package no.hvl.dat102.oppgave2.adt;

public interface DobbelKjedetOrdnetListeMADT<T> {
	 
	 /**
	  * 
	  * @param el er elementet som skal legges til
	  */
	  void leggTil(T el);
	  
	  
	  /**
	   * 
	   * @param el er elementet det søkes etter
	   * @return true hvis elementet fins ellers false
	   */    
	  boolean fins(T el);
	  
	  /**
	   * 
	   * @param el er elementet som skal fjernes hvis det fins
	   * @return elementet som skal fjernes ellers returneres null
	   */  
	  T fjern(T el);
	  
	}