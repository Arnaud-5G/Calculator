/***
 * The base of all {@code Calculator} subclasses.
 */
public abstract class Calculator {
    protected final Expression _expression;

    /***
     * The constructor for the {@code Calculator} class.
     * 
     * @param expression
     */
    Calculator(Expression expression){
        this._expression = expression;
    }

    /***
     * The {@code calculate()} method is used to calculate.
     */
    public abstract String calculate();
}
