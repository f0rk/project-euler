#!/usr/bin/perl
#solution: 932718654
use strict;
use warnings;

print euler_problem_38(), "\n";

sub euler_problem_38 {
    my $max = 0;
    for(my $i = 1; $i < 100000; ++$i) {
        my $cat = "";
        for(my $j = 1; length($cat) < 9; ++$j) {
            $cat .= $i*$j;
        }
        if(length($cat) == 9) {
            if(is_pandigital($cat)) {
                if($cat > $max) {
                    $max = $cat;
                }
            }
        }
    }
    return $max;
}

sub is_pandigital {
    my $str = shift;
    
    $str =~ s/1//;
    $str =~ s/2//;
    $str =~ s/3//;
    $str =~ s/4//;
    $str =~ s/5//;
    $str =~ s/6//;
    $str =~ s/7//;
    $str =~ s/8//;
    $str =~ s/9//;
    
    return length($str) == 0;
}
