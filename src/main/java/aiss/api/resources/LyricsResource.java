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
	 * Returns all lyrics searched.
	 * 
	 * Use example:
	 * >>> curl -X GET -i http://localhost:8090/api/lyrics/
	 * <<< [{"id":"l0","lyrics":"lyrics0"},{"id":"l1","lyrics":"lyrics1"}]
	 */
	@GET
	@Produces("application/json")
	public Collection<Lyrics> getAll() {
		return repository.getAll();
	}

	/**
	 * Returns the lyrics with its Id = lyricsId.
	 * 
	 * If the lyrics do not exist, returns "404 Not Found".
	 * 
	 * Use example:
	 * >>> curl -X GET -i http://localhost:8090/api/lyrics/l0
	 * <<< {"id":"l0","lyrics":"lyrics0"}
	 */
	@GET
	@Path("/{lyricsID}")
	@Produces("application/json")
	public Lyrics getLyrics(@PathParam("lyricsID") String id) {
		Lyrics lyrics = repository.getLyrics(id);
		if (lyrics == null) {
			throw new NotFoundException("Not Found");
		}
		return lyrics;
	}

	/**
	 * Adds new lyrics.
	 * 
	 * If the lyrics are not correct, returns "400 Bad Request".
	 * 
	 * Otherwise, returns "201 Created", the lyrics' URI and their fields.
	 * 
	 * Use example:
	 * >>> curl -X POST -H 'Content-Type: application/json' -i http://localhost:8090/api/lyrics/ --data '{"lyrics":"new lyrics"}'
	 * <<< {"id":"new id","lyrics":"new lyrics"}
	 */
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response addLyrics(@Context UriInfo uriInfo, Lyrics lyrics) {
		// Comprobar campos
		if (lyrics.getLyrics() == null || lyrics.getLyrics().equals("")) {
			throw new BadRequestException("Bad Request");
		}
		repository.addLyrics(lyrics);
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "getLyrics");
		URI uri = ub.build(lyrics.getId());
		ResponseBuilder resp = Response.created(uri);
		resp.entity(lyrics);
		return resp.build();
	}

	/**
	 * Updates the lyrics with the given id using the given fields.
	 * 
	 * If the lyrics do not exist, returns "404 Not Found".
	 * 
	 * If the lyrics are not correct, returns "400 Bad Request".
	 * 
	 * Otherwise, returns "204 No Content".
	 * 
	 * Use example:
	 * >>> curl -X PUT -H 'Content-Type: application/json' -i http://localhost:8090/api/lyrics/ --data '{"id":"l0","lyrics":"new lyrics"}'
	 * <<<
	 */
	@PUT
	@Consumes("application/json")
	public Response updateLyrics(Lyrics lyrics) {
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
	 * Deletes the lyrics with id equal to lyricsID.
	 * 
	 * If the lyrics do not exist, returns "404 Not Found".
	 * 
	 * >>> curl -X DELETE -i http://localhost:8090/api/lyrics/l0
	 * <<<
	 */
	@DELETE
	@Path("/{lyricsID}")
	public Response deleteLyrics(@PathParam("lyricsID") String id) {
		Lyrics lyrics = repository.getLyrics(id);
		if (lyrics == null) {
			throw new NotFoundException("Not Found");
		} else {
			repository.deleteLyrics(id);
		}
		return Response.noContent().build();
	}

}
