import java.util.Scanner;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors

class VaccineCenterExtended {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("=========================================================");
        System.out.println("100 or VVB: View all Vaccination Booths");
        System.out.println("101 or VEB: View all Empty Booths");
        System.out.println("102 or APB: Add Patient to a Booth");
        System.out.println("103 or RPB: Remove Patient from a Booth");
        System.out.println("104 or VPS: View Patients Sorted in alphabetical order");
        System.out.println("105 or SPD: Store Program Data into file");
        System.out.println("106 or LPD: Load Program Data from file");
        System.out.println("107 or VRV: View Remaining Vaccinations");
        System.out.println("108 or AVS: Add Vaccinations to the Stock");
        System.out.println("999 or EXT: Exit the Program");
        System.out.println("=========================================================");
        String[] ServiceCenter = new String[6];
        String[] Surname = new String[6];
        int vaccines = 150;
        String instruct;
        String Vacc;


        for (int i = 0; i < ServiceCenter.length; i++) {
            ServiceCenter[i] = "Empty";
        }


        while (true) {
            System.out.print("Enter a Input:");
            instruct = input.next();
            if (instruct.equals("VVB") || instruct.equals("100")) { // a view all booths
                System.out.println("All Vaccination Booths");
                for (int i = 0; i < ServiceCenter.length; i++) {
                    System.out.println("Booth " + (i) + ":" + ServiceCenter[i]);
                }

            }

            if (instruct.equals("VEB") || instruct.equals("101")) { // view only empty booths
                System.out.println("All Empty Booths");
                printname();
                for (int i = 0; i < ServiceCenter.length; i++) {
                    if (ServiceCenter[i] == "Empty") {
                        System.out.println("Booth " + (i) + ":" + ServiceCenter[i]);
                    }
                }

            }
            if(instruct.equals("APB") || instruct.equals("102")){ // add a patient
                System.out.print("Enter Vaccine Name:"); // user input of vaccine
                Vacc=input.next();

                if(Vacc.equals("AstraZeneca")){ //check vaccine
                    System.out.println("Enter Booth Number 0,1");
                    int i=input.nextInt();
                    if(i==0 || i==1){//check the correct booth
                        if(ServiceCenter[i]!="Empty"){ //check booth is empty or not
                            System.out.println("A Patient is in this Booth");
                        }
                        if(ServiceCenter[i]=="Empty"){
                            System.out.print("Enter Patient First Name:"); //used arrays to store data
                            ServiceCenter[i]=input.next();
                            System.out.print("Enter Patient  Surname:");
                            Surname[i]=input.next();
                            vaccines--;
                        }

                    }
                    else{
                        System.out.println("Enter Correct Booth Number");
                    }
                }
                if(Vacc.equals("Sinopharm")){ //check the vaccine
                    System.out.println("Enter Booth Number 2,3");
                    int i=input.nextInt();
                    if(i==2 || i==3){ //check the correct booth
                        if(ServiceCenter[i]!="Empty"){
                            System.out.println("A Patient is in this Booth:");
                        }
                        if(ServiceCenter[i]=="Empty"){
                            System.out.print("Enter Patient First Name:");
                            ServiceCenter[i]=input.next();
                            System.out.print("Enter Patient  Surname:"); //use arrays to store data
                            Surname[i]=input.next();
                            vaccines--;
                        }

                    }else{
                        System.out.println("Enter Correct Booth Number"); //if user input a wrong booth number

                    }
                }
                if(Vacc.equals("Pfizer")){//check the vaccine
                    System.out.println("Enter Booth Number 4,5");
                    int i=input.nextInt();
                    if(i==4 || i==5){//check the correct booth
                        if(ServiceCenter[i]!="Empty"){
                            System.out.println("A Patient is in this Booth");
                        }
                        if(ServiceCenter[i]=="Empty"){
                            System.out.print("Enter Patient First Name:");//use arrays to store data
                            ServiceCenter[i]=input.next();
                            System.out.print("Enter Patient  Surname:");
                            Surname[i]=input.next();
                            vaccines--;
                        }

                    }else{
                        System.out.println("Enter Correct Booth Number");//if user input a wrong booth number

                    }
                }


            } else if (instruct.equals("RPB") || instruct.equals("103")) {
                System.out.print("Enter Number of the booth to remove a Patient");
                int i = input.nextInt();
                ServiceCenter[i] = "Empty";
            } else if (instruct.equals("VPS") || instruct.equals("104")) {
                System.out.println("Patients Sorted in alphabetical order");
                String order;
                for (int i = 0; i < ServiceCenter.length; i++) {
                    for (int j = i + 1; j < ServiceCenter.length; j++) {


                        if (ServiceCenter[i].compareTo(ServiceCenter[j]) > 0) {

                            order = ServiceCenter[i];
                            ServiceCenter[i] = ServiceCenter[j];
                            ServiceCenter[j] = order;
                        }
                    }
                }



                System.out.println(
                        "The names in alphabetical order are: ");
                for (int i = 0; i < ServiceCenter.length; i++) {
                    System.out.println(ServiceCenter[i]);
                }
            } else if (instruct.equals("SPD") || instruct.equals("105")) {

                System.out.println("Store Program Data into file");
                try {
                    FileWriter savedata = new FileWriter("SavedData.txt"); //creat a new object name savedata
                    for (int i = 0; i < ServiceCenter.length; i++) {
                        savedata.write("Booth" + i+" " + "First Name:" + ServiceCenter[i] +"  "+"Surname:"+Surname[i]+ "\n");
                    }

                    savedata.close();
                    System.out.println("Successfully wrote to the file.");
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
            } else if (instruct.equals("LPD") || instruct.equals("106")) {
                System.out.println("Loaded Program Data from file");         //load saved data
                File myObj = new File("SavedData.txt");
                if (myObj.exists()) {
                    System.out.println("File name: " + myObj.getName());
                    System.out.println("Absolute path: " + myObj.getAbsolutePath());

                } else {
                    System.out.println("The file does not exist.");
                }

            } else if (instruct.equals("VRV") || instruct.equals("107")) { //view remaining vaccines
                System.out.print("Remaining Vaccinations:");
                System.out.println(vaccines);

            } else if (instruct.equals("AVS") || instruct.equals("108")) { //add a vaccine
                System.out.println("Added a Vaccine...");
                vaccines++;

            }  else if(instruct.equals("EXT") || instruct.equals("999")) { // exit from programm
                System.out.println("Exited...");
                break;
            }
            else {
                System.out.println("Invalid Input..."); //if user enter a wrong input , print a message
            }

        }
    }

    public static void printname() {
        System.out.println("HI.....");
    }
}
//refernce --->https://www.w3schools.com/java/java_files_create.asp (save and load data)
//------------>https://www.studytonight.com/java-programs/java-program-to-sort-an-array-in-alphabetical-order (sort in to alphabetical order)





