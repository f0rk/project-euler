<?php
//solution: 21124
echo eulerProblem17() . "\n";

function eulerProblem17() {
    $nums = array();
    $nums[] = "";
    $nums[] = "one";
    $nums[] = "two";
    $nums[] = "three";
    $nums[] = "four";
    $nums[] = "five";
    $nums[] = "six";
    $nums[] = "seven";
    $nums[] = "eight";
    $nums[] = "nine";
    $nums[] = "ten";
    $nums[] = "eleven";
    $nums[] = "twelve";
    $nums[] = "thirteen";
    $nums[] = "fourteen";
    $nums[] = "fifteen";
    $nums[] = "sixteen";
    $nums[] = "seventeen";
    $nums[] = "eighteen";
    $nums[] = "nineteen";
    
    $byten[] = "";
    $byten[] = "ten";
    $byten[] = "twenty";
    $byten[] = "thirty";
    $byten[] = "forty";
    $byten[] = "fifty";
    $byten[] = "sixty";
    $byten[] = "seventy";
    $byten[] = "eighty";
    $byten[] = "ninety";
    
    $sum = 0;
    for($i = 0; $i < count($nums); ++$i) {
        $sum += strlen($nums[$i]);
    }
    
    for($i = 20; $i < 1000; ++$i) {
        $f = intval(floor($i / 100));
        $s = intval(floor(($i - 100 * $f) / 10));
        $t = $i - 100 * $f - 10 * $s;
        
        if($f > 0) {
            $sum += strlen($nums[$f]."hundred");
        }
        
        if($s != 0 || $t != 0) {
            if($f > 0) {
                $sum += strlen("and");
            }
            
            if($s * 10 >= 20) {
                $sum += strlen($byten[$s]);
                $sum += strlen($nums[$t]);
            } else {
                $sum += strlen($nums[$s*10+$t]);
            }
        }
    }
    
    $sum += strlen("onethousand");
    
    return $sum;
}

?>
