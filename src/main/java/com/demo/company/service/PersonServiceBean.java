package com.demo.company.service;

import com.demo.company.entity.Person;
import com.demo.company.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.demo.company.entity.Employee;
import com.demo.company.repository.EmployeeRepository;
import com.demo.config.data.Credential;

@Service
public class PersonServiceBean implements PersonService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PersonServiceBean.class);

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Page<Person> find(Pageable pageable) throws Exception {
        return personRepository.findByMarkForDeleteFalse(pageable);
    }

}
