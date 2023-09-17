import java.util.regex.Pattern;

/***
 * Used to create an {@code Arithmetic Calculator}.
 */
public class Arithmetic extends Calculator {
    private final String regexString = "[\\^?*/+-]";

    /***
     * The constructor for the {@code Arithmetic} class.
     * <p>
     * Calls the {@code setMode()} method to set the expression's mode to {@code ARITHMETIC}.
     * 
     * @param expression
     */
    Arithmetic(Expression expression) {
        super(expression);
        _expression.setMode(Expression.Mode.ARITHMETIC);
    }

    /***
     * The {@code calculate()} method is used to calculate.
     */
    public String calculate(){
        // gets the expression from the Expression class
        String expression = _expression.getEquation();

        // calls getPriorities()
        return getPriorities(expression).replaceAll("\"", "");
    }

    private String getPriorities(String expression){
        System.out.println(expression.replaceAll("\"", ""));

        // checks for parenteses
        while(Pattern.compile("\\((.*)\\)").matcher(expression).find()){
            // replace parenteses content
            expression = expression.replaceFirst(
            Pattern.quote(expression.substring(expression.split("\\([^)]+\\)+", 2)[0].length(), expression.length() - expression.split("\\([^)]+\\)+", 2)[1].length())), 
            // calls getPriorities() which will do a recursion if there are still parenteses
            getPriorities(
            expression.substring(expression.split("\\([^)]+\\)+", 2)[0].length()+1, expression.length() - expression.split("\\([^)]+\\)+", 2)[1].length()-1)));
        }

        // checks for operators
        while(Pattern.compile("[\\^?]").matcher(expression).find()){ expression = operations(expression, "\\^|\\?"); System.out.println(expression); }
        while(Pattern.compile("[*/]").matcher(expression).find()){ expression = operations(expression, "\\*|/"); System.out.println(expression); }
        while(Pattern.compile("[+-]").matcher(expression).find()){ expression = operations(expression, "\\+|-"); System.out.println(expression); }
        
        // returns the expression
        return expression;
    }
    
    private String operations(String expression, String operators){
        
        // instanciates the vars
        String[] operation;
        
        double num1, num2, result;
        
        // splits the expression
        operation = expression.split("(?<=\")" + operators + "(?=\")", 2);
        
        // gets the two numbers to use in the operation
        num1 = Double.parseDouble(operation[0].split("\"")[operation[0].split("\"").length-1]);
        num2 = Double.parseDouble(operation[1].split("\"", 3)[1]);

        // makes the appropriate operation
        result = switch(expression.charAt(operation[0].length())){
            case '^' -> Math.pow(num1, num2);
            case '?' -> (num1 == 2 ? Math.sqrt(num2) : (num1 == 3 ? Math.cbrt(num2) : Math.pow(num2, 1/num1)));
            case '*' -> num1 * num2;
            case '/' -> num1 / num2;
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            default  -> throw new UnknownError();
        };

        // returns the result imbeded in the expression
        return operation[0].substring(0, operation[0].lastIndexOf("\"", operation[0].length()-2)) + // gets the first half of the expression
        "\"" + String.valueOf(result) + "\"" + // returns the result as a String
        operation[1].substring(operation[1].indexOf("\"", 1)+1); // gets the second half of the expression
    }
}
