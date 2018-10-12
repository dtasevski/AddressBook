import java.util.ArrayList;
import java.util.Scanner;

class Contact{
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    public Contact(String firstName, String lastName, String email, String phone){
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
        this.phone=phone;
    }
    public void setFirstName(String firstName){
        this.firstName=firstName;
    }
    public String getFirstName(){
        return firstName;
    }
    public void setLastName(String lastName){
        this.lastName=lastName;
    }
    public String getLastName(){
        return  lastName;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String getEmail(){
        return email;
    }
    public void setPhone(String phone){
        this.phone=phone;
    }
    public String getPhone(){
        return phone;
    }
    public void printContact(){
        System.out.println("First Name:  "+firstName+ ",  Last Name:  "+lastName+",  Email:  "+email+",  Phone:  "+phone);
    }
}

class AddressBook{
    private ArrayList<Contact> contacts;
    AddressBook(){
        contacts=new ArrayList<Contact>();
    }
    public void addContact(String firstname, String lastname, String email, String phone){
        contacts.add(new Contact(firstname, lastname, email, phone));
    }
    public void printAddressBook() {
        int indexOfContact=1;
        for (Contact singleContact : contacts) {
            System.out.print((indexOfContact++) + ": ");
            singleContact.printContact();
        }
    }
    public void searchContact(int criteria,String searchQuery){
        switch(criteria){
            case 1:
                for (int i=0; i<contacts.size(); i++){
                    if(contacts.get(i).getFirstName().contains(searchQuery)) (contacts.get(i)).printContact();
                    else System.out.println("\nThat contact doesn't exist");
                } break;
            case 2:
                for (int i=0; i<contacts.size(); i++){
                    if(contacts.get(i).getLastName().contains(searchQuery)) (contacts.get(i)).printContact();
                    else System.out.println("\nThat contact doesn't exist");
                } break;
            case 3:
                for (int i=0; i<contacts.size(); i++){
                    if(contacts.get(i).getEmail().contains(searchQuery)) (contacts.get(i)).printContact();
                    else System.out.println("\nThat contact doesn't exist");
                } break;
            case 4:
                for (int i=0; i<contacts.size(); i++){
                    if(contacts.get(i).getPhone().contains(searchQuery)) (contacts.get(i)).printContact();
                    else System.out.println("\nThat contact doesn't exist");
                } break;
            default:
                System.out.println("\n That contact doesn't exist");
        }
    }
    public void deleteContact(int deleteContactChoice){
        if(deleteContactChoice-1 < contacts.size() && deleteContactChoice>0) {
            contacts.remove(deleteContactChoice - 1);
        } else {
            System.out.println("\nNo such contact exists");
        }
    }
    public void modifyContact(int modifyContactChoice, int attrToBeModified, String newValue){
        switch(attrToBeModified){
            case 1:
                contacts.get(modifyContactChoice-1).setFirstName(newValue);
                System.out.println("First name successfully changed to "+ newValue + "!\n");
                break;
            case 2:
                contacts.get(modifyContactChoice-1).setLastName(newValue);
                System.out.println("Last name successfully changed to "+newValue + "!\n");
                break;
            case 3:
                contacts.get(modifyContactChoice-1).setEmail(newValue);
                System.out.println("Email address successfully changed to "+ newValue + "!\n");
                break;
            case 4:
                contacts.get(modifyContactChoice-1).setPhone(newValue);
                System.out.println("Phone number successfully changed to " + newValue + "!\n");
                break;
            default:
                System.out.println("Invalid value, please try again");
                break;
        }
    }
    public boolean validateContact(int modifyContactChoice){
        if((modifyContactChoice-1 < contacts.size())&& (modifyContactChoice)>0) return true;
        else return false;
    }
    public boolean isEmpty(){
        if(contacts.size()==0) return true;
        else return false;
    }
}

class AddressBookProject {

