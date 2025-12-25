package com.google.android.exoplayer2.util;

import android.content.Context;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.opengl.GLU;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.List;
import p000.cx0;

/* loaded from: classes.dex */
public final class GlUtil {
    public static final int HOMOGENEOUS_COORDINATE_VECTOR_SIZE = 4;
    public static final float LENGTH_NDC = 2.0f;

    /* renamed from: a */
    public static final int[] f12708a = {12344};

    /* renamed from: b */
    public static final int[] f12709b = {12445, 13120, 12344};

    /* renamed from: c */
    public static final int[] f12710c = {12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12344};

    /* renamed from: d */
    public static final int[] f12711d = {12352, 4, 12324, 10, 12323, 10, 12322, 10, 12321, 2, 12325, 0, 12326, 0, 12344};
    public static boolean glAssertionsEnabled = false;

    /* loaded from: classes.dex */
    public static final class GlException extends RuntimeException {
        public GlException(String str) {
            super(str);
        }
    }

    /* renamed from: a */
    public static void m3018a(String str) {
        boolean z;
        int eglGetError = EGL14.eglGetError();
        if (eglGetError == 12288) {
            z = true;
        } else {
            z = false;
        }
        String str2 = str + ", error code: " + eglGetError;
        if (!z) {
            m3019b(str2);
        }
    }

    public static void assertValidTextureSize(int i, int i2) {
        int[] iArr = new int[1];
        GLES20.glGetIntegerv(3379, iArr, 0);
        int i3 = iArr[0];
        if (i < 0 || i2 < 0) {
            m3019b("width or height is less than 0");
        }
        if (i > i3 || i2 > i3) {
            m3019b("width or height is greater than GL_MAX_TEXTURE_SIZE " + i3);
        }
    }

    /* renamed from: b */
    public static void m3019b(String str) {
        if (!glAssertionsEnabled) {
            Log.m3023e("GlUtil", str);
            return;
        }
        throw new GlException(str);
    }

    public static void bindTexture(int i, int i2) {
        GLES20.glBindTexture(i, i2);
        checkGlError();
        GLES20.glTexParameteri(i, 10240, 9729);
        checkGlError();
        GLES20.glTexParameteri(i, 10241, 9729);
        checkGlError();
        GLES20.glTexParameteri(i, 10242, 33071);
        checkGlError();
        GLES20.glTexParameteri(i, 10243, 33071);
        checkGlError();
    }

    public static void checkGlError() {
        int i = 0;
        while (true) {
            int glGetError = GLES20.glGetError();
            if (glGetError == 0) {
                break;
            }
            Log.m3023e("GlUtil", "glError: " + GLU.gluErrorString(glGetError));
            i = glGetError;
        }
        if (i != 0) {
            m3019b("glError: " + GLU.gluErrorString(i));
        }
    }

    public static FloatBuffer createBuffer(float[] fArr) {
        return (FloatBuffer) createBuffer(fArr.length).put(fArr).flip();
    }

    @RequiresApi(17)
    public static EGLContext createEglContext(EGLDisplay eGLDisplay) {
        return cx0.m4495a(eGLDisplay, 2, f12710c);
    }

    @RequiresApi(17)
    public static EGLContext createEglContextEs3Rgba1010102(EGLDisplay eGLDisplay) {
        return cx0.m4495a(eGLDisplay, 3, f12711d);
    }

    @RequiresApi(17)
    public static EGLDisplay createEglDisplay() {
        return cx0.m4496b();
    }

    public static int createExternalTexture() {
        if (Util.areEqual(EGL14.eglGetCurrentContext(), EGL14.EGL_NO_CONTEXT)) {
            m3019b("No current context");
        }
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        checkGlError();
        int i = iArr[0];
        bindTexture(36197, i);
        return i;
    }

