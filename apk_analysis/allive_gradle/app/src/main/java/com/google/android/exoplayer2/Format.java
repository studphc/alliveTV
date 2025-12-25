package com.google.android.exoplayer2;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.ColorInfo;
import com.google.common.base.Joiner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.UUID;
import kotlinx.coroutines.DebugKt;
import p000.AbstractC1726qj;
import p000.ee0;
import p000.ye0;

/* loaded from: classes.dex */
public final class Format implements Bundleable {
    public static final int NO_VALUE = -1;
    public static final long OFFSET_SAMPLE_RELATIVE = Long.MAX_VALUE;

    /* renamed from: a */
    public int f9353a;
    public final int accessibilityChannel;
    public final int averageBitrate;
    public final int bitrate;
    public final int channelCount;

    @Nullable
    public final String codecs;

    @Nullable
    public final ColorInfo colorInfo;

    @Nullable
    public final String containerMimeType;
    public final int cryptoType;

    @Nullable
    public final DrmInitData drmInitData;
    public final int encoderDelay;
    public final int encoderPadding;
    public final float frameRate;
    public final int height;

    /* renamed from: id */
    @Nullable
    public final String f9354id;
    public final List<byte[]> initializationData;

    @Nullable
    public final String label;

    @Nullable
    public final String language;
    public final int maxInputSize;

    @Nullable
    public final Metadata metadata;
    public final int pcmEncoding;
    public final int peakBitrate;
    public final float pixelWidthHeightRatio;

    @Nullable
    public final byte[] projectionData;
    public final int roleFlags;
    public final int rotationDegrees;

    @Nullable
    public final String sampleMimeType;
    public final int sampleRate;
    public final int selectionFlags;
    public final int stereoMode;
    public final long subsampleOffsetUs;
    public final int width;

    /* renamed from: b */
    public static final Format f9352b = new Builder().build();
    public static final Bundleable.Creator<Format> CREATOR = new ee0(4);

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: A */
        public int f9355A;

        /* renamed from: B */
        public int f9356B;

        /* renamed from: a */
        public String f9359a;

        /* renamed from: b */
        public String f9360b;

        /* renamed from: c */
        public String f9361c;

        /* renamed from: d */
        public int f9362d;

        /* renamed from: e */
        public int f9363e;

        /* renamed from: h */
        public String f9366h;

        /* renamed from: i */
        public Metadata f9367i;

        /* renamed from: j */
        public String f9368j;

        /* renamed from: k */
        public String f9369k;

        /* renamed from: m */
        public List f9371m;

        /* renamed from: n */
        public DrmInitData f9372n;

        /* renamed from: s */
        public int f9377s;

        /* renamed from: u */
        public byte[] f9379u;

        /* renamed from: w */
        public ColorInfo f9381w;

        /* renamed from: f */
        public int f9364f = -1;

        /* renamed from: g */
        public int f9365g = -1;

        /* renamed from: l */
        public int f9370l = -1;

        /* renamed from: o */
        public long f9373o = Long.MAX_VALUE;

        /* renamed from: p */
        public int f9374p = -1;

        /* renamed from: q */
        public int f9375q = -1;

        /* renamed from: r */
        public float f9376r = -1.0f;

        /* renamed from: t */
        public float f9378t = 1.0f;

        /* renamed from: v */
        public int f9380v = -1;

        /* renamed from: x */
        public int f9382x = -1;

        /* renamed from: y */
        public int f9383y = -1;

        /* renamed from: z */
        public int f9384z = -1;

        /* renamed from: C */
        public int f9357C = -1;

        /* renamed from: D */
        public int f9358D = 0;

        public Format build() {
            return new Format(this);
        }

        public Builder setAccessibilityChannel(int i) {
            this.f9357C = i;
            return this;
        }

        public Builder setAverageBitrate(int i) {
            this.f9364f = i;
            return this;
        }

        public Builder setChannelCount(int i) {
            this.f9382x = i;
            return this;
        }

        public Builder setCodecs(@Nullable String str) {
            this.f9366h = str;
            return this;
        }

        public Builder setColorInfo(@Nullable ColorInfo colorInfo) {
            this.f9381w = colorInfo;
            return this;
        }

