<?php
//solution: 31875000
echo eulerProblem9() . "\n";

function eulerProblem9() {
   for($a = 1; $a < 1000; $a++) {
       for($b = 1; $b < 1000; $b++) {
           if(1000 - ($a + $b) < 1) {
               continue;
           }
           
           $c = 1000 - ($a + $b);
           
           if($a * $a + $b * $b == $c * $c) {
               return $a * $b * $c;
           }
       }
   }
   
   return -1; //should never happen
}

?>
