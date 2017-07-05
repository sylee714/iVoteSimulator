package ivotesimulator;

// class: MCQuestion
// purpose: Implements interface Question and represents single choice
//          question type.
public class SCQuestion implements Question{
    
    // Number of options that students can choose.
    private int numberOfOptions;
    
    // constructor: SCQuestion()
    // purpose: Creates a SCQuestion object and sets the numberOfOptios as
    //          1 since only one option can be chosen in case of single choice type
    //          question.
    public SCQuestion() {
        numberOfOptions = 1;
    }
    
    // method: setNumberOfAnswersToChoose(int number)
    // purpose: Sets how many answers that student can choose.
    //          However, it's not going to be used for this class object because
    //          only one option is allowed for single choice type question. 
    @Override
    public void setNumberOfAnswersToChoose(int number) {
    }
    
    // method: getNumberOfOptions()
    // purpose: Returns the number of options.
    @Override
    public int getNumberOfOptions() {
        return numberOfOptions;
    }

}
