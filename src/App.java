import Calculator.*;

public class App {
    public static void main(String[] args) throws Exception {
        // shows an example code
        Calculator example = new Arithmetic(new Expression("6/2(1+2)"));
        System.out.println("result: " + example.calculate()); // result: 1
    }
}
