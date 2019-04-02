
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
    public void basicTest() {
    
    Sudoku s = new Sudoku();
    String expRes = "Testitulostus toimii!";
    String result = s.toString();
    assertEquals(expRes, result);

    
}
    @Test
    public void arrayTest() {
    
    Sudoku s = new Sudoku();
    s.setSudoku(0, 0, 3);
    
    int[][] array = s.getArray();
    assertEquals(array[0][0], 3);

    
}
}
