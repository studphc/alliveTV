package com.google.android.exoplayer2.util;

import android.os.Looper;
import androidx.annotation.CheckResult;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import p000.C1524lu;
import p000.RunnableC1185f7;

/* loaded from: classes.dex */
public final class ListenerSet<T> {

    /* renamed from: a */
    public final Clock f12715a;

    /* renamed from: b */
    public final HandlerWrapper f12716b;

    /* renamed from: c */
    public final IterationFinishedEvent f12717c;

    /* renamed from: d */
    public final CopyOnWriteArraySet f12718d;

    /* renamed from: e */
    public final ArrayDeque f12719e;

    /* renamed from: f */
    public final ArrayDeque f12720f;

    /* renamed from: g */
    public boolean f12721g;

    /* loaded from: classes.dex */
    public interface Event<T> {
        void invoke(T t);
    }

    /* loaded from: classes.dex */
    public interface IterationFinishedEvent<T> {
        void invoke(T t, FlagSet flagSet);
    }

    public ListenerSet(Looper looper, Clock clock, IterationFinishedEvent<T> iterationFinishedEvent) {
        this(new CopyOnWriteArraySet(), looper, clock, iterationFinishedEvent);
    }

    public void add(T t) {
        if (this.f12721g) {
            return;
        }
        Assertions.checkNotNull(t);
        this.f12718d.add(new C0736a(t));
    }

    public void clear() {
        this.f12718d.clear();
    }

    @CheckResult
    public ListenerSet<T> copy(Looper looper, IterationFinishedEvent<T> iterationFinishedEvent) {
        return copy(looper, this.f12715a, iterationFinishedEvent);
    }

    public void flushEvents() {
        ArrayDeque arrayDeque = this.f12720f;
        if (arrayDeque.isEmpty()) {
            return;
        }
        HandlerWrapper handlerWrapper = this.f12716b;
        if (!handlerWrapper.hasMessages(0)) {
            handlerWrapper.sendMessageAtFrontOfQueue(handlerWrapper.obtainMessage(0));
        }
        ArrayDeque arrayDeque2 = this.f12719e;
        boolean isEmpty = arrayDeque2.isEmpty();
        arrayDeque2.addAll(arrayDeque);
        arrayDeque.clear();
        if (!isEmpty) {
            return;
        }
        while (!arrayDeque2.isEmpty()) {
            ((Runnable) arrayDeque2.peekFirst()).run();
            arrayDeque2.removeFirst();
        }
    }

    public void queueEvent(int i, Event<T> event) {
        this.f12720f.add(new RunnableC1185f7(new CopyOnWriteArraySet(this.f12718d), i, event, 3));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void release() {
        CopyOnWriteArraySet copyOnWriteArraySet = this.f12718d;
        Iterator it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            C0736a c0736a = (C0736a) it.next();
            c0736a.f12787d = true;
            if (c0736a.f12786c) {
                FlagSet build = c0736a.f12785b.build();
                this.f12717c.invoke(c0736a.f12784a, build);
            }
        }
        copyOnWriteArraySet.clear();
        this.f12721g = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void remove(T t) {
        CopyOnWriteArraySet copyOnWriteArraySet = this.f12718d;
        Iterator it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            C0736a c0736a = (C0736a) it.next();
            if (c0736a.f12784a.equals(t)) {
                c0736a.f12787d = true;
                if (c0736a.f12786c) {
                    FlagSet build = c0736a.f12785b.build();
                    this.f12717c.invoke(c0736a.f12784a, build);
                }
                copyOnWriteArraySet.remove(c0736a);
            }
        }
    }

    public void sendEvent(int i, Event<T> event) {
        queueEvent(i, event);
        flushEvents();
    }

    public int size() {
        return this.f12718d.size();
    }

    public ListenerSet(CopyOnWriteArraySet copyOnWriteArraySet, Looper looper, Clock clock, IterationFinishedEvent iterationFinishedEvent) {
        this.f12715a = clock;
        this.f12718d = copyOnWriteArraySet;
        this.f12717c = iterationFinishedEvent;
        this.f12719e = new ArrayDeque();
        this.f12720f = new ArrayDeque();
        this.f12716b = clock.createHandler(looper, new C1524lu(3, this));
    }

    @CheckResult
    public ListenerSet<T> copy(Looper looper, Clock clock, IterationFinishedEvent<T> iterationFinishedEvent) {
        return new ListenerSet<>(this.f12718d, looper, clock, iterationFinishedEvent);
    }
}
