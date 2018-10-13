import java.util.ArrayList;
import java.util.Scanner;

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
}

class AddressBook {
    private ArrayList<Contact> contacts;

    AddressBook() {
        contacts = new ArrayList<Contact>();
    }

    public void addContact(String firstname, String lastname, String email, String phone) {
        contacts.add(new Contact(firstname, lastname, email, phone));
    }

    public void printAddressBook() {
        int indexOfContact = 1;
        for (Contact singleContact : contacts) {
            System.out.print((indexOfContact++) + ": ");
            singleContact.printContact();
        }
    }

    public void searchContact(String criteria, String searchQuery) {
        switch (criteria) {
            case "1":
                int counterName = 0;
                for (int i = 0; i < contacts.size(); i++) {
                    if (contacts.get(i).getFirstName().toUpperCase().contains(searchQuery.toUpperCase())) {
                        (contacts.get(i)).printContact();
                        counterName++;
                    }
                }
                if (counterName == 0) System.out.println("No contacts found");
                break;
            case "2":
                int counterLastname = 0;
                for (int i = 0; i < contacts.size(); i++) {
                    if (contacts.get(i).getLastName().toUpperCase().contains(searchQuery.toUpperCase())) {
                        (contacts.get(i)).printContact();
                        counterLastname++;
                    }
                }
                if (counterLastname == 0) System.out.println("No contacts found");
                break;
            case "3":
                int counterEmail = 0;
                for (int i = 0; i < contacts.size(); i++) {
                    if (contacts.get(i).getEmail().toUpperCase().contains(searchQuery.toUpperCase())) {
                        (contacts.get(i)).printContact();
                        counterEmail++;
                    }
                }
                if (counterEmail == 0) System.out.println("No contacts found");
                break;
            case "4":
                int counterPhone = 0;
                for (int i = 0; i < contacts.size(); i++) {
                    if (contacts.get(i).getPhone().contains(searchQuery)) {
                        (contacts.get(i)).printContact();
                        counterPhone++;
                    }
                }
                if (counterPhone == 0) System.out.println("No contacts found");
                break;
        }
    }

    public void deleteContact(String deleteContactChoice) {
        if (((Integer.parseInt(deleteContactChoice) - 1) < contacts.size()) && (Integer.parseInt(deleteContactChoice)) > 0) {
            contacts.remove((Integer.parseInt(deleteContactChoice) - 1));
        } else {
            System.out.println("\nNo such contact exists");
        }
    }

    public void modifyContact(String modifyContactChoice, String attrToBeModified, String newValue) {
        switch (attrToBeModified) {
            case "1":
                contacts.get((Integer.parseInt(modifyContactChoice) - 1)).setFirstName(newValue);
                System.out.println("First name successfully changed to " + newValue + "!\n");
                break;
            case "2":
                contacts.get((Integer.parseInt(modifyContactChoice) - 1)).setLastName(newValue);
                System.out.println("Last name successfully changed to " + newValue + "!\n");
                break;
            case "3":
                contacts.get((Integer.parseInt(modifyContactChoice) - 1)).setEmail(newValue);
                System.out.println("Email address successfully changed to " + newValue + "!\n");
                break;
            case "4":
                contacts.get((Integer.parseInt(modifyContactChoice) - 1)).setPhone(newValue);
                System.out.println("Phone number successfully changed to " + newValue + "!\n");
                break;
            default:
                System.out.println("Invalid value, please try again");
                break;
        }
    }

    public boolean validateContact(String modifyContactChoice) {
        if (((Integer.parseInt(modifyContactChoice) - 1) < contacts.size()) && (Integer.parseInt(modifyContactChoice)) > 0)
            return true;
        else return false;
    }

    public boolean isInteger(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException number) {
            return false;
        }
        return true;
    }

    public boolean isEmpty() {
        if (contacts.size() == 0) return true;
        else return false;
    }
}

class AddressBookProject {

    public static void main(String[] args) {
        String userInput;
        AddressBook addr = new AddressBook();
        Scanner scanner = new Scanner(System.in);
        do {
            menuNavigation();
            userInput = scanner.nextLine();
            switch (userInput) {
                case "1":
                    addingContact(scanner, addr);
                    break;

                case "2":
                    searchingContact(scanner, addr);
                    break;

                case "3":
                    addr.printAddressBook();
                    modifyingContact(scanner, addr);
                    break;

                case "4":
                    addr.printAddressBook();
                    removingContact(scanner, addr);
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
        } while (true);
    }

    public static void menuNavigation() {
        System.out.println("\nChoose an action\n");
        System.out.println("1. Add New Contact");
        System.out.println("2. Search Contacts");
        System.out.println("3. Modify Existing Contact");
        System.out.println("4. Remove Existing Contact");
        System.out.println("5. Preview the whole address book");
        System.out.println("Press e to exit\n");
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
        if (addr.isEmpty()) System.out.println("The Address Book is currently empty");
        else {
            System.out.println("\nPlease choose the criteria of your search: 1-By First Name, 2-By Last Name, 3-By Email, 4-By Phone");
            String searchCriteria = scanner.nextLine();
            if (searchCriteria.compareTo("1") < 0 || searchCriteria.compareTo("4") > 0)
                System.out.println("Invalid criteria, returning to main menu");
            else {
                System.out.println("Add the keyword you would like to search");
                String searchQuery = scanner.nextLine();
                addr.searchContact(searchCriteria, searchQuery);
            }
        }
    }

    public static void modifyingContact(Scanner scanner, AddressBook addr) {
        if (addr.isEmpty()) System.out.println("The Address Book is currently empty");
        else {
            System.out.println("\nPlease choose the number of the contact that you would like to edit");
            String modifyContactChoice = scanner.nextLine();
            if (addr.isInteger(modifyContactChoice)) {
                if (addr.validateContact(modifyContactChoice)) {
                    String attrToBeModified;
                    boolean flag = true;
                    do {
                        System.out.println("Please choose the attribute to be modified: (1-First Name, 2-Last Name, 3-Email, 4-Phone)");
                        attrToBeModified = scanner.nextLine();
                        if ((attrToBeModified.compareTo("0") < 1) || (attrToBeModified.compareTo("4") > 0)) {
                            System.out.println("That attribute doesn't exist, please choose again\n");
                        } else {
                            System.out.println("Please enter the new value");
                            String newValue = scanner.nextLine();
                            addr.modifyContact(modifyContactChoice, attrToBeModified, newValue);
                            System.out.println("Would you like to make additional changes? y/n");
                            String additionalChange = scanner.nextLine();
                            if (additionalChange.equals("n")) {
                                flag = false;
                            }
                        }
                    } while (flag);
                } else System.out.println("\nNo such contact exists");
            } else System.out.println("\nInvalid value, returning to main menu");
        }
    }

    public static void removingContact(Scanner scanner, AddressBook addr) {
        if (addr.isEmpty()) System.out.println("The Address Book is currently empty");
        else {
            System.out.println("\nPlease choose the number of the contact that you would like to delete");
            String deleteContactChoice = scanner.nextLine();
            if(addr.isInteger(deleteContactChoice)){
                addr.deleteContact(deleteContactChoice);
            }else System.out.println("\nInvalid value, returning to main menu");

        }
    }
}