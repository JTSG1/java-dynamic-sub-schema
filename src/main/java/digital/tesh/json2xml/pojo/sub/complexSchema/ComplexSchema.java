package digital.tesh.json2xml.pojo.sub.complexSchema;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ComplexSchema {

    @XmlElement
    private String field1;

    @XmlElement
    private String field2;

    @XmlElement
    @JsonProperty("transactions")
    private List<Transaction> transactions;

}
