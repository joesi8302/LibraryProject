package com.synergisticIT.Service;

import com.synergisticIT.Domain.Publisher;

import java.util.List;

public interface PublisherService {
    Publisher addPublisher(Publisher publisher);
    Publisher getPublisherById(Integer publisherId);
    List<Publisher> getAllPublishers();
    void deletePublisher(Integer publisherId);

}
