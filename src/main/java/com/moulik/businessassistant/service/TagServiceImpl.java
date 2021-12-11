package com.moulik.businessassistant.service;

import com.moulik.businessassistant.exception.RecordNotFoundException;
import com.moulik.businessassistant.iservice.TagService;
import com.moulik.businessassistant.model.Tag;
import com.moulik.businessassistant.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Sadman
 */
@RequiredArgsConstructor
@Service
public class TagServiceImpl implements TagService {
    private final TagRepository tagRepository;

    @Override
    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }

    @Override
    public Tag getTagById(Long id) throws RecordNotFoundException {
        return tagRepository.getById(id);
    }

    @Override
    public Tag createTag(Tag tag) {
        return tagRepository.save(tag);
    }

    @Override
    public Tag updateTag(Tag newTag, Long id) {
        return tagRepository.findById(id)
                .map(tag -> {
                    tag.setName(newTag.getName());
                    tag.setDescription(newTag.getDescription());
                    return tagRepository.save(tag);
                })
                .orElseGet(() -> {
                    newTag.setId(id);
                    return tagRepository.save(newTag);
                });
    }

    @Override
    public void deleteTagById(Long id) {
        tagRepository.deleteById(id);
    }
}
