package ChessDemo.Chesses;

import ChessDemo.ChessPiece;
import ChessDemo.MoveStrategy;

public class Pawn extends ChessPiece implements MoveStrategy {
    private boolean firstStepFlag;

    public Pawn(int row, int col, char side) {
        super(row, col, side);
        if (side == 'B') {
            super.imagePath = "/res/blackPawn.png";
        }
        if (side == 'W') {
            super.imagePath = "/res/whitePawn.png";
        }
        firstStepFlag = true;
    }

    @Override
    public boolean chessPieceMoveStrategy(int row, int col) {


        if (side == 'B') {
            if (firstStepFlag) {
                if (col - this.col <= 2 && row == this.row&&col - this.col>0) {
                    firstStepFlag=false;
                    return true;
                }
                else {
                    return false;
                }
            }else {
                if (col - this.col <= 1 && row == this.row&&col - this.col>0) {
                    return true;
                }
                else {
                    return false;
                }
            }
        } else {
            if (firstStepFlag) {
                if (this.col-col <= 2 && row == this.row&&this.col-col>0) {
                firstStepFlag=false;
                return true;
            }
                else {
                    return false;
                }
        }else {
            if (this.col-col <= 1 && row == this.row&&this.col-col>0) {
                return true;
            }
            return false;
        }
        }
    }

}


