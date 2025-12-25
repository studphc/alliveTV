package p000;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import androidx.core.view.ViewCompat;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Ascii;

/* loaded from: classes.dex */
public final class o70 {

    /* renamed from: h */
    public static final byte[] f23641h = {0, 7, 8, Ascii.f14464SI};

    /* renamed from: i */
    public static final byte[] f23642i = {0, 119, -120, -1};

    /* renamed from: j */
    public static final byte[] f23643j = {0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};

    /* renamed from: a */
    public final Paint f23644a;

    /* renamed from: b */
    public final Paint f23645b;

    /* renamed from: c */
    public final Canvas f23646c;

    /* renamed from: d */
    public final i70 f23647d;

    /* renamed from: e */
    public final h70 f23648e;

    /* renamed from: f */
    public final n70 f23649f;

    /* renamed from: g */
    public Bitmap f23650g;

    public o70(int i, int i2) {
        Paint paint = new Paint();
        this.f23644a = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        paint.setPathEffect(null);
        Paint paint2 = new Paint();
        this.f23645b = paint2;
        paint2.setStyle(Paint.Style.FILL);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        paint2.setPathEffect(null);
        this.f23646c = new Canvas();
        this.f23647d = new i70(AdaptiveTrackSelection.DEFAULT_MAX_HEIGHT_TO_DISCARD, 575, 0, AdaptiveTrackSelection.DEFAULT_MAX_HEIGHT_TO_DISCARD, 0, 575);
        this.f23648e = new h70(0, new int[]{0, -1, ViewCompat.MEASURED_STATE_MASK, -8421505}, m6486b(), m6487c());
        this.f23649f = new n70(i, i2);
    }

    /* renamed from: a */
    public static byte[] m6485a(int i, int i2, ParsableBitArray parsableBitArray) {
        byte[] bArr = new byte[i];
        for (int i3 = 0; i3 < i; i3++) {
            bArr[i3] = (byte) parsableBitArray.readBits(i2);
        }
        return bArr;
    }

