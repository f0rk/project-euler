#include <iostream>
using namespace std;
//solution: 31875000

int eulerProblem9() {
    for(int i = 1;; ++i) {
        for(int j = i+1; j+i < 1000; ++j) {
            int k = 1000 - j - i;
            if(k*k == j*j + i*i) {
                return i*j*k;
            }
        }
    }
}

int main() {
    cout << eulerProblem9() << endl;
    return 0;
}
