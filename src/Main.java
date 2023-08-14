public class Main {
    public static void main(String[] args) {
        HDFC AvyayAcc = new HDFC("Avyay","Avyay123",2000);
        System.out.println(AvyayAcc); //prints attributes via overriding toString()

        //fetch balance
        //incorrect password
        System.out.println(AvyayAcc.fetchBalance("123456"));
        //correct password
        System.out.println(AvyayAcc.fetchBalance("Avyay123"));

        //add money
        System.out.println(AvyayAcc.addMoney(5000.00));

        //withdraw money
        System.out.println(AvyayAcc.withdrawMoney(10000,"Avyay123")); // forcing infsufficient balance
        System.out.println(AvyayAcc.withdrawMoney(2000,"Avyay123")); // checking new balance
        System.out.println(AvyayAcc.withdrawMoney(2000,"Avyay123456")); // wrong password

        //change password
        System.out.println(AvyayAcc.changePassword("Avyay123" , "Avk123"));
        //trying to fetch balance with old password
        System.out.println(AvyayAcc.fetchBalance("Avyay123")); // wrong old password
        System.out.println(AvyayAcc.fetchBalance("Avk123")); // correct new password

        //calculate interest
        System.out.println(AvyayAcc.calculateInterest(2));
        System.out.println(AvyayAcc.addMoney(50000));
        System.out.println(AvyayAcc.calculateInterest(5));
    }
}