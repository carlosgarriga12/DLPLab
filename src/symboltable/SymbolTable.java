package symboltable;

import java.util.*;
import ast.definition.Definition;
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
		if(findInCurrentScope(definition.getName()) == null) {
			table.get(scope).put(definition.getName(), definition);
			definition.setScope(scope);
			return true;
		} else {
			new ErrorType(definition.getLine(), definition.getColumn(), "Repeated definition");
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
