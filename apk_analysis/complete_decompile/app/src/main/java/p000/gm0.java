package p000;

import io.reactivex.rxjava3.operators.ConditionalSubscriber;

/* loaded from: classes2.dex */
public final class gm0 extends im0 {
    private static final long serialVersionUID = 2587302975077663557L;

    /* renamed from: d */
    public final ConditionalSubscriber f17759d;

    public gm0(ConditionalSubscriber conditionalSubscriber, Object[] objArr) {
        super(objArr);
        this.f17759d = conditionalSubscriber;
    }

    @Override // p000.im0
    /* renamed from: a */
    public final void mo4956a() {
        Object[] objArr = this.f18463a;
        int length = objArr.length;
        ConditionalSubscriber conditionalSubscriber = this.f17759d;
        for (int i = this.f18464b; i != length; i++) {
            if (this.f18465c) {
                return;
            }
            Object obj = objArr[i];
            if (obj == null) {
                conditionalSubscriber.onError(new NullPointerException(ye0.m8292l(i, "The element at index ", " is null")));
                return;
            }
            conditionalSubscriber.tryOnNext(obj);
        }
        if (this.f18465c) {
            return;
        }
        conditionalSubscriber.onComplete();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0048, code lost:
    
        r10.f18464b = r2;
        r11 = addAndGet(-r6);
     */
    @Override // p000.im0
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void mo4957e(long j) {
        Object[] objArr = this.f18463a;
        int length = objArr.length;
        int i = this.f18464b;
        ConditionalSubscriber conditionalSubscriber = this.f17759d;
        do {
            long j2 = 0;
            while (true) {
                if (j2 != j && i != length) {
                    if (this.f18465c) {
                        return;
                    }
                    Object obj = objArr[i];
                    if (obj == null) {
                        conditionalSubscriber.onError(new NullPointerException(ye0.m8292l(i, "The element at index ", " is null")));
                        return;
                    } else {
                        if (conditionalSubscriber.tryOnNext(obj)) {
                            j2++;
                        }
                        i++;
                    }
                } else if (i == length) {
                    if (!this.f18465c) {
                        conditionalSubscriber.onComplete();
                        return;
                    }
                    return;
                } else {
                    j = get();
                    if (j2 == j) {
                        break;
                    }
                }
            }
        } while (j != 0);
    }
}
