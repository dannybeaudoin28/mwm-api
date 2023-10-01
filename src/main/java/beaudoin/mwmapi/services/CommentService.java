package beaudoin.mwmapi.services;

import org.springframework.stereotype.Service;

import beaudoin.mwmapi.models.Comment;
import beaudoin.mwmapi.repositories.CommentRepository;

@Service
public class CommentService {
    CommentRepository commentRepository;

    public CommentService (CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public void save(Comment newComment) {
        commentRepository.save(newComment);
    }
    
}
