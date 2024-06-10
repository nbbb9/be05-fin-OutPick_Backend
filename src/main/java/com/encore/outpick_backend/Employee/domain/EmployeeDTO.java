package com.encore.outpick_backend.Employee.domain;

import java.time.LocalDate;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class EmployeeDTO {
    private int employee_id;
    private int employee_number;
    private String name;
    private String position;
    private String address;
    private String contact;
    private String birthdate;
    private String state;
    private LocalDate hired_date;
    @JsonIgnore
    private String password;

    private List<Integer> shop;
    private List<Integer> add_shop;
    private List<Integer> delete_shop;

}
