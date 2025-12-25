package com.google.android.exoplayer2.extractor.flv;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.AacUtil;
import com.google.android.exoplayer2.extractor.DummyTrackOutput;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.IndexSeekMap;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.video.AvcConfig;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p000.C1581nd;
import p000.ee0;
import p000.ge3;
import p000.o23;
import p000.te2;
import p000.ye0;

/* loaded from: classes.dex */
public final class FlvExtractor implements Extractor {
    public static final ExtractorsFactory FACTORY = new ee0(3);

    /* renamed from: a */
    public final ParsableByteArray f10158a = new ParsableByteArray(4);

    /* renamed from: b */
    public final ParsableByteArray f10159b = new ParsableByteArray(9);

    /* renamed from: c */
    public final ParsableByteArray f10160c = new ParsableByteArray(11);

    /* renamed from: d */
    public final ParsableByteArray f10161d = new ParsableByteArray();

    /* renamed from: e */
    public final te2 f10162e;

    /* renamed from: f */
    public ExtractorOutput f10163f;

    /* renamed from: g */
    public int f10164g;

    /* renamed from: h */
    public boolean f10165h;

    /* renamed from: i */
    public long f10166i;

    /* renamed from: j */
    public int f10167j;

    /* renamed from: k */
    public int f10168k;

    /* renamed from: l */
    public int f10169l;

    /* renamed from: m */
    public long f10170m;

    /* renamed from: n */
    public boolean f10171n;

    /* renamed from: o */
    public C1581nd f10172o;

    /* renamed from: p */
    public o23 f10173p;

    /* JADX WARN: Type inference failed for: r0v4, types: [te2, ge3] */
    public FlvExtractor() {
        ?? ge3Var = new ge3(new DummyTrackOutput());
        ge3Var.f26787b = C0643C.TIME_UNSET;
        ge3Var.f26788c = new long[0];
        ge3Var.f26789d = new long[0];
        this.f10162e = ge3Var;
        this.f10164g = 1;
    }

    /* renamed from: a */
    public final ParsableByteArray m2538a(ExtractorInput extractorInput) {
        int i = this.f10169l;
        ParsableByteArray parsableByteArray = this.f10161d;
        if (i > parsableByteArray.capacity()) {
            parsableByteArray.reset(new byte[Math.max(parsableByteArray.capacity() * 2, this.f10169l)], 0);
        } else {
            parsableByteArray.setPosition(0);
        }
        parsableByteArray.setLimit(this.f10169l);
        extractorInput.readFully(parsableByteArray.getData(), 0, this.f10169l);
        return parsableByteArray;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput extractorOutput) {
        this.f10163f = extractorOutput;
    }

