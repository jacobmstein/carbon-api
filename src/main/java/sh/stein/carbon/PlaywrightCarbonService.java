package sh.stein.carbon;

import static sh.stein.carbon.ImageOptions.Language;
import static sh.stein.carbon.ImageOptions.WindowTheme;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.ScreenshotOptions;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.BoundingBox;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Interacts with Carbon using Microsoft's Playwright library.
 */
public class PlaywrightCarbonService implements CarbonService {

    private static final String CARBON_URI = "https://carbon.now.sh";
    private static final String IMAGE_SELECTOR = "#export-container .container-bg";

    /**
     * A map consisting of {@code ImageOptions.Language} keys and their string equivalents.
     */
    private static final Map<Language, String> LANGUAGE_STRING_MAP = new HashMap<>() {{
        put(Language.Auto, "auto");
        put(Language.Auto, "auto");
        put(Language.Apache, "text/apache");
        put(Language.Bash, "application/x-sh");
        put(Language.C, "text/x-csrc");
        put(Language.CPlusPlus, "text/x-c++src");
        put(Language.CSharp, "text/x-csharp");
        put(Language.Clojure, "clojure");
        put(Language.COBOL, "cobol");
        put(Language.CoffeeScript, "coffeescript");
        put(Language.Crystal, "crystal");
        put(Language.CSS, "css");
        put(Language.D, "d");
        put(Language.Dart, "dart");
        put(Language.Diff, "text/x-diff");
        put(Language.Django, "django");
        put(Language.Docker, "dockerfile");
        put(Language.Elixir, "elixir");
        put(Language.Elm, "elm");
        put(Language.Erlang, "erlang");
        put(Language.Fortran, "fortran");
        put(Language.Gherkin, "gherkin");
        put(Language.GraphQL, "graphql");
        put(Language.Go, "text/x-go");
        put(Language.Groovy, "groovy");
        put(Language.Handlebars, "handlebars");
        put(Language.Haskell, "haskell");
        put(Language.HTMLXML, "htmlmixed");
        put(Language.Java, "text/x-java");
        put(Language.JavaScript, "javascript");
        put(Language.JSON, "application/json");
        put(Language.JSX, "jsx");
        put(Language.Julia, "julia");
        put(Language.Kotlin, "text/x-kotlin");
        put(Language.LaTeX, "stex");
        put(Language.Lisp, "commonlisp");
        put(Language.Lua, "lua");
        put(Language.Markdown, "markdown");
        put(Language.Mathematica, "mathematica");
        put(Language.MATLABOctave, "text/x-octave");
        put(Language.MySQL, "text/x-mysql");
        put(Language.NTriples, "application/n-triples");
        put(Language.NGINX, "nginx");
        put(Language.Nim, "nim");
        put(Language.ObjectiveC, "text/x-objectivec");
        put(Language.OCamlFSharp, "mllike");
        put(Language.Pascal, "pascal");
        put(Language.Perl, "perl");
        put(Language.PHP, "text/x-php");
        put(Language.PlainText, "text");
        put(Language.PowerShell, "powershell");
        put(Language.Python, "python");
        put(Language.R, "r");
        put(Language.RISCV, "riscv");
        put(Language.Ruby, "ruby");
        put(Language.Rust, "rust");
        put(Language.Sass, "sass");
        put(Language.Scala, "text/x-scala");
        put(Language.Smalltalk, "smalltalk");
        put(Language.Solidity, "solidity");
        put(Language.SPARQL, "application/sparql-query");
        put(Language.SQL, "sql");
        put(Language.Stylus, "stylus");
        put(Language.Swift, "swift");
        put(Language.TCL, "tcl");
        put(Language.TOML, "toml");
        put(Language.Turtle, "text/turtle");
        put(Language.TypeScript, "application/typescript");
        put(Language.TSX, "text/typescript-jsx");
        put(Language.Twig, "text/x-twig");
        put(Language.VBDOTNET, "vb");
        put(Language.Verilog, "verilog");
        put(Language.VHDL, "vhdl");
        put(Language.Vue, "vue");
        put(Language.XQuery, "xquery");
        put(Language.YAML, "yaml");
    }};

    /**
     * A map consisting of {@code ImageOptions.WindowTheme} keys and their string equivalents.
     */
    private static final Map<WindowTheme, String> WINDOW_THEME_STRING_MAP = new HashMap<>() {{
        put(WindowTheme.RoundedEdges, "none"); // default
        put(WindowTheme.SharpEdges, "sharp");
        put(WindowTheme.Outlined, "bw");
    }};

    /**
     * Loads Carbon using Playwright, then screenshots the image created with the specified code and
     * default options.
     *
     * @param code code to get an image of
     * @return the image as a byte array
     */
    @Override
    public byte[] getImage(String code) {
        return getImage(code, ImageOptions.getDefault());
    }

