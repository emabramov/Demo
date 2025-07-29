package com.springbootapplication.services;
import com.springbootapplication.dto.NewsDTO;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class NewsCRUDService implements CRUDService<NewsDTO> {

    private final ConcurrentHashMap<Long, NewsDTO> storageNews = new ConcurrentHashMap<>();

    @Override
    public NewsDTO getById(Long id) {
        if(storageNews.containsKey(id)){
            return storageNews.get(id);
        }
        return null;
    }

    @Override
    public Collection<NewsDTO> getAll() {
        return storageNews.values();
    }

    @Override
    public void create(NewsDTO news) {
        Long id = (long)(storageNews.isEmpty() ? 0 : storageNews.size()) + 1;
        news.setId(id);
        news.setDate(Instant.now());
        storageNews.put(id, news);
    }

    @Override
    public void update(Long id, NewsDTO news) {
        if(!storageNews.containsKey(id)){
            return;
        }
        news.setId((long)id);
        news.setDate(Instant.now());
        storageNews.put(id, news);
    }

    @Override
    public void delete(Long id) {
        if(!storageNews.containsKey(id)){
           return;
        }
        storageNews.remove(id);
    }
}
