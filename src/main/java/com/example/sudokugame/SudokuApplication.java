package com.example.sudokugame;

import com.example.sudokugame.buildlogic.SudokuBuildLogic;
import com.example.sudokugame.userinterface.IUserInterfaceContract;
import com.example.sudokugame.userinterface.UserInterfaceImpl;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class SudokuApplication extends Application {
    private IUserInterfaceContract.View uiImpl;
    @Override
    public void start(Stage primaryStage) throws IOException {
       uiImpl = new UserInterfaceImpl(primaryStage);
       try{
           SudokuBuildLogic.build(uiImpl);
       }catch(IOException e){
           e.printStackTrace();
           throw e;
       }
       catch(Exception  e){
           e.printStackTrace();
       }
    }

    public static void main(String[] args) {
        launch();
    }
}