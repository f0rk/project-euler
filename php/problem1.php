<?php
//solution: 233168
echo eulerProblem1() . "\n";

function eulerProblem1() {
    $acc = 0;
    for($i = 0; $i < 1000; ++$i) {
        if($i % 3 == 0 || $i % 5 == 0) {
            $acc += $i;
        }
    }
    
    return $acc;
}

?>
