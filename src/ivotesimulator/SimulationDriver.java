/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ivotesimulator;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MingKie
 */
public class SimulationDriver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Answers scAnswers = new SCAnswers();
        System.out.println(scAnswers.getAnswers());
        
        
        List<String> answerList = new ArrayList<>();
        answerList.add("A");
        answerList.add("B");
        answerList.add("C");
        answerList.add("D");
        Student student1 = new Student("123", (List) scAnswers.getAnswers(), 1);
        System.out.println("Answer: " + student1.getChosenAnswer());
    
    }
    
}
