package com.google.android.exoplayer2.text.cea;

import android.text.Layout;
import android.text.SpannableStringBuilder;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.extractor.p002ts.TsExtractor;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleInputBuffer;
import com.google.android.exoplayer2.text.SubtitleOutputBuffer;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.text.Typography;
import okio.Utf8;
import p000.AbstractC1726qj;
import p000.AbstractC1876ul;
import p000.C1691pl;
import p000.C1728ql;
import p000.C1765rl;
import p000.C1802sl;
import p000.C1913vl;

/* loaded from: classes.dex */
public final class Cea708Decoder extends AbstractC1876ul {

    /* renamed from: g */
    public final ParsableByteArray f11795g = new ParsableByteArray();

    /* renamed from: h */
    public final ParsableBitArray f11796h = new ParsableBitArray();

    /* renamed from: i */
    public int f11797i = -1;

    /* renamed from: j */
    public final int f11798j;

    /* renamed from: k */
    public final C1728ql[] f11799k;

    /* renamed from: l */
    public C1728ql f11800l;

    /* renamed from: m */
    public List f11801m;

    /* renamed from: n */
    public List f11802n;

    /* renamed from: o */
    public C1765rl f11803o;

    /* renamed from: p */
    public int f11804p;

    public Cea708Decoder(int i, @Nullable List<byte[]> list) {
        this.f11798j = i == -1 ? 1 : i;
        if (list != null) {
            CodecSpecificDataUtil.parseCea708InitializationData(list);
        }
        this.f11799k = new C1728ql[8];
        for (int i2 = 0; i2 < 8; i2++) {
            this.f11799k[i2] = new C1728ql();
        }
        this.f11800l = this.f11799k[0];
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:56:0x014b. Please report as an issue. */
    /* renamed from: a */
    public final void m2848a() {
        int i;
        int i2;
        String str;
        boolean z;
        char c;
        int i3;
        String str2;
        C1765rl c1765rl = this.f11803o;
        if (c1765rl == null) {
            return;
        }
        int i4 = 2;
        String str3 = "Cea708Decoder";
        if (c1765rl.f26011d != (c1765rl.f26009b * 2) - 1) {
            Log.m3021d("Cea708Decoder", "DtvCcPacket ended prematurely; size is " + ((this.f11803o.f26009b * 2) - 1) + ", but current index is " + this.f11803o.f26011d + " (sequence number " + this.f11803o.f26008a + ");");
        }
        C1765rl c1765rl2 = this.f11803o;
        byte[] bArr = c1765rl2.f26010c;
        int i5 = c1765rl2.f26011d;
        ParsableBitArray parsableBitArray = this.f11796h;
        parsableBitArray.reset(bArr, i5);
        boolean z2 = false;
        while (true) {
            if (parsableBitArray.bitsLeft() > 0) {
                int i6 = 3;
                int readBits = parsableBitArray.readBits(3);
                int readBits2 = parsableBitArray.readBits(5);
                if (readBits == 7) {
                    parsableBitArray.skipBits(i4);
                    readBits = parsableBitArray.readBits(6);
                    if (readBits < 7) {
                        AbstractC1726qj.m7036A(readBits, "Invalid extended service number: ", str3);
                    }
                }
                if (readBits2 == 0) {
                    if (readBits != 0) {
                        Log.m3027w(str3, "serviceNumber is non-zero (" + readBits + ") when blockSize is 0");
                    }
                } else if (readBits != this.f11798j) {
                    parsableBitArray.skipBytes(readBits2);
                } else {
                    int position = (readBits2 * 8) + parsableBitArray.getPosition();
                    while (parsableBitArray.getPosition() < position) {
                        int readBits3 = parsableBitArray.readBits(8);
                        if (readBits3 != 16) {
                            if (readBits3 <= 31) {
                                if (readBits3 != 0) {
                                    if (readBits3 != i6) {
                                        if (readBits3 != 8) {
                                            switch (readBits3) {
                                                case 12:
                                                    m2850c();
                                                    break;
                                                case 13:
                                                    this.f11800l.m7074a('\n');
                                                    break;
                                                case 14:
                                                    break;
                                                default:
                                                    if (readBits3 >= 17 && readBits3 <= 23) {
                                                        Log.m3027w(str3, "Currently unsupported COMMAND_EXT1 Command: " + readBits3);
                                                        parsableBitArray.skipBits(8);
                                                        break;
                                                    } else if (readBits3 >= 24 && readBits3 <= 31) {
                                                        Log.m3027w(str3, "Currently unsupported COMMAND_P16 Command: " + readBits3);
                                                        parsableBitArray.skipBits(16);
                                                        break;
                                                    } else {
                                                        AbstractC1726qj.m7036A(readBits3, "Invalid C0 command: ", str3);
                                                        break;
                                                    }
                                            }
                                        } else {
                                            SpannableStringBuilder spannableStringBuilder = this.f11800l.f25651b;
                                            int length = spannableStringBuilder.length();
                                            if (length > 0) {
                                                spannableStringBuilder.delete(length - 1, length);
                                            }
                                        }
                                    } else {
                                        this.f11801m = m2849b();
                                    }
                                }
                                i3 = i4;
                                i = i6;
                                i2 = position;
                            } else if (readBits3 <= 127) {
                                if (readBits3 == 127) {
                                    this.f11800l.m7074a((char) 9835);
                                } else {
                                    this.f11800l.m7074a((char) (readBits3 & 255));
                                }
                                i3 = i4;
                                i = i6;
                                i2 = position;
                                z2 = true;
                            } else {
                                if (readBits3 <= 159) {
                                    C1728ql[] c1728qlArr = this.f11799k;
                                    switch (readBits3) {
                                        case 128:
                                        case TsExtractor.TS_STREAM_TYPE_AC3 /* 129 */:
                                        case TsExtractor.TS_STREAM_TYPE_HDMV_DTS /* 130 */:
                                        case 131:
                                        case 132:
                                        case 133:
                                        case TsExtractor.TS_STREAM_TYPE_SPLICE_INFO /* 134 */:
                                        case TsExtractor.TS_STREAM_TYPE_E_AC3 /* 135 */:
                                            str2 = str3;
                                            i = i6;
                                            i2 = position;
                                            z = true;
                                            int i7 = readBits3 - 128;
                                            if (this.f11804p != i7) {
                                                this.f11804p = i7;
                                                this.f11800l = c1728qlArr[i7];
                                                break;
                                            }
                                            break;
                                        case 136:
                                            str2 = str3;
                                            i = i6;
                                            i2 = position;
                                            z = true;
                                            for (int i8 = 1; i8 <= 8; i8++) {
                                                if (parsableBitArray.readBit()) {
                                                    C1728ql c1728ql = c1728qlArr[8 - i8];
                                                    c1728ql.f25650a.clear();
                                                    c1728ql.f25651b.clear();
                                                    c1728ql.f25665p = -1;
                                                    c1728ql.f25666q = -1;
                                                    c1728ql.f25667r = -1;
                                                    c1728ql.f25669t = -1;
                                                    c1728ql.f25671v = 0;
                                                }
                                            }
                                            break;
                                        case 137:
                                            str2 = str3;
                                            i = i6;
                                            i2 = position;
                                            for (int i9 = 1; i9 <= 8; i9++) {
                                                if (parsableBitArray.readBit()) {
                                                    c1728qlArr[8 - i9].f25653d = true;
                                                }
                                            }
                                            z = true;
                                            break;
                                        case TsExtractor.TS_STREAM_TYPE_DTS /* 138 */:
                                            str2 = str3;
                                            i = i6;
                                            i2 = position;
                                            for (int i10 = 1; i10 <= 8; i10++) {
                                                if (parsableBitArray.readBit()) {
                                                    c1728qlArr[8 - i10].f25653d = false;
                                                }
                                            }
                                            z = true;
                                            break;
                                        case 139:
                                            str2 = str3;
                                            i = i6;
                                            i2 = position;
                                            for (int i11 = 1; i11 <= 8; i11++) {
                                                if (parsableBitArray.readBit()) {
                                                    c1728qlArr[8 - i11].f25653d = !r1.f25653d;
                                                }
                                            }
                                            z = true;
                                            break;
                                        case 140:
                                            str2 = str3;
                                            i = i6;
                                            i2 = position;
                                            for (int i12 = 1; i12 <= 8; i12++) {
                                                if (parsableBitArray.readBit()) {
                                                    c1728qlArr[8 - i12].m7076d();
                                                }
                                            }
                                            z = true;
                                            break;
                                        case ModuleDescriptor.MODULE_VERSION /* 141 */:
                                            str2 = str3;
                                            i = i6;
                                            i2 = position;
                                            parsableBitArray.skipBits(8);
                                            z = true;
                                            break;
                                        case 142:
                                            str2 = str3;
                                            i = i6;
                                            i2 = position;
                                            z = true;
                                            break;
                                        case 143:
                                            str2 = str3;
                                            i = i6;
                                            i2 = position;
                                            m2850c();
                                            z = true;
                                            break;
                                        case 144:
                                            str2 = str3;
                                            i2 = position;
                                            if (!this.f11800l.f25652c) {
                                                parsableBitArray.skipBits(16);
                                                i = 3;
                                                z = true;
                                                break;
                                            } else {
                                                parsableBitArray.readBits(4);
                                                parsableBitArray.readBits(2);
                                                parsableBitArray.readBits(2);
                                                boolean readBit = parsableBitArray.readBit();
                                                boolean readBit2 = parsableBitArray.readBit();
                                                i = 3;
                                                parsableBitArray.readBits(3);
                                                parsableBitArray.readBits(3);
                                                this.f11800l.m7077e(readBit, readBit2);
                                                z = true;
                                            }
                                        case 145:
                                            str2 = str3;
                                            i2 = position;
                                            if (!this.f11800l.f25652c) {
                                                parsableBitArray.skipBits(24);
                                            } else {
                                                int m7073c = C1728ql.m7073c(parsableBitArray.readBits(2), parsableBitArray.readBits(2), parsableBitArray.readBits(2), parsableBitArray.readBits(2));
                                                int m7073c2 = C1728ql.m7073c(parsableBitArray.readBits(2), parsableBitArray.readBits(2), parsableBitArray.readBits(2), parsableBitArray.readBits(2));
                                                parsableBitArray.skipBits(2);
                                                C1728ql.m7073c(parsableBitArray.readBits(2), parsableBitArray.readBits(2), parsableBitArray.readBits(2), 0);
                                                this.f11800l.m7078f(m7073c, m7073c2);
                                            }
                                            i = 3;
                                            z = true;
                                            break;
                                        case 146:
                                            str2 = str3;
                                            i2 = position;
                                            if (!this.f11800l.f25652c) {
                                                parsableBitArray.skipBits(16);
                                            } else {
                                                parsableBitArray.skipBits(4);
                                                int readBits4 = parsableBitArray.readBits(4);
                                                parsableBitArray.skipBits(2);
                                                parsableBitArray.readBits(6);
                                                C1728ql c1728ql2 = this.f11800l;
                                                if (c1728ql2.f25671v != readBits4) {
                                                    c1728ql2.m7074a('\n');
                                                }
                                                c1728ql2.f25671v = readBits4;
                                            }
                                            i = 3;
                                            z = true;
                                            break;
                                        case 147:
                                        case 148:
                                        case 149:
                                        case 150:
                                        default:
                                            AbstractC1726qj.m7036A(readBits3, "Invalid C1 command: ", str3);
                                            str2 = str3;
                                            i = i6;
                                            i2 = position;
                                            z = true;
                                            break;
                                        case 151:
                                            str2 = str3;
                                            i2 = position;
                                            if (!this.f11800l.f25652c) {
                                                parsableBitArray.skipBits(32);
                                            } else {
                                                int m7073c3 = C1728ql.m7073c(parsableBitArray.readBits(2), parsableBitArray.readBits(2), parsableBitArray.readBits(2), parsableBitArray.readBits(2));
                                                parsableBitArray.readBits(2);
                                                C1728ql.m7073c(parsableBitArray.readBits(2), parsableBitArray.readBits(2), parsableBitArray.readBits(2), 0);
                                                parsableBitArray.readBit();
                                                parsableBitArray.readBit();
                                                parsableBitArray.readBits(2);
                                                parsableBitArray.readBits(2);
                                                int readBits5 = parsableBitArray.readBits(2);
                                                parsableBitArray.skipBits(8);
                                                C1728ql c1728ql3 = this.f11800l;
                                                c1728ql3.f25664o = m7073c3;
                                                c1728ql3.f25661l = readBits5;
                                            }
                                            i = 3;
                                            z = true;
                                            break;
                                        case 152:
                                        case 153:
                                        case 154:
                                        case 155:
                                        case 156:
                                        case 157:
                                        case 158:
                                        case 159:
                                            int i13 = readBits3 - 152;
                                            C1728ql c1728ql4 = c1728qlArr[i13];
                                            parsableBitArray.skipBits(i4);
                                            boolean readBit3 = parsableBitArray.readBit();
                                            boolean readBit4 = parsableBitArray.readBit();
                                            parsableBitArray.readBit();
                                            int readBits6 = parsableBitArray.readBits(i6);
                                            boolean readBit5 = parsableBitArray.readBit();
                                            int readBits7 = parsableBitArray.readBits(7);
                                            int readBits8 = parsableBitArray.readBits(8);
                                            int readBits9 = parsableBitArray.readBits(4);
                                            int readBits10 = parsableBitArray.readBits(4);
                                            parsableBitArray.skipBits(i4);
                                            i2 = position;
                                            parsableBitArray.readBits(6);
                                            parsableBitArray.skipBits(i4);
                                            int readBits11 = parsableBitArray.readBits(3);
                                            str2 = str3;
                                            int readBits12 = parsableBitArray.readBits(3);
                                            c1728ql4.f25652c = true;
                                            c1728ql4.f25653d = readBit3;
                                            c1728ql4.f25660k = readBit4;
                                            c1728ql4.f25654e = readBits6;
                                            c1728ql4.f25655f = readBit5;
                                            c1728ql4.f25656g = readBits7;
                                            c1728ql4.f25657h = readBits8;
                                            c1728ql4.f25658i = readBits9;
                                            int i14 = readBits10 + 1;
                                            if (c1728ql4.f25659j != i14) {
                                                c1728ql4.f25659j = i14;
                                                while (true) {
                                                    ArrayList arrayList = c1728ql4.f25650a;
                                                    if ((readBit4 && arrayList.size() >= c1728ql4.f25659j) || arrayList.size() >= 15) {
                                                        arrayList.remove(0);
                                                    }
                                                }
                                            }
                                            if (readBits11 != 0 && c1728ql4.f25662m != readBits11) {
                                                c1728ql4.f25662m = readBits11;
                                                int i15 = readBits11 - 1;
                                                int i16 = C1728ql.f25642C[i15];
                                                boolean z3 = C1728ql.f25641B[i15];
                                                int i17 = C1728ql.f25649z[i15];
                                                int i18 = C1728ql.f25640A[i15];
                                                int i19 = C1728ql.f25648y[i15];
                                                c1728ql4.f25664o = i16;
                                                c1728ql4.f25661l = i19;
                                            }
                                            if (readBits12 != 0 && c1728ql4.f25663n != readBits12) {
                                                c1728ql4.f25663n = readBits12;
                                                int i20 = readBits12 - 1;
                                                int i21 = C1728ql.f25644E[i20];
                                                int i22 = C1728ql.f25643D[i20];
                                                c1728ql4.m7077e(false, false);
                                                c1728ql4.m7078f(C1728ql.f25646w, C1728ql.f25645F[i20]);
                                            }
                                            if (this.f11804p != i13) {
                                                this.f11804p = i13;
                                                this.f11800l = c1728qlArr[i13];
                                            }
                                            i = 3;
                                            z = true;
                                            break;
                                    }
                                } else {
                                    str2 = str3;
                                    i = i6;
                                    i2 = position;
                                    z = true;
                                    if (readBits3 <= 255) {
                                        this.f11800l.m7074a((char) (readBits3 & 255));
                                    } else {
                                        str = str2;
                                        AbstractC1726qj.m7036A(readBits3, "Invalid base command: ", str);
                                        i3 = 2;
                                        c = 7;
                                    }
                                }
                                z2 = z;
                                str = str2;
                                i3 = 2;
                                c = 7;
                            }
                            c = 7;
                            str = str3;
                            z = true;
                        } else {
                            i = i6;
                            i2 = position;
                            str = str3;
                            z = true;
                            int readBits13 = parsableBitArray.readBits(8);
                            if (readBits13 <= 31) {
                                c = 7;
                                if (readBits13 > 7) {
                                    if (readBits13 <= 15) {
                                        parsableBitArray.skipBits(8);
                                    } else if (readBits13 <= 23) {
                                        parsableBitArray.skipBits(16);
                                    } else if (readBits13 <= 31) {
                                        parsableBitArray.skipBits(24);
                                    }
                                }
                            } else {
                                c = 7;
                                if (readBits13 <= 127) {
                                    if (readBits13 != 32) {
                                        if (readBits13 != 33) {
                                            if (readBits13 != 37) {
                                                if (readBits13 != 42) {
                                                    if (readBits13 != 44) {
                                                        if (readBits13 != 63) {
                                                            if (readBits13 != 57) {
                                                                if (readBits13 != 58) {
                                                                    if (readBits13 != 60) {
                                                                        if (readBits13 != 61) {
                                                                            switch (readBits13) {
                                                                                case 48:
                                                                                    this.f11800l.m7074a((char) 9608);
                                                                                    break;
                                                                                case 49:
                                                                                    this.f11800l.m7074a(Typography.leftSingleQuote);
                                                                                    break;
                                                                                case 50:
                                                                                    this.f11800l.m7074a(Typography.rightSingleQuote);
                                                                                    break;
                                                                                case 51:
                                                                                    this.f11800l.m7074a(Typography.leftDoubleQuote);
                                                                                    break;
                                                                                case 52:
                                                                                    this.f11800l.m7074a(Typography.rightDoubleQuote);
                                                                                    break;
                                                                                case 53:
                                                                                    this.f11800l.m7074a(Typography.bullet);
                                                                                    break;
                                                                                default:
                                                                                    switch (readBits13) {
                                                                                        case 118:
                                                                                            this.f11800l.m7074a((char) 8539);
                                                                                            break;
                                                                                        case 119:
                                                                                            this.f11800l.m7074a((char) 8540);
                                                                                            break;
                                                                                        case 120:
                                                                                            this.f11800l.m7074a((char) 8541);
                                                                                            break;
                                                                                        case 121:
                                                                                            this.f11800l.m7074a((char) 8542);
                                                                                            break;
                                                                                        case 122:
                                                                                            this.f11800l.m7074a((char) 9474);
                                                                                            break;
                                                                                        case 123:
                                                                                            this.f11800l.m7074a((char) 9488);
                                                                                            break;
                                                                                        case 124:
                                                                                            this.f11800l.m7074a((char) 9492);
                                                                                            break;
                                                                                        case 125:
                                                                                            this.f11800l.m7074a((char) 9472);
                                                                                            break;
                                                                                        case 126:
                                                                                            this.f11800l.m7074a((char) 9496);
                                                                                            break;
                                                                                        case 127:
                                                                                            this.f11800l.m7074a((char) 9484);
                                                                                            break;
                                                                                        default:
                                                                                            AbstractC1726qj.m7036A(readBits13, "Invalid G2 character: ", str);
                                                                                            break;
                                                                                    }
                                                                            }
                                                                        } else {
                                                                            this.f11800l.m7074a((char) 8480);
                                                                        }
                                                                    } else {
                                                                        this.f11800l.m7074a((char) 339);
                                                                    }
                                                                } else {
                                                                    this.f11800l.m7074a((char) 353);
                                                                }
                                                            } else {
                                                                this.f11800l.m7074a(Typography.tm);
                                                            }
                                                        } else {
                                                            this.f11800l.m7074a((char) 376);
                                                        }
                                                    } else {
                                                        this.f11800l.m7074a((char) 338);
                                                    }
                                                } else {
                                                    this.f11800l.m7074a((char) 352);
                                                }
                                            } else {
                                                this.f11800l.m7074a(Typography.ellipsis);
                                            }
                                        } else {
                                            this.f11800l.m7074a(Typography.nbsp);
                                        }
                                    } else {
                                        this.f11800l.m7074a(' ');
                                    }
                                    z2 = true;
                                } else if (readBits13 <= 159) {
                                    if (readBits13 <= 135) {
                                        parsableBitArray.skipBits(32);
                                    } else if (readBits13 <= 143) {
                                        parsableBitArray.skipBits(40);
                                    } else if (readBits13 <= 159) {
                                        i3 = 2;
                                        parsableBitArray.skipBits(2);
                                        parsableBitArray.skipBits(parsableBitArray.readBits(6) * 8);
                                    }
                                } else {
                                    i3 = 2;
                                    if (readBits13 <= 255) {
                                        if (readBits13 == 160) {
                                            this.f11800l.m7074a((char) 13252);
                                        } else {
                                            AbstractC1726qj.m7036A(readBits13, "Invalid G3 character: ", str);
                                            this.f11800l.m7074a('_');
                                        }
                                        z2 = true;
                                    } else {
                                        AbstractC1726qj.m7036A(readBits13, "Invalid extended command: ", str);
                                    }
                                }
                            }
                            i3 = 2;
                        }
                        i6 = i;
                        str3 = str;
                        position = i2;
                        i4 = i3;
                    }
                }
            }
        }
        if (z2) {
            this.f11801m = m2849b();
        }
        this.f11803o = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00f0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a4  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List m2849b() {
        C1691pl c1691pl;
        Layout.Alignment alignment;
        float f;
        float f2;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        boolean z;
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < 8; i6++) {
            C1728ql[] c1728qlArr = this.f11799k;
            C1728ql c1728ql = c1728qlArr[i6];
            if (c1728ql.f25652c && (!c1728ql.f25650a.isEmpty() || c1728ql.f25651b.length() != 0)) {
                C1728ql c1728ql2 = c1728qlArr[i6];
                if (c1728ql2.f25653d) {
                    if (c1728ql2.f25652c) {
                        ArrayList arrayList2 = c1728ql2.f25650a;
                        if (!arrayList2.isEmpty() || c1728ql2.f25651b.length() != 0) {
                            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                            for (int i7 = 0; i7 < arrayList2.size(); i7++) {
                                spannableStringBuilder.append((CharSequence) arrayList2.get(i7));
                                spannableStringBuilder.append('\n');
                            }
                            spannableStringBuilder.append((CharSequence) c1728ql2.m7075b());
                            int i8 = c1728ql2.f25661l;
                            if (i8 != 0) {
                                if (i8 != 1) {
                                    if (i8 != 2) {
                                        if (i8 != 3) {
                                            throw new IllegalArgumentException("Unexpected justification value: " + c1728ql2.f25661l);
                                        }
                                    } else {
                                        alignment = Layout.Alignment.ALIGN_CENTER;
                                    }
                                } else {
                                    alignment = Layout.Alignment.ALIGN_OPPOSITE;
                                }
                                Layout.Alignment alignment2 = alignment;
                                if (!c1728ql2.f25655f) {
                                    f = c1728ql2.f25657h / 99.0f;
                                    f2 = c1728ql2.f25656g / 99.0f;
                                } else {
                                    f = c1728ql2.f25657h / 209.0f;
                                    f2 = c1728ql2.f25656g / 74.0f;
                                }
                                float f3 = (f * 0.9f) + 0.05f;
                                float f4 = (f2 * 0.9f) + 0.05f;
                                int i9 = c1728ql2.f25658i;
                                i = i9 / 3;
                                if (i != 0) {
                                    i2 = 0;
                                } else if (i == 1) {
                                    i2 = 1;
                                } else {
                                    i2 = 2;
                                }
                                i3 = i9 % 3;
                                if (i3 != 0) {
                                    i4 = 0;
                                } else if (i3 == 1) {
                                    i4 = 1;
                                } else {
                                    i4 = 2;
                                }
                                i5 = c1728ql2.f25664o;
                                if (i5 == C1728ql.f25647x) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                c1691pl = new C1691pl(spannableStringBuilder, alignment2, f4, i2, f3, i4, z, i5, c1728ql2.f25654e);
                                if (c1691pl != null) {
                                    arrayList.add(c1691pl);
                                }
                            }
                            alignment = Layout.Alignment.ALIGN_NORMAL;
                            Layout.Alignment alignment22 = alignment;
                            if (!c1728ql2.f25655f) {
                            }
                            float f32 = (f * 0.9f) + 0.05f;
                            float f42 = (f2 * 0.9f) + 0.05f;
                            int i92 = c1728ql2.f25658i;
                            i = i92 / 3;
                            if (i != 0) {
                            }
                            i3 = i92 % 3;
                            if (i3 != 0) {
                            }
                            i5 = c1728ql2.f25664o;
                            if (i5 == C1728ql.f25647x) {
                            }
                            c1691pl = new C1691pl(spannableStringBuilder, alignment22, f42, i2, f32, i4, z, i5, c1728ql2.f25654e);
                            if (c1691pl != null) {
                            }
                        }
                    }
                    c1691pl = null;
                    if (c1691pl != null) {
                    }
                } else {
                    continue;
                }
            }
        }
        Collections.sort(arrayList, C1691pl.f25206c);
        ArrayList arrayList3 = new ArrayList(arrayList.size());
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            arrayList3.add(((C1691pl) arrayList.get(i10)).f25207a);
        }
        return Collections.unmodifiableList(arrayList3);
    }

