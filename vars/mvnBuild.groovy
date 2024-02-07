def call(Map stageParams) {
    echo "Building the application..."
    sh "mvn clean install -DskipTests"
    def jars = findFiles(glob: '**/target/*.jar')
        if (jars != null && !jars.isEmpty()) {
            def jarFile = jars[0]
            echo "Generated JAR file: ${jarFile}"
            } else {
                    error "No JAR file found in target directory"
                }
}