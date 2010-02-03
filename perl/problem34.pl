#!/usr/bin/perl
#solution: 40730
use strict;
use warnings;

print euler_problem_34(), "\n";

sub euler_problem_34 {
    my @facts = (1,1,2,6,24,120,720,5040,40320,362880);
    my $total = 0;
    for(my $i = 3; $i < 10000000; ++$i) {
        my @digits = split(//, $i);
        my $sum = 0;
        foreach my $digit (@digits) {
            $sum += $facts[$digit];
        }
        if($sum == $i) {
            $total += $i;
        }
    }
    return $total;
}
