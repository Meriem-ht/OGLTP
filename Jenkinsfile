pipeline {
  agent any
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


 stage("Deploy"){
           steps {
               bat './gradlew publish'

           }
           }

stage("notification") {
    steps {
      bat 'ls'
    }
    post {
        failure {
            notifyEvents message: 'Failure', token: 'v1vwv5hma4ribtadfrsz3rbhjii-ba6s'
            mail to: 'km_hathat@esi.dz',
                 subject: "Failure",
                 body: "Something went wrong "
        }
        success {
            notifyEvents message: 'Success ', token: 'v1vwv5hma4ribtadfrsz3rbhjii-ba6s'
            mail to: 'km_hathat@esi.dz',
                 subject: "Success",
                 body: "Deployment successful"
        }
    }
}





}
}