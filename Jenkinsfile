pipeline {
  agent any
   environment {
          deployStatus = ''
      }
  stages {



     stage("test"){
           steps{
               bat './gradlew test'
               junit 'build/test-results/test/*.xml'
               cucumber buildStatus: 'UNSTABLE',
                               reportTitle: 'My report',
                               fileIncludePattern: 'target/report.json',
                               trendsLimit: 10
           }
         }


      stage("Code Analysis"){
         steps{

           withSonarQubeEnv('sonar') {
                             bat "./gradlew sonar"
                         }
         }

         }



      stage("Code Quality") {
                  steps {
                      waitForQualityGate abortPipeline: true
                  }
              }





stage("Build"){
           steps {
               bat './gradlew build'
               bat './gradlew javadoc'
               archiveArtifacts 'build/libs/*.jar'
            }
 }

 pipeline {
     agent any

     environment {
         deployStatus = ''
     }

     stages {
         stage("Deploy") {
             steps {
                 script {
                     bat './gradlew publish'
                 }
             }
             post {
                 failure {
                     script {
                         deployStatus = 'failure'
                     }
                 }
                 success {
                     script {
                         deployStatus = 'success'
                     }
                 }
             }
         }

         stage("Notification") {
             steps {
                 script {
                     echo "Deployment status: ${deployStatus}"

                     notifyEvents message: deployStatus, token: 'v1vwv5hma4ribtadfrsz3rbhjii-ba6s'
                     mail to: 'km_hathat@esi.dz',
                         subject: "Deployment ${deployStatus}",
                         body: "Deployment status: ${deployStatus}"
                 }
             }
         }
     }
 }














}
}