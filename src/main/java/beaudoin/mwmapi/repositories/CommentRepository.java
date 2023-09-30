package beaudoin.mwmapi.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import beaudoin.mwmapi.models.Comment;

@Repository
public interface CommentRepository extends CrudRepository <Comment, Integer> {
    
}
