package digital.tesh.json2xml.pojo.payloads.common;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

@XmlRootElement
@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class Recipient{

    @XmlElement
    private String customerId;

};