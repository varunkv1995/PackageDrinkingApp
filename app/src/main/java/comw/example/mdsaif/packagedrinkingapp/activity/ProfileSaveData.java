package comw.example.mdsaif.packagedrinkingapp.activity;

/**
 * Created by myLaptop on 2/24/2018.
 */

public class ProfileSaveData {
    String name,address,number,pincode;



    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber(){ return number;}

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public ProfileSaveData(String name, String address, String number, String pincode) {


        this.name = name;
        this.address = address;
        this.number=number;
        this.pincode=pincode;
    }
    public ProfileSaveData(){}


}

