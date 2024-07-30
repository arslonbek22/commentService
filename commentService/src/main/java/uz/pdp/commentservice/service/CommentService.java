package uz.pdp.commentservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.commentservice.entity.Comment;
import uz.pdp.commentservice.repo.CommentRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {


    private final CommentRepo commentRepo;

    public List<Comment> getComment(String id) {
        return commentRepo.findByPostId(id);
    }

    public Comment save(Comment comment) {
        return commentRepo.save(comment);
    }

    public void deleteComment(String id) {
        commentRepo.deleteById(id);
    }

    public Comment update(String id, Comment comment) {
        Comment comment1 = commentRepo.findById(id);
        comment1.setText(comment.getText());
        return commentRepo.save(comment);
    }
}
