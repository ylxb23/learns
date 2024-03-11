package rocketmq;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class RocketMQTrxMsgProducerTest {
    static ExecutorService executorService = new ThreadPoolExecutor(2, 5, 100, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(200), new ThreadFactory() {
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            t.setName("TrxMsg-check-thread");
            return t;
        }
    });

    public static void main(String[] args) {
        TransactionMQProducer trxMQProducer = new TransactionMQProducer();
        trxMQProducer.setProducerGroup("TrxGroup001");
        trxMQProducer.setNamesrvAddr("127.0.0.1:9876");
        trxMQProducer.setTransactionListener(new TransactionListener() {
            public LocalTransactionState executeLocalTransaction(Message msg, Object arg) {
                System.out.println("exec local transaction, msg: " + msg + ", arg: " + arg);
                return LocalTransactionState.UNKNOW;
            }

            public LocalTransactionState checkLocalTransaction(MessageExt msg) {
                System.out.println("check local transaction, msg: " + msg);
                return LocalTransactionState.COMMIT_MESSAGE;
            }
        });
        try {
            trxMQProducer.start();
        } catch (MQClientException e) {
            System.err.println("producer start exception, " + e);
            throw new RuntimeException(e);
        }
        Map<String, String> props = new HashMap<String, String>();
        props.put("AA", "AA");

        MessageExt msg = new MessageExt();
        msg.setTopic("TEST001");
        msg.setTags("ABC,BBC");
        msg.setBody("This is test msg body".getBytes());
        msg.setTransactionId("ThisIsTrxId000001");  // 会被broker端生成的trx id覆盖

        try {
            trxMQProducer.sendMessageInTransaction(msg, props);
        } catch (MQClientException e) {
            System.err.println("send trx msg exception, " + e);
            throw new RuntimeException(e);
        }
        try {
            Thread.sleep(60 * 1000L);
            trxMQProducer.shutdown();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
