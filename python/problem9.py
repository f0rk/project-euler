#!/usr/bin/python
#solution: 31875000

import math

def euler_problem_9():
    for a in range(1, 1000, 1):
        for b in range(1, 1000, 1):
            for c in range(1, 1000, 1):
                if a + b + c == 1000 and int(math.pow(a, 2)) + int(math.pow(b, 2)) == int(math.pow(c, 2)):
                    return a * b * c

print euler_problem_9()
