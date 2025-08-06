import java.util.Scanner;


class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        //enter account number
        System.out.printlin ("Enter the account number");
        int accountNumber = scanner.nextInt ();

        //enter service code
        System.out.println("Enter service code (r/R for regular, p/P for premium): ");
        char servicecode = scanner.next().charAt(0);

        //variables
        double amountDue = 0.0;
        int dayMinutes = 0;
        int nightMinutes = 0;

        //calculate bill based on service type
        if(serviceCode == "r" || serviceCode == "R"){

            //regular service
            System.out.println ("Enter number of minutes used: ");
            int totalMinutes = scanner.nextInt();

            amountDue = 10.00; //base fee
            if (totalMinutes > 50){
                amountDue += (totalMinutes - 50) * 0.20; //additional charges
            }
            dayMinutes = totalMinutes; 
        }else if (serviceCode == "p" || serviceCode == "P"){
            //premium service
             System.out.println ("Enter number of minutes used during the day (6:00a.m to 6:00p.m): ");
            dayMinutes = scanner.nextInt();
            System.out.println ("Enter number of minutes used during the night (6:00p.m to 6:00a.m): ");
            nightMinutes = scanner.nextInt();

            amountDue = 25.00; //base fee

            //calculate day charges
            if (dayMinutes > 75){
                amountDue += (dayMinutes - 75) * 0.10; //additional charges
            }

            //calculate night charges
            if(nightMinutes > 100){
                amountDue += (nightMinutes - 100) * 0.05; //additional charges
            }
        }else {
            //invalid service code
            System.out.println ("Error: invalid service code");
            scanner.close();
            return;
        }

        //output the bill details
        System.out.println ("Account number: " + accountNumber);
        System.out.println ("service type: ", (serviceCode == "r" || serviceCode == "R") ? "Regular" : "Premium");
        System.out.println ("Minutes used (day): " + dayMinutes);
        System.out.println ("Minutes used (night): " + nightMinutes);
        System.out.println ("Amount due: " + amountDue);

        scanner.close();
    }
}