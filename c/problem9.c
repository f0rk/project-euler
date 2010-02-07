#include <stdio.h>
//solution: 31875000

int euler_problem_9() {
    int i, j, k;
    for(i = 1;; ++i) {
        for(j = i+1; j+i < 1000; ++j) {
            k = 1000 - j - i;
            if(k*k == j*j + i*i) {
                return i*j*k;
            }
        }
    }
}

int main() {
    printf("%d\n", euler_problem_9());
    return 0;
}

