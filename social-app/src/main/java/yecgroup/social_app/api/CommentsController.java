package yecgroup.social_app.api;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import yecgroup.social_app.business.abstracts.CommentService;
import yecgroup.social_app.business.requests.commentRequests.AddCommentRequest;
import yecgroup.social_app.business.responses.commentResponses.GetCommentResponse;

@RestController
@AllArgsConstructor
@RequestMapping("/api/comments")
public class CommentsController {

    private CommentService commentService;

    @GetMapping("/{id}")
    public GetCommentResponse getById(@PathVariable int id){

        return commentService.getById(id);
    }

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody @Valid AddCommentRequest addCommentRequest){

        commentService.add(addCommentRequest);
    }
}
