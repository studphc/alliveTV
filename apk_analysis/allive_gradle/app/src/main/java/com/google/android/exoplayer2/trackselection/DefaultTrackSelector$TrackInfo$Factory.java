package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.source.TrackGroup;
import java.util.List;
import p000.q10;

/* loaded from: classes.dex */
public interface DefaultTrackSelector$TrackInfo$Factory<T extends q10> {
    List<T> create(int i, TrackGroup trackGroup, int[] iArr);
}
