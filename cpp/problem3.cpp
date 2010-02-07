#include <iostream>
#include <cmath>
using namespace std;
//solution: 6857

bool isPrime(int);
bool slowPrime(int);

int eulerProblem3() {
    long target = 600851475143;
    int max = 0;
    for(int i = 3; i <= sqrt(target); ++i) {
        if(isPrime(i) && target % i == 0) {
            max = i;
        }
    }
    return max;
}

int main() {
    cout << eulerProblem3() << endl;
    return 0;
}

bool isPrime(int n) {
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
    
    for(int i = 3; i <= sqrt(n); i += 2) {
        if(n % i == 0) {
            return false;
        }
    }
    
    return true;
}

bool slowPrime(int n) {
    if(n == 0) { return false; }
    if(n == 1) { return false; }
    if(n == 2) { return true; }
    if(n % 2 == 0) { return false; }
    for(int i = 2; i <= sqrt(n); ++i) {
        if(n % i == 0) {
            return false;
        }
    }
    return true;
}
