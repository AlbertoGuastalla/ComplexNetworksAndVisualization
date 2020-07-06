public class WelfordAlgorithm {
    private int n = 0;          // number of data values
    private double sum = 0.0;   // sample variance * (n-1)
    private double mu = 0.0;    // sample mean

    public WelfordAlgorithm() {
    }

    public void addDataValue(double x) {
        n++;
        double delta = x - mu;
        mu  += delta / n;
        sum += (double) (n - 1) / n * delta * delta;
    }

    public double mean() {
        return mu;
    }

    public double var() {
        if (n <= 1) return Double.NaN;
        return sum / (n - 1);
    }

    public double stddev() {
        return Math.sqrt(this.var());
    }

    public int count() {
        return n;
    }

    public String toString() {
        return "n = " + n + ", mean = " + mean() + ", stddev = " + stddev();
    }
}