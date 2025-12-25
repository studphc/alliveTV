package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.os.HandlerThread;
import com.google.android.exoplayer2.mediacodec.MediaCodecAdapter;
import com.google.android.exoplayer2.mediacodec.SynchronousMediaCodecAdapter;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.util.Util;
import p000.C1153ec;

/* loaded from: classes.dex */
public final class DefaultMediaCodecAdapterFactory implements MediaCodecAdapter.Factory {

    /* renamed from: a */
    public int f10650a = 0;

    /* renamed from: b */
    public boolean f10651b;

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter.Factory
    public MediaCodecAdapter createAdapter(MediaCodecAdapter.Configuration configuration) {
        int i;
        int i2 = Util.SDK_INT;
        if (i2 >= 23 && ((i = this.f10650a) == 1 || (i == 0 && i2 >= 31))) {
            final int trackType = MimeTypes.getTrackType(configuration.format.sampleMimeType);
            Log.m3025i("DMCodecAdapterFactory", "Creating an asynchronous MediaCodec adapter for track type " + Util.getTrackTypeString(trackType));
            final boolean z = this.f10651b;
            return new MediaCodecAdapter.Factory(trackType, z) { // from class: com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecAdapter$Factory

                /* renamed from: a */
                public final C1153ec f10647a;

                /* renamed from: b */
                public final C1153ec f10648b;

                /* renamed from: c */
                public final boolean f10649c;

                {
                    C1153ec c1153ec = new C1153ec(trackType, 0);
                    C1153ec c1153ec2 = new C1153ec(trackType, 1);
                    this.f10647a = c1153ec;
                    this.f10648b = c1153ec2;
                    this.f10649c = z;
                }

                @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter.Factory
                public C0676a createAdapter(MediaCodecAdapter.Configuration configuration2) {
                    MediaCodec mediaCodec;
                    String str = configuration2.codecInfo.name;
                    C0676a c0676a = null;
                    try {
                        TraceUtil.beginSection("createCodec:" + str);
                        mediaCodec = MediaCodec.createByCodecName(str);
                        try {
                            C0676a c0676a2 = new C0676a(mediaCodec, (HandlerThread) this.f10647a.get(), (HandlerThread) this.f10648b.get(), this.f10649c);
                            try {
                                TraceUtil.endSection();
                                C0676a.m2667a(c0676a2, configuration2.mediaFormat, configuration2.surface, configuration2.crypto, configuration2.flags);
                                return c0676a2;
                            } catch (Exception e) {
                                e = e;
                                c0676a = c0676a2;
                                if (c0676a != null) {
                                    c0676a.release();
                                } else if (mediaCodec != null) {
                                    mediaCodec.release();
                                }
                                throw e;
                            }
                        } catch (Exception e2) {
                            e = e2;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        mediaCodec = null;
                    }
                }
            }.createAdapter(configuration);
        }
        return new SynchronousMediaCodecAdapter.Factory().createAdapter(configuration);
    }

    public void experimentalSetSynchronizeCodecInteractionsWithQueueingEnabled(boolean z) {
        this.f10651b = z;
    }

    public DefaultMediaCodecAdapterFactory forceDisableAsynchronous() {
        this.f10650a = 2;
        return this;
    }

    public DefaultMediaCodecAdapterFactory forceEnableAsynchronous() {
        this.f10650a = 1;
        return this;
    }
}
