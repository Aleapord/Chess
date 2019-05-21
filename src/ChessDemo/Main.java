package ChessDemo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    public void start(Stage primaryStage) {
        //新建一个国际象棋实体
        ChessEntity body=new ChessEntity();
        Scene scene=new Scene(body.getChessPane(),560,560);
        //设置场景控制器
        scene.setOnMouseClicked(new Controller(body));
        primaryStage.setTitle("国际象棋0.3");
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image("/res/icon.jpg"));
        primaryStage.show();
    }

    public static void main(String... args){
        System.out.println("hello，我支持判断当前下子方和吃子，你可以试试哦！");
        System.out.println("其他功能正在完善中。。。");
        Application.launch();
    }

}
