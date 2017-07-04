package ivotesimulator;

// class: MCQuestion
// purpose: Implements interface Question and represents single choice
// question type.
public class SCQuestion implements Question{
    
    // An integer value of 2 to represent single choice question
    // type.
    private final int questionType = 2;

    // method: getQuestionType()
    // purpose: Returns its question type.
    @Override
    public int getQuestionType() {
        return questionType;
    }
    
}
