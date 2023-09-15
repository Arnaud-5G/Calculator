import java.util.regex.Pattern;

/***
 * Used to construct the {@code Calculator} class and to stop illegal characters.
 */
public class Expression {
    private String _equation;
    private Mode _mode;

    /***
     * The different modes an {@code Expression} class instance can take :
     * <p>
     * {@code ARITHMETIC}, 
     * {@code ALGEBRAIC}
     */
    public static enum Mode{
        ARITHMETIC,
        ALGEBRAIC
    }

    /***
     * The constructor for the {@code Expression} class.
     * 
     * @param expression
     */
    Expression(String expression){
        _equation = expression;
    }

    /***
     * Returns the {@code _expression} variable.
     * 
     * @return String
     */
    public String getEquation(){
        return _equation;
    }

    /***
     * Sets the {@code _mode} variable.
     * <p>
     * Calls the {@code verifyExpression()} method.
     * 
     * @param mode
     */
    public void setMode(Mode mode){
        verifyExpression(mode);
        this._mode = mode;
    }

    private void verifyExpression(Mode mode){
        if(mode == Mode.ARITHMETIC && _mode != Mode.ARITHMETIC){
            if(Pattern.compile("[^0-9\\(\\)\\^?*/+-\\.]").matcher(this._equation).find(0)) throw new UnsupportedOperationException();
            this._equation = this._equation.replaceAll("([-]?(?=\\.[0-9]|[0-9])(?:[0-9]+)?(?:\\.?[0-9]*))(?:[Ee]([-]?[0-9]+))?", "\"$1\"");
            this._equation = this._equation.replaceAll("\"\"", "\"+\"");
        }
        else if(mode == Mode.ALGEBRAIC && _mode != Mode.ALGEBRAIC){
            if(Pattern.compile("[^0-9a-zA-Z\\(\\)\\^?*/+-\\.]").matcher(this._equation).find(0)) throw new UnsupportedOperationException();
        }
    }
}
