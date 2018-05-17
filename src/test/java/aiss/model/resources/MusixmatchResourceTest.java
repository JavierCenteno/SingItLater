package aiss.model.resources;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import aiss.model.musicxmatch.BusquedaSearch;

public class MusixmatchResourceTest {

	/**
	 * Recurso que estamos probando.
	 */
	private MusicxmatchResource musicxmatchResource;
	/**
	 * Término usado en las búsquedas.
	 */
	private String query;

	{
		musicxmatchResource = new MusicxmatchResource();
		query = "hello";
	}

	@Test
	public void searchLyricsTest() {
		BusquedaSearch busquedaSearch = null;
		try {
			busquedaSearch = musicxmatchResource.getLyric(query);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		/*
		 * Lanza NullPointerException si busquedaSearch o el mensaje es null.
		 */
		busquedaSearch.getMessage().getBody();
	}

}
