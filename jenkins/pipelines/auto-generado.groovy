                
pipeline{
    agent any
    stages{
        stage('Generado'){
            steps{
                echo 'Este pipeline ha sido guardado como archivo desde Jenkins'
            }
        }
    }
}
