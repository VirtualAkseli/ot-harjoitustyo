package sudokuNow.tests;


import java.io.IOException;
import org.junit.Assert;
import sudokuNow.domain.Sudoku;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author aknu
 */
public class SudokuTest {

    @Test
    public void tableTest() {

        Sudoku s = new Sudoku();
        s.setSudoku(0, 0, 3);

        int[][] array = s.getTable();
        assertEquals(array[0][0], 3);

    }

    @Test
    public void checkSudokuHoriTest() {

        Sudoku s = new Sudoku();
        s.setSudoku(0, 0, 1);
        boolean result = s.checkSudoku(0, 1, 1);

        assertEquals(false, result);

    }
    @Test
    public void checkSudokuVertTest() {

        Sudoku s = new Sudoku();
        s.setSudoku(7, 7, 1);
        boolean result = s.checkSudoku(8, 7, 1);

        assertEquals(false, result);

    }
    @Test
    public void checkSudokuRectTest() {

        Sudoku s = new Sudoku();
        s.setSudoku(3, 3, 1);
        boolean result = s.checkSudoku(5, 5, 1);

        assertEquals(false, result);

    }
    
    @Test
    public void checkSudokuEasyTest() {
        
        Sudoku s = new Sudoku();
        int[][] sudoEasy = {
            {0, 0, 0, 6, 0, 2, 0, 0, 7},
            {0, 7, 0, 0, 0, 0, 0, 4, 1},
            {0, 0, 2, 7, 5, 0, 0, 8, 9},
            {0, 0, 0, 3, 4, 6, 0, 9, 2},
            {1, 0, 9, 5, 2, 8, 0, 0, 0},
            {0, 4, 3, 0, 0, 0, 0, 6, 0},
            {7, 8, 1, 0, 3, 9, 0, 2, 0},
            {9, 3, 4, 0, 6, 5, 7, 1, 8},
            {6, 0, 5, 8, 7, 1, 0, 0, 4}
        };
        
        Assert.assertArrayEquals(sudoEasy, s.makeSudokuEasy());
        
    }
    
    @Test
    public void checkSudokuHardTest() {
        
        Sudoku s = new Sudoku();
        int[][] sudoHard =  {
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
        
        Assert.assertArrayEquals(sudoHard, s.makeSudokuHard());
        
    }
    
   
}
