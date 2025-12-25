package p000;

import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class vo0 extends to0 {
    private static final long serialVersionUID = 2587302975077663557L;

    /* renamed from: d */
    public final Subscriber f27896d;

    public vo0(Subscriber subscriber, long j, long j2) {
        super(j, j2);
        this.f27896d = subscriber;
    }

    @Override // p000.to0
    /* renamed from: a */
    public final void mo7501a() {
        long j = this.f26907a;
        Subscriber subscriber = this.f27896d;
        for (long j2 = this.f26908b; j2 != j; j2++) {
            if (this.f26909c) {
                return;
            }
            subscriber.onNext(Long.valueOf(j2));
        }
        if (this.f26909c) {
            return;
        }
        subscriber.onComplete();
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0036, code lost:
    
        r11.f26908b = r2;
        r12 = addAndGet(-r7);
     */
    @Override // p000.to0
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void mo7502e(long j) {
        long j2 = this.f26907a;
        long j3 = this.f26908b;
        Subscriber subscriber = this.f27896d;
        do {
            long j4 = 0;
            while (true) {
                if (j4 != j && j3 != j2) {
                    if (this.f26909c) {
                        return;
                    }
                    subscriber.onNext(Long.valueOf(j3));
                    j4++;
                    j3++;
                } else if (j3 == j2) {
                    if (!this.f26909c) {
                        subscriber.onComplete();
                        return;
                    }
                    return;
                } else {
                    j = get();
                    if (j4 == j) {
                        break;
                    }
                }
            }
        } while (j != 0);
    }
}
