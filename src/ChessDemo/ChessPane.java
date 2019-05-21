package ChessDemo;

import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.List;
//继承网格面板类
public class ChessPane extends GridPane{

    public ChessPane(List<ChessPiece> list) {
        createChessBoard();
        paintChessPiece(list);
    }
    //选中相应的网格
    public void getRecSelected(int row,int col){
        Rectangle rectangle=new Rectangle(70,70);
        rectangle.setFill(new Color(0,0,1,.5));
        this.add(rectangle,col,row);
    }
    //重画棋盘和棋子
    public void rePaintChessPane(List<ChessPiece> list){
        this.getChildren().clear();
        createChessBoard();
        paintChessPiece(list);
    }
    //画棋盘
    private void createChessBoard(){
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                Rectangle r=new Rectangle(70,70,Color.WHITE);
                if((i+j)%2!=0)
                    r.setFill(Color.gray(0.5));
                else{
                    r.setFill(Color.gray(0.9));
                }
                this.add(r,i,j);
            }
        }
    }
    //画棋子
    private void paintChessPiece(List<ChessPiece> list){
        list.forEach(e->this.add(new ImageView(e.imagePath),e.col,e.row));
    }
}