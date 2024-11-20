package com.itwill.jdbc.model;

import java.time.LocalDateTime;

// MVC 아키텍쳐에서 Model을 담당하는 객체.
public class Blog {

    private Integer id; // blogs 테이블의 PK
    private String title;
    private String content;
    private String author;
    private LocalDateTime createdTime;
    private LocalDateTime modifiedTime;

    public Blog() {}
    
    public Blog(Integer id, String title, String content, String author, LocalDateTime createdTime,
            LocalDateTime modifiedTime) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.createdTime = createdTime;
        this.modifiedTime = modifiedTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public LocalDateTime getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(LocalDateTime modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Blog [id=" + id + ", title=" + title + ", content=" + content + ", author=" + author + ", createdTime="
                + createdTime + ", modifiedTime=" + modifiedTime + "]";
    }
    
    // Builder 디자인 패턴
    public static BlogBuilder builder() {
        return new BlogBuilder();
    }
    
    public static class BlogBuilder {
        private Integer id;
        private String title;
        private String content;
        private String author;
        private LocalDateTime createdTime;
        private LocalDateTime modifiedTime;
        
        private BlogBuilder() {}

        public BlogBuilder id(Integer id) {
            this.id = id;
            return this;
        }

        public BlogBuilder title(String title) {
            this.title = title;
            return this;
        }

        public BlogBuilder content(String content) {
            this.content = content;
            return this;
        }

        public BlogBuilder author(String author) {
            this.author = author;
            return this;
        }

        public BlogBuilder createdTime(LocalDateTime createdTime) {
            this.createdTime = createdTime;
            return this;
        }

        public BlogBuilder modifiedTime(LocalDateTime modifiedTime) {
            this.modifiedTime = modifiedTime;
            return this;
        }
        
        public Blog build() {
            return new Blog(id, title, content, author, createdTime, modifiedTime);
        }
    }
    
}
