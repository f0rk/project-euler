#!/usr/bin/python
#solution: 137846528820

def factorial(n):
    if n == 2:
        return 2
    return n * factorial(n - 1)

def combinations(n, r):
    return factorial(n) / (factorial(r) * factorial(n - r))

def euler_problem_15():
    return combinations(40, 20)

print euler_problem_15()
