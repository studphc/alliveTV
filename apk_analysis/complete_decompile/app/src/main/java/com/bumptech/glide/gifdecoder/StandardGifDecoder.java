package com.bumptech.glide.gifdecoder;

import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentTransaction;
import com.bumptech.glide.gifdecoder.GifDecoder;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;
import p000.ww0;

/* loaded from: classes.dex */
public class StandardGifDecoder implements GifDecoder {

    /* renamed from: a */
    public int[] f8591a;

    /* renamed from: b */
    public final int[] f8592b;

    /* renamed from: c */
    public final GifDecoder.BitmapProvider f8593c;

    /* renamed from: d */
    public ByteBuffer f8594d;

    /* renamed from: e */
    public byte[] f8595e;

    /* renamed from: f */
    public GifHeaderParser f8596f;

    /* renamed from: g */
    public short[] f8597g;

    /* renamed from: h */
    public byte[] f8598h;

    /* renamed from: i */
    public byte[] f8599i;

    /* renamed from: j */
    public byte[] f8600j;

    /* renamed from: k */
    public int[] f8601k;

    /* renamed from: l */
    public int f8602l;

    /* renamed from: m */
    public GifHeader f8603m;

    /* renamed from: n */
    public Bitmap f8604n;

    /* renamed from: o */
    public boolean f8605o;

    /* renamed from: p */
    public int f8606p;

    /* renamed from: q */
    public int f8607q;

    /* renamed from: r */
    public int f8608r;

    /* renamed from: s */
    public int f8609s;

    /* renamed from: t */
    public Boolean f8610t;

    /* renamed from: u */
    public Bitmap.Config f8611u;

    public StandardGifDecoder(@NonNull GifDecoder.BitmapProvider bitmapProvider, GifHeader gifHeader, ByteBuffer byteBuffer) {
        this(bitmapProvider, gifHeader, byteBuffer, 1);
    }

