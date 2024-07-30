package uz.pdp.commentservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.pdp.commentservice.entity.Comment;
import uz.pdp.commentservice.service.CommentService;

import java.util.List;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @GetMapping("{postId}")
    public List<Comment> getComment(@PathVariable String postId) {
        return commentService.getComment(postId);
    }

    @PostMapping("{postId}")
    public Comment addComment(@PathVariable String postId, @RequestBody Comment comment) {
        comment.setPostId(postId);
        return commentService.save(comment);
    }

    @DeleteMapping("{id}")
    public void deleteComment(@PathVariable String id) {
        commentService.deleteComment(id);
    }

    @PutMapping("{id}")
    public Comment updateComment(@PathVariable String id, @RequestBody Comment comment) {
        return commentService.update(id, comment);
    }

}
