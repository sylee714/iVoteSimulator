/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ivotesimulator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author MingKie
 */
public class SimulationDriver {
    
    // 1 for multiple choices and 2 for single choice
    private static final int[] QUESTION_TYPES = {1,2};
    private static Student[] students;
    private static Question question;
    private static Answers answers;
    private static iVoteService iVoteService;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       programEngine();
    }
  
    public static void initializeQuestion() {
        RandomNumber randomNum = new RandomNumber(0, QUESTION_TYPES.length - 1);
        int questionType = QUESTION_TYPES[randomNum.generateRandomNumber()];
        if (questionType == QUESTION_TYPES[0]) {
            question = new MCQuestion();
            System.out.println("Multiple choices question.");
        } else {
            question = new SCQuestion();
            System.out.println("Single choice question.");
        }
    }
    
    public static void initializeAnswers() {
        if (question.getQuestionType() == QUESTION_TYPES[0]) {
            answers = new MCAnswers();
        } else {
            answers = new SCAnswers();
        }
    }
    
    public static void initializeStudents() {
        RandomNumber randomNum = new RandomNumber(2, 10);
        int numberOfStudents = randomNum.generateRandomNumber();
        students = new Student[numberOfStudents];
        for (int i = 0; i < students.length; ++i) {
            students[i] = new Student(i + "", answers, question);
        }
        System.out.println("Number of students: " + numberOfStudents);
    }
    
    public static void initializeIVoteService() {
        iVoteService = new iVoteServiceDesktop(question, answers, students);
    }
    
    public static void initialize() {
        initializeQuestion();
        initializeAnswers();
        initializeStudents();
        initializeIVoteService();
    }
    
    public static void startSubmission() {
        iVoteService.startSubmission();
        if (iVoteService.getAcceptSubmission()) {
            RandomNumber randomNum = new RandomNumber(1,3);
            for (int i = 0; i < students.length; ++i) {
                // Assign a random number to test if only the last submission 
                // of each student is counted. For testing, only 1 to 3 submissions.
                int numberOfSubmissions = randomNum.generateRandomNumber();
                while (numberOfSubmissions > 0) {
                    students[i].submitAnswer();
                    numberOfSubmissions--;
                }
            } 
            } else {
                System.err.println("Service is not open. Cannot submit answers.");
            }
    }
    
    public static void endSubmission() {
        iVoteService.endSubmission();
    }
    
    public static void printResult() {
        iVoteService.printResult();
    }
    
    public static void programEngine() {
        initialize();
        startSubmission();
        endSubmission();
        printResult();
    }
    
    
}
