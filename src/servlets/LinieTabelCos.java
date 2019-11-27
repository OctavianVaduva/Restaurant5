package servlets;

public class LinieTabelCos { // clasa de ajutor pentru crearea liniilor de cos
		public Integer idProdus;
		public String numeProdus;
		public String descriereProdus;
		public Double pretUnitar;
		public Integer cantitate;
		public Double pretTotal;
		
	public LinieTabelCos() {
		// TODO Auto-generated constructor stub
	}

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
	
	

}
