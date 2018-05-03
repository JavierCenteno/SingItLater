package aiss.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import aiss.model.musicxmatch.BusquedaSearch;
import aiss.model.resources.MusicxmatchResource;



/**
 * Servlet implementation class SearchController
 */
public class LyricController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Logger log = Logger.getLogger(LyricController.class.getName());
	 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LyricController() {
        super();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		String query = request.getParameter("searchQuery");
		RequestDispatcher rd = null;
		
		// Search for albums in Spotify
		log.log(Level.FINE, "Searching for the lyric of song" + query);
		//SpotifyResource spotify = new SpotifyResource();
		//AlbumSearch spotifyResults = spotify.getAlbums(query);
		MusicxmatchResource solicitaLetra = new MusicxmatchResource();
		BusquedaSearch resultado=solicitaLetra.getLyric(query);
		
		if (resultado!=null){
			rd = request.getRequestDispatcher("/success.jsp");
			request.setAttribute("letras", resultado.getMessage().getBody().getLyrics().getLyricsBody());
		} else {
			log.log(Level.SEVERE, "Letra object: " + resultado);
			rd = request.getRequestDispatcher("/error.jsp");
		}
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
