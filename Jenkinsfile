pipeline {
    agent any

    environment {
        REPO_DIR = "${env.WORKSPACE}"
    }

    stages {
        stage('Run tarea') {
            steps {
                echo "Hola desde el pipeline!"
            }
        }

        stage('Guardar copia del Jenkinsfile') {
            steps {
                script {
                    def pipelineText = sh(script: "git show HEAD:Jenkinsfile", returnStdout: true).trim()
                    def destino = "${env.REPO_DIR}/jenkins/pipelines/Jenkinsfile-${env.BUILD_NUMBER}.groovy"
                    writeFile file: destino, text: pipelineText
                }
            }
        }

        stage('Hacer commit y push') {
            steps {
                dir("${env.REPO_DIR}") {
                    sh """
                        git config user.email "pablo@example.com"
                        git config user.name "Pablo DevOps"
                        git add jenkins/pipelines/Jenkinsfile-${BUILD_NUMBER}.groovy
                        git commit -m "Backup automático del Jenkinsfile (${BUILD_NUMBER})" || echo "Nada que commitear"
                        git push origin main
                    """
                }
            }
        }
    }
}
