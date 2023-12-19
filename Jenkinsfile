pipeline {
  agent any
  stages {
  stage("test"){
  steps{
      bat './gradlew test' // générer les tests unitaires
      archiveArtifacts '' //l'éxécutable de chaque fichier
    }
  }
  stage("Code Analysis")
}

}