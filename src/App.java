public class App {
    public static void main(String[] args) throws Exception {
        // Calculator calculator = new Arithmetic(new Expression("100+10/2*5^2+10^-3"));
        Calculator calculator = new Arithmetic(new Expression("-2*-3.5/2.5"));
        System.out.println(calculator.calculate());
    }
}
