<?php
//solution: 648
echo eulerProblem20() . "\n";

function eulerProblem20() {
    $str = factorial(100);
    
    $sum = 0;
    for($i = 0; $i < strlen($str); ++$i) {
        $sum += $str{$i};
    }
    
    return $sum;
}

function factorial($num) {
    if($num == 1) {
        return 1;
    }
    
    return bcmul($num, factorial($num-1));
}

?>
