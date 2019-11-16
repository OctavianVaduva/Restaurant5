package entitati;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "comenzi")
public class Comanda {

	@Id
	@Column(name = "id_comanda")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer idComanda;
	
	@Column(name = "nr_masa")
	public Integer nrMasa;
	
	@Column(name = "nume_ospatar")
	public String numeOspatar;
	
	@Column(name = "data_creare")
	public Date dataCreare;
	
	@Column(name = "data_livrare")
	public Date dataLivrare;
	

	@Column(name = "pret_total_comanda")
	public Double pretTotalComanda;
	
	@Column(name = "incasat")
	public Double incasat;
	
	@Column(name = "data_incasare")
	public Date dataIncasare;
	
	@Column(name = "continut_comanda")
	public String continutComanda;

	public Comanda(Integer nrMasa, String numeOspatar, Date dataCreare, Double pretTotalComanda, 
			String continutComanda) {
		super();
		this.nrMasa = nrMasa;
		this.numeOspatar = numeOspatar;
		this.dataCreare = dataCreare;
		this.pretTotalComanda = pretTotalComanda;
		this.continutComanda = continutComanda;
	}

	public Comanda() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getIdComanda() {
		return idComanda;
	}

	public void setIdComanda(Integer idComanda) {
		this.idComanda = idComanda;
	}

	public Integer getNrMasa() {
		return nrMasa;
	}

	public void setNrMasa(Integer nrMasa) {
		this.nrMasa = nrMasa;
	}

	public String getNumeOspatar() {
		return numeOspatar;
	}

	public void setNumeOspatar(String numeOspatar) {
		this.numeOspatar = numeOspatar;
	}

	public Double getPretTotalComanda() {
		return pretTotalComanda;
	}

	public void setPretTotalComanda(Double pretTotalComanda) {
		this.pretTotalComanda = pretTotalComanda;
	}

	public Double getIncasat() {
		return incasat;
	}

	public void setIncasat(Double incasat) {
		this.incasat = incasat;
	}

	public Date getDataIncasare() {
		return dataIncasare;
	}

	public void setDataIncasare(Date dataIncasare) {
		this.dataIncasare = dataIncasare;
	}

	public String getContinutComanda() {
		return continutComanda;
	}

	public void setContinutComanda(String continutComanda) {
		this.continutComanda = continutComanda;
	}

	public Date getDataCreare() {
		return dataCreare;
	}

	public void setDataCreare(Date dataCreare) {
		this.dataCreare = dataCreare;
	}

	public Date getDataLivrare() {
		return dataLivrare;
	}

	public void setDataLivrare(Date dataLivrare) {
		this.dataLivrare = dataLivrare;
	}

	

}
