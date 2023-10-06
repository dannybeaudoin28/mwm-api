package beaudoin.mwmapi.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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

    public Posting findPostingById(Integer id) {
        Optional<Posting> opt = postingRepo.findById(id);
        if(opt.isPresent()) {
            return opt.get();
        }
        return new Posting();
    }

    public void save(Posting posting) {
        postingRepo.save(posting);
    }

    public boolean deletePosting(Integer id) {
        if(!postingRepo.findById(id).isEmpty()) {
            postingRepo.deleteById(id);

            return true;
        }
        return false;
    }

    public Posting updatePosting(Posting newPosting, Integer id) {
        Posting oldPosting = postingRepo.findById(id).get();
        if(oldPosting != null) {
            oldPosting.setPostBody(newPosting.getPostBody());
            oldPosting.setPostTitle(newPosting.getPostTitle());
            oldPosting.setPostDate(new Date());

            postingRepo.save(oldPosting);
            return oldPosting;
        }
        return null;
    }
    
}
