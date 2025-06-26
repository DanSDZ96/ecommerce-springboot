package org.schiano.e_commerce.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ProdottoNelCarrello {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "carrello_id", nullable = false)
    private Carrello carrello;

    @ManyToOne
    @JoinColumn(name = "prodotto_id", nullable = false)
    private Prodotto prodotto;

    @Column(nullable = false)
    private int quantita;

    @Override
    public int hashCode() {
        return Objects.hash(carrello, prodotto);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ProdottoNelCarrello other = (ProdottoNelCarrello) obj;
        return Objects.equals(carrello, other.carrello) &&
               Objects.equals(prodotto, other.prodotto);
    }

	@Override
	public String toString() {
		return "ProdottoNelCarrello [id=" + id + ", carrello=" + carrello + ", prodotto=" + prodotto.getNome() + ", quantita="
				+ quantita + "]";
	}

  
}
