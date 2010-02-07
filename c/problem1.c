#include <stdio.h>
//solution: 233168

int euler_problem_1() {
    int i, sum = 0;
    for(i = 0; i < 1000; ++i) {
        if(i % 3 == 0 || i % 5 == 0) {
            sum += i;
        }
    }
    return sum;
}

int main() {
    printf("%d\n", euler_problem_1());
    return 0;
}

