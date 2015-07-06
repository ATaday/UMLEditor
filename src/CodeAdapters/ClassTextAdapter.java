package CodeAdapters;

import Classes.Class;
import Default.Global;
import Objects.Function;
import Objects.Variable;

public class ClassTextAdapter {
	private Class classOfFile = null;

	public ClassTextAdapter(Class inClassOfFile) {
		classOfFile = inClassOfFile;
	}

	// extends'den sonra implements gelir, tam tersi java'nin yapisina uygun
	// degildir.
	public String GetCodeOfClass() {
		Classes.Class inheritedFrom = null;

		String result = "";

		if (classOfFile.connectionMethods.contains(Global.INTERFACE_PARENT)) {
			result += "public interface " + classOfFile.GetClassName();
		} else {
			result += "public class " + classOfFile.GetClassName();
		}

		if (classOfFile.parents.size() > 0) {
			// Multiple inheritance yoktur.
			if (classOfFile.connectionMethods.contains(Global.INHERITANCE_CHILD)) {
				result += "\n";

				result += "    extends " + classOfFile.parents.get(0).GetClassName();

				inheritedFrom = classOfFile.parents.get(0);
			}

			// Multiple interface var.
			if (classOfFile.connectionMethods.contains(Global.INTERFACE_CHILD)) {
				result += "\n";
				// Eger tek bir ata varsa ve o da inherit olunan sinifsa
				if (classOfFile.parents.size() == 1 && classOfFile.parents.get(0) == inheritedFrom) {
					result += " ";
				} else {
					result += "    implements ";
				}

				for (int i = 0; i < classOfFile.parents.size(); i++) {
					if (inheritedFrom != classOfFile.parents.get(i)) {
						result += classOfFile.parents.get(i).GetClassName();

						if (i != classOfFile.parents.size() - 1) {
							result += ", ";
						}

						// Implement edilen interface'lerin fonksiyonlarini
						// Bu sinifa aldik.
						classOfFile.AddNewFunction(classOfFile.parents.get(i).GetFunction(i));
					}
				}
			}

			if (classOfFile.connectionMethods.contains(Global.AGGREGATION_CHILD)) {
				Class aggregatedFrom = null;
				for (int j = 0; j < classOfFile.GetAggregatedFromSize(); j++) {
					aggregatedFrom = classOfFile.GetAggregatedFrom(j);

					if (aggregatedFrom != null) {
						classOfFile.AddNewVariable(new Variable("var_" + aggregatedFrom.GetClassName().toLowerCase(),
								aggregatedFrom.GetClassName(), false));
					}
				}

			}
		}
		result += "\n{\n\n";

		Variable var = null;
		Variable subVar = null;

		Function func = null;

		for (int i = 0; i < classOfFile.GetVariableSize(); i++) {
			var = classOfFile.GetVariable(i);

			if (var.GetVisibility()) {
				result += "    public ";
			} else {
				result += "    private ";
			}
			result += var.GetVariableType() + " " + var.GetVariableName() + ";\n";
		}

		if (classOfFile.GetVariableSize() > 0) {
			result += "\n";
		}

		for (int i = 0; i < classOfFile.GetFunctionSize(); i++) {
			func = classOfFile.GetFunction(i);

			if (func.GetVisibility()) {
				result += "    public ";
			} else {
				result += "    private ";
			}

			result += func.GetFunctionReturnType() + " " + func.GetFunctionName() + "(";

			for (int j = 0; j < func.GetFunctionParameterList().size(); j++) {
				subVar = func.GetFunctionParameterList().get(j);
				result += subVar.GetVariableType() + " " + subVar.GetVariableName();

				if (j != func.GetFunctionParameterList().size() - 1) {
					result += ", ";
				}
			}
			result += ")\n    {\n\n    }\n";
		}

		if (classOfFile.GetFunctionSize() > 0) {
			result += "\n";
		}

		// Constructor
		if (inheritedFrom != null) {
			result += "    public " + classOfFile.GetClassName() + "()\n";
			result += "    {\n        super();\n    }";
		}

		result += "\n\n}\n";
		return result;
	}
}
