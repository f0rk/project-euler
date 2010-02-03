#!/usr/bin/perl
#solution: 7652413
use strict;
use warnings;

print euler_problem_41(), "\n";

sub euler_problem_41 {
    my $max = 0;
    for(my $i = 2; $i < 10; ++$i) {
        for(my $j = 0; $j <= factorial($i); ++$j) {
            my $num = join('',@{permutation($j,[1..$i])});
            if($num > $max && is_prime($num)) {
                $max = $num; 
            }
        }
    }
    return $max;
}

sub factorial {
    my $n = shift;
    if($n == 2) {
        return 2;
    }
    
    return $n * factorial($n-1);
}

sub permutation {
    my ($pos, $seq) = @_;
    my $n = $#{$seq} + 1; my $factorial = 1;
    for(my $i = 2; $i < $n; ++$i) {
        $factorial *= $i;
    }

    for(my $i = 0; $i < $n - 1; ++$i) {
        my $ti = ($pos / $factorial) % ($n - $i);
        my $ts = $seq->[$i + $ti];
        for(my $j = $i + $ti; $j > $i; --$j) {
            $seq->[$j] = $seq->[$j - 1];
        }
        $seq->[$i] = $ts;
        $factorial = $factorial / ($n - ($i + 1));
    }
    return $seq;
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
