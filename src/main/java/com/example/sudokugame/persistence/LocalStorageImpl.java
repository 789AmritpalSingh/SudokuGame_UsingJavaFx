package com.example.sudokugame.persistence;

import com.example.sudokugame.problemdomain.IStorage;
import com.example.sudokugame.problemdomain.SudokuGameClass;

import java.io.*;

public class LocalStorageImpl implements IStorage {
    private static File GAME_DATA = new File(
            System.getProperty("user.home"),
            "gamedata.txt"
    );

    @Override
    public void updateGameData(SudokuGameClass game) throws IOException {
        try{
            FileOutputStream fileOutputStream = new FileOutputStream(GAME_DATA);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(game);
            objectOutputStream.close();
        }catch(IOException e){
            throw new IOException("Unable to access Game Data");
        }
    }

    @Override
    public SudokuGameClass getGameData() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(GAME_DATA);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        try{
            SudokuGameClass gameState = (SudokuGameClass) objectInputStream.readObject();
            objectInputStream.close();
            return gameState;
        }catch(ClassNotFoundException e){
            e.printStackTrace();
            throw new IOException("File Not Found");
        }
    }
}
