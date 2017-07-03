/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ivotesimulator;

/**
 *
 * @author MingKie
 */
public class iVoteServiceDesktop implements iVoteService{
    
    private Question question;
    private Answers answers;
    private Student[] students;
    private int[] countAnswers;
    
    public iVoteServiceDesktop(Question question, Answers answers, Student[] students) {
        this.question = question;
        this.answers = answers;
        this.students = students;
        countAnswers = new int[answers.getAnswers().size()];
    }
    
    public void submitAnswers() {
        for (int i = 0; i < students.length; ++i) {
            students[i].chooseAnswer();
        }
    }
    
    public void endSubmission() {
        
    }
    
    @Override
    public void printResult() {
        System.out.println("RESULT: ");
        int size = answers.getAnswers().size();
        for (int i = 0; i < size; ++i) {
            System.out.println(answers.getAnswers().get(i) + " : " + countAnswers[i]);
        }
        System.out.println();
    }
    
    
}
