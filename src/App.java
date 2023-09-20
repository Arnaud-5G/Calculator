public class App {
    public static void main(String[] args) throws Exception {
        // shows an example code
        Calculator example = new Arithmetic(new Expression("3*(1+2)"));
        System.out.println(example.calculate()); // prints result: 9
    }
}
