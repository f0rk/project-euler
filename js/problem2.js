//solution: 4613732
print(eulerProblem2());

function eulerProblem2() {
    var sum = 0;
    var fib1 = 1;
    var fib2 = 2;
    while(fib2 < 4000000) {
        if(fib2 % 2 == 0) {
            sum += fib2;
        }
        var t = fib2;
        fib2 += fib1;
        fib1 = t;
    }
    return sum;
}
