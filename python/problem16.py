#!/usr/bin/python
#solution: 1366 

def euler_problem_16():
    return reduce(lambda x, y: int(x) + int(y), str(2 ** 1000))

print euler_problem_16()
