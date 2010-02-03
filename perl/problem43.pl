#!/usr/bin/perl
#solution: 16695334890
use strict;
use warnings;

print euler_problem_43(), "\n";

sub euler_problem_43 {
    my $sum = 0;
    for(my $i = 0; $i < factorial(10); ++$i) {
        my $seq = permutation($i,[0..9]);
        my $s1 = $seq->[1].$seq->[2].$seq->[3];
        $s1 =~ s/^0//;
        my $s2 = $seq->[2].$seq->[3].$seq->[4];
        $s2 =~ s/^0//;
        my $s3 = $seq->[3].$seq->[4].$seq->[5];
        $s3 =~ s/^0//;
        my $s4 = $seq->[4].$seq->[5].$seq->[6];
        $s4 =~ s/^0//;
        my $s5 = $seq->[5].$seq->[6].$seq->[7];
        $s5 =~ s/^0//;
        my $s6 = $seq->[6].$seq->[7].$seq->[8];
        $s6 =~ s/^0//;
        my $s7 = $seq->[7].$seq->[8].$seq->[9];
        $s7 =~ s/^0//;
        if($s1 % 2 == 0 && $s2 % 3 == 0
        && $s3 % 5 == 0 && $s4 % 7 == 0
        && $s5 % 11 == 0 && $s6 % 13 == 0
        && $s7 % 17 == 0) {
            my $num = join('',@$seq);
            $num =~ s/^0//;
            $sum += $num;
        }
    }
    return $sum;
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
