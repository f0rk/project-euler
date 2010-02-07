#include <iostream>
using namespace std;
//solution: 25164150

int eulerProblem6() {
    return (100*(100+1)/2)*(100*(100+1)/2)-100*(100+1)*(2*100+1)/6;
}

int main() {
    cout << eulerProblem6() << endl;
    return 0;
}
