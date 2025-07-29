package sitemap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.RecursiveTask;

public class PageInspect extends RecursiveTask<Set<Link>> {

    private static Set<Link> links = new TreeSet<>();
    private String link;
    private String domain;
    private int tabCount;
    private static Set<String> visitedLinks = new CopyOnWriteArraySet<>();

    @Override
    protected Set<Link> compute() throws NullPointerException {

        Elements elements = null;
        List<PageInspect> pageInspectList = new LinkedList<>();

        try {
            elements = Jsoup.connect(link)
                    .userAgent("Baidu Web Search")
                    .followRedirects(false)
                    .timeout(20000)
                    .get().select("a"); //получаем все ссылки на странице
            Thread.sleep(Math.round((150 * Math.random())*10));

        } catch (Exception e) { }

        for (Element element : elements) {    //проверяем каждый элемент, содержащий ссылку
            String currentLink = element.absUrl("href");
            if(!currentLink.startsWith(domain) //если не начинается с домена
                    || currentLink.equals(domain)
                    || currentLink.matches(domain + ".+\\.[A-Za-z#]+$") //если это ссылка на файл
                    || visitedLinks.contains(currentLink) //если уже в списке посещённых
                    || currentLink.contains("#")
                    || currentLink.contains("?")) //если это внутренняя ссылка или ссылка с параметрами
            {
               continue; //идём к следующей ссылке
            } else {
                tabCount = currentLink.replaceAll(domain, "").split("/").length;
                links.add(new Link(currentLink.replaceAll("/$", "") + "\n", tabCount));
            }
            visitedLinks.add(currentLink);

            PageInspect task = new PageInspect(currentLink, domain); //создаём новый объект для исследования всей страницы по новому адресу
            try {
                task.fork(); //запускаем асинхронно задачу
                pageInspectList.add(task); //добавляем задачу в список задач
            } catch (NullPointerException ex) {
                System.out.println("Исключение " + ex.getLocalizedMessage() + " по ссылке " + task.link);
            }
        }

        for (PageInspect page : pageInspectList) { //перебираем список с задачами и результат выполнения каждой задачи добавляем в Set ссылок
            try {
                links.addAll(page.join());
            } catch (Exception ex) {
                System.out.println(ex.getLocalizedMessage());
            }
        }
        return links;
    }

    public PageInspect(String link, String domain) {
        this.domain = domain;
        this.link = link;
    }
}