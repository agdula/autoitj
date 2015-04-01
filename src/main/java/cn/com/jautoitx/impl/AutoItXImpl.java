package cn.com.jautoitx.impl;

import cn.com.jautoitx.contract.AutoItX;
import cn.com.jautoitx.jna.AutoItXLibrary;
import com.sun.jna.Native;
import com.sun.jna.Platform;

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Logger;

/**
 * 
 * 
 * @author zhengbo.wang
 */
public class AutoItXImpl implements AutoItX {
	/* AutoItX's version */
	private static String AUTOITX_VERSION = null;

	public static int INT_BUF_SIZE = String.valueOf(Integer.MIN_VALUE)
			.length();
	public static int BOOLEAN_BUF_SIZE = 8;
	public static int HANDLE_BUF_SIZE = 20;

	/* AutoItX library name */
	private static final String DLL_LIB_NAME = "AutoItX3"
			+ (Platform.is64Bit() ? "_x64" : "");

	/* AutoItX library path */
	private static final String DLL_LIB_RESOURCE_PATH = "/cn/com/jautoitx/lib/";

	private static final Logger logger = Logger.getLogger(AutoItXImpl.class.getName());

	public static AutoItXLibrary autoItX;

	static {
		// Initialize AutoIt
		initAutoItX();
	}

	protected AutoItXImpl() {
		// Do nothing
	}

	/**
	 * Initialize AutoItX.
	 */
	private static void initAutoItX() {
		// Initialize AutoItX
		try {
			autoItX = loadNativeLibrary();

			logger.fine("AutoItX initialized.");
		} catch (Throwable e) {
			logger.warning("Unable to initialize "
					+ AutoItXImpl.class.getSimpleName());
		}
	}

	/**
	 * Unpacking and loading the library into the Java Virtual Machine.
	 */
	protected static AutoItXLibrary loadNativeLibrary() {
		try {
			// Get what the system "thinks" the library name should be.
			String libNativeName = System.mapLibraryName(DLL_LIB_NAME);

			// Slice up the library name.
			int i = libNativeName.lastIndexOf('.');
			String libNativePrefix = libNativeName.substring(0, i) + '_';
			String libNativeSuffix = libNativeName.substring(i);

			// This may return null in some circumstances.
			InputStream libInputStream = AutoItXImpl.class
					.getResourceAsStream(DLL_LIB_RESOURCE_PATH.toLowerCase()
							+ libNativeName);
			if (libInputStream == null) {
				throw new IOException("Unable to locate the native library.");
			}

			// Create the temp file for this win32 of the library.
			File libFile = File
					.createTempFile(libNativePrefix, libNativeSuffix);
			libFile.deleteOnExit();

			// Copy AutoItX.dll or AutoItX_x64.dll library to the temp file.
			copyInputStreamToFile(libInputStream, libFile);
			closeQuietly(libInputStream);
			if (AUTOITX_VERSION == null) {
				AUTOITX_VERSION = LocalInstances.win32.getFileVersion(libFile);
			}

			System.load(libFile.getPath());

			Native.setProtected(true);
			return (AutoItXLibrary) Native.loadLibrary(libFile.getName(),
					AutoItXLibrary.class);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	/**
	 * Get AutoItX's version.
	 * 
	 * @return Returns AutoItX's version.
	 */
	public String version() {
		return AUTOITX_VERSION;
	}

	/**
	 * Get error property for the last AutoItX method if it will set error code.
	 * 
	 * @return Returns error property.
	 */
	public int error() {
		return autoItX.AU3_error();
	}

	/**
	 * Check last AutoItX method execute status.
	 * 
	 * @return Returns true if last AutoItX method has error, otherwise return
	 *         false.
	 */
	public boolean hasError() {
		return error() != 0;
	}


	private static void closeQuietly(final Closeable closeable) {
		if (closeable != null) {
			try {
				closeable.close();
			} catch (IOException e) {
				// Ignore exception
			}
		}
	}

	private static void copyInputStreamToFile(final InputStream input,
			final File file) throws IOException {
		OutputStream output = null;
		try {
			output = new FileOutputStream(file);
			int n = 0;
			byte[] buffer = new byte[4 * 1024];
			while ((n = input.read(buffer)) != -1) {
				output.write(buffer, 0, n);
			}
		} finally {
			closeQuietly(output);
		}
	}

}
