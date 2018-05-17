package aiss.model.resources;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import aiss.model.YouTube.VideoSearch;
import aiss.model.resources.YouTubeResource;

public class YoutubeResourceTest {

	/**
	 * Recurso que estamos probando.
	 */
	private YouTubeResource youtubeResource;
	/**
	 * Término usado en las búsquedas.
	 */
	private String query;

	{
		youtubeResource = new YouTubeResource();
		query = "hello";
	}

	@Test
	public void searchVideosTest() {
		VideoSearch videoSearch = null;
		try {
			videoSearch = youtubeResource.getVideos(query);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		/*
		 * Lanza IndexOutOfBoundsException si la lista está vacía; lanza
		 * NullPointerException si la lista es null.
		 */
		videoSearch.getItems().get(0);
	}

}
