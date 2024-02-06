def call(Map stageParams) {
    echo "Building the application..."
    sh "mvn clean install -DskipTests"
}