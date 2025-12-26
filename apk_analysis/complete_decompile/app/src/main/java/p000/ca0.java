package p000;

import com.google.firebase.components.Preconditions;
import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;
import com.google.firebase.events.Publisher;
import com.google.firebase.events.Subscriber;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class ca0 implements Subscriber, Publisher {

    /* renamed from: a */
    public final HashMap f8302a = new HashMap();

    /* renamed from: b */
    public ArrayDeque f8303b = new ArrayDeque();

    /* renamed from: c */
    public final Executor f8304c;

    public ca0(Executor executor) {
        this.f8304c = executor;
    }

    /* renamed from: a */
    public final synchronized Set m2216a(Event event) {
        Set entrySet;
        try {
            Map map = (Map) this.f8302a.get(event.getType());
            if (map == null) {
                entrySet = Collections.emptySet();
            } else {
                entrySet = map.entrySet();
            }
        } catch (Throwable th) {
            throw th;
        }
        return entrySet;
    }

    @Override // com.google.firebase.events.Publisher
    public final void publish(Event event) {
        Preconditions.checkNotNull(event);
        synchronized (this) {
            try {
                ArrayDeque arrayDeque = this.f8303b;
                if (arrayDeque != null) {
                    arrayDeque.add(event);
                    return;
                }
                for (Map.Entry entry : m2216a(event)) {
                    ((Executor) entry.getValue()).execute(new RunnableC0583c7(18, entry, event));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.firebase.events.Subscriber
    public final synchronized void subscribe(Class cls, Executor executor, EventHandler eventHandler) {
        try {
            Preconditions.checkNotNull(cls);
            Preconditions.checkNotNull(eventHandler);
            Preconditions.checkNotNull(executor);
            if (!this.f8302a.containsKey(cls)) {
                this.f8302a.put(cls, new ConcurrentHashMap());
            }
            ((ConcurrentHashMap) this.f8302a.get(cls)).put(eventHandler, executor);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.firebase.events.Subscriber
    public final synchronized void unsubscribe(Class cls, EventHandler eventHandler) {
        Preconditions.checkNotNull(cls);
        Preconditions.checkNotNull(eventHandler);
        if (!this.f8302a.containsKey(cls)) {
            return;
        }
        ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) this.f8302a.get(cls);
        concurrentHashMap.remove(eventHandler);
        if (concurrentHashMap.isEmpty()) {
            this.f8302a.remove(cls);
        }
    }

    @Override // com.google.firebase.events.Subscriber
    public final void subscribe(Class cls, EventHandler eventHandler) {
        subscribe(cls, this.f8304c, eventHandler);
    }
}
