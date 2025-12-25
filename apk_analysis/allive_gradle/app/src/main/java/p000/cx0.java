package p000;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.GlUtil;

/* loaded from: classes.dex */
public abstract class cx0 {
    @DoNotInline
    /* renamed from: a */
    public static EGLContext m4495a(EGLDisplay eGLDisplay, int i, int[] iArr) {
        EGLContext eglCreateContext = EGL14.eglCreateContext(eGLDisplay, m4500f(eGLDisplay, iArr), EGL14.EGL_NO_CONTEXT, new int[]{12440, i, 12344}, 0);
        if (eglCreateContext == null) {
            EGL14.eglTerminate(eGLDisplay);
            GlUtil.m3019b("eglCreateContext() failed to create a valid context. The device may not support EGL version " + i);
        }
        GlUtil.checkGlError();
        return eglCreateContext;
    }

    @DoNotInline
    /* renamed from: b */
    public static EGLDisplay m4496b() {
        EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
        if (eglGetDisplay.equals(EGL14.EGL_NO_DISPLAY)) {
            GlUtil.m3019b("No EGL display.");
        }
        if (!EGL14.eglInitialize(eglGetDisplay, new int[1], 0, new int[1], 0)) {
            GlUtil.m3019b("Error in eglInitialize.");
        }
        GlUtil.checkGlError();
        return eglGetDisplay;
    }

    @DoNotInline
    /* renamed from: c */
    public static EGLSurface m4497c(EGLDisplay eGLDisplay, int[] iArr, int[] iArr2) {
        EGLSurface eglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(eGLDisplay, m4500f(eGLDisplay, iArr), iArr2, 0);
        GlUtil.m3018a("Error creating surface");
        return eglCreatePbufferSurface;
    }

    @DoNotInline
    /* renamed from: d */
    public static void m4498d(@Nullable EGLDisplay eGLDisplay, @Nullable EGLContext eGLContext) {
        if (eGLDisplay == null) {
            return;
        }
        EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
        EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
        GlUtil.m3018a("Error releasing context");
        if (eGLContext != null) {
            EGL14.eglDestroyContext(eGLDisplay, eGLContext);
            GlUtil.m3018a("Error destroying context");
        }
        EGL14.eglReleaseThread();
        GlUtil.m3018a("Error releasing thread");
        EGL14.eglTerminate(eGLDisplay);
        GlUtil.m3018a("Error terminating display");
    }

    @DoNotInline
    /* renamed from: e */
    public static void m4499e(EGLDisplay eGLDisplay, EGLContext eGLContext, EGLSurface eGLSurface, int i, int i2, int i3) {
        int[] iArr = new int[1];
        GLES20.glGetIntegerv(36006, iArr, 0);
        if (iArr[0] != i) {
            GLES20.glBindFramebuffer(36160, i);
        }
        GlUtil.checkGlError();
        EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, eGLContext);
        GlUtil.m3018a("Error making context current");
        GLES20.glViewport(0, 0, i2, i3);
        GlUtil.checkGlError();
    }

    @DoNotInline
    /* renamed from: f */
    private static EGLConfig m4500f(EGLDisplay eGLDisplay, int[] iArr) {
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (!EGL14.eglChooseConfig(eGLDisplay, iArr, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
            GlUtil.m3019b("eglChooseConfig failed.");
        }
        return eGLConfigArr[0];
    }

    @DoNotInline
    /* renamed from: g */
    public static EGLSurface m4501g(EGLDisplay eGLDisplay, Object obj, int[] iArr, int[] iArr2) {
        EGLSurface eglCreateWindowSurface = EGL14.eglCreateWindowSurface(eGLDisplay, m4500f(eGLDisplay, iArr), obj, iArr2, 0);
        GlUtil.m3018a("Error creating surface");
        return eglCreateWindowSurface;
    }
}
