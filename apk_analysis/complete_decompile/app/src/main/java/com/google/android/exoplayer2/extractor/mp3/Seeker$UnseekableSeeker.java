package com.google.android.exoplayer2.extractor.mp3;

import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.extractor.SeekMap;
import p000.tf2;

/* loaded from: classes.dex */
public class Seeker$UnseekableSeeker extends SeekMap.Unseekable implements tf2 {
    public Seeker$UnseekableSeeker() {
        super(C0643C.TIME_UNSET);
    }

    @Override // p000.tf2
    public long getDataEndPosition() {
        return -1L;
    }

    @Override // p000.tf2
    public long getTimeUs(long j) {
        return 0L;
    }
}
