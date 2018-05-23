package aiss.model;

public class Video {

	// Campos de instancia

	public String id;
	public String url;

	// Inicializadores de instancia

	public Video() {
		this.id = null;
		this.url = null;
	}

	public Video(String url) {
		this.id = null;
		this.url = url;
	}

	// Métodos de instancia

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
