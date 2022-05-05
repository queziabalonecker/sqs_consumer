package br.com.sqs_consumer.services;

import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.GetQueueUrlRequest;
import software.amazon.awssdk.services.sqs.model.GetQueueUrlResponse;

public class SQSGetQueueURL {
    public static String returnQueueUrl(SqsClient sqsClient) {

        GetQueueUrlRequest request = GetQueueUrlRequest.builder()
                .queueName(System.getenv("AWS_QUEUE_NAME"))
                .queueOwnerAWSAccountId(System.getenv("AWS_OWNER_ID")).build();

        GetQueueUrlResponse createResult = sqsClient.getQueueUrl(request);
        
        return createResult.queueUrl();
    };
}
