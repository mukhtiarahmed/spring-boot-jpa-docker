package com.siroi.assignment.exception;

/**
 * @author Mukhtiar Ahmed
 */
public class SiroiAssignmentException extends BusinessException {

  private static final long serialVersionUID = 8087867092781813380L;


  /**
   * <p>
   * This is the constructor of <code>SiroiAssignmentException</code> class with message argument.
   * </p>
   *
   * @param message the error message.
   */
  public SiroiAssignmentException(String message) {
    super(message);
  }

  /**
   * <p>
   * This is the constructor of <code>SiroiAssignmentException</code> class with message and cause arguments.
   * </p>
   *
   * @param message the error message.
   * @param cause the cause of the exception.
   */
  public SiroiAssignmentException(String message, Throwable cause) {
    super(message, cause);
  }
}
