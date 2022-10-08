import java.io.File;
import java.io.IOException;
import java.util.Scanner;



public class App {
    public static void main(String[] args) throws IOException {

        Scanner acceptData = new Scanner(System.in);

        System.out.print("Enter Loan amount: ");
        double principal = acceptData.nextDouble();

        System.out.print("Enter interest rate: ");
        double interest = acceptData.nextDouble();

        System.out.print("Enter Payment period in months: ");
        int months = acceptData.nextInt();

        double monthlyPayable = PmlCalculator.Pmlcalc(principal, months, interest);
        double fullPayable = monthlyPayable*months;
        System.out.println("\nThe monthly payable: "+ Rounder.truncateDecimal(monthlyPayable,2));
        System.out.println("Your full payment in "+months+" months is: "+ Rounder.truncateDecimal(fullPayable,2));
        System.out.println("Your overall Interest payment in "+months+" months is: "+ Rounder.truncateDecimal((fullPayable-principal),2));
        System.out.println("\nFor more Information and Full payment schedule summary check out the file found in your Directory "+ WriteFile.filePath);

        WriteFile.CreateAndWriteFile(principal, months, monthlyPayable, interest);


    }
}
