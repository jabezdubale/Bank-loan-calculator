import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {
    public static String filePath = "LoanCalculatorTestingAssignment.txt";
    public static void CreateAndWriteFile(double principal, int months, double monthlyPayable, double interest) throws IOException {
        FileWriter myObj = new FileWriter(filePath);
        double fullPayable = monthlyPayable*months;
        int yearCounter = 1;
        double remainingPrincipal = principal;
        double monthlyInterest = 0;

        myObj.write("Year and Month \t\t\t Loaned money \t\t Monthly Payment \tPayment in interest \tFull Payment\n");
        myObj.write(months/12+" Years or "+months+" months \t\t"+Rounder.truncateDecimal(principal,2)+"ETB \t\t "+Rounder.truncateDecimal(monthlyPayable,2)+"ETB \t\t"+Rounder.truncateDecimal((fullPayable-principal),2)+"ETB \t\t"+Rounder.truncateDecimal(fullPayable,2)+"\n\n");
        myObj.write("Month \t\tMonthly Payment \tMonthly Interest \tPrincipal payment \tRemaining principal\n");


        for (int i=1; i<=months; i++){
            monthlyInterest = (remainingPrincipal*(interest/100))/12;
            remainingPrincipal -= (monthlyPayable-monthlyInterest);

            myObj.write(i+" months \t"+ Rounder.truncateDecimal(monthlyPayable,3)+"ETB \t\t "+ Rounder.truncateDecimal(monthlyInterest,3)+"ETB \t\t"+ Rounder.truncateDecimal((monthlyPayable-monthlyInterest),3)+"ETB \t\t"+Rounder.truncateDecimal(remainingPrincipal,3)+"\n");

            if (i%12==0){
                myObj.write("#######################  "+yearCounter+" Year Finished."+"  #######################\n\n");
                yearCounter++;
            }
        }
        myObj.close();
    }
}