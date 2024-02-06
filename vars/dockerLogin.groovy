//groovy script to logon to Docker Hub

def call(String username, String password) {
    // sh "docker login -u ${username} -p ${password}"
    withCredentials([usernamePassword(
            credentialsId: "docker",
            usernameVariable: "USER",
            passwordVariable: "PASS"
    )]) {
        sh "docker login -u '$USER' -p '$PASS'"
    }
}