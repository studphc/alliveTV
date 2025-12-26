package p000;

import com.google.common.base.Ticker;

/* loaded from: classes.dex */
public final class nt2 extends Ticker {
    @Override // com.google.common.base.Ticker
    public final long read() {
        dx0 dx0Var = t42.f26692a;
        return System.nanoTime();
    }
}
