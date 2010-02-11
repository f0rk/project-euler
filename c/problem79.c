#include <stdio.h>
#include <stdlib.h>
//solution: 73162890

struct node {
    char c;
    struct node* next;
    struct node* prev;
};

typedef struct node node;

struct list {
    node* head;
    node* tail;
    int size;
};

typedef struct list list;

void list_add_after(list*, char, char);
void list_add_before(list*, char, char);
void list_add(list*, char);
int list_has(list*, char);

int euler_problem_79() {
    char* arr[] = {"319", "680", "180", "690", "129", "620", "762", "689", "762", "318", "368", "710", "720", "710", "629", "168", "160", "689", "716", "731", "736", "729", "316", "729", "729", "710", "769", "290", "719", "680", "318", "389", "162", "289", "162", "718", "729", "319", "790", "680", "890", "362", "319", "760", "316", "729", "380", "319", "728", "716", "\0\0\0"};
    list** ll = (list**)malloc(sizeof(list)*10);
    for(int i = 0; i < 10; ++i) {
        ll[i] = (list*)malloc(sizeof(list));
        ll[i]->head = 0;
        ll[i]->size = 0;
    }
    
    int* seen = (int*)malloc(sizeof(int)*10);
    for(int i = 0; arr[i][0] != '\0'; ++i) {
        if(!list_has(ll[arr[i][1]-'0'], arr[i][0])) {
            list_add(ll[arr[i][1]-'0'], arr[i][0]);
        }
        if(!list_has(ll[arr[i][2]-'0'], arr[i][1])) {
            list_add(ll[arr[i][2]-'0'], arr[i][1]);
        }
        seen[arr[i][0]-'0'] = 1;
        seen[arr[i][1]-'0'] = 1;
        seen[arr[i][2]-'0'] = 1;
    }
    
    //order the lists by length, removing
    //those that were not seen
    
    //if two lists are the same length,
    //filter out equal elements and then
    //check to see how they should be ordered
    //based on the remaining elements
    int* order = (int*)malloc(sizeof(int)*20);
    for(int i = 0; i < 20; ++i) { order[i] = -1; }
    int open = 0;
    for(int i = 0; i < 10; ++i, ++open) {
        for(int j = 0; j < 10; ++j) {
            if(ll[j]->size == i) {
                if(i == 0) {
                    if(seen[j] != 0) {
                        order[open] = j;
                        break;
                    }
                } else {
                    if(order[open] != -1 && ll[order[open]]->size == ll[j]->size) { //already seen this one, tiebreak
                        char l1c, l2c;
                        for(node* n = ll[order[i]]->head; n != 0; n = n->next) {
                            if(!list_has(ll[j], n->c)) {
                                l1c = n->c;
                            }
                        }
                        for(node* n = ll[j]->head; n != 0; n = n->next) {
                            if(!list_has(ll[order[i]], n->c)) {
                                l2c = n->c;
                            }
                        }
                        
                        if(ll[l1c-'0']->size < ll[l2c-'0']->size) { //order good
                            order[open+1] = j;
                            ++open;
                        } else { //swap
                            order[open+1] = order[open];
                            order[open] = j;
                            ++open;
                        }
                        break;
                    } else {
                        order[open] = j;
                    }
                }
            }
        }
    }
    
    char* str = (char*)malloc(sizeof(char)*100);
    for(int i = 0; order[i] != -1; ++i) {
        sprintf(str, "%s%c", str, order[i]+'0');        
    }
    return atoi(str);
}

int list_has(list* l, char c) {
    for(node* n = l->head; n != 0; n = n->next) {
        if(n->c == c) {
            return 1;
        }
    }
    return 0;
}

void list_add(list* l, char c) {
    node* nn = (node*)malloc(sizeof(node));
    nn->next = 0;
    nn->prev = 0;
    nn->c = c;
    if(l->head == 0) {
        l->head = nn;
        l->tail = nn;
        l->size++;
        return;
    }
    l->tail->next = nn;
    nn->prev = l->tail;
    l->tail = nn;
    l->size++;
    return;
}

void list_add_after(list* l, char nc, char cc) {
    node* nn = (node*)malloc(sizeof(node));
    nn->next = 0;
    nn->prev = 0;
    nn->c = nc;
    if(l->head == 0) {
        l->head = nn;
        l->tail = nn;
        l->size++;
        return;
    }
    for(node* n = l->head; n != 0; n = n->next) {
        if(n->c == cc) { //put it after this one
            if(n->next == 0) {
                l->tail = nn;
                nn->prev = n;
                n->next = nn;
                l->size++;
                return;
            }
            n->next->prev = nn;
            nn->prev = n;
            nn->next = n->next;
            n->next = nn;
            l->size++;
            return;
        }
    }
    //not in the list, add to the end
    l->tail->next = nn;
    nn->prev = l->tail;
    l->tail = nn;
    l->size++;
    return;
}

void list_add_before(list* l, char nc, char cc) {
    node* nn = (node*)malloc(sizeof(node));
    nn->next = 0;
    nn->prev = 0;
    nn->c = nc;
    if(l->head == 0) {
        l->head = nn;
        l->tail = nn;
        l->size++;
        return;
    }
    for(node* n = l->head; n != 0; n = n->next) {
        if(n->c == cc) { //put it before this one
            if(n->prev == 0) {
                l->head = nn;
                nn->next = n;
                n->prev = nn;
                l->size++;
                return;
            }
            n->prev->next = nn;
            nn->prev = n->prev;
            n->prev = nn;
            nn->next = n;
            l->size++;
            return;
        }
    }
    //not in the list, add to the end
    l->tail->next = nn;
    nn->prev = l->tail;
    l->tail = nn;
    l->size++;
    return;
}

int main() {
    printf("%d\n", euler_problem_79());
    return 0;
}

