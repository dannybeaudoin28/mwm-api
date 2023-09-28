package beaudoin.mwmapi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import beaudoin.mwmapi.dao.PostingDAO;
import beaudoin.mwmapi.models.Posting;
import beaudoin.mwmapi.services.PostingService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class PostingController {
    private PostingService postingService;

    public PostingController(PostingService postingService) {
        this.postingService = postingService;
    }

    @PostMapping("/post-posting")
    public ResponseEntity<Integer> addPosting(@RequestBody PostingDAO posting) {
        System.out.println(posting.toString());
        Posting newPosting = new Posting(posting.getPostTitle(), posting.getPostBody());

        postingService.addPosting(newPosting);

        return new ResponseEntity<>(newPosting.getId(), HttpStatus.CREATED);
    }

    @GetMapping("/all-postings")
    public ResponseEntity<List<Posting>> getAllPostings() {
        List postings = postingService.findAllPostings();
        if(postings.size() > 0)
            return new ResponseEntity<List<Posting>>(postings, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}