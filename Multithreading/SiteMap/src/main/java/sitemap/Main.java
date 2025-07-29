package sitemap;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.sql.SQLOutput;
import java.util.*;
import java.util.concurrent.*;

import static java.nio.file.StandardOpenOption.*;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
    String link = "https://sendel.ru/";
    //String link = "https://salaris.ru/";
    //String link = "https://skillbox.ru/";
    //String link = "https://www.mos.ru";

        Set<Link> setLinks = new TreeSet<>();
        long startTime = System.currentTimeMillis();
        int cores = Runtime.getRuntime().availableProcessors();
        ForkJoinPool pool = new ForkJoinPool(cores);


        setLinks.add(new Link(link + "\n", 0));
        setLinks.addAll(pool.invoke(new PageInspect(link, link)));



        String average;
        System.out.print("Понадобилось ");
        long time = System.currentTimeMillis() - startTime;
        if(time/1000 < 60){
            average = time/1000 + " секунд";
            System.out.println(time/1000 + " секунд");
        } else if (time/1000/60 < 3600) {
            average = time/1000 + " минут";
            System.out.println(time/1000/60 + " минут");
        } else {
            average = time/1000 + " часов";
            System.out.println(time/1000/60/60 + " часов");
        }

        pool.shutdown();
        String info = "Всего записей: " + setLinks.size();
        System.out.println(info);
        setLinks.add(new Link(info + "\n", 0));
        setLinks.add(new Link("Понадобилось времени: " + average + "\n", 0));

//        setLinks.forEach(link1 -> {
//            System.out.println("\t".repeat(link1.getTabCount()) + link1.getUrl());
//        });

        fileWriter(Paths.get("data" + File.separator + "sitemap_" + link.replaceAll("http[s]://", "").replaceAll("/", "") + ".txt").toAbsolutePath().toString(), setLinks);

    }

    //запись в файл
    private static void fileWriter(String pathString, Set<Link> setLinks) throws IOException {
        Path path = Paths.get(pathString);

        try {
            if(Files.exists(path)) {
                Files.delete(path);
                System.out.println("Path: " + path.toString() + ". File deleted");
            }
            for(Link link : setLinks){
                String url;
                url = "\t".repeat(link.getTabCount()) + link.getUrl();
                Files.write(path, url.getBytes(), CREATE, APPEND);
            }
        } catch (Exception ex){
            System.out.println(ex.getLocalizedMessage());
        }
    }
}
