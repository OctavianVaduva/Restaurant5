package entitati;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categorie_produs")
public class Categorie {

	@Id
	@Column(name = "id_categorie_produs")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer idCategorieProdus;
	
	@Column(name = "nume_categorie_produs")
    public String numeCategorieProdus;
	
	public Categorie(Integer idCategorie, String numeCategorieProdus) {
		super();
		this.idCategorieProdus = idCategorie;
		this.numeCategorieProdus = numeCategorieProdus;
	}

	public Categorie() {
		// TODO Auto-generated constructor stub
	}

	public Integer getIdCategorieProdus() {
		return idCategorieProdus;
	}

	public void setIdCategorieProdus(Integer idCategorieProdus) {
		this.idCategorieProdus = idCategorieProdus;
	}

	public String getNumeCategorieProdus() {
		return numeCategorieProdus;
	}

	public void setNumeCategorieProdus(String numeCategorieProdus) {
		this.numeCategorieProdus = numeCategorieProdus;
	}

}
