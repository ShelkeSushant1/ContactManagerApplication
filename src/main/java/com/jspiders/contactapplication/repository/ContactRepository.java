package com.jspiders.contactapplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jspiders.contactapplication.pojo.Contact;
@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {
	List<Contact> findByNameContainingIgnoreCase(String name);
}
