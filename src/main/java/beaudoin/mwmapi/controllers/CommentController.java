package beaudoin.mwmapi.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import beaudoin.mwmapi.models.Comment;
import beaudoin.mwmapi.models.Posting;
import beaudoin.mwmapi.services.CommentService;
import beaudoin.mwmapi.services.PostingService;

@RestController
@CrossOrigin("*")
@RequestMapping("/comments")
public class CommentController {

    private CommentService commentService;
    private PostingService postingService;

    public CommentController(CommentService commentService, PostingService postingService) {
        this.commentService = commentService;
        this.postingService = postingService;
    }

    @PostMapping("/post-comment/{postingId}")
    public ResponseEntity<Integer> addComment(@RequestBody Comment comment, @PathVariable Integer postingId) {
        Posting posting = postingService.findPostingById(postingId);
        posting.getComments().add(comment);
        commentService.save(comment);
        

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}