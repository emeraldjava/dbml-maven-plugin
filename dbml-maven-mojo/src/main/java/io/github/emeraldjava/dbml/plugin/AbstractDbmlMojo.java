package io.github.emeraldjava.dbml.plugin;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.File;

abstract class AbstractDbmlMojo extends AbstractMojo {

    @Parameter(defaultValue = "${project.build.directory}", required = true, readonly = true)
    File projectBuildDir;

    @Parameter(defaultValue = "${project.version}", required = true, readonly = true)
    String projectVersion;

    @Parameter(defaultValue = "${project.artifactId}", required = true, readonly = true)
    String projectArtifactId;

    @Parameter(name = "verbose", defaultValue = "false")
    private boolean verbose;
}
