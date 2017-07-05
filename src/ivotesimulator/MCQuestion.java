package ivotesimulator;

// class: MCQuestion
// purpose: Implements interface Question and represents multiple choices
// question type.
public class MCQuestion implements Question{
    
    // An integer value of 1 to represent multiple choices question
    // type.
    private final int questionType = 1;

    // method: getQuestionType()
    // purpose: Returns its question type.
    @Override
    public int getQuestionType() {
        return questionType;
    }
    
}
