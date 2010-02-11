#include <stdio.h>
#include <gmp.h>
#include <math.h>
#include <stdlib.h>
#include <string.h>
//solution: 55374

void p(long, mpz_t*, mpz_t);

long euler_problem_78() {
    long pcsize = 200000;
    mpz_t* pcache = (mpz_t*)malloc(sizeof(mpz_t)*pcsize);
    for(long i = 0; i < pcsize; ++i) {
        mpz_init(pcache[i]);
    }
    mpz_set_si(pcache[0], 1);
    mpz_set_si(pcache[1], 1);
    
    mpz_t pr;
    mpz_init(pr);
    mpz_t md;
    mpz_init(md);
    for(long i = 0; i < 100000; ++i) {
        p(i, pcache, pr);
        mpz_mod_ui(md, pr, 1000000);
        if(mpz_cmp_ui(md, 0) == 0) {
            return i;
        }
    }
    return 0;
}

void p(long n, mpz_t* pcache, mpz_t result) {
    if(mpz_cmp_ui(pcache[n], 0) != 0) {
        mpz_set(result, pcache[n]);
        return;
    }
    mpz_t sum;
    mpz_init_set_ui(sum, 0);
    mpz_t pk;
    mpz_init(pk);
    long k = 1, i = 1, j = 1;
    while(n-k >= 0) {
        p(n-k, pcache, pk);
        if(j % 4 == 3 || j % 4 == 0) {
            mpz_sub(sum, sum, pk);
        } else {
            mpz_add(sum, sum, pk);
        }
        i = i < 0 ? i*-1 + 1 : i*-1;
        k = i*(3*i-1)/2;
        ++j;
    }
    mpz_set(pcache[n], sum);
    mpz_set(result, sum);
    mpz_clear(sum);
    mpz_clear(pk);
    return;
}

int main() {
    printf("%d\n", euler_problem_78());
    return 0;
}

