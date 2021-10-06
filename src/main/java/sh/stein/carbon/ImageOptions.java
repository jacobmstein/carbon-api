package sh.stein.carbon;

/**
 * Options to get an image with.
 */
public class ImageOptions {

    private String backgroundColor = "rgba(171, 184, 195, 1)";
    private boolean dropShadow = true;
    private String dropShadowBlurRadius = "68px";
    private String dropShadowOffsetY = "20px";
    private int firstLineNumber = 1;
    private String fontFamily = "Hack";
    private String fontSize = "14px";
    private Language language = Language.Auto;
    private String lineHeight = "133%";
    private boolean lineNumbers = false;
    private String paddingHorizontal = "56px";
    private String paddingVertical = "56px";
    private int scaleFactor = 2;
    private String theme = "seti";
    private boolean watermark = false;
    private boolean widthAdjustment = true;
    private boolean windowControls = true;
    private WindowTheme windowTheme = WindowTheme.RoundedEdges;

    private ImageOptions() {
    }

    /**
     * Gets the default options, as found on Carbon.
     *
     * @return the {@code ImageOptions} instance
     */
    public static ImageOptions getDefault() {
        return new ImageOptions();
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public boolean getDropShadow() {
        return dropShadow;
    }

    public String getDropShadowBlurRadius() {
        return dropShadowBlurRadius;
    }

    public String getDropShadowOffsetY() {
        return dropShadowOffsetY;
    }

    public int getFirstLineNumber() {
        return firstLineNumber;
    }

    public String getFontFamily() {
        return fontFamily;
    }

    public String getFontSize() {
        return fontSize;
    }

    public Language getLanguage() {
        return language;
    }

    public String getLineHeight() {
        return lineHeight;
    }

    public boolean getLineNumbers() {
        return lineNumbers;
    }

    public String getPaddingHorizontal() {
        return paddingHorizontal;
    }

    public String getPaddingVertical() {
        return paddingVertical;
    }

    public int getScaleFactor() {
        return scaleFactor;
    }

    public String getTheme() {
        return theme;
    }

    public boolean getWatermark() {
        return watermark;
    }

    public boolean getWidthAdjustment() {
        return widthAdjustment;
    }

    public boolean getWindowControls() {
        return windowControls;
    }

    public WindowTheme getWindowTheme() {
        return windowTheme;
    }

    /**
     * A window style supported by Carbon.
     */
    public enum WindowTheme {
        RoundedEdges,
        SharpEdges,
        Outlined
    }

    /**
     * A language supported by Carbon.
     */
    public enum Language {
        Auto, Apache, Bash, C, CPlusPlus, CSharp, Clojure, COBOL, CoffeeScript, Crystal, CSS, D,
        Dart, Diff, Django, Docker, Elixir, Elm, Erlang, Fortran, Gherkin, GraphQL, Go, Groovy,
        Handlebars, Haskell, HTMLXML, Java, JavaScript, JSON, JSX, Julia, Kotlin, LaTeX, Lisp, Lua,
        Markdown, Mathematica, MATLABOctave, MySQL, NTriples, NGINX, Nim, ObjectiveC, OCamlFSharp,
        Pascal, Perl, PHP, PlainText, PowerShell, Python, R, RISCV, Ruby, Rust, Sass, Scala,
        Smalltalk, Solidity, SPARQL, SQL, Stylus, Swift, TCL, TOML, Turtle, TypeScript, TSX, Twig,
        VBDOTNET, Verilog, VHDL, Vue, XQuery, YAML
    }

    /**
     * Used to build an instance of {@code ImageOptions} fluently.
     */
    public static class ImageOptionsBuilder {

        private final ImageOptions options = new ImageOptions();

        /**
         * Sets the background color.
         *
         * @param backgroundColor an RGBA or hex color
         * @return the {@code ImageOptionsBuilder} instance
         */
        public ImageOptionsBuilder backgroundColor(String backgroundColor) {
            options.backgroundColor = backgroundColor;
            return this;
        }

        /**
         * Sets drop shadow.
         *
         * @param dropShadow whether drop shadow is enabled
         * @return the {@code ImageOptionsBuilder} instance
         */
        public ImageOptionsBuilder dropShadow(boolean dropShadow) {
            options.dropShadow = dropShadow;
            return this;
        }

        /**
         * Sets the drop shadow blur radius.
         *
         * @param dropShadowBlurRadius a px value, e.g. {@code 20px}
         * @return the {@code ImageOptionsBuilder} instance
         */
        public ImageOptionsBuilder dropShadowBlurRadius(String dropShadowBlurRadius) {
            options.dropShadowBlurRadius = dropShadowBlurRadius;
            return this;
        }

        /**
         * Sets the drop shadow Y offset.
         *
         * @param dropShadowOffsetY a px value, e.g. {@code 20px}
         * @return the {@code ImageOptionsBuilder} instance
         */
        public ImageOptionsBuilder dropShadowOffsetY(String dropShadowOffsetY) {
            options.dropShadowOffsetY = dropShadowOffsetY;
            return this;
        }

        /**
         * Sets the first line number. Line numbers must be enabled.
         *
         * @param firstLineNumber an integer, e.g. {@code 19}
         * @return the {@code ImageOptionsBuilder} instance
         */
        public ImageOptionsBuilder firstLineNumber(int firstLineNumber) {
            options.firstLineNumber = firstLineNumber;
            return this;
        }

        /**
         * Sets the font family.
         *
         * @param fontFamily a font family, found by exporting a Carbon config
         * @return the {@code ImageOptionsBuilder} instance
         */
        public ImageOptionsBuilder fontFamily(String fontFamily) {
            options.fontFamily = fontFamily;
            return this;
        }

        /**
         * Sets the font size.
         *
         * @param fontSize a px value, e.g. {@code 20px}
         * @return the {@code ImageOptionsBuilder} instance
         */
        public ImageOptionsBuilder fontSize(String fontSize) {
            options.fontSize = fontSize;
            return this;
        }

        /**
         * Sets the language.
         *
         * @param language an {@code ImageOptions.Language} value
         * @return the {@code ImageOptionsBuilder} instance
         */
        public ImageOptionsBuilder language(Language language) {
            options.language = language;
            return this;
        }

        /**
         * Sets the line height.
         *
         * @param lineHeight a percentage, e.g. {@code 200%}
         * @return the {@code ImageOptionsBuilder} instance
         */
        public ImageOptionsBuilder lineHeight(String lineHeight) {
            options.lineHeight = lineHeight;
            return this;
        }

        /**
         * Sets line numbers.
         *
         * @param lineNumbers whether line numbers are enabled
         * @return the {@code ImageOptionsBuilder} instance
         */
        public ImageOptionsBuilder lineNumbers(boolean lineNumbers) {
            options.lineNumbers = lineNumbers;
            return this;
        }

        /**
         * Sets the horizontal padding.
         *
         * @param paddingHorizontal a px value, e.g. {@code 20px}
         * @return the {@code ImageOptionsBuilder} instance
         */
        public ImageOptionsBuilder paddingHorizontal(String paddingHorizontal) {
            options.paddingHorizontal = paddingHorizontal;
            return this;
        }

        /**
         * Sets the vertical padding.
         *
         * @param paddingVertical a px value, e.g. {@code 20px}
         * @return the {@code ImageOptionsBuilder} instance
         */
        public ImageOptionsBuilder paddingVertical(String paddingVertical) {
            options.paddingVertical = paddingVertical;
            return this;
        }

        /**
         * Sets the scale factor.
         *
         * @param scaleFactor an integer, e.g. {@code 3}
         * @return the {@code ImageOptionsBuilder} instance
         */
        public ImageOptionsBuilder scaleFactor(int scaleFactor) {
            options.scaleFactor = scaleFactor;
            return this;
        }

        /**
         * Sets the theme.
         *
         * @param theme a theme, valid themes can be found by exporting a Carbon config
         * @return the {@code ImageOptionsBuilder} instance
         */
        public ImageOptionsBuilder theme(String theme) {
            options.theme = theme;
            return this;
        }

        /**
         * Sets watermark.
         *
         * @param watermark whether watermark is enabled
         * @return the {@code ImageOptionsBuilder} instance
         */
        public ImageOptionsBuilder watermark(boolean watermark) {
            options.watermark = watermark;
            return this;
        }

        /**
         * Sets width adjustment.
         *
         * @param widthAdjustment whether width adjustment is enabled.
         * @return the {@code ImageOptionsBuilder} instance
         */
        public ImageOptionsBuilder widthAdjustment(boolean widthAdjustment) {
            options.widthAdjustment = widthAdjustment;
            return this;
        }

        /**
         * Sets window controls.
         *
         * @param windowControls whether window controls are enabled
         * @return the {@code ImageOptionsBuilder} instance
         */
        public ImageOptionsBuilder windowControls(boolean windowControls) {
            options.windowControls = windowControls;
            return this;
        }

        /**
         * Sets the window theme.
         *
         * @param windowTheme an {@code ImageOptions.WindowTheme} value
         * @return the {@code ImageOptionsBuilder} instance
         */
        public ImageOptionsBuilder windowTheme(WindowTheme windowTheme) {
            options.windowTheme = windowTheme;
            return this;
        }

        /**
         * Gets the created options.
         *
         * @return the {@code ImageOptions} instance
         */
        public ImageOptions build() {
            return options;
        }
    }
}
