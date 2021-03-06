package LHD_1fixed;

public class Croix {
	public int[] coord; //les coordonn�es de la croix
	//La dimension de la grille correspondra � la longueur de ce tableau
	boolean estFixee;
	
	public Croix(int[] coord){
		this.coord = coord;
		this.estFixee = false;
	}
	
	public Croix(int[] coord, boolean b){
		this.coord = coord;
		this.estFixee = b;
	}
	
	public int[] getCoord(){
		return this.coord;
	}
	
	public boolean isFixed(){
		return this.estFixee;
	}
	
	public boolean equals(Croix autre) {
		//On regarde si les coordonn�es de la croix courante sont identiques aux coordonn�es de l'autre
		//Prend pas en compte le c�t� "fix�/pas fix�"
		int i =0;
		while( (this.coord[i]==autre.coord[i]) && (i<this.coord.length) ){
			i++;
		}
		return (i==this.coord.length);
	}
	
	public int getDimension(){
		return this.coord.length;
	}
	
	public Croix clone(){
		//On recopie les anciennes coordonn�es dans un nouveau tableau
		int[] tab = new int[this.getDimension()];
		for (int i = 0; i < this.getDimension(); i++){
			tab[i] = this.getCoord()[i];
		}
		//A partir de ce tableau, on cr�e une nouvelle croix
		return new Croix(tab,this.estFixee);
	}
	
	public String toString(){
		String s = "";
		int k = this.getDimension();
		for (int i = 0; i < k; i++){
			s += this.coord[i] + " ";
		}
		return s;
	}

}
