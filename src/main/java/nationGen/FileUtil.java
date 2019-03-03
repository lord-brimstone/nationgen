package nationGen;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.List;
import java.util.stream.Collectors;


public final class FileUtil {
	
	private FileUtil() {
		throw new UnsupportedOperationException("Do not instantiate.");
	}
	
	/**
	 * Reads an image resource from a file path.
	 * @param filepath The path to the image
	 * @return The buffered image object
	 */
	public static BufferedImage readImage(String filepath) {
		
		BufferedImage image;
		try {
			image = ImageIO.read(getResource(filepath));
		} catch (IOException ioe) {
			throw new IllegalArgumentException("File '" + filepath + "' can't be read into an image.", ioe);
		}
		return image;
	}
	
	public static List<String> readLines(String filepath) {
		
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(getResource(filepath)))) {
			return reader.lines().collect(Collectors.toList());
		} catch (IOException e) {
			throw new IllegalArgumentException("File " + filepath + "' can't be read.", e);
		}
	}
	
	public static boolean resourceExists(String filename) {
		return FileUtil.class.getResource(filename) != null;
	}
	
	private static InputStream getResource(String filepath) {
		InputStream resourceLocation = FileUtil.class.getResourceAsStream(filepath);
		if (resourceLocation == null) {
			throw new IllegalArgumentException("File '" + filepath + "' can't be found.");
		}
		return resourceLocation;
	}
}
