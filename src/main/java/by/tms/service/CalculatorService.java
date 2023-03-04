package by.tms.service;


import by.tms.entity.Operation;

import by.tms.entity.User;
import by.tms.storage.InFileOperationStorage;
import by.tms.storage.InMemoryOperationStorage;
import by.tms.storage.JDBCOperationStorage;
import by.tms.storage.OperationStorage;



import java.util.List;

public class CalculatorService {

    private final OperationStorage fileStorage = new InFileOperationStorage();
    private final OperationStorage memoryStorage = new InMemoryOperationStorage();
    JDBCOperationStorage jdbcOperationStorage=new JDBCOperationStorage();

    public Operation calculate(Operation operation) {
        String stringtype = operation.getType().toUpperCase();

        Type type = Type.valueOf(stringtype);


        switch (type) {

            case SUM:
                operation.setResult(sum(operation.getNum1(), operation.getNum2()));
                fileStorage.save(operation);
                memoryStorage.save(operation);
                jdbcOperationStorage.save(operation);
                return operation;
            case SUB:
                operation.setResult(sub(operation.getNum1(), operation.getNum2()));
                fileStorage.save(operation);
                memoryStorage.save(operation);
                jdbcOperationStorage.save(operation);
                return operation;
            case MULT:
                operation.setResult(mult(operation.getNum1(), operation.getNum2()));
                fileStorage.save(operation);
                memoryStorage.save(operation);
                jdbcOperationStorage.save(operation);
                return operation;
            case DIV:
                operation.setResult(div(operation.getNum1(), operation.getNum2()));
                fileStorage.save(operation);
                memoryStorage.save(operation);
                jdbcOperationStorage.save(operation);
                return operation;


        }
        return null;
    }

    private static double sum(double a, double b) {
        return a + b;
    }

    private static double sub(double a, double b) {
        return a - b;
    }

    private static double mult(double a, double b) {
        return a * b;
    }

    private static double div(double a, double b) {
        return a / b;
    }

    public List<Operation> showHistory() {
        return memoryStorage.findAll();
    }

    enum Type {
        SUM,
        SUB,
        MULT,
        DIV
    }
}

	//public List<Operation> findAllByUser(User user) {
      //  Object storage;
        //List<Operation> allByUserId = storage.getAllByUserId(user.getId());
		//reurn allByUserId;
//	}


