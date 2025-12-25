package p000;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.SubscriberExceptionContext;
import com.google.common.eventbus.SubscriberExceptionHandler;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public final class ba0 implements SubscriberExceptionHandler {

    /* renamed from: a */
    public static final ba0 f7941a = new Object();

    @Override // com.google.common.eventbus.SubscriberExceptionHandler
    public final void handleException(Throwable th, SubscriberExceptionContext subscriberExceptionContext) {
        String name = EventBus.class.getName();
        String identifier = subscriberExceptionContext.getEventBus().identifier();
        StringBuilder sb = new StringBuilder(AbstractC1726qj.m7052h(name.length() + 1, identifier));
        sb.append(name);
        sb.append(".");
        sb.append(identifier);
        Logger logger = Logger.getLogger(sb.toString());
        Level level = Level.SEVERE;
        if (logger.isLoggable(level)) {
            Method subscriberMethod = subscriberExceptionContext.getSubscriberMethod();
            String name2 = subscriberMethod.getName();
            String name3 = subscriberMethod.getParameterTypes()[0].getName();
            String valueOf = String.valueOf(subscriberExceptionContext.getSubscriber());
            String valueOf2 = String.valueOf(subscriberExceptionContext.getEvent());
            StringBuilder sb2 = new StringBuilder(valueOf2.length() + valueOf.length() + name3.length() + AbstractC1726qj.m7052h(80, name2));
            sb2.append("Exception thrown by subscriber method ");
            sb2.append(name2);
            sb2.append('(');
            sb2.append(name3);
            sb2.append(") on subscriber ");
            sb2.append(valueOf);
            sb2.append(" when dispatching event: ");
            sb2.append(valueOf2);
            logger.log(level, sb2.toString(), th);
        }
    }
}
