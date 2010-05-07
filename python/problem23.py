#!/usr/bin/python
#solution: 4179871

import math

def proper_divisors(n):
    divs = [1]
    i = 2
    while i <= math.sqrt(n):
        if n % i == 0:
            divs.append(i)
            divs.append(n / i)
            if i == math.sqrt(n):
                divs.pop()
        i += 1
    return divs

def euler_problem_23():
    abun = {}
    for i in xrange(2, 28123):
        if i < sum(proper_divisors(i)): # abundant
            abun[i] = True
    total = 0
    i = 0
    while i < 28123:
        total += i
        for a in abun.keys():
            diff = i - a
            if diff <= 0:
                break
            if diff in abun:
                total -= i
                break
        i += 1
    return total 
    

print euler_problem_23()
