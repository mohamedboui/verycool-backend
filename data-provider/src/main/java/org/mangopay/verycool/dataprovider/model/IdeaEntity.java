package org.mangopay.verycool.dataprovider.model;

import jakarta.persistence.*;

import java.util.*;
import java.util.List;

@Entity
@Table(name = "idea")
public class IdeaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "idea_tags",
            joinColumns = {@JoinColumn(name = "idea_id")},
            inverseJoinColumns = {@JoinColumn(name = "tag_id")})
    private final List<TagEntity> tags = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<TagEntity> getTags() {
        return tags;
    }
}
