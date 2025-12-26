package com.google.android.exoplayer2.video.spherical;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;
import p000.qa2;

/* loaded from: classes.dex */
public final class CameraMotionRenderer extends BaseRenderer {

    /* renamed from: n */
    public final DecoderInputBuffer f12891n;

    /* renamed from: o */
    public final ParsableByteArray f12892o;

    /* renamed from: p */
    public long f12893p;

    /* renamed from: q */
    public CameraMotionListener f12894q;

    /* renamed from: r */
    public long f12895r;

    public CameraMotionRenderer() {
        super(6);
        this.f12891n = new DecoderInputBuffer(1);
        this.f12892o = new ParsableByteArray();
    }

    @Override // com.google.android.exoplayer2.Renderer, com.google.android.exoplayer2.RendererCapabilities
    public String getName() {
        return "CameraMotionRenderer";
    }

    @Override // com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.PlayerMessage.Target
    public void handleMessage(int i, @Nullable Object obj) {
        if (i == 8) {
            this.f12894q = (CameraMotionListener) obj;
        } else {
            super.handleMessage(i, obj);
        }
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isEnded() {
        return hasReadStreamToEnd();
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        return true;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onDisabled() {
        CameraMotionListener cameraMotionListener = this.f12894q;
        if (cameraMotionListener != null) {
            cameraMotionListener.onCameraMotionReset();
        }
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onPositionReset(long j, boolean z) {
        this.f12895r = Long.MIN_VALUE;
        CameraMotionListener cameraMotionListener = this.f12894q;
        if (cameraMotionListener != null) {
            cameraMotionListener.onCameraMotionReset();
        }
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onStreamChanged(Format[] formatArr, long j, long j2) {
        this.f12893p = j2;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public void render(long j, long j2) {
        float[] fArr;
        while (!hasReadStreamToEnd() && this.f12895r < 100000 + j) {
            DecoderInputBuffer decoderInputBuffer = this.f12891n;
            decoderInputBuffer.clear();
            if (readSource(getFormatHolder(), decoderInputBuffer, 0) == -4 && !decoderInputBuffer.isEndOfStream()) {
                this.f12895r = decoderInputBuffer.timeUs;
                if (this.f12894q != null && !decoderInputBuffer.isDecodeOnly()) {
                    decoderInputBuffer.flip();
                    ByteBuffer byteBuffer = (ByteBuffer) Util.castNonNull(decoderInputBuffer.data);
                    if (byteBuffer.remaining() != 16) {
                        fArr = null;
                    } else {
                        byte[] array = byteBuffer.array();
                        int limit = byteBuffer.limit();
                        ParsableByteArray parsableByteArray = this.f12892o;
                        parsableByteArray.reset(array, limit);
                        parsableByteArray.setPosition(byteBuffer.arrayOffset() + 4);
                        float[] fArr2 = new float[3];
                        for (int i = 0; i < 3; i++) {
                            fArr2[i] = Float.intBitsToFloat(parsableByteArray.readLittleEndianInt());
                        }
                        fArr = fArr2;
                    }
                    if (fArr != null) {
                        ((CameraMotionListener) Util.castNonNull(this.f12894q)).onCameraMotion(this.f12895r - this.f12893p, fArr);
                    }
                }
            } else {
                return;
            }
        }
    }

    @Override // com.google.android.exoplayer2.RendererCapabilities
    public int supportsFormat(Format format) {
        if (MimeTypes.APPLICATION_CAMERA_MOTION.equals(format.sampleMimeType)) {
            return qa2.m7011a(4);
        }
        return qa2.m7011a(0);
    }
}
