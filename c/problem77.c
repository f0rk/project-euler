#include <stdio.h>
#include <math.h>
#include <stdlib.h>
#include <string.h>
long a(long, long*, long*);
long psum(long, long*);
long* pfactors(long, long*);
long is_prime(long);
long slow_prime(long);
//solution: 71

long euler_problem_77() {
    long pcnt = 2000;
    long* primes = (long*)malloc(sizeof(long)*pcnt);
    primes[0] = 2;
    long count = 1;
    for(long i = 3; count < pcnt; i += 2) {
        if(is_prime(i)) {
            primes[count] = i;
            ++count;
        }
    }
    long acount = 10000;
    long* acache = (long*)malloc(sizeof(long)*acount);
    for(long i = 0; i < acount; ++i) {
        acache[i] = 0;
    }
    acache[0] = 1;
    acache[1] = 0;
    
    for(long i = 4;; ++i) {
        if(a(i, primes, acache) > 5000) {
            return i;
        }
    }
}

long a(long n, long* primes, long* acache) {
    if(n == 1) {
        return 0;
    }
    if(acache[n] != 0) {
        return acache[n];
    }
    long sum = 0;
    for(long k = 1; k <= n; ++k) {
        long ps = psum(k, primes);
        long ank = a(n-k, primes, acache);
        sum += ps*ank;
    }
    acache[n] = sum/n;
    return acache[n];
}

long psum(long n, long* primes) {
    long* factors = pfactors(n, primes);
    long sum = 0;
    for(long i = 0; factors[i] != 0; i += 2) {
        sum += factors[i];
    }
    free(factors);
    return sum;
}

long * pfactors(long n, long * primes) {
    if(n < 2) {
        long* arr = (long*)malloc(sizeof(long));
        arr[0] = 0;
        return arr;
    }
    
    if(is_prime(n)) {
        long* arr = (long*)malloc(sizeof(long)*3);
        arr[0] = n; //the factor
        arr[1] = 1; //factor's power
        arr[2] = 0; //end of factors
        return arr;
    }
    
    long* arr = (long*)malloc(sizeof(long)*22);
    long sz = 21; long cur = 0;
    for(long i = 0; primes[i] <= sqrt(n); ++i) {
        if(n % primes[i] == 0) {
            long count = 1;
            n /= primes[i];
            while(n % primes[i] == 0 ) {
                n /= primes[i];
                ++count;
            }
            if(cur == sz - 3) {
                sz = 2*(sz-1)+1;
                long* tar = (long*)malloc(sizeof(long)*sz);
                memcpy(tar, arr, sz-1);
                free(arr);
                arr = tar;
            }
            arr[cur] = primes[i];
            arr[cur+1] = count;
            cur += 2;
        }
    }
    if(n != 1) {
        arr[cur] = n;
        arr[cur+1] = 1;
        cur += 2;
    }
    arr[cur] = 0;
    return arr;
}

long is_prime(long n) {
    long i;

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

long slow_prime(long n) {
    long i;
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

int main() {
    printf("%d\n", euler_problem_77());
    return 0;
}

