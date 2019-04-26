/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokuNow.tests;

import java.io.IOException;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import sudokuNow.domain.Sudoku;
import sudokuNow.dao.FileSudokuDao;

/**
 *
 * @author aknu
 */
public class FileSudokuDaoTest {
    @Test
    public void tableGetsSavedTest() throws IOException {

        FileSudokuDao dao = new FileSudokuDao();
        
        Sudoku s1 = new Sudoku();
        s1.setSudoku(0, 0, 3);
        
        int[][] array1 = s1.getTable();
        dao.saveSudoku(array1, 0, 0);
        
        
        int[][] array2 = dao.loadSudoku(1);
        
        assertEquals(array1[0][0], array2[0][0]);

    }
}
