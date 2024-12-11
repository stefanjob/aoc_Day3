
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main {
    public static void part2() {
        System.out.println("AoC Day 3 Part 2");

        String regex = "don't\\(\\)|mul\\((\\d+),(\\d+)\\)|do\\(\\)";

        // Compile the pattern
        Pattern pattern = Pattern.compile(regex);

        // Variable to store the sum of products
        long sumOfProducts = 0;

        boolean full = true;
        Scanner scanner = null;
 
        try {
            if (full) {
                scanner = new Scanner(new File("input_full.txt"));
            } else {
                scanner = new Scanner(new File("input_test.txt"));
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        boolean ignore = false;

        while (scanner.hasNextLine()) {
            
            String line = scanner.nextLine();
            System.out.println(line);

            // Match the pattern in the input string
            Matcher matcher = pattern.matcher(line);
 
            // List to store the matches
            List<String> matches = new ArrayList<>();
            
            // Iterate through the matches
            while (matcher.find()) {
                matches.add(matcher.group());
 
                if ("don't()".equalsIgnoreCase(matches.getLast())) {
                    ignore = true;
                } else if ("do()".equalsIgnoreCase(matches.getLast())) {
                    ignore = false;
                } else {
                    if (!ignore) {
                        System.out.println(matches.getLast());
                        // Extract the numbers and calculate the product
                        int num1 = Integer.parseInt(matcher.group(1));
                        int num2 = Integer.parseInt(matcher.group(2));
                        sumOfProducts += num1 * num2;
                        }                
                }
            }

        // Print the sum of products
        System.out.println("Sum of products: " + sumOfProducts);
        }
    }

    public static void part1()
    {
        System.out.println("AoC Day 3 Part 1");
       
        // Variable to store the sum of products
        int sumOfProducts = 0;
 
        // Regular expression to match "mul" followed by (number1,number2)
        String regex = "mul\\((\\d+),(\\d+)\\)";
 
        // Compile the pattern
        Pattern pattern = Pattern.compile(regex);
 
        boolean full = true;
        Scanner scanner = null;
 
        try {
            if (full) {
                scanner = new Scanner(new File("input_full.txt"));
            } else {
                scanner = new Scanner(new File("input_test.txt"));
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
 
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
 
            // Match the pattern in the input string
            Matcher matcher = pattern.matcher(line);
 
            // List to store the matches
            List<String> matches = new ArrayList<>();
 
            // Iterate through the matches
            while (matcher.find()) {
                matches.add(matcher.group());
 
                // Extract the numbers and calculate the product
                int num1 = Integer.parseInt(matcher.group(1));
                int num2 = Integer.parseInt(matcher.group(2));
                sumOfProducts += num1 * num2;
            }
 
            // Print the results
            System.out.println("Matches found:");
            for (String match : matches) {
                System.out.println(match);
            }
        }
 
        // Print the sum of products
        System.out.println("Sum of products: " + sumOfProducts);
    }

    public static void main(String[] args) {
        part2();
    }
}