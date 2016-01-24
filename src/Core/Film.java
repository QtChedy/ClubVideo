//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Club Video
//  @ File Name : Film.java
//  @ Date : 1/17/2016
//  @ Author : Chedy Najjar
//
//

package Core;


abstract public class Film {
	private String titre;
	private Realisateur realisateur;
	private double prix;
	
	public Film(String titre, Realisateur reali, double prx) {
		this.titre = titre;
		realisateur = reali;
		prix = prx;
	
	}

	public String getTitre() {
		return titre;
	}
	
	public String getRealisteurName() {
		return realisateur.getNom();
	}
	public String getRealisateurPrenom()
	{
		return realisateur.getPrenom();
	}
	
	public double getPrix() {
		return prix;
	}
	
	public Realisateur getRealisteur() {
		return realisateur;
	
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(prix);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((realisateur == null) ? 0 : realisateur.hashCode());
		result = prime * result + ((titre == null) ? 0 : titre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Film other = (Film) obj;
		if (Double.doubleToLongBits(prix) != Double.doubleToLongBits(other.prix)) {
			return false;
		}
		if (realisateur == null) {
			if (other.realisateur != null) {
				return false;
			}
		} else if (!realisateur.equals(other.realisateur)) {
			return false;
		}
		if (titre == null) {
			if (other.titre != null) {
				return false;
			}
		} else if (!titre.equals(other.titre)) {
			return false;
		}
		return true;
	}
	
	

	@Override
	public String toString() {
		return ",'"+titre +"',"+ prix+",";
	}

	public abstract int getType();
}
