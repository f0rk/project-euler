<?php
//solution: 4613732
echo eulerProblem2() . "\n";

function eulerProblem2() {
    $f1 = 1; $f2 = 2; $acc = 0;
    while(1) {
        if($f1 % 2 == 0) { $acc += $f1; }
        if($f2 % 2 == 0) { $acc += $f2; }
        
        $t = $f2;
        $f1 = $f1 + $f2;
        $f2 = $t + $f1;
        
        if($f1 >= 4000000 || $f2 >= 4000000) { return $acc; }
        
    }
}

?>
