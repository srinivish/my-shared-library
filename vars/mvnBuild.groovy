def call() {
    echo "Building the application..."
    sh "mvn clean install -DskipTests"
}