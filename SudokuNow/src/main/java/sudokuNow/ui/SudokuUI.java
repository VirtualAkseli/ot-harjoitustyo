/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokuNow.ui;


import java.awt.event.ActionListener;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import sudokuNow.domain.Sudoku;
import javafx.scene.layout.Pane;
/**
 *
 * @author aknu
 */
public class SudokuUI extends Application implements ActionListener {
        
    TextField error;
    TextField clock;
    TextField txt;
    GridPane base;
    int[][] table = new int[9][9];
    int[][] idArr = new int[9][9];
    int id;
    int badInt;
    Scene playScene;
    Sudoku s;
    int clockTime;
  
    
    @Override
  public void init() {
      s = new Sudoku();
  }
    
    @Override
    public void start(Stage mainStage) {
        
        
        //login scene
        StackPane startEle = new StackPane();
        Button easyMode = new Button("Easy");
        Pane baseGame = new Pane();
        baseGame.setMinHeight(740);
        baseGame.setMinWidth(1000);
        startEle.getChildren().add(baseGame);
        startEle.getChildren().add(easyMode);
      
        Scene startScene = new Scene(startEle);
        mainStage.setScene(startScene);
        
        mainStage.setResizable(false);
        
        easyMode.setOnAction(e->{
            s.makeSudokuEasy();
            table = s.getTable();
            for (int i = 0; i < 9 ; i++ ) {
                for (int j = 0; j < 9 ; j++) {
                    TextField initField = (TextField) (base.getChildren().get(idArr[i][j] - 1).lookup("#child" + (idArr[i][j])));
                            if (table[i][j] != 0) {
                            initField.setText(String.valueOf(table[i][j]));
                            }
                            else {
                                initField.setText("");
                            }
                }
            }
            mainStage.setScene(playScene);   
}); 
        
        ;
        
        //play scene
        
        HBox elements = new HBox();
        StackPane stack = new StackPane();
        
        Text title = new Text();
        Text title2 = new Text();
        title.setText("Sudoku");
        title.setId("titletext");
        
        base = new GridPane();
        base.setPadding(new Insets(40, 40, 40, 40));
        
        stack.getChildren().add(title);
        stack.getChildren().add(base);
        
        stack.setAlignment(Pos.TOP_CENTER);
        
        int boxsize = 70;
        
        error = new TextField();
        GridPane unit = new GridPane();
        table = s.getTable();
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                id++;
                txt = new TextField();
                txt.setId("child" + id);
                txt.getStyleClass().add("field");
                txt.setMinWidth(30);
                int one = y;
                int two = x;

                idArr[one][two] = id;
                HBox cell = new HBox();
                cell.setPadding(new Insets(5, 5, 5, 5));
                cell.setPrefSize(boxsize, boxsize);
                if (table[y][x] != 0) {
                    int baseValue = table[y][x];
                    txt.setText(String.valueOf(baseValue));
                    
                } else {
                    txt.setText("");
                }
                
                if (y < 3 && x > 2 && x < 6) {
                    txt.setStyle("-fx-background-color: beige");
                }

                if (y > 2 && y < 6 && x < 3) {
                    txt.setStyle("-fx-background-color: beige");
                }
                if (y > 2 && y < 6 && x > 5) {
                    txt.setStyle("-fx-background-color: beige");
                }

                if (y > 5 && x > 2 && x < 6) {
                    txt.setStyle("-fx-background-color: beige");
                }

                txt.textProperty().addListener((oB, oV, nV) -> {

                    error.setText("");
                    error.setVisible(false);


                        if (!nV.matches("\\d*") || nV.matches("")) {
                            TextField asd = (TextField) (base.getChildren().get(idArr[one][two] - 1).lookup("#child" + (idArr[one][two])));

                            asd.setText(nV.replaceAll("[^\\d]", ""));
                            nV = "99" + one;
                        } else {
                            base.getChildren().get(idArr[one][two] - 1).lookup("#child" + (idArr[one][two])).setStyle(base.getChildren().get(idArr[one][two] - 1).lookup("#child" + (idArr[one][two])).getStyle());

                    if (!s.checkSudoku(one, two, Integer.parseInt(nV))) {
                        error.setVisible(true);
                        error.setText("!");
                        error.getStyleClass().add("errortext");
                   };  
                            s.setSudoku(one, two, Integer.parseInt(nV));

                        }
                    
                });

                cell.getChildren().add(txt);

                base.add(cell, x, y);

            }

        }
        base.setOpacity(0.8);
        elements.getChildren().add(stack);
        
        VBox buttons = new VBox();
        
        Button reset = new Button("Reset");
        
        error.setText("");
        error.setMaxWidth(90);
        error.setOpacity(1);
        error.setDisable(true);
        error.getStyleClass().add("ok");
        
        reset.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                for (int i = 0; i< table[0].length; i++) {
                    for (int j = 0; j < table[0].length; j++) {
                        table[i][j] = 0;
                        TextField changedText = (TextField) (base.getChildren().get(idArr[i][j] - 1).lookup("#child" + (idArr[i][j])));
                        changedText.setText("");
                        
                    }
                }
            }
        });
        
        clock = new TextField();
        clockTime = 1;
        clock.setText("00");
        clock.setDisable(true);
                
        buttons.getChildren().add(reset);
        buttons.getChildren().add(error);
        
        buttons.getChildren().add(clock);
        
        elements.getChildren().add(buttons);
        playScene = new Scene(elements);
        /* mainStage.setScene(playScene);
        mainStage.setMinHeight(740);
        mainStage.setMinWidth(1000);
        mainStage.setResizable(false); */
        mainStage.show();
        
        
        
    }
    
    public void update() {
        long now = System.currentTimeMillis();
        
        while (true) {
        
        
        if(System.currentTimeMillis() - 100 > now) {
        if (clockTime > 59) {
          clock.setText(String.valueOf(clockTime/60) + ":" + String.valueOf(clockTime%60));
          clockTime++;
        }
        
        if (clockTime < 10) {
            clock.setText("0" + String.valueOf(clockTime));
            clockTime++;
        } else {
            clock.setText(String.valueOf(clockTime));
            clockTime++;
        } 
        }
        }
        
    }
     
    public static void main(String[] args) {
        
        launch(args);
        
    }
    
   

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}