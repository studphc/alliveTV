package com.google.android.exoplayer2.extractor.avi;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.DummyExtractorOutput;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.UnmodifiableIterator;
import java.util.ArrayList;
import java.util.Arrays;
import p000.C0015ae;
import p000.C0554be;
import p000.C1556mp;
import p000.C2016yd;
import p000.C2053zd;
import p000.InterfaceC1979xd;
import p000.ao2;
import p000.i91;
import p000.zn2;

/* loaded from: classes.dex */
public final class AviExtractor implements Extractor {
    public static final int FOURCC_AVI_ = 541677121;
    public static final int FOURCC_JUNK = 1263424842;
    public static final int FOURCC_LIST = 1414744396;
    public static final int FOURCC_RIFF = 1179011410;
    public static final int FOURCC_auds = 1935963489;
    public static final int FOURCC_avih = 1751742049;
    public static final int FOURCC_hdrl = 1819436136;
    public static final int FOURCC_idx1 = 829973609;
    public static final int FOURCC_movi = 1769369453;
    public static final int FOURCC_strf = 1718776947;
    public static final int FOURCC_strh = 1752331379;
    public static final int FOURCC_strl = 1819440243;
    public static final int FOURCC_strn = 1852994675;
    public static final int FOURCC_txts = 1937012852;
    public static final int FOURCC_vids = 1935960438;

    /* renamed from: c */
    public int f10132c;

    /* renamed from: e */
    public C0015ae f10134e;

    /* renamed from: h */
    public long f10137h;

    /* renamed from: i */
    public C1556mp f10138i;

    /* renamed from: m */
    public int f10142m;

    /* renamed from: n */
    public boolean f10143n;

    /* renamed from: a */
    public final ParsableByteArray f10130a = new ParsableByteArray(12);

    /* renamed from: b */
    public final C2053zd f10131b = new Object();

    /* renamed from: d */
    public ExtractorOutput f10133d = new DummyExtractorOutput();

    /* renamed from: g */
    public C1556mp[] f10136g = new C1556mp[0];

    /* renamed from: k */
    public long f10140k = -1;

    /* renamed from: l */
    public long f10141l = -1;

    /* renamed from: j */
    public int f10139j = -1;

