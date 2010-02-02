<?php
//solution: 837799
echo eulerProblem14() . "\n";

function eulerProblem14() {
    $arr = range(1, 1000000);
    for($i = 0; $i < count($arr); ++$i) {
        $arr[$i] = 0;
    }
    
    $maxnum = 0;
    $maxsteps = 0;
    for($i = 2; $i < 1000000; ++$i) {
        $num = $i;
        $steps = 0;
        while($num > 1) {
            if($num % 2 == 0) {
                $num /= 2;
            } else {
                $num = 3 * $num + 1;
            }
            if($arr[$num] != 0) {
                $steps += $arr[$num];
                break;
            } else {
                ++$steps;
            }
        }
        $arr[$i] = $steps;
        if($steps > $maxsteps) {
            $maxsteps = $steps;
            $maxnum = $i;
        }
    }
    return $maxnum;
}

?>
