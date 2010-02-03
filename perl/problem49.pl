#!/usr/bin/perl
#solution: 296962999629
use strict;
use warnings;

print euler_problem_49(), "\n";

sub euler_problem_49 {
    my %phash = (2 => 1);
    for(my $i = 0; $i < 10000; ++$i) {
        if(is_prime($i)) {
            $phash{$i} = 1;
        }
    }
    
    my $fact4 = factorial(4);
    for(my $i = 9999; $i > 7660; --$i) {
        if(is_prime($i,\%phash)) {
            if(is_prime($i-3330,\%phash) && is_prime($i-2*3330,\%phash) && is_permutation($i, $i-3330) && is_permutation($i, $i-2*3330) && $i != 1487) {
                return ($i-2*3330).($i-3330).$i;
            }
        }
    }
}

sub is_permutation {
    my ($i, $n) = @_;
    my $o = $n;
    my @cs = split(//, $i);
    foreach my $c (@cs) {
        if($n eq $c) {
            return 1;
        }
        my $idx = index($n,$c);
        if($idx > -1) {
            $n = substr($n, $idx, 1, "");
        }
    }
    return length($n) == 0;
}

sub factorial {
    my $n = shift;
    if($n == 2) {
        return 2;
    }
    
    return $n * factorial($n-1);
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
