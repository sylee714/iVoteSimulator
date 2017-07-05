package ivotesimulator;

// class: MCQuestion
// purpose: Implements interface Question and represents multiple choices
// question type.
public class MCQuestion implements Question{
    
    // Number of options that students can choose.
    private int numberOfOptions;
    
    // constructor: MCQuestion()
    // purpose: Creates a MCQuestion type.
    public MCQuestion() {
    }
    
    // method: setNumberOfAnswersToChoose(int number)
    // purpose: Sets how many answers that student can choose.
    @Override
    public void setNumberOfAnswersToChoose(int number) {
        numberOfOptions = number;
    }
    
    // method: getNumberOfOptions()
    // purpose: Returns the number of options.
    @Override
    public int getNumberOfOptions() {
        return numberOfOptions;
    }
    
}
