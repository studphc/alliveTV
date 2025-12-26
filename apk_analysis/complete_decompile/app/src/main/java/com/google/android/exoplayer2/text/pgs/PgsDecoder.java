package com.google.android.exoplayer2.text.pgs;

import android.graphics.Bitmap;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.zip.Inflater;
import p000.C1913vl;
import p000.m42;

/* loaded from: classes.dex */
public final class PgsDecoder extends SimpleSubtitleDecoder {

    /* renamed from: o */
    public final ParsableByteArray f11806o;

    /* renamed from: p */
    public final ParsableByteArray f11807p;

    /* renamed from: q */
    public final m42 f11808q;

    /* renamed from: r */
    public Inflater f11809r;

    public PgsDecoder() {
        super("PgsDecoder");
        this.f11806o = new ParsableByteArray();
        this.f11807p = new ParsableByteArray();
        this.f11808q = new m42();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.exoplayer2.text.SimpleSubtitleDecoder
    public Subtitle decode(byte[] bArr, int i, boolean z) {
        boolean z2;
        Cue cue;
        int i2;
        int readUnsignedByte;
        int i3;
        int i4;
        ParsableByteArray parsableByteArray;
        boolean z3;
        int readUnsignedInt24;
        ParsableByteArray parsableByteArray2 = this.f11806o;
        parsableByteArray2.reset(bArr, i);
        if (parsableByteArray2.bytesLeft() > 0 && parsableByteArray2.peekUnsignedByte() == 120) {
            if (this.f11809r == null) {
                this.f11809r = new Inflater();
            }
            Inflater inflater = this.f11809r;
            ParsableByteArray parsableByteArray3 = this.f11807p;
            if (Util.inflate(parsableByteArray2, parsableByteArray3, inflater)) {
                parsableByteArray2.reset(parsableByteArray3.getData(), parsableByteArray3.limit());
            }
        }
        m42 m42Var = this.f11808q;
        int i5 = 0;
        m42Var.f22791d = 0;
        m42Var.f22792e = 0;
        m42Var.f22793f = 0;
        m42Var.f22794g = 0;
        m42Var.f22795h = 0;
        m42Var.f22796i = 0;
        ParsableByteArray parsableByteArray4 = m42Var.f22788a;
        parsableByteArray4.reset(0);
        m42Var.f22790c = false;
        ArrayList arrayList = new ArrayList();
        while (parsableByteArray2.bytesLeft() >= 3) {
            int limit = parsableByteArray2.limit();
            int readUnsignedByte2 = parsableByteArray2.readUnsignedByte();
            int readUnsignedShort = parsableByteArray2.readUnsignedShort();
            int position = parsableByteArray2.getPosition() + readUnsignedShort;
            if (position > limit) {
                parsableByteArray2.setPosition(limit);
                cue = null;
                i5 = i5;
            } else {
                int i6 = 128;
                int[] iArr = m42Var.f22789b;
                if (readUnsignedByte2 != 128) {
                    switch (readUnsignedByte2) {
                        case 20:
                            if (readUnsignedShort % 5 == 2) {
                                parsableByteArray2.skipBytes(2);
                                Arrays.fill(iArr, i5);
                                int i7 = readUnsignedShort / 5;
                                int i8 = i5;
                                while (i8 < i7) {
                                    int readUnsignedByte3 = parsableByteArray2.readUnsignedByte();
                                    double readUnsignedByte4 = parsableByteArray2.readUnsignedByte();
                                    int[] iArr2 = iArr;
                                    double readUnsignedByte5 = parsableByteArray2.readUnsignedByte() - i6;
                                    double readUnsignedByte6 = parsableByteArray2.readUnsignedByte() - 128;
                                    iArr2[readUnsignedByte3] = (Util.constrainValue((int) ((1.402d * readUnsignedByte5) + readUnsignedByte4), 0, 255) << 16) | (parsableByteArray2.readUnsignedByte() << 24) | (Util.constrainValue((int) ((readUnsignedByte4 - (0.34414d * readUnsignedByte6)) - (readUnsignedByte5 * 0.71414d)), 0, 255) << 8) | Util.constrainValue((int) ((readUnsignedByte6 * 1.772d) + readUnsignedByte4), 0, 255);
                                    i8++;
                                    iArr = iArr2;
                                    parsableByteArray4 = parsableByteArray4;
                                    i6 = 128;
                                }
                                parsableByteArray = parsableByteArray4;
                                m42Var.f22790c = true;
                                break;
                            }
                            break;
                        case 21:
                            if (readUnsignedShort >= 4) {
                                parsableByteArray2.skipBytes(3);
                                if ((128 & parsableByteArray2.readUnsignedByte()) != 0) {
                                    z3 = true;
                                } else {
                                    z3 = i5;
                                }
                                int i9 = readUnsignedShort - 4;
                                if (z3) {
                                    if (i9 >= 7 && (readUnsignedInt24 = parsableByteArray2.readUnsignedInt24()) >= 4) {
                                        m42Var.f22795h = parsableByteArray2.readUnsignedShort();
                                        m42Var.f22796i = parsableByteArray2.readUnsignedShort();
                                        parsableByteArray4.reset(readUnsignedInt24 - 4);
                                        i9 = readUnsignedShort - 11;
                                    }
                                }
                                int position2 = parsableByteArray4.getPosition();
                                int limit2 = parsableByteArray4.limit();
                                if (position2 < limit2 && i9 > 0) {
                                    int min = Math.min(i9, limit2 - position2);
                                    parsableByteArray2.readBytes(parsableByteArray4.getData(), position2, min);
                                    parsableByteArray4.setPosition(position2 + min);
                                    break;
                                }
                            }
                            break;
                        case 22:
                            if (readUnsignedShort >= 19) {
                                m42Var.f22791d = parsableByteArray2.readUnsignedShort();
                                m42Var.f22792e = parsableByteArray2.readUnsignedShort();
                                parsableByteArray2.skipBytes(11);
                                m42Var.f22793f = parsableByteArray2.readUnsignedShort();
                                m42Var.f22794g = parsableByteArray2.readUnsignedShort();
                                break;
                            }
                            break;
                    }
                    parsableByteArray = parsableByteArray4;
                    parsableByteArray4 = parsableByteArray;
                    i4 = 0;
                    cue = null;
                } else {
                    ParsableByteArray parsableByteArray5 = parsableByteArray4;
                    if (m42Var.f22791d == 0 || m42Var.f22792e == 0 || m42Var.f22795h == 0 || m42Var.f22796i == 0 || parsableByteArray5.limit() == 0 || parsableByteArray5.getPosition() != parsableByteArray5.limit() || !m42Var.f22790c) {
                        parsableByteArray4 = parsableByteArray5;
                        z2 = 0;
                        cue = null;
                    } else {
                        parsableByteArray4 = parsableByteArray5;
                        parsableByteArray4.setPosition(0);
                        int i10 = m42Var.f22795h * m42Var.f22796i;
                        int[] iArr3 = new int[i10];
                        int i11 = 0;
                        while (i11 < i10) {
                            int readUnsignedByte7 = parsableByteArray4.readUnsignedByte();
                            if (readUnsignedByte7 != 0) {
                                i2 = i11 + 1;
                                iArr3[i11] = iArr[readUnsignedByte7];
                            } else {
                                int readUnsignedByte8 = parsableByteArray4.readUnsignedByte();
                                if (readUnsignedByte8 != 0) {
                                    if ((readUnsignedByte8 & 64) == 0) {
                                        readUnsignedByte = readUnsignedByte8 & 63;
                                    } else {
                                        readUnsignedByte = ((readUnsignedByte8 & 63) << 8) | parsableByteArray4.readUnsignedByte();
                                    }
                                    if ((readUnsignedByte8 & 128) == 0) {
                                        i3 = 0;
                                    } else {
                                        i3 = iArr[parsableByteArray4.readUnsignedByte()];
                                    }
                                    i2 = readUnsignedByte + i11;
                                    Arrays.fill(iArr3, i11, i2, i3);
                                }
                            }
                            i11 = i2;
                        }
                        cue = new Cue.Builder().setBitmap(Bitmap.createBitmap(iArr3, m42Var.f22795h, m42Var.f22796i, Bitmap.Config.ARGB_8888)).setPosition(m42Var.f22793f / m42Var.f22791d).setPositionAnchor(0).setLine(m42Var.f22794g / m42Var.f22792e, 0).setLineAnchor(0).setSize(m42Var.f22795h / m42Var.f22791d).setBitmapHeight(m42Var.f22796i / m42Var.f22792e).build();
                        z2 = 0;
                    }
                    m42Var.f22791d = z2 ? 1 : 0;
                    m42Var.f22792e = z2 ? 1 : 0;
                    m42Var.f22793f = z2 ? 1 : 0;
                    m42Var.f22794g = z2 ? 1 : 0;
                    m42Var.f22795h = z2 ? 1 : 0;
                    m42Var.f22796i = z2 ? 1 : 0;
                    parsableByteArray4.reset(z2 ? 1 : 0);
                    m42Var.f22790c = z2;
                    i4 = z2;
                }
                parsableByteArray2.setPosition(position);
                i5 = i4;
            }
            if (cue != null) {
                arrayList.add(cue);
            }
        }
        return new C1913vl(3, Collections.unmodifiableList(arrayList));
    }
}
