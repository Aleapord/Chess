package ChessDemo.Chesses;

import ChessDemo.ChessPiece;
import ChessDemo.MoveStrategy;

public class Queen extends ChessPiece implements MoveStrategy {
    public Queen(int row,int col,char side) {
        super(row,col,side);
        if(side=='B'){
            super.imagePath="/res/blackQueen.png";
        }
        if(side=='W'){
            super.imagePath="/res/whiteQueen.png";
        }
    }

    @Override
    public boolean chessPieceMoveStrategy(int row, int col) {
       if(this.row ==row||this.col ==col||Math.abs(this.col -col)==Math.abs(this.row -row)){
           return true;
       }
       else {
           return false;
       }
    }
}

