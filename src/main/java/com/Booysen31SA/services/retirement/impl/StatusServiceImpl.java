package com.Booysen31SA.services.retirement.impl;

import com.Booysen31SA.domain.retirement.Status;
import com.Booysen31SA.repository.retirement.IStatusRepository;
import com.Booysen31SA.services.retirement.IStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service("StatusRetirementServiceImpl")
public class StatusServiceImpl implements IStatusService {

    private static StatusServiceImpl service = null;
    @Autowired
    private IStatusRepository repository;

    public StatusServiceImpl(){

    }
    public static StatusServiceImpl getService(){
        if(service == null){
            return new StatusServiceImpl();
        }
        return service;
    }

    @Override
    public Set<Status> getAll() {
        List<Status> list = (List<Status>) repository.findAll();

        return new HashSet<>(list);
    }

    @Override
    public Status create(Status appointment) {
        return repository.save(appointment);
    }

    @Override
    public Status read(String integer) {
        return this.repository.findById(integer).orElse(null);
    }

    @Override
    public Status update(Status appointment) {
        return this.repository.save(appointment);
    }

    @Override
    public void delete(String integer) {
        this.repository.deleteById(integer);
    }
}
