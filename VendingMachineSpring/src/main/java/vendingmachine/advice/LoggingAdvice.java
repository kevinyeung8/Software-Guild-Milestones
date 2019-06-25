/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.advice;

import org.aspectj.lang.JoinPoint;
import vendingmachine.dao.VendingMachineAuditDao;
import vendingmachine.dao.VendingMachinePersistenceException;

/**
 *
 * @author kevinyeung
 */
public class LoggingAdvice {
    
    VendingMachineAuditDao auditDao;

    public LoggingAdvice(VendingMachineAuditDao auditDao) {
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
        } catch (VendingMachinePersistenceException ex) {
            System.err.println(
                    "ERROR: Could not create audit entry in LoggingAdvice.");
        }
    }
}
    
