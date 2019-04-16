/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokuNow.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import sudokuNow.domain.Sudoku;

/**
 *
 * @author aknu
 */
public class FileSudokuDao {

    FileWriter saveGame;
    FileReader loadGame;
    File saveFile;
    int[][] daoTable;
    ArrayList<String> sudokuChars = new ArrayList();
    Sudoku s;

    public void saveSudoku(int[][] table) throws IOException {

        daoTable = table;
        saveFile = new File(System.getProperty("user.dir") + "/save.xml");
        saveGame = new FileWriter(saveFile);
        saveGame.write(getTableText());
        System.out.println("kirjoitettiin taulukon sisältö");
        saveGame.close();

    }

    public int[][] loadSudoku(int selection) throws IOException {

        s = new Sudoku();

        daoTable = new int[9][9];
        saveFile = new File(System.getProperty("user.dir") + "/save.xml");
        loadGame = new FileReader(saveFile);

        BufferedReader brSave = new BufferedReader(loadGame);
        String whatToRead;

        while ((whatToRead = brSave.readLine()) != null) {
            sudokuChars.add(whatToRead);
        }

        String loadFile = sudokuChars.toString();
        loadFile.trim();
        loadFile = loadFile.replace("[", "");
        loadFile = loadFile.replace("]", "");
        loadFile = loadFile.replace(",", "");
        loadFile = loadFile.replace(" ", "");
        System.out.println("merkkijono nyt: " + loadFile);

        int charAtInd = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                //System.out.println("merkki: " + loadFile.charAt(charAtInd));
                daoTable[i][j] = Character.getNumericValue(loadFile.charAt(charAtInd));
                //System.out.println("merkkin nyt: " + daoTable[i][j]);
                charAtInd++;
            }
        }

        loadGame.close();

        System.out.println("ladattiin taulukon sisältö");

        return daoTable;

    }

    private String getTableText() {
        ArrayList<String> txtStyle = new ArrayList();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                String letter = String.valueOf(daoTable[i][j]);
                txtStyle.add(letter);
            }
        }
        return txtStyle.toString();
    }
}
