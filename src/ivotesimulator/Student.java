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
        
    // constructor: Student()
    // purpose: Creates a student object.
    public Student(String studentID, Answers answers, Question question ) {
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
    // Only the last submission is counted.
    public void submitAnswer() {
        // When student chooses different answer, clear all the
        // elements of choseAsnwer so the last answer will be counted.
        if (!chosenAnswer.isEmpty()) {
            chosenAnswer.clear();
        }
        // Chooses between multiple choice type or single choice type
        switch (question.getQuestionType()) {
            // Multiple choices type
            case 1:
                // Randomly assign how many options student wants to choose.
                int numChoose = randomNum.generateRandomNumber() + 1;
                Object chosenOption; //
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
                break;
            // Single choice type
            case 2:
                // Randomly choose an option from chosenAnswer list.
                chosenAnswer.add(answers.getAnswers().get(randomNum.
                        generateRandomNumber()));
                break;
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
