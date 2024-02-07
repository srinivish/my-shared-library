def call(String jarName, String artifactoryPublicIP) {
    echo 'JFrog Artifactory uploadJarToArtifactory ' + ${jarName} + ' ' + ${artifactoryPublicIP}
    sh 'curl -X PUT -u admin -p password -T' + ${jarName} + 'http://' + ${artifactoryPublicIP}+':8082/artifactory/example-repo-local/' 
}