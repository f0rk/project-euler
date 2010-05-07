#!/usr/bin/python
#solution: 31626

import math

def proper_divisors(n):
    divs = [1]
    i = 2
    while i < math.sqrt(n):
        if n % i == 0:
            divs.append(i)
            divs.append(n / i)
        i += 1
    return divs

def euler_problem_21():
    totalsum = 0
    for i in xrange(2, 10000):
        divsum = sum(proper_divisors(i))
        othersum = sum(proper_divisors(divsum))
        if i == othersum and i != divsum:
            totalsum += i
            totalsum += divsum
    return totalsum / 2 # everything gets added twice

print euler_problem_21()
