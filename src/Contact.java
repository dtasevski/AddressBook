class Contact {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    public Contact(String firstName, String lastName, String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void printContact() {
        System.out.println("First Name:  " + firstName + ",  Last Name:  " + lastName + ",  Email:  " + email + ",  Phone:  " + phone);
    }

    String searchAtribute(int criteria){
        switch (criteria){
            case 1:
                return getFirstName().toUpperCase();
            case 2:
                return getLastName().toUpperCase();
            case 3:
                return getEmail().toUpperCase();
            case 4:
                return getPhone().toUpperCase();
        }
        return null;
    }

    boolean contains(int criteria, String searchQuery){
        if(searchAtribute(criteria).contains(searchQuery.toUpperCase())) return true;
        else return false;
    }

    void printAttribute(String attribute, String newValue){
        System.out.println(attribute + " successfully changed to " + newValue + "!\n");
    }

    void modifyAttribute(int modifyContactChoice, String newValue){
        switch (modifyContactChoice){
            case 1:
                setFirstName(newValue);
                printAttribute("First name", newValue);
                break;
            case 2:
                setLastName(newValue);
                printAttribute("First name", newValue);
                break;
            case 3:
                setEmail(newValue);
                printAttribute("First name", newValue);
                break;
            case 4:
                setPhone(newValue);
                printAttribute("First name", newValue);
                break;
            default:
                System.out.println("Invalid value, please try again");
                break;
        }
    }
}