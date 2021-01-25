package com.demo.company.repository;

import com.demo.company.entity.Person;
import com.sun.deploy.perf.PerfRollup;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.demo.company.entity.Employee;

public interface PersonRepository extends MongoRepository<Person, String> {

    Employee findFirstByPersonCodeAndMarkForDeleteFalse(Integer personCode);

    Page<Person> findByMarkForDeleteFalse(Pageable pageable);

    void deleteByPersonCode(Integer personCode);
}
