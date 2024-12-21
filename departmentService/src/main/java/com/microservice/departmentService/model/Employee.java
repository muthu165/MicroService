package com.microservice.departmentService.model;

//No setters for record
public record Employee(Long id,Long departmentId,String name,int age,String position) {
}
