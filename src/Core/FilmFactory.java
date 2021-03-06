//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Club Video
//  @ File Name : FilmFactory.java
//  @ Date : 1/17/2016
//  @ Author : Chedy Najjar
//
//

package Core;


public class FilmFactory {
	public Film makeFilm(int type, Realisateur r, String tit, double prx) {
		
		if(type == 1)
			return new FilmRomance(tit,r,prx);
		else if(type == 2)
		{
			return new FilmAction(tit,r,prx);
		}
		else if(type == 3)
			return new FilmScienceFiction(tit,r,prx);
		else
			return null;
	}
}
