<?php
//solution: 137846528820
echo eulerProblem15() . "\n";

function eulerProblem15() {
    return combinations(40, 20);
}

function combinations($n, $k) {
    return factorial($n) / (factorial($k) * factorial($n - $k));
}

function factorial($num) {
    $fact = 1;
    for($i = 2; $i <= $num; ++$i) {
        $fact *= $i;
    }
    return $fact;
}

?>
