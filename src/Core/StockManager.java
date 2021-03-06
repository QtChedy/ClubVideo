//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Club Video
//  @ File Name : StockManager.java
//  @ Date : 1/17/2016
//  @ Author : Chedy Najjar
//
//

package Core;

import java.sql.*;


public class StockManager {
	private DataBase clubDB;
	
	public void addFilm(Film film)throws SQLException {
		clubDB.insert("Film", film);
	}
	
	public void removeFilm(int id_film) throws SQLException {
		clubDB.delete("Film","id_film" , new Integer(id_film).toString());
	}
	
	public ResultSet filterFilm(String col, String value)  throws SQLException{
		
		return clubDB.select("Film", "titre,prix,type", col + " = " + value);
	
	}
	
	public StockManager() throws SQLException {
		clubDB = new DataBase();
		clubDB.connect("clubvideo", "root", "");
	}
	
	public void addRealisateur(Realisateur r) throws SQLException
	{
		clubDB.insert("Realisateur", r);
	}
	
	public void removeRealisateur(int id_rea) throws SQLException {
		clubDB.delete("Realisateur","id_realisateur" , new Integer(id_rea).toString());
		clubDB.delete("Film", "id_realisateur",  new Integer(id_rea).toString());
	}
	
	public ResultSet getAllFilms() throws SQLException
	{
		String sqlQuery = "select * from Film";
		return clubDB.getStatment().executeQuery(sqlQuery);
	}
	public ResultSet getAllFilms(String cols) throws SQLException
	{
		String sqlQuery = "select "+ cols+ " from Film";
		return clubDB.getStatment().executeQuery(sqlQuery);
	}
	
	public ResultSet getAllRealisateur() throws SQLException
	{
		String sqlQuery = "select *from Realisateur";
		return clubDB.getStatment().executeQuery(sqlQuery);
	}
	
	public Film toFilm(int row)
	{
		try
		{
			ResultSet rs = this.getAllFilms();
		    rs.next();
			for(int i =0; i < row;++i,rs.next());
			System.out.println("index row : "+row );
			String type = rs.getString("type");
			String titre = rs.getString("titre");
			double prix = rs.getDouble("prix");
			int idR = rs.getInt("id_realisateur");
			rs.close();
			String sql = "select nom,prenom from Realisateur where id_realisateur = "+idR; 
			ResultSet s = clubDB.getStatment().executeQuery(sql);
			if(s.next())
			{
				FilmFactory fact = new FilmFactory();
				return fact.makeFilm(Film.convertTypeFromAsciiToNumber(type), 
								 	new Realisateur(s.getString("nom"), s.getString("prenom")), 
								 	titre, 
								 	prix);
			}
			return null;
			
		}
		catch(SQLException s)
		{
			System.out.println("error");
			s.printStackTrace();
			return null;
		}

	}
}
