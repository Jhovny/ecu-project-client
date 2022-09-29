package ecu.project.client.domain.dto;


import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@Builder
public class Person {

    private Long idPerson;
    private String name;
    private String gender;
    private int age;
    private String addres;
    private String phone;
    private String identification;

}
