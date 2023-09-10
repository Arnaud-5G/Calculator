public abstract class Calculator {
    protected final Equation _equation;

    Calculator(Equation equation) {
        _equation = equation;
    }

    public abstract void calculate();
}
