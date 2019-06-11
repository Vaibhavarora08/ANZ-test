pipeline {
    agent any
    parameters {
        string(name: 'profile', defaultValue: 'Version application', description: 'profile Name for build Maven Project')
        string(name: 'gitProjectRepo', defaultValue: 'https://github.com/Vaibhavarora08/ANZ-test.git', description: 'Project  repo')
		string(name: 'BRANCH_NAME' , defaultValue: 'master' , description:'project branch')
        
           }

    stages {
        stage ('clean workspace'){
            steps {
                deleteDir()
            }
        }
        stage ('git clone Project'){
            steps {
                git 'https://github.com/Vaibhavarora08/ANZ-test.git'
            }
        }
        stage ('maven build with testing'){
            steps {
                script {
                    sh 'mvn clean install'
                    def pom = readMavenPom file:'pom.xml'
                    print pom.version
                    env.version = pom.version
                        // execute the unit testing and collect the reports
                        junit '**//*target/surefire-reports/TEST-*.xml'
                        archive 'target*//*.jar'
                    } 
                }
            }
        stage('docker build and deploy'){
            steps{
                    dir("devops/Docker/${params.profile}"){
                    script{
                    def dockerImageName = "${params.profile}".toLowerCase()
                    sh "docker login -u admin -p admin123 ${dockerRepoUrl}"
                    docker.build("${dockerImageName}:v_${BUILD_NUMBER}","-f ${params.profile}-Dockerfile .").push()
					docker.image(${dockerImageName}).run('-p 8761:8761 --name version')
                }
            }
            }
        }
		
		
		
	def getVersion() {
    def gitCommit = sh(returnStdout: true, script: 'git rev-parse HEAD').trim()
    def versionNumber;
    if (gitCommit == null) {
        versionNumber = env.BUILD_NUMBER;
    } else {
        versionNumber = gitCommit.take(8);
    }
    print 'build  versions...'
    print versionNumber
    return versionNumber
}
    
    post {
        always {
            archive "${params.entryPointPath}/target/*.jar"
            //deleteDir() /* clean up our workspace */
        }

        
