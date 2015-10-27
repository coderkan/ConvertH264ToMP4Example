import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.googlecode.mp4parser.DirectFileReadDataSource;
import com.googlecode.mp4parser.authoring.Movie;
import com.googlecode.mp4parser.authoring.builder.DefaultMp4Builder;
import com.googlecode.mp4parser.authoring.tracks.h264.H264TrackImpl;


public class H264TrackExample {

	public static void main(String[] args) throws IOException {
		String path = "in.h264";
		String mp4path = "out.mp4";
		
		H264TrackImpl h264track = new H264TrackImpl(new DirectFileReadDataSource(new File(path)));
		Movie movie = new Movie();
		movie.addTrack(h264track);
		com.coremedia.iso.boxes.Container mp4file =  new DefaultMp4Builder().build(movie);
		FileOutputStream fos = new FileOutputStream(mp4path);
		mp4file.writeContainer(fos.getChannel());
		fos.close();
	}

}
