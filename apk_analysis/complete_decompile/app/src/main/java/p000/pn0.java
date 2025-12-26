package p000;

import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.subscribers.BasicFuseableConditionalSubscriber;
import io.reactivex.rxjava3.operators.ConditionalSubscriber;
import java.util.Objects;
import java.util.Optional;

/* loaded from: classes2.dex */
public final class pn0 extends BasicFuseableConditionalSubscriber {

    /* renamed from: a */
    public final /* synthetic */ int f25230a;

    /* renamed from: b */
    public final Function f25231b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ pn0(ConditionalSubscriber conditionalSubscriber, Function function, int i) {
        super(conditionalSubscriber);
        this.f25230a = i;
        this.f25231b = function;
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        switch (this.f25230a) {
            case 0:
                if (!this.done) {
                    if (this.sourceMode != 0) {
                        this.downstream.onNext(null);
                        return;
                    }
                    try {
                        Object apply = this.f25231b.apply(obj);
                        Objects.requireNonNull(apply, "The mapper function returned a null value.");
                        this.downstream.onNext(apply);
                        return;
                    } catch (Throwable th) {
                        fail(th);
                        return;
                    }
                }
                return;
            default:
                if (!tryOnNext(obj)) {
                    this.upstream.request(1L);
                    return;
                }
                return;
        }
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final Object poll() {
        boolean isPresent;
        Object obj;
        switch (this.f25230a) {
            case 0:
                Object poll = this.f19888qs.poll();
                if (poll != null) {
                    Object apply = this.f25231b.apply(poll);
                    Objects.requireNonNull(apply, "The mapper function returned a null value.");
                    return apply;
                }
                return null;
        }
        while (true) {
            Object poll2 = this.f19888qs.poll();
            if (poll2 == null) {
                return null;
            }
            Object apply2 = this.f25231b.apply(poll2);
            Objects.requireNonNull(apply2, "The mapper returned a null Optional");
            Optional m5540h = ki0.m5540h(apply2);
            isPresent = m5540h.isPresent();
            if (isPresent) {
                obj = m5540h.get();
                return obj;
            }
            if (this.sourceMode == 2) {
                this.f19888qs.request(1L);
            }
        }
    }

    @Override // io.reactivex.rxjava3.operators.ConditionalSubscriber
    public final boolean tryOnNext(Object obj) {
        boolean isPresent;
        Object obj2;
        switch (this.f25230a) {
            case 0:
                if (this.done) {
                    return true;
                }
                if (this.sourceMode != 0) {
                    this.downstream.tryOnNext(null);
                    return true;
                }
                try {
                    Object apply = this.f25231b.apply(obj);
                    Objects.requireNonNull(apply, "The mapper function returned a null value.");
                    return this.downstream.tryOnNext(apply);
                } catch (Throwable th) {
                    fail(th);
                    return true;
                }
            default:
                if (this.done) {
                    return true;
                }
                if (this.sourceMode != 0) {
                    this.downstream.onNext(null);
                    return true;
                }
                try {
                    Object apply2 = this.f25231b.apply(obj);
                    Objects.requireNonNull(apply2, "The mapper returned a null Optional");
                    Optional m5540h = ki0.m5540h(apply2);
                    isPresent = m5540h.isPresent();
                    if (isPresent) {
                        ConditionalSubscriber<? super R> conditionalSubscriber = this.downstream;
                        obj2 = m5540h.get();
                        return conditionalSubscriber.tryOnNext(obj2);
                    }
                    return false;
                } catch (Throwable th2) {
                    fail(th2);
                    return true;
                }
        }
    }
}
