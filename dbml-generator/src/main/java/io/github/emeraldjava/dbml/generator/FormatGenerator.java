package io.github.emeraldjava.dbml.generator;

import com.wn.dbml.model.Database;

import java.io.File;
import java.util.List;

/**
 * Interface for all output format generators
 */
public interface FormatGenerator {

    String getName();

    List<File> createGeneratedFile(Database database);

}
