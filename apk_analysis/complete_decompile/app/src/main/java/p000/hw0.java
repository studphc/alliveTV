package p000;

import com.google.common.util.concurrent.AbstractFuture;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class hw0 extends AbstractFuture {

    /* renamed from: h */
    public iw0 f18204h;

    @Override // com.google.common.util.concurrent.AbstractFuture
    public final void afterDone() {
        this.f18204h = null;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        iw0 iw0Var = this.f18204h;
        if (!super.cancel(z)) {
            return false;
        }
        Objects.requireNonNull(iw0Var);
        iw0Var.f20285a = true;
        if (!z) {
            iw0Var.f20286b = false;
        }
        iw0Var.m5367a();
        return true;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public final String pendingToString() {
        iw0 iw0Var = this.f18204h;
        if (iw0Var != null) {
            int length = iw0Var.f20288d.length;
            int i = iw0Var.f20287c.get();
            StringBuilder sb = new StringBuilder(49);
            sb.append("inputCount=[");
            sb.append(length);
            sb.append("], remaining=[");
            sb.append(i);
            sb.append("]");
            return sb.toString();
        }
        return null;
    }
}
