package yecgroup.social_app;


import java.util.HashMap;
import java.util.NoSuchElementException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import yecgroup.social_app.core.exceptions.BusinessException;
import yecgroup.social_app.core.exceptions.ProblemDetail;
import yecgroup.social_app.core.exceptions.ValidationProblemDetail;
import yecgroup.social_app.core.utilities.ExceptionMessageConstant;

@SpringBootApplication
@RestControllerAdvice
public class SocialAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocialAppApplication.class, args);	
	}
	
	
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ProblemDetail businessException(BusinessException businessException) {
		
		return new ProblemDetail(businessException.getMessage());
	}
	
	
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ValidationProblemDetail validationProblemDetail(MethodArgumentNotValidException validException) {
		
		ValidationProblemDetail validationDetail = new ValidationProblemDetail();
		
		validationDetail.setMessage(ExceptionMessageConstant.validationErrorMessage);
		
		validationDetail.setProblems(new HashMap<String, String>());
		
		for (FieldError fieldError : validException.getBindingResult().getFieldErrors()) {
			
			validationDetail.getProblems().put(fieldError.getField(),fieldError.getDefaultMessage());
			
		}

		return validationDetail;
		
	}
	
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ProblemDetail noSuchElementException(NoSuchElementException noSuchElementException) {
		
		ProblemDetail problemDetail = new ProblemDetail();
		problemDetail.setMessage(ExceptionMessageConstant.noSuchElementMessage);
		
		return problemDetail;
		
	}
	
	

}
