package Objects;

import java.util.ArrayList;

public class Function {
	private String functionName;
	private String functionReturnType;
	private ArrayList<Variable> functionParamList;

	private boolean visibility;

	public Function(String funcName, String funcRetType, ArrayList<Variable> paramList, boolean vbility) {
		this.functionName = funcName;
		this.functionReturnType = funcRetType;
		this.functionParamList = paramList;
		this.visibility = vbility;
	}

	public String GetFunctionName() {
		return functionName;
	}

	public String GetFunctionReturnType() {
		return functionReturnType;
	}

	public ArrayList<Variable> GetFunctionParameterList() {
		return functionParamList;
	}

	public boolean GetVisibility() {
		return visibility;
	}

	public String GetFunctionGeneralInfoStringVersion() {
		String result = "";

		if (visibility) {
			result += "+ ";
		} else {
			result += "- ";
		}
		result += functionName + ": " + functionReturnType;

		for (int i = 0; i < functionParamList.size(); i++) {
			result += "  " + functionParamList.get(i).GetVariableName() + ": "
					+ functionParamList.get(i).GetVariableType();
		}
		return result;
	}
}
