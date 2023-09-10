public class Algebraic extends Arithmetic {
    Algebraic(Equation equation) {
        super(equation);
        _equation.setMode(Equation.Mode.ALGEBRAIC);
    }

    public void calculate() {

    }
}
