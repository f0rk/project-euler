#!/usr/bin/python
#solution: 233168

def euler_problem_1():
    return sum([x for x in range(1, 1000, 1) if x % 3 == 0 or x % 5 == 0])

print euler_problem_1()
