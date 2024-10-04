package com.synergisticIT.Controllers.RESTControllers;

import com.synergisticIT.Domain.Publisher;
import com.synergisticIT.Service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/publisher")
public class PublisherRESTController {
    @Autowired
    PublisherService publisherService;

    @PostMapping
    public ResponseEntity<Publisher> createPublisher(@RequestBody Publisher publisher){
        Publisher savedPublisher = publisherService.addPublisher(publisher);

        return new ResponseEntity<>(savedPublisher, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Publisher> getPublisherById(@PathVariable Integer id){
        Publisher publisher = publisherService.getPublisherById(id);
        if(publisher != null){
            return new ResponseEntity<>(publisher, HttpStatus.FOUND);
        }
        else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Publisher>> getAllPublishers(){
        List<Publisher> publisherList =  publisherService.getAllPublishers();
        return new ResponseEntity<>(publisherList, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAirlines(@PathVariable Integer id){
        Publisher publisher = publisherService.getPublisherById(id);
        if(publisher != null){
            publisherService.deletePublisher(id);
            return new ResponseEntity<>("Publisher deleted", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Publisher of id " + id+ " was not found", HttpStatus.NOT_FOUND);
        }
    }
}
