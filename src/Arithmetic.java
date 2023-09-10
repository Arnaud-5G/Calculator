import java.util.regex.Pattern;

public class Arithmetic extends Calculator {
    Arithmetic(Equation equation) {
        super(equation);
        _equation.setMode(Equation.Mode.ARITHMETIC);
    }

    public void calculate(){
        String equation = _equation.getEquation();

        if(Pattern.compile("[x/]").matcher(equation).find(0)) operations(equation);
    }
    
    private String operations(String equation){
        String[] operation = equation.split("[x/]", 2);

        int num1 = Integer.valueOf(operation[0].split("[x/+-/r/n]")[operation[0].split("[x/+-/r/n]").length-1]);
        int num2 = Integer.valueOf(operation[1].split("[x/+-/r/n]", 2)[0]);

        int result;

        
        switch(equation.charAt(operation[0].length())){
            case 'x' : result = num1 * num2; break;
            case '/' : result = num1 / num2; break;
            default  : result = 0; break;
        }
        
        System.out.println(operation[0].substring(0, operation[0].lastIndexOf(operation[0].split("[x/+-/r/n]")[operation[0].split("[x/+-/r/n]").length-1])) + result + operation[1].substring(operation[1].indexOf(operation[1].split("[x/+-/r/n]", 2)[0])+1));
        
        return null;
    }
}
