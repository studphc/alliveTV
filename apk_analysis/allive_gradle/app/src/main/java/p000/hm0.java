package p000;

import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class hm0 extends im0 {
    private static final long serialVersionUID = 2587302975077663557L;

    /* renamed from: d */
    public final Subscriber f18098d;

    public hm0(Subscriber subscriber, Object[] objArr) {
        super(objArr);
        this.f18098d = subscriber;
    }

    @Override // p000.im0
    /* renamed from: a */
    public final void mo4956a() {
        Object[] objArr = this.f18463a;
        int length = objArr.length;
        Subscriber subscriber = this.f18098d;
        for (int i = this.f18464b; i != length; i++) {
            if (this.f18465c) {
                return;
            }
            Object obj = objArr[i];
            if (obj == null) {
                subscriber.onError(new NullPointerException(ye0.m8292l(i, "The element at index ", " is null")));
                return;
            }
            subscriber.onNext(obj);
        }
        if (this.f18465c) {
            return;
        }
        subscriber.onComplete();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0045, code lost:
    
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
        Subscriber subscriber = this.f18098d;
        do {
            long j2 = 0;
            while (true) {
                if (j2 != j && i != length) {
                    if (this.f18465c) {
                        return;
                    }
                    Object obj = objArr[i];
                    if (obj == null) {
                        subscriber.onError(new NullPointerException(ye0.m8292l(i, "The element at index ", " is null")));
                        return;
                    } else {
                        subscriber.onNext(obj);
                        j2++;
                        i++;
                    }
                } else if (i == length) {
                    if (!this.f18465c) {
                        subscriber.onComplete();
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
