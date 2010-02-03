#!/usr/bin/perl
#solution: 73682
use strict;
use warnings;

print euler_problem_31(), "\n";

sub euler_problem_31 {
    my $combos = 0;
    for(my $n1 = 0; $n1 <= 1; ++$n1) {
        for(my $n2 = 0; $n2 <= 2; ++$n2) {
            for(my $n3 = 0; $n3 <= 4; ++$n3) {
                for(my $n4 = 0; $n4 <= 10; ++$n4) {
                    for(my $n5 = 0; $n5 <= 20; ++$n5) {
                        for(my $n6 = 0; $n6 <= 40; ++$n6) {
                            for(my $n7 = 0; $n7 <= 100; ++$n7) {
                                for(my $n8 = 0; $n8 <= 200; ++$n8) {
                                    if($n1*200 + $n2*100 + $n3*50 + $n4*20 + $n5*10 + $n6*5 + $n7*2 + $n8 == 200) {
                                        ++$combos;
                                    }
                                    last if $n1*200 + $n2*100 + $n3*50 + $n4*20 + $n5*10 + $n6*5 + $n7*2 + $n8 + 1 > 200;
                                }
                                last if $n1*200 + $n2*100 + $n3*50 + $n4*20 + $n5*10 + $n6*5 + $n7*2 + 1 > 200;
                            }
                            last if $n1*200 + $n2*100 + $n3*50 + $n4*20 + $n5*10 + $n6*5 + 1 > 200;
                        }
                        last if $n1*200 + $n2*100 + $n3*50 + $n4*20 + $n5*10 + 1 > 200;
                    }
                    last if $n1*200 + $n2*100 + $n3*50 + $n4*20 + 1 > 200;
                }
                last if $n1*200 + $n2*100 + $n3*50 + 1 > 200;
            }
            last if $n1*200 + $n2*100 + 1 > 200;
        }
        last if $n1*200 + 1 > 200;
    }
    return $combos;
}
