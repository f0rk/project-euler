<?php
//solution: 1074
echo eulerProblem18() . "\n";

function eulerProblem18() {
    $top = buildTree();
    $head = $top; $or = NULL;
    while($head->left != NULL) {
        for($p = $head; $p != NULL; $p = $p->next) {
            $left = $p->left; $right = $p->right;
            
            $nl = new Node($p->data + $left->data);
            $nr = new Node($p->data + $right->data);
            
            $nl->left = $left->left; $nl->right = $left->right;
            $nr->left = $right->left; $nr->right = $right->right;
            
            $nl->next = $nr;
            
            if($or == NULL) {
                $head = $nl;
            } else {
                $or->next = $nl;
            }
            
            $or = $nr;
        }
        $or = NULL;
    }
    
    $max = 0;
    for($cur = $head; $cur != NULL; $cur = $cur->next) {
        if($cur->data > $max) {
            $max = $cur->data;
        }
    }
    
    return $max;
}

function buildTree() {
    $arr = array(array(75),
    array(95,64),
    array(17,47,82),
    array(18,35,87,10),
    array(20,4,82,47,65),
    array(19,1,23,75,3,34),
    array(88,2,77,73,7,63,67),
    array(99,65,4,28,6,16,70,92),
    array(41,41,26,56,83,40,80,70,33),
    array(41,48,72,33,47,32,37,16,94,29),
    array(53,71,44,65,25,43,91,52,97,51,14),
    array(70,11,33,28,77,73,17,78,39,68,17,57),
    array(91,71,52,38,17,14,91,43,58,50,27,29,48),
    array(63,66,4,68,89,53,67,30,73,16,69,87,40,31),
    array(4,62,98,27,23,9,70,98,73,93,38,53,60,4,23));
    
    for($i = 0; $i < count($arr); ++$i) {
        for($j = 0; $j < count($arr[$i]); ++$j) {
            $arr[$i][$j] = new Node($arr[$i][$j]);
        }
    }
    
    for($i = 0; $i < count($arr) - 1; ++$i) {
        for($j = 0; $j < count($arr[$i]); ++$j) {
            $arr[$i][$j]->left = $arr[$i+1][$j];
            $arr[$i][$j]->right = $arr[$i+1][$j+1];
        }
    }
    
    for($i = 1; $i < count($arr); ++$i) {
        for($j = 0; $j < count($arr[$i]) - 1; ++$j) {
            $arr[$i][$j]->next = $arr[$i][$j+1];
        }
    }
    
    return $arr[0][0];
}

class Node {
    public $next;
    public $left;
    public $right;
    public $data;
    
    function __construct($val) {
        $this->data = $val;
        $this->next = NULL;
        $this->left = NULL;
        $this->right = NULL;
    }
}

?>
