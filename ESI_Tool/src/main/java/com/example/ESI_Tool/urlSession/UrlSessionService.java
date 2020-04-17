package com.example.ESI_Tool.urlSession;

import com.example.ESI_Tool.FileStore.FileStore;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UrlSessionService {
    private static List<UrlSession> urlSession = new ArrayList<>();
    private final FileStore fileStore;

    public UrlSessionService(FileStore fileStore) {
        this.fileStore = fileStore;
    }

    static {
        urlSession.add(new UrlSession("in28minutes"));
        urlSession.add(new UrlSession("in30minutes"));
        urlSession.add(new UrlSession("in32minutes"));
        urlSession.add(new UrlSession("in34minutes"));
    }

    public List<UrlSession> findAll() {
        return urlSession;
    }

    void uploadUrlInDatabase(UrlSession url)
    {
        fileStore.save(url);
    }
}
