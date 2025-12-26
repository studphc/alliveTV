package com.google.android.exoplayer2.extractor.p002ts;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.BinarySearchSeeker;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.p002ts.TsPayloadReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p000.ax2;
import p000.bx2;
import p000.t82;
import p000.zw2;

/* loaded from: classes.dex */
public final class TsExtractor implements Extractor {
    public static final int DEFAULT_TIMESTAMP_SEARCH_BYTES = 112800;
    public static final ExtractorsFactory FACTORY = new t82(20);
    public static final int MODE_HLS = 2;
    public static final int MODE_MULTI_PMT = 0;
    public static final int MODE_SINGLE_PMT = 1;
    public static final int TS_PACKET_SIZE = 188;
    public static final int TS_STREAM_TYPE_AAC_ADTS = 15;
    public static final int TS_STREAM_TYPE_AAC_LATM = 17;
    public static final int TS_STREAM_TYPE_AC3 = 129;
    public static final int TS_STREAM_TYPE_AC4 = 172;
    public static final int TS_STREAM_TYPE_AIT = 257;
    public static final int TS_STREAM_TYPE_DC2_H262 = 128;
    public static final int TS_STREAM_TYPE_DTS = 138;
    public static final int TS_STREAM_TYPE_DVBSUBS = 89;
    public static final int TS_STREAM_TYPE_E_AC3 = 135;
    public static final int TS_STREAM_TYPE_H262 = 2;
    public static final int TS_STREAM_TYPE_H263 = 16;
    public static final int TS_STREAM_TYPE_H264 = 27;
    public static final int TS_STREAM_TYPE_H265 = 36;
    public static final int TS_STREAM_TYPE_HDMV_DTS = 130;
    public static final int TS_STREAM_TYPE_ID3 = 21;
    public static final int TS_STREAM_TYPE_MPA = 3;
    public static final int TS_STREAM_TYPE_MPA_LSF = 4;
    public static final int TS_STREAM_TYPE_SPLICE_INFO = 134;
    public static final int TS_SYNC_BYTE = 71;

    /* renamed from: a */
    public final int f10549a;

    /* renamed from: b */
    public final int f10550b;

    /* renamed from: c */
    public final List f10551c;

    /* renamed from: d */
    public final ParsableByteArray f10552d;

    /* renamed from: e */
    public final SparseIntArray f10553e;

    /* renamed from: f */
    public final TsPayloadReader.Factory f10554f;

    /* renamed from: g */
    public final SparseArray f10555g;

    /* renamed from: h */
    public final SparseBooleanArray f10556h;

    /* renamed from: i */
    public final SparseBooleanArray f10557i;

    /* renamed from: j */
    public final bx2 f10558j;

    /* renamed from: k */
    public ax2 f10559k;

    /* renamed from: l */
    public ExtractorOutput f10560l;

    /* renamed from: m */
    public int f10561m;

    /* renamed from: n */
    public boolean f10562n;

    /* renamed from: o */
    public boolean f10563o;

    /* renamed from: p */
    public boolean f10564p;

    /* renamed from: q */
    public TsPayloadReader f10565q;

    /* renamed from: r */
    public int f10566r;

    /* renamed from: s */
    public int f10567s;

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface Mode {
    }

