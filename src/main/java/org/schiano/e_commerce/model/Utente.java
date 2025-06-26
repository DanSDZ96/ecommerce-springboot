package org.schiano.e_commerce.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

public class Utente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false, unique = true)
	private String username;
	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false)
	private String password;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Ruolo ruolo;
	
	@OneToOne(mappedBy = "utente")
	private Carrello carrello;
	
	@OneToMany(mappedBy = "utente")
	private List<Ordine> ordini = new ArrayList<Ordine>();
	
	
	public Utente(String username, String email, String password) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(carrello, email, id, ordini, password, ruolo, username);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utente other = (Utente) obj;
		return Objects.equals(carrello, other.carrello) && Objects.equals(email, other.email)
				&& Objects.equals(id, other.id) && Objects.equals(ordini, other.ordini)
				&& Objects.equals(password, other.password) && Objects.equals(ruolo, other.ruolo)
				&& Objects.equals(username, other.username);
	}


	@Override
	public String toString() {
		return "Utente [username=" + username + ", email=" + email + ", password=" + password + ", ruolo=" + ruolo + "]";
	}
}
