package yecgroup.social_app.api;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import yecgroup.social_app.business.abstracts.CommentLikeService;
import yecgroup.social_app.business.requests.commentLikeRequests.AddCommentLikeRequest;

@RestController
@AllArgsConstructor
@RequestMapping("/api/comment-likes")
public class CommentLikesController {

    private CommentLikeService commentLikeService;

    @PostMapping("/add")
    public void add(@RequestBody AddCommentLikeRequest addCommentLikeRequest){

        commentLikeService.add(addCommentLikeRequest);

    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){

        commentLikeService.delete(id);
    }
}
