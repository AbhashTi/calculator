pipeline {
    agent any

    stages {

        stage('Stage 1: Git Clone') {
            steps {
                checkout scm
            }
        }

        stage('Stage 2: Maven Build') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Stage 3: Build Docker Image') {
            steps {
                script {
                    docker_image = docker.build("abhashti/calculator:latest")
                }
            }
        }
    }
}

