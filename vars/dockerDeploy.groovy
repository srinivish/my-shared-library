// Deploy provided container in docker
def call(String containerName, String dockerUser, String tag)
{

// def containerName = "my-java-app"
//                     echo "container name inside Docker Deploy Statge: $containerName"
//                     // Check if container is running
//                     def isRunning = sh(script: "docker inspect -f '{{.State.Running}}' $containerName", returnStatus: true) == 0
//                     if (isRunning){
//                         // Container is running, stop and remove it
//                         sh "docker stop $containerName"
//                         sh "docker rm -f $containerName"
//                     }
//                 // Deploy container with new build
//                 sh "docker run --name $params.ImageName -d $params.DockerHubUser/$params.ImageName:$params.ImageTag"
//                 echo "created new container: $containerName with image: $params.DockerHubUser/$params.ImageName:$params.ImageTag"

// check if container is running
def isRunning = sh(script: "docker inspect -f '{{.State.Running}}' $containerName", returnStatus: true) == 0
if (isRunning){
// Container is running, stop and remove it
  sh "docker stop $containerName"
  sh "docker rm -f $containerName"
}
// Deploy container with new build
sh "docker run --name $containerName -d $dockerUser/$containerName:$tag"
echo "created new container: $containerName with image: $dockerUser/$containerName:$tag"
}