    /**
     * Loads Carbon using Playwright, then screenshots the image created with the specified code and
     * options.
     *
     * @param code    code to get an image of
     * @param options an {@code ImageOptions} instance
     * @return the image as a byte array
     */
    @Override
    public byte[] getImage(String code, ImageOptions options) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch();
            int scaleFactor = options.getScaleFactor();
            Page page = browser.newPage(
                    new Browser.NewPageOptions().setDeviceScaleFactor(scaleFactor));
            page.navigate(getURI(code, options));

            // the element screenshot method in playwright also captures the background for whatever
            // reason, so manually capture the element
            BoundingBox box = page.querySelector(IMAGE_SELECTOR).boundingBox();

            ScreenshotOptions screenshotOptions = new ScreenshotOptions()
                    .setClip(box.x, box.y, box.width, box.height)
                    .setFullPage(true)
                    .setOmitBackground(true);

            return page.screenshot(screenshotOptions);
        }
    }

    /**
     * Loads Carbon using Playwright, then screenshots the image created with the specified file's
     * contents and default options.
     *
     * @param file a {@code File} instance to read the contents of
     * @return the image as a byte array
     * @throws IOException if the file cannot be read
     */
    @Override
    public byte[] getImage(File file) throws IOException {
        return getImage(file, ImageOptions.getDefault());
    }

    /**
     * Loads Carbon using Playwright, then screenshots the image created with the specified file's
     * contents and options.
     *
     * @param file    a {@code File} instance to read the contents of
     * @param options an {@code ImageOptions} instance
     * @return the image as a byte array
     * @throws IOException if the file cannot be read
     */
    @Override
    public byte[] getImage(File file, ImageOptions options) throws IOException {
        Path path = file.toPath();
        String contents = new String(Files.readAllBytes(path), Charset.defaultCharset());
        return getImage(contents, options);
    }

    /**
     * Gets a URI string with the appropriate query string parameters using the specified options.
     *
     * @param options an {@code ImageOptions} instance
     * @return the URI string
     */
    private String getURI(String code, ImageOptions options) {
        Map<String, String> parameters = new HashMap<>() {{
            put("code", code);
            put("bg", options.getBackgroundColor());
            put("ds", Boolean.toString(options.getDropShadow()));
            put("dsblur", options.getDropShadowBlurRadius());
            put("dsyoff", options.getDropShadowOffsetY());
            put("fm", options.getFontFamily());
            put("fs", options.getFontSize());
            put("ln", Boolean.toString(options.getLineNumbers()));
            put("fl", Integer.toString(options.getFirstLineNumber()));
            put("lh", options.getLineHeight());
            put("ph", options.getPaddingHorizontal());
            put("pv", options.getPaddingVertical());
            put("t", options.getTheme());
            put("wa", Boolean.toString(options.getWidthAdjustment()));
            put("wc", Boolean.toString(options.getWindowControls()));
            put("wm", Boolean.toString(options.getWatermark()));
            Optional<String> languageString = getLanguageString(options.getLanguage());
            languageString.ifPresent(language -> put("l", language));
            Optional<String> windowThemeString = getWindowThemeString(options.getWindowTheme());
            windowThemeString.ifPresent(windowTheme -> put("wt", windowTheme));
        }};

        return addQueryParameters(CARBON_URI, parameters);
    }

    /**
     * Encodes and appends the specified parameters to the URI as a query string.
     *
     * @param uri        a base URI string
     * @param parameters a map of query string parameters
     * @return the updated URI string
     */
    private String addQueryParameters(String uri, Map<String, String> parameters) {
        StringBuilder stringBuilder = new StringBuilder(uri);
        stringBuilder.append("?&");

        for (Map.Entry<String, String> entry : parameters.entrySet()) {
            stringBuilder.append(URLEncoder.encode(entry.getKey(), StandardCharsets.UTF_8));
            stringBuilder.append('=');
            stringBuilder.append(URLEncoder.encode(entry.getValue(), StandardCharsets.UTF_8));
            stringBuilder.append('&');
        }

        return stringBuilder.toString();
    }

    /**
     * Gets the corresponding language string for the specified language.
     *
     * @param language an {@code ImageOptions.Language} value
     * @return the language string if existent, else empty.
     */
    private Optional<String> getLanguageString(Language language) {
        return Optional.of(LANGUAGE_STRING_MAP.get(language));
    }

    /**
     * Gets the corresponding window theme string for the window theme.
     *
     * @param windowTheme an {@code ImageOptions.Language} value
     * @return the window theme string if existent, else empty.
     */
    private Optional<String> getWindowThemeString(WindowTheme windowTheme) {
        return Optional.of(WINDOW_THEME_STRING_MAP.get(windowTheme));
    }
}
