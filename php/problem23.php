<?php
//solution: 4179871
echo eulerProblem23() . "\n";

function eulerProblem23() {
    $arr = range(0,28123);
    for($i = 0; $i < count($arr); ++$i) {
        $is = isAbundant($i);
        if($is > 0) {
            $arr[$i] = $i;
        } else {
            $arr[$i] = 0;
        }
    }
    
    $sum = 0;
    for($i = 1; $i <= 20161; ++$i) {
        if(!isSumOfAbundantNumbers($arr, $i)) {
            echo $i . "\n";
            $sum += $i;
        }
    }
    return $sum;
}

function isSumOfAbundantNumbers($arr, $num) {
    if($num > 48 && $num % 2 == 0) {
        return 1;
    }
    
    for($i = 2; $i < count($arr); ++$i) {
        if($arr[$i] == 0) {
            continue;
        }
        $diff = $num - $arr[$i];
        if($diff < 0 || $diff > count($arr)) {
            return 0;
        }
        
        if($arr[$diff] != 0) {
            return 1;
        }
    }
    
    return 0;
}

function sumOfProperDivisors($num) {
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

function isAbundant($num) {
    $sum = sumOfProperDivisors($num);
    if($sum > $num) {
        return $sum;
    }
    
    return 0;
}

?>
