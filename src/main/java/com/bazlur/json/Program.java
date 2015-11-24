package com.bazlur.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Bazlur Rahman Rokon
 * @since 11/24/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Program {
    private Long id;
    private String name;
    private User createdBy;
    private String contents;

    public Program(Long id, String name, String contents, User createdBy) {
        this.id = id;
        this.name = name;
        this.contents = contents;
        this.createdBy = createdBy;
    }

    public Program() {
    }

    public Long getId() {
        return id;
    }

    public Program setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Program setName(String name) {
        this.name = name;
        return this;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public Program setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public String getContents() {
        return contents;
    }

    public Program setContents(String contents) {
        this.contents = contents;
        return this;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Program{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", createdBy=").append(createdBy);
        sb.append(", contents='").append(contents).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
