#!/usr/bin/python
#solution: 4613732

def euler_problem_2():
    limit = 4000000
    sum, a, b = 0, 1, 2
    while a < limit:
        if a % 2 == 0:
            sum += a
        a, b = b, a+b
    return sum

print euler_problem_2()
