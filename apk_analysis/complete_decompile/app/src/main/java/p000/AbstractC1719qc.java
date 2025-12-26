package p000;

import android.util.Pair;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.AacUtil;
import com.google.android.exoplayer2.audio.Ac3Util;
import com.google.android.exoplayer2.audio.Ac4Util;
import com.google.android.exoplayer2.audio.OpusUtil;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.ExtractorUtil;
import com.google.android.exoplayer2.extractor.GaplessInfoHolder;
import com.google.android.exoplayer2.extractor.mp4.FixedSampleSizeRechunker$Results;
import com.google.android.exoplayer2.extractor.mp4.Track;
import com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox;
import com.google.android.exoplayer2.extractor.p002ts.PsExtractor;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.AvcConfig;
import com.google.android.exoplayer2.video.ColorInfo;
import com.google.android.exoplayer2.video.DolbyVisionConfig;
import com.google.android.exoplayer2.video.HevcConfig;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Ints;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: qc */
/* loaded from: classes.dex */
public abstract class AbstractC1719qc {

    /* renamed from: a */
    public static final byte[] f25511a = Util.getUtf8Bytes("OpusHead");

    /* renamed from: a */
    public static C1543mc m7019a(int i, ParsableByteArray parsableByteArray) {
        long j;
        long j2;
        parsableByteArray.setPosition(i + 12);
        parsableByteArray.skipBytes(1);
        m7020b(parsableByteArray);
        parsableByteArray.skipBytes(2);
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        if ((readUnsignedByte & 128) != 0) {
            parsableByteArray.skipBytes(2);
        }
        if ((readUnsignedByte & 64) != 0) {
            parsableByteArray.skipBytes(parsableByteArray.readUnsignedByte());
        }
        if ((readUnsignedByte & 32) != 0) {
            parsableByteArray.skipBytes(2);
        }
        parsableByteArray.skipBytes(1);
        m7020b(parsableByteArray);
        String mimeTypeFromMp4ObjectType = MimeTypes.getMimeTypeFromMp4ObjectType(parsableByteArray.readUnsignedByte());
        if (!MimeTypes.AUDIO_MPEG.equals(mimeTypeFromMp4ObjectType) && !MimeTypes.AUDIO_DTS.equals(mimeTypeFromMp4ObjectType) && !MimeTypes.AUDIO_DTS_HD.equals(mimeTypeFromMp4ObjectType)) {
            parsableByteArray.skipBytes(4);
            long readUnsignedInt = parsableByteArray.readUnsignedInt();
            long readUnsignedInt2 = parsableByteArray.readUnsignedInt();
            parsableByteArray.skipBytes(1);
            int m7020b = m7020b(parsableByteArray);
            byte[] bArr = new byte[m7020b];
            parsableByteArray.readBytes(bArr, 0, m7020b);
            if (readUnsignedInt2 > 0) {
                j = readUnsignedInt2;
            } else {
                j = -1;
            }
            if (readUnsignedInt > 0) {
                j2 = readUnsignedInt;
            } else {
                j2 = -1;
            }
            return new C1543mc(mimeTypeFromMp4ObjectType, bArr, j, j2);
        }
        return new C1543mc(mimeTypeFromMp4ObjectType, null, -1L, -1L);
    }

    /* renamed from: b */
    public static int m7020b(ParsableByteArray parsableByteArray) {
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        int i = readUnsignedByte & 127;
        while ((readUnsignedByte & 128) == 128) {
            readUnsignedByte = parsableByteArray.readUnsignedByte();
            i = (i << 7) | (readUnsignedByte & 127);
        }
        return i;
    }