    /* renamed from: f */
    public long f10135f = C0643C.TIME_UNSET;

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput extractorOutput) {
        this.f10132c = 0;
        this.f10133d = extractorOutput;
        this.f10137h = -1L;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0032 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0387  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0111  */
    @Override // com.google.android.exoplayer2.extractor.Extractor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) {
        boolean z;
        C1556mp c1556mp;
        long j;
        C1556mp c1556mp2;
        int i;
        boolean z2;
        int i2;
        int i3 = 0;
        if (this.f10137h != -1) {
            long position = extractorInput.getPosition();
            long j2 = this.f10137h;
            if (j2 >= position && j2 <= PlaybackStateCompat.ACTION_SET_REPEAT_MODE + position) {
                extractorInput.skipFully((int) (j2 - position));
            } else {
                positionHolder.position = j2;
                z = true;
                this.f10137h = -1L;
                if (!z) {
                    return 1;
                }
                int i4 = this.f10132c;
                C1556mp c1556mp3 = null;
                int i5 = 8;
                C2053zd c2053zd = this.f10131b;
                ParsableByteArray parsableByteArray = this.f10130a;
                switch (i4) {
                    case 0:
                        if (sniff(extractorInput)) {
                            extractorInput.skipFully(12);
                            this.f10132c = 1;
                            return 0;
                        }
                        throw ParserException.createForMalformedContainer("AVI Header List not found", null);
                    case 1:
                        extractorInput.readFully(parsableByteArray.getData(), 0, 12);
                        parsableByteArray.setPosition(0);
                        c2053zd.getClass();
                        c2053zd.f29313a = parsableByteArray.readLittleEndianInt();
                        c2053zd.f29314b = parsableByteArray.readLittleEndianInt();
                        c2053zd.f29315c = 0;
                        if (c2053zd.f29313a == 1414744396) {
                            int readLittleEndianInt = parsableByteArray.readLittleEndianInt();
                            c2053zd.f29315c = readLittleEndianInt;
                            if (readLittleEndianInt == 1819436136) {
                                this.f10139j = c2053zd.f29314b;
                                this.f10132c = 2;
                                return 0;
                            }
                            throw ParserException.createForMalformedContainer("hdrl expected, found: " + c2053zd.f29315c, null);
                        }
                        throw ParserException.createForMalformedContainer("LIST expected, found: " + c2053zd.f29313a, null);
                    case 2:
                        int i6 = this.f10139j - 4;
                        ParsableByteArray parsableByteArray2 = new ParsableByteArray(i6);
                        extractorInput.readFully(parsableByteArray2.getData(), 0, i6);
                        i91 m5201b = i91.m5201b(FOURCC_hdrl, parsableByteArray2);
                        int i7 = m5201b.f18343b;
                        if (i7 == 1819436136) {
                            C0015ae c0015ae = (C0015ae) m5201b.m5202a(C0015ae.class);
                            if (c0015ae != null) {
                                this.f10134e = c0015ae;
                                this.f10135f = c0015ae.f149c * c0015ae.f147a;
                                ArrayList arrayList = new ArrayList();
                                UnmodifiableIterator it = m5201b.f18342a.iterator();
                                int i8 = 0;
                                while (it.hasNext()) {
                                    InterfaceC1979xd interfaceC1979xd = (InterfaceC1979xd) it.next();
                                    if (interfaceC1979xd.getType() == 1819440243) {
                                        i91 i91Var = (i91) interfaceC1979xd;
                                        int i9 = i8 + 1;
                                        C0554be c0554be = (C0554be) i91Var.m5202a(C0554be.class);
                                        zn2 zn2Var = (zn2) i91Var.m5202a(zn2.class);
                                        if (c0554be == null) {
                                            Log.m3027w("AviExtractor", "Missing Stream Header");
                                        } else if (zn2Var == null) {
                                            Log.m3027w("AviExtractor", "Missing Stream Format");
                                        } else {
                                            long scaleLargeTimestamp = Util.scaleLargeTimestamp(c0554be.f7976d, c0554be.f7974b * 1000000, c0554be.f7975c);
                                            Format format = zn2Var.f29448a;
                                            Format.Builder buildUpon = format.buildUpon();
                                            buildUpon.setId(i8);
                                            int i10 = c0554be.f7977e;
                                            if (i10 != 0) {
                                                buildUpon.setMaxInputSize(i10);
                                            }
                                            ao2 ao2Var = (ao2) i91Var.m5202a(ao2.class);
                                            if (ao2Var != null) {
                                                buildUpon.setLabel(ao2Var.f7688a);
                                            }
                                            int trackType = MimeTypes.getTrackType(format.sampleMimeType);
                                            if (trackType == 1 || trackType == 2) {
                                                TrackOutput track = this.f10133d.track(i8, trackType);
                                                track.format(buildUpon.build());
                                                c1556mp = new C1556mp(i8, trackType, scaleLargeTimestamp, c0554be.f7976d, track);
                                                this.f10135f = scaleLargeTimestamp;
                                                if (c1556mp != null) {
                                                    arrayList.add(c1556mp);
                                                }
                                                i8 = i9;
                                            }
                                        }
                                        c1556mp = null;
                                        if (c1556mp != null) {
                                        }
                                        i8 = i9;
                                    }
                                }
                                this.f10136g = (C1556mp[]) arrayList.toArray(new C1556mp[0]);
                                this.f10133d.endTracks();
                                this.f10132c = 3;
                                return 0;
                            }
                            throw ParserException.createForMalformedContainer("AviHeader not found", null);
                        }
                        throw ParserException.createForMalformedContainer("Unexpected header list type " + i7, null);
                    case 3:
                        if (this.f10140k != -1) {
                            long position2 = extractorInput.getPosition();
                            long j3 = this.f10140k;
                            if (position2 != j3) {
                                this.f10137h = j3;
                                return 0;
                            }
                        }
                        extractorInput.peekFully(parsableByteArray.getData(), 0, 12);
                        extractorInput.resetPeekPosition();
                        parsableByteArray.setPosition(0);
                        c2053zd.getClass();
                        c2053zd.f29313a = parsableByteArray.readLittleEndianInt();
                        c2053zd.f29314b = parsableByteArray.readLittleEndianInt();
                        c2053zd.f29315c = 0;
                        int readLittleEndianInt2 = parsableByteArray.readLittleEndianInt();
                        int i11 = c2053zd.f29313a;
                        if (i11 == 1179011410) {
                            extractorInput.skipFully(12);
                            return 0;
                        }
                        if (i11 == 1414744396 && readLittleEndianInt2 == 1769369453) {
                            long position3 = extractorInput.getPosition();
                            this.f10140k = position3;
                            this.f10141l = position3 + c2053zd.f29314b + 8;
                            if (!this.f10143n) {
                                if ((((C0015ae) Assertions.checkNotNull(this.f10134e)).f148b & 16) == 16) {
                                    this.f10132c = 4;
                                    this.f10137h = this.f10141l;
                                    return 0;
                                }
                                this.f10133d.seekMap(new SeekMap.Unseekable(this.f10135f));
                                this.f10143n = true;
                            }
                            this.f10137h = extractorInput.getPosition() + 12;
                            this.f10132c = 6;
                            return 0;
                        }
                        this.f10137h = extractorInput.getPosition() + c2053zd.f29314b + 8;
                        return 0;
                    case 4:
                        extractorInput.readFully(parsableByteArray.getData(), 0, 8);
                        parsableByteArray.setPosition(0);
                        int readLittleEndianInt3 = parsableByteArray.readLittleEndianInt();
                        int readLittleEndianInt4 = parsableByteArray.readLittleEndianInt();
                        if (readLittleEndianInt3 == 829973609) {
                            this.f10132c = 5;
                            this.f10142m = readLittleEndianInt4;
                            return 0;
                        }
                        this.f10137h = extractorInput.getPosition() + readLittleEndianInt4;
                        return 0;
                    case 5:
                        ParsableByteArray parsableByteArray3 = new ParsableByteArray(this.f10142m);
                        extractorInput.readFully(parsableByteArray3.getData(), 0, this.f10142m);
                        if (parsableByteArray3.bytesLeft() < 16) {
                            j = 0;
                        } else {
                            int position4 = parsableByteArray3.getPosition();
                            parsableByteArray3.skipBytes(8);
                            long readLittleEndianInt5 = parsableByteArray3.readLittleEndianInt();
                            long j4 = this.f10140k;
                            if (readLittleEndianInt5 > j4) {
                                j = 0;
                            } else {
                                j = j4 + 8;
                            }
                            parsableByteArray3.setPosition(position4);
                        }
                        while (parsableByteArray3.bytesLeft() >= 16) {
                            int readLittleEndianInt6 = parsableByteArray3.readLittleEndianInt();
                            int readLittleEndianInt7 = parsableByteArray3.readLittleEndianInt();
                            long readLittleEndianInt8 = parsableByteArray3.readLittleEndianInt() + j;
                            parsableByteArray3.readLittleEndianInt();
                            C1556mp[] c1556mpArr = this.f10136g;
                            int length = c1556mpArr.length;
                            int i12 = i3;
                            while (true) {
                                if (i12 < length) {
                                    c1556mp2 = c1556mpArr[i12];
                                    if (c1556mp2.f23025b != readLittleEndianInt6 && c1556mp2.f23026c != readLittleEndianInt6) {
                                        i12++;
                                    }
                                } else {
                                    c1556mp2 = null;
                                }
                            }
                            if (c1556mp2 != null) {
                                if ((readLittleEndianInt7 & 16) == 16) {
                                    if (c1556mp2.f23033j == c1556mp2.f23035l.length) {
                                        long[] jArr = c1556mp2.f23034k;
                                        c1556mp2.f23034k = Arrays.copyOf(jArr, (jArr.length * 3) / 2);
                                        int[] iArr = c1556mp2.f23035l;
                                        c1556mp2.f23035l = Arrays.copyOf(iArr, (iArr.length * 3) / 2);
                                    }
                                    long[] jArr2 = c1556mp2.f23034k;
                                    int i13 = c1556mp2.f23033j;
                                    jArr2[i13] = readLittleEndianInt8;
                                    c1556mp2.f23035l[i13] = c1556mp2.f23032i;
                                    i = 1;
                                    c1556mp2.f23033j = i13 + 1;
                                } else {
                                    i = 1;
                                }
                                c1556mp2.f23032i += i;
                            }
                            i3 = 0;
                        }
                        for (C1556mp c1556mp4 : this.f10136g) {
                            c1556mp4.f23034k = Arrays.copyOf(c1556mp4.f23034k, c1556mp4.f23033j);
                            c1556mp4.f23035l = Arrays.copyOf(c1556mp4.f23035l, c1556mp4.f23033j);
                        }
                        this.f10143n = true;
                        this.f10133d.seekMap(new C2016yd(this, this.f10135f));
                        this.f10132c = 6;
                        this.f10137h = this.f10140k;
                        return 0;
                    case 6:
                        if (extractorInput.getPosition() >= this.f10141l) {
                            return -1;
                        }
                        C1556mp c1556mp5 = this.f10138i;
                        if (c1556mp5 != null) {
                            int i14 = c1556mp5.f23030g;
                            int sampleData = i14 - c1556mp5.f23024a.sampleData((DataReader) extractorInput, i14, false);
                            c1556mp5.f23030g = sampleData;
                            if (sampleData == 0) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (z2) {
                                if (c1556mp5.f23029f > 0) {
                                    int i15 = c1556mp5.f23031h;
                                    long j5 = (c1556mp5.f23027d * i15) / c1556mp5.f23028e;
                                    if (Arrays.binarySearch(c1556mp5.f23035l, i15) >= 0) {
                                        i2 = 1;
                                    } else {
                                        i2 = 0;
                                    }
                                    c1556mp5.f23024a.sampleMetadata(j5, i2, c1556mp5.f23029f, 0, null);
                                }
                                c1556mp5.f23031h++;
                            }
                            if (!z2) {
                                return 0;
                            }
                            this.f10138i = null;
                            return 0;
                        }
                        if ((extractorInput.getPosition() & 1) == 1) {
                            extractorInput.skipFully(1);
                        }
                        extractorInput.peekFully(parsableByteArray.getData(), 0, 12);
                        parsableByteArray.setPosition(0);
                        int readLittleEndianInt9 = parsableByteArray.readLittleEndianInt();
                        if (readLittleEndianInt9 == 1414744396) {
                            parsableByteArray.setPosition(8);
                            if (parsableByteArray.readLittleEndianInt() == 1769369453) {
                                i5 = 12;
                            }
                            extractorInput.skipFully(i5);
                            extractorInput.resetPeekPosition();
                            return 0;
                        }
                        int readLittleEndianInt10 = parsableByteArray.readLittleEndianInt();
                        if (readLittleEndianInt9 == 1263424842) {
                            this.f10137h = extractorInput.getPosition() + readLittleEndianInt10 + 8;
                            return 0;
                        }
                        extractorInput.skipFully(8);
                        extractorInput.resetPeekPosition();
                        for (C1556mp c1556mp6 : this.f10136g) {
                            if (c1556mp6.f23025b == readLittleEndianInt9 || c1556mp6.f23026c == readLittleEndianInt9) {
                                c1556mp3 = c1556mp6;
                                if (c1556mp3 != null) {
                                    this.f10137h = extractorInput.getPosition() + readLittleEndianInt10;
                                    return 0;
                                }
                                c1556mp3.f23029f = readLittleEndianInt10;
                                c1556mp3.f23030g = readLittleEndianInt10;
                                this.f10138i = c1556mp3;
                                return 0;
                            }
                        }
                        if (c1556mp3 != null) {
                        }
                        break;
                    default:
                        throw new AssertionError();
                }
            }
        }
        z = false;
        this.f10137h = -1L;
        if (!z) {
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j, long j2) {
        this.f10137h = -1L;
        this.f10138i = null;
        for (C1556mp c1556mp : this.f10136g) {
            if (c1556mp.f23033j == 0) {
                c1556mp.f23031h = 0;
            } else {
                c1556mp.f23031h = c1556mp.f23035l[Util.binarySearchFloor(c1556mp.f23034k, j, true, true)];
            }
        }
        if (j == 0) {
            if (this.f10136g.length == 0) {
                this.f10132c = 0;
                return;
            } else {
                this.f10132c = 3;
                return;
            }
        }
        this.f10132c = 6;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(ExtractorInput extractorInput) {
        ParsableByteArray parsableByteArray = this.f10130a;
        extractorInput.peekFully(parsableByteArray.getData(), 0, 12);
        parsableByteArray.setPosition(0);
        if (parsableByteArray.readLittleEndianInt() != 1179011410) {
            return false;
        }
        parsableByteArray.skipBytes(4);
        if (parsableByteArray.readLittleEndianInt() != 541677121) {
            return false;
        }
        return true;
    }
}
