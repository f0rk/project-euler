#!/usr/bin/python
#solution: 171

def euler_problem_19():
    firstmondays = 0
    year = 1900
    dayofweek = "monday"
    daymap = {
        "monday": "tuesday",
        "tuesday": "wednesday",
        "wednesday": "thursday",
        "thursday": "friday",
        "friday": "saturday",
        "saturday": "sunday",
        "sunday": "monday"
    }
    while year < 2001:
        month = [31,28,31,30,31,30,31,31,30,31,30,31]
        for days in month:
            if days == 28 and year % 4 == 0:
                if year % 100 == 0:
                    if year % 400 == 0:
                        days = 29
                else:
                    days = 29
            i = 0
            while i < days:
                if i == 0 and dayofweek == "sunday" and year > 1900:
                    firstmondays += 1
                dayofweek = daymap[dayofweek]
                i += 1
        year += 1

    return firstmondays

print euler_problem_19()
