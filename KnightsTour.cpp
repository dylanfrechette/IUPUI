/*
Dylan Frechette
Created: 09/02/20
Mod History
*/
#include <cstdlib>
#include <iostream>
#include <string.h>
#include <math.h>
#include <list>
#include <stack>

class Knight
{
public:
    int xMove;
    int yMove;
    int boardSize;
    Knight(int bSize, int xStart, int yStart)
    {
        boardSize=bSize;
        xMove=xStart;
        yMove=yStart;
    }
    int wholeBoard[boardSize][boardSize];
    void KnightMove(xMove, yMove, wholeBoard)
    {
        
    }
};
int main()
{
    std::list<int> initalPos;
    std::stack<int> prevMoves;
    int boardSize;
    int startX;
    int startY;
    int board[][];

    std::cout << "Welcome to the Knight's Tour" << std::endl;
    std::cout << "How big is your board?" << std::endl;
    std::cin >> boardSize;
    std::cout << "What would you like your knight's starting X coordinate to be?" << std::endl;
    std::cin >> startX;
    std::cout << "What would you like the starting y coordinate to be?" << std::endl;
    std::cin >> startY;
    Knight Gallahad=new Knight(boardSize,startX,startY);
}