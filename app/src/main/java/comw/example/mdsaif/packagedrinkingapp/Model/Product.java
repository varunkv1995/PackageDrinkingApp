package comw.example.mdsaif.packagedrinkingapp.Model;

/**
 * Created by Md.Saif on 24-02-2018.
 */

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by gunjit on 30/03/17.
 */

public class Product implements Parcelable{
    public String productName;
    public String productDescription;
    public String productImage;
    private double cost;
    public ArrayList<String> imageArray = new ArrayList<>();
    public double getCost() {
        return cost;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }
    public Product(String productName, double cost) {
        this.productName = productName;
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (!productName.equals(product.productName)){
            return false;
        }

        return false;
    }

    public Product(Parcel in) {
        productName = in.readString();
        productDescription = in.readString();
        productImage = in.readString();
        imageArray = in.createStringArrayList();
        cost = in.readDouble();
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    public Product() {

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(productName);
        parcel.writeString(productDescription);
        parcel.writeString(productImage);
        parcel.writeStringList(imageArray);
        parcel.writeDouble(cost);
    }
}

