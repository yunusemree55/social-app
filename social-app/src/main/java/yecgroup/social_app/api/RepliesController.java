package yecgroup.social_app.api;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import yecgroup.social_app.business.abstracts.ReplyService;
import yecgroup.social_app.business.requests.replyRequests.AddReplyRequest;
import yecgroup.social_app.business.responses.replyResponses.GetReplyResponse;

@RestController
@AllArgsConstructor
@RequestMapping("/api/replies")
public class RepliesController {

    private ReplyService replyService;

    @GetMapping("/{id}")
    public GetReplyResponse getById(@PathVariable int id){

        return replyService.getById(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody @Valid AddReplyRequest addReplyRequest){

        replyService.add(addReplyRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){

        replyService.delete(id);
    }

}
