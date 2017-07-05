package ivotesimulator;

// interface: Question
// purpose: Different type of question implements this interface
public interface Question {
   
   // method: setNumberOfAnswersToChoose(int number)
   // purpose: Sets how many answers that student can choose.
   public void setNumberOfAnswersToChoose(int number); 
   
   // method: getNumberOfOptions()
   // purpose: Returns the number of options.
   public int getNumberOfOptions();
   
}
