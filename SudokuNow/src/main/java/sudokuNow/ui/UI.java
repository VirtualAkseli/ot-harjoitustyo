/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokuNow.ui;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import sudokuNow.domain.SudokuMain;
import sudokuNow.dao.SavingSudokuDao;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.util.Duration;

/**
 * "UI" class is responsible for building the UI
 *
 * @param table contains the "game state"
 * @param idArr contains an reference id to a certain SudokuMain-slot
 * @param initTable an empty table for assisting the initalising of preset
 * Sudokus
 * @param clockTime seconds from the start of the game
 * @param minutes minutes from the beginning of the game
 * @param timeInfo A table that withholds the minutes and seconds (clockTime)
 * from a savegame
 * @author aknu
 */
public class UI extends Application implements ActionListener {

    TextField error;
    TextField txt;
    GridPane base;

    int[][] table = new int[9][9];
    int[][] idArr = new int[9][9];
    int[][] initTable = new int[9][9];
    int id;
    Scene winScene;
    Scene playScene;
    SudokuMain s;
    SavingSudokuDao dao;
    int clockTime = 0;
    int minutes = 0;
    int[][] timeInfo = new int[2][2];
    Text clock = new Text("00:00");
    
    String whatModeIsThis;
    
    Timeline timeline1;
    Timeline timeline2;

    @Override
    public void init() {
        s = new SudokuMain();
        dao = new SavingSudokuDao();

    }

