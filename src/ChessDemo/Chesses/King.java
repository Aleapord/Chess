package ChessDemo.Chesses;

import ChessDemo.ChessPiece;
import ChessDemo.MoveStrategy;

public class King extends ChessPiece implements MoveStrategy {
    public King(int row,int col,char side) {
        super(row,col,side);
        if(side=='B'){
            super.imagePath="/res/blackKing.png";
        }
        if(side=='W'){
            super.imagePath="/res/whiteKing.png";
        }

    }

    @Override
    public boolean chessPieceMoveStrategy(int row, int col) {
        if(Math.abs(this.row-row)<=1&&Math.abs(this.col-col)<=1){
            return true;
        }
        return false;
    }
}

