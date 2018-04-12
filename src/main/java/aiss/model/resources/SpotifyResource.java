package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;

import aiss.model.spotify.Songsearch;

public class SpotifyResource {


	private static final Logger log = Logger.getLogger(SpotifyResource.class.getName());
	
	public Songsearch getSongs(String query) throws UnsupportedEncodingException {
		
		// TODO: Perform search in Spotify
		String song=URLEncoder.encode(query, "UTF-8");
		String uri = "https://api.spotify.com/v1/tracks/"+song;
		ClientResource cr=new ClientResource(uri);
		Songsearch songSearch=cr.get(Songsearch.class);
		
	    return songSearch;
	}
}
