
/**
 * Write a description of class Calculator here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Calculator
{
    // instance variables - replace the example below with your own
    private double standardDeviation;
    private double mean;

    /**
     * Constructor for objects of class Calculator
     */
    public Calculator(double meanInp, double standardDiv)
    {
        // initialise a normal standard deviation
        standardDeviation = standardDiv;
        mean = meanInp;
        System.out.println("A standard normal distribution has been created with mean 0 and s.d. 1.");
    }
    
    public double findProbability(double lowerBound, double upperBound) {
        double probability;
        int nOfStrips = 1000;
        double width = (upperBound - lowerBound) / nOfStrips;
        double sums = sumTrapeziums(lowerBound, upperBound, nOfStrips, width);
        probability = 0.5 * width * (sums);
        if (probability > 1) {
            probability = 1;
        }
        return probability;
    }
    
    private double findYAtX(double x) {
        return 1/(standardDeviation*(Math.sqrt(2*Math.PI))) * Math.exp(-0.5*Math.pow((x - mean)/standardDeviation, 2));
    }
    
    private double sumTrapeziums(double lowerBound, double upperBound, int nStrips, double width) {
        double[] values = new double[nStrips];
        for (int i = 0; i < nStrips; i++) {
            values[i] = findYAtX(lowerBound+i*width);
        }
        double sum = values[0] + values[nStrips-1];
        double sum2 = 0;
        for (int i = 1; i < nStrips - 1; i++) {
            sum2+=values[i];
        }
        sum2*=2;
        return sum+sum2;
    }

    
}
