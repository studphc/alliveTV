package com.google.android.exoplayer2.extractor.mp4;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Pair;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.Ac4Util;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.GaplessInfoHolder;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.TrueHdSampleRechunker;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.mp4.MdtaMetadataEntry;
import com.google.android.exoplayer2.metadata.mp4.MotionPhotoMetadata;
import com.google.android.exoplayer2.metadata.mp4.SlowMotionData;
import com.google.android.exoplayer2.metadata.mp4.SmtaMetadataEntry;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import p000.AbstractC1719qc;
import p000.AbstractC1726qj;
import p000.C1301ic;
import p000.C1349jc;
import p000.cb0;
import p000.ee0;
import p000.ev2;
import p000.mp1;
import p000.p63;
import p000.uf2;
import p000.vf2;

/* loaded from: classes.dex */
public final class Mp4Extractor implements Extractor, SeekMap {
    public static final ExtractorsFactory FACTORY = new ee0(21);
    public static final int FLAG_READ_MOTION_PHOTO_METADATA = 2;
    public static final int FLAG_READ_SEF_DATA = 4;
    public static final int FLAG_WORKAROUND_IGNORE_EDIT_LISTS = 1;

    /* renamed from: a */
    public final int f10305a;

    /* renamed from: b */
    public final ParsableByteArray f10306b;

    /* renamed from: c */
    public final ParsableByteArray f10307c;

    /* renamed from: d */
    public final ParsableByteArray f10308d;

    /* renamed from: e */
    public final ParsableByteArray f10309e;

    /* renamed from: f */
    public final ArrayDeque f10310f;

    /* renamed from: g */
    public final vf2 f10311g;

    /* renamed from: h */
    public final ArrayList f10312h;

    /* renamed from: i */
    public int f10313i;

    /* renamed from: j */
    public int f10314j;

    /* renamed from: k */
    public long f10315k;

    /* renamed from: l */
    public int f10316l;

    /* renamed from: m */
    public ParsableByteArray f10317m;

    /* renamed from: n */
    public int f10318n;

    /* renamed from: o */
    public int f10319o;

    /* renamed from: p */
    public int f10320p;

    /* renamed from: q */
    public int f10321q;

    /* renamed from: r */
    public ExtractorOutput f10322r;

    /* renamed from: s */
    public mp1[] f10323s;

    /* renamed from: t */
    public long[][] f10324t;

    /* renamed from: u */
    public int f10325u;

    /* renamed from: v */
    public long f10326v;

    /* renamed from: w */
    public int f10327w;

    /* renamed from: x */
    public MotionPhotoMetadata f10328x;

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface Flags {
    }

