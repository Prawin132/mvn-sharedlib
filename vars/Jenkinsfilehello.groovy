pipeline {
    agent any

    environment {
        FIRST_NAME = 'Praveen'
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
