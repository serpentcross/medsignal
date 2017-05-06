package ru.medsignal.configurations;

import jdk.nashorn.api.scripting.NashornScriptEngine;
import org.springframework.stereotype.Component;

import javax.script.ScriptContext;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.script.SimpleScriptContext;
import java.io.FileNotFoundException;
import java.io.StringWriter;

@Component
public class React {

    public String renderEntryPoint() throws ScriptException, FileNotFoundException {

        NashornScriptEngine nashornScriptEngine = getNashornScriptEngine();

        try {
            Object html = nashornScriptEngine.invokeFunction("renderServer");
            return String.valueOf(html);
        } catch (Exception e) {
            throw new IllegalStateException("Error! Failed to render react component!", e);
        }
    }


    private NashornScriptEngine getNashornScriptEngine() throws ScriptException {

        NashornScriptEngine nashornScriptEngine = (NashornScriptEngine) new ScriptEngineManager().getEngineByName ("nashorn");

//        ScriptContext scriptContext = new SimpleScriptContext();
//        StringWriter stringWriter = new StringWriter();
//        scriptContext.setWriter(stringWriter);
//        scriptContext.setAttribute("factory", nashornScriptEngine.getFactory(), ScriptContext.GLOBAL_SCOPE);

        nashornScriptEngine.eval ("load ('src/main/resources/static/nashorn-polyfill.js')");
        nashornScriptEngine.eval ("load ('src/main/resources/static/example.js')");
        nashornScriptEngine.eval ("load ('src/main/resources/static/bundle.js')");

        return nashornScriptEngine;
    }
}
