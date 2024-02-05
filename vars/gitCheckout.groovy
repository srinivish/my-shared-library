def call(Map stageParams){
    echo "Checkout to ${stageParams.branch}"
    checkout([
        $class: 'GitSCM', 
        branches: [[name: "${stageParams.branch}"]], 
        userRemoteConfigs: [[url: "${stageParams.repoUrl}"]]
    ])
}