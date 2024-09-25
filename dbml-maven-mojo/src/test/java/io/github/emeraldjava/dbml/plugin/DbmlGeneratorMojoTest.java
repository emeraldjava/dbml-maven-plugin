package io.github.emeraldjava.dbml.plugin;

import org.apache.maven.project.MavenProject;
import org.junit.Test;

import java.io.File;

/**
 * DbmlGeneratorMojoTest
 *
 * Need to use the junit 4 annotation since maven-test-harness is linked to it.
 */
public class DbmlGeneratorMojoTest extends AbstractDbmlMojoTestCase {

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    /**
     * https://stackoverflow.com/questions/70921236/how-to-make-mavenproject-injected-into-the-mojo-during-test-lookup
     *
     * @throws Exception
     */
    @Test
    public void test_generate() throws Exception {
        MavenProject project = readMavenProject( new File( "src/test/resources/projects/default" ) );
        DbmlGeneratorMojo mojo = (DbmlGeneratorMojo) lookupConfiguredMojo( project, "generate" );
        mojo.execute();
    }
}