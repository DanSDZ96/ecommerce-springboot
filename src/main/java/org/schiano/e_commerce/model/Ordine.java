package org.schiano.e_commerce.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
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

public class Ordine {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private LocalDate data_ordine;
	
	@ManyToOne
	@JoinColumn( name = "utente_id", nullable = false)
	private Utente utente;
	
	@OneToMany(mappedBy = "ordine", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Acquisto> acquisti = new ArrayList<Acquisto>();
	
	public Ordine(LocalDate data_ordine) {
		this.data_ordine = data_ordine;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(acquisti, data_ordine, id, utente);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ordine other = (Ordine) obj;
		return Objects.equals(acquisti, other.acquisti) && Objects.equals(data_ordine, other.data_ordine)
				&& Objects.equals(id, other.id) && Objects.equals(utente, other.utente);
	}
	@Override
	public String toString() {
		return "Ordine [id=" + id + ", data_ordine=" + data_ordine + "]";
	}
	
	
}
