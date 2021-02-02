
def call(body) {
    def pipeline_params = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = pipeline_params
    body()
    
    String PACKAGE_NAME = "drop"

    if(pipeline_params.PACKAGE_NAME){
        PACKAGE_NAME = pipeline_params.PACKAGE_NAME
    }
    
    
    env.PACKAGE_NAME = PACKAGE_NAME
    println "PACKAGE_NAME: ${env.PACKAGE_NAME}"
   
    
    pipeline {
    agent any

    stages {
        stage('build'){
            steps{
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('copy') {
            steps {
                sh "mv webapp/target/*.war webapp/target/${PACKAGE_NAME}.war'
            }
        }
    }
}
