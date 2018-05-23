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

import aiss.model.Video;
import aiss.model.repository.VideoRepository;

@Path("/api/video")
public class VideoResource {

	// Campos de clase

	private static VideoResource INSTANCE;

	// Campos de instancia

	VideoRepository repository;

	// Inicializador de clase

	static {
		INSTANCE = new VideoResource();
	}

	// Inicializador de instancia

	private VideoResource() {
		repository = VideoRepository.getInstance();
	}

	// Métodos de clase

	public static VideoResource getInstance() {
		return INSTANCE;
	}

	// Métodos de instancia

	/**
	 * Returns all videos searched.
	 * 
	 * Use example:
	 * >>> curl -X GET -i http://localhost:8090/api/video/
	 * <<< [{"id":"v0","url":"url0"},{"id":"v1","url":"url1"}]
	 */
	@GET
	@Produces("application/json")
	public Collection<Video> getAll() {
		return repository.getAll();
	}

	/**
	 * Returns the video with id equal to videoID.
	 * 
	 * If the video does not exist, returns "404 Not Found".
	 * 
	 * Use example:
	 * >>> curl -X GET -i http://localhost:8090/api/video/v0
	 * <<< {"id":"v0","url":"url0"}
	 */
	@GET
	@Path("/{videoID}")
	@Produces("application/json")
	public Video getVideo(@PathParam("videoID") String id) {
		Video video = repository.getVideo(id);
		if (video == null) {
			throw new NotFoundException("Not Found");
		}
		return video;
	}

	/**
	 * Adds a new video.
	 * 
	 * If the video is not correct, returns "400 Bad Request".
	 * 
	 * Otherwise, returns "201 Created", the video's URI and its fields.
	 * 
	 * Use example:
	 * >>> curl -X POST -H 'Content-Type: application/json' -i http://localhost:8090/api/video/ --data '{"url":"new url"}'
	 * <<< {"id":"new id","url":"new url"}
	 */
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response addVideo(@Context UriInfo uriInfo, Video video) {
		// Comprobar campos
		if (video.getUrl() == null || video.getUrl().equals("")) {
			throw new BadRequestException("Bad Request");
		}
		repository.addVideo(video);
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "getVideo");
		URI uri = ub.build(video.getId());
		ResponseBuilder resp = Response.created(uri);
		resp.entity(video);
		return resp.build();
	}

	/**
	 * Updates the video with the given id using the given fields.
	 * 
	 * If the video does not exist, returns "404 Not Found".
	 * 
	 * If the video is not correct, returns "400 Bad Request".
	 * 
	 * Otherwise, returns "204 No Content".
	 * 
	 * Use example:
	 * >>> curl -X PUT -H 'Content-Type: application/json' -i http://localhost:8090/api/video/ --data '{"id":"v0","url":"new url"}'
	 * <<<
	 */
	@PUT
	@Consumes("application/json")
	public Response updateVideo(Video video) {
		Video oldvideo = repository.getVideo(video.getId());
		if (oldvideo == null) {
			throw new NotFoundException("Not Found");
		}
		// Comprobar campos
		if (video.getUrl() == null || video.getUrl().equals("")) {
			throw new BadRequestException("The URL of the video must not be null");
		}
		// Actualizar campos
		if (video.getUrl() != null) {
			oldvideo.setUrl(video.getUrl());
		}
		return Response.noContent().build();
	}

	/**
	 * Deletes the video with id equal to videoID.
	 * 
	 * If the video does not exist, returns "404 Not Found".
	 * 
	 * Use example:
	 * >>> curl -X DELETE -i http://localhost:8090/api/video/v0
	 * <<<
	 */
	@DELETE
	@Path("/{videoID}")
	public Response deleteVideo(@PathParam("videoID") String id) {
		Video video = repository.getVideo(id);
		if (video == null) {
			throw new NotFoundException("Not Found");
		} else {
			repository.deleteVideo(id);
		}
		return Response.noContent().build();
	}

}
