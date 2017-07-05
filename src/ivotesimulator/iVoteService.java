package ivotesimulator;

// interface: iVoteService
// purpose: Different version of iVoteService implements this interface.
public interface iVoteService {
    
    // method: getAcceptSubmission()
    // purpose: Returns a boolean value if the service is open to
    //          accept submissions.
    public boolean getAcceptSubmission();

    // method: submitAnswers()
    // purpose: Allows students to submit their answers.
    public void startSubmission();

    // method: endSubmission()
    // purpose: Ends the submission and counts the last submissions of
    //          students.
    public void endSubmission();

    // method: countAnswers()
    // purpose: Counts the answers that students submitted.
    public void countAnswers(String studentAnwer, String answer, int index);

    // method: printResult()
    // purpose: Prints out the result.
    public void printResult();

}
