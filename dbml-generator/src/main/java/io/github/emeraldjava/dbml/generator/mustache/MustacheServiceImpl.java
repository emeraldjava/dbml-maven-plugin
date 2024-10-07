package io.github.emeraldjava.dbml.generator.mustache;

import com.samskivert.mustache.Mustache;
import lombok.extern.slf4j.Slf4j;

import java.io.*;

@Slf4j
public class MustacheServiceImpl implements MustacheService {

    public String jmustache(Object input) {
        String tmpl = "debug{{this}} {{#persons}}{{name}}: {{age}}\n{{/persons}}";
        //Writer writer = new PrintWriter(System.out);
        Writer writer = new StringWriter();

        File templateDir = null;
        Mustache.Compiler compiler = Mustache.compiler();
        String result = compiler.compile(tmpl).execute(input);
        return result;
    }

    private void jmustacheTemplate(Object input, String template) {
        String tmpl = "debug{{this}} {{#persons}}{{name}}: {{age}}\n{{/persons}}";
        //Writer writer = new PrintWriter(System.out);
        Writer writer = new StringWriter();

        File templateDir = null;
        Mustache.Compiler compiler = Mustache.compiler().withLoader(new Mustache.TemplateLoader() {
            @Override
            public Reader getTemplate(String name) throws Exception {
                return new FileReader(new File(templateDir,name));
            }
        });

        String result = compiler.compile(tmpl).execute(input);
        log.info("{}",result
        );
    }
}
