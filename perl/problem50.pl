#!/usr/bin/perl
#solution: 997651
use strict;
use warnings;

print euler_problem_50(), "\n";

sub euler_problem_50 {
    my @primes = (2);
    my %phash = (2 => 1);
    for(my $i = 3; $i < 1000000; $i += 2) {
        if(is_prime($i)) {
            push(@primes, $i);
            $phash{$i} = 1;
        }
    }
    
    my $sum = 0; my $count = 0;
    my $max_c = 0; my $max_p = 0;
    for(my $i = 0; $i <= $#primes; ++$i) {
        $sum = 0;
        for(my $j = $i; $j <= $#primes && $sum < 1000000; ++$j) {
            $sum += $primes[$j];
            if(is_prime($sum)) {
                if($max_c < $j - $i + 1) {
                    $max_c = $j - $i + 1;
                    $max_p = $sum;
                }
            }
        }
    }
    
    return $max_p;
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
    my $phash = shift;
    
    if(defined($phash->{$n})) {
        return 1;
    }
    
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
