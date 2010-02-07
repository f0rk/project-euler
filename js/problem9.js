//solution: 31875000
print(eulerProblem9());

function eulerProblem9() {
    for(var i = 1;; ++i) {
        for(var j = i+1; i+j < 1000; ++j) {
            var k = 1000 - j - i;
            if(k*k == j*j + i*i) {
                return i*j*k;
            }
        }
    }
}
