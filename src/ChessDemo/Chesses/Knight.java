package ChessDemo.Chesses;

import ChessDemo.ChessPiece;
import ChessDemo.MoveStrategy;

public class Knight extends ChessPiece implements MoveStrategy {
    public Knight(int row,int col,char side) {
        super(row,col,side);
        if(side=='B'){
            super.imagePath="/res/blackKnight.png";
        }
        if(side=='W'){
            super.imagePath="/res/whiteKnight.png";
        }

    }

    @Override
    public boolean chessPieceMoveStrategy(int row, int col) {
        if((Math.abs(this.row -row)==1&&Math.abs(this.col -col)==2)||
                (Math.abs(this.row -row)==2&&Math.abs(this.col -col)==1)){
            return true;
        }
        return false;
    }
}

