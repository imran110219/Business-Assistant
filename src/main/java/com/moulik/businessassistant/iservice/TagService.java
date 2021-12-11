package com.moulik.businessassistant.iservice;

import com.moulik.businessassistant.exception.RecordNotFoundException;
import com.moulik.businessassistant.model.Tag;

import java.util.List;

public interface TagService {
    List<Tag> getAllTags();

    Tag getTagById(Long id) throws RecordNotFoundException;

    Tag createTag(Tag type);

    Tag updateTag(Tag newTag, Long id);

    void deleteTagById(Long id);
}
