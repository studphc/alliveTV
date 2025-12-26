package com.google.android.exoplayer2.extractor.p002ts;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.p002ts.TsPayloadReader;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.SignedBytes;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class DefaultTsPayloadReaderFactory implements TsPayloadReader.Factory {
    public static final int FLAG_ALLOW_NON_IDR_KEYFRAMES = 1;
    public static final int FLAG_DETECT_ACCESS_UNITS = 8;
    public static final int FLAG_ENABLE_HDMV_DTS_AUDIO_STREAMS = 64;
    public static final int FLAG_IGNORE_AAC_STREAM = 2;
    public static final int FLAG_IGNORE_H264_STREAM = 4;
    public static final int FLAG_IGNORE_SPLICE_INFO_STREAM = 16;
    public static final int FLAG_OVERRIDE_CAPTION_DESCRIPTORS = 32;

    /* renamed from: a */
    public final int f10399a;

    /* renamed from: b */
    public final List f10400b;

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface Flags {
    }

    public DefaultTsPayloadReaderFactory() {
        this(0);
    }

    /* renamed from: a */
    public final List m2563a(TsPayloadReader.EsInfo esInfo) {
        boolean z;
        String str;
        int i;
        List<byte[]> list;
        boolean m2564b = m2564b(32);
        List list2 = this.f10400b;
        if (m2564b) {
            return list2;
        }
        ParsableByteArray parsableByteArray = new ParsableByteArray(esInfo.descriptorBytes);
        while (parsableByteArray.bytesLeft() > 0) {
            int readUnsignedByte = parsableByteArray.readUnsignedByte();
            int position = parsableByteArray.getPosition() + parsableByteArray.readUnsignedByte();
            if (readUnsignedByte == 134) {
                ArrayList arrayList = new ArrayList();
                int readUnsignedByte2 = parsableByteArray.readUnsignedByte() & 31;
                for (int i2 = 0; i2 < readUnsignedByte2; i2++) {
                    String readString = parsableByteArray.readString(3);
                    int readUnsignedByte3 = parsableByteArray.readUnsignedByte();
                    boolean z2 = true;
                    if ((readUnsignedByte3 & 128) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        i = readUnsignedByte3 & 63;
                        str = MimeTypes.APPLICATION_CEA708;
                    } else {
                        str = MimeTypes.APPLICATION_CEA608;
                        i = 1;
                    }
                    byte readUnsignedByte4 = (byte) parsableByteArray.readUnsignedByte();
                    parsableByteArray.skipBytes(1);
                    if (z) {
                        if ((readUnsignedByte4 & SignedBytes.MAX_POWER_OF_TWO) == 0) {
                            z2 = false;
                        }
                        list = CodecSpecificDataUtil.buildCea708InitializationData(z2);
                    } else {
                        list = null;
                    }
                    arrayList.add(new Format.Builder().setSampleMimeType(str).setLanguage(readString).setAccessibilityChannel(i).setInitializationData(list).build());
                }
                list2 = arrayList;
            }
            parsableByteArray.setPosition(position);
        }
        return list2;
    }

    /* renamed from: b */
    public final boolean m2564b(int i) {
        if ((i & this.f10399a) != 0) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.TsPayloadReader.Factory
    public SparseArray<TsPayloadReader> createInitialPayloadReaders() {
        return new SparseArray<>();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:25:0x002e. Please report as an issue. */
    @Override // com.google.android.exoplayer2.extractor.ts.TsPayloadReader.Factory
    @Nullable
    public TsPayloadReader createPayloadReader(int i, TsPayloadReader.EsInfo esInfo) {
        if (i != 2) {
            if (i != 3 && i != 4) {
                if (i != 21) {
                    if (i != 27) {
                        if (i != 36) {
                            if (i != 89) {
                                if (i != 138) {
                                    if (i != 172) {
                                        if (i != 257) {
                                            if (i != 134) {
                                                if (i != 135) {
                                                    switch (i) {
                                                        case 15:
                                                            if (m2564b(2)) {
                                                                return null;
                                                            }
                                                            return new PesReader(new AdtsReader(false, esInfo.language));
                                                        case 16:
                                                            return new PesReader(new H263Reader(new C0671c(m2563a(esInfo))));
                                                        case 17:
                                                            if (m2564b(2)) {
                                                                return null;
                                                            }
                                                            return new PesReader(new LatmReader(esInfo.language));
                                                        default:
                                                            switch (i) {
                                                                case 128:
                                                                    break;
                                                                case TsExtractor.TS_STREAM_TYPE_AC3 /* 129 */:
                                                                    break;
                                                                case TsExtractor.TS_STREAM_TYPE_HDMV_DTS /* 130 */:
                                                                    if (!m2564b(64)) {
                                                                        return null;
                                                                    }
                                                                    break;
                                                                default:
                                                                    return null;
                                                            }
                                                    }
                                                }
                                                return new PesReader(new Ac3Reader(esInfo.language));
                                            }
                                            if (m2564b(16)) {
                                                return null;
                                            }
                                            return new SectionReader(new PassthroughSectionPayloadReader(MimeTypes.APPLICATION_SCTE35));
                                        }
                                        return new SectionReader(new PassthroughSectionPayloadReader(MimeTypes.APPLICATION_AIT));
                                    }
                                    return new PesReader(new Ac4Reader(esInfo.language));
                                }
                                return new PesReader(new DtsReader(esInfo.language));
                            }
                            return new PesReader(new DvbSubtitleReader(esInfo.dvbSubtitleInfos));
                        }
                        return new PesReader(new H265Reader(new SeiReader(m2563a(esInfo))));
                    }
                    if (m2564b(4)) {
                        return null;
                    }
                    return new PesReader(new H264Reader(new SeiReader(m2563a(esInfo)), m2564b(1), m2564b(8)));
                }
                return new PesReader(new Id3Reader());
            }
            return new PesReader(new MpegAudioReader(esInfo.language));
        }
        return new PesReader(new H262Reader(new C0671c(m2563a(esInfo))));
    }

    public DefaultTsPayloadReaderFactory(int i) {
        this(i, ImmutableList.m3902of());
    }

    public DefaultTsPayloadReaderFactory(int i, List<Format> list) {
        this.f10399a = i;
        this.f10400b = list;
    }
}