        public Builder setContainerMimeType(@Nullable String str) {
            this.f9368j = str;
            return this;
        }

        public Builder setCryptoType(int i) {
            this.f9358D = i;
            return this;
        }

        public Builder setDrmInitData(@Nullable DrmInitData drmInitData) {
            this.f9372n = drmInitData;
            return this;
        }

        public Builder setEncoderDelay(int i) {
            this.f9355A = i;
            return this;
        }

        public Builder setEncoderPadding(int i) {
            this.f9356B = i;
            return this;
        }

        public Builder setFrameRate(float f) {
            this.f9376r = f;
            return this;
        }

        public Builder setHeight(int i) {
            this.f9375q = i;
            return this;
        }

        public Builder setId(@Nullable String str) {
            this.f9359a = str;
            return this;
        }

        public Builder setInitializationData(@Nullable List<byte[]> list) {
            this.f9371m = list;
            return this;
        }

        public Builder setLabel(@Nullable String str) {
            this.f9360b = str;
            return this;
        }

        public Builder setLanguage(@Nullable String str) {
            this.f9361c = str;
            return this;
        }

        public Builder setMaxInputSize(int i) {
            this.f9370l = i;
            return this;
        }

        public Builder setMetadata(@Nullable Metadata metadata) {
            this.f9367i = metadata;
            return this;
        }

        public Builder setPcmEncoding(int i) {
            this.f9384z = i;
            return this;
        }

        public Builder setPeakBitrate(int i) {
            this.f9365g = i;
            return this;
        }

        public Builder setPixelWidthHeightRatio(float f) {
            this.f9378t = f;
            return this;
        }

        public Builder setProjectionData(@Nullable byte[] bArr) {
            this.f9379u = bArr;
            return this;
        }

        public Builder setRoleFlags(int i) {
            this.f9363e = i;
            return this;
        }

        public Builder setRotationDegrees(int i) {
            this.f9377s = i;
            return this;
        }

        public Builder setSampleMimeType(@Nullable String str) {
            this.f9369k = str;
            return this;
        }

        public Builder setSampleRate(int i) {
            this.f9383y = i;
            return this;
        }

        public Builder setSelectionFlags(int i) {
            this.f9362d = i;
            return this;
        }

        public Builder setStereoMode(int i) {
            this.f9380v = i;
            return this;
        }

        public Builder setSubsampleOffsetUs(long j) {
            this.f9373o = j;
            return this;
        }

        public Builder setWidth(int i) {
            this.f9374p = i;
            return this;
        }

