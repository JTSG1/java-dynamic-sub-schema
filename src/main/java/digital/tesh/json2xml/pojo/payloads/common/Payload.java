package digital.tesh.json2xml.pojo.payloads.common;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import digital.tesh.json2xml.pojo.payloads.ComplexSchema;
import digital.tesh.json2xml.pojo.payloads.SimpleSchema;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Payload<T> {

    @XmlElement
    private String dataSchema;

    @XmlElement
    private Integer version;

    @XmlElement
    private String dataType;

    @JsonTypeInfo(
            use = JsonTypeInfo.Id.NAME,
            include = JsonTypeInfo.As.EXTERNAL_PROPERTY,
            property = "dataSchema"
    )
    @JsonSubTypes({
            @JsonSubTypes.Type(value = SimpleSchema.class, name = "simpleSchema"),
            @JsonSubTypes.Type(value = ComplexSchema.class, name = "complexSchema"),
    })
    @XmlElement
    private T data;

}