    /* renamed from: a */
    public final Bitmap m2307a() {
        Bitmap.Config config;
        Boolean bool = this.f8610t;
        if (bool != null && !bool.booleanValue()) {
            config = this.f8611u;
        } else {
            config = Bitmap.Config.ARGB_8888;
        }
        Bitmap obtain = this.f8593c.obtain(this.f8609s, this.f8608r, config);
        obtain.setHasAlpha(true);
        return obtain;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void advance() {
        this.f8602l = (this.f8602l + 1) % this.f8603m.f8577c;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0041, code lost:
    
        if (r3.f8584j == r34.f28364h) goto L26;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005a  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Bitmap m2308b(ww0 ww0Var, ww0 ww0Var2) {
        int[] iArr;
        byte b;
        int i;
        boolean z;
        boolean booleanValue;
        int i2;
        int i3;
        boolean z2;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        byte b2;
        boolean z3;
        int i13;
        int i14;
        short s;
        int i15;
        Bitmap bitmap;
        int i16;
        int i17;
        int i18;
        int[] iArr2 = this.f8601k;
        GifDecoder.BitmapProvider bitmapProvider = this.f8593c;
        byte b3 = 0;
        if (ww0Var2 == null) {
            Bitmap bitmap2 = this.f8604n;
            if (bitmap2 != null) {
                bitmapProvider.release(bitmap2);
            }
            this.f8604n = null;
            Arrays.fill(iArr2, 0);
        }
        if (ww0Var2 != null && ww0Var2.f28363g == 3 && this.f8604n == null) {
            Arrays.fill(iArr2, 0);
        }
        if (ww0Var2 != null && (i15 = ww0Var2.f28363g) > 0) {
            if (i15 == 2) {
                if (!ww0Var.f28362f) {
                    GifHeader gifHeader = this.f8603m;
                    i16 = gifHeader.f8585k;
                    if (ww0Var.f28367k != null) {
                    }
                    int i19 = ww0Var2.f28360d;
                    int i20 = this.f8607q;
                    int i21 = i19 / i20;
                    int i22 = ww0Var2.f28358b / i20;
                    int i23 = ww0Var2.f28359c / i20;
                    int i24 = ww0Var2.f28357a / i20;
                    int i25 = this.f8609s;
                    i17 = (i22 * i25) + i24;
                    i18 = (i21 * i25) + i17;
                    while (i17 < i18) {
                        int i26 = i17 + i23;
                        for (int i27 = i17; i27 < i26; i27++) {
                            iArr2[i27] = i16;
                        }
                        i17 += this.f8609s;
                    }
                }
                i16 = 0;
                int i192 = ww0Var2.f28360d;
                int i202 = this.f8607q;
                int i212 = i192 / i202;
                int i222 = ww0Var2.f28358b / i202;
                int i232 = ww0Var2.f28359c / i202;
                int i242 = ww0Var2.f28357a / i202;
                int i252 = this.f8609s;
                i17 = (i222 * i252) + i242;
                i18 = (i212 * i252) + i17;
                while (i17 < i18) {
                }
            } else if (i15 == 3 && (bitmap = this.f8604n) != null) {
                int i28 = this.f8609s;
                bitmap.getPixels(iArr2, 0, i28, 0, 0, i28, this.f8608r);
            }
        }
        this.f8594d.position(ww0Var.f28366j);
        int i29 = ww0Var.f28359c * ww0Var.f28360d;
        byte[] bArr = this.f8600j;
        if (bArr == null || bArr.length < i29) {
            this.f8600j = bitmapProvider.obtainByteArray(i29);
        }
        byte[] bArr2 = this.f8600j;
        if (this.f8597g == null) {
            this.f8597g = new short[4096];
        }
        short[] sArr = this.f8597g;
        if (this.f8598h == null) {
            this.f8598h = new byte[4096];
        }
        byte[] bArr3 = this.f8598h;
        if (this.f8599i == null) {
            this.f8599i = new byte[FragmentTransaction.TRANSIT_FRAGMENT_OPEN];
        }
        byte[] bArr4 = this.f8599i;
        int i30 = this.f8594d.get() & 255;
        int i31 = 1 << i30;
        int i32 = i31 + 1;
        int i33 = i31 + 2;
        int i34 = i30 + 1;
        int i35 = (1 << i34) - 1;
        for (int i36 = 0; i36 < i31; i36++) {
            sArr[i36] = 0;
            bArr3[i36] = (byte) i36;
        }
        byte[] bArr5 = this.f8595e;
        int i37 = i34;
        int i38 = 0;
        int i39 = 0;
        int i40 = 0;
        int i41 = 0;
        int i42 = 0;
        int i43 = 0;
        short s2 = 0;
        int i44 = 0;
        int i45 = i33;
        int i46 = i35;
        short s3 = -1;
        while (true) {
            if (i38 < i29) {
                if (i39 == 0) {
                    int i47 = this.f8594d.get() & 255;
                    if (i47 <= 0) {
                        i13 = i34;
                        i14 = i38;
                    } else {
                        ByteBuffer byteBuffer = this.f8594d;
                        i13 = i34;
                        i14 = i38;
                        byteBuffer.get(this.f8595e, 0, Math.min(i47, byteBuffer.remaining()));
                    }
                    if (i47 <= 0) {
                        this.f8606p = 3;
                        iArr = iArr2;
                        i = i43;
                        b = 0;
                        break;
                    }
                    i39 = i47;
                    i40 = 0;
                } else {
                    i13 = i34;
                    i14 = i38;
                }
                i42 += (bArr5[i40] & 255) << i41;
                i40++;
                i39--;
                short s4 = s3;
                int i48 = i41 + 8;
                int i49 = i45;
                int i50 = i37;
                i38 = i14;
                byte[] bArr6 = bArr5;
                short s5 = s2;
                while (true) {
                    if (i48 >= i50) {
                        int[] iArr3 = iArr2;
                        int i51 = i42 & i46;
                        i42 >>= i50;
                        i48 -= i50;
                        if (i51 == i31) {
                            i49 = i33;
                            i46 = i35;
                            iArr2 = iArr3;
                            i50 = i13;
                            s4 = -1;
                        } else {
                            if (i51 == i32) {
                                s2 = s5;
                                i37 = i50;
                                i45 = i49;
                                bArr5 = bArr6;
                                iArr2 = iArr3;
                                i34 = i13;
                                s3 = s4;
                                i41 = i48;
                                b3 = 0;
                                break;
                            }
                            if (s4 == -1) {
                                bArr2[i43] = bArr3[i51 == true ? 1 : 0];
                                i43++;
                                i38++;
                                s5 = i51 == true ? 1 : 0;
                                s4 = s5;
                                iArr2 = iArr3;
                                i48 = i48;
                            } else {
                                if (i51 >= i49) {
                                    bArr4[i44] = (byte) s5;
                                    i44++;
                                    s = s4;
                                } else {
                                    s = i51 == true ? 1 : 0;
                                }
                                while (s >= i31) {
                                    bArr4[i44] = bArr3[s];
                                    i44++;
                                    s = sArr[s];
                                }
                                boolean z4 = bArr3[s] & 255;
                                byte b4 = z4 ? (byte) 1 : (byte) 0;
                                bArr2[i43] = b4;
                                while (true) {
                                    i43++;
                                    i38++;
                                    if (i44 <= 0) {
                                        break;
                                    }
                                    i44--;
                                    bArr2[i43] = bArr4[i44];
                                }
                                if (i49 < 4096) {
                                    sArr[i49] = s4;
                                    bArr3[i49] = b4;
                                    i49++;
                                    if ((i49 & i46) == 0 && i49 < 4096) {
                                        i50++;
                                        i46 += i49;
                                    }
                                }
                                s4 = i51 == true ? 1 : 0;
                                iArr2 = iArr3;
                                i48 = i48;
                                s5 = z4 ? 1 : 0;
                            }
                        }
                    } else {
                        s2 = s5;
                        i37 = i50;
                        i41 = i48;
                        i45 = i49;
                        bArr5 = bArr6;
                        i34 = i13;
                        b3 = 0;
                        s3 = s4;
                        break;
                    }
                }
            } else {
                iArr = iArr2;
                b = b3;
                i = i43;
                break;
            }
        }
        Arrays.fill(bArr2, i, i29, b);
        if (!ww0Var.f28361e && this.f8607q == 1) {
            int[] iArr4 = this.f8601k;
            int i52 = ww0Var.f28360d;
            int i53 = ww0Var.f28358b;
            int i54 = ww0Var.f28359c;
            int i55 = ww0Var.f28357a;
            if (this.f8602l == 0) {
                b2 = 1;
            } else {
                b2 = b;
            }
            int i56 = this.f8609s;
            byte[] bArr7 = this.f8600j;
            int[] iArr5 = this.f8591a;
            int i57 = -1;
            for (int i58 = b; i58 < i52; i58++) {
                int i59 = (i58 + i53) * i56;
                int i60 = i59 + i55;
                int i61 = i60 + i54;
                int i62 = i59 + i56;
                if (i62 < i61) {
                    i61 = i62;
                }
                int i63 = ww0Var.f28359c * i58;
                while (i60 < i61) {
                    int i64 = i52;
                    int i65 = bArr7[i63];
                    int i66 = i53;
                    int i67 = i65 & 255;
                    if (i67 != i57) {
                        int i68 = iArr5[i67];
                        if (i68 != 0) {
                            iArr4[i60] = i68;
                        } else {
                            i57 = i65;
                        }
                    }
                    i63++;
                    i60++;
                    i52 = i64;
                    i53 = i66;
                }
            }
            Boolean bool = this.f8610t;
            if ((bool != null && bool.booleanValue()) || (this.f8610t == null && b2 != 0 && i57 != -1)) {
                z3 = true;
            } else {
                z3 = false;
            }
            this.f8610t = Boolean.valueOf(z3);
        } else {
            int[] iArr6 = this.f8601k;
            int i69 = ww0Var.f28360d;
            int i70 = this.f8607q;
            int i71 = i69 / i70;
            int i72 = ww0Var.f28358b / i70;
            int i73 = ww0Var.f28359c / i70;
            int i74 = ww0Var.f28357a / i70;
            if (this.f8602l == 0) {
                z = true;
            } else {
                z = false;
            }
            int i75 = this.f8609s;
            int i76 = this.f8608r;
            byte[] bArr8 = this.f8600j;
            int[] iArr7 = this.f8591a;
            Boolean bool2 = this.f8610t;
            int i77 = 8;
            int i78 = 0;
            int i79 = 0;
            int i80 = 1;
            while (i78 < i71) {
                Boolean bool3 = bool2;
                if (ww0Var.f28361e) {
                    if (i79 >= i71) {
                        int i81 = i80 + 1;
                        i2 = i71;
                        if (i81 != 2) {
                            if (i81 != 3) {
                                if (i81 == 4) {
                                    i80 = i81;
                                    i79 = 1;
                                    i77 = 2;
                                }
                            } else {
                                i77 = 4;
                                i80 = i81;
                                i79 = 2;
                            }
                        } else {
                            i79 = 4;
                        }
                        i80 = i81;
                    } else {
                        i2 = i71;
                    }
                    i3 = i79 + i77;
                } else {
                    i2 = i71;
                    i3 = i79;
                    i79 = i78;
                }
                int i82 = i79 + i72;
                if (i70 == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (i82 < i76) {
                    int i83 = i82 * i75;
                    int i84 = i83 + i74;
                    i4 = i3;
                    int i85 = i84 + i73;
                    int i86 = i83 + i75;
                    if (i86 < i85) {
                        i85 = i86;
                    }
                    i5 = i72;
                    int i87 = i78 * i70 * ww0Var.f28359c;
                    if (z2) {
                        bool2 = bool3;
                        int i88 = i84;
                        while (i88 < i85) {
                            int i89 = i73;
                            int i90 = iArr7[bArr8[i87] & 255];
                            if (i90 != 0) {
                                iArr6[i88] = i90;
                            } else if (z && bool2 == null) {
                                bool2 = Boolean.TRUE;
                            }
                            i87 += i70;
                            i88++;
                            i73 = i89;
                        }
                        i6 = i73;
                    } else {
                        i6 = i73;
                        int i91 = ((i85 - i84) * i70) + i87;
                        bool2 = bool3;
                        int i92 = i84;
                        while (i92 < i85) {
                            int i93 = i85;
                            int i94 = ww0Var.f28359c;
                            int i95 = i74;
                            int i96 = i75;
                            int i97 = i87;
                            int i98 = 0;
                            int i99 = 0;
                            int i100 = 0;
                            int i101 = 0;
                            int i102 = 0;
                            while (true) {
                                if (i97 < this.f8607q + i87) {
                                    byte[] bArr9 = this.f8600j;
                                    i10 = i76;
                                    if (i97 >= bArr9.length || i97 >= i91) {
                                        break;
                                    }
                                    int i103 = this.f8591a[bArr9[i97] & 255];
                                    if (i103 != 0) {
                                        i98 += (i103 >> 24) & 255;
                                        i99 += (i103 >> 16) & 255;
                                        i100 += (i103 >> 8) & 255;
                                        i101 += i103 & 255;
                                        i102++;
                                    }
                                    i97++;
                                    i76 = i10;
                                } else {
                                    i10 = i76;
                                    break;
                                }
                            }
                            int i104 = i94 + i87;
                            for (int i105 = i104; i105 < this.f8607q + i104; i105++) {
                                byte[] bArr10 = this.f8600j;
                                if (i105 >= bArr10.length || i105 >= i91) {
                                    break;
                                }
                                int i106 = this.f8591a[bArr10[i105] & 255];
                                if (i106 != 0) {
                                    i98 += (i106 >> 24) & 255;
                                    i99 += (i106 >> 16) & 255;
                                    i100 += (i106 >> 8) & 255;
                                    i101 += i106 & 255;
                                    i102++;
                                }
                            }
                            if (i102 == 0) {
                                i11 = 0;
                            } else {
                                i11 = ((i98 / i102) << 24) | ((i99 / i102) << 16) | ((i100 / i102) << 8) | (i101 / i102);
                            }
                            if (i11 != 0) {
                                iArr6[i92] = i11;
                            } else if (z && bool2 == null) {
                                bool2 = Boolean.TRUE;
                            }
                            i87 += i70;
                            i92++;
                            i85 = i93;
                            i74 = i95;
                            i75 = i96;
                            i76 = i10;
                        }
                    }
                    i7 = i74;
                    i8 = i75;
                    i9 = i76;
                } else {
                    i4 = i3;
                    i5 = i72;
                    i6 = i73;
                    i7 = i74;
                    i8 = i75;
                    i9 = i76;
                    bool2 = bool3;
                }
                i78++;
                i71 = i2;
                i79 = i4;
                i72 = i5;
                i73 = i6;
                i74 = i7;
                i75 = i8;
                i76 = i9;
            }
            Boolean bool4 = bool2;
            if (this.f8610t == null) {
                if (bool4 == null) {
                    booleanValue = false;
                } else {
                    booleanValue = bool4.booleanValue();
                }
                this.f8610t = Boolean.valueOf(booleanValue);
            }
        }
        if (this.f8605o && ((i12 = ww0Var.f28363g) == 0 || i12 == 1)) {
            if (this.f8604n == null) {
                this.f8604n = m2307a();
            }
            Bitmap bitmap3 = this.f8604n;
            int i107 = this.f8609s;
            bitmap3.setPixels(iArr, 0, i107, 0, 0, i107, this.f8608r);
        }
        Bitmap m2307a = m2307a();
        int i108 = this.f8609s;
        m2307a.setPixels(iArr, 0, i108, 0, 0, i108, this.f8608r);
        return m2307a;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void clear() {
        this.f8603m = null;
        byte[] bArr = this.f8600j;
        GifDecoder.BitmapProvider bitmapProvider = this.f8593c;
        if (bArr != null) {
            bitmapProvider.release(bArr);
        }
        int[] iArr = this.f8601k;
        if (iArr != null) {
            bitmapProvider.release(iArr);
        }
        Bitmap bitmap = this.f8604n;
        if (bitmap != null) {
            bitmapProvider.release(bitmap);
        }
        this.f8604n = null;
        this.f8594d = null;
        this.f8610t = null;
        byte[] bArr2 = this.f8595e;
        if (bArr2 != null) {
            bitmapProvider.release(bArr2);
        }
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getByteSize() {
        return (this.f8601k.length * 4) + this.f8594d.limit() + this.f8600j.length;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getCurrentFrameIndex() {
        return this.f8602l;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    @NonNull
    public ByteBuffer getData() {
        return this.f8594d;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getDelay(int i) {
        if (i >= 0) {
            GifHeader gifHeader = this.f8603m;
            if (i < gifHeader.f8577c) {
                return ((ww0) gifHeader.f8579e.get(i)).f28365i;
            }
        }
        return -1;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getFrameCount() {
        return this.f8603m.f8577c;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getHeight() {
        return this.f8603m.f8581g;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    @Deprecated
    public int getLoopCount() {
        int i = this.f8603m.f8586l;
        if (i == -1) {
            return 1;
        }
        return i;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getNetscapeLoopCount() {
        return this.f8603m.f8586l;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getNextDelay() {
        int i;
        if (this.f8603m.f8577c > 0 && (i = this.f8602l) >= 0) {
            return getDelay(i);
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0051 A[Catch: all -> 0x0014, TryCatch #0 {all -> 0x0014, blocks: (B:4:0x0007, B:6:0x000f, B:9:0x0040, B:14:0x004a, B:16:0x0051, B:17:0x005b, B:19:0x006c, B:20:0x0078, B:23:0x0081, B:25:0x0085, B:27:0x008d, B:28:0x00a0, B:32:0x00a4, B:34:0x00a8, B:36:0x00ba, B:38:0x00be, B:39:0x00c2, B:42:0x007d, B:44:0x00c8, B:46:0x00d0, B:49:0x0017, B:51:0x001f, B:52:0x003e), top: B:3:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006c A[Catch: all -> 0x0014, TryCatch #0 {all -> 0x0014, blocks: (B:4:0x0007, B:6:0x000f, B:9:0x0040, B:14:0x004a, B:16:0x0051, B:17:0x005b, B:19:0x006c, B:20:0x0078, B:23:0x0081, B:25:0x0085, B:27:0x008d, B:28:0x00a0, B:32:0x00a4, B:34:0x00a8, B:36:0x00ba, B:38:0x00be, B:39:0x00c2, B:42:0x007d, B:44:0x00c8, B:46:0x00d0, B:49:0x0017, B:51:0x001f, B:52:0x003e), top: B:3:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0085 A[Catch: all -> 0x0014, TryCatch #0 {all -> 0x0014, blocks: (B:4:0x0007, B:6:0x000f, B:9:0x0040, B:14:0x004a, B:16:0x0051, B:17:0x005b, B:19:0x006c, B:20:0x0078, B:23:0x0081, B:25:0x0085, B:27:0x008d, B:28:0x00a0, B:32:0x00a4, B:34:0x00a8, B:36:0x00ba, B:38:0x00be, B:39:0x00c2, B:42:0x007d, B:44:0x00c8, B:46:0x00d0, B:49:0x0017, B:51:0x001f, B:52:0x003e), top: B:3:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a4 A[Catch: all -> 0x0014, TRY_ENTER, TryCatch #0 {all -> 0x0014, blocks: (B:4:0x0007, B:6:0x000f, B:9:0x0040, B:14:0x004a, B:16:0x0051, B:17:0x005b, B:19:0x006c, B:20:0x0078, B:23:0x0081, B:25:0x0085, B:27:0x008d, B:28:0x00a0, B:32:0x00a4, B:34:0x00a8, B:36:0x00ba, B:38:0x00be, B:39:0x00c2, B:42:0x007d, B:44:0x00c8, B:46:0x00d0, B:49:0x0017, B:51:0x001f, B:52:0x003e), top: B:3:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x007d A[Catch: all -> 0x0014, TryCatch #0 {all -> 0x0014, blocks: (B:4:0x0007, B:6:0x000f, B:9:0x0040, B:14:0x004a, B:16:0x0051, B:17:0x005b, B:19:0x006c, B:20:0x0078, B:23:0x0081, B:25:0x0085, B:27:0x008d, B:28:0x00a0, B:32:0x00a4, B:34:0x00a8, B:36:0x00ba, B:38:0x00be, B:39:0x00c2, B:42:0x007d, B:44:0x00c8, B:46:0x00d0, B:49:0x0017, B:51:0x001f, B:52:0x003e), top: B:3:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00d0 A[Catch: all -> 0x0014, TRY_LEAVE, TryCatch #0 {all -> 0x0014, blocks: (B:4:0x0007, B:6:0x000f, B:9:0x0040, B:14:0x004a, B:16:0x0051, B:17:0x005b, B:19:0x006c, B:20:0x0078, B:23:0x0081, B:25:0x0085, B:27:0x008d, B:28:0x00a0, B:32:0x00a4, B:34:0x00a8, B:36:0x00ba, B:38:0x00be, B:39:0x00c2, B:42:0x007d, B:44:0x00c8, B:46:0x00d0, B:49:0x0017, B:51:0x001f, B:52:0x003e), top: B:3:0x0007 }] */
    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized Bitmap getNextFrame() {
        int i;
        int i2;
        ww0 ww0Var;
        int[] iArr;
        try {
            if (this.f8603m.f8577c > 0) {
                if (this.f8602l < 0) {
                }
                i = this.f8606p;
                if (i != 1 && i != 2) {
                    this.f8606p = 0;
                    if (this.f8595e == null) {
                        this.f8595e = this.f8593c.obtainByteArray(255);
                    }
                    ww0 ww0Var2 = (ww0) this.f8603m.f8579e.get(this.f8602l);
                    i2 = this.f8602l - 1;
                    if (i2 < 0) {
                        ww0Var = (ww0) this.f8603m.f8579e.get(i2);
                    } else {
                        ww0Var = null;
                    }
                    iArr = ww0Var2.f28367k;
                    if (iArr != null) {
                        iArr = this.f8603m.f8575a;
                    }
                    this.f8591a = iArr;
                    if (iArr != null) {
                        if (Log.isLoggable("StandardGifDecoder", 3)) {
                            Log.d("StandardGifDecoder", "No valid color table found for frame #" + this.f8602l);
                        }
                        this.f8606p = 1;
                        return null;
                    }
                    if (ww0Var2.f28362f) {
                        System.arraycopy(iArr, 0, this.f8592b, 0, iArr.length);
                        int[] iArr2 = this.f8592b;
                        this.f8591a = iArr2;
                        iArr2[ww0Var2.f28364h] = 0;
                        if (ww0Var2.f28363g == 2 && this.f8602l == 0) {
                            this.f8610t = Boolean.TRUE;
                        }
                    }
                    return m2308b(ww0Var2, ww0Var);
                }
                if (Log.isLoggable("StandardGifDecoder", 3)) {
                    Log.d("StandardGifDecoder", "Unable to decode frame, status=" + this.f8606p);
                }
                return null;
            }
            if (Log.isLoggable("StandardGifDecoder", 3)) {
                Log.d("StandardGifDecoder", "Unable to decode frame, frameCount=" + this.f8603m.f8577c + ", framePointer=" + this.f8602l);
            }
            this.f8606p = 1;
            i = this.f8606p;
            if (i != 1) {
                this.f8606p = 0;
                if (this.f8595e == null) {
                }
                ww0 ww0Var22 = (ww0) this.f8603m.f8579e.get(this.f8602l);
                i2 = this.f8602l - 1;
                if (i2 < 0) {
                }
                iArr = ww0Var22.f28367k;
                if (iArr != null) {
                }
                this.f8591a = iArr;
                if (iArr != null) {
                }
            }
            if (Log.isLoggable("StandardGifDecoder", 3)) {
            }
            return null;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getStatus() {
        return this.f8606p;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getTotalIterationCount() {
        int i = this.f8603m.f8586l;
        if (i == -1) {
            return 1;
        }
        if (i == 0) {
            return 0;
        }
        return i + 1;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getWidth() {
        return this.f8603m.f8580f;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int read(@Nullable InputStream inputStream, int i) {
        if (inputStream != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i > 0 ? i + 4096 : 16384);
                byte[] bArr = new byte[16384];
                while (true) {
                    int read = inputStream.read(bArr, 0, 16384);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                byteArrayOutputStream.flush();
                read(byteArrayOutputStream.toByteArray());
            } catch (IOException e) {
                Log.w("StandardGifDecoder", "Error reading data from stream", e);
            }
        } else {
            this.f8606p = 2;
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e2) {
                Log.w("StandardGifDecoder", "Error closing stream", e2);
            }
        }
        return this.f8606p;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void resetFrameIndex() {
        this.f8602l = -1;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public synchronized void setData(@NonNull GifHeader gifHeader, @NonNull byte[] bArr) {
        setData(gifHeader, ByteBuffer.wrap(bArr));
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void setDefaultBitmapConfig(@NonNull Bitmap.Config config) {
        Bitmap.Config config2;
        Bitmap.Config config3 = Bitmap.Config.ARGB_8888;
        if (config != config3 && config != (config2 = Bitmap.Config.RGB_565)) {
            throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + config3 + " or " + config2);
        }
        this.f8611u = config;
    }

    public StandardGifDecoder(@NonNull GifDecoder.BitmapProvider bitmapProvider, GifHeader gifHeader, ByteBuffer byteBuffer, int i) {
        this(bitmapProvider);
        setData(gifHeader, byteBuffer, i);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public synchronized void setData(@NonNull GifHeader gifHeader, @NonNull ByteBuffer byteBuffer) {
        setData(gifHeader, byteBuffer, 1);
    }

    public StandardGifDecoder(@NonNull GifDecoder.BitmapProvider bitmapProvider) {
        this.f8592b = new int[256];
        this.f8611u = Bitmap.Config.ARGB_8888;
        this.f8593c = bitmapProvider;
        this.f8603m = new GifHeader();
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public synchronized void setData(@NonNull GifHeader gifHeader, @NonNull ByteBuffer byteBuffer, int i) {
        try {
            if (i > 0) {
                int highestOneBit = Integer.highestOneBit(i);
                this.f8606p = 0;
                this.f8603m = gifHeader;
                this.f8602l = -1;
                ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
                this.f8594d = asReadOnlyBuffer;
                asReadOnlyBuffer.position(0);
                this.f8594d.order(ByteOrder.LITTLE_ENDIAN);
                this.f8605o = false;
                Iterator it = gifHeader.f8579e.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (((ww0) it.next()).f28363g == 3) {
                        this.f8605o = true;
                        break;
                    }
                }
                this.f8607q = highestOneBit;
                int i2 = gifHeader.f8580f;
                this.f8609s = i2 / highestOneBit;
                int i3 = gifHeader.f8581g;
                this.f8608r = i3 / highestOneBit;
                this.f8600j = this.f8593c.obtainByteArray(i2 * i3);
                this.f8601k = this.f8593c.obtainIntArray(this.f8609s * this.f8608r);
            } else {
                throw new IllegalArgumentException("Sample size must be >=0, not: " + i);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public synchronized int read(@Nullable byte[] bArr) {
        try {
            if (this.f8596f == null) {
                this.f8596f = new GifHeaderParser();
            }
            GifHeader parseHeader = this.f8596f.setData(bArr).parseHeader();
            this.f8603m = parseHeader;
            if (bArr != null) {
                setData(parseHeader, bArr);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f8606p;
    }
}
