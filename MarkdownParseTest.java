import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import org.junit.*;
public class MarkdownParseTest {

    

    @Test
    public void addition() {
        assertEquals(2, 1+1);
    }
    @Test
    public void getLinks() throws IOException {
    Path directory  = Path.of("test-file.md");
    String content = Files.readString(directory);
    ArrayList<String> Links = MarkdownParse.getLinks(content);
    try{
        MarkdownParse.getLinks(Files.readString(directory));
        
    } catch(IOException e) {
    }

    ArrayList<String> listLinks = new ArrayList<String>();
    listLinks.add("https://something.com");
    listLinks.add("some-thing.html");
    assertEquals(Links, listLinks);
    }

    }