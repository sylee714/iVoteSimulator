/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ivotesimulator;

import java.util.Random;

/**
 *
 * @author MingKie
 */
public class RandomNumber {
    
    private Random random;
    private int minimum;
    private int maximum;
    
    public RandomNumber(int minimum, int maximum) {
        random = new Random();
        this.minimum = minimum;
        this.maximum = maximum;
    }
    
    public int getRandomNumber() {
        return random.nextInt(maximum + 1 -minimum) + minimum;
    }
    
}
