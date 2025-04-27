
package com.example.gatito.gatito;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Cascade;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "gatitos")
public class Gatito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "nombre")
    public String nombre;

    @Column(name = "color")
    public String color;

    @Column(name = "genero")
    public String genero;

    @ElementCollection
    @CollectionTable(name = "gatito_seriesfav", joinColumns = @JoinColumn(name = "gatito_id"))
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    public List<String> seriesfav = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "gatito_cancionesfav", joinColumns = @JoinColumn(name = "gatito_id"))
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    public List<String> cancionesfav = new ArrayList<>();}
