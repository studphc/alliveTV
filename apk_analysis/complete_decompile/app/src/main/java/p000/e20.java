package p000;

import com.google.common.collect.C0916p;
import com.google.common.collect.ImmutableMap;

/* loaded from: classes.dex */
public final class e20 extends h20 {

    /* renamed from: g */
    public final /* synthetic */ int f16657g;

    /* renamed from: h */
    public final int f16658h;

    /* renamed from: i */
    public final /* synthetic */ C0916p f16659i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e20(C0916p c0916p, int i, int i2) {
        super(c0916p.f14931h[i]);
        this.f16657g = i2;
        switch (i2) {
            case 1:
                this.f16659i = c0916p;
                super(c0916p.f14930g[i]);
                this.f16658h = i;
                return;
            default:
                this.f16659i = c0916p;
                this.f16658h = i;
                return;
        }
    }

    @Override // com.google.common.collect.ImmutableMap
    /* renamed from: h */
    public final boolean mo3937h() {
        switch (this.f16657g) {
            case 0:
                return true;
            default:
                return true;
        }
    }

    @Override // p000.h20
    /* renamed from: k */
    public final Object mo4655k(int i) {
        switch (this.f16657g) {
            case 0:
                return this.f16659i.f14932i[i][this.f16658h];
            default:
                return this.f16659i.f14932i[this.f16658h][i];
        }
    }

    @Override // p000.h20
    /* renamed from: l */
    public final ImmutableMap mo4656l() {
        switch (this.f16657g) {
            case 0:
                return this.f16659i.f14926c;
            default:
                return this.f16659i.f14927d;
        }
    }
}
