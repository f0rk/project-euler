#include <stdio.h>
#include <stdlib.h>
#include <string.h>
//solution: 906609

int is_palindrome(char*);

int euler_problem_4() {
    int i, j, k, max = 0;
    char* str = (char*)malloc(sizeof(char)*20);
    for(i = 100; i < 1000; ++i) {
        for(j = 100; j < 1000; ++j) {
            k = i*j;
            sprintf(str, "%d", k);
            if(is_palindrome(str) && k > max) {
                max = k;
            }
        }
    }
    return max;
}

int main() {
    printf("%d\n", euler_problem_4());
    return 0;
}

int is_palindrome(char* str) {
    int low = 0, high = strlen(str) - 1;
    while(low < high) {
        if(str[low] != str[high]) {
            return 0;
        }
        ++low; --high;
    }
    return 1;
}
