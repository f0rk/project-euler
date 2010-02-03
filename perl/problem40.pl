#!/usr/bin/perl
#solution: 210
use strict;
use warnings;

print euler_problem_40(), "\n";

sub euler_problem_40 {
    my $cat = "";
    for(my $i = 1;; ++$i) {
        $cat .= $i;
        if(length($cat) > 1000000) {
            last;
        }
    }
    return substr($cat, 0, 1) * substr($cat, 9, 1) * substr($cat, 99, 1) * substr($cat, 999, 1) * substr($cat, 9999, 1) * substr($cat, 99999, 1) * substr($cat, 999999, 1);
}
