#!/usr/bin/perl
#solution: 748317
use strict;
use warnings;

print euler_problem_37(), "\n";

sub euler_problem_37 {
    
    my %lookup = ();
    my $sum = 0;
    my $count = 0;
    $lookup{2} = 1;
    $lookup{3} = 1;
    $lookup{5} = 1;
    $lookup{7} = 1;
    for(my $i = 9;; $i += 2) {
        if(is_prime($i)) {
            $lookup{$i} = 1;
            my $s = $i;
            my $b = 0;
            while(length($s) > 0) {
                if(!defined($lookup{$s})) {
                    $b = 1;
                    last;
                }
                $s = substr($s, 1);
            }
            $s = $i;
            while(length($s) > 0) {
                if(!defined($lookup{$s})) {
                    $b = 1;
                    last;
                }
                $s = substr($s, 0, length($s)-1);
            }
            if($b == 0) {
                $sum += $i;
                ++$count;
                if($count == 11) {
                    return $sum;
                }
            }
        }
    }
}
    
sub slow_prime {
    my $n = shift;
    
    if($n == 0) { return 0; }
    if($n == 1) { return 0; }
    if($n == 2) { return 1; }
    if($n % 2 == 0) { return 0; }
    for(my $i = 2; $i <= sqrt($n); ++$i) {
        if($n % $i == 0) {
            return 0;
        }
    }
    return 1;
}

sub is_prime {
    my $n = shift;
    
    if($n < 99) {
        return slow_prime($n);
    }
    
    if($n % 2 == 0
    || $n % 3 == 0
    || $n % 5 == 0
    || $n % 7 == 0
    || $n % 11 == 0
    || $n % 13 == 0
    || $n % 17 == 0
    || $n % 19 == 0
    || $n % 23 == 0
    || $n % 29 == 0
    || $n % 31 == 0
    || $n % 37 == 0
    || $n % 41 == 0
    || $n % 43 == 0
    || $n % 47 == 0
    || $n % 53 == 0
    || $n % 59 == 0
    || $n % 61 == 0
    || $n % 67 == 0
    || $n % 71 == 0
    || $n % 73 == 0
    || $n % 79 == 0
    || $n % 83 == 0
    || $n % 89 == 0
    || $n % 97 == 0) {
        return 0;
    }
    
    for(my $i = 3; $i <= sqrt($n); $i += 2) {
        if($n % $i == 0) {
            return 0;
        }
    }
    
    return 1;
}
