package p000;

import com.bumptech.glide.util.pool.StateVerifier;

/* loaded from: classes.dex */
public final class tn2 extends StateVerifier {

    /* renamed from: a */
    public volatile boolean f26905a;

    @Override // com.bumptech.glide.util.pool.StateVerifier
    /* renamed from: a */
    public final void mo2400a(boolean z) {
        this.f26905a = z;
    }

    @Override // com.bumptech.glide.util.pool.StateVerifier
    public final void throwIfRecycled() {
        if (!this.f26905a) {
        } else {
            throw new IllegalStateException("Already released");
        }
    }
}
