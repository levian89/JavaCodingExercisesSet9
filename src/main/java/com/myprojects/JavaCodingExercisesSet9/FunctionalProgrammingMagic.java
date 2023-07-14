package com.myprojects.JavaCodingExercisesSet9;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FunctionalProgrammingMagic {

    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>(List.of(0));
        System.out.println("Filtering the odd numbers: " + filterOddNumbers(numbers));
        System.out.println("Filtering the odd numbers with FP: " + filterOddNumbersWithFP(numbers));

        Scanner scanner = new Scanner(System.in);
        List<Integer> listFromUser = getAnIntegerListFromUser(scanner);
        System.out.println();
        System.out.println("Filtering the odd numbers in the list provided by user: " + filterOddNumbers(listFromUser));
        System.out.println("Filtering with FP the odd numbers in the list provided by " +
                "user: " + filterOddNumbersWithFP(listFromUser));

        System.out.println("Get cubes of first N numbers: " + getCubesOfFirstNNumbers(4));
        System.out.println("Get cubes with FP of first N numbers: " + getCubesOfFirstNNumbersWithFP(4));

        int nNumberFromUser = getNNumberFromUser(scanner);
        System.out.println("Get cubes of first N numbers, N provided by user: " + getCubesOfFirstNNumbers(nNumberFromUser));
        System.out.println("Get cubes with FP of first N numbers, " +
                "N provided by user: " + getCubesOfFirstNNumbersWithFP(nNumberFromUser));

        List<String> courses = new ArrayList<>(List.of("Math", "Physics", "Computer Science", "Chemistry"));
        System.out.println("The characters count related to each subject is: " + getCourseNameCharacterCount(courses));
        System.out.println("The characters count related to each subject " +
                "with FP is: " + getCourseNameCharacterCountWithFP(courses));

        List<String> aStringArrayListFromUserWithCoursesName = getAStringArrayListFromUserWithCoursesName(scanner);
        System.out.println("The characters count related to each subject from a list " +
                "provided by user is: " + getCourseNameCharacterCount(aStringArrayListFromUserWithCoursesName));
        System.out.println("The characters count related to each subject from a list provided by user " +
                "with FP is: " + getCourseNameCharacterCountWithFP(aStringArrayListFromUserWithCoursesName));

        System.out.println("Sum of squares: " + sumOfSquares(new ArrayList<>(List.of(2, 5, 7))));
        System.out.println("Sum of squares with FP: " + sumOfSquaresWithFP(new ArrayList<>(List.of(2, 5, 7))));
        List<Integer> listFromUser1 = getAnIntegerListFromUser(scanner);
        System.out.println("Sum of squares from the list provided by user: " + sumOfSquares(listFromUser1));
        System.out.println("Sum of squares from the list provided by user with FP: " + sumOfSquaresWithFP(listFromUser1));

        System.out.println("Max from the list: " + findMaxEvenNumber(new ArrayList<>(List.of(-2, 5, -3, 10))));
        System.out.println("Max from the list with FP: " + findMaxEvenNumberWithFP(new ArrayList<>(List.of(-2,5,-3,10))));
        List<Integer> listFromUser2 = getAnIntegerListFromUser(scanner);
        System.out.println("Max from the list provided by user: " + findMaxEvenNumber(listFromUser2));
        System.out.println("Max from the list provided by user with FP: " + findMaxEvenNumberWithFP(listFromUser2));
    }

    private static int getNNumberFromUser(Scanner scanner) {
        System.out.println("Enter the number N till the first N cubes will be displayed:");
        int n = scanner.nextInt();
        return n;
    }

    private static List<Integer> getAnIntegerListFromUser(Scanner scanner) {

        System.out.println("Enter the size of list: ");
        int listSize = scanner.nextInt();
        List<Integer> integers = new ArrayList<>();
        System.out.println("Enter the elements of list: ");
        for (int i = 0; i<listSize; i++) {
            integers.add(scanner.nextInt());
        }
        System.out.println("The elements of the list are: " + integers);
//        System.out.print("The elements of the list are: ");
//        for (int i = 0; i<listSize; i++) {
//            System.out.print(integers.get(i) + " ");
//        }
        return integers;
    }

    private static List<String> getAStringArrayListFromUserWithCoursesName (Scanner scanner) {

        System.out.println("Enter the size of list: ");
        int listSize = scanner.nextInt();
        List<String> courses = new ArrayList<>();
        System.out.println("Enter the elements of list: ");
        for (int i = 0; i<listSize; i++) {
            courses.add(scanner.next());
        }
        System.out.println("The elements of the list are: " + courses);
        return courses;
    }

    public static List<Integer> filterOddNumbers(List<Integer> numbers) {

        List<Integer> oddNumbers = new ArrayList<>();

        for (Integer number:numbers) {
            if (number % 2 !=0) {
                oddNumbers.add(number);
            }
        }
        return oddNumbers;
    }

    public static List<Integer> filterOddNumbersWithFP(List<Integer> numbers) {

        return numbers.stream().filter(number->number % 2 != 0).collect(Collectors.toList());

    }

    public static List<Integer> getCubesOfFirstNNumbers(int n) {

        List<Integer> cubesOfFirstNNumbers = new ArrayList<>();
        if (n<0) {
            throw new IllegalArgumentException ("Input cannot be negative");
        }

        if (n==0) {
            return Collections.emptyList();
        }

        for (int i = 0; i<=n; i++) {
            cubesOfFirstNNumbers.add(i*i*i);
        }

        return cubesOfFirstNNumbers;

    }

    public static List<Integer> getCubesOfFirstNNumbersWithFP(int n) {
        if (n<0) {
            throw new IllegalArgumentException ("Input cannot be negative");
        }

        if (n==0) {
            return Collections.emptyList();
            //or return List.of();
        }

        return IntStream.range(0, n+1).map(e->e*e*e).boxed().collect(Collectors.toList());
    }

    public static List<Integer> getCourseNameCharacterCount(List<String> courses) {

        List<Integer> courseNameCharacterCount = new ArrayList<>();
        for (String course:courses) {
            courseNameCharacterCount.add(course.length());
        }
        return courseNameCharacterCount;
    }

    public static List<Integer> getCourseNameCharacterCountWithFP(List<String> courses) {
        if (courses == null) {
            return List.of();
        }

        return courses.stream().map(String::length).collect(Collectors.toList());
    }

    public static long sumOfSquares(List<Integer> numbers) {

        if (numbers == null) {
            return 0;
        }
        long sumOfSquares = 0;
        for (Integer number:numbers) {
            number = number * number;
            sumOfSquares = sumOfSquares + number;
        }
        return sumOfSquares;
    }

    public static long sumOfSquaresWithFP(List<Integer> numbers) {

        if (numbers == null) {
            return 0;
        }

        return numbers.stream().mapToLong(number -> number * number).sum();
    }

    public static int findMaxEvenNumber(List<Integer> numbers) {
        if (numbers == null) {
            return 0;
        }
        int max=Integer.MIN_VALUE;
        for (Integer number:numbers) {
            if (number%2==0 && number>max) {
                max = number;
            }
        }
        return max;
    }

    public static int findMaxEvenNumberWithFP(List<Integer> numbers) {
        if (numbers == null) {
            return 0;
        }

        Optional<Integer> maxEven = numbers.stream().filter(number->number%2==0).max(Integer::compare);

        return maxEven.orElse(0);
    }
}