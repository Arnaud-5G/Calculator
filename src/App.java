public class App {
    public static void main(String[] args) throws Exception {
        Calculator calculator = new Arithmetic(new Expression("100+10/2*5+10"));
        calculator.calculate();
    }
}
