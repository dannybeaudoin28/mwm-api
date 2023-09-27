package beaudoin.mwmapi.services;

import java.util.List;

import org.springframework.stereotype.Service;

import beaudoin.mwmapi.models.Posting;
import beaudoin.mwmapi.repositories.PostingRepository;

@Service
public class PostingService {
    private PostingRepository postingRepo;

    public PostingService(PostingRepository postingRepo) {
        this.postingRepo  = postingRepo;
    }

    public void addPosting(Posting posting) {
        postingRepo.save(posting);
    }

    public List findAllPostings() {
        List<Posting> postings = (List<Posting>) postingRepo.findAll();
        return postings;
    }
    
}
