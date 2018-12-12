// vars/ciRelease.groovy

def call(Map args) {
    if (args.action == 'check') {
        return check()
    }
    error 'ciRelease has been called without valid arguments'
}

def check() {
    result = sh (script: "git log -1 | grep '\\[Release\\]'", returnStatus: true) 
    return result == 0
}