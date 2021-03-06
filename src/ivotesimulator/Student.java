package ivotesimulator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// class: Student
// purpose: Represents a student object with associated fields and methods.
public class Student {
    
    // To generate a random number
    private RandomNumber randomNum;
    private String studentID;
    private Answers answers;
    private Question question;
    //List of answers that student chose
    private List chosenAnswer;
        
    // constructor: Student(String studentID, Answers answers, 
    //              Question question)
    // purpose: Creates a student object.
    public Student(String studentID, Answers answers, Question question) {
        this.studentID = studentID;
        this.answers = answers;
        this.question = question;
        chosenAnswer = new ArrayList<>();
        randomNum = new RandomNumber(0, answers.getAnswers().size() - 1);
    }
    
    // method: getStudentID()
    // purpose: Returns student's ID.
    public String getStudentID() {
        return studentID;
    }
    
    // method: submitAnswer()
    // purpose: Student chooses and submits his/her answer.
    //          Only the last submission is counted.
    public void submitAnswer() {
        // When student chooses different answer, clear all the
        // elements of choseAsnwer so the last answer will be counted.
        if (!chosenAnswer.isEmpty()) {
            chosenAnswer.clear();
        }
        // Randomly generates a number of options student
        // wants to choose.
        RandomNumber randomNumChoose = new RandomNumber(1, 
                question.getNumberOfOptions());
        int numChoose = randomNumChoose.generateRandomNumber();
        // One option that student chose.
        Object chosenOption;
        while (numChoose > 0) {
            // Randomly choose an option from the answer list.
            chosenOption = answers.getAnswers().
                get(randomNum.generateRandomNumber());
            // Check if the chosen option is already in chosenAnswer
            // list. If not, add it to the list.
            if (!chosenAnswer.contains(chosenOption)) {
                chosenAnswer.add(chosenOption);
                numChoose--;
            }
        }
    }
    
    // method: getChosenAnswer()
    // purpose: Returns the list of answers that student chose.
    public List getChosenAnswer() {
        return chosenAnswer;
    }
    
    // method: sortChosenAnswer() 
    // purpose: Sorts chosenAnswer list in ascending order.
    public void sortChosenAnswer() {
        Collections.sort(chosenAnswer);
    }

    // method: printStudentID()
    // purpose: Prints out student's ID.
    public void printStudentID() {
        System.out.println("ID: " + studentID);
    }
    
    // method: printChosenAnswer()
    // purpose: Prints out chosenAnswer list.
    public void printChosenAnswer() {
        System.out.println(chosenAnswer);
    }
    
}
