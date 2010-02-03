#!/usr/bin/perl
#solution: 9183
use strict;
use warnings;
use Math::BigInt lib => 'GMP';

print euler_problem_29(), "\n";

sub euler_problem_29 {
    my %terms = ();
    for($a = 2; $a <= 100; ++$a) {
        for($b = 2; $b <= 100; ++$b) {
            my $x = Math::BigInt->new($a);
            $terms{$x->bpow($b)} = 1;
        }
    }
    
    my @keys = keys %terms;
    return $#keys + 1;
}
