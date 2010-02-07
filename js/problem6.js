//solution: 25164150
print(eulerProblem6());

function eulerProblem6() {
    var sumos = 0;
    for(var i = 1; i <= 100; ++i) {
        sumos += i*i;
    }

    var squofs = 0;
    for(var i = 1; i <= 100; ++i) {
        squofs += i;
    }
    squofs *= squofs;

    return squofs - sumos;
}
