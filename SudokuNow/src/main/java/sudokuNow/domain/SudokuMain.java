package sudokuNow.domain;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
 *The "SudokuMain" class is responsible for executing all of the logical operations
 needed in the application
 * @author aknu
 */

public class SudokuMain {

    TextField error;
    TextField txt;
    GridPane base;
    int[][] table = new int[9][9];
    int[][] idArr = new int[9][9];
    int id;
    int badInt;
    
    public SudokuMain() {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                table[i][j] = 0;
            }
        }

        
    }
    
    public int[][] getTable() {
        return table;
    }

    public void setTable(int[][] tableNew) {
        this.table = tableNew;
    }
    /**
     * Sets the starting SudokuMain "board" as a preset easy SudokuMain
     * @return returns the newly set SudokuMain "board"
     */
    
    public int[][] makeSudokuEasy() {

        int[][] easyTable = {
            {0, 0, 0, 6, 0, 2, 0, 0, 7}, {0, 7, 0, 0, 0, 0, 0, 4, 1}, {0, 0, 2, 7, 5, 0, 0, 8, 9},
            {0, 0, 0, 3, 4, 6, 0, 9, 2}, {1, 0, 9, 5, 2, 8, 0, 0, 0}, {0, 4, 3, 0, 0, 0, 0, 6, 0},
            {7, 8, 1, 0, 3, 9, 0, 2, 0}, {9, 3, 4, 0, 6, 5, 7, 1, 8}, {6, 0, 5, 8, 7, 1, 0, 0, 4}
        };

        
        return easyTable;
    }
    
    /**
     * Sets the starting SudokuMain "board" as a preset hard SudokuMain
     * @return returns the newly set SudokuMain "board"
     */
    public int[][] makeSudokuHard() {

        int[][] hardTable = {
            {1, 2, 0, 0, 0, 0, 5, 0, 0},
            {0, 0, 6, 0, 0, 0, 0, 0, 0},
            {0, 4, 0, 0, 0, 3, 0, 0, 9},
            {0, 7, 0, 5, 9, 0, 0, 0, 8},
            {0, 0, 0, 2, 0, 0, 0, 0, 0},
            {0, 0, 0, 8, 7, 0, 0, 2, 1},
            {4, 0, 0, 1, 0, 0, 0, 0, 2},
            {0, 0, 0, 0, 5, 0, 6, 0, 0},
            {8, 0, 0, 4, 0, 0, 0, 7, 0}
        };

        
        return hardTable;
    }
    
    /**
     * Input "s" is set to sudoku according to coordinates "y" and "x"
     * @param y self explanatory coordinate
     * @param x self explanatory coordinate
     * @param s player given input for a new number
     */
    public void setSudoku(int y, int x, int s) {
        table[y][x] = s;
    }
    
    /**
     * The method checks the sudoku for errors
     * @param y self explanatory coordinate
     * @param x self explanatory coordinate
     * @param s the player given integer that is tested for errors
     * @return returns false if  there are errors, true otherwise
     */
    public boolean checkSudoku(int y, int x, int s) {
        for (int l = 0; l < 9; l++) {
            if (table[y][l] == s && l != x) {
                System.out.println("vaakavirhe! ristiriita kohdassa y: " + y + " , x: " + l + " lisätty arvo " + s + " löytyy jo!");
                return false;
            }
        }
        for (int k = 0; k < 9; k++) {
            if (table[k][x] == s && k != y) {
                System.out.println("pystyvirhe! ristiriita kohdassa y: " + k + " , x: " + x + " lisätty arvo " + s + " löytyy jo!");
                return false;
            }
        }
        int orgY = y;
        int orgX = x;
        y = y - (y % 3);
        x = x - (x % 3);

        for (int yyy = y; yyy < y + 3; yyy++) {
            for (int xxx = x; xxx < x + 3; xxx++) {
                if (table[yyy][xxx] == s && yyy != orgY && xxx != orgX) {
                    System.out.println("ruutuvirhe! ristiriita kohdassa y: " + yyy + " , x: " + xxx + " lisätty arvo " + s + " löytyy jo!");
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean checkResult() {
        int chkVal;
        boolean result = false;
        for (int i = 0; i < 9 ; i++) {
            for (int j = 0; j < 9 ; j++) {
               chkVal = table[i][j];
               if (chkVal == 0) {
                   return false;
               }
               if (chkVal != 0) {
               result = checkSudoku(i, j, chkVal);
               if (!result) {
                   return false;
               }
               }
            }
        }
        return result;
    }
}
