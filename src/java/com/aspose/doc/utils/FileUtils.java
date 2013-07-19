package com.aspose.doc.utils;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;

import com.aspose.doc.support.SimpleLogger;

public class FileUtils {
	private static final SimpleLogger log = new SimpleLogger(FileUtils.class);

	static final int BUFFER = 2048;

	public static Map<String, byte[]> unZip(InputStream inputStream) {
		Map<String, byte[]> entries = new HashMap<String, byte[]>();

		try {
			ZipArchiveInputStream zipInput = new ZipArchiveInputStream(inputStream);
			BufferedOutputStream dest;
			ZipArchiveEntry entry;

			while ((entry = zipInput.getNextZipEntry()) != null) {
				log.debug("Extracting: %s", entry);
				int count;
				byte data[] = new byte[BUFFER];
				ByteArrayOutputStream bos = new ByteArrayOutputStream();
				dest = new BufferedOutputStream(bos, BUFFER);

				while ((count = zipInput.read(data, 0, BUFFER)) != -1) {
					dest.write(data, 0, count);
				}

				dest.flush();
				dest.close();

				entries.put(entry.toString(), bos.toByteArray());
			}

			zipInput.close();
		} catch (Exception e) {
			log.error(e, "Got a error in unZip method");
		}

		return entries;
	}

	public static void zip(OutputStream outputStream, Map<String, byte[]> entries) {
		try {
			ZipArchiveOutputStream zipOutput = new ZipArchiveOutputStream(outputStream);

			for (Entry<String, byte[]> entry : entries.entrySet()) {
				byte[] content = entry.getValue();

				ZipArchiveEntry zipEntry = new ZipArchiveEntry(entry.getKey());
				zipEntry.setSize(content.length);
				zipOutput.putArchiveEntry(zipEntry);
				zipOutput.write(content);
				zipOutput.closeArchiveEntry();
			}
			
			zipOutput.close();
		} catch (Exception e) {
			log.error(e, "Got a error in zip method");
		}
	}
}
