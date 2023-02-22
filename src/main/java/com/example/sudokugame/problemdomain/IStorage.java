package com.example.sudokugame.problemdomain;

import java.io.IOException;

public interface IStorage {
    void updateGameData(SudokuGameClass game) throws IOException;
    SudokuGameClass getGameData() throws IOException;
}
