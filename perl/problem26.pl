#!/usr/bin/perl
#solution: 983
use strict;
use warnings;
use Math::BigFloat;

print euler_problem_26(), "\n";

sub euler_problem_26 {
    Math::BigFloat->accuracy(2020);
    Math::BigFloat->div_scale(2020);
    my $max = 0; my $can = 0;
    for(my $i = 2; $i < 1001; ++$i) {
        next if $i % 3 == 0;
        my $x = Math::BigFloat->new(1);
        my $res = $x->bdiv($i);
        $res =~ s/0\.0*//;
        $res =~ s/0+$//;
        if(length($res) < 100) {
            next;
        }
        next if($res =~ /^1+$/);
        next if($res =~ /^2+$/);
        next if($res =~ /^3+$/);
        next if($res =~ /^4+$/);
        next if($res =~ /^5+$/);
        next if($res =~ /^6+$/);
        next if($res =~ /^7+$/);
        next if($res =~ /^8+$/);
        next if($res =~ /^9+$/);
        
        my $ss = longest_repeated_subsequence($res);
        if(length($ss) > $max) {
            $max = length($ss);
            $can = $i;
        }
    }
    
    return $can;
}

sub longest_repeated_subsequence {
    my ($res) = @_;
    for(my $i = 0; $i <= length($res) / 2; ++$i) {
        for(my $j = 2; $j <= length($res) / 2; ++$j) {
            my $ss = substr($res, $i, $j);
            my $idx = index($res, $ss, $i+$j);
            if($idx == $i + $j) {
                #we have a winner
                return $ss;
            }
        }
    }
    return "";
}
