

public interface Ex1Navio {
	
	/* 
	 * @ requires getCargaTotal() + mercadoria.getPeso() <= getCapacidadeCarga();
	 */
	boolean embarcar(ITransportavel mercadoria);
	
	int calculaFrete();
	
	/* 
	 * @ ensures \result > 0;
	 * @ pure
	 */
	int getCapacidadeCarga();
	
	/* 
	 * @ ensures \result == (\sum (int i; 0<=i && i<numRecords(); getMercadoria(i).getPeso()));
	 * @pure
	 */
	int getCargaTotal();
	
	/*
	 * @ ensures \result >= 0;
	 */
	int getNumMercadorias();
	
	/* @ requires i >= 0 && i <= getNumMercadorias();
	 * @ requires getNumMercadorias() > 0;
	 */
	ITransportavel getMercadoria(int i);
	
}
