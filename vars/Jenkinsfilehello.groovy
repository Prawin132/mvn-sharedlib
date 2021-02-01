def call(body) {
    def helper = new PipelineHelper(this)
    def pipeline_params = [:]
    body.delegate = pipeline_params
    body()
    
    String FIRST_NAME = pipeline_params.FIRST_NAME
    String LAST_NAME = pipeline_params.LAST_NAME
    
    println "FIRST_NAME: ${FIRST_NAME}"
    println "LAST_NAME: ${LAST_NAME}"
    
    pipeline {
    agent any

    stages {
        stage('print') {
            steps {
                echo "Hello ${env.FIRST_NAME} ${env.LAST_NAME}"
            }
        }
    }
}
}
