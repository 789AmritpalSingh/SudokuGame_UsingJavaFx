package com.example.sudokugame.computationlogic;

import com.example.sudokugame.problemdomain.SudokuGameClass;

public class SudokuUtilities {
    public static void copySudokuArrayValues(int[][] oldArray,int [][] newArray) {
        for(int xIndex = 0; xIndex< SudokuGameClass.GRID_BOUNDARY; xIndex++){
            for(int yIndex = 0; yIndex<SudokuGameClass.GRID_BOUNDARY; yIndex++){
                newArray[xIndex][yIndex] = oldArray[xIndex][yIndex];
             }
        }

    }

    public static int [][] copyToNewArray(int [][] oldArray){
        int [][] newArray = new int[SudokuGameClass.GRID_BOUNDARY][SudokuGameClass.GRID_BOUNDARY];

        for(int xIndex = 0; xIndex< SudokuGameClass.GRID_BOUNDARY; xIndex++){
            for(int yIndex = 0; yIndex<SudokuGameClass.GRID_BOUNDARY; yIndex++){
                newArray[xIndex][yIndex] = oldArray[xIndex][yIndex];
            }
        }
        return newArray;

    }
}
