package aiss.controller.oauth;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import aiss.model.resources.SpotifyResource;
//import aiss.model.spotify.Artists;
import aiss.model.spotify.Songsearch;
//import aiss.model.spotify.SpotifySearch;

/**
 * Servlet implementation class SearchController
 */
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Logger log = Logger.getLogger(SearchController.class.getName());
	 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchController() {
        super();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		//
		String query = request.getParameter("searchQuery");
		RequestDispatcher rd = null;
		
		// Search for movies in OMDb
		//log.log(Level.FINE, "Searching for Flickr photos that contains " + query);
		//FlickrResource flickr = new FlickrResource();
		//PhotoSearch flickrResults = flickr.getFlickrPhotos(query);
		
		
		log.log(Level.FINE, "Searching for Spotify songs that contain " + query);
		SpotifyResource spotify = new SpotifyResource();
		//Artists spotifyResults = spotify.getArtists()/*omdb.getMovies(query)*/ ;
		Songsearch spotifyResults = spotify.getSongs(query);
		//
		
		if (spotifyResults!=null){
			rd = request.getRequestDispatcher("/success.jsp");
			request.setAttribute("songs", spotifyResults.getName());	
		} else {
			log.log(Level.SEVERE, "OMDb object: " + spotifyResults);
			rd = request.getRequestDispatcher("/error.jsp");
		}
		rd.forward(request, response);
		
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
