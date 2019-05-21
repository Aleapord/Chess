package ChessDemo.Chesses;

import ChessDemo.ChessPiece;
import ChessDemo.MoveStrategy;

public class Bishop extends ChessPiece implements MoveStrategy {

    //构造函数，调用父类构造器，并通过黑方或白方指定棋子的图像路径(其他棋子子类大同小异，因此省略注释）
    public Bishop(int row, int col, char side) {
        super(row, col, side);
        if (side == 'B') {
            super.imagePath = "/res/blackBishop.png";
        }
        if (side == 'W') {
            super.imagePath = "/res/whiteBishop.png";
        }
    }
    //棋子的移动策略
    @Override
    public boolean chessPieceMoveStrategy(int row, int col) {

        if(Math.abs(this.col -col)==Math.abs(this.row -row)) {
            //调用父类move()函数移动
            return true;
        }
        return false;
    }
}