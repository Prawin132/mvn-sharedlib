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

            stage('copy') {
                steps {
                    sh 'mv target/*.war target/variable-name.war'
                }
            }
        }
    }
}

