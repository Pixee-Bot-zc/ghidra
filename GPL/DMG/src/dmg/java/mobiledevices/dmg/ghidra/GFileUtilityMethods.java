/* ###
 * IP: Public Domain
 */
package mobiledevices.dmg.ghidra;

import java.io.*;
import java.nio.file.Files;


public final class GFileUtilityMethods {

	private static final String GHIDRA_FILE_SYSTEM_PREFIX = "ghidra_file_system_";
	private static final String GHIDRA_FILE_SYSTEM_SUFFIX = ".tmp";

	public final static File writeTemporaryFile( InputStream inputStream ) throws IOException {
		return writeTemporaryFile( inputStream , Integer.MAX_VALUE );
	}

	public final static File writeTemporaryFile( InputStream inputStream, int maxBytesToWrite ) throws IOException {
		File tempOutputFile = Files.createTempFile(GHIDRA_FILE_SYSTEM_PREFIX, GHIDRA_FILE_SYSTEM_SUFFIX).toFile();
		tempOutputFile.deleteOnExit();
		OutputStream outputStream = new FileOutputStream( tempOutputFile );
		try {
			int nWritten = 0;
			byte [] buffer = new byte[ 8192 ];
			while ( true ) {
				int nRead = inputStream.read( buffer );
				if ( nRead == -1 ) {
					break;
				}
				outputStream.write( buffer, 0, nRead );
				nWritten += nRead;
				if ( nWritten >= maxBytesToWrite ) {
					break;
				}
			}
		}
		finally {
			outputStream.close();
		}
		return tempOutputFile;
	}

	public final static File writeTemporaryFile( byte [] bytes, String prefix ) throws IOException {
		if ( prefix == null ) {
			prefix = GHIDRA_FILE_SYSTEM_PREFIX;
		}
		if ( prefix.length() < 3 ) {//temp file prefix must be at least 3 chars in length
			for ( int i = prefix.length() ; i < 3 ; ++i ) {
				prefix = prefix + '_';
			}
		}
		File tempFile = Files.createTempFile(prefix, GHIDRA_FILE_SYSTEM_SUFFIX).toFile();
		tempFile.deleteOnExit();
		OutputStream tempFileOut = new FileOutputStream( tempFile );
		try {
			tempFileOut.write( bytes );
		}
		finally {
			tempFileOut.close();
		}
		return tempFile;
	}
}
