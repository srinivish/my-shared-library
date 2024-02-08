// Deploy provided container in docker
def call(String dockerUser, String containerName, String tag)
// user, app, tag
{
// Check if container is running
def isRunning = sh(script: "docker inspect -f '{{.State.Running}}' $containerName", returnStatus: true) == 0
if (isRunning){
// Container is running, then stop container and remove
  sh "docker stop $containerName"
  sh "docker rm -f $containerName"
}
// Deploy container with new build
sh "docker run --name $containerName -d $dockerUser/$containerName:$tag"
echo "created new container: $containerName with image: $dockerUser/$containerName:$tag"

// Push new image to dockerhub
// Push docker image to dockerhub, this step is done post deploy to ensure successfull deployment of container
//  sh 'docker push '+ $params.DockerHubUser + '/' + $params.ImageName + ':'+ $params.ImageTag + ' . '
echo "pushing new image: $dockerUser/$containerName:$tag""
sh "docker push $dockerUser/$containerName:$tag"
echo "pushed new image: $dockerUser/$containerName:$tag""
}
