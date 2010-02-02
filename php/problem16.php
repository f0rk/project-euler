<?php
//solution: 1366
echo eulerProblem16() . "\n";

function eulerProblem16() {
    $res = bcpow(2, 1000);
    $sum = 0;
    for($i = 0; $i < strlen($res); ++$i) {
        $sum += $res{$i};
    }
    return $sum;
}

?>
