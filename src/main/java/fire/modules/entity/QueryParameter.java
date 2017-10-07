package fire.modules.entity;

public class QueryParameter {
	
	private String name = null;
	private String value = null;


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getValue() {
		return value;
	}


	public void setValue(String value) {
		this.value = value;
	}


	/// <summary>
	/// Initializes a new instance of the <see cref="QueryParameter"/> class.
	/// </summary>
	/// <param name="name">The name.</param>
	/// <param name="value">The value.</param>
	public QueryParameter(String name, String value)
	{
		this.name = name;
		this.value = value;
	}


}
