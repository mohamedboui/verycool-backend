package org.mangopay.verycool.dataprovider.repository;

import org.mangopay.verycool.dataprovider.model.IdeaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IdeaRepository extends JpaRepository<IdeaEntity, Long> {
    @Query("SELECT i FROM IdeaEntity i LEFT JOIN FETCH i.tags")
    List<IdeaEntity> getAllIdeasWithTags();
}
