package modele;

/**
 * Un etat a par d�faut ses voisins definis a NULL, il doit etre modifi� par l'utilisateur.
 * L'utilisateur se devra d'instancier Etat en une classe correspondant � son probleme.
 * Les m�thodes de l'Etat de l'utilisateur seront celles qui contiennent la consigne "L'utilisateur devra..."
 * 
 */
public abstract class Etat {
	
	public double energie;
	
	public double getEnergie(){
		return this.energie;
	}
	
	public void setEnergie(double energie){
		this.energie = energie;
	}
	
	public void setDeltapot(double deltapot){
		this.energie += deltapot;
	}
	/**
	 * Clone l'etat
	 * L'utilisateur devra impl�menter cette m�thode de mani�re � cloner son Etat.
	 * Cette m�thode lui servira certainement pour la m�thode Probleme.clone()
	 */
	public abstract Etat clone();
	
	/**
	 * L'utilisateur devra impl�menter cette m�thode
	 * On calcule ici l'�nergie potentielle de l'�tat en fonction des �l�ments plac�s en arguments.
	 * @return
	 * L'energie potentielle de l'etat
	 */
	public abstract double majEnergie();
	
	/**
	 * Met � jour un nouvel �tat. Equivalent au constructeur
	 * Utilis� pour le param�treur
	 */
	public abstract void maj();
	
	public abstract double getResultat();

}
