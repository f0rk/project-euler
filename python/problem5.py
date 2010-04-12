#!/usr/bin/python
#solution: 232792560

def euler_problem_5():
    cur = 20 
    while True:
        if cur % 2 == 0 and \
            cur % 3 == 0 and \
            cur % 4 == 0 and \
            cur % 5 == 0 and \
            cur % 6 == 0 and \
            cur % 7 == 0 and \
            cur % 8 == 0 and \
            cur % 9 == 0 and \
            cur % 10 == 0 and \
            cur % 11 == 0 and \
            cur % 12 == 0 and \
            cur % 13 == 0 and \
            cur % 14 == 0 and \
            cur % 15 == 0 and \
            cur % 16 == 0 and \
            cur % 17 == 0 and \
            cur % 18 == 0 and \
            cur % 19 == 0 and \
            cur % 20 == 0:
            return cur
        cur += 20

print euler_problem_5()
