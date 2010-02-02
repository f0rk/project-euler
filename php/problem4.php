<?php
//solution: 906609
echo eulerProblem4() . "\n";

function eulerProblem4() {
    $max = 0;
    for($a = 999; $a >= 100; --$a) {
        for($b = 999; $b >= 100; --$b) {
            $ab = $a * $b;
            if(isPalindrome($ab . "") && $ab > $max) {
                $max = $ab;
            }
        }
    }
    return $max;
}

function isPalindrome($string) {
    $low = 0; $high = strlen($string) - 1;
    while($low < $high) {
        if($string{$low} != $string{$high}) {
            return 0;
        }
        $low++; $high--;
    }
    return 1;
}

?>
