def call(body) {
    def pipeline_params = [:]
    body.delegate = pipeline_params
    body()
    
    String FIRST_NAME = pipeline_params.FIRST_NAME
    String LAST_NAME = pipeline_params.LAST_NAME
    if(pipeline_params.FIRST_NAME){
        FIRST_NAME = "Ppraveen"
        LAST_NAME = "Kkk"
    }
    
    
    
     
    env.FIRST_NAME = FIRST_NAME
    env.LAST_NAME = LAST_NAME
    println "FIRST_NAME: ${env.FIRST_NAME}"
    println "LAST_NAME: ${env.LAST_NAME}"
   
    
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
