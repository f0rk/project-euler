<?php
//solution: 76576500
echo eulerProblem12() . "\n";

function eulerProblem12() {
    
    $num = 1; $i = 2;
    while(1) {
        $num += $i; ++$i;
        $divisors = 0;
        for($j = 1; $j < sqrt($num); ++$j) {
            if($num % $j == 0) {
                $divisors += 2;
            }
        }
        if($divisors > 500) {
            return $num;
        }
    }
}

?>
