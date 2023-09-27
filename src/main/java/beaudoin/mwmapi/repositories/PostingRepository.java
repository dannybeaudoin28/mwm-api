package beaudoin.mwmapi.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import beaudoin.mwmapi.models.Posting;

@Repository
public interface PostingRepository extends CrudRepository<Posting, Integer>{
    
}
