def call() {
    echo 'mvnTest'
    sh 'mvn -Dmaven.test.failure.ignore=true test'
}