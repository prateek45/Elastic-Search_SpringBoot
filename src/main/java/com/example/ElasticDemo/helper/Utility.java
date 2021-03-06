package com.example.ElasticDemo.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.nio.file.Files;

/**
 * Class is used to load setting and property mappings of Indices
 */
public class Utility {

    private static final Logger LOG = LoggerFactory.getLogger(Utility.class);

    public static String loadAsString(final String path) {
        try{
            final File resource = new ClassPathResource(path).getFile();

            return new String(Files.readAllBytes(resource.toPath()));
        } catch (final Exception e) {
            LOG.error(e.getMessage(),e);
            return null;
        }
    }
}
