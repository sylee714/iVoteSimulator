package ivotesimulator;

import java.util.ArrayList;
import java.util.List;

// class: Student
// purpose: Represents a student object with associated fields and methods.
public class Student {
    
    private RandomNumber randomNum; // To generate a random number
    private String studentID; // Student's unique ID
    private Answers answers;
    private Question question;
    private List chosenAnswer; //List of answers that student chose
    //private iVoteService iVoteService;
    
    // constructor: Student()
    // purpose: Creates a student object.
    public Student(String studentID, Answers answers, Question question ) {
        this.studentID = studentID;
        this.answers = answers;
        this.question = question;
        chosenAnswer = new ArrayList<>();
        //this.iVoteService = iVoteService;
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
        // Checks if the iVoteService is open to accept submission
        //if (iVoteService.getAcceptSubmission()) {
            // When student chooses different answer, clear all the
            // elements of choseAsnwer so the last answer will be counted.
            if (!chosenAnswer.isEmpty()) {
                chosenAnswer.clear();
            }
            // Chooses between multiple choice type or single choice type
            switch (question.getQuestionType()) {
                // Multiple choice type
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
        //} else {
            //System.out.println("Service is not open. Cannot submit answers.");
       // }
    }
    
    // method: getChosenAnswer()
    // purpose: Returns the list of answers that student chose.
    public List getChosenAnswer() {
        return chosenAnswer;
    }

}
