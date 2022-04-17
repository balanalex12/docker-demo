pipeline {
    agent any

    stages {
        stage('Clean and clone repository') {
            steps {
                bat "docker stop demo-container && docker rm demo-container || exit 0;"
                // Get some code from a GitHub repository
                git branch: 'main', url: 'https://github.com/balanalex12/docker-demo.git'

            }
        }

        stage("Build"){
            steps{
                  bat "./gradlew clean build"
                  bat "docker build -t docker-demo ."
            }
        }

        stage("Deploy"){
            steps{
                bat "docker run -d --network=host -p 8080:8080 --name demo-container docker-demo"
            }
        }
    }
}
