package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.DefaultAudioTrackBufferSizeProvider;

/* renamed from: com.google.android.exoplayer2.audio.c */
/* loaded from: classes.dex */
public interface InterfaceC0649c {

    /* renamed from: a */
    public static final DefaultAudioTrackBufferSizeProvider f9815a = new DefaultAudioTrackBufferSizeProvider.Builder().build();

    int getBufferSizeInBytes(int i, int i2, int i3, int i4, int i5, double d);
}
