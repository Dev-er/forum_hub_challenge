package com.alura.forum_hub_challenge.controller;

import com.alura.forum_hub_challenge.dto.AnswerCreateDto;
import com.alura.forum_hub_challenge.dto.AnswerDetailsDto;
import com.alura.forum_hub_challenge.dto.AnswerUpdateDto;
import com.alura.forum_hub_challenge.service.AnswerService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/answers")
@SecurityRequirement(name = "bearer-key")
public class AnswerController {
    @Autowired
    private AnswerService answerService;

    @PostMapping
    public ResponseEntity<AnswerDetailsDto> create(@RequestBody @Valid AnswerCreateDto dto, UriComponentsBuilder uriBuilder) {
        var answer = answerService.create(dto);
        var uri = uriBuilder.path("/answers/{id}").buildAndExpand(answer.getId()).toUri();

        return ResponseEntity.created(uri).body(new AnswerDetailsDto(answer));
    }

    @GetMapping
    public ResponseEntity<Page<AnswerDetailsDto>> list(Pageable pageable) {
        var page = answerService.list(pageable).map(AnswerDetailsDto::new);

        return ResponseEntity.ok(page);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody @Valid AnswerUpdateDto dto) {
        if (answerService.update(dto) != null) {
            var answer = answerService.update(dto);

            return ResponseEntity.ok(new AnswerDetailsDto(answer));
        }

        return ResponseEntity.status(401).body("Acesso não autorizado.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        if (answerService.delete(id)) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.status(401).body("Acesso não autorizado.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnswerDetailsDto> getById(@PathVariable Long id) {
        var answer = answerService.detail(id);

        return ResponseEntity.ok(new AnswerDetailsDto(answer));
    }
}
