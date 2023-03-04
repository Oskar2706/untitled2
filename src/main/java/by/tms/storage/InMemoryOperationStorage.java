package by.tms.storage;



import by.tms.entity.Operation;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class InMemoryOperationStorage implements OperationStorage {

//	private long nextId = 1;

	private final List<Operation> operationList = new ArrayList<>();

	public void save(Operation operation) {
//		operation.setId(nextId);
		operationList.add(operation);
//		nextId++;
	}

	public List<Operation> findAll() {
		return new ArrayList<>(operationList);
	}

	{
		List<String> types = operationList.stream()
//			.map(operation -> operation.getType())
				.map(Operation::getType)
				.toList();
	}

//	public List<Operation> getAllByUserId(long id) {
//		Predicate<Operation> compareUserIds = operation -> operation.getOwner().getId() == id;
//
//		List<Operation> collectedList = operationList.stream()
//				.filter(
//						compareUserIds
//				)
//				.collect(
//						Collectors.toList()
//				);
//		return collectedList;
//		List<Operation> operations = new ArrayList<>();
//		for (Operation operation : operationList) {
//			if (operation.getOwner().getId() == id) {
//				operations.add(operation);
//			}
//		}
//		return operations;
	}

