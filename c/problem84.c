#include <stdio.h>
#include <stdlib.h>
//solution: 101524

int roll(int sides);
void shuffle(int arr[], int n);

int euler_problem_84() {
    long hits[40] = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    int chance[16] = {
        0, //advance to GO
        10, //go to JAIL
        11, //go to C1
        24, //go to E3
        39, //go to H2
        5, //go to R1
        -1, //go to next RR
        -1, //go to next RR
        -2, //go to next Util
        -3, //go back 3 spaces
        -10, //do nothing
        -10,
        -10,
        -10,
        -10,
        -10
    };
    int comchest[16] = {
        0, //advance to GO
        10, //go to jail
        -10, //do nothing
        -10,
        -10,
        -10,
        -10,
        -10,
        -10,
        -10,
        -10,
        -10,
        -10,
        -10,
        -10,
        -10
    };
    int curpos = 0, //GO
        die0 = 0,
        die1 = 0,
        SIDES = 4, //sides on the dice
        doubles = 0, //doubles in a row
        ccpos = 0, //position community chest deck
        chpos = 0, //position in the chance deck
        i = 0;
    long MAXROLLS = 10000000,
         currolls = 0,
         top0 = 0,
         top1 = 0,
         top2 = 0;

         
    //chance and community chest
    shuffle(chance, 16);
    shuffle(comchest, 16);
    
    for(currolls = 0; currolls < MAXROLLS; ++currolls) {
        die0 = roll(SIDES);
        die1 = roll(SIDES);
        
        if(curpos + die0 + die1 > 39) {
            curpos = curpos + die0 + die1 - 39;
        } else {
            curpos = curpos + die0 + die1;
        }
        
        if(die0 == die1) {
            ++doubles;
        } else {
            doubles = 0;
        }
        
        if(doubles == 3) {
            curpos = 10;
            doubles = 0;
        }
        
        if(curpos == 2 || curpos == 17 || curpos == 33) { //community chest
            switch(comchest[ccpos]) {
                case -10:
                    break;
                case 0:
                    curpos = 0;
                    break;
                case 10:
                    curpos = 10;
                    break;
                default:
                    return 1;
            }
            ++ccpos;
            if(ccpos == 16) {
                ccpos = 0;
            }
        }
        
        if(curpos == 7 || curpos == 22 || curpos == 36) { //chance
            switch(chance[chpos]) {
                case -10:
                    break;
                case 0:
                    curpos = 0;
                    break;
                case 10:
                    curpos = 10;
                    break;
                case 11:
                    curpos = 11;
                    break;
                case 24:
                    curpos = 24;
                    break;
                case 39:
                    curpos = 39;
                    break;
                case 5:
                    curpos = 5;
                    break;
                case -1:
                    curpos = (curpos == 7 ? 15 : (curpos == 22 ? 25 : 5));
                    break;
                case -2:
                    curpos = (curpos == 7 ? 12 : (curpos == 22 ? 28 : 12));
                    break;
                case -3:
                    curpos -= 3;
                    break;
                default:
                    return 2;
            }
            ++chpos;
            if(chpos == 16) {
                chpos = 0;
            }
        }
        
        if(curpos == 30) {
            curpos = 10;
        }
        
        ++hits[curpos];
    }
    
    //find the max
    for(i = 0; i < 40; ++i) {
        if(hits[i] > hits[top0]) {
            top0 = i;
        }
    }
    
    for(i = 0; i < 40; ++i) {
        if(hits[i] > hits[top1] && i != top0) {
            top1 = i;
        }
    }
    
    for(i = 0; i < 40; ++i) {
        if(hits[i] > hits[top2] && i != top0 && i != top1) {
            top2 = i;
        }
    }
    
    printf("%02d%02d%02d\n", top0, top1, top2);
    return 0;
}

int roll(int sides) {
    return rand() % sides + 1;
}

void shuffle(int arr[], int n) {
    int k, tmp;
    while(n > 1) {
        k = rand()%(n--);
        tmp = arr[n];
        arr[n] = arr[k];
        arr[k] = tmp;
    }
}

int main() {
    if(euler_problem_84() != 0) {
        printf("ERROR\n");
    }
    return 0;
}

