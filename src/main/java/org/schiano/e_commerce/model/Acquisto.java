package org.schiano.e_commerce.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Acquisto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable=false)
	private String nomeProdotto;
	@Column(nullable=false)
	private Double prezzoProdotto;
	@Column(nullable=false)
	private Integer quantita;
	
	@ManyToOne
	@JoinColumn(name = "ordine_id", nullable = false)
	private Ordine ordine;
	
	@ManyToOne
	@JoinColumn(name = "prodotto_id", nullable = false)
	private Prodotto prodotto;
	
	
	public Acquisto(String nomeProdotto, Double prezzoProdotto, Integer quantita){
		this.nomeProdotto = nomeProdotto;
		this.prezzoProdotto = prezzoProdotto;
		this.quantita = quantita;
	}
		
	@Override
	public int hashCode() {
		return Objects.hash(id, nomeProdotto, ordine, prezzoProdotto, prodotto);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Acquisto other = (Acquisto) obj;
		return Objects.equals(id, other.id) && Objects.equals(nomeProdotto, other.nomeProdotto)
				&& Objects.equals(ordine, other.ordine) && Objects.equals(prezzoProdotto, other.prezzoProdotto)
				&& Objects.equals(prodotto, other.prodotto);
	}
	@Override
	public String toString() {
		return "Acquisto [id=" + id + ", nomeProdotto=" + nomeProdotto + ", prezzoProdotto=" + prezzoProdotto + "]";
	};
}
