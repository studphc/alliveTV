package com.google.android.exoplayer2.source.hls;

import androidx.annotation.Nullable;
import java.io.IOException;
import p000.ye0;

/* loaded from: classes.dex */
public final class SampleQueueMappingException extends IOException {
    public SampleQueueMappingException(@Nullable String str) {
        super(ye0.m8296p("Unable to bind a sample queue to TrackGroup with mime type ", str, "."));
    }
}
