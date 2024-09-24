package io.github.emeraldjava.dbml.plugin;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

public class DbmlGeneratorMojoTest extends AbstractDbmlMojoTestCase {

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Test
    public void test_A() throws Exception {
        DbmlGeneratorMojo mojo = getGenerateMojo();
//        mojo.inputSpec = null;
  //      mojo.inputSpecRootDirectory = null;


        mojo.execute();

//        generateMojo.analyser = mock(ConfigurationXmlFileOutOfDateResolver.class);
//        generateMojo.productConfigRootFolder = new File(getBasedir(), "src/test/resources/test-projects/generate/src/main/resources/xml");
//        generateMojo.transformer = mock(ConfigurationMergeTransformer.class);
//
//        when(generateMojo.analyser.resolveFilesNeedingUpdate(any(File.class), any(File.class))).thenReturn(getNoFilesNeedingUpdate());
//
//        generateMojo.execute();
//
//        verify(generateMojo.transformer, never()).transform(any(Collection.class), any(File.class), any(ConfigurationType.class));
    }

    //@Test
    public void xx() throws Exception {
        File testPom = new File(getBasedir(), "src/test/resources/projects/default/pom.xml" );
        //aseertNotNull(testPom);
        //https://stackoverflow.com/questions/44009232/nosuchelementexception-thrown-while-testing-maven-plugin/65523947#65523947
        DbmlGeneratorMojo mojo = new DbmlGeneratorMojo();
        mojo = (DbmlGeneratorMojo) super.configureMojo(mojo, extractPluginConfiguration("dbml-maven-plugin", testPom));
        mojo.execute();
    }

//    private DbmlGeneratorMojo getGenerateMojo() throws Exception {
////        File testPom = new File(getBasedir(), "src/test/resources/projects/default/pom.xml" );
//
//        final Path tempDir = newTempFolder();
//        DbmlGeneratorMojo mojo = (DbmlGeneratorMojo) loadMojo(tempDir, "src/test/resources/projects/default", "file", "executionId");
//        //DbmlGeneratorMojo mojo = (DbmlGeneratorMojo) s.lookupMojo( "generate", testPom );
//        return mojo;
//    }

    private DbmlGeneratorMojo getGenerateMojo() throws Exception {
        File testPom = new File(getBasedir(), "src/test/resources/projects/default/pom.xml" );
        DbmlGeneratorMojo mojo = (DbmlGeneratorMojo) super.lookupMojo( "generate", testPom );
        //super.look
        return mojo;
    }
}