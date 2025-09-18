package digital.tesh.json2xml;

import com.fasterxml.jackson.databind.ObjectMapper;
import digital.tesh.json2xml.pojo.Task;
import digital.tesh.json2xml.pojo.sub.complexSchema.ComplexSchema;
import digital.tesh.json2xml.pojo.inputData.InputData;
import digital.tesh.json2xml.pojo.sub.simpleSchema.SimpleSchema;
import digital.tesh.json2xml.pojo.inputData.Payload;
import digital.tesh.json2xml.pojo.inputData.Recipient;
import digital.tesh.json2xml.services.SchemaGenerateService;
import jakarta.xml.bind.JAXBException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

/**
 * Hello world!
 *
 */

public class App 
{
    public static void main( String[] args ) throws IOException, JAXBException {

        System.out.println( "Hello World!" );

        String jsonString = Files.readString(new File("input.json").toPath());

        ObjectMapper mapper = new ObjectMapper();
        Task<?> reloadTask = mapper.readValue(jsonString, Task.class);

        SchemaGenerateService schemaGenerateService = new SchemaGenerateService();
        byte[] schema = schemaGenerateService.generateXsd(Task.class, InputData.class, ComplexSchema.class, SimpleSchema.class, Payload.class, Recipient.class);
        String s = new String(schema, StandardCharsets.UTF_8);

        Files.write(new File("schema.xsd").toPath(), schema);

        System.out.println("Hello World!");


    }
}


//        SimpleSchema simpleSchema = new SimpleSchema();
//        simpleSchema.setField1("field1-value");
//        simpleSchema.setField2("field2-value");
//
//        Recipient recipient = new Recipient("ABC123");
//
//        Payload<SimpleSchema> payload = new Payload<>();
//        payload.setDataSchema("simpleSchema");
//        payload.setDataType("application/json");
//        payload.setVersion(1);
//        payload.setData(simpleSchema);
//
//        InputData<SimpleSchema> inputData = new InputData<>();
//        inputData.setRecipient(recipient);
//        inputData.setPayload(payload);
//
//        Task<SimpleSchema> task = new Task<>();
//        task.setTaskName("myTask");
//        task.setInputData(inputData);
//
//        ObjectMapper mapper = new ObjectMapper();
//        String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(task);
//
//        File outputFile = new File("output.json");
//        FileWriter fileWriter = new FileWriter(outputFile);
//        fileWriter.write(jsonString);
//        fileWriter.close();