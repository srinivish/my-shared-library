def call(Map stageParams){
    echo "inside  def call function. Checkout to ${stageParams.branch}; ${stageParams.repoUrl}"
    checkout([
        $class: 'GitSCM', 
        branches: [[name: "${stageParams.branch}"]], 
        userRemoteConfigs: [[url: "${stageParams.repoUrl}"]]
    ])
}