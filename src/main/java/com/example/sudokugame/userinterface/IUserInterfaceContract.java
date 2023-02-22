package com.example.sudokugame.userinterface;

import com.example.sudokugame.problemdomain.SudokuGameClass;

public interface IUserInterfaceContract {
    interface EventListener{
        void onSudokuInput(int x,int y,int input);
        void onDialogClick();
    }

    interface View{
        void setListener(IUserInterfaceContract.EventListener listener);
        void updateSquare(int x,int y,int input);
        void updateBoard(SudokuGameClass game);
        void showDialog(String Message);
        void showError(String message);
    }
}
