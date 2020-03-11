import exceptions.NegativesNotAllowedException;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {

    public int add(String numbers) throws NegativesNotAllowedException {

        if (numbers.length() == 0) return 0;
        if (numbers.length() == 1) return Integer.parseInt(numbers);

        List<Integer> numbersList = Arrays.asList(numbers.split(","))
                .stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        negativeNumbersCheck(numbersList);

        return numbersList.stream()
                .reduce(0, Integer::sum);
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
        calculator.add("1,-1,-2");
    }
}
