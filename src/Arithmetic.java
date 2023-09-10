import java.util.regex.Pattern;

public class Arithmetic extends Calculator {
    Arithmetic(Equation equation) {
        super(equation);
        _equation.setMode(Equation.Mode.ARITHMETIC);
    }

    public void calculate() {
        String equation = _equation.getEquation();

        if(Pattern.compile("[x/]").matcher(equation).find(0)) operations(equation);
    }

    private void operations(String equation) {
        String[] operation = equation.split("[x/]", 2);

        int num1 = Integer.parseInt(operation[0].split("[x/+-/rn]")[operation[0].split("[x/+-/rn]").length - 1]);
        int num2 = Integer.parseInt(operation[1].split("[x/+-/rn]", 2)[0]);

        int result = switch(equation.charAt(operation[0].length())) {
            case 'x' -> num1 * num2;
            case '/' -> num1 / num2;
            default -> 0;
        };

        System.out.println(operation[0].substring(0, operation[0].lastIndexOf(operation[0].split("[x/+-/rn]")[operation[0].split("[x/+-/rn]").length - 1]))
            + result + operation[1].substring(operation[1].indexOf(operation[1].split("[x/+-/rn]", 2)[0]) + 1));
    }
}
