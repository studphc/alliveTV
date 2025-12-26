package com.google.android.exoplayer2.util;

import android.annotation.SuppressLint;
import android.media.MediaFormat;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.video.ColorInfo;
import java.nio.ByteBuffer;
import java.util.List;
import p000.ye0;

/* loaded from: classes.dex */
public final class MediaFormatUtil {
    public static final String KEY_MAX_BIT_RATE = "max-bitrate";
    public static final String KEY_PCM_ENCODING_EXTENDED = "exo-pcm-encoding-int";
    public static final String KEY_PIXEL_WIDTH_HEIGHT_RATIO_FLOAT = "exo-pixel-width-height-ratio-float";

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0064, code lost:
    
        if (r1 != 4) goto L22;
     */
    @SuppressLint({"InlinedApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static MediaFormat createMediaFormatFromFormat(Format format) {
        int i;
        int i2;
        int i3;
        MediaFormat mediaFormat = new MediaFormat();
        maybeSetInteger(mediaFormat, "bitrate", format.bitrate);
        maybeSetInteger(mediaFormat, KEY_MAX_BIT_RATE, format.peakBitrate);
        maybeSetInteger(mediaFormat, "channel-count", format.channelCount);
        maybeSetColorInfo(mediaFormat, format.colorInfo);
        maybeSetString(mediaFormat, "mime", format.sampleMimeType);
        maybeSetString(mediaFormat, "codecs-string", format.codecs);
        maybeSetFloat(mediaFormat, "frame-rate", format.frameRate);
        maybeSetInteger(mediaFormat, "width", format.width);
        maybeSetInteger(mediaFormat, "height", format.height);
        setCsdBuffers(mediaFormat, format.initializationData);
        int i4 = format.pcmEncoding;
        int i5 = 0;
        if (i4 != -1) {
            maybeSetInteger(mediaFormat, KEY_PCM_ENCODING_EXTENDED, i4);
            if (i4 != 0) {
                if (i4 != 536870912) {
                    if (i4 != 805306368) {
                        if (i4 != 2) {
                            i3 = 3;
                            if (i4 != 3) {
                                i3 = 4;
                            }
                        } else {
                            i3 = 2;
                        }
                    } else {
                        i3 = 22;
                    }
                } else {
                    i3 = 21;
                }
            } else {
                i3 = 0;
            }
            mediaFormat.setInteger("pcm-encoding", i3);
        }
        maybeSetString(mediaFormat, "language", format.language);
        maybeSetInteger(mediaFormat, "max-input-size", format.maxInputSize);
        maybeSetInteger(mediaFormat, "sample-rate", format.sampleRate);
        maybeSetInteger(mediaFormat, "caption-service-number", format.accessibilityChannel);
        mediaFormat.setInteger("rotation-degrees", format.rotationDegrees);
        int i6 = format.selectionFlags;
        int i7 = 1;
        if ((i6 & 4) != 0) {
            i = 1;
        } else {
            i = 0;
        }
        mediaFormat.setInteger("is-autoselect", i);
        if ((i6 & 1) != 0) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        mediaFormat.setInteger("is-default", i2);
        if ((i6 & 2) != 0) {
            i5 = 1;
        }
        mediaFormat.setInteger("is-forced-subtitle", i5);
        mediaFormat.setInteger("encoder-delay", format.encoderDelay);
        mediaFormat.setInteger("encoder-padding", format.encoderPadding);
        float f = format.pixelWidthHeightRatio;
        mediaFormat.setFloat(KEY_PIXEL_WIDTH_HEIGHT_RATIO_FLOAT, f);
        int i8 = 1073741824;
        if (f < 1.0f) {
            i7 = (int) (f * 1073741824);
        } else if (f > 1.0f) {
            i7 = 1073741824;
            i8 = (int) (1073741824 / f);
        } else {
            i8 = 1;
        }
        mediaFormat.setInteger("sar-width", i7);
        mediaFormat.setInteger("sar-height", i8);
        return mediaFormat;
    }

    public static void maybeSetByteBuffer(MediaFormat mediaFormat, String str, @Nullable byte[] bArr) {
        if (bArr != null) {
            mediaFormat.setByteBuffer(str, ByteBuffer.wrap(bArr));
        }
    }

    public static void maybeSetColorInfo(MediaFormat mediaFormat, @Nullable ColorInfo colorInfo) {
        if (colorInfo != null) {
            maybeSetInteger(mediaFormat, "color-transfer", colorInfo.colorTransfer);
            maybeSetInteger(mediaFormat, "color-standard", colorInfo.colorSpace);
            maybeSetInteger(mediaFormat, "color-range", colorInfo.colorRange);
            maybeSetByteBuffer(mediaFormat, "hdr-static-info", colorInfo.hdrStaticInfo);
        }
    }

    public static void maybeSetFloat(MediaFormat mediaFormat, String str, float f) {
        if (f != -1.0f) {
            mediaFormat.setFloat(str, f);
        }
    }

    public static void maybeSetInteger(MediaFormat mediaFormat, String str, int i) {
        if (i != -1) {
            mediaFormat.setInteger(str, i);
        }
    }

    public static void maybeSetString(MediaFormat mediaFormat, String str, @Nullable String str2) {
        if (str2 != null) {
            mediaFormat.setString(str, str2);
        }
    }

    public static void setCsdBuffers(MediaFormat mediaFormat, List<byte[]> list) {
        for (int i = 0; i < list.size(); i++) {
            mediaFormat.setByteBuffer(ye0.m8291k(i, "csd-"), ByteBuffer.wrap(list.get(i)));
        }
    }
}
