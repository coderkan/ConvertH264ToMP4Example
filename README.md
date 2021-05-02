# ConvertH264ToMP4Example
This is a very simple project converting **H264** to **MP4** files in Java.
This is clearly converting files. I have used isoparser API to convert it.

You can download isoparser all jar files in this [link.](http://repo1.maven.org/maven2/com/googlecode/mp4parser/isoparser/)

I used 1.1.9 revision.

``` Java
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

```
Have a nice coding.
