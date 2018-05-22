package aiss.api;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import aiss.api.resources.LyricsResource;
import aiss.api.resources.VideoResource;

public class SingItLaterApplication extends Application {

	// Campos de instancia

	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> classes = new HashSet<Class<?>>();

	// Inicializador de instancia

	public SingItLaterApplication() {
		/*
		 * Loads all resources that are implemented in the application so that they can
		 * be found by RESTEasy.
		 */
		singletons.add(VideoResource.getInstance());
		singletons.add(LyricsResource.getInstance());
	}

	// Métodos de instancia

	@Override
	public Set<Class<?>> getClasses() {
		return classes;
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}

}
