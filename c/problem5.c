#include <stdio.h>
//solution: 232792560

int euler_problem_5() {
    int i;
    for(i = 2520;; i += 20) {
        if(i % 11 == 0 && i % 12 == 0
        && i % 13 == 0 && i % 14 == 0
        && i % 15 == 0 && i % 16 == 0
        && i % 17 == 0 && i % 18 == 0
        && i % 19 == 0) {
            return i;
        }
    }
}

int main() {
    printf("%d\n", euler_problem_5());
    return 0;
}

