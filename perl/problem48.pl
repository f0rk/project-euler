#!/usr/bin/perl
#solution: 9110846700
use strict;
use warnings;
use Math::BigInt;

print euler_problem_48(), "\n";

sub euler_problem_48 {
    my $x = Math::BigInt->new(1);
    for(my $i = 2; $i <= 1000; ++$i) {
        my $y = Math::BigInt->new($i);
        $y->bpow($y);
        $x->badd($y);
    }
    
    return substr($x, -10);
}
