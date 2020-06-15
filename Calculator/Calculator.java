import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    String originalInput;
    StringBuilder processedInput = null;
    String calculationRulesBODMAS = "Division";

    public Calculator(String maths) {
        this.setOriginalInput(maths);
        // Brackets()
        // Order()
        divide();
        System.out.println("");
        multiply();
        System.out.println("");
        addition();
        System.out.println("");
        substraction();
        System.out.println("");
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

    public void getCalculationRulesBODMAS() {
        System.out.println(calculationRulesBODMAS);
    }

    public void setCalculationRulesBODMAS(String calculationRulesBODMAS) {
        this.calculationRulesBODMAS = calculationRulesBODMAS;
    }

    public void multiply() {
        setCalculationRulesBODMAS("Multiplication");
        getCalculationRulesBODMAS();
        StringBuilder stringToProcess = new StringBuilder(getProcessedInput());
        String multiplyPattern = "[-]?[0-9]+\\.?[0-9]*\\*[-]?[0-9]+\\.?[0-9]*";
        Pattern brackets = Pattern.compile(multiplyPattern);
        Matcher matcher = brackets.matcher(stringToProcess);
        String temp = null;
        while (matcher.find()) {
            System.out.println("Start : " + stringToProcess);
            int indexStart = matcher.start();
            int indexEnd = matcher.end();
            temp = stringToProcess.substring(indexStart, indexEnd);
            String[] array = temp.split("\\*");
            double value = Double.parseDouble(array[0]) * Double.parseDouble(array[1]);
            stringToProcess.replace(indexStart, indexEnd, Double.toString(value));
            System.out.println("End : " + stringToProcess);
            matcher = brackets.matcher(stringToProcess);
            value = 0;
        }
        this.processedInput = new StringBuilder(stringToProcess);
    }

    public void divide() {
        setCalculationRulesBODMAS("Division");
        getCalculationRulesBODMAS();
        StringBuilder stringToProcess = new StringBuilder(getOriginalInput());
        String dividePattern = "[-]?[0-9]+\\.?[0-9]*/[-]?[0-9]+\\.?[0-9]*";
        Pattern brackets = Pattern.compile(dividePattern);
        Matcher matcher = brackets.matcher(stringToProcess);
        String temp = null;
        while (matcher.find()) {
            System.out.println("Start : " + stringToProcess);
            int indexStart = matcher.start();
            int indexEnd = matcher.end();
            temp = stringToProcess.substring(indexStart, indexEnd);
            String[] array = temp.split("/");
            double value = Double.parseDouble(array[0]) / Double.parseDouble(array[1]);
            stringToProcess.replace(indexStart, indexEnd, Double.toString(value));
            System.out.println("End : " + stringToProcess);
            matcher = brackets.matcher(stringToProcess);
            value = 0;
        }
        setProcessedInput(stringToProcess);
    }

    public void addition() {
        setCalculationRulesBODMAS("Addition");
        getCalculationRulesBODMAS();
        removeAdditionSignStart();
        StringBuilder stringToProcess = new StringBuilder(getProcessedInput());
        String additionPattern = "[-]?[0-9]+\\.?[0-9]*\\+[-]?[0-9]+\\.?[0-9]*";
        Pattern brackets = Pattern.compile(additionPattern);
        Matcher matcher = brackets.matcher(stringToProcess);
        String temp = null;
        while (matcher.find()) {
            System.out.println("Start : " + stringToProcess);
            int indexStart = matcher.start();
            int indexEnd = matcher.end();
            temp = stringToProcess.substring(indexStart, indexEnd);
            String[] array = temp.split("\\+");
            double value = Double.parseDouble(array[0]) + Double.parseDouble(array[1]);
            stringToProcess.replace(indexStart, indexEnd, Double.toString(value));
            System.out.println("End : " + stringToProcess);
            matcher = brackets.matcher(stringToProcess);
            value = 0;
        }
        this.processedInput = new StringBuilder(stringToProcess);
    }

    public void removeAdditionSignStart() {
        setCalculationRulesBODMAS("Plus Removal at Start");
        StringBuilder stringToProcess = new StringBuilder(getProcessedInput());
        String additionStartPattern = "^\\+";
        Pattern brackets = Pattern.compile(additionStartPattern);
        Matcher matcher = brackets.matcher(stringToProcess);
        while (matcher.find()) {
            getCalculationRulesBODMAS();
            System.out.println("Start : " + stringToProcess);
            int indexStart = matcher.start();
            int indexEnd = matcher.end();
            stringToProcess.replace(indexStart, indexEnd, "");
            System.out.println("End : " + stringToProcess);
            matcher = brackets.matcher(stringToProcess);
        }
        this.processedInput = new StringBuilder(stringToProcess);
    }

    public void substractionMinusMinus() {
        setCalculationRulesBODMAS("MinusMinus Removal");
        StringBuilder stringToProcess = new StringBuilder(getProcessedInput());
        String substractionMinusMinusPattern = "--";
        Pattern brackets = Pattern.compile(substractionMinusMinusPattern);
        Matcher matcher = brackets.matcher(stringToProcess);
        while (matcher.find()) {
            getCalculationRulesBODMAS();
            System.out.println("Start : " + stringToProcess);
            int indexStart = matcher.start();
            int indexEnd = matcher.end();
            stringToProcess.replace(indexStart, indexEnd, "+");
            System.out.println("End : " + stringToProcess);
            matcher = brackets.matcher(stringToProcess);
        }
        this.processedInput = new StringBuilder(stringToProcess);
        addition();
    }

    public void substraction() {
        setCalculationRulesBODMAS("Substraction");
        getCalculationRulesBODMAS();
        substractionMinusMinus();
        StringBuilder stringToProcess = new StringBuilder(getProcessedInput());
        String substractionPattern = "[-]?[0-9]+\\.?[0-9]*-[-]?[0-9]+\\.?[0-9]*";
        Pattern brackets = Pattern.compile(substractionPattern);
        Matcher matcher = brackets.matcher(stringToProcess);
        String temp = null;
        while (matcher.find()) {
            getCalculationRulesBODMAS();
            System.out.println("Start : " + stringToProcess);
            int indexStart = matcher.start();
            int indexEnd = matcher.end();
            temp = stringToProcess.substring(indexStart, indexEnd);
            String[] array = temp.split("-");
            double value = Double.parseDouble(array[0]) - Double.parseDouble(array[1]);
            stringToProcess.replace(indexStart, indexEnd, Double.toString(value));
            System.out.println("End : " + stringToProcess);
            matcher = brackets.matcher(stringToProcess);
            value = 0;
        }
        this.processedInput = new StringBuilder(stringToProcess);
        removeAdditionSignStart();
    }

    public static void main(String[] args) {
        String maths = "3+3/3*2*4+5*5-3";
        maths = "4+5*3+0/3-6*-6-4*10-54/2*4";
        // maths = "4.4-2.2/2.2+2*2.1";
        // maths = "6.5-4.3+1";
        // maths = "6.5-4.4/-2";
        maths = "4/-2"; // division test works
        maths = "-4*2"; // multiplication test works
        maths = "-4+-1"; // addition test works
        maths = "+4--5-5";
        Calculator calc = new Calculator(maths);
        // calc.substractionMinusMinus();
        // calc.removeAdditionSignStart();
    }
}