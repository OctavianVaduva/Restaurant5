package util;

import java.util.List;

import entitati.Produs;

public interface ProdusDAO {

	void setup();

	void exit();

	Produs getProdusById(Integer idProdus);

	List readAllProducts();

	void updateStoc(Produs p);

}