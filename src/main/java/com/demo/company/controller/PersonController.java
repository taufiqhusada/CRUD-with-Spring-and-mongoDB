package com.demo.company.controller;

import com.demo.base.ListBaseResponse;
import com.demo.base.Metadata;
import com.demo.company.entity.Employee;
import com.demo.company.entity.Person;
import com.demo.company.service.EmployeeService;
import com.demo.company.service.PersonService;
import com.demo.dto.EmployeeResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = PersonControllerPath.BASE_PATH)
public class PersonController {
    @Autowired
    private PersonService personService;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ListBaseResponse<Person> findPersons(@RequestParam String storeId, @RequestParam String channelId,
                                                            @RequestParam String clientId, @RequestParam String requestId, @RequestParam String username,
                                                            @RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "10") Integer size)
            throws Exception {
        Pageable pageable = PageRequest.of(page, size);
        Page<Person> persons = this.personService.find(pageable);
        List<Person> personResponses = persons.getContent();
        return new ListBaseResponse<>(null, null, true, requestId, personResponses,
                new Metadata(page, size, persons.getTotalElements()));
    }

}