    /* renamed from: c */
    public final void m2850c() {
        for (int i = 0; i < 8; i++) {
            this.f11799k[i].m7076d();
        }
    }

    @Override // p000.AbstractC1876ul
    public Subtitle createSubtitle() {
        List list = this.f11801m;
        this.f11802n = list;
        return new C1913vl(0, (List) Assertions.checkNotNull(list));
    }

    @Override // p000.AbstractC1876ul
    public void decode(SubtitleInputBuffer subtitleInputBuffer) {
        boolean z;
        ByteBuffer byteBuffer = (ByteBuffer) Assertions.checkNotNull(subtitleInputBuffer.data);
        byte[] array = byteBuffer.array();
        int limit = byteBuffer.limit();
        ParsableByteArray parsableByteArray = this.f11795g;
        parsableByteArray.reset(array, limit);
        while (parsableByteArray.bytesLeft() >= 3) {
            int readUnsignedByte = parsableByteArray.readUnsignedByte();
            int i = readUnsignedByte & 3;
            boolean z2 = false;
            if ((readUnsignedByte & 4) == 4) {
                z = true;
            } else {
                z = false;
            }
            byte readUnsignedByte2 = (byte) parsableByteArray.readUnsignedByte();
            byte readUnsignedByte3 = (byte) parsableByteArray.readUnsignedByte();
            if (i == 2 || i == 3) {
                if (z) {
                    if (i == 3) {
                        m2848a();
                        int i2 = (readUnsignedByte2 & 192) >> 6;
                        int i3 = this.f11797i;
                        if (i3 != -1 && i2 != (i3 + 1) % 4) {
                            m2850c();
                            Log.m3027w("Cea708Decoder", "Sequence number discontinuity. previous=" + this.f11797i + " current=" + i2);
                        }
                        this.f11797i = i2;
                        int i4 = readUnsignedByte2 & Utf8.REPLACEMENT_BYTE;
                        if (i4 == 0) {
                            i4 = 64;
                        }
                        C1765rl c1765rl = new C1765rl(i2, i4);
                        this.f11803o = c1765rl;
                        c1765rl.f26011d = 1;
                        c1765rl.f26010c[0] = readUnsignedByte3;
                    } else {
                        if (i == 2) {
                            z2 = true;
                        }
                        Assertions.checkArgument(z2);
                        C1765rl c1765rl2 = this.f11803o;
                        if (c1765rl2 == null) {
                            Log.m3023e("Cea708Decoder", "Encountered DTVCC_PACKET_DATA before DTVCC_PACKET_START");
                        } else {
                            byte[] bArr = c1765rl2.f26010c;
                            int i5 = c1765rl2.f26011d;
                            int i6 = i5 + 1;
                            c1765rl2.f26011d = i6;
                            bArr[i5] = readUnsignedByte2;
                            c1765rl2.f26011d = i5 + 2;
                            bArr[i6] = readUnsignedByte3;
                        }
                    }
                    C1765rl c1765rl3 = this.f11803o;
                    if (c1765rl3.f26011d == (c1765rl3.f26009b * 2) - 1) {
                        m2848a();
                    }
                }
            }
        }
    }

