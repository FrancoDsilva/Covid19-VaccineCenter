package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.util.Random;
public class Scene2Controller {

    @FXML
    Label nameLabel,nameLabel1,nameLabel2,nameLabel3,nameLabel4,nameLabel5,nameLabel6,nameLabel7;
    public void displayName6(String username6) {
        nameLabel6.setText( username6);
    }
    public void displayName5(String username5) {
        nameLabel5.setText( username5);
    }
    public void displayName(String username) {
        nameLabel.setText( username);
    }
    public void displayName1(String username1) {
        nameLabel1.setText( username1);
    }
    public void displayName2(String username2) {
        nameLabel2.setText( username2);
    }
    public void displayName3(String username3) {
        nameLabel3.setText( username3);
    }
    public void displayName4(String username4) {
        nameLabel4.setText( username4);

        Random r = new Random();
        int datelow = 1;
        int datehigh = 31;
        int dateresult = r.nextInt(datehigh-datelow) + datelow;

        int monthlow = 8;
        int monthhigh = 12;
        int monthresult = r.nextInt(monthhigh-monthlow) + monthlow;

        int Yearlow = 2021;
        int Yearhigh = 2022;
        int Yearresult = r.nextInt(Yearhigh-Yearlow) + Yearlow;

        int hourlow = 8;
        int hourhigh = 17;
        int hourresult = r.nextInt(hourhigh-hourlow) + hourlow;

        int timelow = 00;
        int timehigh = 59;
        int timeresult = r.nextInt(timehigh-timelow) + timelow;

        nameLabel7.setText(String.valueOf(dateresult+"/"+monthresult+"/"+Yearresult+" | "+hourresult+":"+timeresult));


    }




}









//reference-->bro code(YT channel)