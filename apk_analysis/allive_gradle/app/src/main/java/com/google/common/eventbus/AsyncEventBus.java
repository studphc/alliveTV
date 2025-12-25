package com.google.common.eventbus;

import java.util.concurrent.Executor;
import p000.ba0;
import p000.x40;

/* loaded from: classes.dex */
public class AsyncEventBus extends EventBus {
    public AsyncEventBus(String str, Executor executor) {
        super(str, executor, new x40(), ba0.f7941a);
    }

    public AsyncEventBus(Executor executor) {
        super("default", executor, new x40(), ba0.f7941a);
    }

    public AsyncEventBus(Executor executor, SubscriberExceptionHandler subscriberExceptionHandler) {
        super("default", executor, new x40(), subscriberExceptionHandler);
    }
}
