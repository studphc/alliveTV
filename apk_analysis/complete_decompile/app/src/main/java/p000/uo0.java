package p000;

import io.reactivex.rxjava3.operators.ConditionalSubscriber;

/* loaded from: classes2.dex */
public final class uo0 extends to0 {
    private static final long serialVersionUID = 2587302975077663557L;

    /* renamed from: d */
    public final ConditionalSubscriber f27396d;

    public uo0(ConditionalSubscriber conditionalSubscriber, long j, long j2) {
        super(j, j2);
        this.f27396d = conditionalSubscriber;
    }

    @Override // p000.to0
    /* renamed from: a */
    public final void mo7501a() {
        long j = this.f26907a;
        ConditionalSubscriber conditionalSubscriber = this.f27396d;
        for (long j2 = this.f26908b; j2 != j; j2++) {
            if (this.f26909c) {
                return;
            }
            conditionalSubscriber.tryOnNext(Long.valueOf(j2));
        }
        if (this.f26909c) {
            return;
        }
        conditionalSubscriber.onComplete();
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0039, code lost:
    
        r12.f26908b = r2;
        r13 = addAndGet(-r7);
     */
    @Override // p000.to0
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void mo7502e(long j) {
        long j2 = this.f26907a;
        long j3 = this.f26908b;
        ConditionalSubscriber conditionalSubscriber = this.f27396d;
        do {
            long j4 = 0;
            while (true) {
                if (j4 != j && j3 != j2) {
                    if (this.f26909c) {
                        return;
                    }
                    if (conditionalSubscriber.tryOnNext(Long.valueOf(j3))) {
                        j4++;
                    }
                    j3++;
                } else if (j3 == j2) {
                    if (!this.f26909c) {
                        conditionalSubscriber.onComplete();
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
