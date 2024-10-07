package io.github.emeraldjava.dbml.generator;

import com.samskivert.mustache.Mustache;
import com.wn.dbml.compiler.DbmlParser;
import com.wn.dbml.model.Database;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.sourceforge.plantuml.FileFormat;
import net.sourceforge.plantuml.FileFormatOption;
import net.sourceforge.plantuml.SourceStringReader;

import java.io.*;
import java.nio.charset.Charset;

@Slf4j
public class DbmlGeneratorImpl implements DbmlGenerator {

    @Getter
    @Setter
    Mustache.Compiler compiler = Mustache.compiler();

    @Override
    public String generate() {

        // get the DBML db
        String dbml = """
        Table table1 {
          id integer
        }""";
        Database database = DbmlParser.parse(dbml);
        log.info("{}",database.getSchema("public").getTables().toString());

        // mustache
        jmustache(database.getSchema("public").getTables());

        // to plantuml svg

        return "dostuff";
    }

    /**
     * https://github.com/samskivert/jmustache
     * use the {{this}} trick
     */
    private void jmustache(Object input) {
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

    /**
     * https://plantuml.com/api
     */
    private void plantUmlToSvg() throws Exception {
        String source = "@startuml\n";
        source += "Bob -> Alice : hello\n";
        source += "@enduml\n";

        SourceStringReader reader = new SourceStringReader(source);
        final ByteArrayOutputStream os = new ByteArrayOutputStream();
        // Write the first image to "os"
        String desc = reader.generateImage(os, new FileFormatOption(FileFormat.SVG));
        os.close();

        // The XML is stored into svg
        final String svg = new String(os.toByteArray(), Charset.forName("UTF-8"));
    }

    public static void main(String[] args) {
        DbmlGeneratorImpl impl = new DbmlGeneratorImpl();
        impl.generate();
    }
}
