package Objects;

public class Variable {
	private String variableName;
	private String variableType;
	private boolean visibility;

	public Variable(String varName, String varType, boolean vbility) {
		this.variableName = varName;
		this.variableType = varType;
		this.visibility = vbility;
	}

	public String GetVariableName() {
		return variableName;
	}

	public String GetVariableType() {
		return variableType;
	}

	public boolean GetVisibility() {
		return visibility;
	}

	public String GetStringVersion() {
		String result;

		if (visibility) {
			result = "+ " + variableName + ": " + variableType;
		} else {
			result = "- " + variableName + ": " + variableType;
		}
		return result;
	}
}