    @Override
    public void start(Stage mainStage) throws IOException {

        
        
       
        
        //start scene
        StackPane startEle = new StackPane();
        HBox scoreBox = new HBox();
        Button newMode = new Button("New");
        Button easyMode = new Button("Easy");
        Button hardMode = new Button("Hard");
        Button loadGame = new Button("Load");
        Text highScore = new Text("High scores: \n " + dao.loadHighScore());
        highScore.setId("highscorelist");
        clock.setId("titletext");
        VBox loginElements = new VBox();
        Pane baseGame = new Pane();
        baseGame.setMinHeight(740);
        baseGame.setMinWidth(1000);
        startEle.getChildren().add(baseGame);
        loginElements.getChildren().add(newMode);
        loginElements.getChildren().add(easyMode);
        loginElements.getChildren().add(hardMode);
        loginElements.getChildren().add(loadGame);
        loginElements.setAlignment(Pos.CENTER);
        scoreBox.getChildren().add(highScore);
        scoreBox.setAlignment(Pos.CENTER_RIGHT);
        startEle.getChildren().add(scoreBox);
        startEle.getChildren().add(loginElements);

        Scene startScene = new Scene(startEle);

        startScene.getStylesheets().add("custom.css");

        mainStage.setScene(startScene);

        mainStage.setResizable(false);

        
        Image backgImg1 = new Image("background_sud.png");
        Image backgImg2 = new Image("background_sud_v2.png");

        Font coolFont = new Font("MagicCardsNormal.ttf", 30);

        BackgroundSize size = new BackgroundSize(715, 700, false, false, false, false);
        BackgroundImage img2 = new BackgroundImage(backgImg1, null, null, null, size);
        BackgroundImage img3 = new BackgroundImage(backgImg2, null, null, null, size);

        Background back1 = new Background(img2);
        Background back2 = new Background(img3);

        startEle.setBackground(back1);
        
        newMode.setOnAction(e -> {
            whatModeIsThis = "cust";
            timeline1.play();
            timeline2.play();
            mainStage.setScene(playScene);
            
        });
        
        easyMode.setOnAction(e -> {
            System.out.println("nappi toimii");
            initTable = s.makeSudokuEasy();
            whatModeIsThis = "easy";
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    TextField initField = (TextField) (base.getChildren().get(idArr[i][j] - 1).lookup("#child" + (idArr[i][j])));
                    if (initTable[i][j] != 0) {
                        initField.setText(String.valueOf(initTable[i][j]));
                        s.setSudoku(i, j, initTable[i][j]);
                        initField.setDisable(true);
                        initField.setOpacity(1);
                    } else {
                        initField.setText("");
                    }
                }
            }
            timeline1.play();
            timeline2.play();
            mainStage.setScene(playScene);
            
        });

        hardMode.setOnAction(e -> {

            initTable = s.makeSudokuHard();
            whatModeIsThis = "hard";
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    TextField initField = (TextField) (base.getChildren().get(idArr[i][j] - 1).lookup("#child" + (idArr[i][j])));
                    if (initTable[i][j] != 0) {
                        initField.setText(String.valueOf(initTable[i][j]));
                        s.setSudoku(i, j, initTable[i][j]);
                        initField.setDisable(true);
                    } else {
                        initField.setText("");
                    }
                }
            }
            timeline1.play();
            timeline2.play();
            mainStage.setScene(playScene);
            
        });

        loadGame.setOnAction(e -> {

            try {
                table = dao.loadSudokuTable();
                timeInfo = dao.loadSudokuTimer();
            } catch (IOException ex) {
                Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
            }

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    TextField initField = (TextField) (base.getChildren().get(idArr[i][j] - 1).lookup("#child" + (idArr[i][j])));
                    if (table[i][j] != 0) {
                        initField.setText(String.valueOf(table[i][j]));
                    } else {
                        initField.setText("");
                    }
                }
            }
            this.minutes = timeInfo[0][0];
            this.clockTime = timeInfo[0][1];
            System.out.println("Kello nyt:");
            System.out.println(minutes);
            System.out.println(clockTime);
            timeline1.play();
            timeline2.play();
            mainStage.setScene(playScene);
            
        });
        ;

        //play scene
        HBox playElements = new HBox();
        StackPane stack = new StackPane();

        Text title = new Text();
        
        title.setText("Sudoku");
        title.setId("titletext");

        base = new GridPane();
        base.setPadding(new Insets(40, 40, 40, 40));

        stack.getChildren().add(title);
        stack.getChildren().add(base);

        stack.setAlignment(Pos.TOP_CENTER);

        stack.setBackground(back2);
        playElements.setBackground(back1);
        int boxsize = 70;

        error = new TextField();
        error.setVisible(false);
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

                        if (!s.checkSudoku(one, two, Integer.parseInt(nV)) && Integer.parseInt(nV) != 0) {
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
        playElements.getChildren().add(stack);

        VBox buttons = new VBox();

        Button chkBtn = new Button("Check");
        Button resetBtn = new Button("Reset");
        Button saveBtn = new Button("Save");

        error.setText("");
        error.setMaxWidth(90);
        error.setOpacity(1);
        error.setDisable(true);
        error.getStyleClass().add("ok");

        resetBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                for (int i = 0; i < table[0].length; i++) {
                    for (int j = 0; j < table[0].length; j++) {
                        table[i][j] = 0;
                        TextField changedText = (TextField) (base.getChildren().get(idArr[i][j] - 1).lookup("#child" + (idArr[i][j])));
                        changedText.setText("");

                    }
                }
            }
        });

        saveBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try {
                    dao.saveSudoku(table, minutes, clockTime);
                } catch (IOException ex) {
                    Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        chkBtn.setOnAction((ActionEvent e) -> {

            boolean isReady = false;
            isReady = s.checkResult();
            if (isReady) {
                try {
                    dao.saveResult(whatModeIsThis, minutes, clockTime);
                    highScore.setText("");
                    highScore.setText("High scores: \n " + dao.loadHighScore());
                    
                    
                } catch (IOException ex) {
                    Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
                }
                minutes = 0;
                clockTime = 0;
                
                timeline1.stop();
                timeline2.stop();
                mainStage.setScene(startScene);
                
            }
        });

        //minutes = 0;
        
        //clockTime = 0;

        timeline1 = new Timeline(new KeyFrame(
                Duration.millis(1000),
                a -> tickClock()));
        timeline2 = new Timeline(new KeyFrame(
                Duration.millis(60000),
                a -> minutes++));
        timeline1.setCycleCount(Animation.INDEFINITE);
        
        timeline2.setCycleCount(Animation.INDEFINITE);
        

        buttons.getChildren().add(chkBtn);
        buttons.getChildren().add(resetBtn);
        buttons.getChildren().add(saveBtn);
        buttons.getChildren().add(error);

        buttons.getChildren().add(clock);
        buttons.setPadding(new Insets(40, 40, 40, 40));

        playElements.getChildren().add(buttons);
        playScene = new Scene(playElements);
        playScene.getStylesheets().add("custom.css");

        mainStage.show();

    }

    /**
     * Ensures the logic behind ticking of the clock, converts clockTime to
     * seconds after the first minute has passed
     */
    public void tickClock() {
        if (clockTime > 600) {

            clock.setText(clockTime / 60 + ":" + String.valueOf(clockTime % 60));

        }
        if (clockTime > 59) {

            clock.setText("0" + clockTime / 60 + ":" + String.valueOf(clockTime % 60));
            clockTime++;
        }

        if (clockTime < 10) {
            clock.setText("00:0" + String.valueOf(clockTime));
            clockTime++;
        } else if (clockTime < 60) {
            clock.setText("00:" + String.valueOf(clockTime));
            clockTime++;
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
