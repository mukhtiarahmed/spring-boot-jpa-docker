package com.siroi.assignment.exception;

import com.siroi.assignment.util.SiroiAssignmentHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

/**
 * The exception handler.
 *
 * @author  mukhtiar.ahmed
 * @version 1.0
 */
@Slf4j
@ControllerAdvice
public class ExceptionHandlerController {

    /**
     * Handle EntityNotFoundException.
     *
     * @param exception the exception
     * @return the error response
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    public ModelAndView handleEntityNotFound(HttpServletRequest request, EntityNotFoundException exception) {
        log.info("EntityNotFoundException Occured:: URL {} ", request.getRequestURL());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(SiroiAssignmentHelper.ERROR, exception.getMessage());
        modelAndView.setViewName("error");
        return  modelAndView;
    }

    /**
     * Handle InvalidDataException.
     *
     * @param exception the exception
     * @return the error response
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({InvalidDataException.class})
    public ModelAndView handleBadRequest(HttpServletRequest request, InvalidDataException exception) {
        log.info("InvalidDataException Occured:: URL {} ", request.getRequestURL());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(SiroiAssignmentHelper.ERROR, exception.getMessage());
        modelAndView.setViewName("error");
        return  modelAndView;
    }
    
    /**
     * HttpRequestMethodNotSupportedException
     * @param exception the exception
     * @return the error response
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentTypeMismatchException.class})
    public  ModelAndView handleBadRequest(HttpServletRequest request,
                                          MethodArgumentTypeMismatchException exception) {
        log.info("MethodArgumentTypeMismatchException Occured:: URL {} , method {} ",
                request.getRequestURL(), request.getMethod());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(SiroiAssignmentHelper.ERROR, "Internal Server error. Please contact to admin");
        modelAndView.setViewName("error");
        return  modelAndView;
    }
    
    /**
     * HttpRequestMethodNotSupportedException
     * @param exception the exception
     * @return the error response
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public ModelAndView handleBadRequest(HttpServletRequest request,
                                         HttpRequestMethodNotSupportedException exception) {
        log.info("HttpRequestMethodNotSupportedException Occured:: URL {} , method {} ",
                request.getRequestURL(), request.getMethod());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(SiroiAssignmentHelper.ERROR, exception.getMessage());
        modelAndView.setViewName("error");
        return  modelAndView;
    }
    
    /**
     * HttpRequestMethodNotSupportedException
     * @param exception the exception
     * @return the error response
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({HttpMessageNotReadableException.class})
    public ModelAndView handleBadRequest(HttpServletRequest request, HttpMessageNotReadableException exception) {
        log.info("HttpMessageNotReadableException Occured:: URL {} , method {} ",
                request.getRequestURL(), request.getMethod());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(SiroiAssignmentHelper.ERROR, exception.getMessage());
        modelAndView.setViewName("error");
        return  modelAndView;
    }
    
    /**
     * Handle SiroiAssignmentException.
     *
     * @param exception the exception
     * @return the error response
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(SiroiAssignmentException.class)
    public ModelAndView handleBadRequest(HttpServletRequest request, SiroiAssignmentException exception) {
        log.error("SiroiAssignmentException Occured:: URL {} , method {} ",
                request.getRequestURL(), request.getMethod(), exception);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(SiroiAssignmentHelper.ERROR, exception.getMessage());
        modelAndView.setViewName("error");
        return  modelAndView;
    }

    /**
     * Handle all other runtime exceptions.
     *
     * @param exception the exception
     * @return the error response
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RuntimeException.class)
    public ModelAndView handleBadRequest(HttpServletRequest request,  RuntimeException exception) {
        log.error("RuntimeException Occured:: URL {} , method {} ",
                request.getRequestURL(), request.getMethod(), exception);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(SiroiAssignmentHelper.ERROR, "Internal Server error. Please contact to admin");
        modelAndView.setViewName("error");
        return  modelAndView;
    }
    
    /**
     * Handle all SQLException exceptions.
     *
     * @param exception the exception
     * @return the error response
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(SQLException.class)
    public ModelAndView handleBadRequest(HttpServletRequest request,  SQLException exception) {
        log.error("SQLException Occured:: URL {} , method {} ",
                request.getRequestURL(), request.getMethod(), exception);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(SiroiAssignmentHelper.ERROR, "Internal Server error. Please contact to admin");
        modelAndView.setViewName("error");
        return  modelAndView;
    }

    /**
     * Handle all other exceptions.
     *
     * @param exception the exception
     * @return the error response
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ModelAndView handleBadRequest(HttpServletRequest request,  Exception exception) {
        log.error("Exception Occured:: URL {} , method {} ",
                request.getRequestURL(), request.getMethod(), exception);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(SiroiAssignmentHelper.ERROR, "Internal Server error. Please contact to admin");
        modelAndView.setViewName("error");
        return  modelAndView;
    }

}
