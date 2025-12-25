package p000;

import com.google.android.exoplayer2.extractor.avi.AviExtractor;

/* renamed from: ae */
/* loaded from: classes.dex */
public final class C0015ae implements InterfaceC1979xd {

    /* renamed from: a */
    public final int f147a;

    /* renamed from: b */
    public final int f148b;

    /* renamed from: c */
    public final int f149c;

    public C0015ae(int i, int i2, int i3) {
        this.f147a = i;
        this.f148b = i2;
        this.f149c = i3;
    }

    @Override // p000.InterfaceC1979xd
    public final int getType() {
        return AviExtractor.FOURCC_avih;
    }
}
