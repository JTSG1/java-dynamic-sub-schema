package digital.tesh.json2xml.pojo;

import digital.tesh.json2xml.pojo.payloads.InputData;
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
public class Task<T> {

    @XmlElement
    private String taskName;

    @XmlElement
    private String taskId;

    @XmlElement
    private InputData<T> inputData;

}
