package com.example.superkasssa.controller;

import com.example.superkasssa.dto.Count;
import com.example.superkasssa.dto.TableSkDto;
import com.example.superkasssa.service.TableSkService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    private final TableSkService tableSkService;

    public Controller(TableSkService tableSkService) {
        this.tableSkService = tableSkService;
    }

    @ResponseStatus(value = HttpStatus.I_AM_A_TEAPOT)
    @PostMapping("/add")
    public TableSkDto addCounter(@RequestBody Count count)  {
        return tableSkService.addCounter(count);
    }
}
