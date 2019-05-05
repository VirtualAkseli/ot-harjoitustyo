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

import sudokuNow.domain.SudokuMain;

/**
 * "SavingSudokuDao" is responsible for creating saved data and loading data
 * from a save
 *
 * @author aknu
 */
public class SavingSudokuDao {

    FileWriter saveGame;
    FileWriter saveGame2;
    FileWriter saveGameHighScore;

    FileReader loadGame;
    FileReader loadGame2;

    File saveFile;
    File saveFile2;
    File saveFileHighScore;

    int[][] daoTable;
    int[][] daoTimer;
    ArrayList<String> daoList;

    int daoMinutes;
    int daoTime;

    ArrayList<String> sudokuChars = new ArrayList();
    ArrayList<String> timeChars = new ArrayList();
    ArrayList<String> timeCharsScore = new ArrayList();

    SudokuMain s;

    /**
     * The method saves the SudokuMain and the elapsed time at the press of
     * "Save" button. .
     *
     * @param table the array the contains the SudokuMain "game state"
     * @param minutes how many minutes have passed since the beginning of the
     * game
     * @param clockTime how many seconds have passed since the beginning of the
     * game
     *
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
     * Once a sudoku has been finished, this method saves he elapsed time and
     * difficulty of that sudoku.
     *
     * @param mode The difficulty (game mode) of the finished sudoku
     * @param minutes Elapsed minutes
     * @param clockTime Elapsed total seconds.
     *
     */
    public void saveResult(String mode, int minutes, int clockTime) throws IOException {

        daoMinutes = minutes;
        daoTime = clockTime % 60;
        saveFile = new File(System.getProperty("user.dir") + "/highscore.xml");
        saveGameHighScore = new FileWriter(saveFile, true);

        saveGameHighScore.write("|" + mode + ": " + daoMinutes + "," + daoTime);
        System.out.println("kirjoitettiin taulukon sisältö");

        saveGameHighScore.close();

    }

    /**
     * The method loads the last saved SudokuMain "game state"
     *
     *
     * @return the method returns daoTable which contains the numbers for
     * SudokuMain.
     * @throws IOException
     */
    public int[][] loadSudokuTable() throws IOException {

        s = new SudokuMain();

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
    }

    /**
     * The method loads the data for how long the player has tried to solve the
     * Sudoku.
     *
     *
     * @return The method returns an array, that contains the minutes and
     * seconds that the player has used solving the SudokuMain so far.
     * @throws IOException
     */
    public int[][] loadSudokuTimer() throws IOException {

        s = new SudokuMain();
        daoTimer = new int[2][2];
        saveFile2 = new File(System.getProperty("user.dir") + "/time.xml");
        loadGame = new FileReader(saveFile2);

        BufferedReader brSave = new BufferedReader(loadGame);
        String readFromTimer;

        while ((readFromTimer = brSave.readLine()) != null) {
            timeChars.add(readFromTimer);
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
            daoTimer[0][i] = Integer.parseInt(minutesAndSeconds[i]);
            i++;
        }

        loadGame.close();

        System.out.println("ladattiin taulukon sisältö");

        return daoTimer;

    }

    /**
     * The method loads the high score for the "start menu"
     *
     * @return returns an ArrayList containing the durations players have spent
     * solving sudokus
     *
     */
    public String loadHighScore() throws IOException {
        
        s = new SudokuMain();

        daoList = new ArrayList<String>();
        saveFileHighScore = new File(System.getProperty("user.dir") + "/highscore.xml");
        loadGame = new FileReader(saveFileHighScore);

        BufferedReader brSave = new BufferedReader(loadGame);
        String readFromHighScore;

        while ((readFromHighScore = brSave.readLine()) != null) {
            timeCharsScore.add(readFromHighScore);
        }

        String loadFile = timeCharsScore.toString();
        loadFile.trim();
        loadFile = loadFile.replace("[", "");

        loadFile = loadFile.replace("]", "");

        String[] highScoreInfo = loadFile.split("|");

        
        int i = 0;
        while (i < highScoreInfo.length) {
            daoList.add(highScoreInfo[i]);
            i++;
        }

        loadGame.close();

        String highScoreList = daoList.toString();
        System.out.println(highScoreList);
        highScoreList = highScoreList.replace(",,", "min ");
        highScoreList = highScoreList.replace(",", "");
        highScoreList = highScoreList.replace("]", "");
        highScoreList = highScoreList.trim();
        highScoreList = highScoreList.substring(2);
        highScoreList = highScoreList.replace("|", " \n");
        return highScoreList;

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
