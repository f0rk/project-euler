#!/usr/bin/perl
#solution: 443839
use strict;
use warnings;

print euler_problem_30(), "\n";

sub euler_problem_30 {
    my @good = ();
    my $sum = 0;
    for(my $i = 2; $i < 199999; ++$i) {
        my @digits = split(//, $i);
        my $is = 0;
        foreach my $digit (@digits) {
            $is += $digit**5;
        }
        if($is == $i) {
            $sum += $i;
        }
    }
    return $sum;
}
