package digital.tesh.json2xml.pojo.payloads;

import digital.tesh.json2xml.pojo.payloads.common.Payload;
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
public class SimpleSchema {

    @XmlElement
    private String field1;

    @XmlElement
    private String field2;

}
