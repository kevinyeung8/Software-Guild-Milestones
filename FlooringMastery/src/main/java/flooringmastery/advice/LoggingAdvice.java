/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flooringmastery.advice;

import flooringmastery.dao.FlooringMasteryAuditDao;
import flooringmastery.dao.FlooringMasteryPersistenceException;
import org.aspectj.lang.JoinPoint;

/**
 *
 * @author kevinyeung
 */
public class LoggingAdvice {
    
    FlooringMasteryAuditDao auditDao;

    public LoggingAdvice(FlooringMasteryAuditDao auditDao) {
        this.auditDao = auditDao;
    }

    public void createAuditEntry(JoinPoint jp, Throwable e) {
        Object[] args = jp.getArgs();
        String auditEntry = jp.getSignature().getName() + " " +
                e.getMessage() + ": ";
        for (Object currentArg : args) {
            auditEntry += currentArg;
        }
        try {
            auditDao.writeAuditEntry(auditEntry);
        } catch (FlooringMasteryPersistenceException ex) {
            System.err.println(
                    "ERROR: Could not create audit entry in LoggingAdvice.");
        }
    }
}
    
