package com.aspose.doc.utils;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;

import org.simpleframework.xml.core.Persister;

public class PersisterUtils {

	public static <T> T read(Class<T> iface, String source) throws Exception {
		Persister persister = new Persister();
		return persister.read(iface, source);
	}

	public static <T> T read(Class<T> iface, InputStream inputStream) throws Exception {
		Persister persister = new Persister();
		return persister.read(iface, inputStream);
	}

	public static <T> T read(Class<T> iface, File xml) throws Exception {
		Persister persister = new Persister();
		return persister.read(iface, xml);
	}

	public static <T> void write(Object source, OutputStream outputStream) throws Exception {
		Persister persister = new Persister();
		persister.write(source, outputStream);
	}
	
	public static <T> void write(Object source, File xml) throws Exception {
		Persister persister = new Persister();
		persister.write(source, xml);
	}

}
