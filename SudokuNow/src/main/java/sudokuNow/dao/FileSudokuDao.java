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
 * "FileSudokuDao" is responsible for creating saved data and loading data from
 * a save
 *
 * @author aknu
 */
public class FileSudokuDao {

    FileWriter saveGame;
    FileReader loadGame;
    File saveFile;

    FileWriter saveGame2;
    FileReader loadGame2;
    File saveFile2;

    int[][] daoTable;

    int daoMinutes;
    int daoTime;

    ArrayList<String> sudokuChars = new ArrayList();
    ArrayList<String> timeChars = new ArrayList();

    Sudoku s;

    /**
     * The method saves the Sudoku and the elapsed time at the press of "Save"
     * button. .
     *
     * @param table the array the contains the Sudoku "game state"
     * @param minutes how many minutes have passed since the beginning of the
     * game
     * @param clockTime how many seconds have passed since the beginning of the
     * game
     * @throws IOException This just needs to be here
     */
    public void saveSudoku(int[][] table, int minutes, int clockTime) throws IOException {

        daoTable = table;
        daoMinutes = minutes;
        daoTime = clockTime;
        saveFile = new File(System.getProperty("user.dir") + "/save.xml");
        saveGame = new FileWriter(saveFile);
        saveFile2 = new File(System.getProperty("user.dir") + "/time.xml");
        saveGame2 = new FileWriter(saveFile2);
        saveGame.write(getTableText());
        saveGame2.write(daoMinutes + "," + daoTime);
        System.out.println("kirjoitettiin taulukon sisältö");
        System.out.println("ajan tallennusmuoto: " + daoMinutes + "," + daoTime);
        saveGame.close();
        saveGame2.close();

    }

    /**
     * The method loads the last saved Sudoku "game state" and how long the
     * player has tried to solve it.
     *
     * @param selection the Integer "selection" determines whether we are
     * loading the actual Sudoku or just the time, the loading is conducted in
     * two phases.
     * @return If the loading of the Sudoku-numbers is selected (selection == 1)
     * the method returns daoTable which contains the numbers for Sudoku. If
     * selection != 1, the method returns an array, that contains the minutes
     * and seconds that the player has used solving the Sudoku so far.
     * @throws IOException
     */
    public int[][] loadSudoku(int selection) throws IOException {
        //this method should be divided to two
        s = new Sudoku();

        if (selection == 1) {

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

                    daoTable[i][j] = Character.getNumericValue(loadFile.charAt(charAtInd));

                    charAtInd++;
                }
            }

            loadGame.close();

            System.out.println("ladattiin taulukon sisältö");

            return daoTable;
        } else {

            daoTable = new int[2][2];
            saveFile = new File(System.getProperty("user.dir") + "/time.xml");
            loadGame = new FileReader(saveFile);

            BufferedReader brSave = new BufferedReader(loadGame);
            String whatToRead;

            while ((whatToRead = brSave.readLine()) != null) {
                timeChars.add(whatToRead);
            }

            String loadFile = timeChars.toString();
            loadFile.trim();
            loadFile = loadFile.replace("[", "");
            loadFile = loadFile.replace("]", "");
            loadFile = loadFile.replace(" ", "");

            String[] minutesAndSeconds = loadFile.split(",");

            System.out.println("merkkijono nyt: " + loadFile);

            int i = 0;
            while (i < 2) {
                daoTable[0][i] = Integer.parseInt(minutesAndSeconds[i]);
                i++;
            }

            loadGame.close();

            System.out.println("ladattiin taulukon sisältö");

            return daoTable;
        }

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
