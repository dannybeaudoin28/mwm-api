package beaudoin.mwmapi.dao;

public class PostingDAO {
    private String postTitle;
    private String postBody;
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
    @Override
    public String toString() {
        return "PostingDAO [postTitle=" + postTitle + ", postBody=" + postBody + "]";
    }   
}
