package by.tms.entity;


public abstract class AbstractEntity {
	protected User owner;
	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "AbstractEntity{" +
				"id=" + id +
				'}';
	}
}
