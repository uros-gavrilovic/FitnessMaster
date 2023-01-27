package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Package implements Serializable, GenericEntity {
     int packageID;
     String name;
     double price;

     public Package() {
     }
     public Package(int packageID) {
          this.packageID = packageID;
     }
     public Package(String name, double price) {
          this.name = name;
          this.price = price;
     }
     public Package(int packageID, String name, double price) {
          this.packageID = packageID;
          this.name = name;
          this.price = price;
     }

     public boolean equals(Object obj) {
          if (this == obj) {
               return true;
          }
          if (obj == null) {
               return false;
          }
          if (getClass() != obj.getClass()) {
               return false;
          }
          final Package other = (Package) obj;
          if (this.packageID != other.packageID) {
               return false;
          }
          if (Double.doubleToLongBits(this.price) != Double.doubleToLongBits(other.price)) {
               return false;
          }
          return Objects.equals(this.name, other.name);
     }
     public String toString() {
          return "Package{" + "packageID=" + packageID + ", name=" + name + ", price=" + price + '}';
     }

     public int getPackageID() {
          return packageID;
     }
     public void setPackageID(int packageID) {
          this.packageID = packageID;
     }
     public String getName() {
          return name;
     }
     public void setName(String name) {
          this.name = name;
     }
     public double getPrice() {
          return price;
     }
     public void setPrice(double price) {
          this.price = price;
     }

    @Override
    public ArrayList<String> getIdNames() {
        return (ArrayList<String>) List.of("packageID");
    }
    @Override
    public void setId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
