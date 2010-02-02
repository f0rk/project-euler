<?php
//solution: 4782
echo eulerProblem25() . "\n";

function eulerProblem25() {
    $f1 = 1;
    $f2 = 1;
    $term = 2;
    while(1) {
        $t = bcadd($f1, $f2);
        $f1 = $f2;
        $f2 = $t;
        ++$term;
        
        if(strlen($f2) >= 1000) {
            return $term;
        }
    }
}

?>
