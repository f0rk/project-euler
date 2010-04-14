#!/usr/bin/python
#solution: 

import math

def is_prime(n):
    if n < 2:
        return False
    if n == 2:
        return True
    if n < 10:
        values = { \
            2: True, \
            3: True, \
            4: False, \
            5: True, \
            6: False, \
            7: True, \
            8: False, \
            9: False \
        }
        return values.get(n)
    i = 3
    while i <= math.sqrt(n):
        if n % i == 0:
            return False
        i += 2
    return True

def primes():
    p = 2
    while 1:
        if is_prime(p):
            yield p
        if p == 2:
            p = 3
        else:
            p += 2


def euler_problem_10():
    p = 0
    sum = 0
    pnums = primes()
    while p < 2000000:
        p = pnums.next()
        sum += p
    return sum - p

print euler_problem_10()