    /* renamed from: c */
    public static Pair m7021c(ParsableByteArray parsableByteArray, int i, int i2) {
        boolean z;
        boolean z2;
        boolean z3;
        Integer num;
        TrackEncryptionBox trackEncryptionBox;
        Pair create;
        int i3;
        int i4;
        boolean z4;
        byte[] bArr;
        int position = parsableByteArray.getPosition();
        while (position - i < i2) {
            parsableByteArray.setPosition(position);
            int readInt = parsableByteArray.readInt();
            boolean z5 = false;
            if (readInt > 0) {
                z = true;
            } else {
                z = false;
            }
            ExtractorUtil.checkContainerInput(z, "childAtomSize must be positive");
            if (parsableByteArray.readInt() == 1936289382) {
                int i5 = position + 8;
                int i6 = 0;
                int i7 = -1;
                String str = null;
                Integer num2 = null;
                while (i5 - position < readInt) {
                    parsableByteArray.setPosition(i5);
                    int readInt2 = parsableByteArray.readInt();
                    int readInt3 = parsableByteArray.readInt();
                    if (readInt3 == 1718775137) {
                        num2 = Integer.valueOf(parsableByteArray.readInt());
                    } else if (readInt3 == 1935894637) {
                        parsableByteArray.skipBytes(4);
                        str = parsableByteArray.readString(4);
                    } else if (readInt3 == 1935894633) {
                        i7 = i5;
                        i6 = readInt2;
                    }
                    i5 += readInt2;
                }
                if (!C0643C.CENC_TYPE_cenc.equals(str) && !C0643C.CENC_TYPE_cbc1.equals(str) && !C0643C.CENC_TYPE_cens.equals(str) && !C0643C.CENC_TYPE_cbcs.equals(str)) {
                    create = null;
                } else {
                    if (num2 != null) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    ExtractorUtil.checkContainerInput(z2, "frma atom is mandatory");
                    if (i7 != -1) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    ExtractorUtil.checkContainerInput(z3, "schi atom is mandatory");
                    int i8 = i7 + 8;
                    while (true) {
                        if (i8 - i7 < i6) {
                            parsableByteArray.setPosition(i8);
                            int readInt4 = parsableByteArray.readInt();
                            if (parsableByteArray.readInt() == 1952804451) {
                                int m5518b = AbstractC1386kc.m5518b(parsableByteArray.readInt());
                                parsableByteArray.skipBytes(1);
                                if (m5518b == 0) {
                                    parsableByteArray.skipBytes(1);
                                    i3 = 0;
                                    i4 = 0;
                                } else {
                                    int readUnsignedByte = parsableByteArray.readUnsignedByte();
                                    int i9 = (readUnsignedByte & PsExtractor.VIDEO_STREAM_MASK) >> 4;
                                    i3 = readUnsignedByte & 15;
                                    i4 = i9;
                                }
                                if (parsableByteArray.readUnsignedByte() == 1) {
                                    z4 = true;
                                } else {
                                    z4 = false;
                                }
                                int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
                                byte[] bArr2 = new byte[16];
                                parsableByteArray.readBytes(bArr2, 0, 16);
                                if (z4 && readUnsignedByte2 == 0) {
                                    int readUnsignedByte3 = parsableByteArray.readUnsignedByte();
                                    byte[] bArr3 = new byte[readUnsignedByte3];
                                    parsableByteArray.readBytes(bArr3, 0, readUnsignedByte3);
                                    bArr = bArr3;
                                } else {
                                    bArr = null;
                                }
                                num = num2;
                                trackEncryptionBox = new TrackEncryptionBox(z4, str, readUnsignedByte2, bArr2, i4, i3, bArr);
                            } else {
                                i8 += readInt4;
                            }
                        } else {
                            num = num2;
                            trackEncryptionBox = null;
                            break;
                        }
                    }
                    if (trackEncryptionBox != null) {
                        z5 = true;
                    }
                    ExtractorUtil.checkContainerInput(z5, "tenc atom is mandatory");
                    create = Pair.create(num, (TrackEncryptionBox) Util.castNonNull(trackEncryptionBox));
                }
                if (create != null) {
                    return create;
                }
            }
            position += readInt;
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r5v0, types: [pc, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v14, types: [oc, java.lang.Object] */
    /* renamed from: d */
    public static ev2 m7022d(Track track, C1301ic c1301ic, GaplessInfoHolder gaplessInfoHolder) {
        InterfaceC1580nc interfaceC1580nc;
        boolean z;
        ParsableByteArray parsableByteArray;
        ParsableByteArray parsableByteArray2;
        int i;
        int i2;
        int i3;
        int i4;
        boolean z2;
        int i5;
        int i6;
        boolean z3;
        int i7;
        Track track2;
        String str;
        int i8;
        long[] jArr;
        int[] iArr;
        long[] jArr2;
        int[] iArr2;
        int i9;
        long j;
        int i10;
        int i11;
        int i12;
        int i13;
        boolean z4;
        boolean z5;
        long[] jArr3;
        int[] iArr3;
        int[] iArr4;
        long[] jArr4;
        int[] iArr5;
        int i14;
        boolean z6;
        int i15;
        int i16;
        boolean z7;
        boolean z8;
        C1349jc m5207d = c1301ic.m5207d(1937011578);
        if (m5207d != null) {
            Format format = track.format;
            ?? obj = new Object();
            ParsableByteArray parsableByteArray3 = m5207d.f20458b;
            obj.f23761c = parsableByteArray3;
            parsableByteArray3.setPosition(12);
            int readUnsignedIntToInt = parsableByteArray3.readUnsignedIntToInt();
            if (MimeTypes.AUDIO_RAW.equals(format.sampleMimeType)) {
                int pcmFrameSize = Util.getPcmFrameSize(format.pcmEncoding, format.channelCount);
                if (readUnsignedIntToInt == 0 || readUnsignedIntToInt % pcmFrameSize != 0) {
                    Log.m3027w("AtomParsers", "Audio sample size mismatch. stsd sample size: " + pcmFrameSize + ", stsz sample size: " + readUnsignedIntToInt);
                    readUnsignedIntToInt = pcmFrameSize;
                }
            }
            if (readUnsignedIntToInt == 0) {
                readUnsignedIntToInt = -1;
            }
            obj.f23759a = readUnsignedIntToInt;
            obj.f23760b = parsableByteArray3.readUnsignedIntToInt();
            interfaceC1580nc = obj;
        } else {
            C1349jc m5207d2 = c1301ic.m5207d(1937013298);
            if (m5207d2 != null) {
                ?? obj2 = new Object();
                ParsableByteArray parsableByteArray4 = m5207d2.f20458b;
                obj2.f25116e = parsableByteArray4;
                parsableByteArray4.setPosition(12);
                obj2.f25113b = parsableByteArray4.readUnsignedIntToInt() & 255;
                obj2.f25112a = parsableByteArray4.readUnsignedIntToInt();
                interfaceC1580nc = obj2;
            } else {
                throw ParserException.createForMalformedContainer("Track has no sample table size information", null);
            }
        }
        int mo6341b = interfaceC1580nc.mo6341b();
        if (mo6341b == 0) {
            return new ev2(track, new long[0], new int[0], 0, new long[0], new int[0], 0L);
        }
        C1349jc m5207d3 = c1301ic.m5207d(1937007471);
        if (m5207d3 == null) {
            m5207d3 = (C1349jc) Assertions.checkNotNull(c1301ic.m5207d(1668232756));
            z = true;
        } else {
            z = false;
        }
        ParsableByteArray parsableByteArray5 = m5207d3.f20458b;
        ParsableByteArray parsableByteArray6 = ((C1349jc) Assertions.checkNotNull(c1301ic.m5207d(1937011555))).f20458b;
        ParsableByteArray parsableByteArray7 = ((C1349jc) Assertions.checkNotNull(c1301ic.m5207d(1937011827))).f20458b;
        C1349jc m5207d4 = c1301ic.m5207d(1937011571);
        if (m5207d4 != null) {
            parsableByteArray = m5207d4.f20458b;
        } else {
            parsableByteArray = null;
        }
        C1349jc m5207d5 = c1301ic.m5207d(1668576371);
        if (m5207d5 != null) {
            parsableByteArray2 = m5207d5.f20458b;
        } else {
            parsableByteArray2 = null;
        }
        C1506lc c1506lc = new C1506lc(parsableByteArray6, parsableByteArray5, z);
        parsableByteArray7.setPosition(12);
        int readUnsignedIntToInt2 = parsableByteArray7.readUnsignedIntToInt() - 1;
        int readUnsignedIntToInt3 = parsableByteArray7.readUnsignedIntToInt();
        int readUnsignedIntToInt4 = parsableByteArray7.readUnsignedIntToInt();
        if (parsableByteArray2 != null) {
            parsableByteArray2.setPosition(12);
            i = parsableByteArray2.readUnsignedIntToInt();
        } else {
            i = 0;
        }
        if (parsableByteArray != null) {
            parsableByteArray.setPosition(12);
            i3 = parsableByteArray.readUnsignedIntToInt();
            if (i3 > 0) {
                i2 = parsableByteArray.readUnsignedIntToInt() - 1;
            } else {
                i2 = -1;
                parsableByteArray = null;
            }
        } else {
            i2 = -1;
            i3 = 0;
        }
        int mo6340a = interfaceC1580nc.mo6340a();
        String str2 = track.format.sampleMimeType;
        if (mo6340a != -1 && ((MimeTypes.AUDIO_RAW.equals(str2) || MimeTypes.AUDIO_MLAW.equals(str2) || MimeTypes.AUDIO_ALAW.equals(str2)) && readUnsignedIntToInt2 == 0 && i == 0 && i3 == 0)) {
            i4 = i3;
            z2 = true;
        } else {
            i4 = i3;
            z2 = false;
        }
        if (z2) {
            int i17 = c1506lc.f22449a;
            long[] jArr5 = new long[i17];
            int[] iArr6 = new int[i17];
            while (c1506lc.m5915a()) {
                int i18 = c1506lc.f22450b;
                jArr5[i18] = c1506lc.f22452d;
                iArr6[i18] = c1506lc.f22451c;
            }
            long j2 = readUnsignedIntToInt4;
            int i19 = 8192 / mo6340a;
            int i20 = 0;
            for (int i21 = 0; i21 < i17; i21++) {
                i20 += Util.ceilDivide(iArr6[i21], i19);
            }
            long[] jArr6 = new long[i20];
            int[] iArr7 = new int[i20];
            long[] jArr7 = new long[i20];
            int[] iArr8 = new int[i20];
            int i22 = 0;
            int i23 = 0;
            int i24 = 0;
            int i25 = 0;
            while (i22 < i17) {
                int i26 = iArr6[i22];
                long j3 = jArr5[i22];
                long[] jArr8 = jArr5;
                int i27 = i25;
                int i28 = i17;
                int i29 = i26;
                while (i29 > 0) {
                    int min = Math.min(i19, i29);
                    jArr6[i24] = j3;
                    int[] iArr9 = iArr6;
                    int i30 = mo6340a * min;
                    iArr7[i24] = i30;
                    int max = Math.max(i27, i30);
                    jArr7[i24] = i23 * j2;
                    iArr8[i24] = 1;
                    j3 += iArr7[i24];
                    i23 += min;
                    i29 -= min;
                    i24++;
                    i27 = max;
                    iArr6 = iArr9;
                }
                i22++;
                i25 = i27;
                i17 = i28;
                jArr5 = jArr8;
            }
            FixedSampleSizeRechunker$Results fixedSampleSizeRechunker$Results = new FixedSampleSizeRechunker$Results(jArr6, iArr7, i25, jArr7, iArr8, j2 * i23);
            long[] jArr9 = fixedSampleSizeRechunker$Results.offsets;
            int[] iArr10 = fixedSampleSizeRechunker$Results.sizes;
            int i31 = fixedSampleSizeRechunker$Results.maximumSize;
            long[] jArr10 = fixedSampleSizeRechunker$Results.timestamps;
            int[] iArr11 = fixedSampleSizeRechunker$Results.flags;
            long j4 = fixedSampleSizeRechunker$Results.duration;
            track2 = track;
            i8 = mo6341b;
            jArr = jArr9;
            iArr = iArr10;
            i9 = i31;
            jArr2 = jArr10;
            iArr2 = iArr11;
            j = j4;
        } else {
            long[] jArr11 = new long[mo6341b];
            int[] iArr12 = new int[mo6341b];
            long[] jArr12 = new long[mo6341b];
            int[] iArr13 = new int[mo6341b];
            int i32 = i2;
            int i33 = 0;
            int i34 = 0;
            int i35 = 0;
            long j5 = 0;
            long j6 = 0;
            int i36 = 0;
            int i37 = 0;
            int i38 = i;
            int i39 = readUnsignedIntToInt4;
            int i40 = readUnsignedIntToInt3;
            int i41 = i4;
            int i42 = readUnsignedIntToInt2;
            while (true) {
                if (i33 < mo6341b) {
                    long j7 = j6;
                    int i43 = i35;
                    boolean z9 = true;
                    while (i43 == 0) {
                        z9 = c1506lc.m5915a();
                        if (!z9) {
                            break;
                        }
                        int i44 = i40;
                        long j8 = c1506lc.f22452d;
                        i43 = c1506lc.f22451c;
                        j7 = j8;
                        i40 = i44;
                        i39 = i39;
                        mo6341b = mo6341b;
                    }
                    int i45 = mo6341b;
                    i5 = i40;
                    int i46 = i39;
                    if (!z9) {
                        Log.m3027w("AtomParsers", "Unexpected end of chunk data");
                        jArr11 = Arrays.copyOf(jArr11, i33);
                        iArr12 = Arrays.copyOf(iArr12, i33);
                        jArr12 = Arrays.copyOf(jArr12, i33);
                        iArr13 = Arrays.copyOf(iArr13, i33);
                        mo6341b = i33;
                        i6 = i43;
                        break;
                    }
                    if (parsableByteArray2 != null) {
                        while (i37 == 0 && i38 > 0) {
                            i37 = parsableByteArray2.readUnsignedIntToInt();
                            i36 = parsableByteArray2.readInt();
                            i38--;
                        }
                        i37--;
                    }
                    int i47 = i36;
                    jArr11[i33] = j7;
                    int mo6342c = interfaceC1580nc.mo6342c();
                    iArr12[i33] = mo6342c;
                    if (mo6342c > i34) {
                        i34 = mo6342c;
                    }
                    jArr12[i33] = j5 + i47;
                    if (parsableByteArray == null) {
                        i10 = 1;
                    } else {
                        i10 = 0;
                    }
                    iArr13[i33] = i10;
                    if (i33 == i32) {
                        iArr13[i33] = 1;
                        i41--;
                        if (i41 > 0) {
                            i32 = ((ParsableByteArray) Assertions.checkNotNull(parsableByteArray)).readUnsignedIntToInt() - 1;
                        }
                    }
                    int i48 = i32;
                    j5 += i46;
                    int i49 = i5 - 1;
                    if (i49 == 0 && i42 > 0) {
                        i49 = parsableByteArray7.readUnsignedIntToInt();
                        i11 = parsableByteArray7.readInt();
                        i12 = i42 - 1;
                    } else {
                        i11 = i46;
                        i12 = i42;
                    }
                    int i50 = i49;
                    long j9 = j7 + iArr12[i33];
                    i33++;
                    i36 = i47;
                    int i51 = i12;
                    i40 = i50;
                    i42 = i51;
                    i32 = i48;
                    i39 = i11;
                    i35 = i43 - 1;
                    mo6341b = i45;
                    j6 = j9;
                } else {
                    i5 = i40;
                    i6 = i35;
                    break;
                }
            }
            long j10 = j5 + i36;
            if (parsableByteArray2 != null) {
                while (i38 > 0) {
                    if (parsableByteArray2.readUnsignedIntToInt() != 0) {
                        z3 = false;
                        break;
                    }
                    parsableByteArray2.readInt();
                    i38--;
                }
            }
            z3 = true;
            if (i41 == 0 && i5 == 0 && i6 == 0 && i42 == 0) {
                i7 = i37;
                if (i7 == 0 && z3) {
                    track2 = track;
                    i8 = mo6341b;
                    jArr = jArr11;
                    iArr = iArr12;
                    jArr2 = jArr12;
                    iArr2 = iArr13;
                    i9 = i34;
                    j = j10;
                }
            } else {
                i7 = i37;
            }
            StringBuilder sb = new StringBuilder("Inconsistent stbl box for track ");
            track2 = track;
            sb.append(track2.f10330id);
            sb.append(": remainingSynchronizationSamples ");
            sb.append(i41);
            sb.append(", remainingSamplesAtTimestampDelta ");
            sb.append(i5);
            sb.append(", remainingSamplesInChunk ");
            sb.append(i6);
            sb.append(", remainingTimestampDeltaChanges ");
            sb.append(i42);
            sb.append(", remainingSamplesAtTimestampOffset ");
            sb.append(i7);
            if (!z3) {
                str = ", ctts invalid";
            } else {
                str = "";
            }
            sb.append(str);
            Log.m3027w("AtomParsers", sb.toString());
            i8 = mo6341b;
            jArr = jArr11;
            iArr = iArr12;
            jArr2 = jArr12;
            iArr2 = iArr13;
            i9 = i34;
            j = j10;
        }
        long scaleLargeTimestamp = Util.scaleLargeTimestamp(j, 1000000L, track2.timescale);
        long[] jArr13 = track2.editListDurations;
        if (jArr13 == null) {
            Util.scaleLargeTimestampsInPlace(jArr2, 1000000L, track2.timescale);
            return new ev2(track, jArr, iArr, i9, jArr2, iArr2, scaleLargeTimestamp);
        }
        if (jArr13.length == 1 && track2.type == 1 && jArr2.length >= 2) {
            long j11 = ((long[]) Assertions.checkNotNull(track2.editListMediaTimes))[0];
            long scaleLargeTimestamp2 = Util.scaleLargeTimestamp(track2.editListDurations[0], track2.timescale, track2.movieTimescale) + j11;
            int length = jArr2.length - 1;
            int constrainValue = Util.constrainValue(4, 0, length);
            i13 = i8;
            int constrainValue2 = Util.constrainValue(jArr2.length - 4, 0, length);
            long j12 = jArr2[0];
            if (j12 <= j11 && j11 < jArr2[constrainValue] && jArr2[constrainValue2] < scaleLargeTimestamp2 && scaleLargeTimestamp2 <= j) {
                z8 = true;
            } else {
                z8 = false;
            }
            if (z8) {
                long scaleLargeTimestamp3 = Util.scaleLargeTimestamp(j11 - j12, track2.format.sampleRate, track2.timescale);
                long scaleLargeTimestamp4 = Util.scaleLargeTimestamp(j - scaleLargeTimestamp2, track2.format.sampleRate, track2.timescale);
                if ((scaleLargeTimestamp3 != 0 || scaleLargeTimestamp4 != 0) && scaleLargeTimestamp3 <= 2147483647L && scaleLargeTimestamp4 <= 2147483647L) {
                    gaplessInfoHolder.encoderDelay = (int) scaleLargeTimestamp3;
                    gaplessInfoHolder.encoderPadding = (int) scaleLargeTimestamp4;
                    Util.scaleLargeTimestampsInPlace(jArr2, 1000000L, track2.timescale);
                    return new ev2(track, jArr, iArr, i9, jArr2, iArr2, Util.scaleLargeTimestamp(track2.editListDurations[0], 1000000L, track2.movieTimescale));
                }
            }
        } else {
            i13 = i8;
        }
        long[] jArr14 = track2.editListDurations;
        if (jArr14.length == 1 && jArr14[0] == 0) {
            long j13 = ((long[]) Assertions.checkNotNull(track2.editListMediaTimes))[0];
            for (int i52 = 0; i52 < jArr2.length; i52++) {
                jArr2[i52] = Util.scaleLargeTimestamp(jArr2[i52] - j13, 1000000L, track2.timescale);
            }
            return new ev2(track, jArr, iArr, i9, jArr2, iArr2, Util.scaleLargeTimestamp(j - j13, 1000000L, track2.timescale));
        }
        if (track2.type == 1) {
            z4 = true;
        } else {
            z4 = false;
        }
        int[] iArr14 = new int[jArr14.length];
        int[] iArr15 = new int[jArr14.length];
        long[] jArr15 = (long[]) Assertions.checkNotNull(track2.editListMediaTimes);
        int i53 = 0;
        boolean z10 = false;
        int i54 = 0;
        int i55 = 0;
        while (true) {
            long[] jArr16 = track2.editListDurations;
            if (i53 >= jArr16.length) {
                break;
            }
            int[] iArr16 = iArr;
            int i56 = i9;
            long j14 = jArr15[i53];
            if (j14 != -1) {
                int i57 = i55;
                boolean z11 = z10;
                int i58 = i54;
                long scaleLargeTimestamp5 = Util.scaleLargeTimestamp(jArr16[i53], track2.timescale, track2.movieTimescale);
                iArr14[i53] = Util.binarySearchFloor(jArr2, j14, true, true);
                iArr15[i53] = Util.binarySearchCeil(jArr2, j14 + scaleLargeTimestamp5, z4, false);
                while (true) {
                    i15 = iArr14[i53];
                    i16 = iArr15[i53];
                    if (i15 >= i16 || (iArr2[i15] & 1) != 0) {
                        break;
                    }
                    iArr14[i53] = i15 + 1;
                }
                i54 = (i16 - i15) + i58;
                if (i57 != i15) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                z6 = z11 | z7;
                i14 = i16;
            } else {
                i14 = i55;
                z6 = z10;
            }
            i53++;
            z10 = z6;
            i55 = i14;
            i9 = i56;
            iArr = iArr16;
        }
        int[] iArr17 = iArr;
        int i59 = i9;
        boolean z12 = z10;
        int i60 = 0;
        if (i54 != i13) {
            z5 = true;
        } else {
            z5 = false;
        }
        boolean z13 = z12 | z5;
        if (z13) {
            jArr3 = new long[i54];
        } else {
            jArr3 = jArr;
        }
        if (z13) {
            iArr3 = new int[i54];
        } else {
            iArr3 = iArr17;
        }
        if (z13) {
            i59 = 0;
        }
        if (z13) {
            iArr4 = new int[i54];
        } else {
            iArr4 = iArr2;
        }
        long[] jArr17 = new long[i54];
        int i61 = 0;
        int i62 = i59;
        long j15 = 0;
        while (i60 < track2.editListDurations.length) {
            long j16 = track2.editListMediaTimes[i60];
            int i63 = iArr14[i60];
            int[] iArr18 = iArr14;
            int i64 = iArr15[i60];
            int[] iArr19 = iArr15;
            if (z13) {
                int i65 = i64 - i63;
                System.arraycopy(jArr, i63, jArr3, i61, i65);
                jArr4 = jArr;
                iArr5 = iArr17;
                System.arraycopy(iArr5, i63, iArr3, i61, i65);
                System.arraycopy(iArr2, i63, iArr4, i61, i65);
            } else {
                jArr4 = jArr;
                iArr5 = iArr17;
            }
            int i66 = i62;
            while (i63 < i64) {
                int[] iArr20 = iArr2;
                int i67 = i64;
                long j17 = j15;
                int[] iArr21 = iArr5;
                long[] jArr18 = jArr3;
                jArr17[i61] = Util.scaleLargeTimestamp(j15, 1000000L, track2.movieTimescale) + Util.scaleLargeTimestamp(Math.max(0L, jArr2[i63] - j16), 1000000L, track2.timescale);
                if (z13 && iArr3[i61] > i66) {
                    i66 = iArr21[i63];
                }
                i61++;
                i63++;
                iArr2 = iArr20;
                iArr5 = iArr21;
                j15 = j17;
                i64 = i67;
                jArr3 = jArr18;
            }
            j15 += track2.editListDurations[i60];
            i60++;
            iArr2 = iArr2;
            i62 = i66;
            iArr17 = iArr5;
            iArr14 = iArr18;
            iArr15 = iArr19;
            jArr = jArr4;
            jArr3 = jArr3;
        }
        return new ev2(track, jArr3, iArr3, i62, jArr17, iArr4, Util.scaleLargeTimestamp(j15, 1000000L, track2.movieTimescale));
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00ec, code lost:
    
        if (r26 == 0) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00ee, code lost:
    
        r26 = -9223372036854775807L;
     */
    /* JADX WARN: Code restructure failed: missing block: B:547:0x0baf, code lost:
    
        if (r26 == null) goto L580;
     */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0588  */
    /* JADX WARN: Removed duplicated region for block: B:579:0x0c8f  */
    /* JADX WARN: Removed duplicated region for block: B:581:0x0c91  */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ArrayList m7023e(C1301ic c1301ic, GaplessInfoHolder gaplessInfoHolder, long j, DrmInitData drmInitData, boolean z, boolean z2, Function function) {
        long j2;
        long j3;
        ArrayList arrayList;
        int i;
        long[] jArr;
        long[] jArr2;
        Track track;
        Function function2;
        Pair create;
        int i2;
        C1301ic c1301ic2;
        Pair pair;
        int i3;
        TrackEncryptionBox[] trackEncryptionBoxArr;
        int i4;
        int i5;
        DrmInitData drmInitData2;
        String str;
        String str2;
        int i6;
        int i7;
        List<byte[]> list;
        int i8;
        int i9;
        int i10;
        DrmInitData drmInitData3;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        byte[] bArr;
        float f;
        byte[] bArr2;
        int i18;
        String str3;
        String str4;
        int i19;
        Pair pair2;
        int readUnsignedShort;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        DrmInitData drmInitData4;
        String str5;
        int i25;
        Format format;
        int i26;
        int i27;
        boolean z3;
        int i28;
        int position;
        String str6;
        boolean z4;
        int i29;
        DrmInitData copyWithSchemeType;
        long j4;
        ImmutableList immutableList;
        C1301ic c1301ic3 = c1301ic;
        DrmInitData drmInitData5 = drmInitData;
        ArrayList arrayList2 = new ArrayList();
        int i30 = 0;
        while (true) {
            ArrayList arrayList3 = c1301ic3.f18361d;
            if (i30 >= arrayList3.size()) {
                return arrayList2;
            }
            C1301ic c1301ic4 = (C1301ic) arrayList3.get(i30);
            if (c1301ic4.f20817a != 1953653099) {
                i = i30;
            } else {
                C1349jc c1349jc = (C1349jc) Assertions.checkNotNull(c1301ic3.m5207d(1836476516));
                C1301ic c1301ic5 = (C1301ic) Assertions.checkNotNull(c1301ic4.m5206c(1835297121));
                ParsableByteArray parsableByteArray = ((C1349jc) Assertions.checkNotNull(c1301ic5.m5207d(1751411826))).f20458b;
                parsableByteArray.setPosition(16);
                int readInt = parsableByteArray.readInt();
                int i31 = readInt == 1936684398 ? 1 : readInt == 1986618469 ? 2 : (readInt == 1952807028 || readInt == 1935832172 || readInt == 1937072756 || readInt == 1668047728) ? 3 : readInt == 1835365473 ? 5 : -1;
                if (i31 == -1) {
                    function2 = function;
                    arrayList = arrayList2;
                    i = i30;
                    track = null;
                } else {
                    ParsableByteArray parsableByteArray2 = ((C1349jc) Assertions.checkNotNull(c1301ic4.m5207d(1953196132))).f20458b;
                    parsableByteArray2.setPosition(8);
                    int m5518b = AbstractC1386kc.m5518b(parsableByteArray2.readInt());
                    parsableByteArray2.skipBytes(m5518b == 0 ? 8 : 16);
                    int readInt2 = parsableByteArray2.readInt();
                    parsableByteArray2.skipBytes(4);
                    int position2 = parsableByteArray2.getPosition();
                    int i32 = m5518b == 0 ? 4 : 8;
                    int i33 = 0;
                    while (true) {
                        j2 = C0643C.TIME_UNSET;
                        if (i33 < i32) {
                            if (parsableByteArray2.getData()[position2 + i33] != -1) {
                                j3 = m5518b == 0 ? parsableByteArray2.readUnsignedInt() : parsableByteArray2.readUnsignedLongToLong();
                            } else {
                                i33++;
                            }
                        } else {
                            parsableByteArray2.skipBytes(i32);
                            break;
                        }
                    }
                    parsableByteArray2.skipBytes(16);
                    int readInt3 = parsableByteArray2.readInt();
                    int readInt4 = parsableByteArray2.readInt();
                    parsableByteArray2.skipBytes(4);
                    int readInt5 = parsableByteArray2.readInt();
                    int readInt6 = parsableByteArray2.readInt();
                    int i34 = (readInt3 == 0 && readInt4 == 65536 && readInt5 == -65536 && readInt6 == 0) ? 90 : (readInt3 == 0 && readInt4 == -65536 && readInt5 == 65536 && readInt6 == 0) ? 270 : (readInt3 == -65536 && readInt4 == 0 && readInt5 == 0 && readInt6 == -65536) ? 180 : 0;
                    long j5 = j == C0643C.TIME_UNSET ? j3 : j;
                    ParsableByteArray parsableByteArray3 = c1349jc.f20458b;
                    parsableByteArray3.setPosition(8);
                    parsableByteArray3.skipBytes(AbstractC1386kc.m5518b(parsableByteArray3.readInt()) == 0 ? 8 : 16);
                    long readUnsignedInt = parsableByteArray3.readUnsignedInt();
                    if (j5 != C0643C.TIME_UNSET) {
                        j2 = Util.scaleLargeTimestamp(j5, 1000000L, readUnsignedInt);
                    }
                    C1301ic c1301ic6 = (C1301ic) Assertions.checkNotNull(((C1301ic) Assertions.checkNotNull(c1301ic5.m5206c(1835626086))).m5206c(1937007212));
                    ParsableByteArray parsableByteArray4 = ((C1349jc) Assertions.checkNotNull(c1301ic5.m5207d(1835296868))).f20458b;
                    parsableByteArray4.setPosition(8);
                    int m5518b2 = AbstractC1386kc.m5518b(parsableByteArray4.readInt());
                    parsableByteArray4.skipBytes(m5518b2 == 0 ? 8 : 16);
                    long readUnsignedInt2 = parsableByteArray4.readUnsignedInt();
                    parsableByteArray4.skipBytes(m5518b2 == 0 ? 4 : 8);
                    int readUnsignedShort2 = parsableByteArray4.readUnsignedShort();
                    Pair create2 = Pair.create(Long.valueOf(readUnsignedInt2), "" + ((char) (((readUnsignedShort2 >> 10) & 31) + 96)) + ((char) (((readUnsignedShort2 >> 5) & 31) + 96)) + ((char) ((readUnsignedShort2 & 31) + 96)));
                    ParsableByteArray parsableByteArray5 = ((C1349jc) Assertions.checkNotNull(c1301ic6.m5207d(1937011556))).f20458b;
                    String str7 = (String) create2.second;
                    parsableByteArray5.setPosition(12);
                    int readInt7 = parsableByteArray5.readInt();
                    TrackEncryptionBox[] trackEncryptionBoxArr2 = new TrackEncryptionBox[readInt7];
                    int i35 = 0;
                    Format format2 = null;
                    int i36 = 0;
                    int i37 = 0;
                    while (i35 < readInt7) {
                        int i38 = readInt7;
                        int position3 = parsableByteArray5.getPosition();
                        int i39 = i30;
                        int readInt8 = parsableByteArray5.readInt();
                        ArrayList arrayList4 = arrayList2;
                        long j6 = readUnsignedInt;
                        String str8 = "childAtomSize must be positive";
                        ExtractorUtil.checkContainerInput(readInt8 > 0, "childAtomSize must be positive");
                        int readInt9 = parsableByteArray5.readInt();
                        if (readInt9 == 1635148593 || readInt9 == 1635148595 || readInt9 == 1701733238 || readInt9 == 1831958048 || readInt9 == 1836070006 || readInt9 == 1752589105 || readInt9 == 1751479857 || readInt9 == 1932670515 || readInt9 == 1211250227 || readInt9 == 1987063864 || readInt9 == 1987063865 || readInt9 == 1635135537 || readInt9 == 1685479798 || readInt9 == 1685479729 || readInt9 == 1685481573 || readInt9 == 1685481521) {
                            i2 = i35;
                            int i40 = i34;
                            c1301ic2 = c1301ic4;
                            String str9 = "childAtomSize must be positive";
                            pair = create2;
                            i3 = i31;
                            trackEncryptionBoxArr = trackEncryptionBoxArr2;
                            parsableByteArray5.setPosition(position3 + 16);
                            parsableByteArray5.skipBytes(16);
                            int readUnsignedShort3 = parsableByteArray5.readUnsignedShort();
                            int readUnsignedShort4 = parsableByteArray5.readUnsignedShort();
                            parsableByteArray5.skipBytes(50);
                            int position4 = parsableByteArray5.getPosition();
                            if (readInt9 == 1701733238) {
                                i4 = readInt8;
                                i5 = position3;
                                Pair m7021c = m7021c(parsableByteArray5, i5, i4);
                                if (m7021c != null) {
                                    readInt9 = ((Integer) m7021c.first).intValue();
                                    drmInitData2 = drmInitData == null ? null : drmInitData.copyWithSchemeType(((TrackEncryptionBox) m7021c.second).schemeType);
                                    trackEncryptionBoxArr[i2] = (TrackEncryptionBox) m7021c.second;
                                } else {
                                    drmInitData2 = drmInitData;
                                }
                                parsableByteArray5.setPosition(position4);
                            } else {
                                i4 = readInt8;
                                i5 = position3;
                                drmInitData2 = drmInitData;
                            }
                            if (readInt9 != 1831958048) {
                                str = readInt9 == 1211250227 ? MimeTypes.VIDEO_H263 : null;
                            } else {
                                str = MimeTypes.VIDEO_MPEG;
                            }
                            str2 = str7;
                            String str10 = str;
                            Format format3 = format2;
                            int i41 = i37;
                            boolean z5 = false;
                            int i42 = -1;
                            String str11 = null;
                            ByteBuffer byteBuffer = null;
                            C1543mc c1543mc = null;
                            int i43 = -1;
                            int i44 = -1;
                            int i45 = -1;
                            int i46 = position4;
                            float f2 = 1.0f;
                            List<byte[]> list2 = null;
                            byte[] bArr3 = null;
                            while (true) {
                                if (i46 - i5 >= i4) {
                                    i6 = readUnsignedShort3;
                                    i7 = readUnsignedShort4;
                                    list = list2;
                                    i8 = i5;
                                    i9 = i4;
                                    i10 = i42;
                                    drmInitData3 = drmInitData2;
                                    break;
                                }
                                parsableByteArray5.setPosition(i46);
                                int position5 = parsableByteArray5.getPosition();
                                drmInitData3 = drmInitData2;
                                int readInt10 = parsableByteArray5.readInt();
                                if (readInt10 == 0) {
                                    list = list2;
                                    if (parsableByteArray5.getPosition() - i5 == i4) {
                                        i6 = readUnsignedShort3;
                                        i7 = readUnsignedShort4;
                                        i8 = i5;
                                        i9 = i4;
                                        i10 = i42;
                                        break;
                                    }
                                } else {
                                    list = list2;
                                }
                                String str12 = str9;
                                int i47 = i5;
                                ExtractorUtil.checkContainerInput(readInt10 > 0, str12);
                                int readInt11 = parsableByteArray5.readInt();
                                if (readInt11 == 1635148611) {
                                    ExtractorUtil.checkContainerInput(str10 == null, null);
                                    parsableByteArray5.setPosition(position5 + 8);
                                    AvcConfig parse = AvcConfig.parse(parsableByteArray5);
                                    list2 = parse.initializationData;
                                    i18 = parse.nalUnitLengthFieldLength;
                                    if (!z5) {
                                        f2 = parse.pixelWidthHeightRatio;
                                    }
                                    str3 = parse.codecs;
                                    str4 = MimeTypes.VIDEO_H264;
                                } else if (readInt11 == 1752589123) {
                                    ExtractorUtil.checkContainerInput(str10 == null, null);
                                    parsableByteArray5.setPosition(position5 + 8);
                                    HevcConfig parse2 = HevcConfig.parse(parsableByteArray5);
                                    list2 = parse2.initializationData;
                                    i18 = parse2.nalUnitLengthFieldLength;
                                    if (!z5) {
                                        f2 = parse2.pixelWidthHeightRatio;
                                    }
                                    str3 = parse2.codecs;
                                    str4 = MimeTypes.VIDEO_H265;
                                } else {
                                    if (readInt11 == 1685480259 || readInt11 == 1685485123) {
                                        i13 = readUnsignedShort3;
                                        i14 = readInt9;
                                        i15 = readUnsignedShort4;
                                        i16 = i4;
                                        i17 = i42;
                                        bArr = bArr3;
                                        f = f2;
                                        DolbyVisionConfig parse3 = DolbyVisionConfig.parse(parsableByteArray5);
                                        if (parse3 != null) {
                                            str11 = parse3.codecs;
                                            str10 = MimeTypes.VIDEO_DOLBY_VISION;
                                        }
                                    } else {
                                        if (readInt11 == 1987076931) {
                                            ExtractorUtil.checkContainerInput(str10 == null, null);
                                            str10 = readInt9 == 1987063864 ? MimeTypes.VIDEO_VP8 : MimeTypes.VIDEO_VP9;
                                        } else if (readInt11 == 1635135811) {
                                            ExtractorUtil.checkContainerInput(str10 == null, null);
                                            str10 = MimeTypes.VIDEO_AV1;
                                        } else if (readInt11 == 1668050025) {
                                            if (byteBuffer == null) {
                                                byteBuffer = ByteBuffer.allocate(25).order(ByteOrder.LITTLE_ENDIAN);
                                            }
                                            ByteBuffer byteBuffer2 = byteBuffer;
                                            byteBuffer2.position(21);
                                            byteBuffer2.putShort(parsableByteArray5.readShort());
                                            byteBuffer2.putShort(parsableByteArray5.readShort());
                                            i13 = readUnsignedShort3;
                                            i14 = readInt9;
                                            i15 = readUnsignedShort4;
                                            byteBuffer = byteBuffer2;
                                            i16 = i4;
                                            list2 = list;
                                            i46 += readInt10;
                                            i5 = i47;
                                            drmInitData2 = drmInitData3;
                                            str9 = str12;
                                            readInt9 = i14;
                                            i4 = i16;
                                            readUnsignedShort4 = i15;
                                            readUnsignedShort3 = i13;
                                        } else if (readInt11 == 1835295606) {
                                            if (byteBuffer == null) {
                                                byteBuffer = ByteBuffer.allocate(25).order(ByteOrder.LITTLE_ENDIAN);
                                            }
                                            ByteBuffer byteBuffer3 = byteBuffer;
                                            short readShort = parsableByteArray5.readShort();
                                            short readShort2 = parsableByteArray5.readShort();
                                            i14 = readInt9;
                                            short readShort3 = parsableByteArray5.readShort();
                                            i16 = i4;
                                            short readShort4 = parsableByteArray5.readShort();
                                            int i48 = i42;
                                            short readShort5 = parsableByteArray5.readShort();
                                            byte[] bArr4 = bArr3;
                                            short readShort6 = parsableByteArray5.readShort();
                                            float f3 = f2;
                                            short readShort7 = parsableByteArray5.readShort();
                                            i15 = readUnsignedShort4;
                                            short readShort8 = parsableByteArray5.readShort();
                                            long readUnsignedInt3 = parsableByteArray5.readUnsignedInt();
                                            long readUnsignedInt4 = parsableByteArray5.readUnsignedInt();
                                            i13 = readUnsignedShort3;
                                            byteBuffer3.position(1);
                                            byteBuffer3.putShort(readShort5);
                                            byteBuffer3.putShort(readShort6);
                                            byteBuffer3.putShort(readShort);
                                            byteBuffer3.putShort(readShort2);
                                            byteBuffer3.putShort(readShort3);
                                            byteBuffer3.putShort(readShort4);
                                            byteBuffer3.putShort(readShort7);
                                            byteBuffer3.putShort(readShort8);
                                            byteBuffer3.putShort((short) (readUnsignedInt3 / 10000));
                                            byteBuffer3.putShort((short) (readUnsignedInt4 / 10000));
                                            byteBuffer = byteBuffer3;
                                            list2 = list;
                                            i42 = i48;
                                            bArr3 = bArr4;
                                            f2 = f3;
                                            i46 += readInt10;
                                            i5 = i47;
                                            drmInitData2 = drmInitData3;
                                            str9 = str12;
                                            readInt9 = i14;
                                            i4 = i16;
                                            readUnsignedShort4 = i15;
                                            readUnsignedShort3 = i13;
                                        } else {
                                            i13 = readUnsignedShort3;
                                            i14 = readInt9;
                                            i15 = readUnsignedShort4;
                                            i16 = i4;
                                            i17 = i42;
                                            bArr = bArr3;
                                            f = f2;
                                            if (readInt11 == 1681012275) {
                                                ExtractorUtil.checkContainerInput(str10 == null, null);
                                                str10 = MimeTypes.VIDEO_H263;
                                                list2 = list;
                                                i42 = i17;
                                                bArr3 = bArr;
                                                f2 = f;
                                                i46 += readInt10;
                                                i5 = i47;
                                                drmInitData2 = drmInitData3;
                                                str9 = str12;
                                                readInt9 = i14;
                                                i4 = i16;
                                                readUnsignedShort4 = i15;
                                                readUnsignedShort3 = i13;
                                            } else {
                                                if (readInt11 == 1702061171) {
                                                    ExtractorUtil.checkContainerInput(str10 == null, null);
                                                    C1543mc m7019a = m7019a(position5, parsableByteArray5);
                                                    byte[] bArr5 = m7019a.f22890b;
                                                    list2 = bArr5 != null ? ImmutableList.m3903of(bArr5) : list;
                                                    c1543mc = m7019a;
                                                    str10 = m7019a.f22889a;
                                                    i42 = i17;
                                                    bArr3 = bArr;
                                                } else if (readInt11 == 1885434736) {
                                                    parsableByteArray5.setPosition(position5 + 8);
                                                    f2 = parsableByteArray5.readUnsignedIntToInt() / parsableByteArray5.readUnsignedIntToInt();
                                                    list2 = list;
                                                    i42 = i17;
                                                    bArr3 = bArr;
                                                    z5 = true;
                                                    i46 += readInt10;
                                                    i5 = i47;
                                                    drmInitData2 = drmInitData3;
                                                    str9 = str12;
                                                    readInt9 = i14;
                                                    i4 = i16;
                                                    readUnsignedShort4 = i15;
                                                    readUnsignedShort3 = i13;
                                                } else if (readInt11 == 1937126244) {
                                                    int i49 = position5 + 8;
                                                    while (true) {
                                                        if (i49 - position5 >= readInt10) {
                                                            bArr2 = null;
                                                            break;
                                                        }
                                                        parsableByteArray5.setPosition(i49);
                                                        int readInt12 = parsableByteArray5.readInt();
                                                        if (parsableByteArray5.readInt() == 1886547818) {
                                                            bArr2 = Arrays.copyOfRange(parsableByteArray5.getData(), i49, readInt12 + i49);
                                                            break;
                                                        }
                                                        i49 += readInt12;
                                                    }
                                                    bArr3 = bArr2;
                                                    list2 = list;
                                                    i42 = i17;
                                                } else if (readInt11 == 1936995172) {
                                                    int readUnsignedByte = parsableByteArray5.readUnsignedByte();
                                                    parsableByteArray5.skipBytes(3);
                                                    if (readUnsignedByte == 0) {
                                                        int readUnsignedByte2 = parsableByteArray5.readUnsignedByte();
                                                        if (readUnsignedByte2 == 0) {
                                                            i17 = 0;
                                                        } else if (readUnsignedByte2 == 1) {
                                                            i17 = 1;
                                                        } else if (readUnsignedByte2 == 2) {
                                                            i17 = 2;
                                                        } else if (readUnsignedByte2 == 3) {
                                                            i17 = 3;
                                                        }
                                                    }
                                                } else if (readInt11 == 1668246642) {
                                                    int readInt13 = parsableByteArray5.readInt();
                                                    if (readInt13 == 1852009592 || readInt13 == 1852009571) {
                                                        int readUnsignedShort5 = parsableByteArray5.readUnsignedShort();
                                                        int readUnsignedShort6 = parsableByteArray5.readUnsignedShort();
                                                        parsableByteArray5.skipBytes(2);
                                                        boolean z6 = readInt10 == 19 && (parsableByteArray5.readUnsignedByte() & 128) != 0;
                                                        int isoColorPrimariesToColorSpace = ColorInfo.isoColorPrimariesToColorSpace(readUnsignedShort5);
                                                        int i50 = z6 ? 1 : 2;
                                                        i45 = isoColorPrimariesToColorSpace;
                                                        i43 = ColorInfo.isoTransferCharacteristicsToColorTransfer(readUnsignedShort6);
                                                        i44 = i50;
                                                    } else {
                                                        Log.m3027w("AtomParsers", "Unsupported color type: " + AbstractC1386kc.m5517a(readInt13));
                                                    }
                                                }
                                                f2 = f;
                                                i46 += readInt10;
                                                i5 = i47;
                                                drmInitData2 = drmInitData3;
                                                str9 = str12;
                                                readInt9 = i14;
                                                i4 = i16;
                                                readUnsignedShort4 = i15;
                                                readUnsignedShort3 = i13;
                                            }
                                        }
                                        i13 = readUnsignedShort3;
                                        i14 = readInt9;
                                        i15 = readUnsignedShort4;
                                        i16 = i4;
                                        list2 = list;
                                        i46 += readInt10;
                                        i5 = i47;
                                        drmInitData2 = drmInitData3;
                                        str9 = str12;
                                        readInt9 = i14;
                                        i4 = i16;
                                        readUnsignedShort4 = i15;
                                        readUnsignedShort3 = i13;
                                    }
                                    list2 = list;
                                    i42 = i17;
                                    bArr3 = bArr;
                                    f2 = f;
                                    i46 += readInt10;
                                    i5 = i47;
                                    drmInitData2 = drmInitData3;
                                    str9 = str12;
                                    readInt9 = i14;
                                    i4 = i16;
                                    readUnsignedShort4 = i15;
                                    readUnsignedShort3 = i13;
                                }
                                str11 = str3;
                                i13 = readUnsignedShort3;
                                i14 = readInt9;
                                i15 = readUnsignedShort4;
                                i41 = i18;
                                i16 = i4;
                                str10 = str4;
                                i46 += readInt10;
                                i5 = i47;
                                drmInitData2 = drmInitData3;
                                str9 = str12;
                                readInt9 = i14;
                                i4 = i16;
                                readUnsignedShort4 = i15;
                                readUnsignedShort3 = i13;
                            }
                            byte[] bArr6 = bArr3;
                            float f4 = f2;
                            if (str10 == null) {
                                i34 = i40;
                                format2 = format3;
                            } else {
                                i34 = i40;
                                Format.Builder drmInitData6 = new Format.Builder().setId(readInt2).setSampleMimeType(str10).setCodecs(str11).setWidth(i6).setHeight(i7).setPixelWidthHeightRatio(f4).setRotationDegrees(i34).setProjectionData(bArr6).setStereoMode(i10).setInitializationData(list).setDrmInitData(drmInitData3);
                                int i51 = i45;
                                if (i51 == -1) {
                                    i12 = i44;
                                    i11 = i43;
                                    if (i12 == -1) {
                                        if (i11 == -1) {
                                        }
                                    }
                                } else {
                                    i11 = i43;
                                    i12 = i44;
                                }
                                drmInitData6.setColorInfo(new ColorInfo(i51, i12, i11, byteBuffer != null ? byteBuffer.array() : null));
                                if (c1543mc != null) {
                                    C1543mc c1543mc2 = c1543mc;
                                    drmInitData6.setAverageBitrate(Ints.saturatedCast(c1543mc2.f22891c)).setPeakBitrate(Ints.saturatedCast(c1543mc2.f22892d));
                                }
                                format2 = drmInitData6.build();
                            }
                            i37 = i41;
                        } else {
                            i3 = i31;
                            if (readInt9 == 1836069985 || readInt9 == 1701733217 || readInt9 == 1633889587 || readInt9 == 1700998451 || readInt9 == 1633889588 || readInt9 == 1835823201 || readInt9 == 1685353315 || readInt9 == 1685353317 || readInt9 == 1685353320 || readInt9 == 1685353324 || readInt9 == 1685353336 || readInt9 == 1935764850 || readInt9 == 1935767394 || readInt9 == 1819304813 || readInt9 == 1936684916 || readInt9 == 1953984371 || readInt9 == 778924082 || readInt9 == 778924083 || readInt9 == 1835557169 || readInt9 == 1835560241 || readInt9 == 1634492771 || readInt9 == 1634492791 || readInt9 == 1970037111 || readInt9 == 1332770163 || readInt9 == 1716281667) {
                                parsableByteArray5.setPosition(position3 + 16);
                                if (z2) {
                                    int readUnsignedShort7 = parsableByteArray5.readUnsignedShort();
                                    parsableByteArray5.skipBytes(6);
                                    i19 = readUnsignedShort7;
                                } else {
                                    parsableByteArray5.skipBytes(8);
                                    i19 = 0;
                                }
                                if (i19 == 0 || i19 == 1) {
                                    pair2 = create2;
                                    readUnsignedShort = parsableByteArray5.readUnsignedShort();
                                    parsableByteArray5.skipBytes(6);
                                    int readUnsignedFixedPoint1616 = parsableByteArray5.readUnsignedFixedPoint1616();
                                    parsableByteArray5.setPosition(parsableByteArray5.getPosition() - 4);
                                    int readInt14 = parsableByteArray5.readInt();
                                    if (i19 == 1) {
                                        parsableByteArray5.skipBytes(16);
                                    }
                                    i20 = readInt14;
                                    i21 = readUnsignedFixedPoint1616;
                                } else if (i19 == 2) {
                                    parsableByteArray5.skipBytes(16);
                                    pair2 = create2;
                                    int round = (int) Math.round(parsableByteArray5.readDouble());
                                    int readUnsignedIntToInt = parsableByteArray5.readUnsignedIntToInt();
                                    i21 = round;
                                    parsableByteArray5.skipBytes(20);
                                    readUnsignedShort = readUnsignedIntToInt;
                                    i20 = 0;
                                } else {
                                    i2 = i35;
                                    i24 = i34;
                                    i23 = readInt8;
                                    c1301ic2 = c1301ic4;
                                    pair = create2;
                                    i22 = position3;
                                    trackEncryptionBoxArr = trackEncryptionBoxArr2;
                                    str2 = str7;
                                    i34 = i24;
                                    i9 = i23;
                                    i8 = i22;
                                }
                                int position6 = parsableByteArray5.getPosition();
                                pair = pair2;
                                if (readInt9 == 1701733217) {
                                    Pair m7021c2 = m7021c(parsableByteArray5, position3, readInt8);
                                    if (m7021c2 != null) {
                                        int intValue = ((Integer) m7021c2.first).intValue();
                                        if (drmInitData5 == null) {
                                            i29 = intValue;
                                            copyWithSchemeType = null;
                                        } else {
                                            i29 = intValue;
                                            copyWithSchemeType = drmInitData5.copyWithSchemeType(((TrackEncryptionBox) m7021c2.second).schemeType);
                                        }
                                        trackEncryptionBoxArr2[i35] = (TrackEncryptionBox) m7021c2.second;
                                        drmInitData4 = copyWithSchemeType;
                                        readInt9 = i29;
                                    } else {
                                        drmInitData4 = drmInitData5;
                                    }
                                    parsableByteArray5.setPosition(position6);
                                } else {
                                    drmInitData4 = drmInitData5;
                                }
                                if (readInt9 == 1633889587) {
                                    str5 = MimeTypes.AUDIO_AC3;
                                } else if (readInt9 == 1700998451) {
                                    str5 = MimeTypes.AUDIO_E_AC3;
                                } else if (readInt9 == 1633889588) {
                                    str5 = MimeTypes.AUDIO_AC4;
                                } else if (readInt9 == 1685353315) {
                                    str5 = MimeTypes.AUDIO_DTS;
                                } else if (readInt9 == 1685353320 || readInt9 == 1685353324) {
                                    str5 = MimeTypes.AUDIO_DTS_HD;
                                } else if (readInt9 == 1685353317) {
                                    str5 = MimeTypes.AUDIO_DTS_EXPRESS;
                                } else if (readInt9 == 1685353336) {
                                    str5 = MimeTypes.AUDIO_DTS_X;
                                } else if (readInt9 == 1935764850) {
                                    str5 = MimeTypes.AUDIO_AMR_NB;
                                } else if (readInt9 == 1935767394) {
                                    str5 = MimeTypes.AUDIO_AMR_WB;
                                } else {
                                    if (readInt9 == 1819304813 || readInt9 == 1936684916) {
                                        str5 = MimeTypes.AUDIO_RAW;
                                        i25 = 2;
                                    } else if (readInt9 == 1953984371) {
                                        i25 = 268435456;
                                        str5 = MimeTypes.AUDIO_RAW;
                                    } else if (readInt9 == 778924082 || readInt9 == 778924083) {
                                        str5 = MimeTypes.AUDIO_MPEG;
                                    } else if (readInt9 == 1835557169) {
                                        str5 = MimeTypes.AUDIO_MPEGH_MHA1;
                                    } else if (readInt9 == 1835560241) {
                                        str5 = MimeTypes.AUDIO_MPEGH_MHM1;
                                    } else if (readInt9 == 1634492771) {
                                        str5 = MimeTypes.AUDIO_ALAC;
                                    } else if (readInt9 == 1634492791) {
                                        str5 = MimeTypes.AUDIO_ALAW;
                                    } else if (readInt9 == 1970037111) {
                                        str5 = MimeTypes.AUDIO_MLAW;
                                    } else if (readInt9 == 1332770163) {
                                        str5 = MimeTypes.AUDIO_OPUS;
                                    } else if (readInt9 == 1716281667) {
                                        str5 = MimeTypes.AUDIO_FLAC;
                                    } else {
                                        str5 = readInt9 == 1835823201 ? MimeTypes.AUDIO_TRUEHD : null;
                                    }
                                    i2 = i35;
                                    i24 = i34;
                                    c1301ic2 = c1301ic4;
                                    trackEncryptionBoxArr = trackEncryptionBoxArr2;
                                    format = format2;
                                    int i52 = i21;
                                    i26 = position6;
                                    int i53 = readUnsignedShort;
                                    List<byte[]> list3 = null;
                                    String str13 = null;
                                    C1543mc c1543mc3 = null;
                                    while (i26 - position3 < readInt8) {
                                        parsableByteArray5.setPosition(i26);
                                        int readInt15 = parsableByteArray5.readInt();
                                        int i54 = readInt8;
                                        ExtractorUtil.checkContainerInput(readInt15 > 0, str8);
                                        int readInt16 = parsableByteArray5.readInt();
                                        int i55 = position3;
                                        if (readInt16 == 1835557187) {
                                            int i56 = readInt15 - 13;
                                            byte[] bArr7 = new byte[i56];
                                            parsableByteArray5.setPosition(i26 + 13);
                                            parsableByteArray5.readBytes(bArr7, 0, i56);
                                            list3 = ImmutableList.m3903of(bArr7);
                                            str6 = str8;
                                            i27 = i20;
                                        } else {
                                            if (readInt16 == 1702061171) {
                                                i27 = i20;
                                                z3 = false;
                                                i28 = 1702061171;
                                            } else if (z2 && readInt16 == 2002876005) {
                                                i27 = i20;
                                                i28 = 1702061171;
                                                z3 = false;
                                            } else {
                                                if (readInt16 == 1684103987) {
                                                    parsableByteArray5.setPosition(i26 + 8);
                                                    format = Ac3Util.parseAc3AnnexFFormat(parsableByteArray5, Integer.toString(readInt2), str7, drmInitData4);
                                                } else if (readInt16 == 1684366131) {
                                                    parsableByteArray5.setPosition(i26 + 8);
                                                    format = Ac3Util.parseEAc3AnnexFFormat(parsableByteArray5, Integer.toString(readInt2), str7, drmInitData4);
                                                } else if (readInt16 == 1684103988) {
                                                    parsableByteArray5.setPosition(i26 + 8);
                                                    format = Ac4Util.parseAc4AnnexEFormat(parsableByteArray5, Integer.toString(readInt2), str7, drmInitData4);
                                                } else if (readInt16 == 1684892784) {
                                                    if (i20 <= 0) {
                                                        throw ParserException.createForMalformedContainer("Invalid sample rate for Dolby TrueHD MLP stream: " + i20, null);
                                                    }
                                                    str6 = str8;
                                                    i52 = i20;
                                                    i27 = i52;
                                                    i53 = 2;
                                                } else if (readInt16 == 1684305011) {
                                                    format = new Format.Builder().setId(readInt2).setSampleMimeType(str5).setChannelCount(i53).setSampleRate(i52).setDrmInitData(drmInitData4).setLanguage(str7).build();
                                                } else {
                                                    if (readInt16 == 1682927731) {
                                                        int i57 = readInt15 - 8;
                                                        byte[] bArr8 = f25511a;
                                                        byte[] copyOf = Arrays.copyOf(bArr8, bArr8.length + i57);
                                                        i27 = i20;
                                                        parsableByteArray5.setPosition(i26 + 8);
                                                        parsableByteArray5.readBytes(copyOf, bArr8.length, i57);
                                                        list3 = OpusUtil.buildInitializationData(copyOf);
                                                    } else {
                                                        i27 = i20;
                                                        if (readInt16 == 1684425825) {
                                                            byte[] bArr9 = new byte[readInt15 - 8];
                                                            bArr9[0] = 102;
                                                            bArr9[1] = 76;
                                                            bArr9[2] = 97;
                                                            bArr9[3] = 67;
                                                            parsableByteArray5.setPosition(i26 + 12);
                                                            parsableByteArray5.readBytes(bArr9, 4, readInt15 - 12);
                                                            list3 = ImmutableList.m3903of(bArr9);
                                                        } else if (readInt16 == 1634492771) {
                                                            int i58 = readInt15 - 12;
                                                            byte[] bArr10 = new byte[i58];
                                                            parsableByteArray5.setPosition(i26 + 12);
                                                            parsableByteArray5.readBytes(bArr10, 0, i58);
                                                            Pair<Integer, Integer> parseAlacAudioSpecificConfig = CodecSpecificDataUtil.parseAlacAudioSpecificConfig(bArr10);
                                                            i52 = ((Integer) parseAlacAudioSpecificConfig.first).intValue();
                                                            int intValue2 = ((Integer) parseAlacAudioSpecificConfig.second).intValue();
                                                            ImmutableList m3903of = ImmutableList.m3903of(bArr10);
                                                            str6 = str8;
                                                            i53 = intValue2;
                                                            list3 = m3903of;
                                                            i26 += readInt15;
                                                            i20 = i27;
                                                            readInt8 = i54;
                                                            position3 = i55;
                                                            str8 = str6;
                                                        } else {
                                                            z4 = false;
                                                            str6 = str8;
                                                            i26 += readInt15;
                                                            i20 = i27;
                                                            readInt8 = i54;
                                                            position3 = i55;
                                                            str8 = str6;
                                                        }
                                                    }
                                                    str6 = str8;
                                                }
                                                i27 = i20;
                                                z4 = false;
                                                str6 = str8;
                                                i26 += readInt15;
                                                i20 = i27;
                                                readInt8 = i54;
                                                position3 = i55;
                                                str8 = str6;
                                            }
                                            if (readInt16 != i28) {
                                                position = parsableByteArray5.getPosition();
                                                ExtractorUtil.checkContainerInput(position >= i26 ? true : z3, null);
                                                while (true) {
                                                    if (position - i26 >= readInt15) {
                                                        str6 = str8;
                                                        position = -1;
                                                        break;
                                                    }
                                                    parsableByteArray5.setPosition(position);
                                                    int readInt17 = parsableByteArray5.readInt();
                                                    ExtractorUtil.checkContainerInput(readInt17 > 0 ? true : z3, str8);
                                                    str6 = str8;
                                                    if (parsableByteArray5.readInt() == 1702061171) {
                                                        break;
                                                    }
                                                    position += readInt17;
                                                    str8 = str6;
                                                }
                                            } else {
                                                str6 = str8;
                                                position = i26;
                                            }
                                            if (position != -1) {
                                                C1543mc m7019a2 = m7019a(position, parsableByteArray5);
                                                String str14 = m7019a2.f22889a;
                                                byte[] bArr11 = m7019a2.f22890b;
                                                if (bArr11 != null) {
                                                    if (MimeTypes.AUDIO_AAC.equals(str14)) {
                                                        AacUtil.Config parseAudioSpecificConfig = AacUtil.parseAudioSpecificConfig(bArr11);
                                                        i52 = parseAudioSpecificConfig.sampleRateHz;
                                                        i53 = parseAudioSpecificConfig.channelCount;
                                                        str13 = parseAudioSpecificConfig.codecs;
                                                    }
                                                    list3 = ImmutableList.m3903of(bArr11);
                                                }
                                                c1543mc3 = m7019a2;
                                                str5 = str14;
                                            }
                                            i26 += readInt15;
                                            i20 = i27;
                                            readInt8 = i54;
                                            position3 = i55;
                                            str8 = str6;
                                        }
                                        i26 += readInt15;
                                        i20 = i27;
                                        readInt8 = i54;
                                        position3 = i55;
                                        str8 = str6;
                                    }
                                    i23 = readInt8;
                                    i22 = position3;
                                    if (format == null || str5 == null) {
                                        format2 = format;
                                    } else {
                                        Format.Builder language = new Format.Builder().setId(readInt2).setSampleMimeType(str5).setCodecs(str13).setChannelCount(i53).setSampleRate(i52).setPcmEncoding(i25).setInitializationData(list3).setDrmInitData(drmInitData4).setLanguage(str7);
                                        if (c1543mc3 != null) {
                                            C1543mc c1543mc4 = c1543mc3;
                                            language.setAverageBitrate(Ints.saturatedCast(c1543mc4.f22891c)).setPeakBitrate(Ints.saturatedCast(c1543mc4.f22892d));
                                        }
                                        format2 = language.build();
                                    }
                                    str2 = str7;
                                    i34 = i24;
                                    i9 = i23;
                                    i8 = i22;
                                }
                                i25 = -1;
                                i2 = i35;
                                i24 = i34;
                                c1301ic2 = c1301ic4;
                                trackEncryptionBoxArr = trackEncryptionBoxArr2;
                                format = format2;
                                int i522 = i21;
                                i26 = position6;
                                int i532 = readUnsignedShort;
                                List<byte[]> list32 = null;
                                String str132 = null;
                                C1543mc c1543mc32 = null;
                                while (i26 - position3 < readInt8) {
                                }
                                i23 = readInt8;
                                i22 = position3;
                                if (format == null) {
                                }
                                format2 = format;
                                str2 = str7;
                                i34 = i24;
                                i9 = i23;
                                i8 = i22;
                            } else {
                                if (readInt9 == 1414810956 || readInt9 == 1954034535 || readInt9 == 2004251764 || readInt9 == 1937010800 || readInt9 == 1664495672) {
                                    parsableByteArray5.setPosition(position3 + 16);
                                    String str15 = MimeTypes.APPLICATION_TTML;
                                    if (readInt9 != 1414810956) {
                                        if (readInt9 == 1954034535) {
                                            int i59 = readInt8 - 16;
                                            byte[] bArr12 = new byte[i59];
                                            parsableByteArray5.readBytes(bArr12, 0, i59);
                                            immutableList = ImmutableList.m3903of(bArr12);
                                            str15 = MimeTypes.APPLICATION_TX3G;
                                            j4 = Long.MAX_VALUE;
                                        } else if (readInt9 == 2004251764) {
                                            str15 = MimeTypes.APPLICATION_MP4VTT;
                                        } else if (readInt9 == 1937010800) {
                                            j4 = 0;
                                            immutableList = null;
                                        } else if (readInt9 == 1664495672) {
                                            str15 = MimeTypes.APPLICATION_MP4CEA608;
                                            j4 = Long.MAX_VALUE;
                                            immutableList = null;
                                            i36 = 1;
                                        } else {
                                            throw new IllegalStateException();
                                        }
                                        format2 = new Format.Builder().setId(readInt2).setSampleMimeType(str15).setLanguage(str7).setSubsampleOffsetUs(j4).setInitializationData(immutableList).build();
                                    }
                                    j4 = Long.MAX_VALUE;
                                    immutableList = null;
                                    format2 = new Format.Builder().setId(readInt2).setSampleMimeType(str15).setLanguage(str7).setSubsampleOffsetUs(j4).setInitializationData(immutableList).build();
                                } else if (readInt9 == 1835365492) {
                                    parsableByteArray5.setPosition(position3 + 16);
                                    if (readInt9 == 1835365492) {
                                        parsableByteArray5.readNullTerminatedString();
                                        String readNullTerminatedString = parsableByteArray5.readNullTerminatedString();
                                        if (readNullTerminatedString != null) {
                                            format2 = new Format.Builder().setId(readInt2).setSampleMimeType(readNullTerminatedString).build();
                                        }
                                    }
                                } else if (readInt9 == 1667329389) {
                                    format2 = new Format.Builder().setId(readInt2).setSampleMimeType(MimeTypes.APPLICATION_CAMERA_MOTION).build();
                                }
                                i2 = i35;
                                i9 = readInt8;
                                c1301ic2 = c1301ic4;
                                pair = create2;
                                str2 = str7;
                                i8 = position3;
                                trackEncryptionBoxArr = trackEncryptionBoxArr2;
                            }
                        }
                        parsableByteArray5.setPosition(i8 + i9);
                        i35 = i2 + 1;
                        drmInitData5 = drmInitData;
                        readInt7 = i38;
                        i30 = i39;
                        arrayList2 = arrayList4;
                        readUnsignedInt = j6;
                        c1301ic4 = c1301ic2;
                        str7 = str2;
                        trackEncryptionBoxArr2 = trackEncryptionBoxArr;
                        i31 = i3;
                        create2 = pair;
                    }
                    arrayList = arrayList2;
                    i = i30;
                    C1301ic c1301ic7 = c1301ic4;
                    long j7 = readUnsignedInt;
                    Pair pair3 = create2;
                    int i60 = i31;
                    TrackEncryptionBox[] trackEncryptionBoxArr3 = trackEncryptionBoxArr2;
                    Format format4 = format2;
                    if (z) {
                        c1301ic4 = c1301ic7;
                    } else {
                        c1301ic4 = c1301ic7;
                        C1301ic m5206c = c1301ic4.m5206c(1701082227);
                        if (m5206c != null) {
                            C1349jc m5207d = m5206c.m5207d(1701606260);
                            if (m5207d == null) {
                                create = null;
                            } else {
                                ParsableByteArray parsableByteArray6 = m5207d.f20458b;
                                parsableByteArray6.setPosition(8);
                                int m5518b3 = AbstractC1386kc.m5518b(parsableByteArray6.readInt());
                                int readUnsignedIntToInt2 = parsableByteArray6.readUnsignedIntToInt();
                                long[] jArr3 = new long[readUnsignedIntToInt2];
                                long[] jArr4 = new long[readUnsignedIntToInt2];
                                for (int i61 = 0; i61 < readUnsignedIntToInt2; i61++) {
                                    jArr3[i61] = m5518b3 == 1 ? parsableByteArray6.readUnsignedLongToLong() : parsableByteArray6.readUnsignedInt();
                                    jArr4[i61] = m5518b3 == 1 ? parsableByteArray6.readLong() : parsableByteArray6.readInt();
                                    if (parsableByteArray6.readShort() == 1) {
                                        parsableByteArray6.skipBytes(2);
                                    } else {
                                        throw new IllegalArgumentException("Unsupported media rate.");
                                    }
                                }
                                create = Pair.create(jArr3, jArr4);
                            }
                            if (create != null) {
                                jArr = (long[]) create.first;
                                jArr2 = (long[]) create.second;
                                track = format4 != null ? null : new Track(readInt2, i60, ((Long) pair3.first).longValue(), j7, j2, format4, i36, trackEncryptionBoxArr3, i37, jArr, jArr2);
                                function2 = function;
                            }
                        }
                    }
                    jArr = null;
                    jArr2 = null;
                    if (format4 != null) {
                    }
                    function2 = function;
                }
                Track track2 = (Track) function2.apply(track);
                if (track2 == null) {
                    arrayList2 = arrayList;
                } else {
                    arrayList2 = arrayList;
                    arrayList2.add(m7022d(track2, (C1301ic) Assertions.checkNotNull(((C1301ic) Assertions.checkNotNull(((C1301ic) Assertions.checkNotNull(c1301ic4.m5206c(1835297121))).m5206c(1835626086))).m5206c(1937007212)), gaplessInfoHolder));
                }
            }
            i30 = i + 1;
            c1301ic3 = c1301ic;
            drmInitData5 = drmInitData;
        }
    }
}
