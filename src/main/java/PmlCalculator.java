public class PmlCalculator {
    public static double Pmlcalc(double principalMoney, int months, double interestPercent){
        double interestPercentInDecimal = interestPercent/100;
        double iOverTwelve = interestPercentInDecimal/12;
        double addedWithOnePoweredWithMinusMonth = Math.pow((1+iOverTwelve), -months);
        double Pmt = (principalMoney*(iOverTwelve/(1-addedWithOnePoweredWithMinusMonth)));

        return Pmt;
    }
}
