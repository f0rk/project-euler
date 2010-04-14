#!/usr/bin/python
#solution: 837799

cache = {}

def collatz_number(n):
    length = 0
    o = n
    while n != 1:
        if n in cache:
            cache[o] = length + cache[n]
            return cache[o]
        if n % 2 == 0:
            n /= 2
        else:
            n = 3 * n + 1
        length += 1

    cache[o] = length
    return length

def euler_problem_14():
    i = 1
    max = 0
    maxi = 0
    while i < 1000000:
        cn = collatz_number(i)
        if cn > max:
            max = cn
            maxi = i
        i += 1
    return maxi

print euler_problem_14()
