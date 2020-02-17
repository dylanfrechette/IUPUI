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

/*
structs for holding knight's current square
and various movement patterns
*/
struct currentSquare
{
    int xSpot, ySpot;
};
//gives warning about inclass initialization being c++11 standard
struct Move_pattern
{
    int xChoices[8] = {1, 1, 2, 2, -1, -1, -2, -2};
    int yChoices[8] = {2, -2, 1, -1, 2, -2, 1, -1};
};

/*
boolean check if new spots x and y are valid spots for movement
in board Board of size S
*/
bool safeMove(int x, int y, int bSize)
{
    return (x >= 0 && x < bSize && y >= 0 && y < bSize) ? true : false;
}

int main()
{
    currentSquare boardPos;
    std::stack<currentSquare> Moves;
    int boardSize;

    std::cout << "Welcome to the Knight's Tour\n";
    std::cout << "How big is your board?\n";
    std::cin >> boardSize;
    std::cout << "What would you like your knight's starting X coordinate to be?\n";
    std::cin >> boardPos.xSpot;
    std::cout << "What would you like the starting y coordinate to be?\n";
    std::cin >> boardPos.ySpot;
    Moves.push(boardPos);
}