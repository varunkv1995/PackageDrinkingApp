package comw.example.mdsaif.packagedrinkingapp.activity;

import android.widget.EditText;

/**
 * Created by DELL on 24-02-2018.
 */


public class User {
   private String name,number,email,password,address,pincode;



   public User(EditText name, String contact, String address, String pincode){

    }
    public User(String name, String number, String email , String password, String address, String pincode) {
        this.name = name;
        this.number=number;
        this.email=email;
        this.password = password;
        this.address = address;
        this.pincode=pincode;

    }



    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }
}
