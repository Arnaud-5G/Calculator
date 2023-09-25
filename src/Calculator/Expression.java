package Calculator;

import java.util.regex.Pattern;

/***
 * Used to construct the {@code Calculator} class and to stop illegal characters.
 */
public class Expression {
    private String _expression;
    private Mode _mode;

    /***
     * The different modes an {@code Expression} class instance can take :
     * <p>
     * {@code ARITHMETIC}, 
     * {@code ALGEBRAIC}
     */
    public static enum Mode {
        ARITHMETIC,
        ALGEBRAIC
    }

    /***
     * The constructor for the {@code Expression} class.
     *
     * @param expression description
     */
    public Expression(String expression) {
        _expression = expression;
    }

    /***
     * Returns the {@code _expression} variable.
     *
     * @return String
     */
    public String getExpression() {
        return _expression;
    }

    /***
     * Sets the {@code _mode} variable.
     * <p>
     * Calls the {@code simplifyExpression()} method.
     *
     * @param mode description
     */
    public void setMode(Mode mode) {
        if (this._mode == null) {
            this._mode = mode;
            simplifyExpression(mode);
        }
    }

    private void simplifyExpression(Mode mode) {
        // verifies if any illegal characters are inserted according to the mode if there are throw UnsupportedOperationException()
        switch (mode) {
            case ARITHMETIC:
                if (Pattern.compile("[^0-9()^?*/%+-.\"]").matcher(this._expression).find(0))
                    throw new UnsupportedOperationException();
            case ALGEBRAIC:
                if (Pattern.compile("[^0-9a-zA-Z()^?*/%+-.\"]").matcher(this._expression).find(0))
                    throw new UnsupportedOperationException();
        }

        // check if each number is surrounded by double quotes if not add them
        this._expression = this._expression.indexOf('"') != -1 ? this._expression : addDoubleQuotes(this._expression);
    }

    private String addDoubleQuotes(String expression) {
        return this._expression = this._expression
            // add double quotes around each number for negative number compatability
            .replaceAll("(-?(?=\\.[0-9]|[0-9])(?:[0-9]+)?\\.?[0-9]*)(?:[Ee](-?[0-9]+))?", "\"$1\"")
            // if two double quotes are touching each other add an addition
            .replaceAll("\"\"", "\"+\"")
            // if there is no operator between a parentheses and a number consider it as juxtaposition
            .replaceAll("\"(-?(?=\\.[0-9]|[0-9])(?:[0-9]+)?\\.?[0-9]*)(?:[Ee](-?[0-9]+))?\"(\\([^)]+\\))+", "(\"$1\"*$3)")
            .replaceAll("(\\([^)]+\\))+\"(-?(?=\\.[0-9]|[0-9])(?:[0-9]+)?\\.?[0-9]*)(?:[Ee](-?[0-9]+)\")?", "($1*\"$3\")")
            // if there is no operator between two parentheses consider it as juxtaposition
            .replaceAll("((?:\\([^)]+\\))+(?:\\([^)]+\\))+)", "($1)")
            .replaceAll("\\)\\(", ")*(");
    }
}
