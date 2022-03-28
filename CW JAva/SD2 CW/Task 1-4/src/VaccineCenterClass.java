import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
class VaccineCenterClass {
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

        Booth b1=new Booth();

        b1.Intilize();

        String instruct;

        while(true){
            System.out.print("Enter a Input:");

            instruct=input.next();

            if(instruct.equals("VVB") || instruct.equals("100")){
                System.out.println("View all Vaccination Booths");
                b1.viewBooth();
                //view all booths

            }
            else if(instruct.equals("VEB") || instruct.equals("101")){
                System.out.println("View all Empty Booths");
                b1.viewEmptyBooth();
                //view only emty booth

            }
            else if(instruct.equals("APB") || instruct.equals("102")){
                System.out.print("Enter Booth number (0-5):");
                b1.addPatient();
                //Enter a patient to booth
            }
            else if(instruct.equals("RPB") || instruct.equals("103")){
                System.out.print("Enter Number of the booth to remove a Patient");
                b1.removePatient();
                //remove a patient
            }
            else if(instruct.equals("VPS") || instruct.equals("104")){
                System.out.println("View Patients Sorted in alphabetical order");
                b1.sort();
                //sort patient's names by alphabetical order
            }
            else if(instruct.equals("SPD") || instruct.equals("105")){
                System.out.println("Store Program Data into file");
                b1.save();
                //save data
            }
            else if(instruct.equals("LPD") || instruct.equals("106")){
                System.out.println("Loaded Program Data from file");
                b1.load();
                //load saved data

            }
            else if(instruct.equals("VRV") || instruct.equals("107")){
                System.out.print("Remaining Vaccinations:");
                b1.RemaingVacc();
                //display remaining vaccine


            }
            else if(instruct.equals("AVS") || instruct.equals("108")){
                System.out.println("Added a Vaccine...");
                b1.AddVacc();
                //add a vaccine

            }
            else if(instruct.equals("EXT") || instruct.equals("999")) {
                System.out.println("Exited...");
                break;
                //exit from programme
            }
            else{
                System.out.println("Invalid Input..."); //if user input a wrong input print a message
            }

        }
    }
}

class Booth{

    String[] ServiceCenter = new String[6];
    int vaccines=150;
    Scanner input = new Scanner(System.in);

    public void Intilize(){
        for (int i = 0; i < ServiceCenter.length ; i++)
        {
            ServiceCenter[i]="Empty";//initialize booth elements
        }
    }




    public void viewBooth(){ //view all booths
        for (int i = 0; i < ServiceCenter.length ; i++)
        {
            System.out.println("Booth "+(i)+":"+ServiceCenter[i]);
        }


    }
    public void viewEmptyBooth(){// view only emty booths
        for (int i = 0; i < ServiceCenter.length ; i++)
        {
            if (ServiceCenter[i]=="Empty"){
                System.out.println("Booth "+(i)+":"+ServiceCenter[i]);
            }// print all booths
        }
    }
    public void addPatient(){// add a patient


        int i=input.nextInt();
        if(ServiceCenter[i]!="Empty"){//check is booth is empty if it empty add a patient
            System.out.println("A Patient is in this Booth");
        }
        if(ServiceCenter[i]=="Empty"){//if not print a message


            System.out.print("Enter Patient Name:");
            ServiceCenter[i]=input.next();
            vaccines--;
            if(vaccines<20){
                System.out.println("vaccines are lower than 20");
            }

        }

    }
    public void removePatient(){
        int i=input.nextInt(); //remove a patient
        ServiceCenter[i]="Empty";

    }
    public void sort() {
        System.out.println("Patients Sorted in alphabetical order");
        String order;
        for (int i = 0; i < ServiceCenter.length; i++) {// sort patients' names alphabetical order
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
    }



    public void load(){
        System.out.println("Loaded Program Data from file");
        File loaddata = new File("SavedData.txt"); //load save data
        if (loaddata.exists()) {
            System.out.println("File name: " + loaddata.getName());
            System.out.println("Absolute path: " + loaddata.getAbsolutePath());

        } else {
            System.out.println("The file is not working");
        }

    }


    public void save(){

        System.out.println("Store Program Data into file");
        try {
            FileWriter savedata = new FileWriter("SavedData.txt");//creat a new object type file writer
            for (int i = 0; i < ServiceCenter.length; i++)
            {
                savedata.write("Booth"+i+" "+"FirstName:" +ServiceCenter[i]+"\n");
            }

            savedata.close();
            System.out.println("Successfully wrote to the file.");
        }catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
    public void RemaingVacc(){
        System.out.println(vaccines); //print remainig vaccine

    }
    public void AddVacc(){ //add a vaccine
        vaccines++;

    }
}

//refernce --->https://www.w3schools.com/java/java_files_create.asp (save and load data)
//------------>https://www.studytonight.com/java-programs/java-program-to-sort-an-array-in-alphabetical-order (sort in to alphabetical order)


