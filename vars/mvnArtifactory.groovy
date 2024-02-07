def call(String jarName, String artifactoryPublicIP) {

// workind code. Need to use JFrog credentials from maven    
    echo "JFrog Artifactory uploadJarToArtifactory $jarName and IP  $artifactoryPublicIP"
    sh 'curl -X PUT -u admin -p Password123456789! -T ' + jarName +' ' +  artifactoryPublicIP

    def user = "admin"
    def password = "Password123456789!"
    sh 'curl -X PUT -u' + user + ':' + password + ' -T ' + jarName +' ' +  artifactoryPublicIP


// use JFrog credentials to upload jar to artifactory

    withCredentials([usernamePassword(
            credentialsId: "jfrog",
            usernameVariable: "USER",
            passwordVariable: "PASS"
    )]) {
        echo "JFrog Credentials $USER and $PASS"
        sh 'curl -X PUT -u' + USER + ':' + PASS + ' -T ' + jarName +' ' +  artifactoryPublicIP
    }
}