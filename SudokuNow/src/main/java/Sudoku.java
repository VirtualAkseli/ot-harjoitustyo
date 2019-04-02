
import java.awt.*;
import java.awt.event.*;
import java.io.File;

import java.lang.reflect.Array;
import java.util.*;
import jdk.nashorn.internal.runtime.GlobalFunctions;
import java.util.Scanner;
import java.util.function.UnaryOperator;
import javafx.application.Application;
import javafx.css.CssMetaData;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.Button;
import javafx.scene.control.TextFormatter.Change;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.text.Text;
import javafx.util.StringConverter;

public class Sudoku extends Application implements ActionListener {

    TextField error;
    TextField txt;
    GridPane base;
    int[][] taulukko = new int[9][9];
    int[][] idArr = new int[9][9];
    int id;
    int badInt;
    BackgroundSize size = new BackgroundSize(715, 700, false, false, false, false);
    
    public String toString() {
        return "Testitulostus toimii!";
    }
    
    public Sudoku() {
      
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                taulukko[i][j] = 0;
            }
        }
    }

    private TextFormatter<String> getTextFormatter() {
        UnaryOperator<Change> filter = getFilter();
        TextFormatter<String> textFormatter = new TextFormatter<>(filter);
        return textFormatter;
    }

    private UnaryOperator<Change> getFilter() {
        return change -> {
            String text = change.getText();

            if (text.matches("[a-z]*")) {
                return null;
            }
            return change;
        };
    }
    
    public int[][] getArray() {
        return taulukko;
    }
    
   

    @Override
    public void start(Stage mainStage) {

        Sudoku s = new Sudoku();
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

        TextField error = new TextField();

        GridPane unit = new GridPane();

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
                txt.setText("");
                
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

//                    for (int i = 0; i < 9; i++) {
//                        for (int j = 0; j < 9; j++) {
//                            for (int l = 1; l < 10; l++) {
//                                if (!checkSudoku(i, j, l)) {
//
//                                    error.setText("!");
//                                    error.setVisible(true);
//                                    break;
//                                }
//                            }
//                        }

                        if (!nV.matches("\\d*") || nV.matches("")) {
                            TextField asd = (TextField) (base.getChildren().get(idArr[one][two] - 1).lookup("#child" + (idArr[one][two])));

                            asd.setText(nV.replaceAll("[^\\d]", ""));
                            nV = "99" + one;
                        } else {
                            base.getChildren().get(idArr[one][two] - 1).lookup("#child" + (idArr[one][two])).setStyle(base.getChildren().get(idArr[one][two] - 1).lookup("#child" + (idArr[one][two])).getStyle());

                    if (!checkSudoku(one, two, Integer.parseInt(nV))) {
                        error.setVisible(true);
                        error.setText("!");
                        error.getStyleClass().add("errortext");
//                        base.getChildren().get(idArr[one][two] - 1).lookup("#child" + (idArr[one][two])).setStyle("-fx-background-color: red; -fx-text-fill: white;");
                    };  
                            setSudoku(one, two, Integer.parseInt(nV));

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

                System.out.println("Nappi toimii!");
                for (int i = 0; i < taulukko[0].length; i++) {
                    for (int j = 0; j < taulukko[0].length; j++) {
                        taulukko[i][j] = 0;
                        TextField asd = (TextField) (base.getChildren().get(idArr[i][j] - 1).lookup("#child" + (idArr[i][j])));

                        asd.setText("");

                    }
                }

            }
        });

        buttons.getChildren().add(reset);

        buttons.getChildren().add(error);

        elements.getChildren().add(buttons);

        Scene scene = new Scene(elements);
        
        mainStage.setScene(scene);

        mainStage.setMinHeight(740);
        mainStage.setMinWidth(1000);
        mainStage.setResizable(false);
        mainStage.show();
    }

    public void errorColor(int y, int x) {
        int realInd = (y + 1) * (x + 1);
        System.out.println("hello");

    }

    UnaryOperator<Change> filter = change -> {
        String text = change.getText();

        if (text.matches("[0-9]*")) {
            return change;
        }

        return null;
    };

    public static void main(String[] args) {

        String[][] taulukko = new String[9][9];
        int k = 0;

        launch(args);

        Scanner keyboard = new Scanner(System.in);

        for (int i = 0; i < taulukko[0].length; i++) {
            for (int j = 0; j < taulukko[0].length; j++) {
                taulukko[i][j] = "_";
            }
        }
        for (int i = 0; i < 9; i++) {
            System.out.println("");
            if (i == 3 || i == 6) {
                System.out.println("___________________");
            }
            for (int j = 0; j < taulukko[0].length; j++) {
                System.out.print(taulukko[i][j] + " ");
                if (j == 2 || j == 5) {
                    System.out.print("|");
                }

            }
        }
        while (true) {
            System.out.println("");
            System.out.println("Valitse y akselin rivi, 666 lopettaa: ");

            k = keyboard.nextInt();

            if (k == 666) {
                break;
            }

            System.out.println("Valitse x akselin rivi: ");

            int h = keyboard.nextInt();
            System.out.println("Valitse lisättävä numero: ");

            String add = keyboard.next();

            for (int x = 0; x < 9; x++) {

                if (taulukko[k][x].contains(add)) {
                    System.out.println("Virhe! Numero " + add + " on jo vaakarivillä!");

                }

            }

            for (int y = 0; y < 9; y++) {

                if (taulukko[y][h].contains(add)) {
                    System.out.println(" ");
                    System.out.println("Virhe! Numero " + add + " on jo pystyrivillä!");
                }

            }

            for (int x = (h - (h % 3)); x < h + 3; x++) {

                for (int y = (k - (k % 3)); y < k + 3; y++) {

                    if (taulukko[x][y].contains(add)) {
                        System.out.println(" ");
                        System.out.println("Virhe! Numero " + add + " on jo 3x3 ruudukossa!");
                    }
                }

            }

            taulukko[k][h] = add;
            String wantToFind = taulukko[k][h];

            for (int i = 0; i < 9; i++) {
                System.out.println("");
                if (i == 3 || i == 6) {
                    System.out.println("___________________");
                }
                for (int j = 0; j < taulukko[0].length; j++) {
                    System.out.print(taulukko[i][j] + " ");
                    if (j == 2 || j == 5) {
                        System.out.print("|");
                    }

                }
            }

        }

    }

    public void setSudoku(int y, int x, int s) {
        System.out.println("pystyrivi on : " + y + " vaakarivi on: " + x + " , valittu on: " + s);
//        for (int i = 0; i < 9; i++) {
//            System.out.println("");
//            if (i == 3 || i == 6) {
//                System.out.println("___________________");
//            }
//            for (int j = 0; j < taulukko[0].length; j++) {
//                System.out.print(taulukko[i][j] + " ");
//                if (j == 2 || j == 5) {
//                    System.out.print("|");
//                }
//
//            }
//        }

        taulukko[y][x] = s;

    }

    public boolean checkSudoku(int y, int x, int s) {
        for (int l = 0; l < 9; l++) {

            if (taulukko[y][l] == s) {
                System.out.println("Virhe! Numero " + s + " on jo vaakarivillä!");
                return false;
            }

        }

        for (int k = 0; k < 9; k++) {

            if (taulukko[k][x] == s) {
                System.out.println(" ");
                System.out.println("Virhe! Numero " + s + " on jo pystyrivillä!");
                return false;
            }

        }

//        System.out.println("y " + y + " ja " + (y%3));
//        System.out.println("x " + x + " ja " + (x%3));
//        
        y = y - (y % 3);
        x = x - (x % 3);

        for (int yyy = y; yyy < y + 3; yyy++) {

            for (int xxx = x; xxx < x + 3; xxx++) {
//                System.out.println("yyy on : " + yyy);
//                System.out.println("xxx on : " + xxx);

                if (taulukko[yyy][xxx] == s) {
                    System.out.println(" ");
                    System.out.println("Virhe! Numero " + s + " on jo 3x3 ruudukossa!");
                    return false;
                }
            }

        }
        return true;

    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
