package org.schiano.e_commerce.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Carrello {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "utente_id", nullable = false)
    private Utente utente;

    @OneToMany(mappedBy = "carrello", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<ProdottoNelCarrello> prodottiNelCarrello = new ArrayList<>();


    @Override
    public int hashCode() {
        return Objects.hash(id, utente);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Carrello other = (Carrello) obj;
        return Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
        return "Carrello [id=" + id + ", utente=" + utente + "]";
    }
}
