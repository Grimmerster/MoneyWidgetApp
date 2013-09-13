import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import org.apache.http.util.ByteArrayBuffer;

public class AndreyzUpDater {
	File root;
	File dir;
	String name;

	AndreyzUpDater() {
		root = android.os.Environment.getExternalStorageDirectory();
		dir = new File(root.getAbsolutePath() + "SLAMW");
	}

	public boolean downloadMethod() {
		try {
			if (dir.exists() == false) {
				dir.mkdirs();
			}

			name = "tmp24fj13i1mn23.xml";

			URL url = new URL("url"); // you can write here any link
			File file = new File(dir, name);
			
			

			//long startTime = System.currentTimeMillis();
			// Log.d("DownloadManager", "download begining");
			// Log.d("DownloadManager", "download url:" + url);
			// Log.d("DownloadManager", "downloaded file name:" + name);

			/* Open a connection to that URL. */
			URLConnection ucon = url.openConnection();

			/*
			 * Define InputStreams to read from the URLConnection.
			 */
			InputStream is = ucon.getInputStream();
			BufferedInputStream bis = new BufferedInputStream(is);

			/*
			 * Read bytes to the Buffer until there is nothing more to read(-1).
			 */
			ByteArrayBuffer baf = new ByteArrayBuffer(5000);
			int current = 0;
			while ((current = bis.read()) != -1) {
				baf.append((byte) current);
			}

			/* Convert the Bytes read to a String. */
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(baf.toByteArray());
			fos.flush();
			fos.close();
			// Log.d("DownloadManager", "download ready in" +
			// ((System.currentTimeMillis() - startTime) / 1000) + " sec");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}
}
