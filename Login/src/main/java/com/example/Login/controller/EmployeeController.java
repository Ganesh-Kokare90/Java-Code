package com.example.Login.controller;


import com.example.Login.DTO.EmployeeDTO;
import com.example.Login.DTO.LoginDTO;
import com.example.Login.Service.EmployeeService;
import com.example.Login.payloadResponse.LoginMesage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @PostMapping(path = "/save")
    public String saveEmployee(@RequestBody EmployeeDTO employeeDTO)
    {
        String id = employeeService.addEmployee(employeeDTO);
        return id;
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> loginEmployee(@RequestBody LoginDTO loginDTO)
    {
        LoginMesage loginMesage = employeeService.loginEmployee(loginDTO);
        return ResponseEntity.ok(loginMesage);
    }

}
