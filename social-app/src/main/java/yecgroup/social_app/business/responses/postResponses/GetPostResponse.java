package yecgroup.social_app.business.responses.postResponses;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import yecgroup.social_app.business.responses.commentResponses.GetCommentResponse;
import yecgroup.social_app.business.responses.likeResponses.GetAllLikeResponse;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetPostResponse {
	
	
	private int id;
	private String username;
	private String title;
	private String content;
	private String src;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime createdAt;
	
	private List<GetAllLikeResponse> likes;
	private List<GetCommentResponse> comments;

}
