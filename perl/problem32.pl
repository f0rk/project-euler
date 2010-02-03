#!/usr/bin/perl
#solution: 45228
use strict;
use warnings;

print euler_problem_32(), "\n";

sub euler_problem_32 {
    my $sum = 0;
    my %found = ();
    for(my $i = 10000; $i > 4000; --$i) {
        my $ret = factor_pairs($i);
        for(my $j = 0; $j <= $#{$ret}; ++$j) {
            my $str = $i.$ret->[$j]->[0].$ret->[$j]->[1];
            if(length($str) == 9) {
                $str =~ s/1//;
                $str =~ s/2//;
                $str =~ s/3//;
                $str =~ s/4//;
                $str =~ s/5//;
                $str =~ s/6//;
                $str =~ s/7//;
                $str =~ s/8//;
                $str =~ s/9//;
                if($str eq "" && !defined($found{$i})) {
                    $sum += $i;
                    $found{$i} = 1;
                }
            }
        }
    }
    return $sum;
}

sub factor_pairs {
    my $num = shift;
    my $ret = [];
    for(my $i = 2; $i <= sqrt($num); ++$i) {
        if($num % $i == 0) {
            push(@$ret, [$i,$num/$i]);
        }
    }
    return $ret;
}
