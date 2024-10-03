package com.synergisticIT.Service.Implementation;

import com.synergisticIT.Domain.Publisher;
import com.synergisticIT.Repositories.PublisherRepository;
import com.synergisticIT.Service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PublisherServiceImpl implements PublisherService {

    @Autowired
    PublisherRepository publisherRepository;

    @Override
    public Publisher addPublisher(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    @Override
    public Publisher getPublisherById(Integer publisherId) {
        return publisherRepository.findById(publisherId).orElse(null);
    }

    @Override
    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }

    @Override
    public void deletePublisher(Integer publisherId) {

        Publisher foundPublisher = getPublisherById(publisherId);
        if(foundPublisher != null){
            publisherRepository.delete(foundPublisher);
        }
    }
}
