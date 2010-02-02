<?php
//solution: 6857
echo eulerProblem3() . "\n";

function eulerProblem3() {
    $max = 1;
    $limit = 600851475143;
    for($factor = 2; $factor <= $limit; $factor = nextPrime($factor)) {
        if($limit % $factor == 0) {
            $max = $factor;
            $limit = $limit / $factor;
        }
    }
    return $max;
}

function nextPrime($n) {
    $n = $n + 1;
    while($n++) {
        if(isPrime($n)) {
            return $n;
        }
    }
}

function isPrime($n) {
    for($i = 2; $i < $n; ++$i) {
        if($n % $i == 0) {
            return 0;
        }
    }
    return 1;
}

?>
