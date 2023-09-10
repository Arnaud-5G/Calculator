public class Equation {
    private final String _equation;
    private Mode _mode;

    public static enum Mode{
        ARITHMETIC,
        ALGEBRAIC
    }

    Equation(String equation){
        _equation = equation;
    }

    public String getEquation(){
        return _equation;
    }

    public void setMode(Mode mode){
        _mode = mode;
    }
}
