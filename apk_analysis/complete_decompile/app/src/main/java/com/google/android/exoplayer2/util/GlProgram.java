package com.google.android.exoplayer2.util;

import android.content.Context;
import android.opengl.GLES20;
import java.nio.Buffer;
import java.util.HashMap;
import p000.ax0;
import p000.bx0;
import p000.ye0;

/* loaded from: classes.dex */
public final class GlProgram {

    /* renamed from: a */
    public final int f12703a;

    /* renamed from: b */
    public final ax0[] f12704b;

    /* renamed from: c */
    public final bx0[] f12705c;

    /* renamed from: d */
    public final HashMap f12706d;

    /* renamed from: e */
    public final HashMap f12707e;

    public GlProgram(Context context, String str, String str2) {
        this(GlUtil.loadAsset(context, str), GlUtil.loadAsset(context, str2));
    }

    /* renamed from: a */
    public static void m3017a(int i, int i2, String str) {
        int glCreateShader = GLES20.glCreateShader(i2);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = {0};
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] != 1) {
            GlUtil.m3019b(GLES20.glGetShaderInfoLog(glCreateShader) + ", source: " + str);
        }
        GLES20.glAttachShader(i, glCreateShader);
        GLES20.glDeleteShader(glCreateShader);
        GlUtil.checkGlError();
    }

    public void bindAttributesAndUniforms() {
        int i;
        for (ax0 ax0Var : this.f12704b) {
            Buffer buffer = (Buffer) Assertions.checkNotNull(ax0Var.f7777c, "call setBuffer before bind");
            GLES20.glBindBuffer(34962, 0);
            GLES20.glVertexAttribPointer(ax0Var.f7776b, ax0Var.f7778d, 5126, false, 0, buffer);
            GLES20.glEnableVertexAttribArray(ax0Var.f7775a);
            GlUtil.checkGlError();
        }
        for (bx0 bx0Var : this.f12705c) {
            float[] fArr = bx0Var.f8175c;
            int i2 = bx0Var.f8173a;
            int i3 = bx0Var.f8174b;
            switch (i3) {
                case 5126:
                    GLES20.glUniform1fv(i2, 1, fArr, 0);
                    GlUtil.checkGlError();
                    break;
                case 35664:
                    GLES20.glUniform2fv(i2, 1, fArr, 0);
                    GlUtil.checkGlError();
                    break;
                case 35665:
                    GLES20.glUniform3fv(i2, 1, fArr, 0);
                    GlUtil.checkGlError();
                    break;
                case 35675:
                    GLES20.glUniformMatrix3fv(i2, 1, false, fArr, 0);
                    GlUtil.checkGlError();
                    break;
                case 35676:
                    GLES20.glUniformMatrix4fv(i2, 1, false, fArr, 0);
                    GlUtil.checkGlError();
                    break;
                case 35678:
                case 35815:
                case 36198:
                    if (bx0Var.f8176d != 0) {
                        GLES20.glActiveTexture(bx0Var.f8177e + 33984);
                        GlUtil.checkGlError();
                        if (i3 == 35678) {
                            i = 3553;
                        } else {
                            i = 36197;
                        }
                        GlUtil.bindTexture(i, bx0Var.f8176d);
                        GLES20.glUniform1i(i2, bx0Var.f8177e);
                        GlUtil.checkGlError();
                        break;
                    } else {
                        throw new IllegalStateException("No call to setSamplerTexId() before bind.");
                    }
                default:
                    throw new IllegalStateException(ye0.m8291k(i3, "Unexpected uniform type: "));
            }
        }
    }

    public void delete() {
        GLES20.glDeleteProgram(this.f12703a);
        GlUtil.checkGlError();
    }

    public int getAttributeArrayLocationAndEnable(String str) {
        int glGetAttribLocation = GLES20.glGetAttribLocation(this.f12703a, str);
        GLES20.glEnableVertexAttribArray(glGetAttribLocation);
        GlUtil.checkGlError();
        return glGetAttribLocation;
    }

    public int getUniformLocation(String str) {
        return GLES20.glGetUniformLocation(this.f12703a, str);
    }

    public void setBufferAttribute(String str, float[] fArr, int i) {
        ax0 ax0Var = (ax0) Assertions.checkNotNull((ax0) this.f12706d.get(str));
        ax0Var.getClass();
        ax0Var.f7777c = GlUtil.createBuffer(fArr);
        ax0Var.f7778d = i;
    }

    public void setFloatUniform(String str, float f) {
        ((bx0) Assertions.checkNotNull((bx0) this.f12707e.get(str))).f8175c[0] = f;
    }

    public void setFloatsUniform(String str, float[] fArr) {
        bx0 bx0Var = (bx0) Assertions.checkNotNull((bx0) this.f12707e.get(str));
        bx0Var.getClass();
        System.arraycopy(fArr, 0, bx0Var.f8175c, 0, fArr.length);
    }

    public void setSamplerTexIdUniform(String str, int i, int i2) {
        bx0 bx0Var = (bx0) Assertions.checkNotNull((bx0) this.f12707e.get(str));
        bx0Var.f8176d = i;
        bx0Var.f8177e = i2;
    }

    public void use() {
        GLES20.glUseProgram(this.f12703a);
        GlUtil.checkGlError();
    }

    public GlProgram(String str, String str2) {
        byte[] bArr;
        byte[] bArr2;
        int glCreateProgram = GLES20.glCreateProgram();
        this.f12703a = glCreateProgram;
        GlUtil.checkGlError();
        m3017a(glCreateProgram, 35633, str);
        m3017a(glCreateProgram, 35632, str2);
        GLES20.glLinkProgram(glCreateProgram);
        int i = 0;
        int[] iArr = {0};
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        int i2 = 1;
        if (iArr[0] != 1) {
            GlUtil.m3019b("Unable to link shader program: \n" + GLES20.glGetProgramInfoLog(glCreateProgram));
        }
        GLES20.glUseProgram(glCreateProgram);
        this.f12706d = new HashMap();
        int[] iArr2 = new int[1];
        GLES20.glGetProgramiv(glCreateProgram, 35721, iArr2, 0);
        this.f12704b = new ax0[iArr2[0]];
        int i3 = 0;
        while (i3 < iArr2[0]) {
            int i4 = this.f12703a;
            int[] iArr3 = new int[i2];
            GLES20.glGetProgramiv(i4, 35722, iArr3, 0);
            int i5 = iArr3[0];
            byte[] bArr3 = new byte[i5];
            GLES20.glGetActiveAttrib(i4, i3, i5, new int[i2], 0, new int[i2], 0, new int[i2], 0, bArr3, 0);
            int i6 = 0;
            while (true) {
                if (i6 >= i5) {
                    bArr2 = bArr3;
                    i6 = i5;
                    break;
                } else {
                    bArr2 = bArr3;
                    if (bArr2[i6] == 0) {
                        break;
                    }
                    i6++;
                    bArr3 = bArr2;
                }
            }
            String str3 = new String(bArr2, 0, i6);
            ax0 ax0Var = new ax0(str3, i3, GLES20.glGetAttribLocation(i4, str3));
            this.f12704b[i3] = ax0Var;
            this.f12706d.put(str3, ax0Var);
            i3++;
            i2 = 1;
        }
        this.f12707e = new HashMap();
        int[] iArr4 = new int[1];
        GLES20.glGetProgramiv(this.f12703a, 35718, iArr4, 0);
        this.f12705c = new bx0[iArr4[0]];
        for (int i7 = 0; i7 < iArr4[i]; i7++) {
            int i8 = this.f12703a;
            int[] iArr5 = new int[1];
            GLES20.glGetProgramiv(i8, 35719, iArr5, i);
            int[] iArr6 = new int[1];
            int i9 = iArr5[i];
            byte[] bArr4 = new byte[i9];
            GLES20.glGetActiveUniform(i8, i7, i9, new int[1], 0, new int[1], 0, iArr6, 0, bArr4, 0);
            int i10 = 0;
            while (true) {
                if (i10 >= i9) {
                    bArr = bArr4;
                    i10 = i9;
                    break;
                } else {
                    bArr = bArr4;
                    if (bArr[i10] == 0) {
                        break;
                    }
                    i10++;
                    bArr4 = bArr;
                }
            }
            i = 0;
            String str4 = new String(bArr, 0, i10);
            bx0 bx0Var = new bx0(str4, GLES20.glGetUniformLocation(i8, str4), iArr6[0]);
            this.f12705c[i7] = bx0Var;
            this.f12707e.put(str4, bx0Var);
        }
        GlUtil.checkGlError();
    }
}
