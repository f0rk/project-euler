#!/usr/bin/python
#solution: 6857

import math

def is_prime(n):
    if n == 2:
        return True
    if n % 2 == 0:
        return False
    i = 3
    while i < math.sqrt(n):
        if n % i == 0:
            return False
        i += 2
    return True
    

def euler_problem_3():
    i, max, limit = 3, 0, 600851475143
    while i < math.sqrt(limit):
        if is_prime(i) and limit % i == 0:
            max = i
        i += 2
    return max

print euler_problem_3()
