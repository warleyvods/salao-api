pipeline {
  agent any
  
   triggers {
    pollSCM('* * * * *')
  }
  
  stages {
    stage('Construindo') {
      steps {
        powershell 'mvn clean install -U'
      }
    }
    stage('Testando') {
      steps {
        echo 'Testando com Maven'
        powershell 'mvn test'
      }
    }
    stage('Analisando Codigo') {
      steps {
        echo 'Analisando Qualidade do Codigo no Sonarqube'
        powershell 'mvn sonar:sonar'
      }
    }
    stage('Publicando') {
      steps {
        echo 'Realizando Deploy no Nexus'
        powershell 'mvn clean compile package deploy'
      }
        post {
          success {
            emailNotification('SUCESSO ao Realizar o Deploy')
        }
        failure {
            emailNotification('FALHA ao Realizar o Deploy')
         }
       }
     }
   }
 }

def emailNotification(status) {
  mail(
  to: "warleyvods@gmail.com",
  subject: "${status}",
  body: "Job Name: <b>${env.JOB_NAME}</b> <br>" +
      "Build: <b>${env.BUILD_NUMBER}</b> <br>" +
      "<a href=${env.BUILD_URL}>Check Console Output</a>"
  )
}
