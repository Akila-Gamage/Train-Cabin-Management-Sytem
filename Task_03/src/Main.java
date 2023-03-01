import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    static String firstName;
    static String surName;
    static String waitingName;
    static double expenses;
    static int cabinNum = 0;
    static int passengerCount;
    static int count = 12;
    static int waitingCount = 0;
    static Cabin[] ship = new Cabin[12];
    static PassengerQue waitingList = new PassengerQue();

    //***************************************************************************************************************************

    public static void addCustomer() {        //Add customers to the system
        while (true) {
            for (int i = 0; i < ship.length; i++) {
                if (ship[i].getPassenger1f() == "empty"){
                    count = count-1;
                    if(count==0){
                        while (waitingCount<3) {
                            System.out.println("Enter name for cabin :");
                            waitingName = input.next();
                            waitingList.enQueue(waitingName);
                            waitingCount = waitingCount +1;
                        }return;
                    }
                }
                    for (int x = 0; x < ship.length; x++) {
                        if (ship[x].getPassenger1f() == "empty")
                            System.out.println("cabin " + x + " is empty.");
                    }
                    System.out.println("Enter cabin number (0-11) or 12 to go back to main menu:");
                    cabinNum = input.nextInt();
                    if (cabinNum == 12) {
                        return;
                    } else if (cabinNum >= 0 && cabinNum <= 11) {
                        System.out.println("Enter the number of passengers (Max-3): ");
                        passengerCount = input.nextInt();
                        if (passengerCount == 1) {
                            System.out.println("Enter first name of passenger :");
                            firstName = input.next();
                            System.out.println("Enter sur name of passenger :");
                            surName = input.next();
                            System.out.println("Enter the expenses of passenger: ");
                            expenses = input.nextDouble();
                            ship[cabinNum].setPassenger1(firstName, surName);
                            ship[cabinNum].setPassenger1e(expenses);
                        } else if (passengerCount == 2) {
                            System.out.println("Enter first name of passenger 1 :");
                            firstName = input.next();
                            System.out.println("Enter sur name of passenger 1 :");
                            surName = input.next();
                            System.out.println("Enter the expenses of passenger 1: ");
                            expenses = input.nextDouble();
                            ship[cabinNum].setPassenger1(firstName, surName);
                            ship[cabinNum].setPassenger1e(expenses);

                            System.out.println("Enter first name of passenger 2 :");
                            firstName = input.next();
                            System.out.println("Enter sur name of passenger 2 :");
                            surName = input.next();
                            System.out.println("Enter the expenses of passenger 2: ");
                            expenses = input.nextDouble();
                            ship[cabinNum].setPassenger2(firstName, surName);
                            ship[cabinNum].setPassenger2e(expenses);
                        } else if (passengerCount == 3) {
                            System.out.println("Enter first name of passenger 1 :");
                            firstName = input.next();
                            System.out.println("Enter sur name of passenger 1 :");
                            surName = input.next();
                            System.out.println("Enter the expenses of passenger 1: ");
                            expenses = input.nextDouble();
                            ship[cabinNum].setPassenger1(firstName, surName);
                            ship[cabinNum].setPassenger1e(expenses);

                            System.out.println("Enter first name of passenger 2 :");
                            firstName = input.next();
                            System.out.println("Enter sur name of passenger 2 :");
                            surName = input.next();
                            System.out.println("Enter the expenses of passenger 2: ");
                            expenses = input.nextDouble();
                            ship[cabinNum].setPassenger2(firstName, surName);
                            ship[cabinNum].setPassenger2e(expenses);

                            System.out.println("Enter first name of passenger 3 :");
                            firstName = input.next();
                            System.out.println("Enter sur name of passenger 3 :");
                            surName = input.next();
                            System.out.println("Enter the expenses of passenger 3: ");
                            expenses = input.nextDouble();
                            ship[cabinNum].setPassenger3(firstName, surName);
                            ship[cabinNum].setPassenger3e(expenses);
                        }


                    } else {
                        System.out.println("Invalid cabin number enter again: ");
                    }
            }
        }
    }
    //***************************************************************************************************************************

    public static void viewCustomers(){         //view customers in the system
        for (int x = 0; x < ship.length; x++) {
            System.out.println("cabin " + x + " occupied by " + ship[x].getPassenger1f() +" "+ ship[x].getPassenger1s()+","+ship[x].getPassenger2f()+" "+ship[x].getPassenger2s()+","+ship[x].getPassenger3f()+" "+ship[x].getPassenger3s());
        }
        System.out.println();
    }

    //***************************************************************************************************************************

    public static void emptyCabins(){            //view the empty cabins
        for (int x = 0; x < ship.length; x++) {
            if (ship[x].getPassenger1f()=="empty")
                System.out.println("cabin " + x + " is empty.");
        }
    }
    //***************************************************************************************************************************

    public static void deleteData(){             //delete data from the cabins
        System.out.println("Enter cabin number (0-11) to delete :");
        cabinNum = input.nextInt();
        ship[cabinNum].setPassenger1("empty", "null");
        ship[cabinNum].setPassenger2("null","null");
        ship[cabinNum].setPassenger3("null","null");
        for (int x = 0; x < ship.length; x++) {
            System.out.println("cabin " + x + " occupied by " + ship[x].getPassenger1f() +" "+ ship[x].getPassenger1s()+","+ship[x].getPassenger2f()+" "+ship[x].getPassenger2s());
        }
        System.out.println();
    }
    //***************************************************************************************************************************

    public static void findCustomerByName(){       //find cabin no. by 1st passenger's name
        System.out.println("Enter the customer's name to find the cabin: ");
        String search_name = input.next();
        boolean search = false;
        for (int i = 0; i < ship.length; i++) {
            if(search_name.equals(ship[i].getPassenger1f())){
                System.out.println(search_name+" reserved cabin "+i);
                search=true;
                break;
            }
        }
        if(search==false){
            System.out.println("There is no cabin reserved to that name.");
        }
    }
    //***************************************************************************************************************************

    public static void saveData(){         // save cabin data to a file
        int linecount = 0;
        try {
            FileWriter f = new FileWriter("ShipQueue.txt");
            for (int i = 0; i < ship.length; i++) {
                f.write("\n" +linecount+ "-" + ship[i].getPassenger1f() +" "+ ship[i].getPassenger1s()+","+ship[i].getPassenger2f()+" "+ship[i].getPassenger2s());
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

    public static void loadData(){         //print cabin data from a file
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

//    public static void sortCustomers(){         //sort customer names to alphabetical order
//        String temp = null;
//        for (int i = 0; i < ship.length; i++) {
//            for (int j = 1; j < ship.length-i; j++) {
//                if (ship[j-1].getPassenger1().compareTo(ship[j].getPassenger1())>0){
//                    temp = (ship[j-1].getPassenger1());
//                    ship[j-1] = ship[j];
//                    ship[j].getPassenger1() = temp;
//                }
//            }
//        }
//        for (Cabin s: ship){
//            System.out.println(s);
//        }
//    }
    //***************************************************************************************************************************

    public static void totalExpenses(){          // view each passenger's expenses and total expenses of the cabin by cabin no.
        System.out.println("Enter cabin number (0-11) to delete :");
        cabinNum = input.nextInt();
        System.out.println("Passenger 1 expenses: "+ship[cabinNum].getPassenger1e());
        System.out.println("Passenger 2 expenses: "+ship[cabinNum].getPassenger2e());
        System.out.println("Passenger 3 expenses: "+ship[cabinNum].getPassenger3e());

        double totalExpenses = ship[cabinNum].getPassenger1e()+ship[cabinNum].getPassenger2e()+ship[cabinNum].getPassenger3e();
        System.out.println("Total expenses of cabin "+cabinNum+" :"+totalExpenses);
    }
    //***************************************************************************************************************************


    private static void initialise(Cabin[] shipRef)
    {
        for (int x = 0; x < 12; x++ )
            shipRef[x].setPassenger1("empty",".");
        System.out.println( "initialise ");
    }


    //***************************************************************************************************************************

    public static void main(String[] args) {
        ship[0]= new Cabin();
        ship[1]= new Cabin();
        ship[2]= new Cabin();
        ship[3]= new Cabin();
        ship[4]= new Cabin();
        ship[5]= new Cabin();
        ship[6]= new Cabin();
        ship[7]= new Cabin();
        ship[8]= new Cabin();
        ship[9]= new Cabin();
        ship[10]= new Cabin();
        ship[11]= new Cabin();


        initialise(ship);
        String[] optionList = {"A: Add customer to cabin","V: View all cabins","E: Display Empty cabins","D: Delete customer from cabin","F: Find cabin from customer name","S: Store program data into file","L: Load program data from file","O: View passengers Ordered alphabetically by name","T: View total expenses of cabin","Q: Quit"};
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
//                    sortCustomers();
                    break;
                case ("T"):
                case ("t"):
                    totalExpenses();
                    break;
                case ("Q"):
                case ("q"):
                    return;

            }
        }
    }
}
