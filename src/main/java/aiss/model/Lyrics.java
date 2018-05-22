package aiss.model;

public class Lyrics {

	// Campos de instancia

	public String id;
	public String lyrics;

	// Inicializador de instancia

	public Lyrics(String lyrics) {
		this.id = null;
		this.lyrics = lyrics;
	}

	// Métodos de instancia

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLyrics() {
		return lyrics;
	}

	public void setLyrics(String lyrics) {
		this.lyrics = lyrics;
	}

}
