/*
Dylan Frechette
Knights Tour Backtracking Algorithm
Created: 09/02/20
*/

#include <cstdlib>
#include <iostream>
#include <string.h>
#include <math.h>
#include <list>
#include <stack>

struct currentSquare
{
    int xSpot;
    int ySpot;
};
struct knightMoves
{
    int xMove[8]={1,1,-1,-1,2,2,-2,-2};
    int yMove[8]={2,-2,2,-2,1,-1,1,-1};
};
bool safeMove(int x, int y)
{
    return ((x >= 0 && x < 8) && (y >= 0 && y < 8)) ? true : false;
}
void clearStack(bool board[8][8])
{
    for(int i=0;i<8;i++)
        for(int j=0;j<8;j++)
        {
            board[i][j]=true;
        }
}
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