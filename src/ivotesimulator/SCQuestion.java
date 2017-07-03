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
public class SCQuestion implements Question{
    
    private final int questionType = 2;

    @Override
    public int getQuestionType() {
        return questionType;
    }
    
}
