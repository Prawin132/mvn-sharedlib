def call(Map pipelineParams) {
    pipeline {
        agent any

        tools {
            maven 'maven-3.6.0'
        }

        stages {
            stage('build') {
                steps {
                    sh 'mvn -B -DskipTests clean package'
                }
            }

            stage('test') {
                steps {
                    parallel (
                    "unit tests": { sh 'mvn test' },
                    "integration tests": { sh 'mvn integration-test' }
                )
                }
            }
        }
    }
}

