package io.github.emeraldjava.dbml.plugin;

import org.apache.maven.execution.DefaultMavenExecutionRequest;
import org.apache.maven.execution.MavenExecutionRequest;
import org.apache.maven.plugin.testing.AbstractMojoTestCase;
import org.apache.maven.project.MavenProject;
import org.apache.maven.project.ProjectBuilder;
import org.apache.maven.project.ProjectBuildingException;
import org.apache.maven.project.ProjectBuildingRequest;
import org.eclipse.aether.DefaultRepositorySystemSession;

import java.io.File;

/**
 * Base class for all dbml mojo tests.
 */
abstract class AbstractDbmlMojoTestCase extends AbstractMojoTestCase {

    /**
     * Loads the maven project config for the test case.
     * see https://github.com/apache/maven-plugin-testing/blob/maven-plugin-testing-3.3.0/maven-plugin-testing-harness/src/test/java/org/apache/maven/plugin/testing/ParametersMojoTest.java
     * @param basedir
     * @return
     * @throws ProjectBuildingException
     * @throws Exception
     */
    protected MavenProject readMavenProject( File basedir )
            throws ProjectBuildingException, Exception
    {
        File pom = new File( basedir, "pom.xml" );
        MavenExecutionRequest request = new DefaultMavenExecutionRequest();
        request.setBaseDirectory( basedir );
        ProjectBuildingRequest configuration = request.getProjectBuildingRequest();
        configuration.setRepositorySession( new DefaultRepositorySystemSession() );
        MavenProject project = lookup( ProjectBuilder.class ).build( pom, configuration ).getProject();
        assertNotNull( project );
        return project;
    }
}
