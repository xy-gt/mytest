package test.script;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * ≤‚ ‘java Ω≈±æ
 * @author soonsmile
 *
 */
public class TestScript {

	public static void main(String[] args) throws ScriptException {
		 // create a script engine manager
        ScriptEngineManager factory = new ScriptEngineManager();
        // create a JavaScript engine
        ScriptEngine engine = factory.getEngineByName("JavaScript");
        // evaluate JavaScript code from String
        engine.eval("print('Hello, World')");
	}

}
