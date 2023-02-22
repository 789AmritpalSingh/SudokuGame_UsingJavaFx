package com.example.sudokugame.problemdomain;

import com.example.sudokugame.computationlogic.SudokuUtilities;
import com.example.sudokugame.constants.GameState;

import java.io.Serializable;

public class SudokuGameClass implements Serializable {
    private final GameState gameState;
    private final int [][] gridState;

    public static final int GRID_BOUNDARY = 9;

    public SudokuGameClass(GameState gameState,int [][]gridState){
        this.gameState = gameState;
        this.gridState = gridState;
    }

    public GameState getGameState() {
        return gameState;
    }

    public int [][] getCopyOfGridState(){
        return SudokuUtilities.copyToNewArray(gridState);
    }
}
