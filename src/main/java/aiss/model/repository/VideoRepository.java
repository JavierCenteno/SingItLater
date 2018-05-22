package aiss.model.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import aiss.model.Video;

public class VideoRepository {

	// Campos de clase

	private static VideoRepository INSTANCE;

	// Campos de instancia

	Map<String, Video> videoMap;

	private int index;

	// Inicializador de clase

	static {
		INSTANCE = new VideoRepository();
	}

	// Inicializador de instancia

	private VideoRepository() {
		// Inicializar parámetros del repositorio
		videoMap = new HashMap<String, Video>();
		index = -1;
		// Rellenar el repositorio
		this.addVideo(new Video("https://www.youtube.com/watch?v=YQHsXMglC9A"));
		this.addVideo(new Video("https://www.youtube.com/watch?v=3YxaaGgTQYM"));
	}

	// Métodos de clase

	public static VideoRepository getInstance() {
		return INSTANCE;
	}

	// Métodos de instancia

	public Video getVideo(String id) {
		return videoMap.get(id);
	}

	public Collection<Video> getAll() {
		return videoMap.values();
	}

	public void addVideo(Video video) {
		String id = "v" + ++index;
		video.setId(id);
		videoMap.put(id, video);
	}

	public void updateVideo(Video video) {
		videoMap.put(video.id, video);
	}

	public void deleteVideo(String id) {
		videoMap.remove(id);
	}

}
