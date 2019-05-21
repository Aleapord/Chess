package ChessDemo;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
//控制器类
public class Controller implements EventHandler<MouseEvent> {
    //当前状态是否被点击
    private boolean clickedFlag;
    //当前选中行列
    private int currentCol;
    private int currentRow;
    private ChessEntity chessEntity;

    public Controller(ChessEntity chessEntity) {
        this.chessEntity = chessEntity;
        //初始未被点击
        clickedFlag = false;
        //默认当前行列：0，0
        currentCol = 0;
        currentRow = 0;
    }

    @Override
    public void handle(MouseEvent event) {

        if (!clickedFlag) {
            currentRow = (int) (event.getY() / 70);
            currentCol = (int) (event.getX() / 70);
            //判断是否点中了当前下子方的棋子
            if (chessEntity.getIsOccupied()[currentRow][currentCol] == (chessEntity.getCurrentSide() == 'B' ? 1 : -1)) {
                //选中该棋子
                chessEntity.selectChessPiece(currentRow, currentCol);
                //当前状态:已被选中
                clickedFlag = true;
            }
        } else {
            //实体类负责移动棋子
            chessEntity.operateChessPiece(currentRow,currentCol,((int)event.getY())/70,((int)event.getX())/70);
            //当前状态：未被选中
            clickedFlag=false;

        }
    }
}


