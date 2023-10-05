package beaudoin.mwmapi.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "POSTING_TABLE")
public class Posting {

    public Posting() {}

    public Posting(Integer id, String postTitle, String postBody, Date postDate, boolean isRemoved,
            Date postRemovedDate) {
        this.id = id;
        this.postTitle = postTitle;
        this.postBody = postBody;
        this.postDate = postDate;
        this.isRemoved = isRemoved;
        this.postRemovedDate = postRemovedDate;
        this.comments = new ArrayList<>();
    }

    public Posting(String postingTitle, String postingBody) {
        this.postTitle = postingTitle;
        this.postBody = postingBody;

        this.postDate = new Date();
        this.isRemoved = false;
        this.postRemovedDate = null;
        this.comments = new ArrayList<>();
    }

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

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "POSTING_ID")
    private List<Comment> comments;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostBody() {
        return postBody;
    }

    public void setPostBody(String postBody) {
        this.postBody = postBody;
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

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    
}
