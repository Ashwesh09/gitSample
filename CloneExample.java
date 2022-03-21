class Address {
    Location location;
    String state;
    String country = "India";

    public Address(Location location, String state) {
        this.location =  new Location(location.street, location.city);
        this.state = state;
    }

    @Override
    public String toString() {
        return "\nCountry = " + country + "\nState = " + state +"\nLocation:" + location +  "\n";
    }
}

class Location {
    String street;
    String city;
    public Location(String street, String city) {
        this.street = street;
        this.city = city;
    }
    @Override
    public String toString() {
        return "\nCity = " + city + "\nStreet = " + street;
    }
    
}

class UPIApps implements Cloneable {
    String name;
    int dailyLimit;
    double maxDailyAmount;
    Address headOfficeLocation;

    public UPIApps(String name, int dailyLimit, double maxDailyAmount, Address headOfficeLocation) {
        this.name = name;
        this.dailyLimit = dailyLimit;
        this.maxDailyAmount = maxDailyAmount;
        this.headOfficeLocation = headOfficeLocation;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        //Location loc = new Location(this.headOfficeLocation.location.street, this.headOfficeLocation.location.city);
        Address newDepObj = new Address(this.headOfficeLocation.location, this.headOfficeLocation.state);
        return new UPIApps(this.name,this.dailyLimit,this.maxDailyAmount,newDepObj);
    }

    @Override
    public String toString() {
        return  "\n----  Name = " + name +"  ----\nDaily Limit = " + dailyLimit + "\nMax Daily Amount = " + maxDailyAmount +"\n-- Head Office Location: --"
                + headOfficeLocation + "\n";
    }
    
}

public class CloneExample {
    public static void main(String[] args) throws Exception {
        Location BHIMloc = new Location("123 park road","Banglore");
        Address BHIMadrs = new Address(BHIMloc,"Karnataka") ;
        UPIApps bhim = new UPIApps("BHIM", 10, 100000,BHIMadrs);
        // Before cloning 
        System.out.println("----------- Before Deep cloning: -----------");
        System.out.println("BHIM  app info:\n"+bhim);

        // Deep copy
        UPIApps payTm = (UPIApps) bhim.clone();
        // Changing Data
        payTm.name = "PayTm";
        payTm.headOfficeLocation.location.city = "Mumbai";
        payTm.headOfficeLocation.location.street = "456 RPTS Road";
        payTm.headOfficeLocation.state = "Maharashtra";
        System.out.println("----------- After Cloning -----------\nChanges in paytm\n" + payTm);
        
        //Printing BHIM app info
        System.out.println("BHIM  app info after Cloning:\n"+bhim);
    }
}