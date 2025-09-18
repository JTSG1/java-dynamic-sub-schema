package digital.tesh.json2xml.pojo.payloads;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import digital.tesh.json2xml.pojo.payloads.common.Payload;
import digital.tesh.json2xml.pojo.payloads.common.Recipient;
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
public class InputData<T> {

    @XmlElement
    private Recipient recipient;

    @XmlElement
    private Payload<T> payload;

}
