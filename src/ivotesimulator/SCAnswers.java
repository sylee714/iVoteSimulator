/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ivotesimulator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author MingKie
 */
public class SCAnswers implements Answers {

    private final List answers = new ArrayList<>(Arrays.asList
        ("1. True", "2. False"));
    
    public SCAnswers() {
    
    }
    
    @Override
    public List getAnswers() {
        return answers;
    }
    
}
