#!/usr/bin/python
#solution: 24174150

import math

def euler_problem_6():
    squares = 0
    sum = 0
    for i in range(100):
        sum += i
        squares += math.pow(i, 2)
    return int(math.pow(sum, 2) - squares)

print euler_problem_6()
