package com.example.sudokugame.buildlogic;

import com.example.sudokugame.computationlogic.GameLogic;
import com.example.sudokugame.persistence.LocalStorageImpl;
import com.example.sudokugame.problemdomain.IStorage;
import com.example.sudokugame.problemdomain.SudokuGameClass;
import com.example.sudokugame.userinterface.IUserInterfaceContract;
import com.example.sudokugame.userinterface.logic.ControlLogic;

import java.io.IOException;

public class SudokuBuildLogic {
    public static void build(IUserInterfaceContract.View userInterface) throws Exception{
        SudokuGameClass initialState;
        IStorage storage = new LocalStorageImpl();

        try{
            initialState = storage.getGameData();
        }catch(IOException e){
            initialState = GameLogic.getNewGame();
            storage.updateGameData(initialState);
        }

        IUserInterfaceContract.EventListener uiLogic = new ControlLogic(storage, userInterface);

        userInterface.setListener(uiLogic);
        userInterface.updateBoard(initialState);
    }
}
