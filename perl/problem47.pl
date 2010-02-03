#!/usr/bin/perl
#solution: 134043
use strict;
use warnings;

print euler_problem_47(), "\n";

sub euler_problem_47 {
    my @primes = (2);
    my %phash = (2 => 1);
    for(my $i = 0; $i < 1000000; ++$i) {
        if(is_prime($i)) {
            push(@primes, $i);
            $phash{$i} = 1;
        }
    }
    
    for(my $i = 3;; ++$i) {
        if(num_prime_factors($i, \@primes, \%phash) == 4) {
            if(num_prime_factors($i+1, \@primes, \%phash) == 4) {
                if(num_prime_factors($i+2, \@primes, \%phash) == 4) {
                    if(num_prime_factors($i+3, \@primes, \%phash) == 4) {
                        return $i;
                    }
                }
            }
        }
    }
}

sub num_prime_factors {
    my ($num, $primes, $phash) = @_;
    if(defined($phash->{$num})) { return 1; }
    my $count = 0;
    for(my $i = 0; $num > 1; ++$i) {
        if($num % $primes->[$i] == 0) {
            $num /= $primes->[$i];
            ++$count;
        }
        while($num % $primes->[$i] == 0) {
            $num /= $primes->[$i];
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
