import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.io.IOException;

public class Webpage_downloader {

    public static String downloadHTML(String URL) throws IOException, URISyntaxException {
        URI uri = new URI(URL);
        URL url = uri.toURL();

        InputStream inputStream = url.openStream();
        InputStreamReader isr = new InputStreamReader(inputStream);
        BufferedReader br = new BufferedReader(isr);

        String content = "";

        while (br.readLine() != null) {
            content += br.readLine();
        }
        return content;
    }

    public static void fileMaker(String content, String filename) throws IOException {
        FileWriter file = new FileWriter(filename + ".html");

        file.write(content + "\n");

        System.out.println(filename + " create successfully!");
    }

    public static void fileOpener(String filename) throws IOException {
        Runtime.getRuntime().exec(new String[]{
            "cmd", "/c", "start", filename + ".html"
        });


    }

    public static void main(String[] arg) throws IOException, URISyntaxException {
        String URL = "https://github.com/Muhammad-Sharjeel-Asif";
        String fileName = "index";

        String content  = downloadHTML(URL);

        fileMaker(content, fileName);

        fileOpener(fileName);
    }
}