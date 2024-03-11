package com.zero.learns.rocketmq;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.util.concurrent.CountDownLatch;

public class RocketMQMsgProducerTest {

    static CountDownLatch latch = new CountDownLatch(10);

    public static void main(String[] args) {
        DefaultMQProducer trxMQProducer = new DefaultMQProducer();
        trxMQProducer.setProducerGroup("Group001");
        trxMQProducer.setNamesrvAddr("127.0.0.1:9876");
        try {
            trxMQProducer.start();
        } catch (MQClientException e) {
            System.err.println("producer start exception, " + e);
            throw new RuntimeException(e);
        }
        for(int i=0; i<10; i++) {
            new BatchMQSender(trxMQProducer, i).start();
        }
        try {
            latch.await();
            trxMQProducer.shutdown();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    static class BatchMQSender extends Thread {
        private DefaultMQProducer mqProducer;
        private int index;

        public BatchMQSender(DefaultMQProducer producer, int idx) {
            super("MQSender[" + idx + "]");
            this.index = idx;
            this.mqProducer = producer;
        }

        @Override
        public void run() {
            try {
                for(int i=0; i<100; i++) {
                    MessageExt msg = new MessageExt();
                    msg.setTopic(Constants.TOPIC);
                    msg.setTags("ABC,BBC");
                    msg.setBody(new String("I'm from " + this.getName() + ", No." + i).getBytes());

                    try {
                        SendResult res = mqProducer.send(msg);
                        System.out.println("send result: " + res);
                    } catch (RemotingException | MQBrokerException | InterruptedException | MQClientException e) {
                        System.err.println("send normal msg exception, " + e);
                        throw new RuntimeException(e);
                    }
                }
            } finally {
                latch.countDown();
            }
        }
    }
}
