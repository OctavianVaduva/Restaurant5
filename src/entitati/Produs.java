package entitati;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "produse")
public class Produs {
	
	
	@Id
	@Column(name = "id_produs")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer idProdus;
	
	
	@Column(name = "id_categorie")
	public Integer idCategorie;
	
	@Column(name = "nume_produs")
    public String numeProdus;
	
	@Column(name = "descriere_produs")
    public String descriereProdus;
	
	@Column(name = "pret_unitar")
    public Double pretUnitar;
	
	@Column(name="nivel_existent")
    public Integer stoc;
	
	@Column(name="nivel_alerta")
	public Integer nivelAlerta;
	
	
//	@ManyToOne
//	public Categorie categorie;
    

	public Produs(Integer idProdus, Integer idCategorie, String numeProdus, String descriereProdus, Double pretUnitar,
			Integer stoc, Integer nivelAlerta) {
		super();
		this.idProdus = idProdus;
		this.idCategorie = idCategorie;
		this.numeProdus = numeProdus;
		this.descriereProdus = descriereProdus;
		this.pretUnitar = pretUnitar;
		this.stoc = stoc;
		this.nivelAlerta = nivelAlerta;
	}

	public Produs() {
//		super();
	}

	public Integer getIdProdus() {
		return idProdus;
	}
	public void setIdProdus(Integer idProdus) {
		this.idProdus = idProdus;
	}
	
	public Integer getIdCategorie() {
		return idCategorie;
	}
	public void setIdCategorie(Integer idCategorie) {
		this.idCategorie = idCategorie;
	}
	
	public String getNumeProdus() {
		return numeProdus;
	}
	public void setNumeProdus(String numeProdus) {
		this.numeProdus = numeProdus;
	}
	
	public String getDescriereProdus() {
		return descriereProdus;
	}
	public void setDescriereProdus(String descriereProdus) {
		this.descriereProdus = descriereProdus;
	}
	
	public Double getPretUnitar() {
		return pretUnitar;
	}
	public void setPretUnitar(Double pretUnitar) {
		this.pretUnitar = pretUnitar;
	}

	public Integer getStoc() {
		return stoc;
	}
	public void setStoc(Integer stoc) {
		this.stoc = stoc;
	}

	public Integer getNivelAlerta() {
		return nivelAlerta;
	}
	public void setNivelAlerta(Integer nivelAlerta) {
		this.nivelAlerta = nivelAlerta;
	}

}
