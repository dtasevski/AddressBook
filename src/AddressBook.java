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

        int counter = 0;
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).contains(Integer.parseInt(criteria),searchQuery)) {
                (contacts.get(i)).printContact();
                counter++;
            }
        }
        if (counter == 0) System.out.println("No contacts found");
    }

    public void deleteContact(String deleteContactChoice) {
        if (((Integer.parseInt(deleteContactChoice) - 1) < contacts.size()) && (Integer.parseInt(deleteContactChoice)) > 0) {
            contacts.remove((Integer.parseInt(deleteContactChoice) - 1));
        } else {
            System.out.println("\nNo such contact exists");
        }
    }

    public void modifyContact(String modifyContactChoice, String attrToBeModified, String newValue) {
        contacts.get((Integer.parseInt(modifyContactChoice) - 1)).modifyAttribute(Integer.parseInt(modifyContactChoice), newValue);

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