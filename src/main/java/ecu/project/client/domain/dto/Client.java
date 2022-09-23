package ecu.project.client.domain.dto;


import lombok.Builder;
import lombok.Data;



@Data
@Builder
public class Client  {

    private Long idClient;
    private Long idPerson;
    private String contrasenia;
    private Boolean estado;
    private String clientId;
    private Person person;


}
