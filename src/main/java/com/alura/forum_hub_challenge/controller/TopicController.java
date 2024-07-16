package com.alura.forum_hub_challenge.controller;

import com.alura.forum_hub_challenge.dto.TopicDetailsDto;
import com.alura.forum_hub_challenge.dto.TopicInputDto;
import com.alura.forum_hub_challenge.service.TopicService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topics")
@SecurityRequirement(name = "bearer-key")
public class TopicController {
    @Autowired
    private TopicService topicService;

    @PostMapping
    public ResponseEntity<TopicDetailsDto> post(@RequestBody @Valid TopicInputDto dto, UriComponentsBuilder uriBuilder) {
        var topic = topicService.create(dto);
        var uri = uriBuilder.path("/topics/{id}").buildAndExpand(topic.getId()).toUri();

        return ResponseEntity.created(uri).body(new TopicDetailsDto(topic));
    }

    @GetMapping
    public ResponseEntity<Page<TopicDetailsDto>> list(@PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        var page = topicService.list(pageable).map(TopicDetailsDto::new);

        return ResponseEntity.ok(page);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody @Valid TopicInputDto dto) {
        if (topicService.update(id, dto) != null) {
            var topic = topicService.update(id, dto);

            return ResponseEntity.ok(new TopicDetailsDto(topic));
        }

        return ResponseEntity.status(401).body("Acesso não autorizado.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        if (topicService.delete(id)) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.status(401).body("Acesso não autorizado.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicDetailsDto> getById(@PathVariable Long id) {
        var topic = topicService.detail(id);

        return ResponseEntity.ok(new TopicDetailsDto(topic));
    }
}
