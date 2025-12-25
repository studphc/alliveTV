package com.google.android.exoplayer2.text;

import com.google.android.exoplayer2.decoder.DecoderOutputBuffer;
import com.google.android.exoplayer2.util.Assertions;
import java.util.List;

/* loaded from: classes.dex */
public abstract class SubtitleOutputBuffer extends DecoderOutputBuffer implements Subtitle {

    /* renamed from: b */
    public Subtitle f11752b;

    /* renamed from: c */
    public long f11753c;

    @Override // com.google.android.exoplayer2.decoder.Buffer
    public void clear() {
        super.clear();
        this.f11752b = null;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public List<Cue> getCues(long j) {
        return ((Subtitle) Assertions.checkNotNull(this.f11752b)).getCues(j - this.f11753c);
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public long getEventTime(int i) {
        return ((Subtitle) Assertions.checkNotNull(this.f11752b)).getEventTime(i) + this.f11753c;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public int getEventTimeCount() {
        return ((Subtitle) Assertions.checkNotNull(this.f11752b)).getEventTimeCount();
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public int getNextEventTimeIndex(long j) {
        return ((Subtitle) Assertions.checkNotNull(this.f11752b)).getNextEventTimeIndex(j - this.f11753c);
    }

    public void setContent(long j, Subtitle subtitle, long j2) {
        this.timeUs = j;
        this.f11752b = subtitle;
        if (j2 != Long.MAX_VALUE) {
            j = j2;
        }
        this.f11753c = j;
    }
}
