def call(body) {
    
        String FIRST_NAME = 'Praveen'
        if(pipeline_params.FIRST_NAME){
             FIRST_NAME=pipeline_params.FIRST_NAME
        }
    pipeline {
    agent any
    environment {
        
        LAST_NAME = 'K'
    }

    stages {
        stage('print') {
            steps {
                echo "Hello ${env.FIRST_NAME} ${env.LAST_NAME}"
            }
        }
    }
}
}
