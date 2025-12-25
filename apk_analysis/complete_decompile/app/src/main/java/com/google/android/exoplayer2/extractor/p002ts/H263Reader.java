package com.google.android.exoplayer2.extractor.p002ts;

import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.p002ts.TsPayloadReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;
import java.util.Collections;
import p000.gr1;
import p000.sy0;
import p000.ty0;

/* loaded from: classes.dex */
public final class H263Reader implements ElementaryStreamReader {

    /* renamed from: l */
    public static final float[] f10435l = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 1.0f};

    /* renamed from: a */
    public final C0671c f10436a;

    /* renamed from: b */
    public final ParsableByteArray f10437b;

    /* renamed from: c */
    public final boolean[] f10438c;

    /* renamed from: d */
    public final sy0 f10439d;

    /* renamed from: e */
    public final gr1 f10440e;

    /* renamed from: f */
    public ty0 f10441f;

    /* renamed from: g */
    public long f10442g;

    /* renamed from: h */
    public String f10443h;

    /* renamed from: i */
    public TrackOutput f10444i;

    /* renamed from: j */
    public boolean f10445j;

    /* renamed from: k */
    public long f10446k;

    public H263Reader() {
        this(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0146  */
    @Override // com.google.android.exoplayer2.extractor.p002ts.ElementaryStreamReader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void consume(ParsableByteArray parsableByteArray) {
        int i;
        int i2;
        boolean z;
        ty0 ty0Var;
        boolean z2;
        boolean z3;
        long j;
        int i3;
        int i4;
        float f;
        Assertions.checkStateNotNull(this.f10441f);
        Assertions.checkStateNotNull(this.f10444i);
        int position = parsableByteArray.getPosition();
        int limit = parsableByteArray.limit();
        byte[] data = parsableByteArray.getData();
        this.f10442g += parsableByteArray.bytesLeft();
        this.f10444i.sampleData(parsableByteArray, parsableByteArray.bytesLeft());
        while (true) {
            int findNalUnit = NalUnitUtil.findNalUnit(data, position, limit, this.f10438c);
            sy0 sy0Var = this.f10439d;
            gr1 gr1Var = this.f10440e;
            if (findNalUnit == limit) {
                if (!this.f10445j) {
                    sy0Var.m7424a(data, position, limit);
                }
                this.f10441f.m7513a(data, position, limit);
                if (gr1Var != null) {
                    gr1Var.m4980a(data, position, limit);
                    return;
                }
                return;
            }
            int i5 = findNalUnit + 3;
            byte b = parsableByteArray.getData()[i5];
            int i6 = b & 255;
            int i7 = findNalUnit - position;
            if (!this.f10445j) {
                if (i7 > 0) {
                    sy0Var.m7424a(data, position, findNalUnit);
                }
                if (i7 < 0) {
                    i4 = -i7;
                } else {
                    i4 = 0;
                }
                int i8 = sy0Var.f26615b;
                if (i8 != 0) {
                    if (i8 != 1) {
                        if (i8 != 2) {
                            i2 = i5;
                            if (i8 != 3) {
                                if (i8 == 4) {
                                    if (i6 != 179 && i6 != 181) {
                                        i = limit;
                                    } else {
                                        sy0Var.f26616c -= i4;
                                        sy0Var.f26614a = false;
                                        TrackOutput trackOutput = this.f10444i;
                                        int i9 = sy0Var.f26617d;
                                        String str = (String) Assertions.checkNotNull(this.f10443h);
                                        byte[] copyOf = Arrays.copyOf(sy0Var.f26618e, sy0Var.f26616c);
                                        ParsableBitArray parsableBitArray = new ParsableBitArray(copyOf);
                                        parsableBitArray.skipBytes(i9);
                                        parsableBitArray.skipBytes(4);
                                        parsableBitArray.skipBit();
                                        parsableBitArray.skipBits(8);
                                        if (parsableBitArray.readBit()) {
                                            parsableBitArray.skipBits(4);
                                            parsableBitArray.skipBits(3);
                                        }
                                        int readBits = parsableBitArray.readBits(4);
                                        i = limit;
                                        if (readBits == 15) {
                                            int readBits2 = parsableBitArray.readBits(8);
                                            int readBits3 = parsableBitArray.readBits(8);
                                            if (readBits3 == 0) {
                                                Log.m3027w("H263Reader", "Invalid aspect ratio");
                                                f = 1.0f;
                                                if (parsableBitArray.readBit()) {
                                                    parsableBitArray.skipBits(2);
                                                    parsableBitArray.skipBits(1);
                                                    if (parsableBitArray.readBit()) {
                                                        parsableBitArray.skipBits(15);
                                                        parsableBitArray.skipBit();
                                                        parsableBitArray.skipBits(15);
                                                        parsableBitArray.skipBit();
                                                        parsableBitArray.skipBits(15);
                                                        parsableBitArray.skipBit();
                                                        parsableBitArray.skipBits(3);
                                                        parsableBitArray.skipBits(11);
                                                        parsableBitArray.skipBit();
                                                        parsableBitArray.skipBits(15);
                                                        parsableBitArray.skipBit();
                                                    }
                                                }
                                                if (parsableBitArray.readBits(2) != 0) {
                                                    Log.m3027w("H263Reader", "Unhandled video object layer shape");
                                                }
                                                parsableBitArray.skipBit();
                                                int readBits4 = parsableBitArray.readBits(16);
                                                parsableBitArray.skipBit();
                                                if (parsableBitArray.readBit()) {
                                                    if (readBits4 == 0) {
                                                        Log.m3027w("H263Reader", "Invalid vop_increment_time_resolution");
                                                    } else {
                                                        int i10 = 0;
                                                        for (int i11 = readBits4 - 1; i11 > 0; i11 >>= 1) {
                                                            i10++;
                                                        }
                                                        parsableBitArray.skipBits(i10);
                                                    }
                                                }
                                                parsableBitArray.skipBit();
                                                int readBits5 = parsableBitArray.readBits(13);
                                                parsableBitArray.skipBit();
                                                int readBits6 = parsableBitArray.readBits(13);
                                                parsableBitArray.skipBit();
                                                parsableBitArray.skipBit();
                                                trackOutput.format(new Format.Builder().setId(str).setSampleMimeType(MimeTypes.VIDEO_MP4V).setWidth(readBits5).setHeight(readBits6).setPixelWidthHeightRatio(f).setInitializationData(Collections.singletonList(copyOf)).build());
                                                this.f10445j = true;
                                            } else {
                                                f = readBits2 / readBits3;
                                                if (parsableBitArray.readBit()) {
                                                }
                                                if (parsableBitArray.readBits(2) != 0) {
                                                }
                                                parsableBitArray.skipBit();
                                                int readBits42 = parsableBitArray.readBits(16);
                                                parsableBitArray.skipBit();
                                                if (parsableBitArray.readBit()) {
                                                }
                                                parsableBitArray.skipBit();
                                                int readBits52 = parsableBitArray.readBits(13);
                                                parsableBitArray.skipBit();
                                                int readBits62 = parsableBitArray.readBits(13);
                                                parsableBitArray.skipBit();
                                                parsableBitArray.skipBit();
                                                trackOutput.format(new Format.Builder().setId(str).setSampleMimeType(MimeTypes.VIDEO_MP4V).setWidth(readBits52).setHeight(readBits62).setPixelWidthHeightRatio(f).setInitializationData(Collections.singletonList(copyOf)).build());
                                                this.f10445j = true;
                                            }
                                        } else if (readBits < 7) {
                                            f = f10435l[readBits];
                                            if (parsableBitArray.readBit()) {
                                            }
                                            if (parsableBitArray.readBits(2) != 0) {
                                            }
                                            parsableBitArray.skipBit();
                                            int readBits422 = parsableBitArray.readBits(16);
                                            parsableBitArray.skipBit();
                                            if (parsableBitArray.readBit()) {
                                            }
                                            parsableBitArray.skipBit();
                                            int readBits522 = parsableBitArray.readBits(13);
                                            parsableBitArray.skipBit();
                                            int readBits622 = parsableBitArray.readBits(13);
                                            parsableBitArray.skipBit();
                                            parsableBitArray.skipBit();
                                            trackOutput.format(new Format.Builder().setId(str).setSampleMimeType(MimeTypes.VIDEO_MP4V).setWidth(readBits522).setHeight(readBits622).setPixelWidthHeightRatio(f).setInitializationData(Collections.singletonList(copyOf)).build());
                                            this.f10445j = true;
                                        } else {
                                            Log.m3027w("H263Reader", "Invalid aspect ratio");
                                            f = 1.0f;
                                            if (parsableBitArray.readBit()) {
                                            }
                                            if (parsableBitArray.readBits(2) != 0) {
                                            }
                                            parsableBitArray.skipBit();
                                            int readBits4222 = parsableBitArray.readBits(16);
                                            parsableBitArray.skipBit();
                                            if (parsableBitArray.readBit()) {
                                            }
                                            parsableBitArray.skipBit();
                                            int readBits5222 = parsableBitArray.readBits(13);
                                            parsableBitArray.skipBit();
                                            int readBits6222 = parsableBitArray.readBits(13);
                                            parsableBitArray.skipBit();
                                            parsableBitArray.skipBit();
                                            trackOutput.format(new Format.Builder().setId(str).setSampleMimeType(MimeTypes.VIDEO_MP4V).setWidth(readBits5222).setHeight(readBits6222).setPixelWidthHeightRatio(f).setInitializationData(Collections.singletonList(copyOf)).build());
                                            this.f10445j = true;
                                        }
                                    }
                                } else {
                                    throw new IllegalStateException();
                                }
                            } else {
                                i = limit;
                                if ((b & 240) != 32) {
                                    Log.m3027w("H263Reader", "Unexpected start code value");
                                    sy0Var.f26614a = false;
                                    sy0Var.f26616c = 0;
                                    sy0Var.f26615b = 0;
                                } else {
                                    sy0Var.f26617d = sy0Var.f26616c;
                                    sy0Var.f26615b = 4;
                                }
                            }
                        } else {
                            i = limit;
                            i2 = i5;
                            if (i6 > 31) {
                                Log.m3027w("H263Reader", "Unexpected start code value");
                                sy0Var.f26614a = false;
                                sy0Var.f26616c = 0;
                                sy0Var.f26615b = 0;
                            } else {
                                sy0Var.f26615b = 3;
                            }
                        }
                    } else {
                        i = limit;
                        i2 = i5;
                        if (i6 != 181) {
                            Log.m3027w("H263Reader", "Unexpected start code value");
                            sy0Var.f26614a = false;
                            sy0Var.f26616c = 0;
                            sy0Var.f26615b = 0;
                        } else {
                            sy0Var.f26615b = 2;
                        }
                    }
                } else {
                    i = limit;
                    i2 = i5;
                    if (i6 == 176) {
                        sy0Var.f26615b = 1;
                        sy0Var.f26614a = true;
                    }
                }
                sy0Var.m7424a(sy0.f26613f, 0, 3);
            } else {
                i = limit;
                i2 = i5;
            }
            this.f10441f.m7513a(data, position, findNalUnit);
            if (gr1Var != null) {
                if (i7 > 0) {
                    gr1Var.m4980a(data, position, findNalUnit);
                    i3 = 0;
                } else {
                    i3 = -i7;
                }
                if (gr1Var.m4981b(i3)) {
                    int unescapeStream = NalUnitUtil.unescapeStream(gr1Var.f17812d, gr1Var.f17813e);
                    ParsableByteArray parsableByteArray2 = this.f10437b;
                    ((ParsableByteArray) Util.castNonNull(parsableByteArray2)).reset(gr1Var.f17812d, unescapeStream);
                    ((C0671c) Util.castNonNull(this.f10436a)).m2568a(this.f10446k, parsableByteArray2);
                }
                if (i6 == 178) {
                    z = true;
                    if (parsableByteArray.getData()[findNalUnit + 2] == 1) {
                        gr1Var.m4983d(i6);
                    }
                    int i12 = i - findNalUnit;
                    long j2 = this.f10442g - i12;
                    ty0Var = this.f10441f;
                    boolean z4 = this.f10445j;
                    if (ty0Var.f27021e == 182 && z4 && ty0Var.f27018b) {
                        j = ty0Var.f27024h;
                        if (j != C0643C.TIME_UNSET) {
                            ty0Var.f27017a.sampleMetadata(j, ty0Var.f27020d ? 1 : 0, (int) (j2 - ty0Var.f27023g), i12, null);
                        }
                    }
                    if (ty0Var.f27021e != 179) {
                        ty0Var.f27023g = j2;
                    }
                    ty0 ty0Var2 = this.f10441f;
                    long j3 = this.f10446k;
                    ty0Var2.f27021e = i6;
                    ty0Var2.f27020d = false;
                    if (i6 == 182 && i6 != 179) {
                        z2 = false;
                    } else {
                        z2 = z;
                    }
                    ty0Var2.f27018b = z2;
                    if (i6 != 182) {
                        z3 = z;
                    } else {
                        z3 = false;
                    }
                    ty0Var2.f27019c = z3;
                    ty0Var2.f27022f = 0;
                    ty0Var2.f27024h = j3;
                    position = i2;
                    limit = i;
                }
            }
            z = true;
            int i122 = i - findNalUnit;
            long j22 = this.f10442g - i122;
            ty0Var = this.f10441f;
            boolean z42 = this.f10445j;
            if (ty0Var.f27021e == 182) {
                j = ty0Var.f27024h;
                if (j != C0643C.TIME_UNSET) {
                }
            }
            if (ty0Var.f27021e != 179) {
            }
            ty0 ty0Var22 = this.f10441f;
            long j32 = this.f10446k;
            ty0Var22.f27021e = i6;
            ty0Var22.f27020d = false;
            if (i6 == 182) {
            }
            z2 = z;
            ty0Var22.f27018b = z2;
            if (i6 != 182) {
            }
            ty0Var22.f27019c = z3;
            ty0Var22.f27022f = 0;
            ty0Var22.f27024h = j32;
            position = i2;
            limit = i;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.p002ts.ElementaryStreamReader
    public void createTracks(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.generateNewId();
        this.f10443h = trackIdGenerator.getFormatId();
        TrackOutput track = extractorOutput.track(trackIdGenerator.getTrackId(), 2);
        this.f10444i = track;
        this.f10441f = new ty0(track);
        C0671c c0671c = this.f10436a;
        if (c0671c != null) {
            c0671c.m2569b(extractorOutput, trackIdGenerator);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.p002ts.ElementaryStreamReader
    public void packetFinished() {
    }

    @Override // com.google.android.exoplayer2.extractor.p002ts.ElementaryStreamReader
    public void packetStarted(long j, int i) {
        if (j != C0643C.TIME_UNSET) {
            this.f10446k = j;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.p002ts.ElementaryStreamReader
    public void seek() {
        NalUnitUtil.clearPrefixFlags(this.f10438c);
        sy0 sy0Var = this.f10439d;
        sy0Var.f26614a = false;
        sy0Var.f26616c = 0;
        sy0Var.f26615b = 0;
        ty0 ty0Var = this.f10441f;
        if (ty0Var != null) {
            ty0Var.f27018b = false;
            ty0Var.f27019c = false;
            ty0Var.f27020d = false;
            ty0Var.f27021e = -1;
        }
        gr1 gr1Var = this.f10440e;
        if (gr1Var != null) {
            gr1Var.m4982c();
        }
        this.f10442g = 0L;
        this.f10446k = C0643C.TIME_UNSET;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, sy0] */
    public H263Reader(C0671c c0671c) {
        this.f10436a = c0671c;
        this.f10438c = new boolean[4];
        ?? obj = new Object();
        obj.f26618e = new byte[128];
        this.f10439d = obj;
        this.f10446k = C0643C.TIME_UNSET;
        if (c0671c != null) {
            this.f10440e = new gr1(178);
            this.f10437b = new ParsableByteArray();
        } else {
            this.f10440e = null;
            this.f10437b = null;
        }
    }
}
