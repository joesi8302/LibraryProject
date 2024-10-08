package com.synergisticIT.Service.Implementation;

import com.synergisticIT.Domain.Author;
import com.synergisticIT.Domain.Publisher;
import com.synergisticIT.Repositories.PublisherRepository;
import com.synergisticIT.Service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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

    @Override
    public Page<Publisher> findAllPaginiated(int page, int size) {
        return publisherRepository.findAll(PageRequest.of(page, size));
    }

    public Page<Publisher> findPaginated(int page, int size) {
        return publisherRepository.findAll(PageRequest.of(page, size));
    }
}
