package com.synergisticIT.Service;

import com.synergisticIT.Domain.Author;
import com.synergisticIT.Domain.Publisher;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PublisherService {
    Publisher addPublisher(Publisher publisher);
    Publisher getPublisherById(Integer publisherId);
    List<Publisher> getAllPublishers();
    void deletePublisher(Integer publisherId);

    Page<Publisher> findAllPaginiated(int page, int size);

}
