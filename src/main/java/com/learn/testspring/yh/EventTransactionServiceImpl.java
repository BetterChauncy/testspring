package com.learn.testspring.yh;

import com.yonghui.common.statemachine.EventTransactionService;
import com.yonghui.common.statemachine.EventTransactionStatus;
import com.yonghui.common.util.OperationContext;
import org.springframework.stereotype.Component;

/**
 * @author: liuxf
 * DateTime: 2018/12/13/013 15:03
 */
@Component
public class EventTransactionServiceImpl implements EventTransactionService {
    @Override
    public long createTracking(OperationContext operationContext,
            EventTransactionStatus transStatus,
            String transType,
            String context,
            String comment) {
        return 0;
    }

    @Override
    public void completeTracking(OperationContext operationContext,
            long trackingId,
            EventTransactionStatus transStatus,
            String context,
            String comment) {

    }

    @Override
    public void completeTrackingWithErrMsg(OperationContext operationContext,
            long trackingId,
            EventTransactionStatus transStatus,
            String context,
            String comment,
            String errorMsg) {

    }

    @Override
    public long createTrackingStep(OperationContext operationContext,
            long trackingId,
            EventTransactionStatus stepStatus,
            String stepType,
            String stepContext,
            String stepComment) {
        return 0;
    }

    @Override
    public void completeTrackingStep(OperationContext operationContext,
            long stepId,
            EventTransactionStatus stepStatus,
            String stepContext,
            String stepComment) {

    }

    @Override
    public void completeTrackingStep(OperationContext operationContext,
            long stepId,
            EventTransactionStatus stepStatus,
            String stepContext,
            String stepComment,
            String errorMsg) {

    }
}
