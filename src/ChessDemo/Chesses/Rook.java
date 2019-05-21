package ChessDemo.Chesses;

import ChessDemo.ChessPiece;
import ChessDemo.MoveStrategy;

public class Rook extends ChessPiece implements MoveStrategy {
    public Rook(int row,int col,char side) {
        super(row,col,side);
        if(side=='B'){
            super.imagePath="/res/blackRook.png";
        }
        if(side=='W'){
            super.imagePath="/res/whiteRook.png";
        }

    }

    @Override
    public boolean chessPieceMoveStrategy(int row, int col) {
        if(this.row ==row||this.col ==col){
            return true;
        }
        return false;

    }
}

