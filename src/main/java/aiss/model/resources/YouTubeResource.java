package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;

import aiss.model.YouTube.VideoSearch;


public class YouTubeResource {
	
	private static final String YT_API_KEY = "AIzaSyC0EL4XvyKTxNXyEGZrnXRPNUHaibKHOxI";  // TODO: Change this API KEY for your personal Key
	private static final Logger log = Logger.getLogger(YouTubeResource.class.getName());
	
	public VideoSearch getVideos (String query) throws UnsupportedEncodingException {

		String video = URLEncoder.encode(query, "UTF-8");
		String uri = "https://www.googleapis.com/youtube/v3/search?part=id&q=" + video + "&type=video&key=" + YT_API_KEY ;
		ClientResource cr = new ClientResource(uri);
		VideoSearch YTSearch = cr.get(VideoSearch.class);
	    return YTSearch;
	}
}