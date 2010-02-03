#!/usr/bin/perl
#solution: 55
use strict;
use warnings;

print euler_problem_35(), "\n";

sub euler_problem_35 {
    my %lookup = ();
    my @primes = ();
    for(my $i = 0; $i < 99; ++$i) {
        if(slow_prime($i)) {
            $lookup{$i} = 1;
            push(@primes, $i);
        }
    }
    
    for(my $i = 99; $i < 1000000; $i += 2) {
        if(is_prime($i)) {
            $lookup{$i} = 1;
            push(@primes, $i);
        }
    }
    
    my $count = 0;
    foreach my $prime (@primes) {
        my $s = $prime;
        if(length($s) == 1) {
            ++$count;
        } else {
            my $break = 0;
            do {
                $s = substr($s, 1, length($s)-1) . substr($s, 0, 1);
                if($s =~ /^0/) {
                    my $os = $s;
                    $s =~ s/^0+//;
                    if(!defined($lookup{$s})) {
                        $break = 1;
                    }
                    $s = $os;
                } else {
                    if(!defined($lookup{$s})) {
                        $break = 1;
                    }
                }
            } while($prime != $s && $break == 0);
            if($break == 0) {
                ++$count;
            }
        }
    }
    
    return $count;
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
