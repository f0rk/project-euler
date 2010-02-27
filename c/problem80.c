#include <stdio.h>
#include <stdlib.h>
#include <gmp.h>
//solution: 40886

int ifc(char);

int euler_problem_80() {
    mpz_t chk;
    mpz_init(chk);
    mpf_t n;
    mpf_init2(n, 2000);
    mp_exp_t e = 1;
    long sum = 0;
    for(long i = 2; i < 100; ++i) {
        mpz_set_ui(chk, i);
        mpz_sqrt(chk, chk);
        mpz_mul(chk, chk, chk);
        if(mpz_cmp_ui(chk, i) == 0) { continue; }
        mpf_set_ui(n, i);
        mpf_sqrt(n, n);
        char* str = mpf_get_str(0, &e, 10, 0, n);
        int cnt = -1;
        for(int i = 0; i < 100; ++i) {
            sum += ifc(str[i]);
        }
        free(str);
    }
    return sum;
}

int ifc(char c) {
    if(c == '0') { return 0; }
    if(c == '1') { return 1; }
    if(c == '2') { return 2; }
    if(c == '3') { return 3; }
    if(c == '4') { return 4; }
    if(c == '5') { return 5; }
    if(c == '6') { return 6; }
    if(c == '7') { return 7; }
    if(c == '8') { return 8; }
    if(c == '9') { return 9; }
    return 0;
}

int main() {
    printf("%d\n", euler_problem_80());
    return 0;
}

