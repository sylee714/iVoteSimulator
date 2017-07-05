package ivotesimulator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// class: SCAnswers
// purpose: Implements interface Answers and represents single choice
//          type answers.
public class SCAnswers implements Answers {
    
    private List answers;
    
    // constructor: SCAnswers()
    // purpose: Creates a SCAnswers object with the default 
    //          list of answer options: 1. True and 2. False.
    public SCAnswers() {
        answers = new ArrayList<>(Arrays.asList
        ("1. True", "2. False"));
    }
    
    // constructor: SCAnswers(List answers)
    // purpose: Creates a SCAnswers object with different 
    //          list of answer options.
    public SCAnswers(List answers) {
        this.answers = answers;
    }
    
    // method: getAnswers()
    // purpose: Returns list of answer options.
    @Override
    public List getAnswers() {
        return answers;
    }
    
}
