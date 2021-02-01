def call(Map pipelineParams) {
    pipeline {
    agent any

    environment {
        String FIRST_NAME = pipeline_params.FIRST_NAME != '' ? pipeline_params.FIRST_NAME : 'Praveen'
        //LAST_NAME = 'K'
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
