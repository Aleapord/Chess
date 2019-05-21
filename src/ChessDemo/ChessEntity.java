package ChessDemo;

import ChessDemo.Chesses.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ChessEntity {
    //用于存放棋子的列表
    private List<ChessPiece> list = new ArrayList<>();
    //存放棋盘相应位置存放棋子的类型
    private int[][] isOccupied;
    //国际象棋图形界面
    private ChessPane chessPane;
    //当前下子方
    private char currentSide;
    public int[][] getIsOccupied() {
        return isOccupied;
    }

    public ChessPane getChessPane() {
        return chessPane;
    }

    public char getCurrentSide() {
        return currentSide;
    }

    public ChessEntity() {

        //初始化添加所有棋子
        list.add(new Queen(0, 4, 'B'));
        list.add(new King(7, 4, 'W'));
        list.add(new King(0, 3, 'B'));
        list.add(new Queen(7, 3, 'W'));
        list.add(new Knight(0, 6, 'B'));
        list.add(new Knight(7, 6, 'W'));
        list.add(new Knight(0, 1, 'B'));
        list.add(new Knight(7, 1, 'W'));
        list.add(new Bishop(0, 5, 'B'));
        list.add(new Bishop(7, 5, 'W'));
        list.add(new Bishop(0, 2, 'B'));
        list.add(new Bishop(7, 2, 'W'));
        list.add(new Rook(0, 7, 'B'));
        list.add(new Rook(7, 7, 'W'));
        list.add(new Rook(0, 0, 'B'));
        list.add(new Rook(7, 0, 'W'));
        for (int i = 0; i < 8; i++) {
            list.add(new Pawn(1, i, 'B'));
            list.add(new Pawn(6, i, 'W'));
        }
        //黑方先下子
        currentSide='B';
        //提示用户下子方
        System.out.println("当前下子方："+(currentSide=='B'?"黑方":"白方"));
        //初始化数组
        isOccupied = new int[][]{{1, 1, 0, 0, 0, 0, -1, -1}, {1, 1, 0, 0, 0, 0, -1, -1}, {1, 1, 0, 0, 0, 0, -1, -1}, {1, 1, 0, 0, 0, 0, -1, -1},
                {1, 1, 0, 0, 0, 0, -1, -1}, {1, 1, 0, 0, 0, 0, -1, -1}, {1, 1, 0, 0, 0, 0, -1, -1}, {1, 1, 0, 0, 0, 0, -1, -1}};
        chessPane = new ChessPane(list);
    }
    //对下子吃子进行操作的函数
    public void operateChessPiece(int curRow, int curCol, int row, int col) {
        Iterator<ChessPiece> iterator =list.iterator();
        ChessPiece cp=null;
        while (iterator.hasNext()){
            cp=(ChessPiece)iterator.next();
            if(cp.row==curRow&&cp.col==curCol)
                break;
        }
            if(isOccupied[row][col]==0&&!(isOccupied[row][col]==(currentSide=='B'?1:-1))){
                if(cp.chessPieceMoveStrategy(row,col)){
                    cp.move(row,col);
                    changeCurrentSide();
                    reFactorIsOccupied();
                }
            }
            else {
                if(cp.chessPieceMoveStrategy(row,col)) {
                    deleteChess(row, col);
                    cp.move(row, col);
                    changeCurrentSide();
                    reFactorIsOccupied();
                }
            }
            chessPane.rePaintChessPane(list);
        }

    //改变当前下子方
    private void changeCurrentSide(){
        if(currentSide=='B'){
            currentSide='W';
        }
        else {
            currentSide='B';
        }
        //提示用户下子方
        System.out.println("当前下子方："+(currentSide=='B'?"黑方":"白方"));
    }
    //调用视图层选中棋子
    public void selectChessPiece(int row, int col){
        chessPane.getRecSelected(row,col);
    }
    //重构数组
    private void reFactorIsOccupied() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                isOccupied[i][j] = 0;
            }
        }
        list.forEach(e -> {
            if (e.side == 'B') {
                isOccupied[e.row][e.col] = 1;
            } else {
                isOccupied[e.row][e.col] = -1;
            }
        });
    }
    //删除棋子
    public void deleteChess(int row, int col) {
        Iterator<ChessPiece> iterator =list.iterator();
        while (iterator.hasNext()){
            ChessPiece cp=(ChessPiece)iterator.next();
            if(cp.row == row && cp.col ==col){
                System.out.println("被吃的棋子："+cp);
                iterator.remove();
            }
        }
    }
}
