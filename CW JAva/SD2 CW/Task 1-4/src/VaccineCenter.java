import java.lang.reflect.Array;
import java.util.Arrays; // import arrays
import java.util.Scanner;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;
import java.io.File;  // Import File class
import java.io.FileNotFoundException;  // Import this class to handle errors

class VaccineCenter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("=========================================================");//print all the possible inputs
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

        int vaccines=150;
        String instruct;


        for (int i = 0; i < ServiceCenter.length ; i++)
        {
            ServiceCenter[i]="Empty"; //initialize booth elements
        }


        while(true){

            System.out.print("Enter a Input:");


            instruct = input.next(); //user input of instruction


            if(instruct.equals("VVB") || instruct.equals("100")){ //view all booths
                addpatient();
                System.out.println("All Vaccination Booths");
                for (int i = 0; i < ServiceCenter.length ; i++)
                {
                    System.out.println("Booth "+(i)+":"+ServiceCenter[i]);
                }

            }

            else if(instruct.equals("VEB") || instruct.equals("101")){ // view only emty booths
                System.out.println("All Empty Booths");
                for (int i = 0; i < ServiceCenter.length ; i++)
                {
                    if (ServiceCenter[i]=="Empty"){
                        System.out.println("Booth "+(i)+":"+ServiceCenter[i]); // print all booths
                    }
                }
            }
            else if(instruct.equals("APB") || instruct.equals("102")){ // add a patient
                System.out.print("Enter a booth number to add patient(0-5)");
                int i=input.nextInt();
                if(ServiceCenter[i]!="Empty"){
                    System.out.println("A Patient is in this Booth"); //check is booth is empty if it empty add a patient
                }                                                        //if not print a message
                if(ServiceCenter[i]=="Empty"){


                    System.out.print("Enter Patient Name:");
                    ServiceCenter[i]=input.next();
                    vaccines--;
                    if(vaccines<20){
                        System.out.println("vaccines are lower than 20");//print a message if vaccines go low than 20
                    }

                }

            }

            else if(instruct.equals("RPB") || instruct.equals("103")){ // remove a patient
                System.out.print("Enter Number of the booth to remove a Patient");
               int i=input.nextInt();
               ServiceCenter[i]="Empty";

            }
            else if(instruct.equals("VPS") || instruct.equals("104")) {
                System.out.println("Patients Sorted in alphabetical order"); // sort patients' names alphabetical order
                String order;

                for (int i = 0; i <ServiceCenter.length ; i++) {
                    for (int j = i + 1; j < ServiceCenter.length; j++) {


                        if (ServiceCenter[i].compareTo(ServiceCenter[j]) > 0) {

                            order = ServiceCenter[i];
                            ServiceCenter[i] = ServiceCenter[j];
                            ServiceCenter[j] = order;
                        }
                    }
                }




                for (int i = 0; i < ServiceCenter.length; i++) {
                    System.out.println(ServiceCenter[i]);
                }
            }


            else if(instruct.equals("SPD") || instruct.equals("105")){ // save data

                System.out.println("Save Data into file");
                try {
                    FileWriter savedata = new FileWriter("SavedData.txt"); //creat a new object type file writer
                    for (int i = 0; i < ServiceCenter.length; i++)
                    {
                        savedata.write("Booth"+i+" "+"FirstName:"+ServiceCenter[i]+"\n");
                    }

                    savedata.close();
                    System.out.println("Successfully wrote to the file.");
                }catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
            }
            else if(instruct.equals("LPD") || instruct.equals("106")){
                System.out.println("Loaded Program Data from file");  // load saved data
                File myObj = new File("SavedData.txt");
                if (myObj.exists()) {
                    System.out.println("File name: " + myObj.getName());
                    System.out.println("Absolute path: " + myObj.getAbsolutePath());

                } else {
                    System.out.println("The file does not exist.");
                }

            }
            else if(instruct.equals("VRV") || instruct.equals("107")){
                System.out.print("Remaining Vaccinations:");     //show remaing vaccines
                System.out.println(vaccines);

            }
            else if(instruct.equals("AVS") || instruct.equals("108")){  // add a vaccine
                System.out.println("Added a Vaccine...");
                vaccines++;
            }
            else if(instruct.equals("EXT") || instruct.equals("999")) {  // Exit from programme
                System.out.println("Exited...");
                break;
            }

            else {
                System.out.println("Invalid Input..."); // if user input a different input print message
            }

        }
    }




}
//refernce --->https://www.w3schools.com/java/java_files_create.asp (save and load data)
//------------>https://www.studytonight.com/java-programs/java-program-to-sort-an-array-in-alphabetical-order (sort in to alphabetical order)




