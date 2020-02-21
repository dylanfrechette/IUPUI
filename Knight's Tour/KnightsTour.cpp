/*
Dylan Frechette
Knights Tour; Half-Backtracking Half-Warnsdorff's Algorithm
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
// Checks whether a square is on board and empty
bool isEmpty(int a[], int x, int y) 
{ 
    return (onBoard(x, y)) && (a[y*N+x] < 0); 
} 
/* Returns the number of empty squares adjacent 
   to (x, y) */
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
    int min_deg_idx = -1, c, min_deg = (N+1), nx, ny; 
    /*
    Try all N adjacent of (*x, *y) starting 
    from random pick. Find the adjacent 
    with minimum degree. 
    */
    int start = rand()%N; 
    for (int count = 0; count < N; ++count) 
    { 
        int i = (start + count)%N; 
        nx = *x + moveX[i]; 
        ny = *y + moveY[i]; 
        if ((isEmpty(a, nx, ny)) && 
           (c = getMvDeg(a, nx, ny)) < min_deg) 
        { 
            min_deg_idx = i; 
            min_deg = c; 
        } 
    } 
    //can't find a next point
    if (min_deg_idx == -1) 
        //std::cout <<"Couldn't complete path, try again\n";
        return false; 
  
    // Store next point 
    nx = *x + moveX[min_deg_idx]; 
    ny = *y + moveY[min_deg_idx]; 
  
    // Mark next move on board
    a[ny*N + nx] = a[(*y)*N + (*x)]+1; 
  
    // Update next point 
    *x = nx; 
    *y = ny; 
  
    return true; 
} 
//display board with all moves
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
  
    //std::cout <<"Couldn't complete path, try again\n";
    return false; 
} 
//makes moves using Warnsdorff, returns false if can't
bool completeTour() 
{ 
    // Fill board matrix with -1's 
    int a[N*N]; 
    for (int i = 0; i< N*N; ++i) 
        a[i] = -1; 
   
    int sx = rand()%N; 
    int sy = rand()%N; 
    // int sx, sy;
    // //having issues, sometimes works, sometimes doesn't when
    // //using input, sometimes just need to input twice
    // std::cout<<"Pick an x coordinate\n";
    // std::cin>>sx;
    // std::cout<<"Pick a y coordinate\n";
    // std::cin >> sy;
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

int main() 
{ 
    srand(time(NULL));
    //Continue until solution found 
    while (!completeTour()) 
    { 
    ; 
    } 
    return 0; 
} 