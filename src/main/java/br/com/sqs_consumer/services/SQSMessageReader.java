package br.com.sqs_consumer.services;

import java.util.List;

import br.com.sqs_consumer.services.CredentialsProvider;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.Message;

public class SQSMessageReader {
    public static void messageReader() {

        SqsClient sqsClient = SQSClient.returnSQSClient(CredentialsProvider.returnCredentials());

        String queueUrl = SQSGetQueueURL.returnQueueUrl(sqsClient);

        List<Message> messages = SQSReceiveMessage.receiveMessages(sqsClient, queueUrl);
        for (Message message : messages) {
            System.out.println("Mensagem: " + message.body());
        }

        SQSDeleteMessage.deleteMessages(sqsClient, queueUrl, messages);

        sqsClient.close();
    };
};