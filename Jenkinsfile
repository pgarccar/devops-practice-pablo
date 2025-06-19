pipeline {
    agent any

    environment {
        GIT_REPO = 'git@github.com:pgarccar/devops-practice-pablo.git'
    }

    stages {
        stage('Run tarea') {
            steps {
                echo 'Hola desde el pipeline!'
            }
        }

        stage('Guardar copia del Jenkinsfile') {
            steps {
                script {
                    def jenkinsfileContent = sh(
                        script: "git show HEAD:Jenkinsfile",
                        returnStdout: true
                    ).trim()

                    writeFile file: "jenkins/pipelines/Jenkinsfile-${env.BUILD_NUMBER}.groovy", text: jenkinsfileContent
                }
            }
        }

        stage('Hacer commit y push') {
            steps {
                dir("${env.WORKSPACE}") {
                    sh 'git config user.email "pablo@example.com"'
                    sh 'git config user.name "Pablo DevOps"'
                    sh 'git checkout main'
                    sh 'git add jenkins/pipelines/Jenkinsfile-${BUILD_NUMBER}.groovy'
                    sh 'git commit -m "Backup automático del Jenkinsfile (${BUILD_NUMBER})" || echo "Nada que commitear"'
                    sh 'git push origin main'
                }
            }
        }
    }
}
