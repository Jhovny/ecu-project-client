package ecu.project.client.persistence.model.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name="tb_person")
public class PersonEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="bi_id_person")
    @Id
    private Long idPerson;

    @Column(name="cv_name")
    private String name;

    @Column(name="cv_gender")
    private String gender;

    @Column(name="in_age")
    private int age;

    @Column(name="cv_addres")
    private String addres;

    @Column(name="cv_phone")
    private String phone;

    @Column(name="cv_identification")
    private String identification;

    @OneToMany(mappedBy = "person")
    private List<ClientEntity> clients;
}
