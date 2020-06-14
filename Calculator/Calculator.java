import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    String originalInput;
    StringBuilder processedInput = null;
    char calculationRulesBODMAS = 'B';

    public Calculator(String maths) {
        this.setOriginalInput(maths);
        // Brackets()
        setCalculationRulesBODMAS('O');
        // Order()
        setCalculationRulesBODMAS('D');
        divide();
        setCalculationRulesBODMAS('M');
        multiply();
        setCalculationRulesBODMAS('A');
        addition();
        setCalculationRulesBODMAS('S');
        substraction();
        setCalculationRulesBODMAS('X');

    }

    public String getOriginalInput() {
        return originalInput;
    }

    public void setOriginalInput(String originalInput) {
        this.originalInput = originalInput;
    }

    public StringBuilder getProcessedInput() {
        return processedInput;
    }

    public void setProcessedInput(StringBuilder processedInput) {
        this.processedInput = processedInput;
    }

    public char getCalculationRulesBODMAS() {
        return calculationRulesBODMAS;
    }

    public void setCalculationRulesBODMAS(char calculationRulesBODMAS) {
        System.out.println(getProcessedInput());
        this.calculationRulesBODMAS = calculationRulesBODMAS;
    }

    public void multiply() {
        StringBuilder stringToProcess = new StringBuilder(getProcessedInput());
        String multiplyPattern = "[0-9]+\\*[0-9]+";
        Pattern brackets = Pattern.compile(multiplyPattern);
        Matcher matcher = brackets.matcher(stringToProcess);
        String temp = null;
        while (matcher.find()) {
            System.out.println("Start : " + stringToProcess);
            int indexStart = matcher.start();
            int indexEnd = matcher.end();
            temp = stringToProcess.substring(indexStart, indexEnd);
            String[] array = temp.split("\\*");
            int value = Integer.parseInt(array[0]) * Integer.parseInt(array[1]);
            stringToProcess.replace(indexStart, indexEnd, Integer.toString(value));
            System.out.println("End : " + stringToProcess);
            matcher = brackets.matcher(stringToProcess);
            value = 0;
        }
        this.processedInput = new StringBuilder(stringToProcess);
    }

    public void divide() {
        StringBuilder stringToProcess = new StringBuilder(getOriginalInput());
        String dividePattern = "[0-9]+/[0-9]+";
        Pattern brackets = Pattern.compile(dividePattern);
        Matcher matcher = brackets.matcher(stringToProcess);
        String temp = null;
        while (matcher.find()) {
            System.out.println("Start : " + stringToProcess);
            int indexStart = matcher.start();
            int indexEnd = matcher.end();
            temp = stringToProcess.substring(indexStart, indexEnd);
            String[] array = temp.split("/");
            int value = Integer.parseInt(array[0]) / Integer.parseInt(array[1]);
            stringToProcess.replace(indexStart, indexEnd, Integer.toString(value));
            System.out.println("End : " + stringToProcess);
            matcher = brackets.matcher(stringToProcess);
            value = 0;
        }
        setProcessedInput(stringToProcess);
    }

    public void addition() {
        StringBuilder stringToProcess = new StringBuilder(getProcessedInput());
        String additionPattern = "[0-9]+\\+[0-9]+";
        Pattern brackets = Pattern.compile(additionPattern);
        Matcher matcher = brackets.matcher(stringToProcess);
        String temp = null;
        while (matcher.find()) {
            System.out.println("Start : " + stringToProcess);
            int indexStart = matcher.start();
            int indexEnd = matcher.end();
            temp = stringToProcess.substring(indexStart, indexEnd);
            String[] array = temp.split("\\+");
            int value = Integer.parseInt(array[0]) + Integer.parseInt(array[1]);
            stringToProcess.replace(indexStart, indexEnd, Integer.toString(value));
            System.out.println("End : " + stringToProcess);
            matcher = brackets.matcher(stringToProcess);
            value = 0;
        }
        this.processedInput = new StringBuilder(stringToProcess);
    }

    public void substraction() {
        StringBuilder stringToProcess = new StringBuilder(getProcessedInput());
        String substractionPattern = "[0-9]+-[0-9]+";
        Pattern brackets = Pattern.compile(substractionPattern);
        Matcher matcher = brackets.matcher(stringToProcess);
        String temp = null;
        while (matcher.find()) {
            System.out.println("Start : " + stringToProcess);
            int indexStart = matcher.start();
            int indexEnd = matcher.end();
            temp = stringToProcess.substring(indexStart, indexEnd);
            String[] array = temp.split("-");
            int value = Integer.parseInt(array[0]) - Integer.parseInt(array[1]);
            stringToProcess.replace(indexStart, indexEnd, Integer.toString(value));
            System.out.println("End : " + stringToProcess);
            matcher = brackets.matcher(stringToProcess);
            value = 0;
        }
        this.processedInput = new StringBuilder(stringToProcess);
    }

    public void checkLHS() {

    }

    public static void main(String[] args) {
        String maths = "3+3/3*2*4+5*5-3";
        maths = "4+5*3+0/3+6*6-4*10-54/2*4"; // suceess
        Calculator calc = new Calculator(maths);
    }
}