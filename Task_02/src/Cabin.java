public class Cabin {
    Passenger passenger1 = new Passenger();
    Passenger passenger2 = new Passenger();
    Passenger passenger3 = new Passenger();

    //***************************************************************************************************************************

    public void setPassenger1(String firstName, String surName){  //set passenger 1's firstname and surname
        passenger1.setFirstName(firstName);
        passenger1.setSurName(surName);
    }
    public String getPassenger1f(){
        return passenger1.getFirstName();
    }  //get passenger 1's first name

    public String getPassenger1s(){
        return passenger1.getSurName();
    }    //get passenger 1's surname

    public void setPassenger1e(double expenses){    //set passenger 1 expenses
        passenger1.setExpenses(expenses);
    }    //set passenger 1 expenses

    public Double getPassenger1e(){
        return passenger1.getExpenses();
    }     //get passenger 1 expenses
    //***************************************************************************************************************************

    public void setPassenger2(String firstName, String surName){   //set passenger 2's firstname and surname
        passenger2.setFirstName(firstName);
        passenger2.setSurName(surName);
    }
    public String getPassenger2f(){
        return passenger2.getFirstName();
    }      //get passenger 2's first name

    public String getPassenger2s(){
        return passenger2.getSurName();
    }        //get passenger 2's surname

    public void setPassenger2e(double expenses){  //set passenger 2 expenses
        passenger2.setExpenses(expenses);
    }     //set passenger 2's expenses

    public Double getPassenger2e(){
        return passenger2.getExpenses();
    }          //get passenger 2's expenses

    //***************************************************************************************************************************

    public void setPassenger3(String firstName, String surName){   //set passenger 3's firstname and surname
        passenger3.setFirstName(firstName);
        passenger3.setSurName(surName);
    }
    public String getPassenger3f(){
        return passenger3.getFirstName();
    }       //get passenger 3's first name

    public String getPassenger3s(){
        return passenger3.getSurName();
    }         //get passenger 3's surname

    public void setPassenger3e( double expenses){  //set passenger 3 expenses
        passenger3.setExpenses(expenses);
    }      //set passenger 3's expenses

    public Double getPassenger3e(){
        return passenger3.getExpenses();
    }        //get passenger 3's expenses

}
