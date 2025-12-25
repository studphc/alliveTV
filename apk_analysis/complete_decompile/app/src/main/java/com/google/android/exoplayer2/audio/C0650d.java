package com.google.android.exoplayer2.audio;

import android.media.AudioAttributes;
import android.media.AudioTrack;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.util.Util;

/* renamed from: com.google.android.exoplayer2.audio.d */
/* loaded from: classes.dex */
public final class C0650d {

    /* renamed from: a */
    public final Format f9816a;

    /* renamed from: b */
    public final int f9817b;

    /* renamed from: c */
    public final int f9818c;

    /* renamed from: d */
    public final int f9819d;

    /* renamed from: e */
    public final int f9820e;

    /* renamed from: f */
    public final int f9821f;

    /* renamed from: g */
    public final int f9822g;

    /* renamed from: h */
    public final int f9823h;

    /* renamed from: i */
    public final AudioProcessor[] f9824i;

    public C0650d(Format format, int i, int i2, int i3, int i4, int i5, int i6, int i7, AudioProcessor[] audioProcessorArr) {
        this.f9816a = format;
        this.f9817b = i;
        this.f9818c = i2;
        this.f9819d = i3;
        this.f9820e = i4;
        this.f9821f = i5;
        this.f9822g = i6;
        this.f9823h = i7;
        this.f9824i = audioProcessorArr;
    }

    /* renamed from: c */
    public static android.media.AudioAttributes m2479c(AudioAttributes audioAttributes, boolean z) {
        if (z) {
            return new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build();
        }
        return audioAttributes.getAudioAttributesV21().audioAttributes;
    }

    /* renamed from: a */
    public final AudioTrack m2480a(boolean z, AudioAttributes audioAttributes, int i) {
        boolean z2;
        boolean z3;
        int i2 = this.f9818c;
        try {
            AudioTrack m2481b = m2481b(z, audioAttributes, i);
            int state = m2481b.getState();
            if (state == 1) {
                return m2481b;
            }
            try {
                m2481b.release();
            } catch (Exception unused) {
            }
            if (i2 == 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            throw new AudioSink.InitializationException(state, this.f9820e, this.f9821f, this.f9823h, this.f9816a, z3, null);
        } catch (IllegalArgumentException | UnsupportedOperationException e) {
            if (i2 == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            throw new AudioSink.InitializationException(0, this.f9820e, this.f9821f, this.f9823h, this.f9816a, z2, e);
        }
    }

    /* renamed from: b */
    public final AudioTrack m2481b(boolean z, AudioAttributes audioAttributes, int i) {
        AudioTrack.Builder offloadedPlayback;
        int i2 = Util.SDK_INT;
        int i3 = this.f9822g;
        int i4 = this.f9821f;
        int i5 = this.f9820e;
        if (i2 >= 29) {
            AudioTrack.Builder audioFormat = new AudioTrack.Builder().setAudioAttributes(m2479c(audioAttributes, z)).setAudioFormat(DefaultAudioSink.m2453c(i5, i4, i3));
            boolean z2 = true;
            AudioTrack.Builder sessionId = audioFormat.setTransferMode(1).setBufferSizeInBytes(this.f9823h).setSessionId(i);
            if (this.f9818c != 1) {
                z2 = false;
            }
            offloadedPlayback = sessionId.setOffloadedPlayback(z2);
            return offloadedPlayback.build();
        }
        if (i2 >= 21) {
            return new AudioTrack(m2479c(audioAttributes, z), DefaultAudioSink.m2453c(i5, i4, i3), this.f9823h, 1, i);
        }
        int streamTypeForAudioUsage = Util.getStreamTypeForAudioUsage(audioAttributes.usage);
        if (i == 0) {
            return new AudioTrack(streamTypeForAudioUsage, this.f9820e, this.f9821f, this.f9822g, this.f9823h, 1);
        }
        return new AudioTrack(streamTypeForAudioUsage, this.f9820e, this.f9821f, this.f9822g, this.f9823h, 1, i);
    }
}
