<?php
//solution: 171
echo eulerProblem19() . "\n";

function eulerProblem19() {
    
    $daysInMonths = array(31,28,31,30,31,30,31,31,30,31,30,31);
    $dayOfWeek = "tuesday";
    $sundaysOnFirst = 0;
    for($year = 1901; $year <= 2000; ++$year) {
        for($month = 0; $month < 12; ++$month) {
            
            $dim;
            if($month == 1) {
                $dim = daysInFebruary($year);
            } else {
                $dim = $daysInMonths[$month];
            }
            
            for($day = 1; $day <= $dim; ++$day) {
                if($day == 1 && $dayOfWeek == "sunday") {
                    ++$sundaysOnFirst;
                }
                $dayOfWeek = nextDayOfWeek($dayOfWeek);
            }
        }
    }
    
    return $sundaysOnFirst;
}

function daysInFebruary($year) {
    if($year % 400 == 0) {
        return 29;
    }
    
    if($year % 100 == 0) {
        return 28;
    }
    
    if($year % 4 == 0) {
        return 29;
    }
    
    return 28;
}

function nextDayOfWeek($name) {
    if($name == "monday") {
        return "tuesday";
    } elseif($name == "tuesday") {
        return "wednesday";
    } elseif($name == "wednesday") {
        return "thursday";
    } elseif($name == "thursday") {
        return "friday";
    } elseif($name == "friday") {
        return "saturday";
    } elseif($name == "saturday") {
        return "sunday";
    } elseif($name == "sunday") {
        return "monday";
    }
}

?>
