package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;

import com.fasterxml.jackson.databind.ObjectMapper;


import aiss.model.musicxmatch.BusquedaSearch;


public class MusicxmatchResource {

	private static final Logger log = Logger.getLogger(MusicxmatchResource.class.getName());
	
public BusquedaSearch getLyric(String query) throws UnsupportedEncodingException {
	
		String cancion=URLEncoder.encode(query, "UTF-8");
		
		String uri="https://api.musixmatch.com/ws/1.1/matcher.lyrics.get?q_track="+cancion+"&q_artist="+cancion+"&apikey=d7d676d3ac47b5679c9e7eaf27d6aefe";				
		ClientResource cr=new ClientResource(uri);
		BusquedaSearch lyric=new BusquedaSearch();
		ObjectMapper mapper=new ObjectMapper();
		//String s=cr.get(String.class);
		//System.out.println(lyric);
		//BusquedaLetra lyric=null;
		try{
		lyric=mapper.readValue(cr.get(String.class), BusquedaSearch.class);	
		}catch(Throwable e){
		e.printStackTrace();
		}
	    return lyric;
	}
}

