package sh.stein.carbon;

import java.io.File;
import java.io.IOException;

/**
 * A service used to interact with Carbon.
 *
 * @see <a href="https://github.com/carbon-app/carbon">https://github.com/carbon-app/carbon</a>
 * @see <a href="https://carbon.now.sh/">https://carbon.now.sh/</a>
 */
public interface CarbonService {

    /**
     * Gets an image using the specified code.
     *
     * @param code code to get an image of
     * @return the image as a byte array
     */
    byte[] getImage(String code);

    /**
     * Gets an image using the specified code and options.
     *
     * @param code    code to get an image of
     * @param options an {@code ImageOptions} instance
     * @return the image as a byte array
     */
    byte[] getImage(String code, ImageOptions options);

    /**
     * Gets an image using the specified file's contents.
     *
     * @param file a {@code File} instance
     * @return the image as a byte array
     * @throws IOException if the file cannot be read
     */
    byte[] getImage(File file) throws IOException;

    /**
     * Gets an image using the specified file's contents and options.
     *
     * @param file    a {@code File} instance
     * @param options an {@code ImageOptions} instance
     * @return the image as a byte array
     * @throws IOException if the file cannot be read
     */
    byte[] getImage(File file, ImageOptions options) throws IOException;
}
