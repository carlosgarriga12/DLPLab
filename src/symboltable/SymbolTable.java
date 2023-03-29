package symboltable;

import java.util.*;
import ast.definition.Definition;
import ast.definition.VariableDefinition;
import ast.expression.Variable;
import ast.type.ErrorType;


public class SymbolTable {
	
	private int scope=0;
	private List<Map<String, Definition>> table;

	public SymbolTable()  {
		table = new ArrayList<>();
		table.add(new HashMap<>());
	}

	public void set() {
		table.add(new HashMap<>());
		scope++;
	}
	
	public void reset() {
		table.remove(scope);
		scope--;
	}
	
	public boolean insert(Definition definition) {
		Definition definitionToFind = findInCurrentScope(definition.getName());
		if(definitionToFind == null) {
			table.get(scope).put(definition.getName(), definition);
			definition.setScope(scope);
			return true;
		} else {
			if (definition instanceof VariableDefinition) {
				new ErrorType(
						definitionToFind.getLine(),
						definitionToFind.getColumn(),
						"Repeated variable definition " + definition.getName()
				);
			} else {
				new ErrorType(
						definitionToFind.getLine(),
						definitionToFind.getColumn(),
						"Repeated function definition " + definition.getName());
			}

			return false;
		}
	}
	
	public Definition find(String id) {
		for (int i = scope; i>=0; i--) {
			Definition def = table.get(i).get(id);
			if (def != null) {
				return def;
			}
		}
		return null;
	}

	public Definition findInCurrentScope(String id) {
		Definition def = table.get(scope).get(id);
		return def;
	}

	public int getScope(){
		return this.scope;
	}
}
