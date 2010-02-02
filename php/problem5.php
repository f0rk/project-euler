<?php
//solution: 232792560
echo eulerProblem5() . "\n";

function eulerProblem5() {
    $a = 2520;
    while(1) {
        if($a % 11 == 0
        && $a % 12 == 0
        && $a % 13 == 0
        && $a % 14 == 0
        && $a % 15 == 0
        && $a % 16 == 0
        && $a % 17 == 0
        && $a % 18 == 0
        && $a % 19 == 0
        && $a % 20 == 0) {
            return $a;
        }
        ++$a;
    }
}

?>
