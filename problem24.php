<?php
//solution: 2783915460
echo eulerProblem24() . "\n";

function eulerProblem24() {
    $arr = array("0","1","2","3","4","5","6","7","8","9");
    $seq = permutation(1000000, $arr);
    return implode("", $seq);
}

function permutation($pos, $seq) {
     $n = count($seq); $factorial = 1;
     for($i = 2; $i < $n; ++$i) {
         $factorial *= $i;
     }
     
     for($i = 0; $i < $n - 1; ++$i) {
         
         $ti = (($pos - 1) / $factorial) % ($n - $i);
         $ts = $seq[$i + $ti];
         for($j = $i + $ti; $j > $i; --$j) {
             $seq[$j] = $seq[$j - 1];
         }
         $seq[$i] = $ts;
         $factorial = $factorial / ($n - ($i + 1));
     }
     return $seq;
}


?>
