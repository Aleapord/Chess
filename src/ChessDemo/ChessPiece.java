package ChessDemo;
//所有棋子的父类，包含棋子的通用属性和通用方法
public class ChessPiece implements MoveStrategy {
    //棋子的行列信息
    public int col;
    public int row;
    //棋子的图像路径
    protected String imagePath;
    //黑方或白方
    protected char side;

    public ChessPiece(int col, int row, char side) {
        this.col = col;
        this.row = row;
        this.side = side;
    }
    //移动棋子到指定位置
    public void move(int row, int col){
        this.row =row;
        this.col =col;
    }

    @Override
    public String toString() {
        //利用反射获取棋子名并打印输出
        Class obj=this.getClass();
        return "第"+(row+1)+"行，第"+(col+1)+"列"+(side=='B'?"黑":"白")+"方的"+obj.getName();
    }

    //判断棋子是否能移动到指定位置,并移动棋子
    @Override
    public boolean chessPieceMoveStrategy(int row, int col) {
        return true;

    }
}
