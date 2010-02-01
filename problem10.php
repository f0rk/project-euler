<?php
//solution: 142913828922
echo eulerProblem10() . "\n";

function eulerProblem10() {
    $ll = new LinkedList();
    $ll->push(2);
    $ll->push(3); 
    $ll->push(5); 
    $ll->push(7); 
    $ll->push(11); 
    $ll->push(13); 
    $ll->push(17); 
    $ll->push(19); 
    $ll->push(23); 
    $ll->push(29); 
    $ll->push(31); 
    $ll->push(37); 
    $ll->push(41); 
    $ll->push(43); 
    $ll->push(47); 
    $ll->push(53); 
    $ll->push(59); 
    $ll->push(61); 
    $ll->push(67); 
    $ll->push(71); 
    $ll->push(73); 
    $ll->push(79); 
    $ll->push(83); 
    $ll->push(89); 
    $ll->push(97);
    for($i = 99; $i < 2000000; $i += 2) {
        if($i % 3 == 0
        || $i % 5 == 0
        || $i % 7 == 0
        || $i % 11 == 0
        || $i % 13 == 0
        || $i % 17 == 0) {
            
        } else {
            $ll->push($i);
        }
    }
    
    for($pointer = $ll->head->next; $pointer != NULL && pow($pointer->data, 2) < 2000000; $pointer = $pointer->next) {
        $pn = $pointer->data;
        for($cur = $pointer->next; $cur != NULL;) {
            $cn = $cur->data;
            if($cn % $pn == 0) {
                $next = $cur->next;
                $ll->remove($cur);
                $cur = $next;
            } else {
                $cur = $cur->next;
            }
        }
    }
    
    $sum = 0;
    for($cur = $ll->head; $cur != NULL; $cur = $cur->next) {
        $sum += $cur->data;
    }
    
    return $sum;
}

class Node {
    public $data;
    public $next;
    public $prev;
    
    function __construct($data) {
        $this->data = $data;
        $this->next = NULL;
        $this->prev = NULL;
    }
}

class LinkedList {
    
    public $head;
    public $tail;
    public $count;
    
    function __construct() {
        $this->head = NULL;
        $this->tail = NULL;
        $this->count = 0;
    }
    
    function push($data) {
        $node = new Node($data);
        if($this->tail == NULL) {
            $this->head = $node;
            $this->tail = $node;
        } else {
            $this->tail->next = $node;
            $node->prev = $this->tail;
            $this->tail = $node;
        }
        $this->count++;
    }
    
    function remove($node) {
        if($node->prev != NULL) {
            $node->prev->next = $node->next;
        } else { //the head
            $this->head = $node->next;
            if($node->next == NULL) {
                $this->tail = NULL;
            } else {
                $node->next->prev = NULL;
            }
        }
        
        if($node->next != NULL) {
             $node->next->prev = $node->prev;
        } else { //the tail
            $this->tail = $node->prev;
            if($node->prev == NULL) {
                $this->head = NULL;
            } else {
                $node->prev->next = NULL;
            }
        }
        
        $node->next = NULL;
        $node->prev = NULL;
        
        $this->count--;
    }
    
}

?>
