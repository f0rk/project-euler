#!/usr/bin/perl
#solution: 669171001
use strict;
use warnings;

print euler_problem_28(), "\n";

sub euler_problem_28 {
    my $arr = [];
    for(my $i = 0; $i < 1001; ++$i) {
        my $ref = [];
        for(my $j = 0; $j < 1001; ++$j) {
            push(@$ref, 0);
        }
        push(@$arr, $ref);
    }
    
    my $nextx = 1000;
    my $nexty = 0;
    my $direction = "left";
    for(my $i = 1002001; $i > 0; --$i) {
        $arr->[$nexty]->[$nextx] = $i;
        
        if($direction eq "left" && $nextx - 1 >= 0 && $arr->[$nexty]->[$nextx-1] == 0) { #good to go left
            $nextx -= 1;
            next;
        } elsif($direction eq "left") {
            #can't go left, go down
            $direction = "down";
        }
        
        if($direction eq "down" && $nexty + 1 < 1001 && $arr->[$nexty+1]->[$nextx] == 0) { #good to go down
            $nexty += 1;
            next;
        } elsif($direction eq "down") {
            #can't go down, go right
            $direction = "right";
        }
        
        if($direction eq "right" && $nextx + 1 < 1001 && $arr->[$nexty]->[$nextx+1] == 0) { #good to go right
            $nextx += 1;
            next;
        } elsif($direction eq "right") {
            #can't right, go up
            $direction = "up";
        }
        
        if($direction eq "up" && $nexty - 1 > 0 && $arr->[$nexty-1]->[$nextx] == 0) { #good to go up
            $nexty -= 1;
            next;
        } elsif($direction eq "up") {
            #can't go up, go left
            $direction = "left";
            #need to handle change of $nextx here
            $nextx -= 1;
        }
    }
    
    my $sum = 0;
    for(my $i = 0; $i < 1001; ++$i) {
        $sum += $arr->[$i]->[$i];
    }
    
    for(my $i = 1000; $i >= 0; --$i) {
        $sum += $arr->[1000-$i]->[$i];
    }
    
    return $sum - 1;
}
