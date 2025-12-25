package p000;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.avi.AviExtractor;

/* loaded from: classes.dex */
public final class zn2 implements InterfaceC1979xd {

    /* renamed from: a */
    public final Format f29448a;

    public zn2(Format format) {
        this.f29448a = format;
    }

    @Override // p000.InterfaceC1979xd
    public final int getType() {
        return AviExtractor.FOURCC_strf;
    }
}
