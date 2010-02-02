#!/usr/bin/perl
#solution: -59231
use strict;
use warnings;

print euler_problem_27(), "\n";

sub euler_problem_27 {
    my %primes = ();
    $primes{2} = 1;
    $primes{3} = 1;
    $primes{5} = 1;
    $primes{7} = 1;
    $primes{11} = 1;
    $primes{13} = 1;
    $primes{17} = 1;
    $primes{19} = 1;
    $primes{23} = 1;
    $primes{29} = 1;
    $primes{31} = 1;
    $primes{37} = 1;
    $primes{41} = 1;
    $primes{43} = 1;
    $primes{47} = 1;
    $primes{53} = 1;
    $primes{59} = 1;
    $primes{61} = 1;
    $primes{67} = 1;
    $primes{71} = 1;
    $primes{73} = 1;
    $primes{79} = 1;
    $primes{83} = 1;
    $primes{89} = 1;
    $primes{97} = 1;
    my @bs = (2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97);
    for(my $i = 3; $i < 20000; $i += 2) {
        if(is_prime($i)) {
            $primes{$i} = 1;
            if($i < 1000) {
                push(@bs, $i);
            }
        }
    }
    
    my $ret = 0; my $max = 0;
    for(my $a = -1000; $a <= 1000; ++$a) {
        foreach my $b (@bs) {
            my $len = longest_prime_sequence($a, $b, \%primes);
            if($len > $max) {
                $max = $len;
                $ret = $a*$b;
            }
        }
    }
    print $max, "\n";
    return $ret;
}

sub longest_prime_sequence {
    my ($a, $b, $primes) =  @_;
    my $count = 0;
    for(my $n = 0; ; ++$n) {
        my $val = $n**2 + $a * $n + $b;
        if(defined($primes->{$val})) { #got a prime
            ++$count;
        } else { #prime might be too big, or might not be prime
            if($val > 10000) { #check it
                if(is_prime($val)) {
                    ++$count;
                } else {
                    return $count;
                }
            } else { #not prime
                return $count;
            }
        }
    }
    return -1;
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
    
    for(my $i = 3; $i < $n; $i += 2) {
        if($n % $i == 0) {
            return 0;
        }
    }
    
    return 1;
}
