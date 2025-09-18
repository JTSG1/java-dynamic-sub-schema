package digital.tesh.json2xml.pojo.sub.complexSchema;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Transaction {

    private String description;
    private Float amount;

}
