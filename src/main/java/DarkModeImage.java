import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class DarkModeImage {

    public static void main(String[] args) throws IOException {
        // Load the input image
        File inputFile = new File("C:\\Users\\claytonc\\OneDrive - The Biovac Institute\\Pictures\\Saved Pictures\\Biovac - Copy.png"
        );
        BufferedImage image = ImageIO.read(inputFile);

        // Create a new image with the same dimensions as the input image
        BufferedImage darkImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);

        // Loop through all pixels in the input image
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                // Get the color of the current pixel in the input image
                Color color = new Color(image.getRGB(x, y));

                // Convert the color to the HSB color space
                float[] hsb = Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), null);

                // Invert the brightness value
                hsb[2] = 1.0f - hsb[2];

                // Convert the color back to the RGB color space
                int rgb = Color.HSBtoRGB(hsb[0], hsb[1], hsb[2]);
                Color darkColor = new Color(rgb, true);

                // Set the color of the corresponding pixel in the output image
                darkImage.setRGB(x, y, darkColor.getRGB());
            }
        }

        // Save the resulting image as a new PNG file
        File outputFile = new File("C:\\Users\\claytonc\\OneDrive - The Biovac Institute\\Pictures\\Saved Pictures\\Output.png");
        ImageIO.write(darkImage, "png", outputFile);
    }
}
