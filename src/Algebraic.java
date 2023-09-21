/***
 * Used to create an {@code Algebraic Calculator}.
 */
public class Algebraic extends Arithmetic {

    /***
     * The constructor for the {@code Algebraic} class.
     * <p>
     * Calls the {@code setMode()} method to set the expression's mode to {@code ALGEBRAIC}.
     *
     * @param expression description
     */
    Algebraic(Expression expression) {
        super(expression);
        _expression.setMode(Expression.Mode.ALGEBRAIC);
    }

    /***
     * The {@code calculate()} method is used to calculate.
     */
    public String calculate() {
        return null;
    }
}
