package anaydis.compression;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;

public class HuffmanTester {

    Huffman huffman = new Huffman();


    @Test
    public void testEncode() throws IOException {


        String str = "AAAAAAAAAAABBBBBBBC";
        InputStream inputStream = new ByteArrayInputStream(str.getBytes());
        OutputStream outputStream = new ByteArrayOutputStream();



        huffman.encode(inputStream, outputStream);

        String result = outputStream.toString();
        Assert.assertEquals("111111111110101010101010100", result);


    }

    @Test
    public void testDecode() throws IOException {
//        String str = "Call me Ishmael.  Some years ago--never mind how long\n" +
//                "precisely--having little or no money in my purse, and nothing\n" +
//                "particular to interest me on shore, I thought I would sail about a\n" +
//                "little and see the watery part of the world.  It is a way I have of\n" +
//                "driving off the spleen and regulating the circulation.  Whenever I\n" +
//                "find myself growing grim about the mouth; whenever it is a damp,\n" +
//                "drizzly November in my soul; whenever I find myself involuntarily\n" +
//                "pausing before coffin warehouses, and bringing up the rear of every\n" +
//                "funeral I meet; and especially whenever my hypos get such an upper\n" +
//                "hand of me, that it requires a strong moral principle to prevent me\n" +
//                "from deliberately stepping into the street, and methodically knocking\n" +
//                "people's hats off--then, I account it high time to get to sea as soon\n" +
//                "as I can.  This is my substitute for pistol and ball.  With a\n" +
//                "philosophical flourish Cato throws himself upon his sword; I quietly\n" +
//                "take to the ship.  There is nothing surprising in this.  If they but\n" +
//                "knew it, almost all men in their degree, some time or other, cherish\n" +
//                "very nearly the same feelings towards the ocean with me.";
        String str = "AAAAAAAAAAABBBBBBBC";
        InputStream inputStream = new ByteArrayInputStream(str.getBytes());
        OutputStream outputStream = new ByteArrayOutputStream();



        huffman.encode(inputStream, outputStream);


        String result = outputStream.toString();

        InputStream newInputStream = new ByteArrayInputStream(outputStream.toString().getBytes());
        OutputStream newoutputStream = new ByteArrayOutputStream();



        huffman.decode(newInputStream, newoutputStream);


        result = newoutputStream.toString();

        System.out.println(result);

        Assert.assertEquals(str, result);



    }
}

