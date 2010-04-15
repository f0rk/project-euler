#!/usr/bin/python
#solution: 21124

def word_form(number):
    if number < 20:
        words = {
            0: "",
            1: "one",
            2: "two",
            3: "three",
            4: "four",
            5: "five",
            6: "six",
            7: "seven",
            8: "eight",
            9: "nine",
            10: "ten",
            11: "eleven",
            12: "twelve",
            13: "thirteen",
            14: "fourteen",
            15: "fifteen",
            16: "sixteen",
            17: "seventeen",
            18: "eighteen",
            19: "nineteen",
        }
        return words[number]

    if number < 100:
        tens = (number / 10) * 10
        ones = number % 10
        words = {
            20: "twenty",
            30: "thirty",
            40: "forty",
            50: "fifty",
            60: "sixty",
            70: "seventy",
            80: "eighty",
            90: "ninety"
        }
        return words[tens] + word_form(ones)

    if number < 1000:
        huns = (number / 100) * 100
        tens = ((number - huns) / 10) * 10
        ones = number - huns - tens
        sand = "and"
        if tens == 0 and ones == 0:
            sand = ""
        return word_form(huns / 100) + "hundred" + sand + word_form(tens + ones)

    return "onethousand"

def euler_problem_17():
    return len("".join([word_form(i) for i in range(1001)]))

print euler_problem_17()
