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

//structure to generate and hold squares to store in stack
struct currentSquare
{
    int xSpot;
    int ySpot;
};
//structure to hold arrays for all possible knight movements
struct knightMoves
{
    int xMove[8]={1,1,-1,-1,2,2,-2,-2};
    int yMove[8]={2,-2,2,-2,1,-1,1,-1};
};
//boolean to check if the space moved to is a valid board space
bool safeMove(int x, int y)
{
    return ((x >= 0 && x < 8) && (y >= 0 && y < 8)) ? true : false;
}
//clear stack with each iteration of the algorithm
void clearStack(bool board[8][8])
{
    for(int i=0;i<8;i++)
        for(int j=0;j<8;j++)
        {
            board[i][j]=true;
        }
}
//print out completed board after running the algorithm
void printBoard(int board[8][8])
{
    for(int i=0;i<8;i++)
    {
        for(int j=0;j<8;j++)
        {
            std::cout<<board[i][j]<< std::endl;
        }
    }
}

int main()
{
    currentSquare boardPos;
    std::stack<currentSquare> Moves;

    bool board[8][8];
    clearStack(board);

    std::cout << "What would you like your knight's starting X coordinate to be?\n";
    std::cin >> boardPos.xSpot;
    std::cout << "What would you like the starting y coordinate to be?\n";
    std::cin >> boardPos.ySpot;
    Moves.push(boardPos);
    board[boardPos.xSpot][boardPos.ySpot]=false;

}