package aiss.model.resources;

import org.junit.Test;

import aiss.model.google.drive.FileItem;

public class GoogleDriveResourceTest {

	private static String ACCESS_TOKEN = "ya29.Glu9BYVb4jA5KR0-6jLX3MZdjPUoc3rpxOIZRq8p21zDkPWeQ0KnAWA46oYF7AcXErrr_fCFRiw_6IrsVxkO00Rtd4LtJcu1E-PyBlzIuKT5qTJHQptzsSfDE8at";

	/**
	 * Recurso que estamos probando.
	 */
	private GoogleDriveResource googleDriveResource;
	/**
	 * Título usado para la creación del archivo.
	 */
	private String title;
	/**
	 * Contenido usado para la creación del archivo.
	 */
	private String content;

	{
		googleDriveResource = new GoogleDriveResource(ACCESS_TOKEN);
		title = "test";
		content = "this is a test";
	}

	@Test
	public void createFileTest() {
		FileItem file = new FileItem();
		file.setTitle(title);
		file.setMimeType("text/plain");
		String id = googleDriveResource.insertFile(file, content);
		FileItem newFile = googleDriveResource.getFile(id);
		/*
		 * Lanza NullPointerException si el archivo o su título es null.
		 */
		newFile.getTitle().equals(title);
	}

}