    /* JADX WARN: Removed duplicated region for block: B:123:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0373 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0382  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0386  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0392 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0009 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v51, types: [ge3, nd] */
    @Override // com.google.android.exoplayer2.extractor.Extractor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) {
        long j;
        long j2;
        int i;
        boolean z;
        boolean z2;
        boolean z3;
        int i2;
        long j3;
        String str;
        boolean z4;
        boolean z5;
        Assertions.checkStateNotNull(this.f10163f);
        while (true) {
            int i3 = this.f10164g;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4) {
                            boolean z6 = this.f10165h;
                            te2 te2Var = this.f10162e;
                            if (z6) {
                                j = this.f10166i + this.f10170m;
                            } else if (te2Var.f26787b == C0643C.TIME_UNSET) {
                                j2 = 0;
                                i = this.f10168k;
                                if (i != 8 && this.f10172o != null) {
                                    if (!this.f10171n) {
                                        this.f10163f.seekMap(new SeekMap.Unseekable(C0643C.TIME_UNSET));
                                        this.f10171n = true;
                                    }
                                    C1581nd c1581nd = this.f10172o;
                                    ParsableByteArray m2538a = m2538a(extractorInput);
                                    if (!c1581nd.f23328b) {
                                        int readUnsignedByte = m2538a.readUnsignedByte();
                                        int i4 = (readUnsignedByte >> 4) & 15;
                                        c1581nd.f23330d = i4;
                                        TrackOutput trackOutput = (TrackOutput) c1581nd.f17677a;
                                        if (i4 == 2) {
                                            trackOutput.format(new Format.Builder().setSampleMimeType(MimeTypes.AUDIO_MPEG).setChannelCount(1).setSampleRate(C1581nd.f23327e[(readUnsignedByte >> 2) & 3]).build());
                                            c1581nd.f23329c = true;
                                        } else if (i4 != 7 && i4 != 8) {
                                            if (i4 != 10) {
                                                final String str2 = "Audio format not supported: " + c1581nd.f23330d;
                                                throw new ParserException(str2) { // from class: com.google.android.exoplayer2.extractor.flv.TagPayloadReader$UnsupportedFormatException
                                                };
                                            }
                                        } else {
                                            if (i4 == 7) {
                                                str = MimeTypes.AUDIO_ALAW;
                                            } else {
                                                str = MimeTypes.AUDIO_MLAW;
                                            }
                                            trackOutput.format(new Format.Builder().setSampleMimeType(str).setChannelCount(1).setSampleRate(8000).build());
                                            c1581nd.f23329c = true;
                                        }
                                        c1581nd.f23328b = true;
                                    } else {
                                        m2538a.skipBytes(1);
                                    }
                                    int i5 = c1581nd.f23330d;
                                    TrackOutput trackOutput2 = (TrackOutput) c1581nd.f17677a;
                                    z2 = true;
                                    if (i5 == 2) {
                                        int bytesLeft = m2538a.bytesLeft();
                                        trackOutput2.sampleData(m2538a, bytesLeft);
                                        ((TrackOutput) c1581nd.f17677a).sampleMetadata(j2, 1, bytesLeft, 0, null);
                                    } else {
                                        int readUnsignedByte2 = m2538a.readUnsignedByte();
                                        if (readUnsignedByte2 == 0 && !c1581nd.f23329c) {
                                            int bytesLeft2 = m2538a.bytesLeft();
                                            byte[] bArr = new byte[bytesLeft2];
                                            m2538a.readBytes(bArr, 0, bytesLeft2);
                                            AacUtil.Config parseAudioSpecificConfig = AacUtil.parseAudioSpecificConfig(bArr);
                                            trackOutput2.format(new Format.Builder().setSampleMimeType(MimeTypes.AUDIO_AAC).setCodecs(parseAudioSpecificConfig.codecs).setChannelCount(parseAudioSpecificConfig.channelCount).setSampleRate(parseAudioSpecificConfig.sampleRateHz).setInitializationData(Collections.singletonList(bArr)).build());
                                            c1581nd.f23329c = true;
                                        } else if (c1581nd.f23330d != 10 || readUnsignedByte2 == 1) {
                                            int bytesLeft3 = m2538a.bytesLeft();
                                            trackOutput2.sampleData(m2538a, bytesLeft3);
                                            ((TrackOutput) c1581nd.f17677a).sampleMetadata(j2, 1, bytesLeft3, 0, null);
                                        }
                                        z2 = false;
                                    }
                                    z = true;
                                    if (!this.f10165h) {
                                    }
                                    this.f10167j = 4;
                                    this.f10164g = 2;
                                    if (z) {
                                    }
                                } else if (i != 9 && this.f10173p != null) {
                                    if (!this.f10171n) {
                                        this.f10163f.seekMap(new SeekMap.Unseekable(C0643C.TIME_UNSET));
                                        this.f10171n = true;
                                    }
                                    o23 o23Var = this.f10173p;
                                    ParsableByteArray m2538a2 = m2538a(extractorInput);
                                    o23Var.getClass();
                                    int readUnsignedByte3 = m2538a2.readUnsignedByte();
                                    int i6 = (readUnsignedByte3 >> 4) & 15;
                                    int i7 = readUnsignedByte3 & 15;
                                    if (i7 == 7) {
                                        o23Var.f23581g = i6;
                                        if (i6 != 5) {
                                            z3 = true;
                                        } else {
                                            z3 = false;
                                        }
                                        if (z3) {
                                            int readUnsignedByte4 = m2538a2.readUnsignedByte();
                                            long readInt24 = (m2538a2.readInt24() * 1000) + j2;
                                            TrackOutput trackOutput3 = (TrackOutput) o23Var.f17677a;
                                            boolean z7 = true;
                                            if (readUnsignedByte4 == 0 && !o23Var.f23579e) {
                                                ParsableByteArray parsableByteArray = new ParsableByteArray(new byte[m2538a2.bytesLeft()]);
                                                m2538a2.readBytes(parsableByteArray.getData(), 0, m2538a2.bytesLeft());
                                                AvcConfig parse = AvcConfig.parse(parsableByteArray);
                                                o23Var.f23578d = parse.nalUnitLengthFieldLength;
                                                trackOutput3.format(new Format.Builder().setSampleMimeType(MimeTypes.VIDEO_H264).setCodecs(parse.codecs).setWidth(parse.width).setHeight(parse.height).setPixelWidthHeightRatio(parse.pixelWidthHeightRatio).setInitializationData(parse.initializationData).build());
                                                o23Var.f23579e = true;
                                            } else if (readUnsignedByte4 == 1 && o23Var.f23579e) {
                                                if (o23Var.f23581g == 1) {
                                                    i2 = 1;
                                                } else {
                                                    i2 = 0;
                                                }
                                                if (o23Var.f23580f || i2 != 0) {
                                                    ParsableByteArray parsableByteArray2 = o23Var.f23577c;
                                                    byte[] data = parsableByteArray2.getData();
                                                    data[0] = 0;
                                                    data[1] = 0;
                                                    data[2] = 0;
                                                    int i8 = 4 - o23Var.f23578d;
                                                    int i9 = 0;
                                                    while (m2538a2.bytesLeft() > 0) {
                                                        m2538a2.readBytes(parsableByteArray2.getData(), i8, o23Var.f23578d);
                                                        parsableByteArray2.setPosition(0);
                                                        int readUnsignedIntToInt = parsableByteArray2.readUnsignedIntToInt();
                                                        ParsableByteArray parsableByteArray3 = o23Var.f23576b;
                                                        parsableByteArray3.setPosition(0);
                                                        trackOutput3.sampleData(parsableByteArray3, 4);
                                                        trackOutput3.sampleData(m2538a2, readUnsignedIntToInt);
                                                        i9 = i9 + 4 + readUnsignedIntToInt;
                                                    }
                                                    ((TrackOutput) o23Var.f17677a).sampleMetadata(readInt24, i2, i9, 0, null);
                                                    o23Var.f23580f = true;
                                                    if (z7) {
                                                        z2 = true;
                                                        z = true;
                                                        if (!this.f10165h) {
                                                            this.f10165h = true;
                                                            if (te2Var.f26787b != C0643C.TIME_UNSET) {
                                                            }
                                                            this.f10166i = j3;
                                                        }
                                                        this.f10167j = 4;
                                                        this.f10164g = 2;
                                                        if (z) {
                                                        }
                                                    }
                                                }
                                            }
                                            z7 = false;
                                            if (z7) {
                                            }
                                        }
                                        z2 = false;
                                        z = true;
                                        if (!this.f10165h) {
                                        }
                                        this.f10167j = 4;
                                        this.f10164g = 2;
                                        if (z) {
                                        }
                                    } else {
                                        final String m8291k = ye0.m8291k(i7, "Video format not supported: ");
                                        throw new ParserException(m8291k) { // from class: com.google.android.exoplayer2.extractor.flv.TagPayloadReader$UnsupportedFormatException
                                        };
                                    }
                                } else {
                                    if (i != 18 && !this.f10171n) {
                                        ParsableByteArray m2538a3 = m2538a(extractorInput);
                                        te2Var.getClass();
                                        te2Var.getClass();
                                        if (m2538a3.readUnsignedByte() == 2 && "onMetaData".equals(te2.m7493s(m2538a3)) && m2538a3.bytesLeft() != 0 && m2538a3.readUnsignedByte() == 8) {
                                            HashMap m7492r = te2.m7492r(m2538a3);
                                            Object obj = m7492r.get(TypedValues.TransitionType.S_DURATION);
                                            if (obj instanceof Double) {
                                                double doubleValue = ((Double) obj).doubleValue();
                                                if (doubleValue > 0.0d) {
                                                    te2Var.f26787b = (long) (doubleValue * 1000000.0d);
                                                }
                                            }
                                            Object obj2 = m7492r.get("keyframes");
                                            if (obj2 instanceof Map) {
                                                Map map = (Map) obj2;
                                                Object obj3 = map.get("filepositions");
                                                Object obj4 = map.get("times");
                                                if ((obj3 instanceof List) && (obj4 instanceof List)) {
                                                    List list = (List) obj3;
                                                    List list2 = (List) obj4;
                                                    int size = list2.size();
                                                    te2Var.f26788c = new long[size];
                                                    te2Var.f26789d = new long[size];
                                                    for (int i10 = 0; i10 < size; i10++) {
                                                        Object obj5 = list.get(i10);
                                                        Object obj6 = list2.get(i10);
                                                        if ((obj6 instanceof Double) && (obj5 instanceof Double)) {
                                                            te2Var.f26788c[i10] = (long) (((Double) obj6).doubleValue() * 1000000.0d);
                                                            te2Var.f26789d[i10] = ((Double) obj5).longValue();
                                                        } else {
                                                            te2Var.f26788c = new long[0];
                                                            te2Var.f26789d = new long[0];
                                                            break;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        long j4 = te2Var.f26787b;
                                        if (j4 != C0643C.TIME_UNSET) {
                                            this.f10163f.seekMap(new IndexSeekMap(te2Var.f26789d, te2Var.f26788c, j4));
                                            this.f10171n = true;
                                        }
                                        z = true;
                                    } else {
                                        extractorInput.skipFully(this.f10169l);
                                        z = false;
                                    }
                                    z2 = false;
                                    if (!this.f10165h && z2) {
                                        this.f10165h = true;
                                        if (te2Var.f26787b != C0643C.TIME_UNSET) {
                                            j3 = -this.f10170m;
                                        } else {
                                            j3 = 0;
                                        }
                                        this.f10166i = j3;
                                    }
                                    this.f10167j = 4;
                                    this.f10164g = 2;
                                    if (z) {
                                        return 0;
                                    }
                                }
                            } else {
                                j = this.f10170m;
                            }
                            j2 = j;
                            i = this.f10168k;
                            if (i != 8) {
                            }
                            if (i != 9) {
                            }
                            if (i != 18) {
                            }
                            extractorInput.skipFully(this.f10169l);
                            z = false;
                            z2 = false;
                            if (!this.f10165h) {
                            }
                            this.f10167j = 4;
                            this.f10164g = 2;
                            if (z) {
                            }
                        } else {
                            throw new IllegalStateException();
                        }
                    } else {
                        ParsableByteArray parsableByteArray4 = this.f10160c;
                        if (!extractorInput.readFully(parsableByteArray4.getData(), 0, 11, true)) {
                            return -1;
                        }
                        parsableByteArray4.setPosition(0);
                        this.f10168k = parsableByteArray4.readUnsignedByte();
                        this.f10169l = parsableByteArray4.readUnsignedInt24();
                        this.f10170m = parsableByteArray4.readUnsignedInt24();
                        this.f10170m = ((parsableByteArray4.readUnsignedByte() << 24) | this.f10170m) * 1000;
                        parsableByteArray4.skipBytes(3);
                        this.f10164g = 4;
                    }
                } else {
                    extractorInput.skipFully(this.f10167j);
                    this.f10167j = 0;
                    this.f10164g = 3;
                }
            } else {
                ParsableByteArray parsableByteArray5 = this.f10159b;
                if (!extractorInput.readFully(parsableByteArray5.getData(), 0, 9, true)) {
                    return -1;
                }
                parsableByteArray5.setPosition(0);
                parsableByteArray5.skipBytes(4);
                int readUnsignedByte5 = parsableByteArray5.readUnsignedByte();
                if ((readUnsignedByte5 & 4) != 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if ((readUnsignedByte5 & 1) != 0) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (z4 && this.f10172o == null) {
                    this.f10172o = new ge3(this.f10163f.track(8, 1));
                }
                if (z5 && this.f10173p == null) {
                    this.f10173p = new o23(this.f10163f.track(9, 2));
                }
                this.f10163f.endTracks();
                this.f10167j = parsableByteArray5.readInt() - 5;
                this.f10164g = 2;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j, long j2) {
        if (j == 0) {
            this.f10164g = 1;
            this.f10165h = false;
        } else {
            this.f10164g = 3;
        }
        this.f10167j = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(ExtractorInput extractorInput) {
        ParsableByteArray parsableByteArray = this.f10158a;
        extractorInput.peekFully(parsableByteArray.getData(), 0, 3);
        parsableByteArray.setPosition(0);
        if (parsableByteArray.readUnsignedInt24() != 4607062) {
            return false;
        }
        extractorInput.peekFully(parsableByteArray.getData(), 0, 2);
        parsableByteArray.setPosition(0);
        if ((parsableByteArray.readUnsignedShort() & ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION) != 0) {
            return false;
        }
        extractorInput.peekFully(parsableByteArray.getData(), 0, 4);
        parsableByteArray.setPosition(0);
        int readInt = parsableByteArray.readInt();
        extractorInput.resetPeekPosition();
        extractorInput.advancePeekPosition(readInt);
        extractorInput.peekFully(parsableByteArray.getData(), 0, 4);
        parsableByteArray.setPosition(0);
        if (parsableByteArray.readInt() != 0) {
            return false;
        }
        return true;
    }
}
