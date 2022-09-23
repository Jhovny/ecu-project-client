package ecu.project.client.persistence.model.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name="tb_client")
public class ClientEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="bi_id_client")
    @Id
    private Long idClient;

    @Column(name="bi_id_person")
    private Long idPerson;

    @Column(name="cv_contrasenia")
    private String contrasenia;

    @Column(name="bt_estado")
    private Boolean estado;

    @Column(name="cv_client_id")
    private String clientId;

    @ManyToOne
    @JoinColumn(name = "bi_id_person", insertable = false, updatable = false)
    private PersonEntity person;

}