    public static void main(String[] args) {
        String userInput;
        AddressBook addr = new AddressBook();
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("\nChoose an action\n");
            System.out.println("1. Add New Contact");
            System.out.println("2. Search Contacts");
            System.out.println("3. Modify Existing Contact");
            System.out.println("4. Remove Existing Contact");
            System.out.println("5. Preview the whole address book");
            System.out.println("Press e to exit\n");
            userInput = scanner.nextLine();
            switch (userInput) {
                case "1":
                    addingContact(scanner, addr);
                    break;

                case "2":
                    if (addr.isEmpty()) System.out.println("The Address Book is currently empty");
                    else {
                        searchingContact(scanner, addr);
                    }
                    break;

                case "3":
                    if (addr.isEmpty()) {
                        System.out.println("The Address Book is currently empty");
                    } else {
                        addr.printAddressBook();
                        modifyingContact(scanner, addr);
                    }
                    break;

                case "4":
                    if (addr.isEmpty()) System.out.println("The Address Book is currently empty");
                    else {
                        addr.printAddressBook();
                        removingContact(scanner,addr);
                    }
                    break;
                case "5":
                    if (addr.isEmpty()) System.out.println("The Address Book is currently empty");
                    else addr.printAddressBook();
                    break;
                case "e":
                    return;
                default:
                    if (!userInput.equals("e")) System.out.println("Invalid value please try again");
            }
        } while (!userInput.equals("e"));
    }

    public static void addingContact(Scanner scanner, AddressBook addr) {
        System.out.println("Enter First Name: ");
        String fname = scanner.nextLine();
        System.out.println("Enter Last Name: ");
        String lname = scanner.nextLine();
        System.out.println("Enter Email Address");
        String em = scanner.nextLine();
        System.out.println("Enter Phone Number");
        String pnumber = scanner.nextLine();
        addr.addContact(fname, lname, em, pnumber);
    }

    public static void searchingContact(Scanner scanner, AddressBook addr) {
        System.out.println("\nPlease choose the criteria of your search: 1-By First Name, 2-By Last Name, 3-By Email, 4-By Phone");
        int searchCriteria = scanner.nextInt();
        scanner.nextLine();
        if (searchCriteria < 1 || searchCriteria > 4)
            System.out.println("Invalid criteria, returning to main menu");
        else {
            System.out.println("Add the keyword you would like to search");
            String searchQuery = scanner.nextLine();
            addr.searchContact(searchCriteria, searchQuery);
        }
    }

    public static void modifyingContact(Scanner scanner, AddressBook addr) {
        System.out.println("\nPlease choose the number of the contact that you would like to edit");
        int modifyContactChoice = scanner.nextInt();
        scanner.nextLine();
        if (addr.validateContact(modifyContactChoice)) {
            int attrToBeModified;
            boolean flag = true;
            do {
                System.out.println("Please choose the attribute to be modified: (1-First Name, 2-Last Name, 3-Email, 4-Phone, 0-cancel)");
                attrToBeModified = scanner.nextInt();
                scanner.nextLine();
                if (attrToBeModified < 0 || attrToBeModified > 4) {
                    System.out.println("That attribute doesn't exist, please choose again");
                } else if (attrToBeModified != 0) {
                    System.out.println("Please enter the new value");
                    String newValue = scanner.nextLine();
                    addr.modifyContact(modifyContactChoice, attrToBeModified, newValue);
                    System.out.println("Would you like to make additional changes? y/n");
                    String additionalChange = scanner.nextLine();
                    if (additionalChange.equals("n")) {
                        flag = false;
                    }
                }
            } while (attrToBeModified != 0 && flag);
        } else System.out.println("\nNo such contact exists");
    }
    public static void removingContact(Scanner scanner, AddressBook addr){
        System.out.println("\nPlease choose the number of the contact that you would like to delete");
        int deleteContactChoice = scanner.nextInt();
        scanner.nextLine();
        addr.deleteContact(deleteContactChoice);
    }
}