/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokuNow.tests;

import java.io.IOException;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import sudokuNow.domain.SudokuMain;
import sudokuNow.dao.SavingSudokuDao;

/**
 *
 * @author aknu
 */
public class SavingOfSudokuTest {
    @Test
    public void tableGetsSavedTest() throws IOException {
        
        SavingSudokuDao dao = new SavingSudokuDao();
        
        SudokuMain s1 = new SudokuMain();
        s1.setSudoku(0, 0, 3);
        
        int[][] array1 = s1.getTable();
        dao.saveSudoku(array1, 0, 0);
        
        
        int[][] array2 = dao.loadSudokuTable();
        
        assertEquals(array1[0][0], array2[0][0]);
        
    }
}
