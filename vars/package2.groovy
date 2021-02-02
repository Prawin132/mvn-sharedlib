def call(body) {
    def pipeline_params = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = pipeline_params
    body()
    
    
    pipeline {
    agent any

    stages {
		stage('prepare') {
            steps {
               script {
                   def props = readProperties file:"/var/lib/jenkins/workspace/${JOB_NAME}@libs/sharedlib/vars/${myprop}";
                      env['PACKAGE_NAME'] = props['WAR_NAME'];

                }
            }
        }
        stage('build'){
            steps{
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('copy') {
            steps {
                sh 'mv webapp/target/*.war webapp/target/${PACKAGE_NAME}.war'
            }
        }
    }
}
}
