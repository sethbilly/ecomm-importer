package com.ectools.challenge.ectoolsimporter.jobs;

import com.ectools.challenge.ectoolsimporter.models.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

    private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

    @Autowired
    private final JmsTemplate jmsTemplate;

    @Resource
    List<Product> productList;

    @Autowired
    public JobCompletionNotificationListener(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    /**
     * This method is called after job has completed
     * The jmsTemplate will convert and send processed data to
     * queue
     * @param jobExecution
     */
    @Override
    public void afterJob(JobExecution jobExecution) {
        if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
            log.info("Batch processing finished. Time to send data to queue");
            jmsTemplate.convertAndSend("ProductTransactionQueue", productList);
        }
    }

}