    @Override // p000.AbstractC1876ul, com.google.android.exoplayer2.decoder.Decoder
    @Nullable
    public SubtitleInputBuffer dequeueInputBuffer() {
        boolean z;
        if (this.f27310d == null) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkState(z);
        ArrayDeque arrayDeque = this.f27307a;
        if (arrayDeque.isEmpty()) {
            return null;
        }
        C1802sl c1802sl = (C1802sl) arrayDeque.pollFirst();
        this.f27310d = c1802sl;
        return c1802sl;
    }

    @Override // p000.AbstractC1876ul, com.google.android.exoplayer2.decoder.Decoder
    @Nullable
    public /* bridge */ /* synthetic */ SubtitleOutputBuffer dequeueOutputBuffer() {
        return super.dequeueOutputBuffer();
    }

    @Override // p000.AbstractC1876ul, com.google.android.exoplayer2.decoder.Decoder
    public void flush() {
        super.flush();
        this.f11801m = null;
        this.f11802n = null;
        this.f11804p = 0;
        this.f11800l = this.f11799k[0];
        m2850c();
        this.f11803o = null;
    }

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public String getName() {
        return "Cea708Decoder";
    }

    @Override // p000.AbstractC1876ul
    public boolean isNewSubtitleDataAvailable() {
        if (this.f11801m != this.f11802n) {
            return true;
        }
        return false;
    }

    @Override // p000.AbstractC1876ul
    public /* bridge */ /* synthetic */ void queueInputBuffer(SubtitleInputBuffer subtitleInputBuffer) {
        super.queueInputBuffer(subtitleInputBuffer);
    }

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public /* bridge */ /* synthetic */ void release() {
    }

    @Override // com.google.android.exoplayer2.text.SubtitleDecoder
    public void setPositionUs(long j) {
        this.f27311e = j;
    }
}
