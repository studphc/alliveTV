package p000;

import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class so0 extends qo0 {
    private static final long serialVersionUID = 2587302975077663557L;

    /* renamed from: d */
    public final Subscriber f26505d;

    public so0(Subscriber subscriber, int i, int i2) {
        super(i, i2);
        this.f26505d = subscriber;
    }

    @Override // p000.qo0
    /* renamed from: a */
    public final void mo7114a() {
        int i = this.f25703a;
        Subscriber subscriber = this.f26505d;
        for (int i2 = this.f25704b; i2 != i; i2++) {
            if (this.f25705c) {
                return;
            }
            subscriber.onNext(Integer.valueOf(i2));
        }
        if (this.f25705c) {
            return;
        }
        subscriber.onComplete();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0033, code lost:
    
        r9.f25704b = r1;
        r10 = addAndGet(-r5);
     */
    @Override // p000.qo0
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void mo7115e(long j) {
        int i = this.f25703a;
        int i2 = this.f25704b;
        Subscriber subscriber = this.f26505d;
        do {
            long j2 = 0;
            while (true) {
                if (j2 != j && i2 != i) {
                    if (this.f25705c) {
                        return;
                    }
                    subscriber.onNext(Integer.valueOf(i2));
                    j2++;
                    i2++;
                } else if (i2 == i) {
                    if (!this.f25705c) {
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
