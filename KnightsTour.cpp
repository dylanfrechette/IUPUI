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
    int board[][];
    int boardSize;

    void KnightMove(xMove, yMove, board[boardSize][boardSize])
    {
    }
};
int main()
{
    std::list<int> initalPos;
    std::stack<int> prevMoves;
    int boardSize;

    std::cout << "Welcome to the Knight's Tour" << std::endl;
    std::cout << "How big is your board?" << std::endl;
    std::cin >> boardSize;
}