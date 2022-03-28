import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
class VaccineCenterTask4 {
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

        newbooth p1=new newbooth();

        p1.Intilize();

        String instruct;

        while(true){
            System.out.print("Enter a Input:");

            instruct=input.next();

            if(instruct.equals("VVB") || instruct.equals("100")){
                System.out.println("View all Vaccination Booths");
                p1.viewBooth();
                //view all booths

            }
            else if(instruct.equals("VEB") || instruct.equals("101")){
                System.out.println("View all Empty Booths");
                p1.viewEmptyBooth();
                //view only emty booth

            }
            else if(instruct.equals("APB") || instruct.equals("102")){

                p1.addPatient();
                //Enter a patient to booth
            }
            else if(instruct.equals("RPB") || instruct.equals("103")){

                p1.removePatient();
                //remove a patient
            }
            else if(instruct.equals("VPS") || instruct.equals("104")){
                System.out.println("View Patients Sorted in alphabetical order");
                p1.sort();
                //sort patient's names by alphabetical order
            }
            else if(instruct.equals("SPD") || instruct.equals("105")){
                System.out.println("Store Program Data into file");
                p1.save();
                //save data
            }
            else if(instruct.equals("LPD") || instruct.equals("106")){
                System.out.println("Loaded Program Data from file");
                p1.load();
                //load saved data

            }
            else if(instruct.equals("VRV") || instruct.equals("107")){
                System.out.print("Remaining Vaccinations:");
                p1.RemaingVacc();
                //display remaining vaccine


            }
            else if(instruct.equals("AVS") || instruct.equals("108")){
                System.out.println("Added a Vaccine...");
                p1.AddVacc();
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

class newbooth{
    String[] ServiceCenter = new String[6]; //creat a array to enter names

    int vaccines=150; // number of vaccines
    Scanner input = new Scanner(System.in);
    String Vacc;
    LinkedList<String> waitinglist=new LinkedList<>();

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



            System.out.print("Enter Booth number (0-5):");

            int i=input.nextInt();//add the booth number that you want to put patient
            System.out.print("Enter Patients name:");
            String name=input.next();//get patient name
            if(ServiceCenter[i]!="Empty"){
                System.out.println("patient added to waiting list");


                waitinglist.add(name);//if booth is full add patient to waiting list

            }

            if(ServiceCenter[i]=="Empty"){ //if booth emtpy
                if(waitinglist!=null){ //if waitng list has data

                    String[] temp = waitinglist.toArray(new String[6]); // creating a tempory array to assign linkedlist data to booth
                    temp[0]=name;
                    ServiceCenter[i]=temp[0];
                    waitinglist.remove(name);
                    vaccines--;



                }
                else if(waitinglist==null){//if waitng list has no data
                    System.out.print("Enter Patient Name:");
                    ServiceCenter[i]=name;
                    vaccines--;

                    if(vaccines<20){
                        System.out.println("vaccines are lower than 20");
                    }
                }



            }

        }
    public void removePatient(){
        System.out.print("Enter Number of the booth to remove a Patient");
        int i=input.nextInt();
        if(waitinglist.size()==0){

            ServiceCenter[i]="Empty";
        }
        else if(waitinglist!=null){
            String[] temp = waitinglist.toArray(new String[6]); //creat a tempory array to get linked list data

            ServiceCenter[i]=temp[0];
            waitinglist.remove();
            vaccines--;

        }

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
                savedata.write("Booth"+i+"  "+"FirstName:"+ServiceCenter[i]+"\n");
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



