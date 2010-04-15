#!/usr/bin/python
#solution: 648

def factorial(n):
    if n == 2:
        return 2
    return n * factorial(n - 1)

def euler_problem_20():
    return reduce(lambda x, y: int(x) + int(y), str(factorial(100)))

print euler_problem_20()
