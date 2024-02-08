// dockerImageScan.groovy

def call(String imageName, String imageTag, String userName) {
    // sh """   
    //  trivy image ${userName}/${imageName}:${imageTag} > scan.txt
    //  cat scan.txt
    // """
//sh 'docker build -t '+ userName + '/' + appName + ':' + tag +' .'
    echo "Scanning image ${userName}/${imageName}:${imageTag}"
    sh 'trivy image '+ userName + '/' + imageName + ':' + imageTag + ' > scan.txt'
    sh 'cat scan.txt'
    echo "Trivy Scan completed"

}
