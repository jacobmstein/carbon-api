# Carbon API

---

![](https://img.shields.io/maven-central/v/sh.stein/carbon-api)
![](https://img.shields.io/github/license/jacobmstein/carbon-api)

![](https://user-images.githubusercontent.com/10369094/31211729-591d059c-a950-11e7-86af-fa5ea3d7dbac.png)

**An unofficial Java API for [Carbon](https://carbon.now.sh). Create and share beautiful images of
your source code, *dynamically*, *with Java*!**

```java
CarbonService carbon = new PlaywrightCarbonService();

ImageOptions options = new ImageOptions.ImageOptionsBuilder()
        .language(ImageOptions.Language.CSharp)
        .fontFamily(ImageOptions.FontFamily.JetBrainsMono)
        .theme(ImageOptions.Theme.Hopscotch)
        .build();

String code = "Console.WriteLine(\"Hello, world!\");";

byte[] image = carbon.getImage(code, options);

// or, read code from a file
image = carbon.getImage(new File("README.md"), options);
```

> Want to use Carbon with Discord? Check out [Carbon Bot](https://github.com/jacobmstein/CarbonBot).

## Contents

* [How It Works](#how-it-works)
* [Using Carbon API](#using-carbon-api)
* [Documentation](#documentation)
* [Dependencies](#dependencies)
* [Style](#style)

## How It Works

1. Creates a URI from the specified arguments.
2. Uses [Microsoft Playwright](https://github.com/microsoft/playwright-java) to visit the created
   URI.
3. Screenshots the created image.

## Using Carbon API

Java versions 11 and up are supported.

Latest stable release:

![](https://img.shields.io/maven-central/v/sh.stein/carbon-api)

### Gradle

Just include the following in your `build.gradle` file:

> Replace `VERSION` with a valid Maven release.

```gradle
repositories {
    mavenCentral()
}

dependencies {
    implementation 'sh.stein:carbon-api:VERSION'
}
```

## Documentation

The latest Javadoc is available
[here](https://www.javadoc.io/doc/sh.stein/carbon-api/latest/sh/stein/carbon/package-summary.html).

## Dependencies

* Playwright
    * [GitHub](https://github.com/microsoft/playwright-java)
    * Playwright requires various dependencies to install browsers,
      see [the docs](https://playwright.dev/java/docs/cli#install-system-dependencies).

## Style

The IntelliJ code style files, which are a fork of
the [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html), are stored in
the `.idea/codeStyles` directory.
