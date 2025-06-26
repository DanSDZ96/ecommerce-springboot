package org.schiano.e_commerce.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String nome;
	
	@OneToMany(mappedBy = "categoria")
	private List<Prodotto> prodotti = new ArrayList<Prodotto>();
	
	public Categoria(String nome){
		this.nome = nome;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(id, nome, prodotti);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		return Objects.equals(id, other.id) && Objects.equals(nome, other.nome)
				&& Objects.equals(prodotti, other.prodotti);
	}
	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nome=" + nome + "]";
	};
}

