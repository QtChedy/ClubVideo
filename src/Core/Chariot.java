//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : Chariot.java
//  @ Date : 
//  @ Author : 
//
//

package Core;

import java.util.Vector;


public class Chariot {
	public double total;
	public int date;
	public Vector<Film> films;
	
	public Chariot(int d) 
	{
		total = 0;
		films = new Vector<>();
	}
	public boolean addFilm(Film film)
	{
		if(!films.contains(film))
		{
			films.add(film);
			total = total + film.getPrix();
			return true;
		}
		return false;
	}
}
