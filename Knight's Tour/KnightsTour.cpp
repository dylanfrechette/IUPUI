/*
Dylan Frechette
Knights Tour Using Warnsdorff's Algorithm
Created: 09/02/20
*/

#include <cstdlib>
#include <iostream>
#include <string.h>
#include <math.h>
#include <list>
#include <stack>
#include <fstream>
//defining a set value to be size of chessboard for logical purposes
#define N 8

// Move patterns for x and y coordinates 
static int moveX[N] = {1,1,2,2,-1,-1,-2,-2}; 
static int moveY[N] = {2,-2,1,-1,2,-2,1,-1}; 
//checks if spot is on board
bool onBoard(int x, int y) 
{ 
    return ((x >= 0 && y >= 0) && (x < N && y < N)); 
} 
// Checks whether a square is on board and hasn't been visited
bool isEmpty(int a[], int x, int y) 
{ 
    return (onBoard(x, y)) && (a[y*N+x] < 0); 
} 
/* 
Returns the number of empty squares knight
is able to move to from (x, y)
*/
int getMvDeg(int a[], int x, int y) 
{ 
    int count = 0; 
    for (int i = 0; i < N; ++i) 
        if (isEmpty(a, (x + moveX[i]), (y + moveY[i]))) 
            count++; 
  
    return count; 
} 
/*
Picks next point using Warnsdorff, 
returns false if it is not possible to pick next point. 
*/
bool nextMove(int a[], int *x, int *y) 
{ 
    int minDegIndex = -1, c, minDegree = (N+1), newx, newy; 
    /*
    Try all N adjacent of (*x, *y) starting 
    from random pick. Find the adjacent 
    with minimum degree. 
    */
    int start = rand()%N; 
    for (int count = 0; count < N; ++count) 
    { 
        int i = (start + count)%N; 
        newx = *x + moveX[i]; 
        newy = *y + moveY[i]; 
        if ((isEmpty(a, newx, newy)) && 
           (c = getMvDeg(a, newx, newy)) < minDegree) 
        { 
            minDegIndex = i; 
            minDegree = c; 
        } 
    } 
    //can't find a next point
    if (minDegIndex == -1) 
        return false; 
  
    // Store next point 
    newx = *x + moveX[minDegIndex]; 
    newy = *y + moveY[minDegIndex]; 
  
    // Mark next move on board
    a[newy*N + newx] = a[(*y)*N + (*x)]+1; 
  
    // Update next point 
    *x = newx; 
    *y = newy; 
  
    return true; 
} 
//display board with all moves and order visited
void print(int a[]) 
{ 
    for (int i = 0; i < N; ++i) 
    { 
        for (int j = 0; j < N; ++j) 
            printf("%d\t",a[j*N+i]); 
        printf("\n"); 
    } 
} 
//checks knight's neighboring squares
//if knight ends on square one move from start square, tour is complete
bool neighborSq(int x, int y, int xx, int yy) 
{ 
    for (int i = 0; i < N; ++i) 
        if (((x+moveX[i]) == xx)&&((y + moveY[i]) == yy)) 
            return true; 
  
    return false; 
} 
//makes moves using Warnsdorff, returns false if can't complete
bool completeTour(int sx,int sy) 
{ 
    // Fill board matrix with -1's 
    int a[N*N]; 
    for (int i = 0; i< N*N; ++i) 
        a[i] = -1; 
   
    // int sx = rand()%N; 
    // int sy = rand()%N; 

    // Current points are same as initial points 
    int x = sx, y = sy; 
    //Mark first location on board
    a[y*N+x] = 1; 
    // continue picking points using Warnsdorff
    for (int i = 0; i < N*N-1; ++i) 
        if (nextMove(a, &x, &y) == 0) 
            return false; 
    //Check if tour Can end at starting point
    if (!neighborSq(x, y, sx, sy)) 
        return false; 

    print(a); 
    return true; 
}
//Following struct and function are for linked list generation
struct Node
{
    int data;
    struct Node *next;
};
//intialize head node
struct Node *head = NULL;
//insert node to front of linked list
void insert(int new_data)
{
    struct Node *new_node = (struct Node *)malloc(sizeof(struct Node));
    new_node->data = new_data;
    new_node->next = head;
    head = new_node;
}
//deletes last input node
  void deleteIn()
  {
    Node *temp=new Node;
    temp=head;
    head=head->next;
    delete temp;
  }
/*
displays nodes input from most recent to least,
displaying every two nodes as a coordinate
*/
void display()
{
    struct Node *ptr;
    ptr = head;
    int count=0;
    while (ptr != NULL)
    {
        if(count%2==0)
        {
        std::cout <<"("<< ptr->data << ",";
        ptr = ptr->next;
        count++;
        }
        else
        {
            std::cout << ptr->data << ") ";
            ptr = ptr->next;
            count++;
        }
        
    }
    std::cout << "\n";
}
    int main()
    {
        //boolean made to check for when finished inputting new points
        bool doneEdit=false;
        int x, y, choice;
        std::cout << "Select an x (0-7)\n";
        std::cin >> x;
        std::cout << "select a y(0-7)\n";
        std::cin >> y;
        insert(x);
        insert(y);
        display();
        while(!doneEdit)
        {
            std::cout << "1. Add new coordinate\n2. Delete last input\n3. continue to tour list\n";
            std::cin >> choice;
            if(choice==1)
            {
                std::cout << "Select an x(0-7)\n";
                std::cin >> x;
                std::cout << "select a y(0-7)\n";
                std::cin >> y;
                //insert each separately since values stored as single ints
                insert(x);
                insert(y);
                display();
                doneEdit=false;
            }
            else if(choice==2)
            {
                //delete twice due to points being stored as single ints
                deleteIn();
                deleteIn();
                display();
                doneEdit=false;
            }
            else if(choice==3)
            {
                doneEdit=true;
                break;
            }
        }
        while(head != NULL)
        {
        //Continue until solution found
        while (!completeTour(x, y))
        {
            ;
        }
        //delete the x and y just used in current iteration
        deleteIn();
        deleteIn();
        std::cout <<"\n\nTour complete\n\n";
        }
        return 0;
    }