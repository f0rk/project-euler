<?php
//solution: 25164150
echo eulerProblem6() . "\n";

function eulerProblem6() {
    $square_sum = 0;
    for($i = 1; $i <= 100; $i++) {
        $square_sum += pow($i, 2);
    }
    $sum_squared = 0;
    for($i = 1; $i <= 100; $i++) {
        $sum_squared += $i;
    }
    $sum_squared = pow($sum_squared, 2);
    return $sum_squared - $square_sum;
}

?>
