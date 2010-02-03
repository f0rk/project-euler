#!/usr/bin/perl
#solution: 872187
use strict;
use warnings;

print euler_problem_36(), "\n";

sub euler_problem_36 {
    my $sum = 0;
    for(my $i = 0; $i < 1000000; ++$i) {
        if(is_palindrome($i) && is_palindrome(sprintf("%b",$i))) {
            $sum += $i;
        }
    }
    return $sum;
}

sub is_palindrome {
    my $str = shift;
    my $rev = reverse($str);
    return $str eq $rev;
}
