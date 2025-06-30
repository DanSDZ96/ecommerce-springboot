package org.schiano.e_commerce.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Prodotto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;
    
    @Column(nullable = false)
    private Integer disponibilita;
    
    @Column(nullable = false)
    private Double prezzo;
    
    @Column(nullable = false)
    private String nomeImmagine;

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;

    @OneToMany(mappedBy = "prodotto", orphanRemoval = true)
    private List<ProdottoNelCarrello> nelCarrello = new ArrayList<>();

    @OneToMany(mappedBy = "prodotto")
    private List<Acquisto> acquistati = new ArrayList<>();

    public Prodotto(String nome, Integer disponibilita, Double prezzo) {
        this.nome = nome;
        this.disponibilita = disponibilita;
        this.prezzo = prezzo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Prodotto other = (Prodotto) obj;
        return Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
        return "Prodotto [id=" + id + ", nome=" + nome + ", disponibilita=" + disponibilita +
                ", prezzo=" + prezzo + ", nomeImmagine=" + nomeImmagine + "]";
    }
}
