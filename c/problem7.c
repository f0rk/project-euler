#include <stdio.h>
#include <math.h>
//solution: 104743

int is_prime(int);
int slow_prime(int);

int euler_problem_7() {
    int i, count = 1;
    for(i = 3;; i += 2) {
        if(is_prime(i)) {
            ++count;
        }
        if(count == 10001) {
            return i;
        }
    }
}

int main() {
    printf("%d\n", euler_problem_7());
    return 0;
}

int is_prime(int n) {
    int i;

    if(n < 99) {
        return slow_prime(n);
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
        return 0;
    }
    
    for(i = 3; i <= sqrt(n); i += 2) {
        if(n % i == 0) {
            return 0;
        }
    }
    
    return 1;
}

int slow_prime(int n) {
    int i;
    if(n == 0) { return 0; }
    if(n == 1) { return 0; }
    if(n == 2) { return 1; }
    if(n % 2 == 0) { return 0; }
    for(i = 2; i <= sqrt(n); ++i) {
        if(n % i == 0) {
            return 0;
        }
    }
    return 1;
}
