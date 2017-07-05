package ivotesimulator;

// class: iVoteServiceDesktop
// purpose: Implements iVoteService and represents the desktop version
// of iVoteService.
public class iVoteServiceDesktop implements iVoteService{
    
    // To indicate if the service is ready to accept submission.
    private boolean acceptSubmission;
    private Question question;
    private Answers answers;
    private Student[] students;
    // Array of integers to keep track of how many times each option was
    // selected.
    private int[] answerCount;
    
    // constructor: iVoteServiceDesktop()
    // purpose: Creates a iVoteServiceDesktop object.
    public iVoteServiceDesktop(Question question, Answers answers, 
            Student[] students) {
        this.question = question;
        this.answers = answers;
        this.students = students;
        answerCount = new int[answers.getAnswers().size()];
        initializeCountAnswers();
        acceptSubmission = false;
    }
    
    // method: initializeCounterAnswers()
    // purpose: initialize each value of answerCount as 0.
    private void initializeCountAnswers() {
        for (int i = 0; i < answerCount.length; ++i) {
            answerCount[i] = 0;
        }
    }
    
    // method: getAcceptSubmission()
    // purpose: Returns a boolean value if the service is open to
    // accept submissions.
    @Override
    public boolean getAcceptSubmission() {
        return acceptSubmission;
    }
    
    // method: submitAnswers()
    // purpose: Allows students to submit their answers.
    @Override
    public void startSubmission() {
        acceptSubmission = true;
    }
    
    // method: endSubmission()
    // purpose: Ends the submission and counts the last submissions of
    // students.
    @Override
    public void endSubmission() {
        acceptSubmission = false;
        System.out.println("Students' answers: ");
        // For-loop to go through each student 
        for (int i = 0; i < students.length; ++i) {
            // Prints out each student's answers to check if the program works
            students[i].printStudentID();
            students[i].printChosenAnswer();
            // For-loop to go through each answer that student chose
            for (int j = 0; j < students[i].getChosenAnswer().size(); ++j) {
                // For-loop to go through each option in the answer list
                for (int k = 0; k < answers.getAnswers().size(); ++k) {
                    // Call countAnswers to compare
                    countAnswers((String) students[i].getChosenAnswer().get(j), 
                            (String) answers.getAnswers().get(k), k);
                }
            }
        }
    }
 
    // method: countAnswers()
    // purpose: Counts the answers that students submitted.
    @Override
    public void countAnswers(String studentAnwer, String answer, int index) {
        if (studentAnwer.equals(answer)) {
            answerCount[index]++;
        }
    }
    
    // method: printResult()
    // purpose: Prints out the result.
    @Override
    public void printResult() {
        System.out.println("RESULT: ");
        int size = answers.getAnswers().size();
        for (int i = 0; i < size; ++i) {
            System.out.println(answers.getAnswers().get(i) + " : " 
                    + answerCount[i]);
        }
        System.out.println();
    }
    
}
