package com.demo.company.service;

import com.demo.company.entity.Employee;
import com.demo.company.entity.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PersonService {
//    void create(Person person) throws Exception;
//
//    void update(Integer personCode, Person person) throws Exception;

    Page<Person> find(Pageable pageable) throws Exception;
//
//    Person findByCode(Integer code) throws Exception;
//
//    void deleteByPersonNo(Integer code) throws Exception;
}
