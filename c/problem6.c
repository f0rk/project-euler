#include <stdio.h>
//solution: 25164150

int euler_problem_6() {
    return (100*(100+1)/2)*(100*(100+1)/2)-100*(100+1)*(2*100+1)/6;
}

int main() {
    printf("%d\n", euler_problem_6());
    return 0;
}

