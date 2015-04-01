package cn.com.jautoitx.contract;


import cn.com.jautoitx.domain.Color;

/**
 * @author: Andrzej Gdula
 * @created: 03/31/2015 13:42
 * @version: 1.0
 */
public interface Pixel {
	int INVALID_COLOR = -1;
	int DEFAULT_STEP = 1;

	/**
	 * Generates a checksum for a region of pixels.
	 *
	 * Performing a checksum of a region is very time consuming, so use the
	 * smallest region you are able to reduce CPU load. On some machines a
	 * checksum of the whole screen could take many seconds!
	 *
	 * A checksum only allows you to see if "something" has changed in a region
	 * - it does not tell you exactly what has changed.
	 *
	 * When using a step value greater than 1 you must bear in mind that the
	 * checksumming becomes less reliable for small changes as not every pixel
	 * is checked.
	 *
	 * @param left
	 *            left coordinate of rectangle.
	 * @param top
	 *            top coordinate of rectangle.
	 * @param right
	 *            right coordinate of rectangle.
	 * @param bottom
	 *            bottom coordinate of rectangle.
	 * @return Returns the checksum value of the region.
	 */
	int checksum(int left, int top, int right,
				 int bottom);

	/**
	 * Generates a checksum for a region of pixels.
	 *
	 * Performing a checksum of a region is very time consuming, so use the
	 * smallest region you are able to reduce CPU load. On some machines a
	 * checksum of the whole screen could take many seconds!
	 *
	 * A checksum only allows you to see if "something" has changed in a region
	 * - it does not tell you exactly what has changed.
	 *
	 * When using a step value greater than 1 you must bear in mind that the
	 * checksumming becomes less reliable for small changes as not every pixel
	 * is checked.
	 *
	 * @param left
	 *            left coordinate of rectangle.
	 * @param top
	 *            top coordinate of rectangle.
	 * @param right
	 *            right coordinate of rectangle.
	 * @param bottom
	 *            bottom coordinate of rectangle.
	 * @param step
	 *            Instead of checksumming each pixel use a value larger than 1
	 *            to skip pixels (for speed). E.g. A value of 2 will only check
	 *            every other pixel. Default is 1.
	 * @return Returns the checksum value of the region.
	 */
	int checksum(int left, int top, int right,
				 int bottom, Integer step);

	/**
	 * Returns a pixel color according to x,y pixel coordinates.
	 *
	 * @param x
	 *            x coordinate of pixel.
	 * @param y
	 *            y coordinate of pixel.
	 * @return Return decimal value of pixel's color if success, return null if
	 *         invalid coordinates.
	 */
	Integer getColor(int x, int y);

	/**
	 * Returns a java.awt.Color object according to x,y pixel coordinates.
	 *
	 * @param x
	 *            x coordinate of pixel.
	 * @param y
	 *            y coordinate of pixel.
	 * @return Return java.awt.Color object for pixel's color if success, return
	 *         null if invalid coordinates.
	 */
	Color getColor_(int x, int y); //TODO: get rid of awt

	/**
	 * Searches a rectangle of pixels for the pixel color provided.
	 *
	 * @param left
	 *            left coordinate of rectangle.
	 * @param top
	 *            top coordinate of rectangle.
	 * @param right
	 *            right coordinate of rectangle.
	 * @param bottom
	 *            bottom coordinate of rectangle.
	 * @param color
	 *            Colour value of pixel to find (in decimal or hex).
	 * @return Return a 2 element array containing the pixel's coordinates if
	 *         success, return null if color is not found.
	 */
	int[] search(int left, int top, int right,
				 int bottom, int color);

	/**
	 * Searches a rectangle of pixels for the pixel color provided.
	 *
	 * @param left
	 *            left coordinate of rectangle.
	 * @param top
	 *            top coordinate of rectangle.
	 * @param right
	 *            right coordinate of rectangle.
	 * @param bottom
	 *            bottom coordinate of rectangle.
	 * @param color
	 *            Colour value of pixel to find (in decimal or hex).
	 * @param shadeVariation
	 *            A number between 0 and 255 to indicate the allowed number of
	 *            shades of variation of the red, green, and blue components of
	 *            the colour. Default is 0 (exact match).
	 * @return Return a 2 element array containing the pixel's coordinates if
	 *         success, return null if color is not found.
	 */
	int[] search(int left, int top, int right,
				 int bottom, int color, Integer shadeVariation);

	/**
	 * Searches a rectangle of pixels for the pixel color provided.
	 *
	 * @param left
	 *            left coordinate of rectangle.
	 * @param top
	 *            top coordinate of rectangle.
	 * @param right
	 *            right coordinate of rectangle.
	 * @param bottom
	 *            bottom coordinate of rectangle.
	 * @param color
	 *            Colour value of pixel to find (in decimal or hex).
	 * @param shadeVariation
	 *            A number between 0 and 255 to indicate the allowed number of
	 *            shades of variation of the red, green, and blue components of
	 *            the colour. Default is 0 (exact match).
	 * @param step
	 *            Instead of searching each pixel use a value larger than 1 to
	 *            skip pixels (for speed). E.g. A value of 2 will only check
	 *            every other pixel. Default is 1.
	 * @return Return a 2 element array containing the pixel's coordinates if
	 *         success, return null if color is not found.
	 */
	int[] search(int left, int top, int right,
				 int bottom, int color, Integer shadeVariation,
				 Integer step);
}
