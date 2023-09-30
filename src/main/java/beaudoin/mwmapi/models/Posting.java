package beaudoin.mwmapi.models;

import java.util.Date;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "POSTING_TABLE")
public class Posting {
    

    public Posting() {
    }

    public Posting(Integer id, String postTitle, String postBody, Date postDate, boolean isRemoved,
            Date postRemovedDate) {
        this.id = id;
        this.postTitle = postTitle;
        this.postBody = postBody;
        this.postDate = postDate;
        this.isRemoved = isRemoved;
        this.postRemovedDate = postRemovedDate;
    }

    public Posting(String postingTitle, String postingBody) {
        this.postTitle = postingTitle;
        this.postBody = postingBody;

        this.postDate = new Date();
        this.isRemoved = false;
        this.postRemovedDate = null;
    }   

    @ManyToOne
    @JoinColumn(name = "COMMENT_ID")
    private Comment comment;

    @Id
    @GeneratedValue
    @Column(name = "POSTING_ID")
    private Integer id;

    @Column(name = "POSTING_TITLE")
    private String postTitle;

    @Column(name = "POSTING_BODY")
    private String postBody;

    @Column(name = "POSTING_POST_DT")
    private Date postDate;

    @Column(name = "POSTING_IS_REMOVED")
    private boolean isRemoved;

    @Column(name = "POSTING_REMOVED_DT")
    private Date postRemovedDate;

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String title) {
        this.postTitle = title;
    }

    public String getPostBody() {
        return postBody;
    }

    public void setPostBody(String body) {
        this.postBody = body;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public boolean isRemoved() {
        return isRemoved;
    }

    public void setRemoved(boolean isRemoved) {
        this.isRemoved = isRemoved;
    }

    public Date getPostRemovedDate() {
        return postRemovedDate;
    }

    public void setPostRemovedDate(Date postRemovedDate) {
        this.postRemovedDate = postRemovedDate;
    }

    public Integer getId() {
        return id;
    } 
}
