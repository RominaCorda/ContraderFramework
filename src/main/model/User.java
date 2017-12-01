package main.model;

public class User {

    private Integer U_id;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String dateofbirth;
    private String CF;
    private String businessname;
    private String vat;
    private String town;
    private String CAP;
    private String city;
    private String address;
    private String telephone;
    private String role;


    public User(Integer u_id, String username, String password, String firstname, String lastname, String dateofbirth, String CF, String businessname, String vat, String town, String CAP, String city, String address, String telephone, String role) {
        U_id = u_id;
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dateofbirth = dateofbirth;
        this.CF = CF;
        this.businessname = businessname;
        this.vat = vat;
        this.town = town;
        this.CAP = CAP;
        this.city = city;
        this.address = address;
        this.telephone = telephone;
        this.role = role;
    }

    public int getU_id() {
        return U_id;
    }

    public void setU_id(int u_id) {
        U_id = u_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getCF() {
        return CF;
    }

    public void setCF(String CF) {
        this.CF = CF;
    }

    public String getBusinessname() {
        return businessname;
    }

    public void setBusinessname(String businessname) {
        this.businessname = businessname;
    }

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getCAP() {
        return CAP;
    }

    public void setCAP(String CAP) {
        this.CAP = CAP;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (firstname != null ? !firstname.equals(user.firstname) : user.firstname != null) return false;
        if (lastname != null ? !lastname.equals(user.lastname) : user.lastname != null) return false;
        if (dateofbirth != null ? !dateofbirth.equals(user.dateofbirth) : user.dateofbirth != null) return false;
        if (CF != null ? !CF.equals(user.CF) : user.CF != null) return false;
        if (businessname != null ? !businessname.equals(user.businessname) : user.businessname != null) return false;
        if (vat != null ? !vat.equals(user.vat) : user.vat != null) return false;
        if (town != null ? !town.equals(user.town) : user.town != null) return false;
        if (CAP != null ? !CAP.equals(user.CAP) : user.CAP != null) return false;
        if (city != null ? !city.equals(user.city) : user.city != null) return false;
        if (address != null ? !address.equals(user.address) : user.address != null) return false;
        if (telephone != null ? !telephone.equals(user.telephone) : user.telephone != null) return false;
        return role != null ? role.equals(user.role) : user.role == null;
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (dateofbirth != null ? dateofbirth.hashCode() : 0);
        result = 31 * result + (CF != null ? CF.hashCode() : 0);
        result = 31 * result + (businessname != null ? businessname.hashCode() : 0);
        result = 31 * result + (vat != null ? vat.hashCode() : 0);
        result = 31 * result + (town != null ? town.hashCode() : 0);
        result = 31 * result + (CAP != null ? CAP.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (telephone != null ? telephone.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }
    @Override
    public String toString() {
        return "Username: " +username +
                "\nPassword: " + password +
                "\nFirstname: " + firstname +
                "\nLastname: " + lastname +
                "\nDateofbirth:" + dateofbirth +
                "\nCF: " + CF +
                "\nBusinessname: " + businessname +
                "\nVat: " + vat +
                "\nTown: " + town +
                "\nCAP: " + CAP +
                "\nCity: " + city +
                "\nAddress: " + address +
                "\nTelephone: " + telephone +
                "\nRole: " + role +
                "\n";
    }
}
