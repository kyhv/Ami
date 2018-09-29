package sodepami.com.ami.custom;

import java.util.Comparator;

import sodepami.com.ami.model.Contact;

public class ContactComparator implements Comparator<Contact>{

    @Override
    public int compare(Contact contact, Contact t1) {
        return contact.getName().compareTo(t1.getName());
    }
}
