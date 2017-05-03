package ru.medsignal.configurations;

import jdk.nashorn.api.scripting.NashornScriptEngine;
import org.springframework.stereotype.Component;

import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;

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
        nashornScriptEngine.eval ("load ('src/main/resources/static/nashorn-polyfill.js')");
        nashornScriptEngine.eval ("load ('src/main/resources/static/app.bundle.js')");

        return nashornScriptEngine;
    }
}
