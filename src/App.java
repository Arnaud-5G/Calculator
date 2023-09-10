public class App {
    public static void main(String[] args) throws Exception {
        Calculator calculator = new Arithmetic(new Equation("1+10/2+1"));
        calculator.calculate();
    }
}
