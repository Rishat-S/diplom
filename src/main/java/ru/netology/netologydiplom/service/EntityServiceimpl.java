package ru.netology.netologydiplom.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.netology.netologydiplom.entity.Customer;
import ru.netology.netologydiplom.entity.CustomersFile;
import ru.netology.netologydiplom.repository.CustomerFileRepository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class EntityServiceimpl implements EntityService {

    CustomerFileRepository customerFileRepository;

    public EntityServiceimpl(CustomerFileRepository customerFileRepository) {
        this.customerFileRepository = customerFileRepository;
    }

    @Override
    public Optional<CustomersFile> getFile(String filename) {
        return customerFileRepository.findCustomersFileByFileName(filename);
    }


    public List<CustomersFile> getListFiles(Customer customer) {
        return customerFileRepository.findAllByCustomer(customer);
    }
}
