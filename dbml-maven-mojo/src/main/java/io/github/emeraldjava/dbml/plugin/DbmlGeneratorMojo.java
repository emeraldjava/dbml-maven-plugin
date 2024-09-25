package io.github.emeraldjava.dbml.plugin;

import io.github.emeraldjava.dbml.generator.DbmlGenerator;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;

/**
 * DbmlGeneratorMojo
 */
@Mojo(name = "generate")
public class DbmlGeneratorMojo extends AbstractDbmlMojo {

    private DbmlGenerator dbmlGenerator;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        getLog().info("DbmlGeneratorMojo");
    }
}
