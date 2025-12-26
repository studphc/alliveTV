package com.google.android.exoplayer2.extractor.mp4;

import android.util.Pair;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.GaplessInfoHolder;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.p002ts.PsExtractor;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.metadata.emsg.EventMessageEncoder;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Ascii;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import p000.AbstractC1386kc;
import p000.AbstractC1719qc;
import p000.AbstractC1726qj;
import p000.C1301ic;
import p000.C1349jc;
import p000.cv2;
import p000.ee0;
import p000.ev2;
import p000.f10;
import p000.p63;
import p000.qu0;
import p000.ru0;
import p000.ye0;
import p000.z90;

/* loaded from: classes.dex */
public class FragmentedMp4Extractor implements Extractor {
    public static final int FLAG_ENABLE_EMSG_TRACK = 4;
    public static final int FLAG_WORKAROUND_EVERY_VIDEO_FRAME_IS_SYNC_FRAME = 1;
    public static final int FLAG_WORKAROUND_IGNORE_EDIT_LISTS = 16;
    public static final int FLAG_WORKAROUND_IGNORE_TFDT_BOX = 2;

    /* renamed from: A */
    public int f10271A;

    /* renamed from: B */
    public int f10272B;

    /* renamed from: C */
    public int f10273C;

    /* renamed from: D */
    public boolean f10274D;

    /* renamed from: E */
    public ExtractorOutput f10275E;

    /* renamed from: F */
    public TrackOutput[] f10276F;

    /* renamed from: G */
    public TrackOutput[] f10277G;

    /* renamed from: H */
    public boolean f10278H;

    /* renamed from: a */
    public final int f10279a;

    /* renamed from: b */
    public final Track f10280b;

    /* renamed from: c */
    public final List f10281c;

    /* renamed from: d */
    public final SparseArray f10282d;

    /* renamed from: e */
    public final ParsableByteArray f10283e;

    /* renamed from: f */
    public final ParsableByteArray f10284f;

    /* renamed from: g */
    public final ParsableByteArray f10285g;

    /* renamed from: h */
    public final byte[] f10286h;

    /* renamed from: i */
    public final ParsableByteArray f10287i;

    /* renamed from: j */
    public final TimestampAdjuster f10288j;

    /* renamed from: k */
    public final EventMessageEncoder f10289k;

    /* renamed from: l */
    public final ParsableByteArray f10290l;

    /* renamed from: m */
    public final ArrayDeque f10291m;

    /* renamed from: n */
    public final ArrayDeque f10292n;

    /* renamed from: o */
    public final TrackOutput f10293o;

    /* renamed from: p */
    public int f10294p;

    /* renamed from: q */
    public int f10295q;

    /* renamed from: r */
    public long f10296r;

    /* renamed from: s */
    public int f10297s;

    /* renamed from: t */
    public ParsableByteArray f10298t;

    /* renamed from: u */
    public long f10299u;

    /* renamed from: v */
    public int f10300v;

    /* renamed from: w */
    public long f10301w;

    /* renamed from: x */
    public long f10302x;

    /* renamed from: y */
    public long f10303y;

    /* renamed from: z */
    public ru0 f10304z;
    public static final ExtractorsFactory FACTORY = new ee0(5);

    /* renamed from: I */
    public static final byte[] f10269I = {-94, 57, 79, 82, 90, -101, 79, Ascii.DC4, -94, 68, 108, 66, 124, 100, -115, -12};

    /* renamed from: J */
    public static final Format f10270J = new Format.Builder().setSampleMimeType(MimeTypes.APPLICATION_EMSG).build();

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface Flags {
    }

    public FragmentedMp4Extractor() {
        this(0);
    }

