package entitati;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.xml.internal.bind.v2.TODO;

@Entity
@Table(name = "command_items")
public class CommandItem {

	public CommandItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@Column(name = "id_item")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer idItem;
	
	@Column(name = "id_comanda")
	public Integer idComanda;

	@Column(name = "data_creare_item")
	public Date dataCreare;

	@Column(name = "id_produs")
	public Integer idProdus;
	
	@Column(name = "nr_produse")
	public Integer nrProduse;
	
	@Column(name = "pret_total")
	public Double pretTotal;

	@Column(name = "data_livrare_item")
	public Date dataLivrare;

	public Integer getIdItem() {
		return idItem;
	}

	public void setIdItem(Integer idItem) {
		this.idItem = idItem;
	}

	public Integer getIdComanda() {
		return idComanda;
	}

	public void setIdComanda(Integer idComanda) {
		this.idComanda = idComanda;
	}

	public Date getDataCreare() {
		return dataCreare;
	}

	public void setDataCreare(Date dataCreare) {
		this.dataCreare = dataCreare;
	}

	public Integer getIdProdus() {
		return idProdus;
	}

	public void setIdProdus(Integer idProdus) {
		this.idProdus = idProdus;
	}

	public Integer getNrProduse() {
		return nrProduse;
	}

	public void setNrProduse(Integer nrProduse) {
		this.nrProduse = nrProduse;
	}

	public Double getPretTotal() {
		return pretTotal;
	}

	public void setPretTotal(Double pretTotal) {
		this.pretTotal = pretTotal;
	}

	public Date getDataLivrare() {
		return dataLivrare;
	}

	public void setDataLivrare(Date dataLivrare) {
		this.dataLivrare = dataLivrare;
	}
	

}