    public TsExtractor() {
        this(0);
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput extractorOutput) {
        this.f10560l = extractorOutput;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r9v7, types: [com.google.android.exoplayer2.extractor.BinarySearchSeeker, ax2] */
    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) {
        ?? r4;
        ?? r3;
        int i;
        int i2;
        int i3;
        int i4;
        boolean z;
        int i5;
        boolean z2;
        long length = extractorInput.getLength();
        boolean z3 = this.f10562n;
        int i6 = this.f10549a;
        int i7 = 1;
        if (z3) {
            long j = C0643C.TIME_UNSET;
            bx2 bx2Var = this.f10558j;
            if (length != -1 && i6 != 2 && !bx2Var.f8182d) {
                int i8 = this.f10567s;
                if (i8 <= 0) {
                    bx2Var.m2174a(extractorInput);
                    return 0;
                }
                boolean z4 = bx2Var.f8184f;
                ParsableByteArray parsableByteArray = bx2Var.f8181c;
                int i9 = bx2Var.f8179a;
                if (!z4) {
                    long length2 = extractorInput.getLength();
                    int min = (int) Math.min(i9, length2);
                    long j2 = length2 - min;
                    if (extractorInput.getPosition() != j2) {
                        positionHolder.position = j2;
                    } else {
                        parsableByteArray.reset(min);
                        extractorInput.resetPeekPosition();
                        extractorInput.peekFully(parsableByteArray.getData(), 0, min);
                        int position = parsableByteArray.getPosition();
                        int limit = parsableByteArray.limit();
                        int i10 = limit - 188;
                        while (true) {
                            if (i10 < position) {
                                break;
                            }
                            if (TsUtil.isStartOfTsPacket(parsableByteArray.getData(), position, limit, i10)) {
                                long readPcrFromPacket = TsUtil.readPcrFromPacket(parsableByteArray, i10, i8);
                                if (readPcrFromPacket != C0643C.TIME_UNSET) {
                                    j = readPcrFromPacket;
                                    break;
                                }
                            }
                            i10--;
                        }
                        bx2Var.f8186h = j;
                        bx2Var.f8184f = true;
                        i7 = 0;
                    }
                } else {
                    if (bx2Var.f8186h == C0643C.TIME_UNSET) {
                        bx2Var.m2174a(extractorInput);
                        return 0;
                    }
                    if (!bx2Var.f8183e) {
                        int min2 = (int) Math.min(i9, extractorInput.getLength());
                        long j3 = 0;
                        if (extractorInput.getPosition() != j3) {
                            positionHolder.position = j3;
                        } else {
                            parsableByteArray.reset(min2);
                            extractorInput.resetPeekPosition();
                            extractorInput.peekFully(parsableByteArray.getData(), 0, min2);
                            int position2 = parsableByteArray.getPosition();
                            int limit2 = parsableByteArray.limit();
                            while (true) {
                                if (position2 >= limit2) {
                                    break;
                                }
                                if (parsableByteArray.getData()[position2] == 71) {
                                    long readPcrFromPacket2 = TsUtil.readPcrFromPacket(parsableByteArray, position2, i8);
                                    if (readPcrFromPacket2 != C0643C.TIME_UNSET) {
                                        j = readPcrFromPacket2;
                                        break;
                                    }
                                }
                                position2++;
                            }
                            bx2Var.f8185g = j;
                            bx2Var.f8183e = true;
                            i7 = 0;
                        }
                    } else {
                        long j4 = bx2Var.f8185g;
                        if (j4 == C0643C.TIME_UNSET) {
                            bx2Var.m2174a(extractorInput);
                            return 0;
                        }
                        TimestampAdjuster timestampAdjuster = bx2Var.f8180b;
                        long adjustTsTimestamp = timestampAdjuster.adjustTsTimestamp(bx2Var.f8186h) - timestampAdjuster.adjustTsTimestamp(j4);
                        bx2Var.f8187i = adjustTsTimestamp;
                        if (adjustTsTimestamp < 0) {
                            Log.m3027w("TsDurationReader", "Invalid duration: " + bx2Var.f8187i + ". Using TIME_UNSET instead.");
                            bx2Var.f8187i = C0643C.TIME_UNSET;
                        }
                        bx2Var.m2174a(extractorInput);
                        return 0;
                    }
                }
                return i7;
            }
            if (!this.f10563o) {
                this.f10563o = true;
                long j5 = bx2Var.f8187i;
                if (j5 != C0643C.TIME_UNSET) {
                    i = i6;
                    ?? binarySearchSeeker = new BinarySearchSeeker(new BinarySearchSeeker.DefaultSeekTimestampConverter(), new zw2(this.f10567s, bx2Var.f8180b, this.f10550b), j5, 0L, 1 + j5, 0L, length, 188L, 940);
                    this.f10559k = binarySearchSeeker;
                    this.f10560l.seekMap(binarySearchSeeker.getSeekMap());
                } else {
                    i = i6;
                    this.f10560l.seekMap(new SeekMap.Unseekable(j5));
                }
            } else {
                i = i6;
            }
            if (this.f10564p) {
                z2 = false;
                this.f10564p = false;
                seek(0L, 0L);
                if (extractorInput.getPosition() != 0) {
                    positionHolder.position = 0L;
                    return 1;
                }
            } else {
                z2 = false;
            }
            r4 = 1;
            r4 = 1;
            ax2 ax2Var = this.f10559k;
            r3 = z2;
            if (ax2Var != null) {
                r3 = z2;
                if (ax2Var.isSeeking()) {
                    return this.f10559k.handlePendingSeek(extractorInput, positionHolder);
                }
            }
        } else {
            r4 = 1;
            r3 = 0;
            i = i6;
        }
        ParsableByteArray parsableByteArray2 = this.f10552d;
        byte[] data = parsableByteArray2.getData();
        if (9400 - parsableByteArray2.getPosition() < 188) {
            int bytesLeft = parsableByteArray2.bytesLeft();
            if (bytesLeft > 0) {
                System.arraycopy(data, parsableByteArray2.getPosition(), data, r3, bytesLeft);
            }
            parsableByteArray2.reset(data, bytesLeft);
        }
        while (parsableByteArray2.bytesLeft() < 188) {
            int limit3 = parsableByteArray2.limit();
            int read = extractorInput.read(data, limit3, 9400 - limit3);
            if (read == -1) {
                return -1;
            }
            parsableByteArray2.setLimit(limit3 + read);
        }
        int position3 = parsableByteArray2.getPosition();
        int limit4 = parsableByteArray2.limit();
        int findSyncBytePosition = TsUtil.findSyncBytePosition(parsableByteArray2.getData(), position3, limit4);
        parsableByteArray2.setPosition(findSyncBytePosition);
        int i11 = findSyncBytePosition + TS_PACKET_SIZE;
        TsPayloadReader tsPayloadReader = null;
        if (i11 > limit4) {
            int i12 = (findSyncBytePosition - position3) + this.f10566r;
            this.f10566r = i12;
            i2 = i;
            i3 = 2;
            if (i2 == 2 && i12 > 376) {
                throw ParserException.createForMalformedContainer("Cannot find sync byte. Most likely not a Transport Stream.", null);
            }
        } else {
            i2 = i;
            i3 = 2;
            this.f10566r = r3;
        }
        int limit5 = parsableByteArray2.limit();
        if (i11 > limit5) {
            return r3;
        }
        int readInt = parsableByteArray2.readInt();
        if ((8388608 & readInt) != 0) {
            parsableByteArray2.setPosition(i11);
            return r3;
        }
        if ((4194304 & readInt) != 0) {
            i4 = r4;
        } else {
            i4 = r3;
        }
        int i13 = (2096896 & readInt) >> 8;
        if ((readInt & 32) != 0) {
            z = r4;
        } else {
            z = r3;
        }
        if ((readInt & 16) != 0) {
            tsPayloadReader = (TsPayloadReader) this.f10555g.get(i13);
        }
        if (tsPayloadReader == null) {
            parsableByteArray2.setPosition(i11);
            return r3;
        }
        if (i2 != i3) {
            int i14 = readInt & 15;
            SparseIntArray sparseIntArray = this.f10553e;
            int i15 = sparseIntArray.get(i13, i14 - 1);
            sparseIntArray.put(i13, i14);
            if (i15 == i14) {
                parsableByteArray2.setPosition(i11);
                return r3;
            }
            if (i14 != ((i15 + r4) & 15)) {
                tsPayloadReader.seek();
            }
        }
        if (z) {
            int readUnsignedByte = parsableByteArray2.readUnsignedByte();
            if ((parsableByteArray2.readUnsignedByte() & 64) != 0) {
                i5 = i3;
            } else {
                i5 = r3;
            }
            i4 |= i5;
            parsableByteArray2.skipBytes(readUnsignedByte - r4);
        }
        boolean z5 = this.f10562n;
        if (i2 == i3 || z5 || !this.f10557i.get(i13, r3)) {
            parsableByteArray2.setLimit(i11);
            tsPayloadReader.consume(parsableByteArray2, i4);
            parsableByteArray2.setLimit(limit5);
        }
        if (i2 != i3 && !z5 && this.f10562n && length != -1) {
            this.f10564p = r4;
        }
        parsableByteArray2.setPosition(i11);
        return r3;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j, long j2) {
        boolean z;
        ax2 ax2Var;
        boolean z2;
        if (this.f10549a != 2) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkState(z);
        List list = this.f10551c;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            TimestampAdjuster timestampAdjuster = (TimestampAdjuster) list.get(i);
            if (timestampAdjuster.getTimestampOffsetUs() == C0643C.TIME_UNSET) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                long firstSampleTimestampUs = timestampAdjuster.getFirstSampleTimestampUs();
                if (firstSampleTimestampUs != C0643C.TIME_UNSET && firstSampleTimestampUs != 0 && firstSampleTimestampUs != j2) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            }
            if (z2) {
                timestampAdjuster.reset(j2);
            }
        }
        if (j2 != 0 && (ax2Var = this.f10559k) != null) {
            ax2Var.setSeekTargetUs(j2);
        }
        this.f10552d.reset(0);
        this.f10553e.clear();
        int i2 = 0;
        while (true) {
            SparseArray sparseArray = this.f10555g;
            if (i2 < sparseArray.size()) {
                ((TsPayloadReader) sparseArray.valueAt(i2)).seek();
                i2++;
            } else {
                this.f10566r = 0;
                return;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001e, code lost:
    
        r1 = r1 + 1;
     */
    @Override // com.google.android.exoplayer2.extractor.Extractor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean sniff(ExtractorInput extractorInput) {
        byte[] data = this.f10552d.getData();
        extractorInput.peekFully(data, 0, 940);
        int i = 0;
        while (i < 188) {
            for (int i2 = 0; i2 < 5; i2++) {
                if (data[(i2 * TS_PACKET_SIZE) + i] != 71) {
                    break;
                }
            }
            extractorInput.skipFully(i);
            return true;
        }
        return false;
    }

    public TsExtractor(int i) {
        this(1, i, DEFAULT_TIMESTAMP_SEARCH_BYTES);
    }

    public TsExtractor(int i, int i2, int i3) {
        this(i, new TimestampAdjuster(0L), new DefaultTsPayloadReaderFactory(i2), i3);
    }

    public TsExtractor(int i, TimestampAdjuster timestampAdjuster, TsPayloadReader.Factory factory) {
        this(i, timestampAdjuster, factory, DEFAULT_TIMESTAMP_SEARCH_BYTES);
    }

    public TsExtractor(int i, TimestampAdjuster timestampAdjuster, TsPayloadReader.Factory factory, int i2) {
        TsPayloadReader.Factory factory2 = (TsPayloadReader.Factory) Assertions.checkNotNull(factory);
        this.f10554f = factory2;
        this.f10550b = i2;
        this.f10549a = i;
        if (i != 1 && i != 2) {
            ArrayList arrayList = new ArrayList();
            this.f10551c = arrayList;
            arrayList.add(timestampAdjuster);
        } else {
            this.f10551c = Collections.singletonList(timestampAdjuster);
        }
        this.f10552d = new ParsableByteArray(new byte[9400], 0);
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        this.f10556h = sparseBooleanArray;
        this.f10557i = new SparseBooleanArray();
        SparseArray sparseArray = new SparseArray();
        this.f10555g = sparseArray;
        this.f10553e = new SparseIntArray();
        this.f10558j = new bx2(i2);
        this.f10560l = ExtractorOutput.PLACEHOLDER;
        this.f10567s = -1;
        sparseBooleanArray.clear();
        sparseArray.clear();
        SparseArray<TsPayloadReader> createInitialPayloadReaders = factory2.createInitialPayloadReaders();
        int size = createInitialPayloadReaders.size();
        for (int i3 = 0; i3 < size; i3++) {
            sparseArray.put(createInitialPayloadReaders.keyAt(i3), createInitialPayloadReaders.valueAt(i3));
        }
        sparseArray.put(0, new SectionReader(new C0669a(this)));
        this.f10565q = null;
    }
}
