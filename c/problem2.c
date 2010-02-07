#include <stdio.h>
//solution: 4613732

int euler_problem_2() {
    int f1 = 1, f2 = 2, sum = 0, t;
    while(f2 < 4000000) {
        if(f2 % 2 == 0) {
            sum += f2;
        }
        t = f2;
        f2 += f1;
        f1 = t;
    }
    return sum;
}

int main() {
    printf("%d\n", euler_problem_2());
    return 0;
}

