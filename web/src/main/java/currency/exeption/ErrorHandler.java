package currency.exeption;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;


@RestControllerAdvice
@Slf4j
public class ErrorHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleIllegalArgumentException(final ConflictDataException e) {
        return newApiError(e, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiError handleDataNotFound(final DataNotFound e) {
        return newApiError(e, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiError handleThrowable(final Throwable e) {
        return newApiError(e, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ApiError newApiError(Throwable e, HttpStatus httpStatus) {
        StringBuilder errors = new StringBuilder();
        for (StackTraceElement error : e.getStackTrace()) {
            errors.append(error).append("\n");
        }
        ApiError apiError = new ApiError(errors.toString(),
                e.getMessage(),
                httpStatus.toString(),
                LocalDateTime.now().toString());
        if (e.getCause() != null) {
            apiError.setReason(e.getCause().toString());
        }
        log.info("Возвращена ошибка: \n" + e.getClass() + "\n" + apiError);
        return apiError;
    }
}
