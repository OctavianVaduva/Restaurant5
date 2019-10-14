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
	
	@Column(name = "data_comanda")
	public Date dataComanda;
	
	@Column(name = "pret_total_comanda")
	public Double pretTotalComanda;
	
	@Column(name = "incasat")
	public Double incasat;
	
	@Column(name = "data_incasare")
	public Date dataIncasare;
	
	@Column(name = "continut_comanda")
	public String continutComanda;

	public Comanda(Integer nrMasa, String numeOspatar, Date dataComanda, Double pretTotalComanda, Double incasat,
			Date dataIncasare, String continutComanda) {
		super();
		this.nrMasa = nrMasa;
		this.numeOspatar = numeOspatar;
		this.dataComanda = dataComanda;
		this.pretTotalComanda = pretTotalComanda;
		this.incasat = incasat;
		this.dataIncasare = dataIncasare;
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

	public Date getDataComanda() {
		return dataComanda;
	}

	public void setDataComanda(Date dataComanda) {
		this.dataComanda = dataComanda;
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


	

}
