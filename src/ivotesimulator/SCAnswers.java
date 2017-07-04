package ivotesimulator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// class: SCAnswers
// purpose: Implements interface Answers and represents single choice
// type answers.
public class SCAnswers implements Answers {
    
    // Since it said that we can configure the candidate answers for each type,
    // I made a default list with options: 1. True and 2. False.
    private List answers = new ArrayList<>(Arrays.asList
        ("1. True", "2. False"));
    
    // constructor: SCAnswers()
    // purpose: Creates a SCAnswers object with the default 
    // list of answer options.
    public SCAnswers() {
    }
    
    // constructor: SCAnswers()
    // purpose: Creates a SCAnswers object with different 
    // list of answer options.
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
