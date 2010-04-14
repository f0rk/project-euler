#!/usr/bin/python
#solution: 142913828922 

def euler_problem_10():
    ps = range(2000000)
    ps[1] = 0
    i = 2
    while i < len(ps):
        if ps[i] == 0:
            i += 1
            continue
        j = i + i
        while j < len(ps):
            ps[j] = 0
            j += i
        i += 1

    return sum(ps)

print euler_problem_10()
