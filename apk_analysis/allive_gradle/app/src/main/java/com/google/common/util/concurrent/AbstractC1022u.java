package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import p000.AbstractC1726qj;
import p000.EnumC1222g7;
import p000.RunnableC0583c7;
import p000.RunnableC1185f7;

/* renamed from: com.google.common.util.concurrent.u */
/* loaded from: classes2.dex */
public abstract class AbstractC1022u extends AbstractC1024v {

    /* renamed from: o */
    public static final Logger f15429o = Logger.getLogger(AbstractC1022u.class.getName());

    /* renamed from: l */
    public ImmutableCollection f15430l;

    /* renamed from: m */
    public final boolean f15431m;

    /* renamed from: n */
    public final boolean f15432n;

    public AbstractC1022u(ImmutableCollection immutableCollection, boolean z, boolean z2) {
        int size = immutableCollection.size();
        this.f15435h = null;
        this.f15436i = size;
        this.f15430l = (ImmutableCollection) Preconditions.checkNotNull(immutableCollection);
        this.f15431m = z;
        this.f15432n = z2;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public final void afterDone() {
        boolean z;
        super.afterDone();
        ImmutableCollection immutableCollection = this.f15430l;
        mo4362o(EnumC1222g7.f17564a);
        boolean isCancelled = isCancelled();
        if (immutableCollection != null) {
            z = true;
        } else {
            z = false;
        }
        if (isCancelled & z) {
            boolean wasInterrupted = wasInterrupted();
            UnmodifiableIterator it = immutableCollection.iterator();
            while (it.hasNext()) {
                ((Future) it.next()).cancel(wasInterrupted);
            }
        }
    }

    /* renamed from: j */
    public abstract void mo4357j(int i, Object obj);

    /* renamed from: k */
    public final void m4358k(ImmutableCollection immutableCollection) {
        boolean z;
        int mo5039y = AbstractC1024v.f15433j.mo5039y(this);
        int i = 0;
        if (mo5039y >= 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "Less than 0 remaining futures");
        if (mo5039y == 0) {
            if (immutableCollection != null) {
                UnmodifiableIterator it = immutableCollection.iterator();
                while (it.hasNext()) {
                    Future future = (Future) it.next();
                    if (!future.isCancelled()) {
                        try {
                            mo4357j(i, Futures.getDone(future));
                        } catch (ExecutionException e) {
                            m4360m(e.getCause());
                        } catch (Throwable th) {
                            m4360m(th);
                        }
                    }
                    i++;
                }
            }
            this.f15435h = null;
            mo4359l();
            mo4362o(EnumC1222g7.f17565b);
        }
    }

    /* renamed from: l */
    public abstract void mo4359l();

    /* renamed from: m */
    public final void m4360m(Throwable th) {
        Preconditions.checkNotNull(th);
        String str = "Got more than one input Future failure. Logging failures after the first";
        if (this.f15431m && !setException(th)) {
            Set set = this.f15435h;
            if (set == null) {
                Set newConcurrentHashSet = Sets.newConcurrentHashSet();
                Preconditions.checkNotNull(newConcurrentHashSet);
                if (!isCancelled()) {
                    Throwable tryInternalFastPathGetFailure = tryInternalFastPathGetFailure();
                    Objects.requireNonNull(tryInternalFastPathGetFailure);
                    while (tryInternalFastPathGetFailure != null && newConcurrentHashSet.add(tryInternalFastPathGetFailure)) {
                        tryInternalFastPathGetFailure = tryInternalFastPathGetFailure.getCause();
                    }
                }
                AbstractC1024v.f15433j.mo5038v(this, newConcurrentHashSet);
                set = this.f15435h;
                Objects.requireNonNull(set);
            }
            for (Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
                if (set.add(th2)) {
                }
            }
            if (th instanceof Error) {
                str = "Input Future failed with Error";
            }
            f15429o.log(Level.SEVERE, str, th);
            return;
        }
        if (th instanceof Error) {
            if (th instanceof Error) {
                str = "Input Future failed with Error";
            }
            f15429o.log(Level.SEVERE, str, th);
        }
    }

    /* renamed from: n */
    public final void m4361n() {
        ImmutableCollection immutableCollection;
        Objects.requireNonNull(this.f15430l);
        if (this.f15430l.isEmpty()) {
            mo4359l();
            return;
        }
        if (this.f15431m) {
            UnmodifiableIterator it = this.f15430l.iterator();
            int i = 0;
            while (it.hasNext()) {
                ListenableFuture listenableFuture = (ListenableFuture) it.next();
                listenableFuture.addListener(new RunnableC1185f7(this, listenableFuture, i, 0), MoreExecutors.directExecutor());
                i++;
            }
            return;
        }
        if (this.f15432n) {
            immutableCollection = this.f15430l;
        } else {
            immutableCollection = null;
        }
        RunnableC0583c7 runnableC0583c7 = new RunnableC0583c7(2, this, immutableCollection);
        UnmodifiableIterator it2 = this.f15430l.iterator();
        while (it2.hasNext()) {
            ((ListenableFuture) it2.next()).addListener(runnableC0583c7, MoreExecutors.directExecutor());
        }
    }

    /* renamed from: o */
    public abstract void mo4362o(EnumC1222g7 enumC1222g7);

    @Override // com.google.common.util.concurrent.AbstractFuture
    public final String pendingToString() {
        ImmutableCollection immutableCollection = this.f15430l;
        if (immutableCollection != null) {
            String valueOf = String.valueOf(immutableCollection);
            return AbstractC1726qj.m7054j(valueOf.length() + 8, "futures=", valueOf);
        }
        return super.pendingToString();
    }
}
