/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.blogapp.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author tss
 */
@Entity
@Table(name="comment")
public class Comment extends BaseEntity implements Serializable{
    
  
     
     @ManyToOne(optional = false)
    private User author;
     
     @Column(nullable=false)
     private String msg;
     
      @ManyToOne(optional = false)
        private Post post;

   
    

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

   

    @Override
    public String toString() {
        return "Comment{" + ", author=" + author + ", msg=" + msg + ", post=" + post + '}';
    }
     
     
    
}
