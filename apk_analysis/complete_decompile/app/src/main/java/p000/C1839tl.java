package p000;

import com.google.android.exoplayer2.text.SubtitleOutputBuffer;

/* renamed from: tl */
/* loaded from: classes.dex */
public final class C1839tl extends SubtitleOutputBuffer {

    /* renamed from: d */
    public C1294i5 f26863d;

    @Override // com.google.android.exoplayer2.decoder.DecoderOutputBuffer
    public final void release() {
        this.f26863d.releaseOutputBuffer(this);
    }
}
