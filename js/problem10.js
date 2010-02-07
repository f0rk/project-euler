//solution: 142913828922
print(eulerProblem10());

function eulerProblem10() {
    var sum = 2;
    for(var i = 3; i < 2000000; ++i) {
        if(isPrime(i)) {
            sum += i;
        }
    }
    return sum;
}

function isPrime(n) {
    if(n < 99) {
        return slowPrime(n);
    }
    
    if(n % 2 == 0
    || n % 3 == 0
    || n % 5 == 0
    || n % 7 == 0
    || n % 11 == 0
    || n % 13 == 0
    || n % 17 == 0
    || n % 19 == 0
    || n % 23 == 0
    || n % 29 == 0
    || n % 31 == 0
    || n % 37 == 0
    || n % 41 == 0
    || n % 43 == 0
    || n % 47 == 0
    || n % 53 == 0
    || n % 59 == 0
    || n % 61 == 0
    || n % 67 == 0
    || n % 71 == 0
    || n % 73 == 0
    || n % 79 == 0
    || n % 83 == 0
    || n % 89 == 0
    || n % 97 == 0) {
        return false;
    }
    
    for(var i = 3; i <= Math.sqrt(n); i += 2) {
        if(n % i == 0) {
            return false;
        }
    }
    
    return true;
}

function slowPrime(n) {
    if(n == 0) { return false; }
    if(n == 1) { return false; }
    if(n == 2) { return true; }
    if(n % 2 == 0) { return false; }
    for(var i = 2; i <= Math.sqrt(n); ++i) {
        if(n % i == 0) {
            return false;
        }
    }
    return true;
}
