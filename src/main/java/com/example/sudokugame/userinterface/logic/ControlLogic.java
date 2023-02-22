package com.example.sudokugame.userinterface.logic;

import com.example.sudokugame.computationlogic.GameLogic;
import com.example.sudokugame.constants.GameState;
import com.example.sudokugame.constants.Messages;
import com.example.sudokugame.problemdomain.IStorage;
import com.example.sudokugame.problemdomain.SudokuGameClass;
import com.example.sudokugame.userinterface.IUserInterfaceContract;

import java.io.IOException;

public class ControlLogic implements IUserInterfaceContract.EventListener {

    private IStorage storage;
    private IUserInterfaceContract.View view;


    public ControlLogic(IStorage storage, IUserInterfaceContract.View view){
        this.storage = storage;
        this.view = view;
    }
    @Override
    public void onSudokuInput(int x, int y, int input) {
        try{
            SudokuGameClass gameData  = storage.getGameData();
            int [][] newGridState = gameData.getCopyOfGridState();
            newGridState[x][y] = input;

            gameData = new SudokuGameClass(GameLogic.checkForCompletion(newGridState),
                    newGridState
                    );

            storage.updateGameData(gameData);

            view.updateSquare(x,y,input);

            if(gameData.getGameState()== GameState.COMPLETE){
                view.showDialog(Messages.GAME_COMPLETE);
            }
        }catch(IOException e){
            e.printStackTrace();
            view.showError(Messages.ERROR);
        }
    }

    @Override
    public void onDialogClick() {
        try{
            storage.updateGameData(
                    GameLogic.getNewGame()
            );

            view.updateBoard(storage.getGameData());
        }catch(IOException e){
            view.showError(Messages.ERROR);
        }
    }
}
