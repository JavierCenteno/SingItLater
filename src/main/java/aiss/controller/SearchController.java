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
import aiss.model.resources.YouTubeResource;

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

		String query = request.getParameter("searchQuery");
		RequestDispatcher rd = null;



		log.log(Level.FINE, "Searching for YouTube songs that contain " + query);
		YouTubeResource Youtube = new YouTubeResource();
		VideoSearch VideoResults = Youtube.getVideos(query);

		if (VideoResults!=null){
			rd = request.getRequestDispatcher("/success.jsp");
			request.setAttribute("videos", VideoResults.getItems());


		} else {
			log.log(Level.SEVERE, "OMDb object: " + VideoResults);
			rd = request.getRequestDispatcher("/error.jsp");
		}
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}