package p000;

import com.google.android.exoplayer2.extractor.avi.AviExtractor;

/* renamed from: be */
/* loaded from: classes.dex */
public final class C0554be implements InterfaceC1979xd {

    /* renamed from: a */
    public final int f7973a;

    /* renamed from: b */
    public final int f7974b;

    /* renamed from: c */
    public final int f7975c;

    /* renamed from: d */
    public final int f7976d;

    /* renamed from: e */
    public final int f7977e;

    public C0554be(int i, int i2, int i3, int i4, int i5) {
        this.f7973a = i;
        this.f7974b = i2;
        this.f7975c = i3;
        this.f7976d = i4;
        this.f7977e = i5;
    }

    @Override // p000.InterfaceC1979xd
    public final int getType() {
        return AviExtractor.FOURCC_strh;
    }
}
