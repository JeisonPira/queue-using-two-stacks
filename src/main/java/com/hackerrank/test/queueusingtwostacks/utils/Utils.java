package com.hackerrank.test.queueusingtwostacks.utils;

import com.hackerrank.test.queueusingtwostacks.exception.TechnicalException;

import java.util.List;

public class Utils {

    public static Boolean validOperations(List<String> operations) throws TechnicalException {
        boolean valid = true;
        try {
            for (String operationStn : operations) {
                String[] values = operationStn.split("\\s+");
                int operation = Integer.parseInt(values[0]);
                if (operation == 1) {
                    Integer.parseInt(values[0]);
                    Integer.parseInt(values[1]);
                } else if (operation == 2 || operation == 3) {
                    Integer.parseInt(values[0]);
                } else {
                    valid = false;
                }
            }
        } catch (NumberFormatException ne) {
            throw new TechnicalException(ne.getMessage(), ne.getCause());
        } catch (ArrayIndexOutOfBoundsException ae) {
            throw new TechnicalException(ae.getMessage(), ae.getCause());
        }
        return valid;
    }
}
