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

/*
using nested vectors rather than array due to being able to actually alter vector size,
giving the ability to make a variable the size for our board
*/
class Knight
{
public:
    int xStarting;
    int yStarting;
    int boardSize;
    std::vector<std::vector<int> > wholeBoard;
    int xMove;
    int yMove;
    Knight(std::vector<std::vector<int> > Board, int xStart, int yStart, int bSize)
    {
        boardSize=bSize;
        wholeBoard = Board;
        xStarting=xStart;
        yStarting=yStart;
    }
    void KnightMove(int xMove, int yMove, std::vector<std::vector<int> > Board)
    {

    }
    /*
    boolean check if new spots x and y are valid spots for movement
    in board Board of size S
    */
    bool safeMove(int x, int y, std::vector<std::vector<int> > board, int bSize)
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
    /*using vector of vectors for board due to flexibility*/
    std::vector<std::vector<int> > board;
    /*initializing memory for the total size of board*/
    board.reserve(boardSize*boardSize);

    std::cout << "Welcome to the Knight's Tour" << std::endl;
    std::cout << "How big is your board?" << std::endl;
    std::cin >> boardSize;
    std::cout << "What would you like your knight's starting X coordinate to be?" << std::endl;
    std::cin >> startX;
    std::cout << "What would you like the starting y coordinate to be?" << std::endl;
    std::cin >> startY;
    Knight Gallahad(board,startX,startY,boardSize);
}