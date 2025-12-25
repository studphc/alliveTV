package com.google.android.exoplayer2.text;

import com.google.android.exoplayer2.Format;
import p000.dx0;

/* loaded from: classes.dex */
public interface SubtitleDecoderFactory {
    public static final SubtitleDecoderFactory DEFAULT = new dx0(25);

    SubtitleDecoder createDecoder(Format format);

    boolean supportsFormat(Format format);
}
