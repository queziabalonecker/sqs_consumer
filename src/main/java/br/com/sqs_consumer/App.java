package br.com.sqs_consumer;

import br.com.sqs_consumer.services.SQSMessageReader;

public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
        while(true){
            SQSMessageReader.messageReader();
        }
    };
};