    public static int createFboForTexture(int i) {
        if (Util.areEqual(EGL14.eglGetCurrentContext(), EGL14.EGL_NO_CONTEXT)) {
            m3019b("No current context");
        }
        int[] iArr = new int[1];
        GLES20.glGenFramebuffers(1, iArr, 0);
        checkGlError();
        GLES20.glBindFramebuffer(36160, iArr[0]);
        checkGlError();
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, i, 0);
        checkGlError();
        return iArr[0];
    }

    @RequiresApi(17)
    public static EGLSurface createPlaceholderEglSurface(EGLDisplay eGLDisplay) {
        if (isSurfacelessContextExtensionSupported()) {
            return EGL14.EGL_NO_SURFACE;
        }
        return cx0.m4497c(eGLDisplay, f12710c, new int[]{12375, 1, 12374, 1, 12344});
    }

    public static int createTexture(int i, int i2) {
        assertValidTextureSize(i, i2);
        if (Util.areEqual(EGL14.eglGetCurrentContext(), EGL14.EGL_NO_CONTEXT)) {
            m3019b("No current context");
        }
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        checkGlError();
        int i3 = iArr[0];
        bindTexture(3553, i3);
        GLES20.glTexImage2D(3553, 0, 6408, i, i2, 0, 6408, 5121, ByteBuffer.allocateDirect(i * i2 * 4));
        checkGlError();
        return i3;
    }

    public static float[] createVertexBuffer(List<float[]> list) {
        float[] fArr = new float[list.size() * 4];
        for (int i = 0; i < list.size(); i++) {
            System.arraycopy(list.get(i), 0, fArr, i * 4, 4);
        }
        return fArr;
    }

    public static void deleteTexture(int i) {
        GLES20.glDeleteTextures(1, new int[]{i}, 0);
        checkGlError();
    }

    @RequiresApi(17)
    public static void destroyEglContext(@Nullable EGLDisplay eGLDisplay, @Nullable EGLContext eGLContext) {
        cx0.m4498d(eGLDisplay, eGLContext);
    }

    @RequiresApi(17)
    public static void focusEglSurface(EGLDisplay eGLDisplay, EGLContext eGLContext, EGLSurface eGLSurface, int i, int i2) {
        cx0.m4499e(eGLDisplay, eGLContext, eGLSurface, 0, i, i2);
    }

    @RequiresApi(17)
    public static void focusFramebuffer(EGLDisplay eGLDisplay, EGLContext eGLContext, EGLSurface eGLSurface, int i, int i2, int i3) {
        cx0.m4499e(eGLDisplay, eGLContext, eGLSurface, i, i2, i3);
    }

    @RequiresApi(17)
    public static void focusPlaceholderEglSurface(EGLContext eGLContext, EGLDisplay eGLDisplay) {
        focusEglSurface(eGLDisplay, eGLContext, cx0.m4497c(eGLDisplay, f12710c, new int[]{12375, 1, 12374, 1, 12344}), 1, 1);
    }

    @RequiresApi(17)
    public static void focusPlaceholderEglSurfaceBt2020Pq(EGLContext eGLContext, EGLDisplay eGLDisplay) {
        focusEglSurface(eGLDisplay, eGLContext, cx0.m4497c(eGLDisplay, f12711d, new int[]{12375, 1, 12374, 1, 12445, 13120, 12344}), 1, 1);
    }

    @RequiresApi(17)
    public static EGLSurface getEglSurface(EGLDisplay eGLDisplay, Object obj) {
        return cx0.m4501g(eGLDisplay, obj, f12710c, f12708a);
    }

    @RequiresApi(17)
    public static EGLSurface getEglSurfaceBt2020Pq(EGLDisplay eGLDisplay, Object obj) {
        return cx0.m4501g(eGLDisplay, obj, f12711d, f12709b);
    }

    public static float[] getNormalizedCoordinateBounds() {
        return new float[]{-1.0f, -1.0f, RecyclerView.f7068F0, 1.0f, 1.0f, -1.0f, RecyclerView.f7068F0, 1.0f, -1.0f, 1.0f, RecyclerView.f7068F0, 1.0f, 1.0f, 1.0f, RecyclerView.f7068F0, 1.0f};
    }

    public static float[] getTextureCoordinateBounds() {
        return new float[]{RecyclerView.f7068F0, RecyclerView.f7068F0, RecyclerView.f7068F0, 1.0f, 1.0f, RecyclerView.f7068F0, RecyclerView.f7068F0, 1.0f, RecyclerView.f7068F0, 1.0f, RecyclerView.f7068F0, 1.0f, 1.0f, 1.0f, RecyclerView.f7068F0, 1.0f};
    }

    public static boolean isProtectedContentExtensionSupported(Context context) {
        String eglQueryString;
        int i = Util.SDK_INT;
        if (i < 24) {
            return false;
        }
        if (i < 26 && ("samsung".equals(Util.MANUFACTURER) || "XT1650".equals(Util.MODEL))) {
            return false;
        }
        if ((i < 26 && !context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance")) || (eglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373)) == null || !eglQueryString.contains("EGL_EXT_protected_content")) {
            return false;
        }
        return true;
    }

    public static boolean isSurfacelessContextExtensionSupported() {
        String eglQueryString;
        if (Util.SDK_INT < 17 || (eglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373)) == null || !eglQueryString.contains("EGL_KHR_surfaceless_context")) {
            return false;
        }
        return true;
    }

    public static String loadAsset(Context context, String str) {
        InputStream inputStream = null;
        try {
            inputStream = context.getAssets().open(str);
            return Util.fromUtf8Bytes(Util.toByteArray(inputStream));
        } finally {
            Util.closeQuietly(inputStream);
        }
    }

    public static FloatBuffer createBuffer(int i) {
        return ByteBuffer.allocateDirect(i * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    }
}
