package com.androidbridge;

import java.io.FileInputStream;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;

/**
 * @author aruna
 * 
 * calculate file CRC32 checksum.
 */
public class FileCrc32Task extends Task {

	/**
	 * Property to save calulated CRC32 to
	 */
	protected String propName;
	
	/**
	 * Setter for property
	 * @param property
	 */
	public void setProperty(String property) {
		this.propName = property;
	}

	/**
	 * File to calculate CRC32
	 */
	protected String aFile;
	
	/**
	 * Setter for file
	 * @param aFile
	 */
	public void setFile(String aFile) {
		this.aFile = aFile;
	}
	
	public void execute() {
		try {
			
			CheckedInputStream cis = new CheckedInputStream(new FileInputStream(aFile),
					new CRC32());

			byte[] buf = new byte[128];
			while (cis.read(buf) >= 0) { }
			long checksum = cis.getChecksum().getValue();
			getProject().setProperty(this.propName, String.valueOf(checksum));
		} catch (Exception e) {
			throw new BuildException(e.getMessage(), e);
		}
	}
}
