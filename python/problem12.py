#!/usr/bin/python
#solution: 76576500 

import math

def sprimep(n):
    if n < 2:
        return False
    if n == 2:
        return True
    if n < 10:
        values = {
            2: True,
            3: True,
            4: False,
            5: True,
            6: False,
            7: True,
            8: False,
            9: False
        }
        return values.get(n)

    i = 3
    while i <= math.sqrt(n):
        if n % i == 0:
            return False
        i += 2
    return True

def primep(n):
    if n < 99:
        return sprimep(n)

    lowprimes = [2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97]
    for prime in lowprimes:
        if n % prime == 0:
            return False
    
    i = 99
    while i <= math.sqrt(n):
        if n % i == 0:
            return False
        i += 2
    return True

def primes():
    p = 2
    while 1:
        if primep(p):
            yield p
        if p == 2:
            p = 3
        else:
            p += 2

def ndivisors(n, plist):
    piter = plist.__iter__()
    p = piter.next()
    divisors = 1
    while n != 1:
        curcount = 0
        while n % p == 0:
            n /= p
            curcount += 1
        if curcount > 0:
            divisors *= curcount + 1
        p = piter.next()
    return divisors

def euler_problem_12():
    i = 0
    plist = []
    pgen = primes()
    while i < 10000:
        plist.append(pgen.next())
        i += 1
    
    i = 3
    while 1:
        i += 1
        nfactors = ndivisors((i * (i + 1)) / 2, plist)
        if nfactors >= 500:
            return (i * (i + 1)) / 2

print euler_problem_12()
