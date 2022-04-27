package amazon.utils;

import java.io.File;

public class Constants {
    public static final String PROJECT_DIR = System.getProperty("user.dir");

    public static final String FILE_SEPARATOR = File.separator;

    public static final String PAGE_CONTENT_DIR = PROJECT_DIR + FILE_SEPARATOR + "src" + FILE_SEPARATOR +
            "main" + FILE_SEPARATOR + "resources" + FILE_SEPARATOR + "pagecontent";

    public static final String PROPS_FILE_EXTENSION = ".properties";
}
