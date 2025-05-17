package com.example.Login.Service;

import com.example.Login.DTO.EmployeeDTO;
import com.example.Login.DTO.LoginDTO;
import com.example.Login.payloadResponse.LoginMesage;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {
    String addEmployee(EmployeeDTO employeeDTO);

    LoginMesage loginEmployee(LoginDTO loginDTO);
}
