package com.example.superkasssa.service;

import com.example.superkasssa.dto.TableSkDto;
import com.example.superkasssa.dto.Count;
import com.example.superkasssa.entity.JsonEntity;
import com.example.superkasssa.entity.TableSk;
import com.example.superkasssa.repository.TableSkRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class TableSkService {

    private final TableSkRepository tableSkRepository;

    public TableSkService(TableSkRepository tableSkRepository) {
        this.tableSkRepository = tableSkRepository;
    }

    public synchronized TableSkDto addCounter(Count count) {
        TableSk tableSk = getTableSk(count.getId());
        JsonEntity current = tableSk.getJsonEntity();
        int newCurrent = current.getCurrent() + count.getAdd();
        save(tableSk, newCurrent, current);
        //AtomicInteger atomicInteger = new AtomicInteger();
        return new TableSkDto(newCurrent);
    }

    private TableSk getTableSk(Long id) {
        Optional<TableSk> tableSk = tableSkRepository.findById(id);
        return tableSk.get();
    }

    private void save(TableSk tableSk, int current, JsonEntity newCurrent) {
        newCurrent.setCurrent(current);
        tableSk.setJsonEntity(newCurrent);
        tableSkRepository.save(tableSk);
    }
}
