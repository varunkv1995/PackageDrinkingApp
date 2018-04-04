package comw.example.mdsaif.packagedrinkingapp.Model;

/**
 * Created by Md.Saif on 24-02-2018.
 */

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.EditText;

/**
 * Created by Md.Saif on 24-02-2018.
 */

public class User implements Parcelable {

    public String email;
    public String Name;
    public String mobileNumber;
    public String password;
    public String name;
    public String number;
    public String address;
    public String pincode;
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

    public User(Parcel in) {
        email = in.readString();
        Name = in.readString();
        mobileNumber = in.readString();
        password = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public User(EditText name, String contact, String address, String pincode) {

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(email);
        parcel.writeString(Name);
        parcel.writeString(mobileNumber);
        parcel.writeString(password);
    }



}


