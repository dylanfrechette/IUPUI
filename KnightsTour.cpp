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
#include <vector>

class Knight
{
public:

    int xMove;
    int yMove;
    Knight(int xStart, int yStart, int bSize)
    {
        const int boardSize=bSize;
        const int xStarting=xStart;
        const int yStarting=yStart;
        int wholeBoard[boardSize][boardSize];
    }

    void KnightMove(int xMove, int yMove)
    {

    }
    /*
    boolean check if new spots x and y are valid spots for movement
    in board Board of size S
    */
    bool safeMove(int x, int y, int bSize)
    {
        return (x>=0 && x<bSize && y >=0 && y<bSize)?true:false;
    }
};
int main()
{
    std::list<int> initalPos;
    std::stack<int> prevMoves;
    int boardSize;
    int startX;
    int startY;

    std::cout << "Welcome to the Knight's Tour\n";
    std::cout << "How big is your board?\n";
    std::cin >> boardSize;
    std::cout << "What would you like your knight's starting X coordinate to be?\n";
    std::cin >> startX;
    std::cout << "What would you like the starting y coordinate to be?\n";
    std::cin >> startY;
    Knight Gallahad(startX,startY,boardSize);
}