// def call(String project, String ImageTag, String hubUser){
    
//     sh """
//      docker rmi ${hubUser}/${project}:${ImageTag}
//      docker rmi ${hubUser}/${project} ${hubUser}/${project}:latest
//     """
// }


def call(String aws_account_id, String region, String ecr_repoName){
    
    sh """
     def previousBuildNumber = env.BUILD_NUMBER.toInteger() - 1
     docker rmi ${ecr_repoName}:latest ${aws_account_id}.dkr.ecr.${region}.amazonaws.com/${ecr_repoName}:${previousBuildNumber}
    """
}