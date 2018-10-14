import java.util.Scanner;


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
            if (addr.isInteger(deleteContactChoice)) {
                addr.deleteContact(deleteContactChoice);
            } else System.out.println("\nInvalid value, returning to main menu");

        }
    }
}