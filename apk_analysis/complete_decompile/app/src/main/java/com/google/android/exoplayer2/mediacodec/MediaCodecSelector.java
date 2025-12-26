package com.google.android.exoplayer2.mediacodec;

import java.util.List;

/* loaded from: classes.dex */
public interface MediaCodecSelector {
    public static final MediaCodecSelector DEFAULT = new Object();

    List<MediaCodecInfo> getDecoderInfos(String str, boolean z, boolean z2);
}
