#!/usr/bin/perl
#solution: 1533776805
use strict;
use warnings;

print euler_problem_44(), "\n";

sub euler_problem_44 {
    my %pent = ();
    for(my $i = 1; $i < 1000000; ++$i) {
        $pent{($i*(3*$i-1)/2)} = 1;
    }
    
    my %hex = ();
    for(my $i = 1; $i < 1000000; ++$i) {
        $hex{($i*(2*$i-1))} = 1;
    }
    
    for(my $i = 286; $i < 1000000; ++$i) {
        if(defined($pent{($i*($i+1)/2)}) && defined($hex{($i*($i+1)/2)})) {
            return $i*($i+1)/2;
        }
    }
    return -1;
}
