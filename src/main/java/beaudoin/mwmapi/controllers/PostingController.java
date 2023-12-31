package beaudoin.mwmapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import beaudoin.mwmapi.dao.PostingDAO;
import beaudoin.mwmapi.models.Posting;
import beaudoin.mwmapi.services.CommentService;
import beaudoin.mwmapi.services.PostingService;

@CrossOrigin("*")
@RestController
@RequestMapping("/postings")
public class PostingController {
    //TODO: add put method as well for updating a post.
    private PostingService postingService;

    @Autowired
    private CommentService commentService;

    public PostingController(PostingService postingService) {
        this.postingService = postingService;
    }

    @PostMapping("/post-posting")
    public ResponseEntity<Integer> addPosting(@RequestBody PostingDAO posting) {
        Posting newPosting = new Posting(posting.getPostTitle(), posting.getPostBody());

        postingService.addPosting(newPosting);

        return new ResponseEntity<>(newPosting.getId(), HttpStatus.CREATED);
    }

    @GetMapping("/all-postings")
    public ResponseEntity<List<Posting>> getAllPostings() {
        List<Posting> postings = postingService.findAllPostings();
        if(postings.size() > 0)
            return new ResponseEntity<List<Posting>>(postings, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("postings/{id}")
    public ResponseEntity<Posting> getPostingById(@PathVariable Integer id) {
        System.out.println("id is: " + id);
        Posting posting = postingService.findPostingById(id);
        if(posting.getPostTitle() != null) {
            return new ResponseEntity<>(posting, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("postings/{id}")
    public ResponseEntity<Integer> deletePostingById(@PathVariable Integer id) {
        if(postingService.deletePosting(id)) {
            return new ResponseEntity<Integer>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/postings/{id}") 
    public ResponseEntity<Void> updatePostingById(@PathVariable Integer id, @RequestBody Posting newPosting) {
        if(postingService.updatePosting(newPosting, id) != null) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}