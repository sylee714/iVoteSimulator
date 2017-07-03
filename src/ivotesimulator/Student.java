/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ivotesimulator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author MingKie
 */
public class Student {
    
    private String studentID;
    private List answerList;
    private int typeQuestion;
    private List chosenAnswer;
    
    public Student(String studentID, List answerList, int typeQuestion) {
        this.studentID = studentID;
        this.answerList = answerList;
        this.typeQuestion = typeQuestion;
        chosenAnswer = new ArrayList<>();
    }
    
    public String getStudentID() {
        return studentID;
    }
    
     
    public void chooseAnswer() {
        // When student chooses different answer, clear all the
        // elements of choseAsnwer so the last answer will be counted.
        if (!chosenAnswer.isEmpty()) {
            chosenAnswer.clear();
        }
        
        switch (typeQuestion) {
            case 1:
                
                break;
            case 2:
                break;
        }
    }
    
    public List getChosenAnswer() {
        return chosenAnswer;
    }

}
