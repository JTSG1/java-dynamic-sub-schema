# java-dynamic-sub-schema

java-dynamic-sub-schema is a Java application that converts JSON input into XML by dynamically selecting and applying sub-schemas at runtime.

The project demonstrates a schema-driven approach where different XML structures are generated from the same JSON model depending on configuration and payload structure.

**Prerequisites**

- Java 11 or newer
- Maven 3.6+

**Build**

Run a Maven package build (tests optional):

```bash
mvn clean package -DskipTests
```

**Run**

Use the Maven Exec plugin or run the main class directly. Example using `mvn exec`:

```bash
mvn exec:java -Dexec.mainClass="digital.tesh.json2xml.App" -Dexec.args="input.json output.json"
```

Or run from the built classes (example):

```bash
java -cp target/classes digital.tesh.json2xml.App input.json output.json
```

**Input / Output**

- Default sample files: [input.json](input.json) and [output.json](output.json)
- XML schema used for validation: [schema.xsd](schema.xsd)

**What it does**

- Parses JSON payloads from `input.json` into Java POJOs under `src/main/java/digital/tesh/json2xml/pojo`.
- Selects and applies either a simple or complex sub-schema at runtime to generate corresponding XML output.

**Project structure**

- [pom.xml](pom.xml): Maven build configuration
- [schema.xsd](schema.xsd): XML Schema used by the application
- [src/main/java](src/main/java): Java sources
	- [src/main/java/digital/tesh/json2xml/App.java](src/main/java/digital/tesh/json2xml/App.java): Application entry point
	- [src/main/java/digital/tesh/json2xml/services/SchemaGenerateService.java](src/main/java/digital/tesh/json2xml/services/SchemaGenerateService.java): Core schema generation logic
	- [src/main/java/digital/tesh/json2xml/pojo](src/main/java/digital/tesh/json2xml/pojo): Data model classes

**Testing**

Run unit tests with Maven:

```bash
mvn test
```

**Notes & Next steps**

- Adjust input/output paths or integrate the project into a larger pipeline as needed.
- If you want, I can add a small example `dockerfile` or CI workflow to build and run tests automatically.

**License**

No license specified. Add a `LICENSE` file if you want to make the project open source.
