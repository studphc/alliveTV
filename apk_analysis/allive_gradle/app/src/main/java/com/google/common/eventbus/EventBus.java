package com.google.common.eventbus;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.UncheckedExecutionException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import java.util.logging.Logger;
import p000.AbstractC1726qj;
import p000.a50;
import p000.ba0;
import p000.eq2;
import p000.z40;

/* loaded from: classes.dex */
public class EventBus {

    /* renamed from: f */
    public static final Logger f15021f = Logger.getLogger(EventBus.class.getName());

    /* renamed from: a */
    public final String f15022a;

    /* renamed from: b */
    public final Executor f15023b;

    /* renamed from: c */
    public final SubscriberExceptionHandler f15024c;

    /* renamed from: d */
    public final eq2 f15025d;

    /* renamed from: e */
    public final a50 f15026e;

    public EventBus() {
        this("default");
    }

    public final String identifier() {
        return this.f15022a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void post(Object obj) {
        eq2 eq2Var = this.f15025d;
        eq2Var.getClass();
        try {
            ImmutableSet immutableSet = (ImmutableSet) eq2.f16952d.getUnchecked(obj.getClass());
            ArrayList newArrayListWithCapacity = Lists.newArrayListWithCapacity(immutableSet.size());
            UnmodifiableIterator it = immutableSet.iterator();
            while (it.hasNext()) {
                CopyOnWriteArraySet copyOnWriteArraySet = (CopyOnWriteArraySet) eq2Var.f16953a.get((Class) it.next());
                if (copyOnWriteArraySet != null) {
                    newArrayListWithCapacity.add(copyOnWriteArraySet.iterator());
                }
            }
            Iterator concat = Iterators.concat(newArrayListWithCapacity.iterator());
            if (concat.hasNext()) {
                this.f15026e.mo20a(concat, obj);
            } else if (!(obj instanceof DeadEvent)) {
                post(new DeadEvent(this, obj));
            }
        } catch (UncheckedExecutionException e) {
            throw Throwables.propagate(e.getCause());
        }
    }

    public void register(Object obj) {
        eq2 eq2Var = this.f15025d;
        for (Map.Entry entry : eq2Var.m4749a(obj).asMap().entrySet()) {
            Class cls = (Class) entry.getKey();
            Collection collection = (Collection) entry.getValue();
            ConcurrentMap concurrentMap = eq2Var.f16953a;
            CopyOnWriteArraySet copyOnWriteArraySet = (CopyOnWriteArraySet) concurrentMap.get(cls);
            if (copyOnWriteArraySet == null) {
                CopyOnWriteArraySet copyOnWriteArraySet2 = new CopyOnWriteArraySet();
                copyOnWriteArraySet = (CopyOnWriteArraySet) MoreObjects.firstNonNull((CopyOnWriteArraySet) concurrentMap.putIfAbsent(cls, copyOnWriteArraySet2), copyOnWriteArraySet2);
            }
            copyOnWriteArraySet.addAll(collection);
        }
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).addValue(this.f15022a).toString();
    }

    public void unregister(Object obj) {
        eq2 eq2Var = this.f15025d;
        for (Map.Entry entry : eq2Var.m4749a(obj).asMap().entrySet()) {
            Class cls = (Class) entry.getKey();
            Collection<?> collection = (Collection) entry.getValue();
            CopyOnWriteArraySet copyOnWriteArraySet = (CopyOnWriteArraySet) eq2Var.f16953a.get(cls);
            if (copyOnWriteArraySet == null || !copyOnWriteArraySet.removeAll(collection)) {
                String valueOf = String.valueOf(obj);
                throw new IllegalArgumentException(AbstractC1726qj.m7059o("missing event subscriber for an annotated method. Is ", valueOf, " registered?", valueOf.length() + 65));
            }
        }
    }

    public EventBus(String str) {
        this(str, MoreExecutors.directExecutor(), new z40(), ba0.f7941a);
    }

    public EventBus(SubscriberExceptionHandler subscriberExceptionHandler) {
        this("default", MoreExecutors.directExecutor(), new z40(), subscriberExceptionHandler);
    }

    public EventBus(String str, Executor executor, a50 a50Var, SubscriberExceptionHandler subscriberExceptionHandler) {
        this.f15025d = new eq2(this);
        this.f15022a = (String) Preconditions.checkNotNull(str);
        this.f15023b = (Executor) Preconditions.checkNotNull(executor);
        this.f15026e = (a50) Preconditions.checkNotNull(a50Var);
        this.f15024c = (SubscriberExceptionHandler) Preconditions.checkNotNull(subscriberExceptionHandler);
    }
}
