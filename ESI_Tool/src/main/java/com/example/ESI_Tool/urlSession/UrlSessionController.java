package com.example.ESI_Tool.urlSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class UrlSessionController {

        @Autowired
        private UrlSessionService urlSessionService;

    @GetMapping("/instructors/{username}/urlSession")
    public List<UrlSession> getAllCourses(@PathVariable String username) {
        return urlSessionService.findAll();
    }

    @PostMapping("/instructors/{username}/urlSession")
    public void createCourse(@PathVariable String username, @RequestBody String urlSession) {

            if(urlSession.length() != 0){

               UrlSession urlSession1 = new UrlSession(urlSession);
//               urlSession1.setUrl(urlSession);
               urlSessionService.uploadUrlInDatabase(urlSession1);
            }


    }


}
