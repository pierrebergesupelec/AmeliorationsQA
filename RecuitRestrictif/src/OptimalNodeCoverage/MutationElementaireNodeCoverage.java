package OptimalNodeCoverage;


import modele.Element;
import modele.Etat;
import modele.Probleme;
import modele.RedondancesParticuleGeneral;
import mutation.MutationElementaire;

public class MutationElementaireNodeCoverage extends MutationElementaire {

	public MutationElementaireNodeCoverage(Element elt, int indice) {
		super(elt, indice);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void faire(Etat e){
		/*ElementMKP elt = (ElementMKP) e.getListe().get(this.getIndice());
		elt.changeAppartenance();
		int m = ((Remplissage)e).getInstance().getNombreSacs();
		for (int i = 0; i < m; i++){
			if (elt.getAppartenance()) ((Remplissage)e).getPoids()[m] += elt.getObjet().getWeight()[m];
			if (!elt.getAppartenance()) ((Remplissage)e).getPoids()[m] -= elt.getObjet().getWeight()[m];
		}*/
		System.out.println("alerte");
	}
	
	public boolean estAutorisee(Probleme p, Etat e, RedondancesParticuleGeneral red){
		if (p.getFreq() > 1) return true;
		ElementNodeCoverage a = (ElementNodeCoverage) e.getListe().get(this.getIndice());
		RedondancesParticuleNodeCoverage r = (RedondancesParticuleNodeCoverage) red;
		int i = a.getAnchor().identifier; 
		//systeme de Hashcode via les noeuds dans un set
		return (r.getTab()[i] <= p.getFreq()*p.nombreEtat());
	}
	@Override
	public void majRedondance(Probleme p, RedondancesParticuleGeneral red, Etat e){
		Coverage re = (Coverage) e;
		RedondancesParticuleNodeCoverage r = (RedondancesParticuleNodeCoverage) red;
		ElementNodeCoverage elt = (ElementNodeCoverage) this.getElement();
		//systeme de Hashcode via les noeuds dans un set
		
		
		A CODER
	}
	
	
	
	
	
}
