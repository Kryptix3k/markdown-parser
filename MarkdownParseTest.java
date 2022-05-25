import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

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


    @Test
    public void testFirstSnippet() throws IOException {
        MarkdownParse markDown = new MarkdownParse();
        Path directory = Path.of("snippet1.md");
        String content = Files.readString(directory);
       ArrayList expectedLinks = markDown.getLinks(content);
       assertEquals(List.of("google.com"), expectedLinks);
    }

    @Test
    public void testSecondSnippet() throws IOException {
        MarkdownParse markDown = new MarkdownParse();
        Path directory = Path.of("snippet2.md");
        String content = Files.readString(directory);
       ArrayList expectedLinks = markDown.getLinks(content);
       assertEquals(List.of("b.com", "a.com(())", "example.com"), expectedLinks);
    }

    @Test
    public void testThirdSnippet() throws IOException {
        MarkdownParse markDown = new MarkdownParse();
        Path directory = Path.of("snippet3.md");
        String content = Files.readString(directory);
       ArrayList expectedLinks = markDown.getLinks(content);
       assertEquals(List.of("https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule"), expectedLinks);
    }

}