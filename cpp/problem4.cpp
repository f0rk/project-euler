#include <iostream>
using namespace std;
//solution: 906609

bool isPalindrome(char*);

int eulerProblem4() {
    int max = 0;
    char* str = (char*)malloc(sizeof(char)*20); //should check the return value
    for(int i = 100; i < 1000; ++i) {
        for(int j = 100; j < 1000; ++j) {
            int p = i*j;
            sprintf(str, "%d", p);
            if(isPalindrome(str) && p > max) {
                max = p;
            }
        }
    }
    return max;
}

int main() {
    cout << eulerProblem4() << endl;
    return 0;
}

bool isPalindrome(char* str) {
    int len = strlen(str);
    int low = 0; int high = len - 1;
    while(low < high) {
        if(str[low] != str[high]) {
            return false;
        }
        ++low; --high;
    }
    return true;
}
