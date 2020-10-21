package com.example.restservice.resource;

import com.example.restservice.domain.CaseFile;
import com.example.restservice.repository.CaseFileRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/case-files")
public class CaseFileController {
    private final CaseFileRepository caseFileRepository;
    private final ObjectMapper objectMapper;


    @GetMapping
    public List<CaseFile> getAll() {
        return caseFileRepository.findAll();
    }

    @GetMapping(value = "/search", params = {"caseFileStr"})
    public List<CaseFile> queryByExampleGet(@RequestParam("caseFileStr") String caseFileStr) throws JsonProcessingException {
        CaseFile caseFile = objectMapper.readerFor(CaseFile.class).readValue(caseFileStr);
        return caseFileRepository.findAll(Example.of(caseFile));
    }
    @GetMapping(value ="/search", params = {"caseFile"})
    public List<CaseFile> queryByExampleGetCaseFile( CaseFile caseFile)  {
        return caseFileRepository.findAll(Example.of(caseFile));
    }

    @PostMapping("/search")
    public List<CaseFile> queryByExamplePost(@RequestBody CaseFile caseFile) {
        return caseFileRepository.findAll(Example.of(caseFile));
    }

    @PostMapping
    public Iterable<CaseFile> post(@RequestBody Iterable<CaseFile> caseFiles) {
        return caseFileRepository.saveAll(caseFiles);
    }

}
