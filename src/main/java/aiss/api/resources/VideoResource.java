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

@Path("/video")
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
	 * Request every single video searched.
	 */
	@GET
	@Produces("application/json")
	public Collection<Video> getAll() {
		return repository.getAll();
	}

	/**
	 * Return the video with its Id = videoId.
	 * 
	 * If video doesn't exits, returns: "404 Not Found".
	 */
	@GET
	@Path("/{videoID}")
	@Produces("application/json")
	public Video get(@PathParam("videoID") String id) {
		Video video = repository.getVideo(id);
		if (video == null) {
			throw new NotFoundException("404 Not Found");
		}
		return video;
	}

	/**
	 * Add a new video with all fields set.
	 * 
	 * If video doesn't exits or is not correct, returns: "400 Bad Request".
	 * 
	 * If video is showed successfully, returns: "201 Created" with its URI and its
	 * fields.
	 */
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response addPlaylist(@Context UriInfo uriInfo, Video video) {
		// Comprobar campos
		if (video.getUrl() == null || video.getUrl().equals("")) {
			throw new BadRequestException("400 Bad Request");
		}
		repository.addVideo(video);
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(video.getId());
		ResponseBuilder resp = Response.created(uri);
		resp.entity(video);
		return resp.build();
	}

	/**
	 * Update the video which its fields are sent in JSON (it must include video
	 * Id).
	 * 
	 * If video doesn't exits, returns: "404 Not Found".
	 * 
	 * If it is success, returns: "204 No Content".
	 */
	@PUT
	@Consumes("application/json")
	public Response updatePlaylist(Video video) {
		Video oldvideo = repository.getVideo(video.getId());
		if (oldvideo == null) {
			throw new NotFoundException("404 Not Found");
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
	 * Delete video with id = videoId.
	 */
	@DELETE
	@Path("/{videoID}")
	public Response removePlaylist(@PathParam("videoID") String id) {
		Video video = repository.getVideo(id);
		if (video == null) {
			throw new NotFoundException("404 Not Found");
		} else {
			repository.deleteVideo(id);
		}
		return Response.noContent().build();
	}

}
