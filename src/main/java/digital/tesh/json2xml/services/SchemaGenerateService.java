package digital.tesh.json2xml.services;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.SchemaOutputResolver;

import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedHashMap;
import java.util.Map;

public class SchemaGenerateService {

    public byte[] generateXsd(Class<?>... classes) throws JAXBException, IOException, IOException, JAXBException {
        JAXBContext ctx = JAXBContext.newInstance(classes);
        InMemorySchemaResolver resolver = new InMemorySchemaResolver();
        ctx.generateSchema(resolver);

        // Most cases produce a single schema file. If multiple, you can merge or pick the primary.
        if (resolver.files.size() == 1) {
            return resolver.files.values().iterator().next().toByteArray();
        }
        // Example: concatenate or choose by systemId; here we zip them for simplicity.
        try (ByteArrayOutputStream zip = new ByteArrayOutputStream();
             java.util.zip.ZipOutputStream zos = new java.util.zip.ZipOutputStream(zip)) {
            for (Map.Entry<String, ByteArrayOutputStream> e : resolver.files.entrySet()) {
                zos.putNextEntry(new java.util.zip.ZipEntry(e.getKey()));
                e.getValue().writeTo(zos);
                zos.closeEntry();
            }
            zos.finish();
            return zip.toByteArray();
        }
    }

    // Collects generated schema(s) into memory
    static class InMemorySchemaResolver extends SchemaOutputResolver {
        final Map<String, ByteArrayOutputStream> files = new LinkedHashMap<>();
        int counter = 0;

        @Override
        public Result createOutput(String namespaceUri, String suggestedFileName) {
            String name = (suggestedFileName != null ? suggestedFileName : ("schema" + (++counter) + ".xsd"));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            files.put(name, baos);
            StreamResult r = new StreamResult(new OutputStreamWriter(baos));
            r.setSystemId(name); // important so imports can resolve
            return r;
        }
    }

}
