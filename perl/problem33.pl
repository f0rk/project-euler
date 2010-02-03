#!/usr/bin/perl
#solution: 1800
use strict;
use warnings;

print euler_problem_33(), "\n";

sub euler_problem_33 {
    my $num_prod = 1;
    my $den_prod = 1;
    for(my $n1 = 1; $n1 < 10; ++$n1) {
        for(my $n2 = 1; $n2 < 10; ++$n2) {
            for(my $d1 = 1; $d1 < 10; ++$d1) {
                for(my $d2 = 1; $d2 < 10; ++$d2) {
                    next if(($n1*10+$n2)/($d1*10+$d2) >= 1);
                    if(($n1*10+$n2)*($d1*$d2) == ($d1*10+$d2)*($n1*$n2) && (($n1 == $d1 || $n1 == $d2) || ($n2 == $d1 || $n2 == $d2))) {
                        $num_prod *= ($n1*10+$n2);
                        $den_prod *= ($d1*10+$d2);
                    }
                }
            }
        }
    }
    my $gcf = gcf($num_prod, $den_prod);
    $den_prod /= $gcf;
    return $den_prod;
}

sub gcf {
    my ($x, $y) = @_;
    ($x, $y) = ($y, $x % $y) while $y;
    return $x;
}
