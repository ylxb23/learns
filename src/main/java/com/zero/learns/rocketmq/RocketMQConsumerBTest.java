package com.zero.learns.rocketmq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;
import org.apache.rocketmq.remoting.protocol.LanguageCode;

import java.util.List;

public class RocketMQConsumerBTest {

    public static void main(String[] args) {
        DefaultMQPushConsumer pushConsumer = new DefaultMQPushConsumer();
        pushConsumer.setConsumerGroup("ThisIsPushConsumerBB");
        pushConsumer.setInstanceName("ThisIsInstantNameBB");
        pushConsumer.setNamesrvAddr("127.0.0.1:9876");
        pushConsumer.setLanguage(LanguageCode.JAVA);
        pushConsumer.setMessageModel(MessageModel.CLUSTERING);
        pushConsumer.registerMessageListener(new MessageListenerConcurrently() {
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                for(int i=0; i<msgs.size(); i++) {
                    MessageExt msg = msgs.get(i);
                    System.out.println("consume msg, topic: " + msg.getTopic() + ", tags: " + msg.getTags() + ", queue id: " + msg.getQueueId() +
                            ", offset: " + msg.getQueueOffset() + ", max offset: " + msg.getProperty("MAX_OFFSET") +
                            ", bron host: " + msg.getBornHostString() + ", msg id: " + msg.getMsgId() + ", properties: " + msg.getProperties() +
                            ", body: " + new String(msg.getBody()));
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });

        try {
            pushConsumer.subscribe("TEST001", "*");
            pushConsumer.start();
            System.out.println("consume group " + pushConsumer.getConsumerGroup() + " started...");
        } catch (MQClientException e) {
            throw new RuntimeException(e);
        }
    }
}