    public Mp4Extractor() {
        this(0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x01fa, code lost:
    
        r29 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0201, code lost:
    
        if (r12 != 1851878757) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0203, code lost:
    
        r2 = r10.readNullTerminatedString(r26 - 12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x020d, code lost:
    
        if (r12 != 1684108385) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x020f, code lost:
    
        r11 = r26;
        r6 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0213, code lost:
    
        r10.skipBytes(r26 - 12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x021c, code lost:
    
        r29 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x021e, code lost:
    
        if (r0 == null) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0220, code lost:
    
        if (r2 == null) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0223, code lost:
    
        if (r6 != (-1)) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x023b, code lost:
    
        r6 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x023c, code lost:
    
        r10.setPosition(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0226, code lost:
    
        r10.setPosition(r6);
        r10.skipBytes(16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0238, code lost:
    
        r6 = new com.google.android.exoplayer2.metadata.id3.InternalFrame(r0, r2, r10.readNullTerminatedString(r11 - 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x0241, code lost:
    
        r29 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x02bf, code lost:
    
        com.google.android.exoplayer2.util.Log.m3021d("MetadataUtil", "Skipped unknown metadata entry: " + p000.AbstractC1386kc.m5517a(r13));
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x02d2, code lost:
    
        r10.setPosition(r3);
        r6 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x00d9, code lost:
    
        r0 = p000.fo1.m4824f(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x00dd, code lost:
    
        if (r0 <= 0) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x00e1, code lost:
    
        if (r0 > 192) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x00e3, code lost:
    
        r0 = p000.fo1.f17354a[r0 - 1];
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x00eb, code lost:
    
        if (r0 == null) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x00ed, code lost:
    
        r6 = new com.google.android.exoplayer2.metadata.id3.TextInformationFrame("TCON", null, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x00f4, code lost:
    
        com.google.android.exoplayer2.util.Log.m3027w("MetadataUtil", "Failed to parse standard genre code");
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x00fa, code lost:
    
        r6 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x00ea, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x0110, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x02f9, code lost:
    
        r10.setPosition(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x02fc, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x00cf, code lost:
    
        r29 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x0246, code lost:
    
        r0 = 16777215 & r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x024d, code lost:
    
        if (r0 != 6516084) goto L129;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x024f, code lost:
    
        r6 = p000.fo1.m4819a(r13, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x0257, code lost:
    
        if (r0 == 7233901) goto L163;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x025c, code lost:
    
        if (r0 != 7631467) goto L134;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x0263, code lost:
    
        if (r0 == 6516589) goto L162;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x0268, code lost:
    
        if (r0 != 7828084) goto L139;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x026f, code lost:
    
        if (r0 != 6578553) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x0271, code lost:
    
        r6 = p000.fo1.m4822d(r13, r10, "TDRC");
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x027b, code lost:
    
        if (r0 != 4280916) goto L145;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x027d, code lost:
    
        r6 = p000.fo1.m4822d(r13, r10, "TPE1");
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x0287, code lost:
    
        if (r0 != 7630703) goto L148;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x0289, code lost:
    
        r6 = p000.fo1.m4822d(r13, r10, "TSSE");
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x0293, code lost:
    
        if (r0 != 6384738) goto L151;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x0295, code lost:
    
        r6 = p000.fo1.m4822d(r13, r10, "TALB");
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x029f, code lost:
    
        if (r0 != 7108978) goto L154;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x02a1, code lost:
    
        r6 = p000.fo1.m4822d(r13, r10, "USLT");
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x02ab, code lost:
    
        if (r0 != 6776174) goto L157;
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x02ad, code lost:
    
        r6 = p000.fo1.m4822d(r13, r10, "TCON");
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x02b5, code lost:
    
        if (r0 != 6779504) goto L160;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x02b7, code lost:
    
        r6 = p000.fo1.m4822d(r13, r10, "TIT1");
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x02d7, code lost:
    
        r6 = p000.fo1.m4822d(r13, r10, "TCOM");
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x02df, code lost:
    
        r6 = p000.fo1.m4822d(r13, r10, "TIT2");
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x02fd, code lost:
    
        r29 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x0304, code lost:
    
        if (r5.isEmpty() == false) goto L173;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x0306, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x030d, code lost:
    
        r19 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x0308, code lost:
    
        r0 = new com.google.android.exoplayer2.metadata.Metadata(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x009a, code lost:
    
        r10.setPosition(r2);
        r2 = r2 + r19;
        r10.skipBytes(r3);
        r5 = new java.util.ArrayList();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00ab, code lost:
    
        if (r10.getPosition() >= r2) goto L354;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00ad, code lost:
    
        r3 = r10.readInt() + r10.getPosition();
        r13 = r10.readInt();
        r0 = (r13 >> 24) & 255;
        r19 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00c9, code lost:
    
        if (r0 == 169) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00cd, code lost:
    
        if (r0 != 253) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00d7, code lost:
    
        if (r13 != 1735291493) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0107, code lost:
    
        if (r13 != 1684632427) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0109, code lost:
    
        r6 = p000.fo1.m4821c(r13, r10, "TPOS");
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00fb, code lost:
    
        r10.setPosition(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00fe, code lost:
    
        r29 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x02e7, code lost:
    
        if (r6 == null) goto L356;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x02e9, code lost:
    
        r5.add(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x02ec, code lost:
    
        r2 = r19;
        r7 = r29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0116, code lost:
    
        if (r13 != 1953655662) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0118, code lost:
    
        r6 = p000.fo1.m4821c(r13, r10, "TRCK");
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0122, code lost:
    
        if (r13 != 1953329263) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0124, code lost:
    
        r0 = p000.fo1.m4823e(r13, "TBPM", r10, true, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x012c, code lost:
    
        r10.setPosition(r3);
        r6 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0134, code lost:
    
        if (r13 != 1668311404) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0136, code lost:
    
        r6 = p000.fo1.m4823e(r13, "TCMP", r10, true, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0141, code lost:
    
        if (r13 != 1668249202) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0143, code lost:
    
        r6 = p000.fo1.m4820b(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x014b, code lost:
    
        if (r13 != 1631670868) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x014d, code lost:
    
        r6 = p000.fo1.m4822d(r13, r10, "TPE2");
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0157, code lost:
    
        if (r13 != 1936682605) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0159, code lost:
    
        r6 = p000.fo1.m4822d(r13, r10, "TSOT");
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0163, code lost:
    
        if (r13 != 1936679276) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0165, code lost:
    
        r6 = p000.fo1.m4822d(r13, r10, "TSO2");
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x016f, code lost:
    
        if (r13 != 1936679282) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0171, code lost:
    
        r6 = p000.fo1.m4822d(r13, r10, "TSOA");
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x017b, code lost:
    
        if (r13 != 1936679265) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x017d, code lost:
    
        r6 = p000.fo1.m4822d(r13, r10, "TSOP");
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0188, code lost:
    
        if (r13 != 1936679791) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x018a, code lost:
    
        r6 = p000.fo1.m4822d(r13, r10, "TSOC");
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0195, code lost:
    
        if (r13 != 1920233063) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0197, code lost:
    
        r6 = p000.fo1.m4823e(r13, "ITUNESADVISORY", r10, false, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01a3, code lost:
    
        if (r13 != 1885823344) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01a5, code lost:
    
        r0 = p000.fo1.m4823e(r13, "ITUNESGAPLESS", r10, false, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01b2, code lost:
    
        if (r13 != 1936683886) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x01b4, code lost:
    
        r6 = p000.fo1.m4822d(r13, r10, "TVSHOWSORT");
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01bf, code lost:
    
        if (r13 != 1953919848) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01c1, code lost:
    
        r6 = p000.fo1.m4822d(r13, r10, "TVSHOW");
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01cc, code lost:
    
        if (r13 != 757935405) goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01ce, code lost:
    
        r0 = null;
        r2 = null;
        r6 = -1;
        r11 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x01d6, code lost:
    
        if (r10.getPosition() >= r3) goto L357;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01d8, code lost:
    
        r13 = r10.getPosition();
        r26 = r10.readInt();
        r12 = r10.readInt();
        r10.skipBytes(4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01ed, code lost:
    
        if (r12 != 1835360622) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01ef, code lost:
    
        r0 = r10.readNullTerminatedString(r26 - 12);
        r29 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0218, code lost:
    
        r7 = r29;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:260:0x04d7  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x0501  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x0605 A[LOOP:10: B:295:0x0602->B:297:0x0605, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:301:0x0613  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x0624  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x062e  */
    /* JADX WARN: Removed duplicated region for block: B:336:0x066f A[LOOP:12: B:334:0x066c->B:336:0x066f, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:341:0x068d  */
    /* JADX WARN: Removed duplicated region for block: B:367:0x04d9  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m2559a(long j) {
        int i;
        boolean z;
        ArrayDeque arrayDeque;
        int i2;
        Metadata metadata;
        Metadata metadata2;
        ArrayList arrayList;
        Metadata metadata3;
        boolean z2;
        int size;
        int i3;
        mp1[] mp1VarArr;
        int i4;
        int i5;
        ev2 ev2Var;
        long j2;
        ArrayList arrayList2;
        int i6;
        int i7;
        GaplessInfoHolder gaplessInfoHolder;
        Metadata metadata4;
        int i8;
        Metadata metadata5;
        Metadata metadata6;
        int i9;
        int i10;
        int i11;
        ArrayList arrayList3;
        int i12;
        int i13;
        int i14;
        ArrayList arrayList4;
        String[] strArr;
        MdtaMetadataEntry mdtaMetadataEntry;
        ArrayDeque arrayDeque2;
        float f;
        int i15 = 4;
        int i16 = 1;
        while (true) {
            ArrayDeque arrayDeque3 = this.f10310f;
            if (arrayDeque3.isEmpty() || ((C1301ic) arrayDeque3.peek()).f18359b != j) {
                break;
            }
            C1301ic c1301ic = (C1301ic) arrayDeque3.pop();
            if (c1301ic.f20817a == 1836019574) {
                ArrayList arrayList5 = new ArrayList();
                if (this.f10327w == i16) {
                    z = i16;
                } else {
                    z = 0;
                }
                GaplessInfoHolder gaplessInfoHolder2 = new GaplessInfoHolder();
                C1349jc m5207d = c1301ic.m5207d(1969517665);
                int i17 = 1751411826;
                int i18 = 1768715124;
                int i19 = 1835365473;
                int i20 = 8;
                if (m5207d != null) {
                    byte[] bArr = AbstractC1719qc.f25511a;
                    ParsableByteArray parsableByteArray = m5207d.f20458b;
                    parsableByteArray.setPosition(8);
                    Metadata metadata7 = null;
                    Metadata metadata8 = null;
                    while (parsableByteArray.bytesLeft() >= i20) {
                        int position = parsableByteArray.getPosition();
                        int readInt = parsableByteArray.readInt();
                        int readInt2 = parsableByteArray.readInt();
                        if (readInt2 == i19) {
                            parsableByteArray.setPosition(position);
                            int i21 = position + readInt;
                            parsableByteArray.skipBytes(i20);
                            int position2 = parsableByteArray.getPosition();
                            parsableByteArray.skipBytes(i15);
                            if (parsableByteArray.readInt() != i17) {
                                position2 += 4;
                            }
                            parsableByteArray.setPosition(position2);
                            while (true) {
                                if (parsableByteArray.getPosition() < i21) {
                                    int position3 = parsableByteArray.getPosition();
                                    int readInt3 = parsableByteArray.readInt();
                                    if (parsableByteArray.readInt() == i18) {
                                        break;
                                    }
                                    parsableByteArray.setPosition(position3 + readInt3);
                                    arrayDeque3 = arrayDeque3;
                                    i20 = 8;
                                    i18 = 1768715124;
                                } else {
                                    arrayDeque2 = arrayDeque3;
                                    metadata7 = null;
                                    break;
                                }
                            }
                        } else {
                            arrayDeque2 = arrayDeque3;
                            if (readInt2 == 1936553057) {
                                parsableByteArray.setPosition(position);
                                int i22 = position + readInt;
                                parsableByteArray.skipBytes(12);
                                while (true) {
                                    if (parsableByteArray.getPosition() >= i22) {
                                        break;
                                    }
                                    int position4 = parsableByteArray.getPosition();
                                    int readInt4 = parsableByteArray.readInt();
                                    if (parsableByteArray.readInt() == 1935766900) {
                                        if (readInt4 >= 14) {
                                            parsableByteArray.skipBytes(5);
                                            int readUnsignedByte = parsableByteArray.readUnsignedByte();
                                            if (readUnsignedByte == 12 || readUnsignedByte == 13) {
                                                if (readUnsignedByte == 12) {
                                                    f = 240.0f;
                                                } else {
                                                    f = 120.0f;
                                                }
                                                parsableByteArray.skipBytes(1);
                                                metadata8 = new Metadata(new SmtaMetadataEntry(f, parsableByteArray.readUnsignedByte()));
                                            }
                                        }
                                    } else {
                                        parsableByteArray.setPosition(position4 + readInt4);
                                    }
                                }
                                metadata8 = null;
                            }
                        }
                        parsableByteArray.setPosition(position + readInt);
                        arrayDeque3 = arrayDeque2;
                        i15 = 4;
                        i19 = 1835365473;
                        i20 = 8;
                        i17 = 1751411826;
                        i18 = 1768715124;
                    }
                    arrayDeque = arrayDeque3;
                    Pair create = Pair.create(metadata7, metadata8);
                    metadata2 = (Metadata) create.first;
                    metadata = (Metadata) create.second;
                    if (metadata2 != null) {
                        gaplessInfoHolder2.setFromMetadata(metadata2);
                    }
                    i2 = 1835365473;
                } else {
                    arrayDeque = arrayDeque3;
                    i2 = 1835365473;
                    metadata = null;
                    metadata2 = null;
                }
                C1301ic m5206c = c1301ic.m5206c(i2);
                if (m5206c != null) {
                    byte[] bArr2 = AbstractC1719qc.f25511a;
                    C1349jc m5207d2 = m5206c.m5207d(1751411826);
                    C1349jc m5207d3 = m5206c.m5207d(1801812339);
                    C1349jc m5207d4 = m5206c.m5207d(1768715124);
                    if (m5207d2 != null && m5207d3 != null && m5207d4 != null) {
                        ParsableByteArray parsableByteArray2 = m5207d2.f20458b;
                        parsableByteArray2.setPosition(16);
                        if (parsableByteArray2.readInt() == 1835299937) {
                            ParsableByteArray parsableByteArray3 = m5207d3.f20458b;
                            parsableByteArray3.setPosition(12);
                            int readInt5 = parsableByteArray3.readInt();
                            String[] strArr2 = new String[readInt5];
                            for (int i23 = 0; i23 < readInt5; i23++) {
                                int readInt6 = parsableByteArray3.readInt();
                                parsableByteArray3.skipBytes(4);
                                strArr2[i23] = parsableByteArray3.readString(readInt6 - 8);
                            }
                            ParsableByteArray parsableByteArray4 = m5207d4.f20458b;
                            parsableByteArray4.setPosition(8);
                            ArrayList arrayList6 = new ArrayList();
                            for (int i24 = 8; parsableByteArray4.bytesLeft() > i24; i24 = 8) {
                                int position5 = parsableByteArray4.getPosition();
                                int readInt7 = parsableByteArray4.readInt();
                                int readInt8 = parsableByteArray4.readInt() - 1;
                                if (readInt8 >= 0 && readInt8 < readInt5) {
                                    String str = strArr2[readInt8];
                                    int i25 = position5 + readInt7;
                                    while (true) {
                                        int position6 = parsableByteArray4.getPosition();
                                        if (position6 < i25) {
                                            int readInt9 = parsableByteArray4.readInt();
                                            i14 = readInt5;
                                            int i26 = i25;
                                            if (parsableByteArray4.readInt() == 1684108385) {
                                                int readInt10 = parsableByteArray4.readInt();
                                                int readInt11 = parsableByteArray4.readInt();
                                                int i27 = readInt9 - 16;
                                                strArr = strArr2;
                                                byte[] bArr3 = new byte[i27];
                                                arrayList4 = arrayList5;
                                                parsableByteArray4.readBytes(bArr3, 0, i27);
                                                mdtaMetadataEntry = new MdtaMetadataEntry(str, bArr3, readInt11, readInt10);
                                                break;
                                            }
                                            parsableByteArray4.setPosition(position6 + readInt9);
                                            readInt5 = i14;
                                            i25 = i26;
                                        } else {
                                            i14 = readInt5;
                                            arrayList4 = arrayList5;
                                            strArr = strArr2;
                                            mdtaMetadataEntry = null;
                                            break;
                                        }
                                    }
                                    if (mdtaMetadataEntry != null) {
                                        arrayList6.add(mdtaMetadataEntry);
                                    }
                                } else {
                                    i14 = readInt5;
                                    arrayList4 = arrayList5;
                                    strArr = strArr2;
                                    AbstractC1726qj.m7036A(readInt8, "Skipped metadata with unknown key index: ", "AtomParsers");
                                }
                                parsableByteArray4.setPosition(position5 + readInt7);
                                strArr2 = strArr;
                                readInt5 = i14;
                                arrayList5 = arrayList4;
                            }
                            arrayList = arrayList5;
                            if (!arrayList6.isEmpty()) {
                                metadata3 = new Metadata(arrayList6);
                                if ((this.f10305a & 1) != 0) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                int i28 = -1;
                                GaplessInfoHolder gaplessInfoHolder3 = gaplessInfoHolder2;
                                ArrayList m7023e = AbstractC1719qc.m7023e(c1301ic, gaplessInfoHolder2, C0643C.TIME_UNSET, null, z2, z, new cb0(3));
                                size = m7023e.size();
                                long j3 = C0643C.TIME_UNSET;
                                int i29 = -1;
                                long j4 = -9223372036854775807L;
                                i3 = 0;
                                while (i3 < size) {
                                    ev2 ev2Var2 = (ev2) m7023e.get(i3);
                                    if (ev2Var2.f16999b == 0) {
                                        metadata6 = metadata2;
                                        arrayList2 = m7023e;
                                        i7 = size;
                                        gaplessInfoHolder = gaplessInfoHolder3;
                                        arrayList3 = arrayList;
                                        i12 = 1;
                                        metadata5 = metadata;
                                        i11 = i28;
                                    } else {
                                        Track track = ev2Var2.f16998a;
                                        long j5 = track.durationUs;
                                        if (j5 != j3) {
                                            j2 = j5;
                                            ev2Var = ev2Var2;
                                        } else {
                                            ev2Var = ev2Var2;
                                            j2 = ev2Var.f17005h;
                                        }
                                        j4 = Math.max(j4, j2);
                                        arrayList2 = m7023e;
                                        mp1 mp1Var = new mp1(track, ev2Var, this.f10322r.track(i3, track.type));
                                        boolean equals = MimeTypes.AUDIO_TRUEHD.equals(track.format.sampleMimeType);
                                        int i30 = ev2Var.f17002e;
                                        if (equals) {
                                            i6 = i30 * 16;
                                        } else {
                                            i6 = i30 + 30;
                                        }
                                        Format.Builder buildUpon = track.format.buildUpon();
                                        buildUpon.setMaxInputSize(i6);
                                        i7 = size;
                                        if (track.type == 2 && j2 > 0 && (i13 = ev2Var.f16999b) > 1) {
                                            buildUpon.setFrameRate(i13 / (((float) j2) / 1000000.0f));
                                        }
                                        if (track.type == 1 && gaplessInfoHolder3.hasGaplessInfo()) {
                                            gaplessInfoHolder = gaplessInfoHolder3;
                                            buildUpon.setEncoderDelay(gaplessInfoHolder.encoderDelay).setEncoderPadding(gaplessInfoHolder.encoderPadding);
                                        } else {
                                            gaplessInfoHolder = gaplessInfoHolder3;
                                        }
                                        int i31 = track.type;
                                        ArrayList arrayList7 = this.f10312h;
                                        if (arrayList7.isEmpty()) {
                                            i8 = 2;
                                            metadata4 = null;
                                        } else {
                                            metadata4 = new Metadata(arrayList7);
                                            i8 = 2;
                                        }
                                        Metadata[] metadataArr = new Metadata[i8];
                                        metadataArr[0] = metadata;
                                        metadataArr[1] = metadata4;
                                        metadata5 = metadata;
                                        Metadata metadata9 = new Metadata(new Metadata.Entry[0]);
                                        if (i31 == 1) {
                                            if (metadata2 != null) {
                                                metadata9 = metadata2;
                                                metadata6 = metadata9;
                                                i9 = 1;
                                                for (i10 = 0; i10 < 2; i10 += i9) {
                                                    metadata9 = metadata9.copyWithAppendedEntriesFrom(metadataArr[i10]);
                                                }
                                                if (metadata9.length() > 0) {
                                                    buildUpon.setMetadata(metadata9);
                                                }
                                                mp1Var.f23047c.format(buildUpon.build());
                                                if (track.type != 2) {
                                                    i11 = -1;
                                                    if (i29 == -1) {
                                                        i29 = arrayList.size();
                                                    }
                                                } else {
                                                    i11 = -1;
                                                }
                                                arrayList3 = arrayList;
                                                arrayList3.add(mp1Var);
                                                i12 = 1;
                                            }
                                        } else if (i31 == 2 && metadata3 != null) {
                                            int i32 = 0;
                                            while (i32 < metadata3.length()) {
                                                Metadata.Entry entry = metadata3.get(i32);
                                                if (entry instanceof MdtaMetadataEntry) {
                                                    MdtaMetadataEntry mdtaMetadataEntry2 = (MdtaMetadataEntry) entry;
                                                    metadata6 = metadata2;
                                                    if (MdtaMetadataEntry.KEY_ANDROID_CAPTURE_FPS.equals(mdtaMetadataEntry2.key)) {
                                                        i9 = 1;
                                                        metadata9 = new Metadata(mdtaMetadataEntry2);
                                                        break;
                                                    }
                                                } else {
                                                    metadata6 = metadata2;
                                                }
                                                i32++;
                                                metadata2 = metadata6;
                                            }
                                        }
                                        metadata6 = metadata2;
                                        i9 = 1;
                                        while (i10 < 2) {
                                        }
                                        if (metadata9.length() > 0) {
                                        }
                                        mp1Var.f23047c.format(buildUpon.build());
                                        if (track.type != 2) {
                                        }
                                        arrayList3 = arrayList;
                                        arrayList3.add(mp1Var);
                                        i12 = 1;
                                    }
                                    i3 += i12;
                                    i28 = i11;
                                    arrayList = arrayList3;
                                    m7023e = arrayList2;
                                    metadata = metadata5;
                                    metadata2 = metadata6;
                                    j3 = C0643C.TIME_UNSET;
                                    gaplessInfoHolder3 = gaplessInfoHolder;
                                    size = i7;
                                }
                                int i33 = i28;
                                this.f10325u = i29;
                                this.f10326v = j4;
                                mp1VarArr = (mp1[]) arrayList.toArray(new mp1[0]);
                                this.f10323s = mp1VarArr;
                                long[][] jArr = new long[mp1VarArr.length];
                                int[] iArr = new int[mp1VarArr.length];
                                long[] jArr2 = new long[mp1VarArr.length];
                                boolean[] zArr = new boolean[mp1VarArr.length];
                                for (i4 = 0; i4 < mp1VarArr.length; i4++) {
                                    jArr[i4] = new long[mp1VarArr[i4].f23046b.f16999b];
                                    jArr2[i4] = mp1VarArr[i4].f23046b.f17003f[0];
                                }
                                long j6 = 0;
                                i5 = 0;
                                while (i5 < mp1VarArr.length) {
                                    int i34 = i33;
                                    long j7 = Long.MAX_VALUE;
                                    for (int i35 = 0; i35 < mp1VarArr.length; i35++) {
                                        if (!zArr[i35]) {
                                            long j8 = jArr2[i35];
                                            if (j8 <= j7) {
                                                i34 = i35;
                                                j7 = j8;
                                            }
                                        }
                                    }
                                    int i36 = iArr[i34];
                                    long[] jArr3 = jArr[i34];
                                    jArr3[i36] = j6;
                                    ev2 ev2Var3 = mp1VarArr[i34].f23046b;
                                    j6 += ev2Var3.f17001d[i36];
                                    int i37 = i36 + 1;
                                    iArr[i34] = i37;
                                    if (i37 < jArr3.length) {
                                        jArr2[i34] = ev2Var3.f17003f[i37];
                                    } else {
                                        zArr[i34] = true;
                                        i5++;
                                    }
                                }
                                i = 1;
                                this.f10324t = jArr;
                                this.f10322r.endTracks();
                                this.f10322r.seekMap(this);
                                arrayDeque.clear();
                                this.f10313i = 2;
                            }
                            metadata3 = null;
                            if ((this.f10305a & 1) != 0) {
                            }
                            int i282 = -1;
                            GaplessInfoHolder gaplessInfoHolder32 = gaplessInfoHolder2;
                            ArrayList m7023e2 = AbstractC1719qc.m7023e(c1301ic, gaplessInfoHolder2, C0643C.TIME_UNSET, null, z2, z, new cb0(3));
                            size = m7023e2.size();
                            long j32 = C0643C.TIME_UNSET;
                            int i292 = -1;
                            long j42 = -9223372036854775807L;
                            i3 = 0;
                            while (i3 < size) {
                            }
                            int i332 = i282;
                            this.f10325u = i292;
                            this.f10326v = j42;
                            mp1VarArr = (mp1[]) arrayList.toArray(new mp1[0]);
                            this.f10323s = mp1VarArr;
                            long[][] jArr4 = new long[mp1VarArr.length];
                            int[] iArr2 = new int[mp1VarArr.length];
                            long[] jArr22 = new long[mp1VarArr.length];
                            boolean[] zArr2 = new boolean[mp1VarArr.length];
                            while (i4 < mp1VarArr.length) {
                            }
                            long j62 = 0;
                            i5 = 0;
                            while (i5 < mp1VarArr.length) {
                            }
                            i = 1;
                            this.f10324t = jArr4;
                            this.f10322r.endTracks();
                            this.f10322r.seekMap(this);
                            arrayDeque.clear();
                            this.f10313i = 2;
                        }
                    }
                }
                arrayList = arrayList5;
                metadata3 = null;
                if ((this.f10305a & 1) != 0) {
                }
                int i2822 = -1;
                GaplessInfoHolder gaplessInfoHolder322 = gaplessInfoHolder2;
                ArrayList m7023e22 = AbstractC1719qc.m7023e(c1301ic, gaplessInfoHolder2, C0643C.TIME_UNSET, null, z2, z, new cb0(3));
                size = m7023e22.size();
                long j322 = C0643C.TIME_UNSET;
                int i2922 = -1;
                long j422 = -9223372036854775807L;
                i3 = 0;
                while (i3 < size) {
                }
                int i3322 = i2822;
                this.f10325u = i2922;
                this.f10326v = j422;
                mp1VarArr = (mp1[]) arrayList.toArray(new mp1[0]);
                this.f10323s = mp1VarArr;
                long[][] jArr42 = new long[mp1VarArr.length];
                int[] iArr22 = new int[mp1VarArr.length];
                long[] jArr222 = new long[mp1VarArr.length];
                boolean[] zArr22 = new boolean[mp1VarArr.length];
                while (i4 < mp1VarArr.length) {
                }
                long j622 = 0;
                i5 = 0;
                while (i5 < mp1VarArr.length) {
                }
                i = 1;
                this.f10324t = jArr42;
                this.f10322r.endTracks();
                this.f10322r.seekMap(this);
                arrayDeque.clear();
                this.f10313i = 2;
            } else {
                i = i16;
                if (!arrayDeque3.isEmpty()) {
                    ((C1301ic) arrayDeque3.peek()).f18361d.add(c1301ic);
                }
            }
            i16 = i;
            i15 = 4;
        }
        if (this.f10313i != 2) {
            this.f10313i = 0;
            this.f10316l = 0;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public long getDurationUs() {
        return this.f10326v;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public SeekMap.SeekPoints getSeekPoints(long j) {
        return getSeekPoints(j, -1);
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput extractorOutput) {
        this.f10322r = extractorOutput;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public boolean isSeekable() {
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:253:0x047f, code lost:
    
        r3 = r10;
        r5 = r41.f10316l;
        r6 = r41.f10309e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:254:0x0487, code lost:
    
        if (r5 != 0) goto L251;
     */
    /* JADX WARN: Code restructure failed: missing block: B:256:0x0494, code lost:
    
        if (r42.readFully(r6.getData(), 0, 8, r3) != false) goto L250;
     */
    /* JADX WARN: Code restructure failed: missing block: B:257:0x04dd, code lost:
    
        r41.f10316l = 8;
        r6.setPosition(0);
        r41.f10315k = r6.readUnsignedInt();
        r41.f10314j = r6.readInt();
     */
    /* JADX WARN: Code restructure failed: missing block: B:258:0x04f6, code lost:
    
        r9 = r41.f10315k;
     */
    /* JADX WARN: Code restructure failed: missing block: B:259:0x04fc, code lost:
    
        if (r9 != 1) goto L255;
     */
    /* JADX WARN: Code restructure failed: missing block: B:260:0x04fe, code lost:
    
        r42.readFully(r6.getData(), 8, 8);
        r41.f10316l += 8;
        r41.f10315k = r6.readUnsignedLongToLong();
     */
    /* JADX WARN: Code restructure failed: missing block: B:261:0x053a, code lost:
    
        r9 = r41.f10315k;
        r11 = r41.f10316l;
     */
    /* JADX WARN: Code restructure failed: missing block: B:262:0x0541, code lost:
    
        if (r9 < r11) goto L349;
     */
    /* JADX WARN: Code restructure failed: missing block: B:263:0x0543, code lost:
    
        r9 = r41.f10314j;
     */
    /* JADX WARN: Code restructure failed: missing block: B:264:0x054e, code lost:
    
        if (r9 == 1836019574) goto L280;
     */
    /* JADX WARN: Code restructure failed: missing block: B:266:0x0553, code lost:
    
        if (r9 == 1953653099) goto L280;
     */
    /* JADX WARN: Code restructure failed: missing block: B:268:0x0558, code lost:
    
        if (r9 == 1835297121) goto L280;
     */
    /* JADX WARN: Code restructure failed: missing block: B:270:0x055d, code lost:
    
        if (r9 == 1835626086) goto L280;
     */
    /* JADX WARN: Code restructure failed: missing block: B:272:0x0562, code lost:
    
        if (r9 == 1937007212) goto L280;
     */
    /* JADX WARN: Code restructure failed: missing block: B:274:0x0567, code lost:
    
        if (r9 == 1701082227) goto L280;
     */
    /* JADX WARN: Code restructure failed: missing block: B:275:0x0569, code lost:
    
        if (r9 != 1835365473) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:277:0x0571, code lost:
    
        if (r9 == 1835296868) goto L316;
     */
    /* JADX WARN: Code restructure failed: missing block: B:279:0x0576, code lost:
    
        if (r9 == 1836476516) goto L316;
     */
    /* JADX WARN: Code restructure failed: missing block: B:280:0x0578, code lost:
    
        if (r9 == 1751411826) goto L316;
     */
    /* JADX WARN: Code restructure failed: missing block: B:282:0x057d, code lost:
    
        if (r9 == 1937011556) goto L316;
     */
    /* JADX WARN: Code restructure failed: missing block: B:284:0x0582, code lost:
    
        if (r9 == 1937011827) goto L316;
     */
    /* JADX WARN: Code restructure failed: missing block: B:286:0x0587, code lost:
    
        if (r9 == 1937011571) goto L316;
     */
    /* JADX WARN: Code restructure failed: missing block: B:288:0x058c, code lost:
    
        if (r9 == 1668576371) goto L316;
     */
    /* JADX WARN: Code restructure failed: missing block: B:290:0x0591, code lost:
    
        if (r9 == 1701606260) goto L316;
     */
    /* JADX WARN: Code restructure failed: missing block: B:292:0x0596, code lost:
    
        if (r9 == 1937011555) goto L316;
     */
    /* JADX WARN: Code restructure failed: missing block: B:294:0x059b, code lost:
    
        if (r9 == 1937011578) goto L316;
     */
    /* JADX WARN: Code restructure failed: missing block: B:296:0x05a0, code lost:
    
        if (r9 == 1937013298) goto L316;
     */
    /* JADX WARN: Code restructure failed: missing block: B:298:0x05a5, code lost:
    
        if (r9 == 1937007471) goto L316;
     */
    /* JADX WARN: Code restructure failed: missing block: B:300:0x05aa, code lost:
    
        if (r9 == 1668232756) goto L316;
     */
    /* JADX WARN: Code restructure failed: missing block: B:302:0x05af, code lost:
    
        if (r9 == 1953196132) goto L316;
     */
    /* JADX WARN: Code restructure failed: missing block: B:304:0x05b4, code lost:
    
        if (r9 == 1718909296) goto L316;
     */
    /* JADX WARN: Code restructure failed: missing block: B:306:0x05b9, code lost:
    
        if (r9 == 1969517665) goto L316;
     */
    /* JADX WARN: Code restructure failed: missing block: B:308:0x05be, code lost:
    
        if (r9 == 1801812339) goto L316;
     */
    /* JADX WARN: Code restructure failed: missing block: B:310:0x05c3, code lost:
    
        if (r9 != 1768715124) goto L317;
     */
    /* JADX WARN: Code restructure failed: missing block: B:311:0x05c8, code lost:
    
        r6 = r42.getPosition();
        r9 = r41.f10316l;
        r33 = r6 - r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:312:0x05d6, code lost:
    
        if (r41.f10314j != 1836086884) goto L320;
     */
    /* JADX WARN: Code restructure failed: missing block: B:313:0x05d8, code lost:
    
        r41.f10328x = new com.google.android.exoplayer2.metadata.mp4.MotionPhotoMetadata(0, r33, com.google.android.exoplayer2.C0643C.TIME_UNSET, r33 + r9, r41.f10315k - r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:314:0x05ee, code lost:
    
        r41.f10317m = null;
        r41.f10313i = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:315:0x05f4, code lost:
    
        r3 = 8;
        r4 = 0;
        r5 = 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:319:0x05fa, code lost:
    
        if (r11 != 8) goto L324;
     */
    /* JADX WARN: Code restructure failed: missing block: B:320:0x05fc, code lost:
    
        r11 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:321:0x05ff, code lost:
    
        com.google.android.exoplayer2.util.Assertions.checkState(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:322:0x0609, code lost:
    
        if (r41.f10315k > 2147483647L) goto L328;
     */
    /* JADX WARN: Code restructure failed: missing block: B:323:0x060b, code lost:
    
        r11 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:324:0x060e, code lost:
    
        com.google.android.exoplayer2.util.Assertions.checkState(r11);
        r7 = new com.google.android.exoplayer2.util.ParsableByteArray((int) r41.f10315k);
        java.lang.System.arraycopy(r6.getData(), 0, r7.getData(), 0, 8);
        r41.f10317m = r7;
        r41.f10313i = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:325:0x060d, code lost:
    
        r11 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:326:0x05fe, code lost:
    
        r11 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:328:0x062d, code lost:
    
        r15 = r42.getPosition();
        r3 = r41.f10315k;
        r5 = r41.f10316l;
        r8 = (r15 + r3) - r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:329:0x063b, code lost:
    
        if (r3 == r5) goto L338;
     */
    /* JADX WARN: Code restructure failed: missing block: B:331:0x063f, code lost:
    
        if (r41.f10314j != 1835365473) goto L338;
     */
    /* JADX WARN: Code restructure failed: missing block: B:332:0x0641, code lost:
    
        r3 = 8;
        r14.reset(8);
        r42.peekFully(r14.getData(), 0, 8);
        r4 = p000.AbstractC1719qc.f25511a;
        r4 = r14.getPosition();
        r5 = 4;
        r14.skipBytes(4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:333:0x065c, code lost:
    
        if (r14.readInt() == 1751411826) goto L337;
     */
    /* JADX WARN: Code restructure failed: missing block: B:334:0x065e, code lost:
    
        r4 = r4 + 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:335:0x065f, code lost:
    
        r14.setPosition(r4);
        r42.skipFully(r14.getPosition());
        r42.resetPeekPosition();
     */
    /* JADX WARN: Code restructure failed: missing block: B:336:0x0670, code lost:
    
        r12.push(new p000.C1301ic(r41.f10314j, r8));
     */
    /* JADX WARN: Code restructure failed: missing block: B:337:0x0681, code lost:
    
        if (r41.f10315k != r41.f10316l) goto L342;
     */
    /* JADX WARN: Code restructure failed: missing block: B:338:0x0683, code lost:
    
        m2559a(r8);
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:340:0x0688, code lost:
    
        r4 = 0;
        r41.f10313i = 0;
        r41.f10316l = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:342:0x066d, code lost:
    
        r3 = 8;
        r5 = 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:345:0x069a, code lost:
    
        throw com.google.android.exoplayer2.ParserException.createForUnsupportedContainerFeature("Atom size less than header length (unsupported).");
     */
    /* JADX WARN: Code restructure failed: missing block: B:347:0x0517, code lost:
    
        if (r9 != 0) goto L265;
     */
    /* JADX WARN: Code restructure failed: missing block: B:348:0x0519, code lost:
    
        r9 = r42.getLength();
     */
    /* JADX WARN: Code restructure failed: missing block: B:349:0x051f, code lost:
    
        if (r9 != (-1)) goto L262;
     */
    /* JADX WARN: Code restructure failed: missing block: B:350:0x0521, code lost:
    
        r11 = (p000.C1301ic) r12.peek();
     */
    /* JADX WARN: Code restructure failed: missing block: B:351:0x0527, code lost:
    
        if (r11 == null) goto L262;
     */
    /* JADX WARN: Code restructure failed: missing block: B:352:0x0529, code lost:
    
        r9 = r11.f18359b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:354:0x052d, code lost:
    
        if (r9 == (-1)) goto L265;
     */
    /* JADX WARN: Code restructure failed: missing block: B:355:0x052f, code lost:
    
        r41.f10315k = (r9 - r42.getPosition()) + r41.f10316l;
     */
    /* JADX WARN: Code restructure failed: missing block: B:358:0x0499, code lost:
    
        if (r41.f10327w != 2) goto L382;
     */
    /* JADX WARN: Code restructure failed: missing block: B:360:0x049e, code lost:
    
        if ((r41.f10305a & 2) == 0) goto L383;
     */
    /* JADX WARN: Code restructure failed: missing block: B:361:0x04a0, code lost:
    
        r0 = r41.f10322r.track(0, 4);
        r2 = r41.f10328x;
     */
    /* JADX WARN: Code restructure failed: missing block: B:362:0x04a9, code lost:
    
        if (r2 != null) goto L246;
     */
    /* JADX WARN: Code restructure failed: missing block: B:363:0x04ab, code lost:
    
        r13 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:364:0x04b7, code lost:
    
        r0.format(new com.google.android.exoplayer2.Format.Builder().setMetadata(r13).build());
        r41.f10322r.endTracks();
        r41.f10322r.seekMap(new com.google.android.exoplayer2.extractor.SeekMap.Unseekable(com.google.android.exoplayer2.C0643C.TIME_UNSET));
     */
    /* JADX WARN: Code restructure failed: missing block: B:365:0x04db, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:366:0x04ad, code lost:
    
        r13 = new com.google.android.exoplayer2.metadata.Metadata(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:367:?, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:368:?, code lost:
    
        return -1;
     */
    @Override // com.google.android.exoplayer2.extractor.Extractor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) {
        int i;
        int i2;
        int i3;
        int i4;
        boolean z;
        long j;
        int i5;
        long j2;
        int i6;
        char c;
        boolean z2;
        int i7;
        int i8 = 3;
        int i9 = 2;
        int i10 = 8;
        int i11 = 0;
        int i12 = 4;
        while (true) {
            boolean z3 = true;
            while (true) {
                int i13 = this.f10313i;
                ArrayDeque arrayDeque = this.f10310f;
                ParsableByteArray parsableByteArray = this.f10308d;
                if (i13 == 0) {
                    break;
                }
                if (i13 != z3) {
                    if (i13 != i9) {
                        if (i13 == i8) {
                            ArrayList arrayList = this.f10312h;
                            vf2 vf2Var = this.f10311g;
                            int i14 = vf2Var.f27762b;
                            if (i14 != 0) {
                                if (i14 != z3) {
                                    ArrayList arrayList2 = vf2Var.f27761a;
                                    short s = 2817;
                                    short s2 = 2192;
                                    if (i14 != i9) {
                                        if (i14 == i8) {
                                            long position = extractorInput.getPosition();
                                            int length = (int) ((extractorInput.getLength() - extractorInput.getPosition()) - vf2Var.f27763c);
                                            ParsableByteArray parsableByteArray2 = new ParsableByteArray(length);
                                            extractorInput.readFully(parsableByteArray2.getData(), i11, length);
                                            int i15 = i11;
                                            while (i15 < arrayList2.size()) {
                                                uf2 uf2Var = (uf2) arrayList2.get(i15);
                                                parsableByteArray2.setPosition((int) (uf2Var.f27249a - position));
                                                parsableByteArray2.skipBytes(i12);
                                                int readLittleEndianInt = parsableByteArray2.readLittleEndianInt();
                                                String readString = parsableByteArray2.readString(readLittleEndianInt);
                                                readString.getClass();
                                                switch (readString.hashCode()) {
                                                    case -1711564334:
                                                        if (readString.equals("SlowMotion_Data")) {
                                                            i6 = i11;
                                                            break;
                                                        }
                                                        break;
                                                    case -1332107749:
                                                        if (readString.equals("Super_SlowMotion_Edit_Data")) {
                                                            i6 = 1;
                                                            break;
                                                        }
                                                        break;
                                                    case -1251387154:
                                                        if (readString.equals("Super_SlowMotion_Data")) {
                                                            i6 = 2;
                                                            break;
                                                        }
                                                        break;
                                                    case -830665521:
                                                        if (readString.equals("Super_SlowMotion_Deflickering_On")) {
                                                            i6 = i8;
                                                            break;
                                                        }
                                                        break;
                                                    case 1760745220:
                                                        if (readString.equals("Super_SlowMotion_BGM")) {
                                                            i6 = 4;
                                                            break;
                                                        }
                                                        break;
                                                }
                                                i6 = -1;
                                                switch (i6) {
                                                    case 0:
                                                        c = 2192;
                                                        break;
                                                    case 1:
                                                        c = 2819;
                                                        break;
                                                    case 2:
                                                        c = 2816;
                                                        break;
                                                    case 3:
                                                        c = 2820;
                                                        break;
                                                    case 4:
                                                        c = 2817;
                                                        break;
                                                    default:
                                                        throw ParserException.createForMalformedContainer("Invalid SEF name", null);
                                                }
                                                int i16 = uf2Var.f27250b - (readLittleEndianInt + i10);
                                                if (c != 2192) {
                                                    if (c != 2816 && c != 2817 && c != 2819 && c != 2820) {
                                                        throw new IllegalStateException();
                                                    }
                                                } else {
                                                    ArrayList arrayList3 = new ArrayList();
                                                    List<String> splitToList = vf2.f27760e.splitToList(parsableByteArray2.readString(i16));
                                                    for (int i17 = i11; i17 < splitToList.size(); i17++) {
                                                        List<String> splitToList2 = vf2.f27759d.splitToList(splitToList.get(i17));
                                                        if (splitToList2.size() == i8) {
                                                            try {
                                                                arrayList3.add(new SlowMotionData.Segment(Long.parseLong(splitToList2.get(i11)), Long.parseLong(splitToList2.get(1)), 1 << (Integer.parseInt(splitToList2.get(2)) - 1)));
                                                            } catch (NumberFormatException e) {
                                                                throw ParserException.createForMalformedContainer(null, e);
                                                            }
                                                        } else {
                                                            throw ParserException.createForMalformedContainer(null, null);
                                                        }
                                                    }
                                                    arrayList.add(new SlowMotionData(arrayList3));
                                                }
                                                i15++;
                                                i10 = 8;
                                                i12 = 4;
                                            }
                                            positionHolder.position = 0L;
                                        } else {
                                            throw new IllegalStateException();
                                        }
                                    } else {
                                        long length2 = extractorInput.getLength();
                                        int i18 = vf2Var.f27763c - 20;
                                        ParsableByteArray parsableByteArray3 = new ParsableByteArray(i18);
                                        extractorInput.readFully(parsableByteArray3.getData(), i11, i18);
                                        int i19 = i11;
                                        while (i19 < i18 / 12) {
                                            parsableByteArray3.skipBytes(2);
                                            short readLittleEndianShort = parsableByteArray3.readLittleEndianShort();
                                            if (readLittleEndianShort != s2 && readLittleEndianShort != 2816 && readLittleEndianShort != s) {
                                                if (readLittleEndianShort != 2819 && readLittleEndianShort != 2820) {
                                                    parsableByteArray3.skipBytes(8);
                                                    j2 = length2;
                                                    i19++;
                                                    length2 = j2;
                                                    s = 2817;
                                                    s2 = 2192;
                                                }
                                            }
                                            j2 = length2;
                                            arrayList2.add(new uf2((length2 - vf2Var.f27763c) - parsableByteArray3.readLittleEndianInt(), parsableByteArray3.readLittleEndianInt()));
                                            i19++;
                                            length2 = j2;
                                            s = 2817;
                                            s2 = 2192;
                                        }
                                        if (arrayList2.isEmpty()) {
                                            positionHolder.position = 0L;
                                        } else {
                                            vf2Var.f27762b = i8;
                                            positionHolder.position = ((uf2) arrayList2.get(i11)).f27249a;
                                        }
                                    }
                                } else {
                                    ParsableByteArray parsableByteArray4 = new ParsableByteArray(8);
                                    extractorInput.readFully(parsableByteArray4.getData(), i11, 8);
                                    vf2Var.f27763c = parsableByteArray4.readLittleEndianInt() + 8;
                                    if (parsableByteArray4.readInt() != 1397048916) {
                                        positionHolder.position = 0L;
                                    } else {
                                        positionHolder.position = extractorInput.getPosition() - (vf2Var.f27763c - 12);
                                        vf2Var.f27762b = 2;
                                    }
                                }
                                i5 = 1;
                            } else {
                                long length3 = extractorInput.getLength();
                                if (length3 != -1 && length3 >= 8) {
                                    j = length3 - 8;
                                } else {
                                    j = 0;
                                }
                                positionHolder.position = j;
                                i5 = 1;
                                vf2Var.f27762b = 1;
                            }
                            if (positionHolder.position == 0) {
                                this.f10313i = i11;
                                this.f10316l = i11;
                            }
                            return i5;
                        }
                        throw new IllegalStateException();
                    }
                    long position2 = extractorInput.getPosition();
                    if (this.f10318n == -1) {
                        int i20 = i11;
                        int i21 = -1;
                        int i22 = -1;
                        boolean z4 = true;
                        boolean z5 = true;
                        long j3 = Long.MAX_VALUE;
                        long j4 = Long.MAX_VALUE;
                        long j5 = Long.MAX_VALUE;
                        while (true) {
                            mp1[] mp1VarArr = this.f10323s;
                            if (i20 >= mp1VarArr.length) {
                                break;
                            }
                            mp1 mp1Var = mp1VarArr[i20];
                            int i23 = mp1Var.f23049e;
                            ev2 ev2Var = mp1Var.f23046b;
                            if (i23 != ev2Var.f16999b) {
                                long j6 = ev2Var.f17000c[i23];
                                long j7 = ((long[][]) Util.castNonNull(this.f10324t))[i20][i23];
                                long j8 = j6 - position2;
                                if (j8 >= 0 && j8 < PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
                                    z = false;
                                } else {
                                    z = true;
                                }
                                if ((!z && z5) || (z == z5 && j8 < j5)) {
                                    z5 = z;
                                    j5 = j8;
                                    i22 = i20;
                                    j4 = j7;
                                }
                                if (j7 < j3) {
                                    z4 = z;
                                    i21 = i20;
                                    j3 = j7;
                                }
                            }
                            i20++;
                        }
                        if (j3 == Long.MAX_VALUE || !z4 || j4 < j3 + 10485760) {
                            i21 = i22;
                        }
                        this.f10318n = i21;
                        if (i21 == -1) {
                            return -1;
                        }
                    }
                    mp1 mp1Var2 = this.f10323s[this.f10318n];
                    TrackOutput trackOutput = mp1Var2.f23047c;
                    int i24 = mp1Var2.f23049e;
                    ev2 ev2Var2 = mp1Var2.f23046b;
                    long j9 = ev2Var2.f17000c[i24];
                    int i25 = ev2Var2.f17001d[i24];
                    long j10 = (j9 - position2) + this.f10319o;
                    if (j10 >= 0 && j10 < PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
                        Track track = mp1Var2.f23045a;
                        if (track.sampleTransformation == 1) {
                            j10 += 8;
                            i25 -= 8;
                        }
                        extractorInput.skipFully((int) j10);
                        int i26 = track.nalUnitLengthFieldLength;
                        TrueHdSampleRechunker trueHdSampleRechunker = mp1Var2.f23048d;
                        if (i26 != 0) {
                            ParsableByteArray parsableByteArray5 = this.f10307c;
                            byte[] data = parsableByteArray5.getData();
                            data[0] = 0;
                            data[1] = 0;
                            data[2] = 0;
                            int i27 = track.nalUnitLengthFieldLength;
                            int i28 = 4 - i27;
                            while (this.f10320p < i25) {
                                int i29 = this.f10321q;
                                if (i29 == 0) {
                                    extractorInput.readFully(data, i28, i27);
                                    this.f10319o += i27;
                                    parsableByteArray5.setPosition(0);
                                    int readInt = parsableByteArray5.readInt();
                                    if (readInt >= 0) {
                                        this.f10321q = readInt;
                                        ParsableByteArray parsableByteArray6 = this.f10306b;
                                        parsableByteArray6.setPosition(0);
                                        trackOutput.sampleData(parsableByteArray6, 4);
                                        this.f10320p += 4;
                                        i25 += i28;
                                    } else {
                                        throw ParserException.createForMalformedContainer("Invalid NAL length", null);
                                    }
                                } else {
                                    int sampleData = trackOutput.sampleData((DataReader) extractorInput, i29, false);
                                    this.f10319o += sampleData;
                                    this.f10320p += sampleData;
                                    this.f10321q -= sampleData;
                                }
                            }
                        } else {
                            if (MimeTypes.AUDIO_AC4.equals(track.format.sampleMimeType)) {
                                if (this.f10320p == 0) {
                                    Ac4Util.getAc4SampleHeader(i25, parsableByteArray);
                                    i4 = 7;
                                    trackOutput.sampleData(parsableByteArray, 7);
                                    this.f10320p += 7;
                                } else {
                                    i4 = 7;
                                }
                                i25 += i4;
                            } else if (trueHdSampleRechunker != null) {
                                trueHdSampleRechunker.startSample(extractorInput);
                            }
                            while (true) {
                                int i30 = this.f10320p;
                                if (i30 >= i25) {
                                    break;
                                }
                                int sampleData2 = trackOutput.sampleData((DataReader) extractorInput, i25 - i30, false);
                                this.f10319o += sampleData2;
                                this.f10320p += sampleData2;
                                this.f10321q -= sampleData2;
                            }
                        }
                        int i31 = i25;
                        long j11 = ev2Var2.f17003f[i24];
                        int i32 = ev2Var2.f17004g[i24];
                        if (trueHdSampleRechunker != null) {
                            trueHdSampleRechunker.sampleMetadata(trackOutput, j11, i32, i31, 0, null);
                            if (i24 + 1 == ev2Var2.f16999b) {
                                trueHdSampleRechunker.outputPendingSampleMetadata(trackOutput, null);
                            }
                        } else {
                            trackOutput.sampleMetadata(j11, i32, i31, 0, null);
                        }
                        mp1Var2.f23049e++;
                        this.f10318n = -1;
                        this.f10319o = 0;
                        this.f10320p = 0;
                        this.f10321q = 0;
                        return 0;
                    }
                    positionHolder.position = j9;
                    return 1;
                }
                long j12 = this.f10315k - this.f10316l;
                long position3 = extractorInput.getPosition() + j12;
                ParsableByteArray parsableByteArray7 = this.f10317m;
                if (parsableByteArray7 != null) {
                    extractorInput.readFully(parsableByteArray7.getData(), this.f10316l, (int) j12);
                    if (this.f10314j == 1718909296) {
                        parsableByteArray7.setPosition(8);
                        int readInt2 = parsableByteArray7.readInt();
                        if (readInt2 != 1751476579) {
                            if (readInt2 != 1903435808) {
                                i7 = 0;
                            } else {
                                i7 = 1;
                            }
                        } else {
                            i7 = 2;
                        }
                        if (i7 == 0) {
                            parsableByteArray7.skipBytes(4);
                            while (true) {
                                if (parsableByteArray7.bytesLeft() > 0) {
                                    int readInt3 = parsableByteArray7.readInt();
                                    if (readInt3 != 1751476579) {
                                        if (readInt3 != 1903435808) {
                                            i7 = 0;
                                        } else {
                                            i7 = 1;
                                        }
                                    } else {
                                        i7 = 2;
                                    }
                                    if (i7 != 0) {
                                        break;
                                    }
                                } else {
                                    i7 = 0;
                                    break;
                                }
                            }
                        }
                        this.f10327w = i7;
                    } else if (!arrayDeque.isEmpty()) {
                        ((C1301ic) arrayDeque.peek()).f18360c.add(new C1349jc(this.f10314j, parsableByteArray7));
                    }
                } else if (j12 < PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
                    extractorInput.skipFully((int) j12);
                } else {
                    positionHolder.position = extractorInput.getPosition() + j12;
                    z2 = true;
                    m2559a(position3);
                    if (!z2 && this.f10313i != 2) {
                        return 1;
                    }
                    z3 = true;
                    i9 = 2;
                    i10 = 8;
                    i11 = 0;
                    i12 = 4;
                }
                z2 = false;
                m2559a(position3);
                if (!z2) {
                }
                z3 = true;
                i9 = 2;
                i10 = 8;
                i11 = 0;
                i12 = 4;
            }
            i10 = i;
            i11 = i3;
            i12 = i2;
            i8 = 3;
            i9 = 2;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j, long j2) {
        this.f10310f.clear();
        this.f10316l = 0;
        this.f10318n = -1;
        this.f10319o = 0;
        this.f10320p = 0;
        this.f10321q = 0;
        if (j == 0) {
            if (this.f10313i != 3) {
                this.f10313i = 0;
                this.f10316l = 0;
                return;
            } else {
                vf2 vf2Var = this.f10311g;
                vf2Var.f27761a.clear();
                vf2Var.f27762b = 0;
                this.f10312h.clear();
                return;
            }
        }
        for (mp1 mp1Var : this.f10323s) {
            ev2 ev2Var = mp1Var.f23046b;
            int binarySearchFloor = Util.binarySearchFloor(ev2Var.f17003f, j2, true, false);
            while (true) {
                if (binarySearchFloor >= 0) {
                    if ((ev2Var.f17004g[binarySearchFloor] & 1) != 0) {
                        break;
                    } else {
                        binarySearchFloor--;
                    }
                } else {
                    binarySearchFloor = -1;
                    break;
                }
            }
            if (binarySearchFloor == -1) {
                binarySearchFloor = ev2Var.m4759a(j2);
            }
            mp1Var.f23049e = binarySearchFloor;
            TrueHdSampleRechunker trueHdSampleRechunker = mp1Var.f23048d;
            if (trueHdSampleRechunker != null) {
                trueHdSampleRechunker.reset();
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(ExtractorInput extractorInput) {
        boolean z;
        if ((this.f10305a & 2) != 0) {
            z = true;
        } else {
            z = false;
        }
        return p63.m6851K(extractorInput, false, z);
    }

    public Mp4Extractor(int i) {
        this.f10305a = i;
        this.f10313i = (i & 4) != 0 ? 3 : 0;
        this.f10311g = new vf2();
        this.f10312h = new ArrayList();
        this.f10309e = new ParsableByteArray(16);
        this.f10310f = new ArrayDeque();
        this.f10306b = new ParsableByteArray(NalUnitUtil.NAL_START_CODE);
        this.f10307c = new ParsableByteArray(4);
        this.f10308d = new ParsableByteArray();
        this.f10318n = -1;
        this.f10322r = ExtractorOutput.PLACEHOLDER;
        this.f10323s = new mp1[0];
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00f5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SeekMap.SeekPoints getSeekPoints(long j, int i) {
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        int i2;
        boolean z;
        int i3;
        boolean z2;
        int[] iArr;
        int m4759a;
        mp1[] mp1VarArr = this.f10323s;
        if (mp1VarArr.length == 0) {
            return new SeekMap.SeekPoints(SeekPoint.START);
        }
        int i4 = -1;
        int i5 = i != -1 ? i : this.f10325u;
        boolean z3 = false;
        boolean z4 = true;
        if (i5 != -1) {
            ev2 ev2Var = mp1VarArr[i5].f23046b;
            long[] jArr = ev2Var.f17003f;
            int binarySearchFloor = Util.binarySearchFloor(jArr, j, true, false);
            while (true) {
                if (binarySearchFloor < 0) {
                    binarySearchFloor = -1;
                    break;
                }
                if ((ev2Var.f17004g[binarySearchFloor] & 1) != 0) {
                    break;
                }
                binarySearchFloor--;
            }
            if (binarySearchFloor == -1) {
                binarySearchFloor = ev2Var.m4759a(j);
            }
            if (binarySearchFloor == -1) {
                return new SeekMap.SeekPoints(SeekPoint.START);
            }
            j3 = jArr[binarySearchFloor];
            long[] jArr2 = ev2Var.f17000c;
            j2 = jArr2[binarySearchFloor];
            if (j3 < j && binarySearchFloor < ev2Var.f16999b - 1 && (m4759a = ev2Var.m4759a(j)) != -1 && m4759a != binarySearchFloor) {
                long j7 = jArr[m4759a];
                long j8 = jArr2[m4759a];
                j4 = j7;
                j5 = j8;
                if (i != -1) {
                    int i6 = 0;
                    j6 = j2;
                    while (true) {
                        mp1[] mp1VarArr2 = this.f10323s;
                        if (i6 >= mp1VarArr2.length) {
                            break;
                        }
                        if (i6 != this.f10325u) {
                            ev2 ev2Var2 = mp1VarArr2[i6].f23046b;
                            long[] jArr3 = ev2Var2.f17003f;
                            int binarySearchFloor2 = Util.binarySearchFloor(jArr3, j3, z4, z3);
                            while (true) {
                                iArr = ev2Var2.f17004g;
                                if (binarySearchFloor2 < 0) {
                                    binarySearchFloor2 = i4;
                                    break;
                                }
                                if ((iArr[binarySearchFloor2] & 1) != 0) {
                                    break;
                                }
                                binarySearchFloor2--;
                            }
                            if (binarySearchFloor2 == i4) {
                                binarySearchFloor2 = ev2Var2.m4759a(j3);
                            }
                            long[] jArr4 = ev2Var2.f17000c;
                            if (binarySearchFloor2 == i4) {
                                i2 = i6;
                            } else {
                                i2 = i6;
                                j6 = Math.min(jArr4[binarySearchFloor2], j6);
                            }
                            z2 = false;
                            z = true;
                            if (j4 != C0643C.TIME_UNSET) {
                                int binarySearchFloor3 = Util.binarySearchFloor(jArr3, j4, true, false);
                                while (true) {
                                    if (binarySearchFloor3 < 0) {
                                        i3 = -1;
                                        binarySearchFloor3 = -1;
                                        break;
                                    }
                                    if ((iArr[binarySearchFloor3] & 1) != 0) {
                                        i3 = -1;
                                        break;
                                    }
                                    binarySearchFloor3--;
                                }
                                if (binarySearchFloor3 == i3) {
                                    binarySearchFloor3 = ev2Var2.m4759a(j4);
                                }
                                if (binarySearchFloor3 != i3) {
                                    j5 = Math.min(jArr4[binarySearchFloor3], j5);
                                }
                            } else {
                                i3 = -1;
                            }
                        } else {
                            i2 = i6;
                            z = z4;
                            boolean z5 = z3;
                            i3 = i4;
                            z2 = z5;
                        }
                        int i7 = i3;
                        z3 = z2;
                        i4 = i7;
                        z4 = z;
                        i6 = i2 + 1;
                    }
                } else {
                    j6 = j2;
                }
                SeekPoint seekPoint = new SeekPoint(j3, j6);
                if (j4 != C0643C.TIME_UNSET) {
                    return new SeekMap.SeekPoints(seekPoint);
                }
                return new SeekMap.SeekPoints(seekPoint, new SeekPoint(j4, j5));
            }
        } else {
            j2 = Long.MAX_VALUE;
            j3 = j;
        }
        j4 = C0643C.TIME_UNSET;
        j5 = -1;
        if (i != -1) {
        }
        SeekPoint seekPoint2 = new SeekPoint(j3, j6);
        if (j4 != C0643C.TIME_UNSET) {
        }
    }
}
