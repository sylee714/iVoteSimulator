package ivotesimulator;

import java.util.Random;

// class: RandomNumber
// purpose: Represents a random number.
public class RandomNumber {
    
    private Random random;
    // Minimum bound
    private int minimum;
    // Maximum bound
    private int maximum;
    
    // constructor: RandomNumber()
    // purpose: Creates a random number object.
    public RandomNumber(int minimum, int maximum) {
        random = new Random();
        this.minimum = minimum;
        this.maximum = maximum;
    }
    
    // method: generateRandomNumber()
    // purpose: Generate a random number within its bounds. 
    public int generateRandomNumber() {
        return random.nextInt(maximum + 1 - minimum) + minimum;
    }
    
}
