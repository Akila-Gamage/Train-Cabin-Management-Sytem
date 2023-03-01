import java.io.*;
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    static String cabinName;
    static int cabinNum = 0;
    static String[] ship = new String[12];

    //***************************************************************************************************************************

    public static void addCustomer() {    //Add customers to the system
        while (true) {
            for (int x = 0; x < ship.length; x++) {
                if (ship[x].equals("empty"))
                    System.out.println("cabin " + x + " is empty");
            }
            System.out.println("Enter cabin number (0-11) or 12 to go back to main menu:");
            cabinNum = input.nextInt();
            if (cabinNum == 12){
                return;
            }else if (cabinNum>=0 && cabinNum<=11){
                System.out.println("Enter name for cabin " + cabinNum + " :");
                cabinName = input.next();
                ship[cabinNum]= cabinName;
            }else {
                System.out.println("Invalid cabin number enter again: ");
            }
        }
    }
    //***************************************************************************************************************************

    public static void viewCustomers(){      //view customers in the system
        for (int x = 0; x < ship.length; x++) {
            System.out.println("cabin " + x + " occupied by " + ship[x]);
        }
        System.out.println();
    }
    //***************************************************************************************************************************

    public static void emptyCabins(){       //view the empty cabins
        for (int x = 0; x < ship.length; x++) {
            if (ship[x].equals("empty"))
                System.out.println("cabin " + x + " is empty");
        }
    }
    //***************************************************************************************************************************

    public static void deleteData(){      //delete data from the cabins
        System.out.println("Enter cabin number (0-12) to delete :");
        cabinNum = input.nextInt();
        ship[cabinNum] = "empty";
        for (int x = 0; x < ship.length; x++) {
            System.out.println("cabin " + x + " occupied by " + ship[x]);
        }
        System.out.println();
    }
    //***************************************************************************************************************************

    public static void findCustomerByName(){      //find cabin no. by customer's name
        System.out.println("Enter the customer's name to find the cabin: ");
        String search_name = input.next();
        boolean search = false;
        for (int i = 0; i < ship.length; i++) {
            if(search_name.equals(ship[i])){
                System.out.println(search_name+" reserved cabin" + i);
                search=true;
                break;
            }
        }
        if(search==false){
            System.out.println("There is no cabin reserved to that name.");
        }
    }
    //***************************************************************************************************************************

    public static void saveData(){      // save cabin data to a file
        int linecount = 0;
        try {
            FileWriter f = new FileWriter("ShipQueue.txt");
            for (int i = 0; i < ship.length; i++) {
                f.write("\n" +linecount+ "-" + ship[i]);
                linecount++;
            }
            f.close();
            System.out.println("*******Successfully wrote ship queue data to the text file*******");
            }
        catch (IOException e){
            System.out.println("An error occurred");
        }
    }
    //***************************************************************************************************************************

    public static void loadData(){       //print cabin data from a file
        try{
            File file = new File("ShipQueue.txt");
            Scanner rf = new Scanner(file);
            String fileline;
            while (rf.hasNext()){
                fileline = rf.nextLine();
                System.out.println(fileline);

            }rf.close();
        }catch (IOException e){
            System.out.println("Error IOException is: "+e);
        }

    }
    //***************************************************************************************************************************

    public static void sortCustomers(){     //sort customer names to alphabetical order
        String temp = null;
        for (int i = 0; i < ship.length; i++) {
            for (int j = 1; j < ship.length-i; j++) {
                if (ship[j-1].compareToIgnoreCase(ship[j])>0){
                    temp = ship[j-1];
                    ship[j-1] = ship[j];
                    ship[j] = temp;
                }
            }
        }for (String s: ship){
            System.out.println(s);
        }
    }
    //***************************************************************************************************************************

    private static void initialise( String shipRef[])
    {
        for (int x = 0; x < 12; x++ )
            shipRef[x] = "empty";
        System.out.println( "initialise ");
    }

    //***************************************************************************************************************************

    public static void main(String[] args) {
        initialise(ship);
        String[] optionList = {"A: Add customer to cabin","V: View all cabins","E: Display Empty cabins","D: Delete customer from cabin","F: Find cabin from customer name","S: Store program data into file","L: Load program data from file","O: View passengers Ordered alphabetically by name","Q: Quit"};
        while (true) {
            System.out.println("|---------------HALO CRUISE SHIP--------------|");
            System.out.println("-------------Please select a option------------");
            for (int i = 0; i < optionList.length; i++) {
                System.out.println(optionList[i]);
            }
            System.out.println("Enter the option Letter: ");
            String menu = input.next();
            switch (menu) {
                case ("A"):
                case ("a"):
                    addCustomer();
                    break;
                case ("V"):
                case ("v"):
                     viewCustomers();
                     break;
                case ("E"):
                case ("e"):
                    emptyCabins();
                    break;
                case ("D"):
                case ("d"):
                    deleteData();
                    break;
                case ("F"):
                case ("f"):
                    findCustomerByName();
                    break;
                case ("S"):
                case ("s"):
                    saveData();
                    break;
                case ("L"):
                case ("l"):
                    loadData();
                    break;
                case ("O"):
                case ("o"):
                    sortCustomers();
                    break;
                case ("Q"):
                case ("q"):
                    return;

            }
        }
    }

}

