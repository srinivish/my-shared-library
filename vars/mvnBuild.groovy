def call(String workDIR) {
    dir("${workDIR}")
    echo "Building the application..."
    sh "mvn clean install -DskipTests"
    def jarFile = sh(script: 'find . -name "*.jar" -type f | head -n 1', returnStdout: true).trim()
    echo "Generated JAR file: ${jarFile}"
}