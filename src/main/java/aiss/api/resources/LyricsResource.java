package aiss.api.resources;

import java.net.URI;
import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.jboss.resteasy.spi.BadRequestException;
import org.jboss.resteasy.spi.NotFoundException;

import aiss.model.Lyrics;
import aiss.model.repository.LyricsRepository;

@Path("/api/lyrics")
public class LyricsResource {

	// Campos de clase

	private static LyricsResource INSTANCE;

	// Campos de instancia

	LyricsRepository repository;

	// Inicializador de clase

	static {
		INSTANCE = new LyricsResource();
	}

	// Inicializador de instancia

	private LyricsResource() {
		repository = LyricsRepository.getInstance();
	}

	// Métodos de clase

	public static LyricsResource getInstance() {
		return INSTANCE;
	}

	// Métodos de instancia

	/**
	 * Request every single lyrics searched.
	 */
	@GET
	@Produces("application/json")
	public Collection<Lyrics> getAll() {
		return repository.getAll();
	}

	/**
	 * Return the lyrics with its Id = lyricsId.
	 * 
	 * If lyrics doesn't exits, returns: "404 Not Found".
	 */
	@GET
	@Path("/{lyricsID}")
	@Produces("application/json")
	public Lyrics get(@PathParam("lyricsID") String id) {
		Lyrics lyrics = repository.getLyrics(id);
		if (lyrics == null) {
			throw new NotFoundException("Not Found");
		}
		return lyrics;
	}

	/**
	 * Add a new lyrics with all fields set.
	 * 
	 * If lyrics doesn't exits or is not correct, returns: "400 Bad Request".
	 * 
	 * If lyrics is showed successfully, returns: "201 Created" with its URI and its
	 * fields.
	 */
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response addPlaylist(@Context UriInfo uriInfo, Lyrics lyrics) {
		// Comprobar campos
		if (lyrics.getLyrics() == null || lyrics.getLyrics().equals("")) {
			throw new BadRequestException("Bad Request");
		}
		repository.addLyrics(lyrics);
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(lyrics.getId());
		ResponseBuilder resp = Response.created(uri);
		resp.entity(lyrics);
		return resp.build();
	}

	/**
	 * Update the lyrics which its fields are sent in JSON (it must include lyrics
	 * Id).
	 * 
	 * If lyrics doesn't exits, returns: "404 Not Found".
	 * 
	 * If it is success, returns: "204 No Content".
	 */
	@PUT
	@Consumes("application/json")
	public Response updatePlaylist(Lyrics lyrics) {
		Lyrics oldLyrics = repository.getLyrics(lyrics.getId());
		if (oldLyrics == null) {
			throw new NotFoundException("Not Found");
		}
		// Comprobar campos
		if (lyrics.getLyrics() == null || lyrics.getLyrics().equals("")) {
			throw new BadRequestException("The URL of the lyrics must not be null");
		}
		// Actualizar campos
		if (lyrics.getLyrics() != null) {
			oldLyrics.setLyrics(lyrics.getLyrics());
		}
		return Response.noContent().build();
	}

	/**
	 * Delete lyrics with id = lyricsId.
	 */
	@DELETE
	@Path("/{lyricsID}")
	public Response removePlaylist(@PathParam("lyricsID") String id) {
		Lyrics lyrics = repository.getLyrics(id);
		if (lyrics == null) {
			throw new NotFoundException("Not Found");
		} else {
			repository.deleteLyrics(id);
		}
		return Response.noContent().build();
	}

}
