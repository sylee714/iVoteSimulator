package ivotesimulator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// class: MCAnswers
// purpose: Implements interface Answers and represents multiple choices
//          type answers.
public class MCAnswers implements Answers {
    
    private List answers;
    
    // constructor: MCAnswers()
    // purpose: Creates a MCAnswers object with the default 
    //          list of answer options. Since it said that we can
    //          configure the candidate answers for each type,
    //          I made a default list with options: A, B, C, D, and E.
    public MCAnswers() {
        answers = new ArrayList<>(Arrays.asList
        ("A", "B", "C", "D", "E"));
    }
    
    // constructor: MCAnswers(List answers)
    // purpose: Creates a MCAnswers object with different 
    //          list of answer options.
    public MCAnswers(List answers) {
        this.answers = answers;
    }
    
    // method: getAnswers()
    // purpose: Returns the list of answer options.
    @Override
    public List getAnswers() {
        return answers;
    }
    
}
