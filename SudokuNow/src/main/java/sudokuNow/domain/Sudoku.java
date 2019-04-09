package sudokuNow.domain;

import java.awt.event.ActionListener;
import javafx.application.Application;
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

/**
 *
 * @author aknu
 */
public class Sudoku {

    TextField error;
    TextField txt;
    GridPane base;
    int[][] table = new int[9][9];
    int[][] idArr = new int[9][9];
    int id;
    int badInt;

    public String toString() {
        return "Testitulostus toimii!";
    }

    public Sudoku() {
        /* for (int i = 0; i < 9 ; i++) {
            for (int j = 0; j < 9; j++) {
                table[i][j] = 0;
            }
        }*/

       // makeSudokuEasy();

    }

    public int[][] getTable() {
        return table;
    }

    public void makeSudokuEasy() {
        int[][] easyTable = {
            {0, 0, 0, 6, 0, 2, 0, 0, 7}, {0, 7, 0, 0, 0, 0, 0, 4, 1}, {0, 0, 2, 7, 5, 0, 0, 8, 9},
            {0, 0, 0, 3, 4, 6, 0, 9, 2}, {1, 0, 9, 5, 2, 8, 0, 0, 0}, {0, 4, 3, 0, 0, 0, 0, 6, 0},
            {7, 8, 1, 0, 3, 9, 0, 2, 0}, {9, 3, 4, 0, 6, 5, 7, 1, 8}, {6, 0, 5, 8, 7, 1, 0, 0, 4}

        };
        table = easyTable;
    }

    public void setSudoku(int y, int x, int s) {
        table[y][x] = s;
    }

    public boolean checkSudoku(int y, int x, int s) {
        for (int l = 0; l < 9; l++) {
            if (table[y][l] == s) {
                return false;
            }
        }
        for (int k = 0; k < 9; k++) {
            if (table[k][x] == s) {
                return false;
            }
        }

        y = y - (y % 3);
        x = x - (x % 3);

        for (int yyy = y; yyy < y + 3; yyy++) {
            for (int xxx = x; xxx < x + 3; xxx++) {
                if (table[yyy][xxx] == s) {
                    return false;
                }
            }
        }
        return true;
    }
}
