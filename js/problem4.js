//solution: 906609
print(eulerProblem4());

function eulerProblem4() {
    var max = 0;
    for(var i = 100; i < 1000; ++i) {
        for(var j = 100; j < 1000; ++j) {
            var p = i*j;
            if(isPalindrome(p.toString()) && p > max) {
                max = p;
            }
        }
    }
    return max;
}

function isPalindrome(str) {
    var rev = strReverse(str);
    return str == rev;
}

function strReverse(str) {
    var ret = "";
    for(var i = str.length - 1; i >= 0; --i) {
        ret += str.charAt(i);
    }
    return ret;
}
