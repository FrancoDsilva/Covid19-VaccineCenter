import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
class VaccineCenterClassExtended {
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

        Booths b1=new Booths();

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

                b1.viewEmptyBooth();
                //view only emty booth

            }
            else if(instruct.equals("APB") || instruct.equals("102")){

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
                System.out.println("Invalid Input...");
            }

        }
    }
}

class Booths{
    String[] ServiceCenter = new String[6]; //creat a array to enter names
    String[] Surname = new String[6]; ////creat a array to enter surname
    String[] City = new String[6]; //creat a array to enter city
    int[] Age = new int[6]; //creat a array to enter age
    String[] NIC = new String[6]; //creat a array to enter nic or passport
    int vaccines=150; // number of vaccines
    Scanner input = new Scanner(System.in);
    String Vacc;

    public void Intilize(){
        for (int i = 0; i < ServiceCenter.length ; i++)
        {
            ServiceCenter[i]="Empty"; //intilize the booth
        }
    }




    public void viewBooth(){
        for (int i = 0; i < ServiceCenter.length ; i++)
        {
            System.out.println("Booth "+(i)+":"+ServiceCenter[i]); //print a array using for-loop
        }


    }
    public void viewEmptyBooth(){
        for (int i = 0; i < ServiceCenter.length ; i++)
        {
            if (ServiceCenter[i]=="Empty"){  //print booths  if booths are empty
                System.out.println("Booth "+(i)+":"+ServiceCenter[i]);
            }
        }
    }
    public void addPatient(){


        System.out.print("Enter Vaccine Name:"); //user input of vaccine
        Vacc=input.next();

        if(Vacc.equals("AstraZeneca")){ //checkthe correct vaccine
            System.out.println("Enter Booth Number 0,1");
            int i=input.nextInt();
            if(i==0 || i==1){ //check the correct booth
                if(ServiceCenter[i]!="Empty"){
                    System.out.println("A Patient is in this Booth"); //if booth is not empty print a message

                }
                if(ServiceCenter[i]=="Empty"){
                    System.out.print("Enter Patient First Name:"); //get data and store in arrayas
                    ServiceCenter[i]=input.next();
                    System.out.print("Enter Patient  Surname:");
                    Surname[i]=input.next();
                    System.out.print("Enter Patient's City:");
                    City[i]=input.next();
                    System.out.print("Enter Patient's Age:");
                    Age[i]=input.nextInt();
                    System.out.print("Enter Patient's NIC or Password:");
                    NIC[i]=input.next();
                    vaccines--;
                }

            }
            else{
                System.out.println("Enter Correct Booth Number"); //print a message if users input is wrong
            }
        }
        if(Vacc.equals("Sinopharm")){//checkthe correct vaccine
            System.out.println("Enter Booth Number 2,3");
            int i=input.nextInt();
            if(i==2 || i==3){//check the correct booth
                if(ServiceCenter[i]!="Empty"){
                    System.out.println("A Patient is in this Booth:");//if booth is not empty print a message
                }
                if(ServiceCenter[i]=="Empty"){
                    System.out.print("Enter Patient First Name:");//get data and store in arrayas
                    ServiceCenter[i]=input.next();
                    System.out.print("Enter Patient  Surname:");
                    Surname[i]=input.next();
                    System.out.print("Enter Patient's City:");
                    City[i]=input.next();
                    System.out.print("Enter Patient's Age:");
                    Age[i]=input.nextInt();
                    System.out.print("Enter Patient's NIC or Password:");
                    NIC[i]=input.next();
                    vaccines--;
                }

            }else{
                System.out.println("Enter Correct Booth Number");//print a message if users input is wrong

            }
        }
        if(Vacc.equals("Pfizer")){//checkthe correct vaccine
            System.out.println("Enter Booth Number 4,5:");
            int i=input.nextInt();
            if(i==4 || i==5){//checkthe correct Booth
                if(ServiceCenter[i]!="Empty"){
                    System.out.println("A Patient is in this Booth");//if booth is not empty print a message
                }
                if(ServiceCenter[i]=="Empty"){
                    System.out.print("Enter Patient First Name:");//get data and store in arrayas
                    ServiceCenter[i]=input.next();
                    System.out.print("Enter Patient  Surname:");
                    Surname[i]=input.next();
                    System.out.print("Enter Patient's City:");
                    City[i]=input.next();
                    System.out.print("Enter Patient's Age:");
                    Age[i]=input.nextInt();
                    System.out.print("Enter Patient's NIC or Password:");
                    NIC[i]=input.next();
                    vaccines--;
                }

            }else{
                System.out.println("Enter Correct Booth Number");//print a message if users input is wrong

            }
        }


    }
    public void removePatient(){
        int i=input.nextInt();
        ServiceCenter[i]="Empty";

    }
    public void sort() {
        System.out.println("Patients Sorted in alphabetical order");//sort patients name according to alpabetical order
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
    }



    public void load(){
        System.out.println("Loaded Program Data from file"); //load data from text file
        File loaddata = new File("SavedData.txt");
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
            FileWriter savedata = new FileWriter("SavedData.txt"); //load save to text file
            for (int i = 0; i < ServiceCenter.length; i++)
            {
                savedata.write("Booth"+i+"  "+"FirstName:"+ServiceCenter[i]+"  "+"Surname:"+Surname[i]+"  "+"City:"+City[i]+"  "+"Age:"+Age[i]+"  "+"NIC:"+NIC[i]+"  "+ "\n");
            }

            savedata.close();
            System.out.println("Successfully wrote to the file.");
        }catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
    public void RemaingVacc(){ //view remaining vaccines
        System.out.println(vaccines);

    }
    public void AddVacc(){ //add a vaccine
        vaccines++;

    }
}
//refernce --->https://www.w3schools.com/java/java_files_create.asp (save and load data)
//------------>https://www.studytonight.com/java-programs/java-program-to-sort-an-array-in-alphabetical-order (sort in to alphabetical order)



