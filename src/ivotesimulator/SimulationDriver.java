package ivotesimulator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// class: SimulationDriver
// purpose: Runs the program and tests if it satifies all the requirements.
public class SimulationDriver {
    
    // 1 for multiple choices and 2 for single choice
    private static final int[] QUESTION_TYPES = {1,2};
    private static Student[] students;
    private static Question question;
    private static Answers answers;
    private static iVoteService iVoteService;

    // method: main(String[] args)
    // purpose: Main method to run the program.
    public static void main(String[] args) {
       programEngine();
    }
  
    // method: initializeQuestion()
    // purpose: Randomly chooses a type of question and configues the answers.
    public static void initializeQuestionAnswers() {
        System.out.print("Type of question: ");
        RandomNumber randomNum = new RandomNumber(0, QUESTION_TYPES.length - 1);
        int questionType = QUESTION_TYPES[randomNum.generateRandomNumber()];
        if (questionType == QUESTION_TYPES[0]) {
            question = new MCQuestion();
            answers = new MCAnswers();
            question.setNumberOfAnswersToChoose(answers.getAnswers().size());
            System.out.println("Multiple choices");
        } else {
            question = new SCQuestion();
            answers = new SCAnswers();
            System.out.println("Single choice");
        }
    }
    
    // method: initializeStudents()
    // purpose: Randomly chooses a number of students.
    public static void initializeStudents() {
        // To make testing simple and quick, restricted number of students from
        // 2 to 5.
        RandomNumber randomNum = new RandomNumber(2, 5);
        int numberOfStudents = randomNum.generateRandomNumber();
        students = new Student[numberOfStudents];
        for (int i = 0; i < students.length; ++i) {
            students[i] = new Student(i + "", answers, question);
        }
        System.out.println("Number of students: " + numberOfStudents);
    }
    
    // method: initializeIVoteService()
    // purpose: Initializes iVoteService based on the type of question, answer
    //          list, students.
    public static void initializeIVoteService() {
        iVoteService = new iVoteServiceDesktop(question, answers, students);
    }
    
    // method: initialize()
    // purpose: Calls every initializing method.
    public static void initialize() {
        initializeQuestionAnswers();
        initializeStudents();
        initializeIVoteService();
    }
    
    // method: startSubmission()
    // purpose: Starts to accept submissions from students.
    public static void startSubmission() {
        iVoteService.startSubmission();
        if (iVoteService.getAcceptSubmission()) {
            System.out.println("Submission history: ");
            // Assign a random number to test if only the last submission 
            // of each student is counted. For testing, only 1 to 3 
            // submissions.
            RandomNumber randomNum = new RandomNumber(1,3);
            for (int i = 0; i < students.length; ++i) {
                students[i].printStudentID();
                int numberOfSubmissions = randomNum.generateRandomNumber();
                while (numberOfSubmissions > 0) {
                    students[i].submitAnswer();
                    // Sort student's answer list
                    students[i].sortChosenAnswer();
                    // Prints out each student's answers to check if the 
                    // program works
                    students[i].printChosenAnswer();
                    numberOfSubmissions--;
                }
            } 
        } else {
            System.err.println("Service is not open. "
                    + "Cannot submit answers.");
        }
    }
    
    // method: endSubmission()
    // purpose: Stops accepting submissions from students.
    public static void endSubmission() {
        iVoteService.endSubmission();
    }
    
    // method: printResult()
    // purpose: Prints out the result.
    public static void printResult() {
        iVoteService.printResult();
    }
    
    // method: programEngine()
    // purpose: Calls methods that are needed to complete the program to run
    //          the program.
    public static void programEngine() {
        initialize();
        startSubmission();
        endSubmission();
        printResult();
    }
      
}
