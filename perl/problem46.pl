#!/usr/bin/perl
#solution: 5777
use strict;
use warnings;

print euler_problem_46(), "\n";

sub euler_problem_46 {
    my %primes = (2 => 1);
    my @plist = (2);
    for(my $i = 3; $i < 1000000; ++$i) {
        if(is_prime($i)) {
            $primes{$i} = 1;
            push(@plist, $i);
        }
    }
    
    for(my $i = 3; $i < 1000000; $i += 2) {
        next if(defined($primes{$i}));
        my $found = 0;
        for(my $j = 0; $plist[$j] < $i; ++$j) {
            my $num = sqrt(($i-$plist[$j])/2);
            if($num == int($num)) {
                $found = 1; last;
            }
        }
        if($found == 0) {
            return $i;
        }
    }
    
    return -1;
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