    /* renamed from: b */
    public static int[] m6486b() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int[] iArr = new int[16];
        iArr[0] = 0;
        for (int i6 = 1; i6 < 16; i6++) {
            if (i6 < 8) {
                if ((i6 & 1) != 0) {
                    i3 = 255;
                } else {
                    i3 = 0;
                }
                if ((i6 & 2) != 0) {
                    i4 = 255;
                } else {
                    i4 = 0;
                }
                if ((i6 & 4) != 0) {
                    i5 = 255;
                } else {
                    i5 = 0;
                }
                iArr[i6] = m6488d(255, i3, i4, i5);
            } else {
                int i7 = 127;
                if ((i6 & 1) != 0) {
                    i = 127;
                } else {
                    i = 0;
                }
                if ((i6 & 2) != 0) {
                    i2 = 127;
                } else {
                    i2 = 0;
                }
                if ((i6 & 4) == 0) {
                    i7 = 0;
                }
                iArr[i6] = m6488d(255, i, i2, i7);
            }
        }
        return iArr;
    }

    /* renamed from: c */
    public static int[] m6487c() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int[] iArr = new int[256];
        iArr[0] = 0;
        for (int i19 = 0; i19 < 256; i19++) {
            int i20 = 255;
            if (i19 < 8) {
                if ((i19 & 1) != 0) {
                    i17 = 255;
                } else {
                    i17 = 0;
                }
                if ((i19 & 2) != 0) {
                    i18 = 255;
                } else {
                    i18 = 0;
                }
                if ((i19 & 4) == 0) {
                    i20 = 0;
                }
                iArr[i19] = m6488d(63, i17, i18, i20);
            } else {
                int i21 = i19 & 136;
                int i22 = 170;
                int i23 = 85;
                if (i21 != 0) {
                    if (i21 != 8) {
                        int i24 = 43;
                        if (i21 != 128) {
                            if (i21 == 136) {
                                if ((i19 & 1) != 0) {
                                    i13 = 43;
                                } else {
                                    i13 = 0;
                                }
                                if ((i19 & 16) != 0) {
                                    i14 = 85;
                                } else {
                                    i14 = 0;
                                }
                                int i25 = i13 + i14;
                                if ((i19 & 2) != 0) {
                                    i15 = 43;
                                } else {
                                    i15 = 0;
                                }
                                if ((i19 & 32) != 0) {
                                    i16 = 85;
                                } else {
                                    i16 = 0;
                                }
                                int i26 = i15 + i16;
                                if ((i19 & 4) == 0) {
                                    i24 = 0;
                                }
                                if ((i19 & 64) == 0) {
                                    i23 = 0;
                                }
                                iArr[i19] = m6488d(255, i25, i26, i24 + i23);
                            }
                        } else {
                            if ((i19 & 1) != 0) {
                                i9 = 43;
                            } else {
                                i9 = 0;
                            }
                            int i27 = i9 + 127;
                            if ((i19 & 16) != 0) {
                                i10 = 85;
                            } else {
                                i10 = 0;
                            }
                            int i28 = i27 + i10;
                            if ((i19 & 2) != 0) {
                                i11 = 43;
                            } else {
                                i11 = 0;
                            }
                            int i29 = i11 + 127;
                            if ((i19 & 32) != 0) {
                                i12 = 85;
                            } else {
                                i12 = 0;
                            }
                            int i30 = i29 + i12;
                            if ((i19 & 4) == 0) {
                                i24 = 0;
                            }
                            int i31 = i24 + 127;
                            if ((i19 & 64) == 0) {
                                i23 = 0;
                            }
                            iArr[i19] = m6488d(255, i28, i30, i31 + i23);
                        }
                    } else {
                        if ((i19 & 1) != 0) {
                            i5 = 85;
                        } else {
                            i5 = 0;
                        }
                        if ((i19 & 16) != 0) {
                            i6 = 170;
                        } else {
                            i6 = 0;
                        }
                        int i32 = i5 + i6;
                        if ((i19 & 2) != 0) {
                            i7 = 85;
                        } else {
                            i7 = 0;
                        }
                        if ((i19 & 32) != 0) {
                            i8 = 170;
                        } else {
                            i8 = 0;
                        }
                        int i33 = i7 + i8;
                        if ((i19 & 4) == 0) {
                            i23 = 0;
                        }
                        if ((i19 & 64) == 0) {
                            i22 = 0;
                        }
                        iArr[i19] = m6488d(127, i32, i33, i23 + i22);
                    }
                } else {
                    if ((i19 & 1) != 0) {
                        i = 85;
                    } else {
                        i = 0;
                    }
                    if ((i19 & 16) != 0) {
                        i2 = 170;
                    } else {
                        i2 = 0;
                    }
                    int i34 = i + i2;
                    if ((i19 & 2) != 0) {
                        i3 = 85;
                    } else {
                        i3 = 0;
                    }
                    if ((i19 & 32) != 0) {
                        i4 = 170;
                    } else {
                        i4 = 0;
                    }
                    int i35 = i3 + i4;
                    if ((i19 & 4) == 0) {
                        i23 = 0;
                    }
                    if ((i19 & 64) == 0) {
                        i22 = 0;
                    }
                    iArr[i19] = m6488d(255, i34, i35, i23 + i22);
                }
            }
        }
        return iArr;
    }

    /* renamed from: d */
    public static int m6488d(int i, int i2, int i3, int i4) {
        return (i << 24) | (i2 << 16) | (i3 << 8) | i4;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0228 A[LOOP:3: B:89:0x0171->B:100:0x0228, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0223 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01f0 A[ADDED_TO_REGION] */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void m6489e(byte[] bArr, int[] iArr, int i, int i2, int i3, Paint paint, Canvas canvas) {
        byte[] bArr2;
        byte[] bArr3;
        int i4;
        boolean z;
        int readBits;
        char c;
        char c2;
        boolean z2;
        int i5;
        int i6;
        byte[] bArr4;
        boolean z3;
        int i7;
        int readBits2;
        int readBits3;
        int i8;
        int i9;
        byte[] bArr5;
        int i10;
        int readBits4;
        int i11;
        ParsableBitArray parsableBitArray = new ParsableBitArray(bArr);
        int i12 = i2;
        int i13 = i3;
        byte[] bArr6 = null;
        byte[] bArr7 = null;
        byte[] bArr8 = null;
        while (parsableBitArray.bitsLeft() != 0) {
            int i14 = 8;
            int readBits5 = parsableBitArray.readBits(8);
            if (readBits5 != 240) {
                int i15 = 1;
                int i16 = 3;
                int i17 = 4;
                switch (readBits5) {
                    case 16:
                        if (i == 3) {
                            if (bArr6 == null) {
                                bArr3 = f23642i;
                            } else {
                                bArr3 = bArr6;
                            }
                        } else if (i == 2) {
                            if (bArr8 == null) {
                                bArr3 = f23641h;
                            } else {
                                bArr3 = bArr8;
                            }
                        } else {
                            bArr2 = null;
                            i4 = i12;
                            z = false;
                            while (true) {
                                readBits = parsableBitArray.readBits(2);
                                if (readBits == 0) {
                                    z2 = z;
                                    i5 = 1;
                                } else if (parsableBitArray.readBit()) {
                                    z2 = z;
                                    i5 = parsableBitArray.readBits(3) + 3;
                                    readBits = parsableBitArray.readBits(2);
                                } else if (parsableBitArray.readBit()) {
                                    z2 = z;
                                    i5 = 1;
                                    readBits = 0;
                                } else {
                                    int readBits6 = parsableBitArray.readBits(2);
                                    if (readBits6 != 0) {
                                        if (readBits6 != 1) {
                                            if (readBits6 != 2) {
                                                if (readBits6 != 3) {
                                                    z2 = z;
                                                    readBits = 0;
                                                    i5 = 0;
                                                } else {
                                                    c2 = '\b';
                                                    z2 = z;
                                                    i5 = parsableBitArray.readBits(8) + 29;
                                                    readBits = parsableBitArray.readBits(2);
                                                    c = 4;
                                                }
                                            } else {
                                                c = 4;
                                                c2 = '\b';
                                                z2 = z;
                                                i5 = parsableBitArray.readBits(4) + 12;
                                                readBits = parsableBitArray.readBits(2);
                                            }
                                        } else {
                                            c = 4;
                                            c2 = '\b';
                                            z2 = z;
                                            i5 = 2;
                                            readBits = 0;
                                        }
                                    } else {
                                        c = 4;
                                        c2 = '\b';
                                        z2 = true;
                                        readBits = 0;
                                        i5 = 0;
                                    }
                                    if (i5 == 0 && paint != null) {
                                        if (bArr2 != 0) {
                                            readBits = bArr2[readBits];
                                        }
                                        paint.setColor(iArr[readBits]);
                                        i6 = i4;
                                        canvas.drawRect(i4, i13, i4 + i5, i13 + 1, paint);
                                    } else {
                                        i6 = i4;
                                    }
                                    i4 = i6 + i5;
                                    if (z2) {
                                        parsableBitArray.byteAlign();
                                        break;
                                    } else {
                                        z = z2;
                                    }
                                }
                                c = 4;
                                c2 = '\b';
                                if (i5 == 0) {
                                }
                                i6 = i4;
                                i4 = i6 + i5;
                                if (z2) {
                                }
                            }
                        }
                        bArr2 = bArr3;
                        i4 = i12;
                        z = false;
                        while (true) {
                            readBits = parsableBitArray.readBits(2);
                            if (readBits == 0) {
                            }
                            c = 4;
                            c2 = '\b';
                            if (i5 == 0) {
                            }
                            i6 = i4;
                            i4 = i6 + i5;
                            if (z2) {
                            }
                            z = z2;
                        }
                    case 17:
                        if (i == 3) {
                            if (bArr7 == null) {
                                bArr5 = f23643j;
                            } else {
                                bArr5 = bArr7;
                            }
                            bArr4 = bArr5;
                        } else {
                            bArr4 = null;
                        }
                        i4 = i12;
                        boolean z4 = false;
                        while (true) {
                            int readBits7 = parsableBitArray.readBits(i17);
                            if (readBits7 != 0) {
                                z3 = z4;
                                i7 = 1;
                            } else if (!parsableBitArray.readBit()) {
                                int readBits8 = parsableBitArray.readBits(i16);
                                if (readBits8 != 0) {
                                    z3 = z4;
                                    i7 = readBits8 + 2;
                                    readBits7 = 0;
                                } else {
                                    z3 = true;
                                    readBits7 = 0;
                                    i7 = 0;
                                }
                            } else {
                                if (!parsableBitArray.readBit()) {
                                    readBits2 = parsableBitArray.readBits(2) + i17;
                                    readBits3 = parsableBitArray.readBits(i17);
                                } else {
                                    int readBits9 = parsableBitArray.readBits(2);
                                    if (readBits9 != 0) {
                                        if (readBits9 != 1) {
                                            if (readBits9 != 2) {
                                                if (readBits9 != i16) {
                                                    z3 = z4;
                                                    readBits7 = 0;
                                                    i7 = 0;
                                                } else {
                                                    readBits2 = parsableBitArray.readBits(i14) + 25;
                                                    readBits3 = parsableBitArray.readBits(i17);
                                                }
                                            } else {
                                                readBits2 = parsableBitArray.readBits(i17) + 9;
                                                readBits3 = parsableBitArray.readBits(i17);
                                            }
                                        } else {
                                            z3 = z4;
                                            i7 = 2;
                                        }
                                    } else {
                                        z3 = z4;
                                        i7 = 1;
                                    }
                                    readBits7 = 0;
                                }
                                z3 = z4;
                                i7 = readBits2;
                                readBits7 = readBits3;
                            }
                            if (i7 != 0 && paint != null) {
                                if (bArr4 != 0) {
                                    readBits7 = bArr4[readBits7];
                                }
                                paint.setColor(iArr[readBits7]);
                                i8 = i16;
                                i9 = i4;
                                canvas.drawRect(i4, i13, i4 + i7, i13 + 1, paint);
                            } else {
                                i8 = i16;
                                i9 = i4;
                            }
                            i4 = i9 + i7;
                            if (z3) {
                                parsableBitArray.byteAlign();
                                break;
                            } else {
                                i16 = i8;
                                z4 = z3;
                                i17 = 4;
                                i14 = 8;
                            }
                        }
                    case 18:
                        int i18 = i12;
                        int i19 = 0;
                        while (true) {
                            int readBits10 = parsableBitArray.readBits(8);
                            if (readBits10 != 0) {
                                i10 = i19;
                                readBits4 = i15;
                            } else if (!parsableBitArray.readBit()) {
                                int readBits11 = parsableBitArray.readBits(7);
                                if (readBits11 != 0) {
                                    i10 = i19;
                                    readBits4 = readBits11;
                                    readBits10 = 0;
                                } else {
                                    i10 = i15;
                                    readBits10 = 0;
                                    readBits4 = 0;
                                }
                            } else {
                                i10 = i19;
                                readBits4 = parsableBitArray.readBits(7);
                                readBits10 = parsableBitArray.readBits(8);
                            }
                            if (readBits4 != 0 && paint != null) {
                                paint.setColor(iArr[readBits10]);
                                i11 = i15;
                                canvas.drawRect(i18, i13, i18 + readBits4, i13 + 1, paint);
                            } else {
                                i11 = i15;
                            }
                            i18 += readBits4;
                            if (i10 != 0) {
                                i12 = i18;
                                continue;
                            } else {
                                i15 = i11;
                                i19 = i10;
                            }
                        }
                    default:
                        switch (readBits5) {
                            case 32:
                                bArr8 = m6485a(4, 4, parsableBitArray);
                                break;
                            case 33:
                                bArr6 = m6485a(4, 8, parsableBitArray);
                                break;
                            case 34:
                                bArr7 = m6485a(16, 8, parsableBitArray);
                                break;
                            default:
                                continue;
                        }
                }
                i12 = i4;
            } else {
                i13 += 2;
                i12 = i2;
            }
        }
    }

    /* renamed from: f */
    public static h70 m6490f(ParsableBitArray parsableBitArray, int i) {
        int[] iArr;
        int readBits;
        int i2;
        int readBits2;
        int i3;
        int i4;
        int i5 = 8;
        int readBits3 = parsableBitArray.readBits(8);
        parsableBitArray.skipBits(8);
        int i6 = 2;
        int i7 = i - 2;
        int i8 = 0;
        int[] iArr2 = {0, -1, ViewCompat.MEASURED_STATE_MASK, -8421505};
        int[] m6486b = m6486b();
        int[] m6487c = m6487c();
        while (i7 > 0) {
            int readBits4 = parsableBitArray.readBits(i5);
            int readBits5 = parsableBitArray.readBits(i5);
            if ((readBits5 & 128) != 0) {
                iArr = iArr2;
            } else if ((readBits5 & 64) != 0) {
                iArr = m6486b;
            } else {
                iArr = m6487c;
            }
            if ((readBits5 & 1) != 0) {
                i3 = parsableBitArray.readBits(i5);
                i4 = parsableBitArray.readBits(i5);
                readBits = parsableBitArray.readBits(i5);
                readBits2 = parsableBitArray.readBits(i5);
                i2 = i7 - 6;
            } else {
                int readBits6 = parsableBitArray.readBits(6) << i6;
                int readBits7 = parsableBitArray.readBits(4) << 4;
                readBits = parsableBitArray.readBits(4) << 4;
                i2 = i7 - 4;
                readBits2 = parsableBitArray.readBits(i6) << 6;
                i3 = readBits6;
                i4 = readBits7;
            }
            if (i3 == 0) {
                i4 = i8;
                readBits = i4;
                readBits2 = 255;
            }
            double d = i3;
            double d2 = i4 - 128;
            double d3 = readBits - 128;
            iArr[readBits4] = m6488d((byte) (255 - (readBits2 & 255)), Util.constrainValue((int) ((1.402d * d2) + d), 0, 255), Util.constrainValue((int) ((d - (0.34414d * d3)) - (d2 * 0.71414d)), 0, 255), Util.constrainValue((int) ((d3 * 1.772d) + d), 0, 255));
            i7 = i2;
            i8 = 0;
            readBits3 = readBits3;
            m6487c = m6487c;
            i5 = 8;
            i6 = 2;
        }
        return new h70(readBits3, iArr2, m6486b, m6487c);
    }

    /* renamed from: g */
    public static j70 m6491g(ParsableBitArray parsableBitArray) {
        byte[] bArr;
        int readBits = parsableBitArray.readBits(16);
        parsableBitArray.skipBits(4);
        int readBits2 = parsableBitArray.readBits(2);
        boolean readBit = parsableBitArray.readBit();
        parsableBitArray.skipBits(1);
        byte[] bArr2 = Util.EMPTY_BYTE_ARRAY;
        if (readBits2 == 1) {
            parsableBitArray.skipBits(parsableBitArray.readBits(8) * 16);
        } else if (readBits2 == 0) {
            int readBits3 = parsableBitArray.readBits(16);
            int readBits4 = parsableBitArray.readBits(16);
            if (readBits3 > 0) {
                bArr2 = new byte[readBits3];
                parsableBitArray.readBytes(bArr2, 0, readBits3);
            }
            if (readBits4 > 0) {
                bArr = new byte[readBits4];
                parsableBitArray.readBytes(bArr, 0, readBits4);
                return new j70(readBits, readBit, bArr2, bArr);
            }
        }
        bArr = bArr2;
        return new j70(readBits, readBit, bArr2, bArr);
    }
}
