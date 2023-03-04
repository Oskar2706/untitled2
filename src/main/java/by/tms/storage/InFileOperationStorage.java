package by.tms.storage;



import by.tms.entity.Operation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InFileOperationStorage implements OperationStorage {

    private static final String FILE_NAME = "History.txt";

    public void save(Operation operation) {
        try (FileWriter fileWriter = new FileWriter(FILE_NAME, true)) {
            fileWriter.write(operation.toString());
            fileWriter.write("\n");
            fileWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Operation> findAll() {
        throw new UnsupportedOperationException("To be implemented...");
    }

    public List<String> readFromFile() {
        List<String> operationFromFile = new ArrayList<>();
        try (BufferedReader fileRider = new BufferedReader(new FileReader(FILE_NAME))) {

            String operation;
            while ((operation = fileRider.readLine()) != null) {
                operationFromFile.add(operation);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return operationFromFile;
    }


}
