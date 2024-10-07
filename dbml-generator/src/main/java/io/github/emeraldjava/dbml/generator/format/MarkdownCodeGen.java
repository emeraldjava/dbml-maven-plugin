package io.github.emeraldjava.dbml.generator.format;

import com.wn.dbml.model.Database;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.List;

@Slf4j
public class MarkdownCodeGen extends AbstractGenerator {

    public List<File> createGeneratedFile(Database database) {
        return null;
    }


    @Override
    public String getName() {
        return "markdown";
    }
}
