package com.rest.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
class EmpController {

    @Autowired
    public Employee emp;

    @Autowired
    public CustomResponse resp;

    //http://localhost:8080/emp
    @GetMapping("emp")
    public Employee getEmp() {
        List<Employee> e = new ArrayList<>();
        // Employee emp = new Employee();
        emp.age = 10;
        emp.name = "sanketh";

        return emp;
    }

    @GetMapping("/")
    public Employee home() {
        List<Employee> e = new ArrayList<>();
        // Employee emp = new Employee();
        emp.age = 10;
        emp.name = "Elon Musk";

        return emp;
    }

    //http://localhost:8080/content?content=elon%20musk
    @GetMapping("/content")
    public ResponseEntity postdata(@RequestParam(name = "content") String content) {
        // Employee emp1 = new Employee();
        emp.age = 20;
        emp.name = content;
        System.out.println("content is  " + content);
        return ResponseEntity.ok().body(emp);
    }

    /*The same can be achieved by GetRequestMapping, but all the data or parameters passed 
    on url is visible, to hide the data from being visible in URL all the data is taken via payload
    */
    @PostMapping(path = "/members", consumes = "application/json", produces = "application/json")
    public ResponseEntity addMember(@RequestBody Employee member) {
        System.out.println("after deserialization");
        System.out.println("name is  " + member.getName());
        System.out.println("age is " + member.getAge());
        // String success = "success";
        // CustomResponse resp = new CustomResponse();
        // ResponseEntity.status(200);
        resp.setStatus(ResponseEntity.ok());
        resp.setResponse("SUCCESSFULLY STORED DATA");
        return ResponseEntity.ok().body(resp);
        // ResponseEntity<String> resp = ResponseEntity;
        // return "stored sucessfully";
    }
}