    /* renamed from: a */
    public static DrmInitData m2556a(ArrayList arrayList) {
        int size = arrayList.size();
        ArrayList arrayList2 = null;
        for (int i = 0; i < size; i++) {
            C1349jc c1349jc = (C1349jc) arrayList.get(i);
            if (c1349jc.f20817a == 1886614376) {
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                byte[] data = c1349jc.f20458b.getData();
                UUID parseUuid = PsshAtomUtil.parseUuid(data);
                if (parseUuid == null) {
                    Log.m3027w("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
                } else {
                    arrayList2.add(new DrmInitData.SchemeData(parseUuid, MimeTypes.VIDEO_MP4, data));
                }
            }
        }
        if (arrayList2 == null) {
            return null;
        }
        return new DrmInitData(arrayList2);
    }

    /* renamed from: b */
    public static void m2557b(ParsableByteArray parsableByteArray, int i, cv2 cv2Var) {
        boolean z;
        parsableByteArray.setPosition(i + 8);
        int readInt = parsableByteArray.readInt();
        if ((readInt & 1) == 0) {
            if ((readInt & 2) != 0) {
                z = true;
            } else {
                z = false;
            }
            int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
            if (readUnsignedIntToInt == 0) {
                Arrays.fill(cv2Var.f16140l, 0, cv2Var.f16133e, false);
                return;
            }
            if (readUnsignedIntToInt == cv2Var.f16133e) {
                Arrays.fill(cv2Var.f16140l, 0, readUnsignedIntToInt, z);
                int bytesLeft = parsableByteArray.bytesLeft();
                ParsableByteArray parsableByteArray2 = cv2Var.f16142n;
                parsableByteArray2.reset(bytesLeft);
                cv2Var.f16139k = true;
                cv2Var.f16143o = true;
                parsableByteArray.readBytes(parsableByteArray2.getData(), 0, parsableByteArray2.limit());
                parsableByteArray2.setPosition(0);
                cv2Var.f16143o = false;
                return;
            }
            StringBuilder m8299s = ye0.m8299s(readUnsignedIntToInt, "Senc sample count ", " is different from fragment sample count");
            m8299s.append(cv2Var.f16133e);
            throw ParserException.createForMalformedContainer(m8299s.toString(), null);
        }
        throw ParserException.createForUnsupportedContainerFeature("Overriding TrackEncryptionBox parameters is unsupported.");
    }

    /* JADX WARN: Code restructure failed: missing block: B:388:0x07c5, code lost:
    
        r5 = r0;
        r5.f10294p = 0;
        r5.f10297s = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:389:0x07cb, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:293:0x06bb  */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m2558c(long j) {
        FragmentedMp4Extractor fragmentedMp4Extractor;
        boolean z;
        String str;
        boolean z2;
        ArrayList arrayList;
        int i;
        ArrayList arrayList2;
        int i2;
        int i3;
        SparseArray sparseArray;
        FragmentedMp4Extractor fragmentedMp4Extractor2;
        Object obj;
        ArrayList arrayList3;
        int i4;
        int i5;
        int i6;
        int i7;
        String str2;
        int size;
        int i8;
        boolean z3;
        long readUnsignedLongToLong;
        boolean z4;
        int i9;
        boolean z5;
        boolean z6;
        int i10;
        ArrayList arrayList4;
        int i11;
        C1301ic c1301ic;
        int i12;
        int i13;
        ArrayList arrayList5;
        SparseArray sparseArray2;
        ru0 ru0Var;
        int i14;
        cv2 cv2Var;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        boolean z12;
        int i15;
        int i16;
        boolean z13;
        boolean z14;
        int i17;
        int i18;
        boolean z15;
        f10 f10Var;
        boolean z16;
        int i19;
        boolean z17;
        ParsableByteArray parsableByteArray;
        ru0 ru0Var2;
        boolean z18;
        long readUnsignedInt;
        boolean z19;
        boolean z20;
        boolean z21;
        Object checkNotNull;
        Object checkNotNull2;
        C1301ic c1301ic2;
        long readUnsignedLongToLong2;
        FragmentedMp4Extractor fragmentedMp4Extractor3 = this;
        while (true) {
            ArrayDeque arrayDeque = fragmentedMp4Extractor3.f10291m;
            if (arrayDeque.isEmpty() || ((C1301ic) arrayDeque.peek()).f18359b != j) {
                break;
            }
            C1301ic c1301ic3 = (C1301ic) arrayDeque.pop();
            int i20 = c1301ic3.f20817a;
            SparseArray sparseArray3 = fragmentedMp4Extractor3.f10282d;
            ArrayList arrayList6 = c1301ic3.f18360c;
            int i21 = 1;
            int i22 = fragmentedMp4Extractor3.f10279a;
            int i23 = 12;
            Track track = fragmentedMp4Extractor3.f10280b;
            if (i20 == 1836019574) {
                if (track == null) {
                    z19 = true;
                } else {
                    z19 = false;
                }
                Assertions.checkState(z19, "Unexpected moov box.");
                DrmInitData m2556a = m2556a(arrayList6);
                C1301ic c1301ic4 = (C1301ic) Assertions.checkNotNull(c1301ic3.m5206c(1836475768));
                SparseArray sparseArray4 = new SparseArray();
                int size2 = c1301ic4.f18360c.size();
                int i24 = 0;
                long j2 = C0643C.TIME_UNSET;
                while (i24 < size2) {
                    C1349jc c1349jc = (C1349jc) c1301ic4.f18360c.get(i24);
                    int i25 = c1349jc.f20817a;
                    ParsableByteArray parsableByteArray2 = c1349jc.f20458b;
                    if (i25 == 1953654136) {
                        parsableByteArray2.setPosition(i23);
                        c1301ic2 = c1301ic4;
                        Pair create = Pair.create(Integer.valueOf(parsableByteArray2.readInt()), new f10(parsableByteArray2.readInt() - i21, parsableByteArray2.readInt(), parsableByteArray2.readInt(), parsableByteArray2.readInt()));
                        sparseArray4.put(((Integer) create.first).intValue(), (f10) create.second);
                    } else {
                        c1301ic2 = c1301ic4;
                        if (i25 == 1835362404) {
                            parsableByteArray2.setPosition(8);
                            if (AbstractC1386kc.m5518b(parsableByteArray2.readInt()) == 0) {
                                readUnsignedLongToLong2 = parsableByteArray2.readUnsignedInt();
                            } else {
                                readUnsignedLongToLong2 = parsableByteArray2.readUnsignedLongToLong();
                            }
                            j2 = readUnsignedLongToLong2;
                        }
                    }
                    i24++;
                    c1301ic4 = c1301ic2;
                    i23 = 12;
                    i21 = 1;
                }
                GaplessInfoHolder gaplessInfoHolder = new GaplessInfoHolder();
                if ((i22 & 16) != 0) {
                    z20 = true;
                } else {
                    z20 = false;
                }
                ArrayList m7023e = AbstractC1719qc.m7023e(c1301ic3, gaplessInfoHolder, j2, m2556a, z20, false, new z90(2, fragmentedMp4Extractor3));
                int size3 = m7023e.size();
                if (sparseArray3.size() == 0) {
                    for (int i26 = 0; i26 < size3; i26++) {
                        ev2 ev2Var = (ev2) m7023e.get(i26);
                        Track track2 = ev2Var.f16998a;
                        TrackOutput track3 = fragmentedMp4Extractor3.f10275E.track(i26, track2.type);
                        int i27 = track2.f10330id;
                        if (sparseArray4.size() == 1) {
                            checkNotNull2 = sparseArray4.valueAt(0);
                        } else {
                            checkNotNull2 = Assertions.checkNotNull((f10) sparseArray4.get(i27));
                        }
                        sparseArray3.put(track2.f10330id, new ru0(track3, ev2Var, (f10) checkNotNull2));
                        fragmentedMp4Extractor3.f10302x = Math.max(fragmentedMp4Extractor3.f10302x, track2.durationUs);
                    }
                    fragmentedMp4Extractor3.f10275E.endTracks();
                } else {
                    if (sparseArray3.size() == size3) {
                        z21 = true;
                    } else {
                        z21 = false;
                    }
                    Assertions.checkState(z21);
                    for (int i28 = 0; i28 < size3; i28++) {
                        ev2 ev2Var2 = (ev2) m7023e.get(i28);
                        Track track4 = ev2Var2.f16998a;
                        ru0 ru0Var3 = (ru0) sparseArray3.get(track4.f10330id);
                        int i29 = track4.f10330id;
                        if (sparseArray4.size() == 1) {
                            checkNotNull = sparseArray4.valueAt(0);
                        } else {
                            checkNotNull = Assertions.checkNotNull((f10) sparseArray4.get(i29));
                        }
                        ru0Var3.f26144d = ev2Var2;
                        ru0Var3.f26145e = (f10) checkNotNull;
                        ru0Var3.f26141a.format(ev2Var2.f16998a.format);
                        ru0Var3.m7307d();
                    }
                }
                fragmentedMp4Extractor = fragmentedMp4Extractor3;
            } else if (i20 == 1836019558) {
                if (track != null) {
                    z = true;
                } else {
                    z = false;
                }
                ArrayList arrayList7 = c1301ic3.f18361d;
                int size4 = arrayList7.size();
                int i30 = 0;
                while (i30 < size4) {
                    C1301ic c1301ic5 = (C1301ic) arrayList7.get(i30);
                    if (c1301ic5.f20817a == 1953653094) {
                        ParsableByteArray parsableByteArray3 = ((C1349jc) Assertions.checkNotNull(c1301ic5.m5207d(1952868452))).f20458b;
                        parsableByteArray3.setPosition(8);
                        int readInt = parsableByteArray3.readInt();
                        int readInt2 = parsableByteArray3.readInt();
                        if (z) {
                            obj = sparseArray3.valueAt(0);
                        } else {
                            obj = sparseArray3.get(readInt2);
                        }
                        ru0 ru0Var4 = (ru0) obj;
                        if (ru0Var4 == null) {
                            z2 = z;
                            arrayList3 = arrayList6;
                            ru0Var4 = null;
                        } else {
                            int i31 = readInt & 1;
                            cv2 cv2Var2 = ru0Var4.f26142b;
                            arrayList3 = arrayList6;
                            if (i31 != 0) {
                                long readUnsignedLongToLong3 = parsableByteArray3.readUnsignedLongToLong();
                                cv2Var2.f16130b = readUnsignedLongToLong3;
                                cv2Var2.f16131c = readUnsignedLongToLong3;
                            }
                            f10 f10Var2 = ru0Var4.f26145e;
                            int readInt3 = (readInt & 2) != 0 ? parsableByteArray3.readInt() - 1 : f10Var2.f17072a;
                            if ((readInt & 8) != 0) {
                                i4 = parsableByteArray3.readInt();
                            } else {
                                i4 = f10Var2.f17073b;
                            }
                            if ((readInt & 16) != 0) {
                                z2 = z;
                                i5 = parsableByteArray3.readInt();
                            } else {
                                z2 = z;
                                i5 = f10Var2.f17074c;
                            }
                            if ((readInt & 32) != 0) {
                                i6 = parsableByteArray3.readInt();
                            } else {
                                i6 = f10Var2.f17075d;
                            }
                            cv2Var2.f16129a = new f10(readInt3, i4, i5, i6);
                        }
                        if (ru0Var4 == null) {
                            fragmentedMp4Extractor2 = fragmentedMp4Extractor3;
                            arrayList = arrayList7;
                            i = size4;
                            i2 = i22;
                            i3 = i30;
                            arrayList2 = arrayList3;
                            sparseArray = sparseArray3;
                        } else {
                            cv2 cv2Var3 = ru0Var4.f26142b;
                            long j3 = cv2Var3.f16144p;
                            boolean z22 = cv2Var3.f16145q;
                            ru0Var4.m7307d();
                            ru0Var4.f26152l = true;
                            C1349jc m5207d = c1301ic5.m5207d(1952867444);
                            if (m5207d != null && (i22 & 2) == 0) {
                                ParsableByteArray parsableByteArray4 = m5207d.f20458b;
                                parsableByteArray4.setPosition(8);
                                if (AbstractC1386kc.m5518b(parsableByteArray4.readInt()) == 1) {
                                    readUnsignedInt = parsableByteArray4.readUnsignedLongToLong();
                                } else {
                                    readUnsignedInt = parsableByteArray4.readUnsignedInt();
                                }
                                cv2Var3.f16144p = readUnsignedInt;
                                cv2Var3.f16145q = true;
                            } else {
                                cv2Var3.f16144p = j3;
                                cv2Var3.f16145q = z22;
                            }
                            ArrayList arrayList8 = c1301ic5.f18360c;
                            int size5 = arrayList8.size();
                            int i32 = 0;
                            int i33 = 0;
                            int i34 = 0;
                            while (true) {
                                i7 = 1953658222;
                                if (i32 >= size5) {
                                    break;
                                }
                                ArrayList arrayList9 = arrayList7;
                                C1349jc c1349jc2 = (C1349jc) arrayList8.get(i32);
                                int i35 = size4;
                                if (c1349jc2.f20817a == 1953658222) {
                                    ParsableByteArray parsableByteArray5 = c1349jc2.f20458b;
                                    parsableByteArray5.setPosition(12);
                                    int readUnsignedIntToInt = parsableByteArray5.readUnsignedIntToInt();
                                    if (readUnsignedIntToInt > 0) {
                                        i34 += readUnsignedIntToInt;
                                        i33++;
                                    }
                                }
                                i32++;
                                size4 = i35;
                                arrayList7 = arrayList9;
                            }
                            arrayList = arrayList7;
                            i = size4;
                            ru0Var4.f26148h = 0;
                            ru0Var4.f26147g = 0;
                            ru0Var4.f26146f = 0;
                            cv2Var3.f16132d = i33;
                            cv2Var3.f16133e = i34;
                            if (cv2Var3.f16135g.length < i33) {
                                cv2Var3.f16134f = new long[i33];
                                cv2Var3.f16135g = new int[i33];
                            }
                            if (cv2Var3.f16136h.length < i34) {
                                int i36 = (i34 * 125) / 100;
                                cv2Var3.f16136h = new int[i36];
                                cv2Var3.f16137i = new long[i36];
                                cv2Var3.f16138j = new boolean[i36];
                                cv2Var3.f16140l = new boolean[i36];
                            }
                            int i37 = 0;
                            int i38 = 0;
                            int i39 = 0;
                            while (true) {
                                long j4 = 0;
                                if (i37 < size5) {
                                    C1349jc c1349jc3 = (C1349jc) arrayList8.get(i37);
                                    if (c1349jc3.f20817a == i7) {
                                        int i40 = i38 + 1;
                                        ParsableByteArray parsableByteArray6 = c1349jc3.f20458b;
                                        parsableByteArray6.setPosition(8);
                                        int readInt4 = parsableByteArray6.readInt();
                                        i11 = size5;
                                        ev2 ev2Var3 = ru0Var4.f26144d;
                                        f10 f10Var3 = (f10) Util.castNonNull(cv2Var3.f16129a);
                                        sparseArray2 = sparseArray3;
                                        cv2Var3.f16135g[i38] = parsableByteArray6.readUnsignedIntToInt();
                                        long[] jArr = cv2Var3.f16134f;
                                        c1301ic = c1301ic5;
                                        int i41 = i39;
                                        long j5 = cv2Var3.f16130b;
                                        jArr[i38] = j5;
                                        if ((readInt4 & 1) != 0) {
                                            arrayList5 = arrayList3;
                                            i12 = i22;
                                            i13 = i30;
                                            jArr[i38] = j5 + parsableByteArray6.readInt();
                                        } else {
                                            i12 = i22;
                                            i13 = i30;
                                            arrayList5 = arrayList3;
                                        }
                                        if ((readInt4 & 4) != 0) {
                                            z7 = true;
                                        } else {
                                            z7 = false;
                                        }
                                        int i42 = f10Var3.f17075d;
                                        if (z7) {
                                            i42 = parsableByteArray6.readInt();
                                        }
                                        if ((readInt4 & 256) != 0) {
                                            z8 = true;
                                        } else {
                                            z8 = false;
                                        }
                                        if ((readInt4 & 512) != 0) {
                                            z9 = true;
                                        } else {
                                            z9 = false;
                                        }
                                        if ((readInt4 & 1024) != 0) {
                                            z10 = true;
                                        } else {
                                            z10 = false;
                                        }
                                        if ((readInt4 & 2048) != 0) {
                                            z11 = true;
                                        } else {
                                            z11 = false;
                                        }
                                        Track track5 = ev2Var3.f16998a;
                                        long[] jArr2 = track5.editListDurations;
                                        int i43 = i42;
                                        if (jArr2 != null && jArr2.length == 1 && jArr2[0] == 0) {
                                            j4 = ((long[]) Util.castNonNull(track5.editListMediaTimes))[0];
                                        }
                                        int[] iArr = cv2Var3.f16136h;
                                        long[] jArr3 = cv2Var3.f16137i;
                                        boolean[] zArr = cv2Var3.f16138j;
                                        arrayList4 = arrayList8;
                                        i10 = i37;
                                        if (track5.type == 2 && (i12 & 1) != 0) {
                                            z12 = true;
                                        } else {
                                            z12 = false;
                                        }
                                        int i44 = i41 + cv2Var3.f16135g[i38];
                                        long j6 = track5.timescale;
                                        ru0 ru0Var5 = ru0Var4;
                                        cv2 cv2Var4 = cv2Var3;
                                        long j7 = cv2Var3.f16144p;
                                        int i45 = i41;
                                        while (i45 < i44) {
                                            if (z8) {
                                                i15 = i44;
                                                z13 = z8;
                                                i16 = parsableByteArray6.readInt();
                                            } else {
                                                i15 = i44;
                                                i16 = f10Var3.f17073b;
                                                z13 = z8;
                                            }
                                            if (i16 >= 0) {
                                                if (z9) {
                                                    z14 = z9;
                                                    i17 = parsableByteArray6.readInt();
                                                } else {
                                                    z14 = z9;
                                                    i17 = f10Var3.f17074c;
                                                }
                                                if (i17 >= 0) {
                                                    if (z10) {
                                                        i18 = parsableByteArray6.readInt();
                                                    } else if (i45 == 0 && z7) {
                                                        i18 = i43;
                                                    } else {
                                                        i18 = f10Var3.f17075d;
                                                    }
                                                    if (z11) {
                                                        z15 = z7;
                                                        f10Var = f10Var3;
                                                        z16 = z10;
                                                        i19 = parsableByteArray6.readInt();
                                                    } else {
                                                        z15 = z7;
                                                        f10Var = f10Var3;
                                                        z16 = z10;
                                                        i19 = 0;
                                                    }
                                                    long scaleLargeTimestamp = Util.scaleLargeTimestamp((i19 + j7) - j4, 1000000L, j6);
                                                    jArr3[i45] = scaleLargeTimestamp;
                                                    long j8 = j6;
                                                    cv2 cv2Var5 = cv2Var4;
                                                    if (!cv2Var5.f16145q) {
                                                        ru0Var2 = ru0Var5;
                                                        z17 = z11;
                                                        parsableByteArray = parsableByteArray6;
                                                        jArr3[i45] = scaleLargeTimestamp + ru0Var2.f26144d.f17005h;
                                                    } else {
                                                        z17 = z11;
                                                        parsableByteArray = parsableByteArray6;
                                                        ru0Var2 = ru0Var5;
                                                    }
                                                    iArr[i45] = i17;
                                                    if (((i18 >> 16) & 1) == 0 && (!z12 || i45 == 0)) {
                                                        z18 = true;
                                                    } else {
                                                        z18 = false;
                                                    }
                                                    zArr[i45] = z18;
                                                    j7 += i16;
                                                    i45++;
                                                    ru0Var5 = ru0Var2;
                                                    cv2Var4 = cv2Var5;
                                                    j6 = j8;
                                                    parsableByteArray6 = parsableByteArray;
                                                    z11 = z17;
                                                    i44 = i15;
                                                    z8 = z13;
                                                    z9 = z14;
                                                    z7 = z15;
                                                    f10Var3 = f10Var;
                                                    z10 = z16;
                                                } else {
                                                    throw ParserException.createForMalformedContainer("Unexpected negative value: " + i17, null);
                                                }
                                            } else {
                                                throw ParserException.createForMalformedContainer("Unexpected negative value: " + i16, null);
                                            }
                                        }
                                        int i46 = i44;
                                        ru0Var = ru0Var5;
                                        cv2Var = cv2Var4;
                                        i14 = 1953658222;
                                        cv2Var.f16144p = j7;
                                        i38 = i40;
                                        i39 = i46;
                                    } else {
                                        i10 = i37;
                                        arrayList4 = arrayList8;
                                        i11 = size5;
                                        c1301ic = c1301ic5;
                                        i12 = i22;
                                        i13 = i30;
                                        arrayList5 = arrayList3;
                                        sparseArray2 = sparseArray3;
                                        ru0Var = ru0Var4;
                                        i14 = i7;
                                        cv2Var = cv2Var3;
                                    }
                                    i7 = i14;
                                    ru0Var4 = ru0Var;
                                    cv2Var3 = cv2Var;
                                    size5 = i11;
                                    sparseArray3 = sparseArray2;
                                    c1301ic5 = c1301ic;
                                    arrayList3 = arrayList5;
                                    i22 = i12;
                                    i30 = i13;
                                    arrayList8 = arrayList4;
                                    i37 = i10 + 1;
                                } else {
                                    ArrayList arrayList10 = arrayList8;
                                    C1301ic c1301ic6 = c1301ic5;
                                    i2 = i22;
                                    i3 = i30;
                                    arrayList2 = arrayList3;
                                    sparseArray = sparseArray3;
                                    cv2 cv2Var6 = cv2Var3;
                                    TrackEncryptionBox sampleDescriptionEncryptionBox = ru0Var4.f26144d.f16998a.getSampleDescriptionEncryptionBox(((f10) Assertions.checkNotNull(cv2Var6.f16129a)).f17072a);
                                    C1349jc m5207d2 = c1301ic6.m5207d(1935763834);
                                    if (m5207d2 != null) {
                                        int i47 = ((TrackEncryptionBox) Assertions.checkNotNull(sampleDescriptionEncryptionBox)).perSampleIvSize;
                                        ParsableByteArray parsableByteArray7 = m5207d2.f20458b;
                                        parsableByteArray7.setPosition(8);
                                        if ((parsableByteArray7.readInt() & 1) == 1) {
                                            parsableByteArray7.skipBytes(8);
                                        }
                                        int readUnsignedByte = parsableByteArray7.readUnsignedByte();
                                        int readUnsignedIntToInt2 = parsableByteArray7.readUnsignedIntToInt();
                                        if (readUnsignedIntToInt2 <= cv2Var6.f16133e) {
                                            if (readUnsignedByte == 0) {
                                                boolean[] zArr2 = cv2Var6.f16140l;
                                                i9 = 0;
                                                for (int i48 = 0; i48 < readUnsignedIntToInt2; i48++) {
                                                    int readUnsignedByte2 = parsableByteArray7.readUnsignedByte();
                                                    i9 += readUnsignedByte2;
                                                    if (readUnsignedByte2 > i47) {
                                                        z6 = true;
                                                    } else {
                                                        z6 = false;
                                                    }
                                                    zArr2[i48] = z6;
                                                }
                                                z5 = false;
                                            } else {
                                                if (readUnsignedByte > i47) {
                                                    z4 = true;
                                                } else {
                                                    z4 = false;
                                                }
                                                i9 = readUnsignedByte * readUnsignedIntToInt2;
                                                z5 = false;
                                                Arrays.fill(cv2Var6.f16140l, 0, readUnsignedIntToInt2, z4);
                                            }
                                            Arrays.fill(cv2Var6.f16140l, readUnsignedIntToInt2, cv2Var6.f16133e, z5);
                                            if (i9 > 0) {
                                                cv2Var6.f16142n.reset(i9);
                                                cv2Var6.f16139k = true;
                                                cv2Var6.f16143o = true;
                                            }
                                        } else {
                                            StringBuilder m8299s = ye0.m8299s(readUnsignedIntToInt2, "Saiz sample count ", " is greater than fragment sample count");
                                            m8299s.append(cv2Var6.f16133e);
                                            throw ParserException.createForMalformedContainer(m8299s.toString(), null);
                                        }
                                    }
                                    C1349jc m5207d3 = c1301ic6.m5207d(1935763823);
                                    if (m5207d3 != null) {
                                        ParsableByteArray parsableByteArray8 = m5207d3.f20458b;
                                        parsableByteArray8.setPosition(8);
                                        int readInt5 = parsableByteArray8.readInt();
                                        if ((readInt5 & 1) == 1) {
                                            parsableByteArray8.skipBytes(8);
                                        }
                                        int readUnsignedIntToInt3 = parsableByteArray8.readUnsignedIntToInt();
                                        if (readUnsignedIntToInt3 == 1) {
                                            int m5518b = AbstractC1386kc.m5518b(readInt5);
                                            long j9 = cv2Var6.f16131c;
                                            if (m5518b == 0) {
                                                readUnsignedLongToLong = parsableByteArray8.readUnsignedInt();
                                            } else {
                                                readUnsignedLongToLong = parsableByteArray8.readUnsignedLongToLong();
                                            }
                                            cv2Var6.f16131c = j9 + readUnsignedLongToLong;
                                        } else {
                                            throw ParserException.createForMalformedContainer("Unexpected saio entry count: " + readUnsignedIntToInt3, null);
                                        }
                                    }
                                    byte[] bArr = null;
                                    C1349jc m5207d4 = c1301ic6.m5207d(1936027235);
                                    if (m5207d4 != null) {
                                        m2557b(m5207d4.f20458b, 0, cv2Var6);
                                    }
                                    if (sampleDescriptionEncryptionBox != null) {
                                        str2 = sampleDescriptionEncryptionBox.schemeType;
                                    } else {
                                        str2 = null;
                                    }
                                    ParsableByteArray parsableByteArray9 = null;
                                    ParsableByteArray parsableByteArray10 = null;
                                    int i49 = 0;
                                    while (i49 < arrayList10.size()) {
                                        ArrayList arrayList11 = arrayList10;
                                        C1349jc c1349jc4 = (C1349jc) arrayList11.get(i49);
                                        ParsableByteArray parsableByteArray11 = c1349jc4.f20458b;
                                        int i50 = c1349jc4.f20817a;
                                        if (i50 == 1935828848) {
                                            parsableByteArray11.setPosition(12);
                                            if (parsableByteArray11.readInt() == 1936025959) {
                                                parsableByteArray9 = parsableByteArray11;
                                            }
                                        } else if (i50 == 1936158820) {
                                            parsableByteArray11.setPosition(12);
                                            if (parsableByteArray11.readInt() == 1936025959) {
                                                parsableByteArray10 = parsableByteArray11;
                                            }
                                        }
                                        i49++;
                                        arrayList10 = arrayList11;
                                    }
                                    ArrayList arrayList12 = arrayList10;
                                    if (parsableByteArray9 != null && parsableByteArray10 != null) {
                                        parsableByteArray9.setPosition(8);
                                        int m5518b2 = AbstractC1386kc.m5518b(parsableByteArray9.readInt());
                                        parsableByteArray9.skipBytes(4);
                                        if (m5518b2 == 1) {
                                            parsableByteArray9.skipBytes(4);
                                        }
                                        if (parsableByteArray9.readInt() == 1) {
                                            parsableByteArray10.setPosition(8);
                                            int m5518b3 = AbstractC1386kc.m5518b(parsableByteArray10.readInt());
                                            parsableByteArray10.skipBytes(4);
                                            if (m5518b3 == 1) {
                                                if (parsableByteArray10.readUnsignedInt() == 0) {
                                                    throw ParserException.createForUnsupportedContainerFeature("Variable length description in sgpd found (unsupported)");
                                                }
                                            } else if (m5518b3 >= 2) {
                                                parsableByteArray10.skipBytes(4);
                                            }
                                            if (parsableByteArray10.readUnsignedInt() == 1) {
                                                parsableByteArray10.skipBytes(1);
                                                int readUnsignedByte3 = parsableByteArray10.readUnsignedByte();
                                                int i51 = (readUnsignedByte3 & PsExtractor.VIDEO_STREAM_MASK) >> 4;
                                                int i52 = readUnsignedByte3 & 15;
                                                if (parsableByteArray10.readUnsignedByte() == 1) {
                                                    z3 = true;
                                                } else {
                                                    z3 = false;
                                                }
                                                if (z3) {
                                                    int readUnsignedByte4 = parsableByteArray10.readUnsignedByte();
                                                    byte[] bArr2 = new byte[16];
                                                    parsableByteArray10.readBytes(bArr2, 0, 16);
                                                    if (readUnsignedByte4 == 0) {
                                                        int readUnsignedByte5 = parsableByteArray10.readUnsignedByte();
                                                        bArr = new byte[readUnsignedByte5];
                                                        parsableByteArray10.readBytes(bArr, 0, readUnsignedByte5);
                                                    }
                                                    cv2Var6.f16139k = true;
                                                    cv2Var6.f16141m = new TrackEncryptionBox(z3, str2, readUnsignedByte4, bArr2, i51, i52, bArr);
                                                    size = arrayList12.size();
                                                    for (i8 = 0; i8 < size; i8++) {
                                                        C1349jc c1349jc5 = (C1349jc) arrayList12.get(i8);
                                                        if (c1349jc5.f20817a == 1970628964) {
                                                            ParsableByteArray parsableByteArray12 = c1349jc5.f20458b;
                                                            parsableByteArray12.setPosition(8);
                                                            byte[] bArr3 = this.f10286h;
                                                            parsableByteArray12.readBytes(bArr3, 0, 16);
                                                            if (Arrays.equals(bArr3, f10269I)) {
                                                                m2557b(parsableByteArray12, 16, cv2Var6);
                                                            }
                                                        }
                                                    }
                                                    fragmentedMp4Extractor2 = this;
                                                }
                                            } else {
                                                throw ParserException.createForUnsupportedContainerFeature("Entry count in sgpd != 1 (unsupported).");
                                            }
                                        } else {
                                            throw ParserException.createForUnsupportedContainerFeature("Entry count in sbgp != 1 (unsupported).");
                                        }
                                    }
                                    size = arrayList12.size();
                                    while (i8 < size) {
                                    }
                                    fragmentedMp4Extractor2 = this;
                                }
                            }
                        }
                    } else {
                        z2 = z;
                        arrayList = arrayList7;
                        i = size4;
                        arrayList2 = arrayList6;
                        i2 = i22;
                        i3 = i30;
                        sparseArray = sparseArray3;
                        fragmentedMp4Extractor2 = fragmentedMp4Extractor3;
                    }
                    i30 = i3 + 1;
                    fragmentedMp4Extractor3 = fragmentedMp4Extractor2;
                    z = z2;
                    size4 = i;
                    arrayList7 = arrayList;
                    sparseArray3 = sparseArray;
                    arrayList6 = arrayList2;
                    i22 = i2;
                }
                ArrayList arrayList13 = arrayList6;
                SparseArray sparseArray5 = sparseArray3;
                fragmentedMp4Extractor = fragmentedMp4Extractor3;
                DrmInitData m2556a2 = m2556a(arrayList13);
                if (m2556a2 != null) {
                    int size6 = sparseArray5.size();
                    int i53 = 0;
                    while (i53 < size6) {
                        SparseArray sparseArray6 = sparseArray5;
                        ru0 ru0Var6 = (ru0) sparseArray6.valueAt(i53);
                        TrackEncryptionBox sampleDescriptionEncryptionBox2 = ru0Var6.f26144d.f16998a.getSampleDescriptionEncryptionBox(((f10) Util.castNonNull(ru0Var6.f26142b.f16129a)).f17072a);
                        if (sampleDescriptionEncryptionBox2 != null) {
                            str = sampleDescriptionEncryptionBox2.schemeType;
                        } else {
                            str = null;
                        }
                        ru0Var6.f26141a.format(ru0Var6.f26144d.f16998a.format.buildUpon().setDrmInitData(m2556a2.copyWithSchemeType(str)).build());
                        i53++;
                        sparseArray5 = sparseArray6;
                    }
                }
                SparseArray sparseArray7 = sparseArray5;
                if (fragmentedMp4Extractor.f10301w != C0643C.TIME_UNSET) {
                    int size7 = sparseArray7.size();
                    for (int i54 = 0; i54 < size7; i54++) {
                        ru0 ru0Var7 = (ru0) sparseArray7.valueAt(i54);
                        long j10 = fragmentedMp4Extractor.f10301w;
                        int i55 = ru0Var7.f26146f;
                        while (true) {
                            cv2 cv2Var7 = ru0Var7.f26142b;
                            if (i55 < cv2Var7.f16133e && cv2Var7.f16137i[i55] < j10) {
                                if (cv2Var7.f16138j[i55]) {
                                    ru0Var7.f26149i = i55;
                                }
                                i55++;
                            }
                        }
                    }
                    fragmentedMp4Extractor.f10301w = C0643C.TIME_UNSET;
                }
            } else {
                fragmentedMp4Extractor = fragmentedMp4Extractor3;
                if (!arrayDeque.isEmpty()) {
                    ((C1301ic) arrayDeque.peek()).f18361d.add(c1301ic3);
                }
            }
            fragmentedMp4Extractor3 = fragmentedMp4Extractor;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput extractorOutput) {
        int i;
        this.f10275E = extractorOutput;
        this.f10294p = 0;
        this.f10297s = 0;
        TrackOutput[] trackOutputArr = new TrackOutput[2];
        this.f10276F = trackOutputArr;
        TrackOutput trackOutput = this.f10293o;
        if (trackOutput != null) {
            trackOutputArr[0] = trackOutput;
            i = 1;
        } else {
            i = 0;
        }
        int i2 = 100;
        if ((this.f10279a & 4) != 0) {
            trackOutputArr[i] = extractorOutput.track(100, 5);
            i2 = 101;
            i++;
        }
        TrackOutput[] trackOutputArr2 = (TrackOutput[]) Util.nullSafeArrayCopy(this.f10276F, i);
        this.f10276F = trackOutputArr2;
        for (TrackOutput trackOutput2 : trackOutputArr2) {
            trackOutput2.format(f10270J);
        }
        List list = this.f10281c;
        this.f10277G = new TrackOutput[list.size()];
        int i3 = 0;
        while (i3 < this.f10277G.length) {
            TrackOutput track = this.f10275E.track(i2, 3);
            track.format((Format) list.get(i3));
            this.f10277G[i3] = track;
            i3++;
            i2++;
        }
        Track track2 = this.f10280b;
        if (track2 != null) {
            this.f10282d.put(0, new ru0(extractorOutput.track(0, track2.type), new ev2(this.f10280b, new long[0], new int[0], 0, new long[0], new int[0], 0L), new f10(0, 0, 0, 0)));
            this.f10275E.endTracks();
        }
    }

    @Nullable
    public Track modifyTrack(@Nullable Track track) {
        return track;
    }

    /* JADX WARN: Code restructure failed: missing block: B:314:0x00b3, code lost:
    
        r3 = r28.f10294p;
        r4 = r2.f26142b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:315:0x00b8, code lost:
    
        if (r3 != 3) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:317:0x00bc, code lost:
    
        if (r2.f26152l != false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:318:0x00be, code lost:
    
        r3 = r2.f26144d.f17001d[r2.f26146f];
     */
    /* JADX WARN: Code restructure failed: missing block: B:319:0x00cd, code lost:
    
        r28.f10271A = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:320:0x00d3, code lost:
    
        if (r2.f26146f >= r2.f26149i) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:321:0x00d5, code lost:
    
        r29.skipFully(r3);
        r1 = r2.m7304a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:322:0x00dc, code lost:
    
        if (r1 != null) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:323:0x00df, code lost:
    
        r3 = r4.f16142n;
        r1 = r1.perSampleIvSize;
     */
    /* JADX WARN: Code restructure failed: missing block: B:324:0x00e3, code lost:
    
        if (r1 == 0) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:325:0x00e5, code lost:
    
        r3.skipBytes(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:326:0x00e8, code lost:
    
        r1 = r2.f26146f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:327:0x00ec, code lost:
    
        if (r4.f16139k == false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:329:0x00f2, code lost:
    
        if (r4.f16140l[r1] == false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:330:0x00f4, code lost:
    
        r3.skipBytes(r3.readUnsignedShort() * 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:332:0x0101, code lost:
    
        if (r2.m7305b() != false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:333:0x0103, code lost:
    
        r28.f10304z = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:334:0x0105, code lost:
    
        r28.f10294p = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:335:?, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:337:0x0112, code lost:
    
        if (r2.f26144d.f16998a.sampleTransformation != 1) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:338:0x0114, code lost:
    
        r28.f10271A = r3 - 8;
        r29.skipFully(8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:340:0x012a, code lost:
    
        if (com.google.android.exoplayer2.util.MimeTypes.AUDIO_AC4.equals(r2.f26144d.f16998a.format.sampleMimeType) == false) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:341:0x012c, code lost:
    
        r28.f10272B = r2.m7306c(r28.f10271A, 7);
        r3 = r28.f10271A;
        r7 = r28.f10287i;
        com.google.android.exoplayer2.audio.Ac4Util.getAc4SampleHeader(r3, r7);
        r2.f26141a.sampleData(r7, 7);
        r28.f10272B += 7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:342:0x014f, code lost:
    
        r28.f10271A += r28.f10272B;
        r28.f10294p = 4;
        r28.f10273C = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:343:0x0147, code lost:
    
        r28.f10272B = r2.m7306c(r28.f10271A, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:344:0x00c7, code lost:
    
        r3 = r4.f16136h[r2.f26146f];
     */
    /* JADX WARN: Code restructure failed: missing block: B:345:0x015b, code lost:
    
        r3 = r2.f26144d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:346:0x015f, code lost:
    
        if (r2.f26152l != false) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:347:0x0161, code lost:
    
        r7 = r3.f17003f[r2.f26146f];
     */
    /* JADX WARN: Code restructure failed: missing block: B:348:0x016f, code lost:
    
        if (r13 == null) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:349:0x0171, code lost:
    
        r7 = r13.adjustSampleTimestamp(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:350:0x0175, code lost:
    
        r3 = r3.f16998a;
        r6 = r3.nalUnitLengthFieldLength;
        r9 = r2.f26141a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:351:0x017b, code lost:
    
        if (r6 == 0) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:352:0x017d, code lost:
    
        r6 = r28.f10284f;
        r11 = r6.getData();
        r11[0] = 0;
        r11[1] = 0;
        r11[2] = 0;
        r14 = r3.nalUnitLengthFieldLength;
        r15 = r14 + 1;
        r14 = 4 - r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:354:0x0197, code lost:
    
        if (r28.f10272B >= r28.f10271A) goto L418;
     */
    /* JADX WARN: Code restructure failed: missing block: B:355:0x0199, code lost:
    
        r5 = r28.f10273C;
     */
    /* JADX WARN: Code restructure failed: missing block: B:356:0x019b, code lost:
    
        if (r5 != 0) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:357:0x019d, code lost:
    
        r29.readFully(r11, r14, r15);
        r6.setPosition(0);
        r10 = r6.readInt();
     */
    /* JADX WARN: Code restructure failed: missing block: B:358:0x01a9, code lost:
    
        if (r10 < 1) goto L417;
     */
    /* JADX WARN: Code restructure failed: missing block: B:359:0x01ab, code lost:
    
        r28.f10273C = r10 - 1;
        r10 = r28.f10283e;
        r10.setPosition(0);
        r9.sampleData(r10, 4);
        r9.sampleData(r6, 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:360:0x01c0, code lost:
    
        if (r28.f10277G.length <= 0) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:361:0x01c2, code lost:
    
        r19 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:362:0x01ce, code lost:
    
        if (com.google.android.exoplayer2.util.NalUnitUtil.isNalUnitSei(r3.format.sampleMimeType, r11[4]) == false) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:363:0x01d0, code lost:
    
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:364:0x01d5, code lost:
    
        r28.f10274D = r5;
        r28.f10272B += 5;
        r28.f10271A += r14;
        r6 = r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:367:0x01d4, code lost:
    
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:368:0x01d2, code lost:
    
        r19 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:371:0x01ed, code lost:
    
        throw com.google.android.exoplayer2.ParserException.createForMalformedContainer("Invalid NAL length", null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:372:0x01ee, code lost:
    
        r19 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:373:0x01f2, code lost:
    
        if (r28.f10274D == false) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:374:0x01f4, code lost:
    
        r6 = r28.f10285g;
        r6.reset(r5);
        r30 = r11;
        r29.readFully(r6.getData(), 0, r28.f10273C);
        r9.sampleData(r6, r28.f10273C);
        r5 = r28.f10273C;
        r10 = com.google.android.exoplayer2.util.NalUnitUtil.unescapeStream(r6.getData(), r6.limit());
        r21 = r3;
        r6.setPosition(com.google.android.exoplayer2.util.MimeTypes.VIDEO_H265.equals(r3.format.sampleMimeType) ? 1 : 0);
        r6.setLimit(r10);
        com.google.android.exoplayer2.extractor.CeaUtil.consume(r7, r6, r28.f10277G);
     */
    /* JADX WARN: Code restructure failed: missing block: B:375:0x0239, code lost:
    
        r28.f10272B += r5;
        r28.f10273C -= r5;
        r11 = r30;
        r6 = r19;
        r3 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:377:0x0230, code lost:
    
        r21 = r3;
        r30 = r11;
        r5 = r9.sampleData((com.google.android.exoplayer2.upstream.DataReader) r29, r5, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:380:0x025e, code lost:
    
        if (r2.f26152l != false) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:381:0x0260, code lost:
    
        r6 = r2.f26144d.f17004g[r2.f26146f];
     */
    /* JADX WARN: Code restructure failed: missing block: B:383:0x0278, code lost:
    
        if (r2.m7304a() == null) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:384:0x027a, code lost:
    
        r24 = 1073741824 | r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:385:0x0282, code lost:
    
        r1 = r2.m7304a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:386:0x0286, code lost:
    
        if (r1 == null) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:387:0x0288, code lost:
    
        r27 = r1.cryptoData;
     */
    /* JADX WARN: Code restructure failed: missing block: B:388:0x028f, code lost:
    
        r9.sampleMetadata(r7, r24, r28.f10271A, 0, r27);
     */
    /* JADX WARN: Code restructure failed: missing block: B:390:0x02a0, code lost:
    
        if (r12.isEmpty() != false) goto L421;
     */
    /* JADX WARN: Code restructure failed: missing block: B:391:0x02a2, code lost:
    
        r1 = (p000.qu0) r12.removeFirst();
        r28.f10300v -= r1.f25754c;
        r3 = r1.f25753b;
        r4 = r1.f25752a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:392:0x02b3, code lost:
    
        if (r3 == false) goto L129;
     */
    /* JADX WARN: Code restructure failed: missing block: B:393:0x02b5, code lost:
    
        r4 = r4 + r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:394:0x02b6, code lost:
    
        if (r13 == null) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:395:0x02b8, code lost:
    
        r4 = r13.adjustSampleTimestamp(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:396:0x02bc, code lost:
    
        r3 = r28.f10276F;
        r6 = r3.length;
        r9 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:398:0x02c0, code lost:
    
        if (r9 >= r6) goto L424;
     */
    /* JADX WARN: Code restructure failed: missing block: B:399:0x02c2, code lost:
    
        r3[r9].sampleMetadata(r4, 1, r1.f25754c, r28.f10300v, null);
        r9 = r9 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:404:0x02dc, code lost:
    
        if (r2.m7305b() != false) goto L137;
     */
    /* JADX WARN: Code restructure failed: missing block: B:405:0x02de, code lost:
    
        r28.f10304z = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:406:0x02e1, code lost:
    
        r28.f10294p = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:407:0x02e5, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:408:0x028d, code lost:
    
        r27 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:409:0x0280, code lost:
    
        r24 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:411:0x026f, code lost:
    
        if (r4.f16138j[r2.f26146f] == false) goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:412:0x0271, code lost:
    
        r6 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:413:0x0273, code lost:
    
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:414:0x024a, code lost:
    
        r3 = r28.f10272B;
        r5 = r28.f10271A;
     */
    /* JADX WARN: Code restructure failed: missing block: B:415:0x024e, code lost:
    
        if (r3 >= r5) goto L425;
     */
    /* JADX WARN: Code restructure failed: missing block: B:416:0x0250, code lost:
    
        r28.f10272B += r9.sampleData((com.google.android.exoplayer2.upstream.DataReader) r29, r5 - r3, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:418:0x0168, code lost:
    
        r7 = r4.f16137i[r2.f26146f];
     */
    @Override // com.google.android.exoplayer2.extractor.Extractor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) {
        long j;
        long j2;
        long j3;
        long scaleLargeTimestamp;
        long j4;
        long j5;
        String str;
        String str2;
        long readUnsignedInt;
        long readUnsignedLongToLong;
        long readUnsignedLongToLong2;
        while (true) {
            int i = this.f10294p;
            ArrayDeque arrayDeque = this.f10291m;
            SparseArray sparseArray = this.f10282d;
            if (i != 0) {
                ArrayDeque arrayDeque2 = this.f10292n;
                TimestampAdjuster timestampAdjuster = this.f10288j;
                if (i != 1) {
                    long j6 = Long.MAX_VALUE;
                    if (i != 2) {
                        ru0 ru0Var = this.f10304z;
                        if (ru0Var != null) {
                            break;
                        }
                        int size = sparseArray.size();
                        long j7 = Long.MAX_VALUE;
                        ru0 ru0Var2 = null;
                        for (int i2 = 0; i2 < size; i2++) {
                            ru0 ru0Var3 = (ru0) sparseArray.valueAt(i2);
                            boolean z = ru0Var3.f26152l;
                            if (z || ru0Var3.f26146f != ru0Var3.f26144d.f16999b) {
                                cv2 cv2Var = ru0Var3.f26142b;
                                if (!z || ru0Var3.f26148h != cv2Var.f16132d) {
                                    if (!z) {
                                        j2 = ru0Var3.f26144d.f17000c[ru0Var3.f26146f];
                                    } else {
                                        j2 = cv2Var.f16134f[ru0Var3.f26148h];
                                    }
                                    if (j2 < j7) {
                                        ru0Var2 = ru0Var3;
                                        j7 = j2;
                                    }
                                }
                            }
                        }
                        if (ru0Var2 == null) {
                            int position = (int) (this.f10299u - extractorInput.getPosition());
                            if (position >= 0) {
                                extractorInput.skipFully(position);
                                this.f10294p = 0;
                                this.f10297s = 0;
                            } else {
                                throw ParserException.createForMalformedContainer("Offset to end of mdat was negative.", null);
                            }
                        } else {
                            if (!ru0Var2.f26152l) {
                                j = ru0Var2.f26144d.f17000c[ru0Var2.f26146f];
                            } else {
                                j = ru0Var2.f26142b.f16134f[ru0Var2.f26148h];
                            }
                            int position2 = (int) (j - extractorInput.getPosition());
                            if (position2 < 0) {
                                Log.m3027w("FragmentedMp4Extractor", "Ignoring negative offset to sample data.");
                                position2 = 0;
                            }
                            extractorInput.skipFully(position2);
                            this.f10304z = ru0Var2;
                            ru0Var = ru0Var2;
                        }
                    } else {
                        int size2 = sparseArray.size();
                        ru0 ru0Var4 = null;
                        for (int i3 = 0; i3 < size2; i3++) {
                            cv2 cv2Var2 = ((ru0) sparseArray.valueAt(i3)).f26142b;
                            if (cv2Var2.f16143o) {
                                long j8 = cv2Var2.f16131c;
                                if (j8 < j6) {
                                    ru0Var4 = (ru0) sparseArray.valueAt(i3);
                                    j6 = j8;
                                }
                            }
                        }
                        if (ru0Var4 == null) {
                            this.f10294p = 3;
                        } else {
                            int position3 = (int) (j6 - extractorInput.getPosition());
                            if (position3 >= 0) {
                                extractorInput.skipFully(position3);
                                cv2 cv2Var3 = ru0Var4.f26142b;
                                ParsableByteArray parsableByteArray = cv2Var3.f16142n;
                                extractorInput.readFully(parsableByteArray.getData(), 0, parsableByteArray.limit());
                                parsableByteArray.setPosition(0);
                                cv2Var3.f16143o = false;
                            } else {
                                throw ParserException.createForMalformedContainer("Offset to encryption data was negative.", null);
                            }
                        }
                    }
                } else {
                    int i4 = ((int) this.f10296r) - this.f10297s;
                    ParsableByteArray parsableByteArray2 = this.f10298t;
                    if (parsableByteArray2 != null) {
                        extractorInput.readFully(parsableByteArray2.getData(), 8, i4);
                        int i5 = this.f10295q;
                        C1349jc c1349jc = new C1349jc(i5, parsableByteArray2);
                        long position4 = extractorInput.getPosition();
                        if (!arrayDeque.isEmpty()) {
                            ((C1301ic) arrayDeque.peek()).f18360c.add(c1349jc);
                        } else if (i5 == 1936286840) {
                            parsableByteArray2.setPosition(8);
                            int m5518b = AbstractC1386kc.m5518b(parsableByteArray2.readInt());
                            parsableByteArray2.skipBytes(4);
                            long readUnsignedInt2 = parsableByteArray2.readUnsignedInt();
                            if (m5518b == 0) {
                                readUnsignedLongToLong = parsableByteArray2.readUnsignedInt();
                                readUnsignedLongToLong2 = parsableByteArray2.readUnsignedInt();
                            } else {
                                readUnsignedLongToLong = parsableByteArray2.readUnsignedLongToLong();
                                readUnsignedLongToLong2 = parsableByteArray2.readUnsignedLongToLong();
                            }
                            long j9 = readUnsignedLongToLong2 + position4;
                            long scaleLargeTimestamp2 = Util.scaleLargeTimestamp(readUnsignedLongToLong, 1000000L, readUnsignedInt2);
                            parsableByteArray2.skipBytes(2);
                            int readUnsignedShort = parsableByteArray2.readUnsignedShort();
                            int[] iArr = new int[readUnsignedShort];
                            long[] jArr = new long[readUnsignedShort];
                            long[] jArr2 = new long[readUnsignedShort];
                            long[] jArr3 = new long[readUnsignedShort];
                            long j10 = j9;
                            long j11 = scaleLargeTimestamp2;
                            int i6 = 0;
                            while (i6 < readUnsignedShort) {
                                int readInt = parsableByteArray2.readInt();
                                if ((readInt & Integer.MIN_VALUE) == 0) {
                                    long readUnsignedInt3 = parsableByteArray2.readUnsignedInt();
                                    iArr[i6] = readInt & Integer.MAX_VALUE;
                                    jArr[i6] = j10;
                                    jArr3[i6] = j11;
                                    long j12 = readUnsignedLongToLong + readUnsignedInt3;
                                    j11 = Util.scaleLargeTimestamp(j12, 1000000L, readUnsignedInt2);
                                    jArr2[i6] = j11 - jArr3[i6];
                                    parsableByteArray2.skipBytes(4);
                                    j10 += iArr[i6];
                                    i6++;
                                    readUnsignedLongToLong = j12;
                                } else {
                                    throw ParserException.createForMalformedContainer("Unhandled indirect reference", null);
                                }
                            }
                            Pair create = Pair.create(Long.valueOf(scaleLargeTimestamp2), new ChunkIndex(iArr, jArr, jArr2, jArr3));
                            this.f10303y = ((Long) create.first).longValue();
                            this.f10275E.seekMap((SeekMap) create.second);
                            this.f10278H = true;
                        } else if (i5 == 1701671783 && this.f10276F.length != 0) {
                            parsableByteArray2.setPosition(8);
                            int m5518b2 = AbstractC1386kc.m5518b(parsableByteArray2.readInt());
                            long j13 = C0643C.TIME_UNSET;
                            if (m5518b2 != 0) {
                                if (m5518b2 != 1) {
                                    AbstractC1726qj.m7036A(m5518b2, "Skipping unsupported emsg version: ", "FragmentedMp4Extractor");
                                } else {
                                    long readUnsignedInt4 = parsableByteArray2.readUnsignedInt();
                                    j5 = Util.scaleLargeTimestamp(parsableByteArray2.readUnsignedLongToLong(), 1000000L, readUnsignedInt4);
                                    scaleLargeTimestamp = Util.scaleLargeTimestamp(parsableByteArray2.readUnsignedInt(), 1000L, readUnsignedInt4);
                                    j4 = -9223372036854775807L;
                                    readUnsignedInt = parsableByteArray2.readUnsignedInt();
                                    str = (String) Assertions.checkNotNull(parsableByteArray2.readNullTerminatedString());
                                    str2 = (String) Assertions.checkNotNull(parsableByteArray2.readNullTerminatedString());
                                }
                            } else {
                                String str3 = (String) Assertions.checkNotNull(parsableByteArray2.readNullTerminatedString());
                                String str4 = (String) Assertions.checkNotNull(parsableByteArray2.readNullTerminatedString());
                                long readUnsignedInt5 = parsableByteArray2.readUnsignedInt();
                                long scaleLargeTimestamp3 = Util.scaleLargeTimestamp(parsableByteArray2.readUnsignedInt(), 1000000L, readUnsignedInt5);
                                long j14 = this.f10303y;
                                if (j14 != C0643C.TIME_UNSET) {
                                    j3 = j14 + scaleLargeTimestamp3;
                                } else {
                                    j3 = -9223372036854775807L;
                                }
                                scaleLargeTimestamp = Util.scaleLargeTimestamp(parsableByteArray2.readUnsignedInt(), 1000L, readUnsignedInt5);
                                j4 = scaleLargeTimestamp3;
                                j5 = j3;
                                str = str3;
                                str2 = str4;
                                readUnsignedInt = parsableByteArray2.readUnsignedInt();
                            }
                            byte[] bArr = new byte[parsableByteArray2.bytesLeft()];
                            parsableByteArray2.readBytes(bArr, 0, parsableByteArray2.bytesLeft());
                            ParsableByteArray parsableByteArray3 = new ParsableByteArray(this.f10289k.encode(new EventMessage(str, str2, scaleLargeTimestamp, readUnsignedInt, bArr)));
                            int bytesLeft = parsableByteArray3.bytesLeft();
                            TrackOutput[] trackOutputArr = this.f10276F;
                            int length = trackOutputArr.length;
                            int i7 = 0;
                            while (i7 < length) {
                                TrackOutput trackOutput = trackOutputArr[i7];
                                parsableByteArray3.setPosition(0);
                                trackOutput.sampleData(parsableByteArray3, bytesLeft);
                                i7++;
                                j13 = C0643C.TIME_UNSET;
                            }
                            if (j5 == j13) {
                                arrayDeque2.addLast(new qu0(bytesLeft, j4, true));
                                this.f10300v += bytesLeft;
                            } else if (!arrayDeque2.isEmpty()) {
                                arrayDeque2.addLast(new qu0(bytesLeft, j5, false));
                                this.f10300v += bytesLeft;
                            } else {
                                if (timestampAdjuster != null) {
                                    j5 = timestampAdjuster.adjustSampleTimestamp(j5);
                                }
                                for (TrackOutput trackOutput2 : this.f10276F) {
                                    trackOutput2.sampleMetadata(j5, 1, bytesLeft, 0, null);
                                }
                            }
                        }
                    } else {
                        extractorInput.skipFully(i4);
                    }
                    m2558c(extractorInput.getPosition());
                }
            } else {
                int i8 = this.f10297s;
                ParsableByteArray parsableByteArray4 = this.f10290l;
                if (i8 == 0) {
                    if (!extractorInput.readFully(parsableByteArray4.getData(), 0, 8, true)) {
                        return -1;
                    }
                    this.f10297s = 8;
                    parsableByteArray4.setPosition(0);
                    this.f10296r = parsableByteArray4.readUnsignedInt();
                    this.f10295q = parsableByteArray4.readInt();
                }
                long j15 = this.f10296r;
                if (j15 == 1) {
                    extractorInput.readFully(parsableByteArray4.getData(), 8, 8);
                    this.f10297s += 8;
                    this.f10296r = parsableByteArray4.readUnsignedLongToLong();
                } else if (j15 == 0) {
                    long length2 = extractorInput.getLength();
                    if (length2 == -1 && !arrayDeque.isEmpty()) {
                        length2 = ((C1301ic) arrayDeque.peek()).f18359b;
                    }
                    if (length2 != -1) {
                        this.f10296r = (length2 - extractorInput.getPosition()) + this.f10297s;
                    }
                }
                if (this.f10296r >= this.f10297s) {
                    long position5 = extractorInput.getPosition() - this.f10297s;
                    int i9 = this.f10295q;
                    if ((i9 == 1836019558 || i9 == 1835295092) && !this.f10278H) {
                        this.f10275E.seekMap(new SeekMap.Unseekable(this.f10302x, position5));
                        this.f10278H = true;
                    }
                    if (this.f10295q == 1836019558) {
                        int size3 = sparseArray.size();
                        for (int i10 = 0; i10 < size3; i10++) {
                            cv2 cv2Var4 = ((ru0) sparseArray.valueAt(i10)).f26142b;
                            cv2Var4.getClass();
                            cv2Var4.f16131c = position5;
                            cv2Var4.f16130b = position5;
                        }
                    }
                    int i11 = this.f10295q;
                    if (i11 == 1835295092) {
                        this.f10304z = null;
                        this.f10299u = position5 + this.f10296r;
                        this.f10294p = 2;
                    } else if (i11 != 1836019574 && i11 != 1953653099 && i11 != 1835297121 && i11 != 1835626086 && i11 != 1937007212 && i11 != 1836019558 && i11 != 1953653094 && i11 != 1836475768 && i11 != 1701082227) {
                        if (i11 != 1751411826 && i11 != 1835296868 && i11 != 1836476516 && i11 != 1936286840 && i11 != 1937011556 && i11 != 1937011827 && i11 != 1668576371 && i11 != 1937011555 && i11 != 1937011578 && i11 != 1937013298 && i11 != 1937007471 && i11 != 1668232756 && i11 != 1937011571 && i11 != 1952867444 && i11 != 1952868452 && i11 != 1953196132 && i11 != 1953654136 && i11 != 1953658222 && i11 != 1886614376 && i11 != 1935763834 && i11 != 1935763823 && i11 != 1936027235 && i11 != 1970628964 && i11 != 1935828848 && i11 != 1936158820 && i11 != 1701606260 && i11 != 1835362404 && i11 != 1701671783) {
                            if (this.f10296r <= 2147483647L) {
                                this.f10298t = null;
                                this.f10294p = 1;
                            } else {
                                throw ParserException.createForUnsupportedContainerFeature("Skipping atom with length > 2147483647 (unsupported).");
                            }
                        } else if (this.f10297s == 8) {
                            long j16 = this.f10296r;
                            if (j16 <= 2147483647L) {
                                ParsableByteArray parsableByteArray5 = new ParsableByteArray((int) j16);
                                System.arraycopy(parsableByteArray4.getData(), 0, parsableByteArray5.getData(), 0, 8);
                                this.f10298t = parsableByteArray5;
                                this.f10294p = 1;
                            } else {
                                throw ParserException.createForUnsupportedContainerFeature("Leaf atom with length > 2147483647 (unsupported).");
                            }
                        } else {
                            throw ParserException.createForUnsupportedContainerFeature("Leaf atom defines extended atom size (unsupported).");
                        }
                    } else {
                        long position6 = (extractorInput.getPosition() + this.f10296r) - 8;
                        arrayDeque.push(new C1301ic(this.f10295q, position6));
                        if (this.f10296r == this.f10297s) {
                            m2558c(position6);
                        } else {
                            this.f10294p = 0;
                            this.f10297s = 0;
                        }
                    }
                } else {
                    throw ParserException.createForUnsupportedContainerFeature("Atom size less than header length (unsupported).");
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j, long j2) {
        SparseArray sparseArray = this.f10282d;
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            ((ru0) sparseArray.valueAt(i)).m7307d();
        }
        this.f10292n.clear();
        this.f10300v = 0;
        this.f10301w = j2;
        this.f10291m.clear();
        this.f10294p = 0;
        this.f10297s = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(ExtractorInput extractorInput) {
        return p63.m6851K(extractorInput, true, false);
    }

    public FragmentedMp4Extractor(int i) {
        this(i, null);
    }

    public FragmentedMp4Extractor(int i, @Nullable TimestampAdjuster timestampAdjuster) {
        this(i, timestampAdjuster, null, Collections.emptyList());
    }

    public FragmentedMp4Extractor(int i, @Nullable TimestampAdjuster timestampAdjuster, @Nullable Track track) {
        this(i, timestampAdjuster, track, Collections.emptyList());
    }

    public FragmentedMp4Extractor(int i, @Nullable TimestampAdjuster timestampAdjuster, @Nullable Track track, List<Format> list) {
        this(i, timestampAdjuster, track, list, null);
    }

    public FragmentedMp4Extractor(int i, @Nullable TimestampAdjuster timestampAdjuster, @Nullable Track track, List<Format> list, @Nullable TrackOutput trackOutput) {
        this.f10279a = i;
        this.f10288j = timestampAdjuster;
        this.f10280b = track;
        this.f10281c = Collections.unmodifiableList(list);
        this.f10293o = trackOutput;
        this.f10289k = new EventMessageEncoder();
        this.f10290l = new ParsableByteArray(16);
        this.f10283e = new ParsableByteArray(NalUnitUtil.NAL_START_CODE);
        this.f10284f = new ParsableByteArray(5);
        this.f10285g = new ParsableByteArray();
        byte[] bArr = new byte[16];
        this.f10286h = bArr;
        this.f10287i = new ParsableByteArray(bArr);
        this.f10291m = new ArrayDeque();
        this.f10292n = new ArrayDeque();
        this.f10282d = new SparseArray();
        this.f10302x = C0643C.TIME_UNSET;
        this.f10301w = C0643C.TIME_UNSET;
        this.f10303y = C0643C.TIME_UNSET;
        this.f10275E = ExtractorOutput.PLACEHOLDER;
        this.f10276F = new TrackOutput[0];
        this.f10277G = new TrackOutput[0];
    }
}
