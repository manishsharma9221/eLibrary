/*
 *  Copyright Impetus @2000-2014
 */
package in.co.impetus.controllers;

import org.hibernate.JDBCException;
import org.hibernate.SessionException;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.GenericJDBCException;
import org.hibernate.exception.SQLGrammarException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mysql.jdbc.exceptions.MySQLSyntaxErrorException;

// TODO: Auto-generated Javadoc
/**
 * The Class ExceptionHandlerController.
 */
@ControllerAdvice
public class ExceptionHandlerController {
    /** The Constant LOGGER. */

    private static final Logger LOGGER = LoggerFactory
            .getLogger(ExceptionHandlerController.class);

    /**
     * Sql grammer exception.
     * 
     * @param e
     *            the e
     * @return the string
     */
    @ExceptionHandler(SQLGrammarException.class)
    public String sqlGrammerException(Exception e) {
        LOGGER.error("SQL Grammar Exception.\nException ::\n" + e);
        return "databaseException";
    }

    /**
     * Generic jdbc exception.
     * 
     * @param e
     *            the e
     * @return the string
     */
    @ExceptionHandler(GenericJDBCException.class)
    public String genericJdbcException(Exception e) {
        LOGGER.error("Generic JDBC Exception.\nException ::\n" + e);
        return "databaseException";
    }

    /**
     * SQ lexception.
     * 
     * @param e
     *            the e
     * @return the string
     */
    @ExceptionHandler(CannotCreateTransactionException.class)
    public String sqlException(Exception e) {
        LOGGER.error("Error connecting Database.\nException ::\n" + e);
        return "databaseException";
    }

    /**
     * Session exception.
     * 
     * @param e
     *            the e
     * @return the string
     */
    @ExceptionHandler(SessionException.class)
    public String sessionException(Exception e) {
        LOGGER.error("Session Exception.\nException ::\n" + e);
        return "databaseException";
    }

    /**
     * Null pointer exception.
     * 
     * @param e
     *            the e
     * @return the string
     */
    @ExceptionHandler(NullPointerException.class)
    public String nullPointerException(Exception e) {
        LOGGER.error("Null Pointer Exception.\nException ::\n" + e);
        return "errorPage";
    }

    /**
     * My sql syntax exception.
     * 
     * @param e
     *            the e
     * @return the string
     */
    @ExceptionHandler(MySQLSyntaxErrorException.class)
    public String mySqlSyntaxException(Exception e) {
        LOGGER.error("(MySQLSyntaxErrorException.\nException ::\n" + e);
        return "errorPage";
    }

    /**
     * Constraint violation exception exception.
     *
     * @param e the e
     * @return the string
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public String constraintViolationExceptionException(Exception e) {
        return "errorPage";
    }
    
    /**
     * Jdbc exception.
     *
     * @param e the e
     * @return the string
     */
    @ExceptionHandler( JDBCException.class)
    public String jdbcException(Exception e) {
        return "errorPage";
    }


   

}