        public Builder setId(int i) {
            this.f9359a = Integer.toString(i);
            return this;
        }
    }

    public Format(Builder builder) {
        this.f9354id = builder.f9359a;
        this.label = builder.f9360b;
        this.language = Util.normalizeLanguageCode(builder.f9361c);
        this.selectionFlags = builder.f9362d;
        this.roleFlags = builder.f9363e;
        int i = builder.f9364f;
        this.averageBitrate = i;
        int i2 = builder.f9365g;
        this.peakBitrate = i2;
        this.bitrate = i2 != -1 ? i2 : i;
        this.codecs = builder.f9366h;
        this.metadata = builder.f9367i;
        this.containerMimeType = builder.f9368j;
        this.sampleMimeType = builder.f9369k;
        this.maxInputSize = builder.f9370l;
        List<byte[]> list = builder.f9371m;
        this.initializationData = list == null ? Collections.emptyList() : list;
        DrmInitData drmInitData = builder.f9372n;
        this.drmInitData = drmInitData;
        this.subsampleOffsetUs = builder.f9373o;
        this.width = builder.f9374p;
        this.height = builder.f9375q;
        this.frameRate = builder.f9376r;
        int i3 = builder.f9377s;
        this.rotationDegrees = i3 == -1 ? 0 : i3;
        float f = builder.f9378t;
        this.pixelWidthHeightRatio = f == -1.0f ? 1.0f : f;
        this.projectionData = builder.f9379u;
        this.stereoMode = builder.f9380v;
        this.colorInfo = builder.f9381w;
        this.channelCount = builder.f9382x;
        this.sampleRate = builder.f9383y;
        this.pcmEncoding = builder.f9384z;
        int i4 = builder.f9355A;
        this.encoderDelay = i4 == -1 ? 0 : i4;
        int i5 = builder.f9356B;
        this.encoderPadding = i5 != -1 ? i5 : 0;
        this.accessibilityChannel = builder.f9357C;
        int i6 = builder.f9358D;
        if (i6 == 0 && drmInitData != null) {
            this.cryptoType = 1;
        } else {
            this.cryptoType = i6;
        }
    }

    /* renamed from: a */
    public static String m2416a(int i) {
        return Integer.toString(12, 36) + "_" + Integer.toString(i, 36);
    }

    @Deprecated
    public static Format createAudioSampleFormat(@Nullable String str, @Nullable String str2, @Nullable String str3, int i, int i2, int i3, int i4, @Nullable List<byte[]> list, @Nullable DrmInitData drmInitData, int i5, @Nullable String str4) {
        return new Builder().setId(str).setLanguage(str4).setSelectionFlags(i5).setAverageBitrate(i).setPeakBitrate(i).setCodecs(str3).setSampleMimeType(str2).setMaxInputSize(i2).setInitializationData(list).setDrmInitData(drmInitData).setChannelCount(i3).setSampleRate(i4).build();
    }

    @Deprecated
    public static Format createContainerFormat(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, int i, int i2, int i3, @Nullable String str6) {
        return new Builder().setId(str).setLabel(str2).setLanguage(str6).setSelectionFlags(i2).setRoleFlags(i3).setAverageBitrate(i).setPeakBitrate(i).setCodecs(str5).setContainerMimeType(str3).setSampleMimeType(str4).build();
    }

    @Deprecated
    public static Format createSampleFormat(@Nullable String str, @Nullable String str2) {
        return new Builder().setId(str).setSampleMimeType(str2).build();
    }

    @Deprecated
    public static Format createVideoSampleFormat(@Nullable String str, @Nullable String str2, @Nullable String str3, int i, int i2, int i3, int i4, float f, @Nullable List<byte[]> list, @Nullable DrmInitData drmInitData) {
        return new Builder().setId(str).setAverageBitrate(i).setPeakBitrate(i).setCodecs(str3).setSampleMimeType(str2).setMaxInputSize(i2).setInitializationData(list).setDrmInitData(drmInitData).setWidth(i3).setHeight(i4).setFrameRate(f).build();
    }

    public static String toLogString(@Nullable Format format) {
        if (format == null) {
            return "null";
        }
        StringBuilder m7064t = AbstractC1726qj.m7064t("id=");
        m7064t.append(format.f9354id);
        m7064t.append(", mimeType=");
        m7064t.append(format.sampleMimeType);
        if (format.bitrate != -1) {
            m7064t.append(", bitrate=");
            m7064t.append(format.bitrate);
        }
        if (format.codecs != null) {
            m7064t.append(", codecs=");
            m7064t.append(format.codecs);
        }
        if (format.drmInitData != null) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            int i = 0;
            while (true) {
                DrmInitData drmInitData = format.drmInitData;
                if (i >= drmInitData.schemeDataCount) {
                    break;
                }
                UUID uuid = drmInitData.get(i).uuid;
                if (uuid.equals(C0643C.COMMON_PSSH_UUID)) {
                    linkedHashSet.add(C0643C.CENC_TYPE_cenc);
                } else if (uuid.equals(C0643C.CLEARKEY_UUID)) {
                    linkedHashSet.add("clearkey");
                } else if (uuid.equals(C0643C.PLAYREADY_UUID)) {
                    linkedHashSet.add("playready");
                } else if (uuid.equals(C0643C.WIDEVINE_UUID)) {
                    linkedHashSet.add("widevine");
                } else if (uuid.equals(C0643C.UUID_NIL)) {
                    linkedHashSet.add("universal");
                } else {
                    linkedHashSet.add("unknown (" + uuid + ")");
                }
                i++;
            }
            m7064t.append(", drm=[");
            Joiner.m3765on(',').appendTo(m7064t, (Iterable<? extends Object>) linkedHashSet);
            m7064t.append(']');
        }
        if (format.width != -1 && format.height != -1) {
            m7064t.append(", res=");
            m7064t.append(format.width);
            m7064t.append("x");
            m7064t.append(format.height);
        }
        if (format.frameRate != -1.0f) {
            m7064t.append(", fps=");
            m7064t.append(format.frameRate);
        }
        if (format.channelCount != -1) {
            m7064t.append(", channels=");
            m7064t.append(format.channelCount);
        }
        if (format.sampleRate != -1) {
            m7064t.append(", sample_rate=");
            m7064t.append(format.sampleRate);
        }
        if (format.language != null) {
            m7064t.append(", language=");
            m7064t.append(format.language);
        }
        if (format.label != null) {
            m7064t.append(", label=");
            m7064t.append(format.label);
        }
        if (format.selectionFlags != 0) {
            ArrayList arrayList = new ArrayList();
            if ((format.selectionFlags & 4) != 0) {
                arrayList.add(DebugKt.DEBUG_PROPERTY_VALUE_AUTO);
            }
            if ((format.selectionFlags & 1) != 0) {
                arrayList.add("default");
            }
            if ((format.selectionFlags & 2) != 0) {
                arrayList.add("forced");
            }
            m7064t.append(", selectionFlags=[");
            Joiner.m3765on(',').appendTo(m7064t, (Iterable<? extends Object>) arrayList);
            m7064t.append("]");
        }
        if (format.roleFlags != 0) {
            ArrayList arrayList2 = new ArrayList();
            if ((format.roleFlags & 1) != 0) {
                arrayList2.add("main");
            }
            if ((format.roleFlags & 2) != 0) {
                arrayList2.add("alt");
            }
            if ((format.roleFlags & 4) != 0) {
                arrayList2.add("supplementary");
            }
            if ((format.roleFlags & 8) != 0) {
                arrayList2.add("commentary");
            }
            if ((format.roleFlags & 16) != 0) {
                arrayList2.add("dub");
            }
            if ((format.roleFlags & 32) != 0) {
                arrayList2.add("emergency");
            }
            if ((format.roleFlags & 64) != 0) {
                arrayList2.add("caption");
            }
            if ((format.roleFlags & 128) != 0) {
                arrayList2.add("subtitle");
            }
            if ((format.roleFlags & 256) != 0) {
                arrayList2.add("sign");
            }
            if ((format.roleFlags & 512) != 0) {
                arrayList2.add("describes-video");
            }
            if ((format.roleFlags & 1024) != 0) {
                arrayList2.add("describes-music");
            }
            if ((format.roleFlags & 2048) != 0) {
                arrayList2.add("enhanced-intelligibility");
            }
            if ((format.roleFlags & 4096) != 0) {
                arrayList2.add("transcribes-dialog");
            }
            if ((format.roleFlags & 8192) != 0) {
                arrayList2.add("easy-read");
            }
            if ((format.roleFlags & 16384) != 0) {
                arrayList2.add("trick-play");
            }
            m7064t.append(", roleFlags=[");
            Joiner.m3765on(',').appendTo(m7064t, (Iterable<? extends Object>) arrayList2);
            m7064t.append("]");
        }
        return m7064t.toString();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, com.google.android.exoplayer2.Format$Builder] */
    public Builder buildUpon() {
        ?? obj = new Object();
        obj.f9359a = this.f9354id;
        obj.f9360b = this.label;
        obj.f9361c = this.language;
        obj.f9362d = this.selectionFlags;
        obj.f9363e = this.roleFlags;
        obj.f9364f = this.averageBitrate;
        obj.f9365g = this.peakBitrate;
        obj.f9366h = this.codecs;
        obj.f9367i = this.metadata;
        obj.f9368j = this.containerMimeType;
        obj.f9369k = this.sampleMimeType;
        obj.f9370l = this.maxInputSize;
        obj.f9371m = this.initializationData;
        obj.f9372n = this.drmInitData;
        obj.f9373o = this.subsampleOffsetUs;
        obj.f9374p = this.width;
        obj.f9375q = this.height;
        obj.f9376r = this.frameRate;
        obj.f9377s = this.rotationDegrees;
        obj.f9378t = this.pixelWidthHeightRatio;
        obj.f9379u = this.projectionData;
        obj.f9380v = this.stereoMode;
        obj.f9381w = this.colorInfo;
        obj.f9382x = this.channelCount;
        obj.f9383y = this.sampleRate;
        obj.f9384z = this.pcmEncoding;
        obj.f9355A = this.encoderDelay;
        obj.f9356B = this.encoderPadding;
        obj.f9357C = this.accessibilityChannel;
        obj.f9358D = this.cryptoType;
        return obj;
    }

    @Deprecated
    public Format copyWithBitrate(int i) {
        return buildUpon().setAverageBitrate(i).setPeakBitrate(i).build();
    }

    public Format copyWithCryptoType(int i) {
        return buildUpon().setCryptoType(i).build();
    }

    @Deprecated
    public Format copyWithDrmInitData(@Nullable DrmInitData drmInitData) {
        return buildUpon().setDrmInitData(drmInitData).build();
    }

    @Deprecated
    public Format copyWithFrameRate(float f) {
        return buildUpon().setFrameRate(f).build();
    }

    @Deprecated
    public Format copyWithGaplessInfo(int i, int i2) {
        return buildUpon().setEncoderDelay(i).setEncoderPadding(i2).build();
    }

    @Deprecated
    public Format copyWithLabel(@Nullable String str) {
        return buildUpon().setLabel(str).build();
    }

    @Deprecated
    public Format copyWithManifestFormatInfo(Format format) {
        return withManifestFormatInfo(format);
    }

    @Deprecated
    public Format copyWithMaxInputSize(int i) {
        return buildUpon().setMaxInputSize(i).build();
    }

    @Deprecated
    public Format copyWithMetadata(@Nullable Metadata metadata) {
        return buildUpon().setMetadata(metadata).build();
    }

    @Deprecated
    public Format copyWithSubsampleOffsetUs(long j) {
        return buildUpon().setSubsampleOffsetUs(j).build();
    }

    @Deprecated
    public Format copyWithVideoSize(int i, int i2) {
        return buildUpon().setWidth(i).setHeight(i2).build();
    }

    public boolean equals(@Nullable Object obj) {
        int i;
        if (this == obj) {
            return true;
        }
        if (obj == null || Format.class != obj.getClass()) {
            return false;
        }
        Format format = (Format) obj;
        int i2 = this.f9353a;
        if (i2 != 0 && (i = format.f9353a) != 0 && i2 != i) {
            return false;
        }
        if (this.selectionFlags == format.selectionFlags && this.roleFlags == format.roleFlags && this.averageBitrate == format.averageBitrate && this.peakBitrate == format.peakBitrate && this.maxInputSize == format.maxInputSize && this.subsampleOffsetUs == format.subsampleOffsetUs && this.width == format.width && this.height == format.height && this.rotationDegrees == format.rotationDegrees && this.stereoMode == format.stereoMode && this.channelCount == format.channelCount && this.sampleRate == format.sampleRate && this.pcmEncoding == format.pcmEncoding && this.encoderDelay == format.encoderDelay && this.encoderPadding == format.encoderPadding && this.accessibilityChannel == format.accessibilityChannel && this.cryptoType == format.cryptoType && Float.compare(this.frameRate, format.frameRate) == 0 && Float.compare(this.pixelWidthHeightRatio, format.pixelWidthHeightRatio) == 0 && Util.areEqual(this.f9354id, format.f9354id) && Util.areEqual(this.label, format.label) && Util.areEqual(this.codecs, format.codecs) && Util.areEqual(this.containerMimeType, format.containerMimeType) && Util.areEqual(this.sampleMimeType, format.sampleMimeType) && Util.areEqual(this.language, format.language) && Arrays.equals(this.projectionData, format.projectionData) && Util.areEqual(this.metadata, format.metadata) && Util.areEqual(this.colorInfo, format.colorInfo) && Util.areEqual(this.drmInitData, format.drmInitData) && initializationDataEquals(format)) {
            return true;
        }
        return false;
    }

    public int getPixelCount() {
        int i;
        int i2 = this.width;
        if (i2 == -1 || (i = this.height) == -1) {
            return -1;
        }
        return i2 * i;
    }

    public int hashCode() {
        int hashCode;
        int i;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        if (this.f9353a == 0) {
            String str = this.f9354id;
            int i2 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i3 = (527 + hashCode) * 31;
            String str2 = this.label;
            if (str2 != null) {
                i = str2.hashCode();
            } else {
                i = 0;
            }
            int i4 = (i3 + i) * 31;
            String str3 = this.language;
            if (str3 == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = str3.hashCode();
            }
            int i5 = (((((((((i4 + hashCode2) * 31) + this.selectionFlags) * 31) + this.roleFlags) * 31) + this.averageBitrate) * 31) + this.peakBitrate) * 31;
            String str4 = this.codecs;
            if (str4 == null) {
                hashCode3 = 0;
            } else {
                hashCode3 = str4.hashCode();
            }
            int i6 = (i5 + hashCode3) * 31;
            Metadata metadata = this.metadata;
            if (metadata == null) {
                hashCode4 = 0;
            } else {
                hashCode4 = metadata.hashCode();
            }
            int i7 = (i6 + hashCode4) * 31;
            String str5 = this.containerMimeType;
            if (str5 == null) {
                hashCode5 = 0;
            } else {
                hashCode5 = str5.hashCode();
            }
            int i8 = (i7 + hashCode5) * 31;
            String str6 = this.sampleMimeType;
            if (str6 != null) {
                i2 = str6.hashCode();
            }
            this.f9353a = ((((((((((((((((Float.floatToIntBits(this.pixelWidthHeightRatio) + ((((Float.floatToIntBits(this.frameRate) + ((((((((((i8 + i2) * 31) + this.maxInputSize) * 31) + ((int) this.subsampleOffsetUs)) * 31) + this.width) * 31) + this.height) * 31)) * 31) + this.rotationDegrees) * 31)) * 31) + this.stereoMode) * 31) + this.channelCount) * 31) + this.sampleRate) * 31) + this.pcmEncoding) * 31) + this.encoderDelay) * 31) + this.encoderPadding) * 31) + this.accessibilityChannel) * 31) + this.cryptoType;
        }
        return this.f9353a;
    }

    public boolean initializationDataEquals(Format format) {
        if (this.initializationData.size() != format.initializationData.size()) {
            return false;
        }
        for (int i = 0; i < this.initializationData.size(); i++) {
            if (!Arrays.equals(this.initializationData.get(i), format.initializationData.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.Bundleable
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString(Integer.toString(0, 36), this.f9354id);
        bundle.putString(Integer.toString(1, 36), this.label);
        bundle.putString(Integer.toString(2, 36), this.language);
        bundle.putInt(Integer.toString(3, 36), this.selectionFlags);
        bundle.putInt(Integer.toString(4, 36), this.roleFlags);
        bundle.putInt(Integer.toString(5, 36), this.averageBitrate);
        bundle.putInt(Integer.toString(6, 36), this.peakBitrate);
        bundle.putString(Integer.toString(7, 36), this.codecs);
        bundle.putParcelable(Integer.toString(8, 36), this.metadata);
        bundle.putString(Integer.toString(9, 36), this.containerMimeType);
        bundle.putString(Integer.toString(10, 36), this.sampleMimeType);
        bundle.putInt(Integer.toString(11, 36), this.maxInputSize);
        for (int i = 0; i < this.initializationData.size(); i++) {
            bundle.putByteArray(m2416a(i), this.initializationData.get(i));
        }
        bundle.putParcelable(Integer.toString(13, 36), this.drmInitData);
        bundle.putLong(Integer.toString(14, 36), this.subsampleOffsetUs);
        bundle.putInt(Integer.toString(15, 36), this.width);
        bundle.putInt(Integer.toString(16, 36), this.height);
        bundle.putFloat(Integer.toString(17, 36), this.frameRate);
        bundle.putInt(Integer.toString(18, 36), this.rotationDegrees);
        bundle.putFloat(Integer.toString(19, 36), this.pixelWidthHeightRatio);
        bundle.putByteArray(Integer.toString(20, 36), this.projectionData);
        bundle.putInt(Integer.toString(21, 36), this.stereoMode);
        if (this.colorInfo != null) {
            bundle.putBundle(Integer.toString(22, 36), this.colorInfo.toBundle());
        }
        bundle.putInt(Integer.toString(23, 36), this.channelCount);
        bundle.putInt(Integer.toString(24, 36), this.sampleRate);
        bundle.putInt(Integer.toString(25, 36), this.pcmEncoding);
        bundle.putInt(Integer.toString(26, 36), this.encoderDelay);
        bundle.putInt(Integer.toString(27, 36), this.encoderPadding);
        bundle.putInt(Integer.toString(28, 36), this.accessibilityChannel);
        bundle.putInt(Integer.toString(29, 36), this.cryptoType);
        return bundle;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Format(");
        sb.append(this.f9354id);
        sb.append(", ");
        sb.append(this.label);
        sb.append(", ");
        sb.append(this.containerMimeType);
        sb.append(", ");
        sb.append(this.sampleMimeType);
        sb.append(", ");
        sb.append(this.codecs);
        sb.append(", ");
        sb.append(this.bitrate);
        sb.append(", ");
        sb.append(this.language);
        sb.append(", [");
        sb.append(this.width);
        sb.append(", ");
        sb.append(this.height);
        sb.append(", ");
        sb.append(this.frameRate);
        sb.append("], [");
        sb.append(this.channelCount);
        sb.append(", ");
        return ye0.m8298r(sb, "])", this.sampleRate);
    }

    public Format withManifestFormatInfo(Format format) {
        String str;
        Metadata copyWithAppendedEntriesFrom;
        if (this == format) {
            return this;
        }
        int trackType = MimeTypes.getTrackType(this.sampleMimeType);
        String str2 = format.f9354id;
        String str3 = format.label;
        if (str3 == null) {
            str3 = this.label;
        }
        String str4 = this.language;
        if ((trackType == 3 || trackType == 1) && (str = format.language) != null) {
            str4 = str;
        }
        int i = this.averageBitrate;
        if (i == -1) {
            i = format.averageBitrate;
        }
        int i2 = this.peakBitrate;
        if (i2 == -1) {
            i2 = format.peakBitrate;
        }
        String str5 = this.codecs;
        if (str5 == null) {
            String codecsOfType = Util.getCodecsOfType(format.codecs, trackType);
            if (Util.splitCodecs(codecsOfType).length == 1) {
                str5 = codecsOfType;
            }
        }
        Metadata metadata = this.metadata;
        if (metadata == null) {
            copyWithAppendedEntriesFrom = format.metadata;
        } else {
            copyWithAppendedEntriesFrom = metadata.copyWithAppendedEntriesFrom(format.metadata);
        }
        float f = this.frameRate;
        if (f == -1.0f && trackType == 2) {
            f = format.frameRate;
        }
        int i3 = this.selectionFlags | format.selectionFlags;
        return buildUpon().setId(str2).setLabel(str3).setLanguage(str4).setSelectionFlags(i3).setRoleFlags(this.roleFlags | format.roleFlags).setAverageBitrate(i).setPeakBitrate(i2).setCodecs(str5).setMetadata(copyWithAppendedEntriesFrom).setDrmInitData(DrmInitData.createSessionCreationData(format.drmInitData, this.drmInitData)).setFrameRate(f).build();
    }

    @Deprecated
    public static Format createVideoSampleFormat(@Nullable String str, @Nullable String str2, @Nullable String str3, int i, int i2, int i3, int i4, float f, @Nullable List<byte[]> list, int i5, float f2, @Nullable DrmInitData drmInitData) {
        return new Builder().setId(str).setAverageBitrate(i).setPeakBitrate(i).setCodecs(str3).setSampleMimeType(str2).setMaxInputSize(i2).setInitializationData(list).setDrmInitData(drmInitData).setWidth(i3).setHeight(i4).setFrameRate(f).setRotationDegrees(i5).setPixelWidthHeightRatio(f2).build();
    }

    @Deprecated
    public static Format createAudioSampleFormat(@Nullable String str, @Nullable String str2, @Nullable String str3, int i, int i2, int i3, int i4, int i5, @Nullable List<byte[]> list, @Nullable DrmInitData drmInitData, int i6, @Nullable String str4) {
        return new Builder().setId(str).setLanguage(str4).setSelectionFlags(i6).setAverageBitrate(i).setPeakBitrate(i).setCodecs(str3).setSampleMimeType(str2).setMaxInputSize(i2).setInitializationData(list).setDrmInitData(drmInitData).setChannelCount(i3).setSampleRate(i4).setPcmEncoding(i5).build();
    }
}
