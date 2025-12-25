package p000;

import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.subscribers.BasicFuseableSubscriber;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class ol0 extends BasicFuseableSubscriber {

    /* renamed from: a */
    public final Consumer f24807a;

    /* renamed from: b */
    public final Consumer f24808b;

    /* renamed from: c */
    public final Action f24809c;

    /* renamed from: d */
    public final Action f24810d;

    public ol0(Subscriber subscriber, Consumer consumer, Consumer consumer2, Action action, Action action2) {
        super(subscriber);
        this.f24807a = consumer;
        this.f24808b = consumer2;
        this.f24809c = action;
        this.f24810d = action2;
    }

    @Override // io.reactivex.rxjava3.internal.subscribers.BasicFuseableSubscriber, org.reactivestreams.Subscriber
    public final void onComplete() {
        if (this.done) {
            return;
        }
        try {
            this.f24809c.run();
            this.done = true;
            this.downstream.onComplete();
            try {
                this.f24810d.run();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
        } catch (Throwable th2) {
            fail(th2);
        }
    }

    @Override // io.reactivex.rxjava3.internal.subscribers.BasicFuseableSubscriber, org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        if (this.done) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.done = true;
        try {
            this.f24808b.accept(th);
            this.downstream.onError(th);
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            this.downstream.onError(new CompositeException(th, th2));
        }
        try {
            this.f24810d.run();
        } catch (Throwable th3) {
            Exceptions.throwIfFatal(th3);
            RxJavaPlugins.onError(th3);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        if (this.done) {
            return;
        }
        if (this.sourceMode != 0) {
            this.downstream.onNext(null);
            return;
        }
        try {
            this.f24807a.accept(obj);
            this.downstream.onNext(obj);
        } catch (Throwable th) {
            fail(th);
        }
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final Object poll() {
        Consumer consumer = this.f24808b;
        try {
            Object poll = this.f19889qs.poll();
            Action action = this.f24810d;
            if (poll != null) {
                try {
                    this.f24807a.accept(poll);
                    action.run();
                } catch (Throwable th) {
                    try {
                        Exceptions.throwIfFatal(th);
                        try {
                            consumer.accept(th);
                            throw ExceptionHelper.throwIfThrowable(th);
                        } catch (Throwable th2) {
                            Exceptions.throwIfFatal(th2);
                            throw new CompositeException(th, th2);
                        }
                    } catch (Throwable th3) {
                        action.run();
                        throw th3;
                    }
                }
            } else if (this.sourceMode == 1) {
                this.f24809c.run();
                action.run();
            }
            return poll;
        } catch (Throwable th4) {
            Exceptions.throwIfFatal(th4);
            try {
                consumer.accept(th4);
                throw ExceptionHelper.throwIfThrowable(th4);
            } catch (Throwable th5) {
                Exceptions.throwIfFatal(th5);
                throw new CompositeException(th4, th5);
            }
        }
    }
}
