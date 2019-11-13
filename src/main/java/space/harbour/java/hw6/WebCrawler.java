import java.net.URL;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArraySet;
import java.net.MalformedURLException;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public final class WebCrawler {

    private static final int NUMBER_OF_THREADS = 10;
    private final String regex =
    "(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";

    private ExecutorService pool =
        Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    private static Queue<URL> toVisit = new ConcurrentLinkedQueue<URL>();
    private static Set<URL> alreadyVisited = new CopyOnWriteArraySet<URL>();


    class Task implements Callable<Boolean> {
        @Override
        public Boolean call() {

            String content;
            Set<URL> urls;
            URL url;

            url = toVisit.poll();
            content = getContentOfWebPage(url);
            urls = getUrlsFromContent(content);


            alreadyVisited.add(url);
            for (var link: alreadyVisited) {
                System.out.println(link);
            }


            for (URL link: urls) {
                if (!alreadyVisited.contains(link)) {
                    toVisit.offer(link);
                }
            }

            return true;
        }
    }


    public static String getContentOfWebPage(final URL url) {
        final StringBuilder content = new StringBuilder();

        try (InputStream is = url.openConnection().getInputStream();
            InputStreamReader in = new InputStreamReader(is, "UTF-8");
            BufferedReader br = new BufferedReader(in); ) {
            String inputLine;
            while ((inputLine = br.readLine()) != null) {
                content.append(inputLine);
            }
        } catch (IOException e) {
            System.out.println("Failed to retrieve content of "
                + url.toString());
            e.printStackTrace();
        }

        return content.toString();
    }

    public static Set<URL> getUrlsFromContent(final String content) {
        Set<URL> result = new CopyOnWriteArraySet<URL>();
        final Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(content);
        while (m.find()) {
            try {
                result.add(new URL(m.group()));
            } catch (MalformedURLException e) { }
        }

        return result;
    }

    public void crawl() {
        while (!toVisit.isEmpty()) {
            Future<Boolean> future = pool.submit(new Task());
        }
    }

    public static void main(final String[] args) {

        try {
            toVisit.add(new URL("http://www.zmiaikou.com"));
            toVisit.add(new URL("http://kamranelahian.com"));
        } catch (MalformedURLException e) { }

        WebCrawler crawler = new WebCrawler();
        crawler.crawl();


    }
}
