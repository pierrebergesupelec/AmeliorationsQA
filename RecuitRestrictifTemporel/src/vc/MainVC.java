package vc;

import java.io.IOException;

import parametres.ParametreGammaLin;
import recuit.Recuit;

public class MainVC {
	
public static void main(String[] args){
		
		int nombreEtat = 10;
		Graphe g = null;
		try {
			g = Traducteur.traduire("C:/Users/Pierre/Desktop/benchmark/vc/dsjc250.5.col");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int n = g.getConnexions().length; ;
		System.out.println(n);
		int nombreIterations = n*n;//on est des fous pas tar�s non plus
		int nbColors = 28;
		
		double temperature = 0.1/nombreEtat ; 

		
		//       Test Recuit
		
		
		int cpt = 0;
		
		try {
			for (int i = 0; i < 1; i++){
				ParametreGammaLin gamma = new ParametreGammaLin(10.0,10.0/(nombreIterations+1),0.0);
				ParticuleVC p = ParticuleVC.initialise(nombreEtat,0.5,g,nbColors);
				MutationVC m = new MutationVC((Coloriage)p.getEtat().get(0));
				RedondancesParticuleVC red = new RedondancesParticuleVC(p);
				Recuit.solution(p,m,red,nombreIterations,1,1,1,temperature,gamma);
			}
			System.out.println(cpt);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
