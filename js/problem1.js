//solution: 233168
print(eulerProblem1());

function eulerProblem1() {
    var sum = 0;
    for(var i = 0; i < 1000; ++i) {
       if(i % 3 == 0 || i % 5 == 0) {
          sum += i;
       }
    }
    return sum;
}
