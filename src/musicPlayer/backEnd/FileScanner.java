package musicPlayer.backEnd;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;

public class FileScanner extends SimpleFileVisitor<Path>{
	
	private ArrayList<String> mp3Files = new ArrayList<String>();
	
	@Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attr) {
		
		if (file.toString().endsWith(".mp3") && file.toFile().canRead()) {
            mp3Files.add(file.toString());
        }
		return FileVisitResult.CONTINUE;
	};
	
	@Override
    public FileVisitResult visitFileFailed(Path file,
                                       IOException exc) {
        System.err.println(exc);
        return FileVisitResult.CONTINUE;
    }
	
	public String getFile(int i) {
		return mp3Files.get(i);
	}

}
