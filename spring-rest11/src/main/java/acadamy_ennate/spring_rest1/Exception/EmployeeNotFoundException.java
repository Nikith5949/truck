package acadamy_ennate.spring_rest1.Exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends RuntimeException{
	public EmployeeNotFoundException(String mes) {
		super(mes);
	}
}