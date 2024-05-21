public class ComplexNumber {
    final public double realFactor;
    final public double imaginaryFactor;

    public ComplexNumber(double realFactor, double imaginaryFactor) {
        this.realFactor = realFactor;
        this.imaginaryFactor = imaginaryFactor;
    }

    public double modulus() {
        return Math.sqrt(Math.pow(realFactor, 2) + Math.pow(imaginaryFactor, 2));
    }

    public ComplexNumber copy() {
        return new ComplexNumber(realFactor, imaginaryFactor);
    }
}
