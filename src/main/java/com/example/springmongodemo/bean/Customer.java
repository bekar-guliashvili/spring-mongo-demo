package com.example.springmongodemo.bean;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@Document(collection = "customer") // table name
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Customer {
    @Id
    private String id;
    @NotBlank(message = "First Name is required")
    private String firstName;
    @NotBlank(message = "Last Name is required")
    private String lastName;
    @NotNull(message = "Age is required")
    private Integer age;
    private List<@Valid Address> addresses;
}
