package com.jspiders.contactapplication.service;

import com.jspiders.contactapplication.pojo.Contact;
import com.jspiders.contactapplication.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    public Optional<Contact> getContactById(int id) {
        return contactRepository.findById(id);
    }

    public Contact createContact(Contact contact) {
        return contactRepository.save(contact);
    }
    
    public Optional<Contact> updateContact(int id, Contact contactDetails) {
        Optional<Contact> optionalContact = contactRepository.findById(id);

        if (optionalContact.isPresent()) {
            Contact contact = optionalContact.get();
            contact.setName(contactDetails.getName());
            contact.setPhoto(contactDetails.getPhoto());
            contact.setContact(contactDetails.getContact());
            contact.setEmail(contactDetails.getEmail());
            contact.setCompany(contactDetails.getCompany());
            contact.setTitle(contactDetails.getTitle());
            contact.setGroupId(contactDetails.getGroupId());
            return Optional.of(contactRepository.save(contact));
        } else {
            return Optional.empty();
        }
    }

    public boolean deleteContact(int id) {
        Optional<Contact> optionalContact = contactRepository.findById(id);

        if (optionalContact.isPresent()) {
            contactRepository.delete(optionalContact.get());
            return true;
        } else {
            return false;
        }
    }
    public List<Contact> searchContactsByName(String name) {
        return contactRepository.findByNameContainingIgnoreCase(name);
    }
}
