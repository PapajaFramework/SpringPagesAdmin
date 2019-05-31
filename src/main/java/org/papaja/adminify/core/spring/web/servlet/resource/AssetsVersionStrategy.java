package org.papaja.adminify.core.spring.web.servlet.resource;

import org.springframework.core.io.Resource;
import org.springframework.lang.Nullable;
import org.springframework.util.DigestUtils;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.resource.AbstractVersionStrategy;
import org.springframework.web.servlet.resource.VersionPathStrategy;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.springframework.util.StringUtils.*;

public class AssetsVersionStrategy extends AbstractVersionStrategy {

    public AssetsVersionStrategy() {
        super(new FileNameVersionPathStrategy());
    }

    @Override
    public String getResourceVersion(Resource resource) {
        String version = "unknown";

        try {
            byte[] content = FileCopyUtils.copyToByteArray(resource.getInputStream());
            version = DigestUtils.md5DigestAsHex(content);
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        System.out.println(version);

        return version;
    }

    protected static class FileNameVersionPathStrategy implements VersionPathStrategy {

        private static final Pattern   PATTERN   = Pattern.compile("-(\\S*)\\.");
        private static final Character SEPARATOR = '.';

        @Override
        @Nullable
        public String extractVersion(String path) {
            Matcher matcher = PATTERN.matcher(path);
            String  version = null;

            if (matcher.find()) {
                String match = matcher.group(1);
                version = (match.contains(SEPARATOR.toString()) ? match.substring(match.lastIndexOf(SEPARATOR) + 1) : match);
            }

            System.out.println(version);

            return version;
        }

        @Override
        public String removeVersion(String path, String version) {
            return delete(path, SEPARATOR + version);
        }

        @Override
        public String addVersion(String path, String version) {
            String filename  = stripFilenameExtension(path);
            String extension = getFilenameExtension(path);

            return (filename + SEPARATOR + version + '.' + extension);
        }
    }

}
