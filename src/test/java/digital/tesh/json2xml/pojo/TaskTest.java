package digital.tesh.json2xml.pojo;

import digital.tesh.json2xml.pojo.inputData.InputData;
import digital.tesh.json2xml.pojo.inputData.Payload;
import digital.tesh.json2xml.pojo.inputData.Recipient;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TaskTest {

    Task<String> task;

    @Before
    public void setup(){
        //arrange
        Recipient recipient = new Recipient();
        recipient.setCustomerId("321");

        Payload<String> payload = new Payload<>();
        payload.setDataType("application/json");
        payload.setVersion(1);
        payload.setDataSchema("string");
        payload.setData("dataItem");

        InputData<String> inputData = new InputData<>();
        inputData.setRecipient(recipient);
        inputData.setPayload(payload);

        this.task = new Task<>();
        task.setTaskName("taskName");
        task.setTaskId("123");
        task.setInputData(inputData);
    }

    @Test
    public void taskRecipientCustomerIdIsCorrect(){
        assertEquals("321", task.getInputData().getRecipient().getCustomerId());
    }

    @Test
    public void taskPayloadDataTypeIsCorrect(){
        assertEquals("application/json", task.getInputData().getPayload().getDataType());
    }

    @Test
    public void taskPayloadVersionIsCorrect(){
        assertEquals((Integer) 1, task.getInputData().getPayload().getVersion());
    }

    @Test
    public void taskPayloadDataSchemaIsCorrect(){
        assertEquals("string", task.getInputData().getPayload().getDataSchema());
    }

    @Test
    public void taskPayloadDataIsCorrect(){
        assertEquals("dataItem", task.getInputData().getPayload().getData());
    }

    @Test
    public void taskTaskNameIsCorrect(){
        assertEquals("taskName", task.getTaskName());
    }

    @Test
    public void taskTaskIDIsCorrect(){
        assertEquals("123", task.getTaskId());
    }

}
