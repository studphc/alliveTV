package p000;

import com.google.common.collect.C0916p;
import com.google.common.collect.ImmutableMap;

/* loaded from: classes.dex */
public final class f20 extends h20 {

    /* renamed from: g */
    public final /* synthetic */ int f17085g;

    /* renamed from: h */
    public final /* synthetic */ C0916p f17086h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f20(C0916p c0916p, int i) {
        super(c0916p.f14931h.length);
        this.f17085g = i;
        switch (i) {
            case 1:
                this.f17086h = c0916p;
                super(c0916p.f14930g.length);
                return;
            default:
                this.f17086h = c0916p;
                return;
        }
    }

    @Override // com.google.common.collect.ImmutableMap
    /* renamed from: h */
    public final boolean mo3937h() {
        switch (this.f17085g) {
            case 0:
                return false;
            default:
                return false;
        }
    }

    @Override // p000.h20
    /* renamed from: k */
    public final Object mo4655k(int i) {
        switch (this.f17085g) {
            case 0:
                return new e20(this.f17086h, i, 0);
            default:
                return new e20(this.f17086h, i, 1);
        }
    }

    @Override // p000.h20
    /* renamed from: l */
    public final ImmutableMap mo4656l() {
        switch (this.f17085g) {
            case 0:
                return this.f17086h.f14927d;
            default:
                return this.f17086h.f14926c;
        }
    }
}
