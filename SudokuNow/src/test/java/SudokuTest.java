
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
    public void easySudokuOkTest() {
        
        Sudoku s = new Sudoku();
        s.makeSudokuEasy();
        int[][] easyTable = s.getTable();
        int result = easyTable[0][8];
        assertEquals(7, result);
        
        
    }
}
