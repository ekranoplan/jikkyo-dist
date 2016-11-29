package Main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ekranoplan on 2016/11/29.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        List<String> listA = loadTweet("./data/a.txt");
        List<String> listB = loadTweet("./data/b.txt");
        CompareTweetSequence cts = new CompareTweetSequence(listA,listB);
        System.out.println("D:"+cts.getDtwDistance());
    }

    private static List<String> loadTweet(String fileName) throws IOException {
        List<String> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(new File(fileName)));
        String str;
        while ((str = br.readLine()) != null) {
            list.add(str);
        }
        br.close();
        return list;
    }


}
