import exceptions.NegativesNotAllowedException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {

    private String delimiter = ",";

    public int add(String numbers) throws NegativesNotAllowedException {

        if (numbers.length() == 0) return 0;
        if (numbers.length() == 1) return Integer.parseInt(numbers);



        if (numbers.startsWith("//[")){
            int lastIndex = numbers.lastIndexOf("/");

            delimiter = extractCustomDelimiters(numbers, lastIndex);
            numbers = cutAwayDelimiterFromNumbers(numbers, lastIndex);
        }


        List<Integer> numbersList = Arrays.asList(numbers.split(delimiter))
                .stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        negativeNumbersCheck(numbersList);

        numbersList = cleanFromNumbersGreaterOrEqualToThousand(numbersList, 1000);

        return numbersList.stream()
                .reduce(0, Integer::sum);
    }

    private String cutAwayDelimiterFromNumbers(String numbers, int lastIndex) {
        return numbers.substring(lastIndex+1);
    }

    private String extractCustomDelimiters(String numbers, int lastIndex) {
        String customDelimiter = numbers.substring(3,lastIndex-2);
        customDelimiter = customDelimiter.replaceAll("[-.\\+*?\\[^\\]$(){}=!<>|:\\\\]", "\\\\$0");
        return customDelimiter;
    }

    private List<Integer> cleanFromNumbersGreaterOrEqualToThousand(List<Integer> numbersList, int i) {
        return numbersList.stream().filter(integer -> integer < i).collect(Collectors.toList());
    }

    private void negativeNumbersCheck(List<Integer> numbersList) throws NegativesNotAllowedException {
        List<Integer> negativeNumbers = numbersList
                .stream()
                .filter(integer -> integer<0)
                .collect(Collectors.toList());
        if (negativeNumbers.size()!=0) throw new NegativesNotAllowedException(negativeNumbers.toString());
    }

    public static void main(String[] args) throws NegativesNotAllowedException {
        Calculator calculator = new Calculator();
        calculator.add("//[***]//1***2***3");
        calculator.add("//[**+-]//1**+-2**+-3");
    }
}
