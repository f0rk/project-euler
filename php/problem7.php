<?php
//solution: 104743
echo eulerProblem7() . "\n";

function eulerProblem7() {
    $count = 25;
    for($i = 99;; $i += 2) {
        if(isPrime($i)) {
            $count++;
        }
        if($count == 10001) {
            return $i;
        }
    }
}

function isPrime($n) {
    if($n % 2 == 0
    || $n % 3 == 0
    || $n % 5 == 0
    || $n % 7 == 0
    || $n % 11 == 0
    || $n % 13 == 0
    || $n % 17 == 0
    || $n % 19 == 0
    || $n % 23 == 0
    || $n % 29 == 0
    || $n % 31 == 0
    || $n % 37 == 0
    || $n % 41 == 0
    || $n % 43 == 0
    || $n % 47 == 0
    || $n % 53 == 0
    || $n % 59 == 0
    || $n % 61 == 0
    || $n % 67 == 0
    || $n % 71 == 0
    || $n % 73 == 0
    || $n % 79 == 0
    || $n % 83 == 0
    || $n % 89 == 0
    || $n % 97 == 0) {
        return 0;
    }
    
    for($i = 3; $i < $n; $i += 2) {
        if($n % $i == 0) {
            return 0;
        }
    }
    
    return 1;
}

?>
