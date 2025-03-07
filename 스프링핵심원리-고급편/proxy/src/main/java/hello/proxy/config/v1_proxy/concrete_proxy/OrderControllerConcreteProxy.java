package hello.proxy.config.v1_proxy.concrete_proxy;

import hello.proxy.app.v2.OrderControllerV2;
import hello.proxy.app.v2.OrderServiceV2;
import hello.proxy.trace.TraceStatus;
import hello.proxy.trace.logtrace.LogTrace;

/**
 * packageName    : com.kovo.domain.ticketlink
 * fileName       : OrderControllerConcreteProxy
 * author         : 이광호
 * date           : 2025-02-10
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-02-10        이광호       최초 생성
 */
public class OrderControllerConcreteProxy extends OrderControllerV2 {

    private final OrderControllerV2 target;
    private final LogTrace logTrace;

    public OrderControllerConcreteProxy(
        final OrderControllerV2 target,
        final LogTrace logTrace
    ) {
        super(null);
        this.target = target;
        this.logTrace = logTrace;
    }

    @Override
    public String request(final String itemId) {
        TraceStatus status = null;
        try {
            status = logTrace.begin("OrderController.request()");

            // target 호출
            String result =  target.request(itemId);
            logTrace.end(status);

            return result;
        }
         catch (Exception e) {
            logTrace.exception(status, e );
            throw e;
         }
    }

    @Override
    public String noLog() {
        return target.noLog();
    }
}
