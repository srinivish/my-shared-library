//groovy script to logon to Docker Hub and then Build the Docker Image
def call(String appName) {
    echo "Logging into Docker Hub"
    withCredentials([usernamePassword(
            credentialsId: "docker",
            usernameVariable: "USER",
            passwordVariable: "PASS"
    )]) {
        sh "docker login -u '$USER' -p '$PASS'"
    }

// part 2 of the script
//groovy script to Build the Docker Image
// docker build -t java-app .  
    echo "Build the Docker Image : $env.WORKSPACE"
    sh 'docker build -t '+ $appName +' .'
}