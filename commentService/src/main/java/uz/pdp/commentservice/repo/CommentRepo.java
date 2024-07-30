package uz.pdp.commentservice.repo;


import org.springframework.data.mongodb.repository.MongoRepository;
import uz.pdp.commentservice.entity.Comment;

import java.util.List;

public interface CommentRepo extends MongoRepository<Comment, Integer> {

    List<Comment> findByPostId(String id);
    
    void deleteById(String id);


    Comment findById(String id);
}
