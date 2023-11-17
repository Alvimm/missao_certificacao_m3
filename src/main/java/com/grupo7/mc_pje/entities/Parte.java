package com.grupo7.mc_pje.entities;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "parte")
public class Parte implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String nome;
    @Column(unique = true, nullable = false)
    @Pattern(regexp = "^[0-9]{11,14}$")
    private String documento;
    private String email;
    private String cep;
    private String numero;
    @ManyToOne
    @JoinColumn (name = "endereco_id")
    private Endereco endereco;
}
