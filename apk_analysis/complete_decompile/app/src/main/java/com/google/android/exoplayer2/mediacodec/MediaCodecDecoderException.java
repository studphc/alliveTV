package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.decoder.DecoderException;
import com.google.android.exoplayer2.util.Util;

/* loaded from: classes.dex */
public class MediaCodecDecoderException extends DecoderException {

    @Nullable
    public final MediaCodecInfo codecInfo;

    @Nullable
    public final String diagnosticInfo;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MediaCodecDecoderException(Throwable th, @Nullable MediaCodecInfo mediaCodecInfo) {
        super(r0.toString(), th);
        String str;
        StringBuilder sb = new StringBuilder("Decoder failed: ");
        String str2 = null;
        if (mediaCodecInfo == null) {
            str = null;
        } else {
            str = mediaCodecInfo.name;
        }
        sb.append(str);
        this.codecInfo = mediaCodecInfo;
        if (Util.SDK_INT >= 21 && (th instanceof MediaCodec.CodecException)) {
            str2 = ((MediaCodec.CodecException) th).getDiagnosticInfo();
        }
        this.diagnosticInfo = str2;
    }
}
