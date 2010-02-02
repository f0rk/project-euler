<?php
//solution: 31626
echo eulerProblem21() . "\n";

function eulerProblem21() {
    $d = range(0,10000);
    $d[0] = 0;
    $d[1] = 0;
    $d[2] = 1;
    for($i = 3; $i < count($d); ++$i) {
        $d[$i] = -1;
    }
    
    for($i = 3; $i < count($d); ++$i) {
        $d[$i] = sumOfFactors($i);
    }
    
    $sum = 0;
    for($i = 3; $i < count($d); ++$i) {
        if(isAmicable($d, $i)) {
            $sum += $i;
        }
    }
    
    return $sum;
}

function sumOfFactors($num) {
    $sum = 1;
    for($i = 2; $i <= sqrt($num); ++$i) {
        if($num % $i == 0) {
            $sum += $i;
            if($num / $i != $i) {
                $sum += $num / $i;
            }
        }
    }
    return $sum;
}

function isAmicable($arr, $i) {
    if($arr[$i] < count($arr)) {
        if($i == $arr[$arr[$i]] && $i != $arr[$i]) {
            return 1;
        }
        
        return 0;
    }
    
    return 0;
}

?>
