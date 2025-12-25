package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.decoder.CryptoInfo;
import com.google.android.exoplayer2.mediacodec.MediaCodecAdapter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.nio.ByteBuffer;
import p000.C1117dc;

/* loaded from: classes.dex */
public final class SynchronousMediaCodecAdapter implements MediaCodecAdapter {

    /* renamed from: a */
    public final MediaCodec f10726a;

    /* renamed from: b */
    public ByteBuffer[] f10727b;

    /* renamed from: c */
    public ByteBuffer[] f10728c;

    /* loaded from: classes.dex */
    public static class Factory implements MediaCodecAdapter.Factory {
        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter.Factory
        public MediaCodecAdapter createAdapter(MediaCodecAdapter.Configuration configuration) {
            MediaCodec mediaCodec = null;
            try {
                mediaCodec = createCodec(configuration);
                TraceUtil.beginSection("configureCodec");
                mediaCodec.configure(configuration.mediaFormat, configuration.surface, configuration.crypto, configuration.flags);
                TraceUtil.endSection();
                TraceUtil.beginSection("startCodec");
                mediaCodec.start();
                TraceUtil.endSection();
                return new SynchronousMediaCodecAdapter(mediaCodec);
            } catch (IOException | RuntimeException e) {
                if (mediaCodec != null) {
                    mediaCodec.release();
                }
                throw e;
            }
        }

        public MediaCodec createCodec(MediaCodecAdapter.Configuration configuration) {
            Assertions.checkNotNull(configuration.codecInfo);
            String str = configuration.codecInfo.name;
            TraceUtil.beginSection("createCodec:" + str);
            MediaCodec createByCodecName = MediaCodec.createByCodecName(str);
            TraceUtil.endSection();
            return createByCodecName;
        }
    }

    public SynchronousMediaCodecAdapter(MediaCodec mediaCodec) {
        this.f10726a = mediaCodec;
        if (Util.SDK_INT < 21) {
            this.f10727b = mediaCodec.getInputBuffers();
            this.f10728c = mediaCodec.getOutputBuffers();
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public int dequeueInputBufferIndex() {
        return this.f10726a.dequeueInputBuffer(0L);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public int dequeueOutputBufferIndex(MediaCodec.BufferInfo bufferInfo) {
        int dequeueOutputBuffer;
        do {
            MediaCodec mediaCodec = this.f10726a;
            dequeueOutputBuffer = mediaCodec.dequeueOutputBuffer(bufferInfo, 0L);
            if (dequeueOutputBuffer == -3 && Util.SDK_INT < 21) {
                this.f10728c = mediaCodec.getOutputBuffers();
            }
        } while (dequeueOutputBuffer == -3);
        return dequeueOutputBuffer;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public void flush() {
        this.f10726a.flush();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    @Nullable
    public ByteBuffer getInputBuffer(int i) {
        if (Util.SDK_INT >= 21) {
            return this.f10726a.getInputBuffer(i);
        }
        return ((ByteBuffer[]) Util.castNonNull(this.f10727b))[i];
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    @RequiresApi(26)
    public PersistableBundle getMetrics() {
        PersistableBundle metrics;
        metrics = this.f10726a.getMetrics();
        return metrics;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    @Nullable
    public ByteBuffer getOutputBuffer(int i) {
        if (Util.SDK_INT >= 21) {
            return this.f10726a.getOutputBuffer(i);
        }
        return ((ByteBuffer[]) Util.castNonNull(this.f10728c))[i];
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public MediaFormat getOutputFormat() {
        return this.f10726a.getOutputFormat();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public boolean needsReconfiguration() {
        return false;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public void queueInputBuffer(int i, int i2, int i3, long j, int i4) {
        this.f10726a.queueInputBuffer(i, i2, i3, j, i4);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public void queueSecureInputBuffer(int i, int i2, CryptoInfo cryptoInfo, long j, int i3) {
        this.f10726a.queueSecureInputBuffer(i, i2, cryptoInfo.getFrameworkCryptoInfo(), j, i3);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public void release() {
        this.f10727b = null;
        this.f10728c = null;
        this.f10726a.release();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public void releaseOutputBuffer(int i, boolean z) {
        this.f10726a.releaseOutputBuffer(i, z);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    @RequiresApi(23)
    public void setOnFrameRenderedListener(MediaCodecAdapter.OnFrameRenderedListener onFrameRenderedListener, Handler handler) {
        this.f10726a.setOnFrameRenderedListener(new C1117dc(this, onFrameRenderedListener, 1), handler);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    @RequiresApi(23)
    public void setOutputSurface(Surface surface) {
        this.f10726a.setOutputSurface(surface);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    @RequiresApi(19)
    public void setParameters(Bundle bundle) {
        this.f10726a.setParameters(bundle);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public void setVideoScalingMode(int i) {
        this.f10726a.setVideoScalingMode(i);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    @RequiresApi(21)
    public void releaseOutputBuffer(int i, long j) {
        this.f10726a.releaseOutputBuffer(i, j);
    }
}
