#!/usr/bin/perl
#solution: 
use strict;
use warnings;

print euler_problem_44(), "\n";

sub euler_problem_44 {
    my %pent = ();
    my @arr = ();
    for(my $i = 1; $i < 10000; ++$i) {
        my $num = $i*(3*$i-1)/2;
        $pent{$num} = 1;
        push(@arr, $num);
    }
    
    my $min_diff = 100000000;
    for(my $i = 1; $i < 5000; ++$i) {
        for(my $j = $i - 1; $j >= 0; --$j) {
            next if $j == $i;
            if(defined($pent{$arr[$i]-$arr[$j]})
            && defined($pent{$arr[$i]+$arr[$j]})) {
                if($arr[$i] - $arr[$j] < $min_diff) {
                    $min_diff = $arr[$i] - $arr[$j];
                }
            }
        }
    }
    return $min_diff;
}
