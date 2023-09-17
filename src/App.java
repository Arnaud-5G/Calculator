public class App {
    public static void main(String[] args) throws Exception {
        Calculator calculator = new Arithmetic(new Expression("3*(1+2)"));
        System.out.println(calculator.calculate());
    }
}
