import java.util.ArrayList;

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