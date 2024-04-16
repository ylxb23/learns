package com.zero.learns.rocketmq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;
import org.apache.rocketmq.remoting.protocol.LanguageCode;

import java.util.List;
import java.util.stream.Collectors;

public class RocketMQConsumerA3Test {

    public static void main(String[] args) {
        DefaultMQPushConsumer pushConsumer = new DefaultMQPushConsumer();
        pushConsumer.setConsumerGroup("ThisIsPushConsumerAA");
        pushConsumer.setInstanceName("ThisIsInstantNameA3");
        pushConsumer.setNamesrvAddr("127.0.0.1:9876");
        pushConsumer.setLanguage(LanguageCode.JAVA);
        pushConsumer.setMessageModel(MessageModel.CLUSTERING);
        pushConsumer.setConsumeMessageBatchMaxSize(5);
        pushConsumer.registerMessageListener(new MessageListenerConcurrently() {
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                System.out.println("current batch msg from queues: " + msgs.stream().map(MessageExt::getQueueId).collect(Collectors.toList()));
                for(int i=0; i<msgs.size(); i++) {
                    MessageExt msg = msgs.get(i);
                    String maxOffset = msg.getProperty("MAX_OFFSET");
                    System.out.println("consume msg, topic: " + msg.getTopic() + ", tags: " + msg.getTags() + ", queue id: " + msg.getQueueId() +
                            ", offset: " + msg.getQueueOffset() + ", max offset: " + maxOffset +
                            ", body: " + new String(msg.getBody()) + ", msg id: " + msg.getMsgId() + ", properties: " + msg.getProperties());
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });

        try {
            pushConsumer.subscribe(Constants.TOPIC, "*");
            pushConsumer.start();
            System.out.println("consume group " + pushConsumer.getConsumerGroup() + " started...");
        } catch (MQClientException e) {
            throw new RuntimeException(e);
        }
    }
}
