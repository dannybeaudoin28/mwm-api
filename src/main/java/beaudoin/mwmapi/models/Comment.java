package beaudoin.mwmapi.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "COMMENT_TABLE")
public class Comment {
    public Comment() {
        this.commentDate = new Date();
    }

    @Id
    @GeneratedValue
    @Column(name = "COMMENT_ID")
    private Integer id;

    @Column(name = "COMMENT_BODY")
    private String body;

    @Column(name = "COMMENT_AUTHOR_ID")
    private Integer authorId;

    @Column(name = "COMMENT_DATE")
    private Date commentDate;

    @Column(name = "COMMENT_IS_REMOVED")
    private boolean commentIsRemoved;

    @Column(name = "COMMENT_REMOVED_DT")
    private Date commentRemovedDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public boolean isCommentIsRemoved() {
        return commentIsRemoved;
    }

    public void setCommentIsRemoved(boolean commentIsRemoved) {
        this.commentIsRemoved = commentIsRemoved;
    }

    public Date getCommentRemovedDate() {
        return commentRemovedDate;
    }

    public void setCommentRemovedDate(Date commentRemovedDate) {
        this.commentRemovedDate = commentRemovedDate;
    }    
}
