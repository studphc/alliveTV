package p000;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Notification;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.operators.observable.ObservableMaterialize;
import io.reactivex.rxjava3.internal.util.BlockingHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;

/* renamed from: zg */
/* loaded from: classes2.dex */
public final class C2056zg implements Iterator {

    /* renamed from: a */
    public final /* synthetic */ int f29360a;

    /* renamed from: b */
    public Object f29361b;

    /* renamed from: c */
    public boolean f29362c = true;

    /* renamed from: d */
    public boolean f29363d = true;

    /* renamed from: e */
    public Throwable f29364e;

    /* renamed from: f */
    public boolean f29365f;

    /* renamed from: g */
    public final Disposable f29366g;

    /* renamed from: h */
    public final Object f29367h;

    public /* synthetic */ C2056zg(Object obj, Disposable disposable, int i) {
        this.f29360a = i;
        this.f29367h = obj;
        this.f29366g = disposable;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f29360a) {
            case 0:
                Throwable th = this.f29364e;
                if (th == null) {
                    if (!this.f29362c) {
                        return false;
                    }
                    if (this.f29363d) {
                        C0018ah c0018ah = (C0018ah) this.f29366g;
                        try {
                            boolean z = this.f29365f;
                            AtomicInteger atomicInteger = c0018ah.f184c;
                            if (!z) {
                                this.f29365f = true;
                                atomicInteger.set(1);
                                Flowable.fromPublisher((Publisher) this.f29367h).materialize().subscribe((FlowableSubscriber) c0018ah);
                            }
                            atomicInteger.set(1);
                            BlockingHelper.verifyNonBlocking();
                            Notification notification = (Notification) c0018ah.f183b.take();
                            if (notification.isOnNext()) {
                                this.f29363d = false;
                                this.f29361b = notification.getValue();
                            } else {
                                this.f29362c = false;
                                if (notification.isOnComplete()) {
                                    return false;
                                }
                                Throwable error = notification.getError();
                                this.f29364e = error;
                                throw ExceptionHelper.wrapOrThrow(error);
                            }
                        } catch (InterruptedException e) {
                            c0018ah.dispose();
                            this.f29364e = e;
                            throw ExceptionHelper.wrapOrThrow(e);
                        }
                    }
                    return true;
                }
                throw ExceptionHelper.wrapOrThrow(th);
            default:
                Throwable th2 = this.f29364e;
                if (th2 == null) {
                    if (!this.f29362c) {
                        return false;
                    }
                    if (this.f29363d) {
                        boolean z2 = this.f29365f;
                        C1158eh c1158eh = (C1158eh) this.f29366g;
                        AtomicInteger atomicInteger2 = c1158eh.f16821c;
                        if (!z2) {
                            this.f29365f = true;
                            atomicInteger2.set(1);
                            new ObservableMaterialize((ObservableSource) this.f29367h).subscribe(c1158eh);
                        }
                        try {
                            atomicInteger2.set(1);
                            BlockingHelper.verifyNonBlocking();
                            Notification notification2 = (Notification) c1158eh.f16820b.take();
                            if (notification2.isOnNext()) {
                                this.f29363d = false;
                                this.f29361b = notification2.getValue();
                            } else {
                                this.f29362c = false;
                                if (notification2.isOnComplete()) {
                                    return false;
                                }
                                Throwable error2 = notification2.getError();
                                this.f29364e = error2;
                                throw ExceptionHelper.wrapOrThrow(error2);
                            }
                        } catch (InterruptedException e2) {
                            c1158eh.dispose();
                            this.f29364e = e2;
                            throw ExceptionHelper.wrapOrThrow(e2);
                        }
                    }
                    return true;
                }
                throw ExceptionHelper.wrapOrThrow(th2);
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f29360a) {
            case 0:
                Throwable th = this.f29364e;
                if (th == null) {
                    if (hasNext()) {
                        this.f29363d = true;
                        return this.f29361b;
                    }
                    throw new NoSuchElementException("No more elements");
                }
                throw ExceptionHelper.wrapOrThrow(th);
            default:
                Throwable th2 = this.f29364e;
                if (th2 == null) {
                    if (hasNext()) {
                        this.f29363d = true;
                        return this.f29361b;
                    }
                    throw new NoSuchElementException("No more elements");
                }
                throw ExceptionHelper.wrapOrThrow(th2);
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f29360a) {
            case 0:
                throw new UnsupportedOperationException("Read only iterator");
            default:
                throw new UnsupportedOperationException("Read only iterator");
        }
    }
}
