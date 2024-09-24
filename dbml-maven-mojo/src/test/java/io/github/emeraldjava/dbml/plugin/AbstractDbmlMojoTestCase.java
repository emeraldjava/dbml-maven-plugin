package io.github.emeraldjava.dbml.plugin;

import org.apache.commons.io.FileUtils;
import org.apache.maven.artifact.repository.ArtifactRepository;
import org.apache.maven.artifact.repository.ArtifactRepositoryPolicy;
import org.apache.maven.artifact.repository.MavenArtifactRepository;
import org.apache.maven.execution.DefaultMavenExecutionRequest;
import org.apache.maven.execution.MavenExecutionRequest;
import org.apache.maven.execution.MavenSession;
import org.apache.maven.plugin.Mojo;
import org.apache.maven.plugin.MojoExecution;
import org.apache.maven.plugin.testing.AbstractMojoTestCase;
import org.apache.maven.project.MavenProject;
import org.apache.maven.project.ProjectBuilder;
import org.apache.maven.project.ProjectBuildingRequest;
import org.apache.maven.repository.internal.MavenRepositorySystemUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

abstract class AbstractDbmlMojoTestCase extends AbstractMojoTestCase {
    //    protected Path getUnitTestDir() {
//        return Paths.get(getBasedir(), "src", "test", "resources", "unit");
//    }

    protected Mojo loadMojo(Path temporaryFolder, String projectRoot, String profile, String executionId) throws Exception {
        FileUtils.copyDirectory(new File(projectRoot), temporaryFolder.toFile());
        MavenProject project = null;//readMavenProject(temporaryFolder, profile);
        MavenSession session = newMavenSession(project);
        MojoExecution execution = newMojoExecution("generate");
        MojoExecution executionWithId = copyWithExecutionId(executionId, execution);
        return lookupConfiguredMojo(session, executionWithId);
    }

//    protected MavenProject readMavenProject(Path basedir, String profile) throws Exception {
//        LocalRepository localRepo = new LocalRepository(basedir.resolve("local-repo").toFile());
//        DefaultRepositorySystemSession session = MavenRepositorySystemUtils.newSession();
//
//        // add localRepo - framework doesn't do this on its own
//        //ArtifactRepository localRepox = createLocalArtifactRepository();
//        //session.setLocalRepositoryManager(localRepo);//.setLocalRepository(localRepo);
////        session.setLocalRepositoryManager(
////                new SimpleLocalRepositoryManagerFactory(new DefaultLocalPathComposer()).newInstance(session, localRepo)
////        );
//        MavenExecutionRequest request = new DefaultMavenExecutionRequest().setBaseDirectory(basedir.toFile());
//        if (profile != null) {
//            request.addActiveProfile(profile);
//        }
//        ProjectBuildingRequest configuration = request.getProjectBuildingRequest()
//                .setRepositorySession(session)
//                .setResolveDependencies(true);
//        MavenProject project = lookup(ProjectBuilder.class)
//                .build(basedir.resolve("pom.xml").toFile(), configuration)
//                .getProject();
//        assertNotNull(project);
//        return project;
//    }

    protected static Path newTempFolder() throws IOException {
        final Path tempDir = Files.createTempDirectory("test");
        tempDir.toFile().deleteOnExit();
        return tempDir;
    }

    private MojoExecution copyWithExecutionId(String executionId, MojoExecution execution) {
        MojoExecution executionWithId  = new MojoExecution(execution.getMojoDescriptor(), executionId);
        executionWithId.setConfiguration(execution.getConfiguration());
        return executionWithId;
    }

    /**
     * Generate a local repository
     * @return local repository object
     *
     * via https://stackoverflow.com/questions/42216442/maven-plugin-testing-harness-session-getlocalrepository-returns-null
     */
//    private ArtifactRepository createLocalArtifactRepository() {
//        MavenArtifactRepository local = new MavenArtifactRepository("local",
//                localRepo.toURI().toString(),
//                new DefaultRepositoryLayout(),
//                new ArtifactRepositoryPolicy(true, ArtifactRepositoryPolicy.UPDATE_POLICY_ALWAYS, ArtifactRepositoryPolicy.CHECKSUM_POLICY_IGNORE),
//                new ArtifactRepositoryPolicy(true, ArtifactRepositoryPolicy.UPDATE_POLICY_ALWAYS, ArtifactRepositoryPolicy.CHECKSUM_POLICY_IGNORE)
//        );
//        return local;
//    }
}
