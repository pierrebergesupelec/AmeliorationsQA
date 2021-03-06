package mutation;
import java.util.ArrayList;

import modele.Element;
import modele.Etat;
import modele.Probleme;
import modele.RedondancesParticuleGeneral;

/**
 * Une mutation est une succession de mutations �l�mentaires
 * La classe fille de l'utilisateur contiendra un constructeur qui cr�era la listeMutations en fonction de son Probl�me, de l'�tat trait�,...
 * Le constructeur sera essentiel car c'est lui qui d�terminera comment seront r�alis�es les mutations.
 * L'utilisateur devra donner une valeur � la borneEc correspondant au type de mutation qu'il utilise.
 * borneEc est la valeur absolue de la variation maximale d'�nergie cin�tique lors d'une mutation. Cela permet d'acc�lerer le recuit avec RecuitAccelere
 * @author Pierre
 *
 */
public abstract class IMutation {
	public ArrayList<MutationElementaire> listeMutations;
	static double borneEc;
	
	public double getBorne(){
		return borneEc;
	}
	
	/**
	 * C'est la m�thode qui effectue toutes les mutations �l�mentaires de la liste
	 * L'utilisateur pourra overrider cette m�thode s'il le souhaite
	 * ATTENTION : C'est une mutation purement "m�canique" : l'argument energie ne doit pas �tre modifi� ici.
	 * Il faudra le faire par la suite (probl�mes de r�cursivit�s avec le delta sinon).
	 * @param e
	 * Etat de la particule sur lequel on effectue les mutations
	 */
public void faire(Probleme p, Etat e){
	int n = this.listeMutations.size();
	for (int i = 0; i < n; i++){
		this.listeMutations.get(i).faire(e);
	}
}
/**
 * Calcule la diff�rence d'energie potentielle suite � la mutation sur l'�tat e
 * L'utilisateur devra impl�menter cette m�thode dans la classe fille adapt�e
 * Cette m�thode ne modifie ni l'�tat ni le probl�me : elle indique juste la modification d'�nergie potentielle en cas de mutation
 * @param p
 * Probl�me sur lequel on mute
 * @param e
 * Etat de la particule sur lequel la mutation a lieu.
 * @return
 * Diff�rence d'�nergie potentielle apr�s mutation
 */
public abstract double calculerdeltaEp(Probleme p, Etat e);
/**
 * Calcule la diff�rence d'energie cin�tique suite � la mutation sur l'�tat e. On ne tient pas compte de la pond�ration dans ce calcul. En fait, on renvoie deltaEc/J.
 * L'utilisateur devra impl�menter cette m�thode dans la classe fille adapt�e
 * Cette m�thode ne modifie ni l'�tat ni le probl�me : elle indique juste la modification d'�nergie cin�tique (sans J) en cas de mutation
 * @param p
 * Probl�me sur lequel on mute
 * @param e
 * Etat de la particule sur lequel la mutation a lieu.
 * @return
 * Diff�rence d'�nergie cin�tique apr�s mutation
 */
public abstract double calculerdeltaSpins(Probleme p, Etat e);


/**
 * Transforme la mutation courante en une autre mutation, de m�me type(m�me type d'objet) mais diff�rente(arguments diff�rents)
 * C'est en fait un g�n�rateur de mutation al�atoire,cr�ant une mutation ind�pendante de la mutation trait�e mais de m�me type : c'est un constructeur en fait
 * L'utilisateur devra impl�menter cette m�thode dans la classe fille adapt�e. Elle sera �quivalente au constructeur a priori.
 */
public abstract void maj(Probleme p, Etat e);

public boolean estAutorisee(Probleme p,Etat e, RedondancesParticuleGeneral red){
	int nbMutations = this.listeMutations.size();
	boolean estAutorisee = true;
	int cpt = 0;
	while ((cpt < nbMutations) && (estAutorisee)){
		estAutorisee = this.listeMutations.get(cpt).estAutorisee(p,e,red);
		cpt++;
	}
	return estAutorisee;
}

/**
 * Application de la m�thode majRedondance pour toutes les mutations �l�mentaires de listeMutations
 * @param p
 * Probleme trait�
 * @param r
 * Redondances de la particule
 * @param e
 * Etat trait�, appartient au probl�me
 */
public void majRedondance(Probleme p,RedondancesParticuleGeneral r, Etat e){
	int n = this.listeMutations.size();
	for (int i = 0; i < n; i++){
		this.listeMutations.get(i).majRedondance(p, r, e);
	}
}
}
