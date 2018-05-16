package aiss.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.YouTube.VideoSearch;
import aiss.model.musicxmatch.BusquedaSearch;
import aiss.model.resources.MusicxmatchResource;
import aiss.model.resources.YouTubeResource;



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
		
		// Search videos in YouTube in order to download mp3
		YouTubeResource Youtube = new YouTubeResource();
		VideoSearch VideoResults = Youtube.getVideos(query);
		log.log(Level.FINE, "Searching for the lyric of song" + query);
		//SpotifyResource spotify = new SpotifyResource();
		//AlbumSearch spotifyResults = spotify.getAlbums(query);
		MusicxmatchResource solicitaLetra = new MusicxmatchResource();
		BusquedaSearch resultado=solicitaLetra.getLyric(query);
		
		if (resultado!=null){
			rd = request.getRequestDispatcher("/successlyrics.jsp");
			request.setAttribute("letras", resultado.getMessage().getBody().getLyrics().getLyricsBody());
			request.setAttribute("videos", VideoResults.getItems());
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
