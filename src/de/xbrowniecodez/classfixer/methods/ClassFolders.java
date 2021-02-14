package de.xbrowniecodez.classfixer.methods;

import java.nio.file.attribute.FileTime;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

import de.xbrowniecodez.classfixer.utils.Utils;

public class ClassFolders {
	public void process(ZipFile zip, ZipEntry zipEntry, ZipOutputStream out) throws Throwable {
		zipEntry.setCompressedSize(-1);
		if (zipEntry.isDirectory() && zipEntry.getName().endsWith(".class/")) {
			ZipEntry newEntry = new ZipEntry(zipEntry.getName().replace(".class/", ".class"));
			resetDateEntry(newEntry);
			out.putNextEntry(newEntry);
			Utils.writeToFile(out, zip.getInputStream(zipEntry));
		} else {
			resetDateEntry(zipEntry);
			out.putNextEntry(zipEntry);
			Utils.writeToFile(out, zip.getInputStream(zipEntry));
		}
	}
	
    public void resetDateEntry(ZipEntry e) {
    	e.setExtra(null);
		e.setTime(0);
		e.setCreationTime(FileTime.fromMillis(0));
		e.setLastAccessTime(FileTime.fromMillis(0));
		e.setLastModifiedTime(FileTime.fromMillis(0));
    }
}
