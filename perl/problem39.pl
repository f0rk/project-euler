#!/usr/bin/perl
#solution: 840
use strict;
use warnings;

print euler_problem_39(), "\n";

sub euler_problem_39 {
    my %sols = ();
    for(my $n = 0; $n < sqrt(1000); ++$n) {
        for(my $m = $n + 1; $m < sqrt(1000); ++$m) {
            if(($n % 2 == 0 || $m % 2 == 0) && !($n % 2 == 0 && $m % 2 == 0) && gcf($n,$m) == 1) {
                my $p = ($m**2-$n**2) + (2*$m*$n) + ($m**2+$n**2);
                for(my $x = 1; $x < 1000 / $p; ++$x) {
                    $sols{$p*$x}++;
                }
            }
        }
    }
    
    my $max_s = 0;
    my $max_p = 0;
    foreach my $perim (keys %sols) {
        if($sols{$perim} > $max_s) {
            $max_s = $sols{$perim};
            $max_p = $perim;
        }
    }
    
    return $max_p;
}

sub gcf {
    my ($x, $y) = @_;
    ($x, $y) = ($y, $x % $y) while $y;
    return $x;
}
