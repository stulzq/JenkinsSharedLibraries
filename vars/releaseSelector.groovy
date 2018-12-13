// vars/releaseSelector.groovy

def call(String pattern) {
    if (pattern == '') {
        error 'releaseSelector has been called without valid arguments'
    }

    result = sh (script: "git diff --name-only $GIT_PREVIOUS_SUCCESSFUL_COMMIT|grep '$pattern'", returnStatus: true) 
    return result == 0
}