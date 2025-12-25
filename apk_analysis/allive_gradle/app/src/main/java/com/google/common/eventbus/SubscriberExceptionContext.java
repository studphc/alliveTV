package com.google.common.eventbus;

import com.google.common.base.Preconditions;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class SubscriberExceptionContext {

    /* renamed from: a */
    public final EventBus f15027a;

    /* renamed from: b */
    public final Object f15028b;

    /* renamed from: c */
    public final Object f15029c;

    /* renamed from: d */
    public final Method f15030d;

    public SubscriberExceptionContext(EventBus eventBus, Object obj, Object obj2, Method method) {
        this.f15027a = (EventBus) Preconditions.checkNotNull(eventBus);
        this.f15028b = Preconditions.checkNotNull(obj);
        this.f15029c = Preconditions.checkNotNull(obj2);
        this.f15030d = (Method) Preconditions.checkNotNull(method);
    }

    public Object getEvent() {
        return this.f15028b;
    }

    public EventBus getEventBus() {
        return this.f15027a;
    }

    public Object getSubscriber() {
        return this.f15029c;
    }

    public Method getSubscriberMethod() {
        return this.f15030d;
    }
}
