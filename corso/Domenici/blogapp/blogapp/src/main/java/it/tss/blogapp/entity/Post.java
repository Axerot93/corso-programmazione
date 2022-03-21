/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.blogapp.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author tss
 */
@Entity
@Table(name="post")
public class Post extends BaseEntity implements Serializable{
    
   
    @Column(nullable = false)
    private LocalDateTime created = LocalDateTime.now();
    
    @ManyToOne(optional = false)
    private User author;
    
    @Column(nullable = false)
    private String title;
    
    @Column(nullable = false)
    private String body;
    
    @ManyToMany
    @JoinTable(name="post_tag",joinColumns = 
    @JoinColumn(name="post_id"),
    inverseJoinColumns= @JoinColumn(name= "tag_id"))
    private Set<Tag> tags;

  
    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

  

    @Override
    public String toString() {
        return "Post{"  + ", created=" + created + ", author=" + author + ", title=" + title + ", body=" + body + ", tags=" + tags + '}';
    }
    
    
}
