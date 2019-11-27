package servlets.admin;

import java.util.Date;

public class LinieTabelComandaOspatar {
    public Integer idProdus;
    public String numeProdus;
    public Integer idCommandItem;
    public String descriereProdus;
    public Double pretUnitar;
    public Integer cantitate;
    public Double pretTotal;
    public Date dataLivrare;
    
    public Integer getIdProdus() {
        return idProdus;
    }
    public void setIdProdus(Integer idProdus) {
        this.idProdus = idProdus;
    }
    public String getNumeProdus() {
        return numeProdus;
    }
    public void setNumeProdus(String numeProdus) {
        this.numeProdus = numeProdus;
    }
    
    public Integer getIdCommandItem() {
		return idCommandItem;
	}
	public void setIdCommandItem(Integer idCommandItem) {
		this.idCommandItem = idCommandItem;
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
    public Integer getCantitate() {
        return cantitate;
    }
    public void setCantitate(Integer cantitate) {
        this.cantitate = cantitate;
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
