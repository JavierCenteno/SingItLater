package aiss.model.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import aiss.model.Lyrics;

public class LyricsRepository {

	// Campos de clase

	private static LyricsRepository INSTANCE;

	// Campos de instancia

	Map<String, Lyrics> lyricsMap;

	private int index;

	// Inicializador de clase

	static {
		INSTANCE = new LyricsRepository();
	}

	// Inicializador de instancia

	private LyricsRepository() {
		lyricsMap = new HashMap<String, Lyrics>();
		index = -1;
		// TODO: rellenar esto con letras
	}

	// Métodos de clase

	public static LyricsRepository getInstance() {
		return INSTANCE;
	}

	// Métodos de instancia

	public Lyrics getLyrics(String id) {
		return lyricsMap.get(id);
	}

	public Collection<Lyrics> getAll() {
		return lyricsMap.values();
	}

	public void addLyrics(Lyrics lyrics) {
		String id = "v" + ++index;
		lyrics.setId(id);
		lyricsMap.put(id, lyrics);
	}

	public void updateLyrics(Lyrics lyrics) {
		lyricsMap.put(lyrics.id, lyrics);
	}

	public void deleteLyrics(String id) {
		lyricsMap.remove(id);
	}

}
