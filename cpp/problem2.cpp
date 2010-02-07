#include <iostream>
using namespace std;
//solution: 4613732

int eulerProblem2() {
    int f1 = 1;
    int f2 = 2;
    int sum = 0;
    while(f2 < 4000000) {
        if(f2 % 2 == 0) {
            sum += f2;
        }
        int t = f2;
        f2 += f1;
        f1 = t;
    }
    return sum;
}

int main() {
    cout << eulerProblem2() << endl;
    return 0;
}
