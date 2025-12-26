package com.google.android.exoplayer2.util;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Handler;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@RequiresApi(17)
/* loaded from: classes.dex */
public final class EGLSurfaceTexture implements SurfaceTexture.OnFrameAvailableListener, Runnable {
    public static final int SECURE_MODE_NONE = 0;
    public static final int SECURE_MODE_PROTECTED_PBUFFER = 2;
    public static final int SECURE_MODE_SURFACELESS_CONTEXT = 1;

    /* renamed from: h */
    public static final int[] f12685h = {12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12327, 12344, 12339, 4, 12344};

    /* renamed from: a */
    public final Handler f12686a;

    /* renamed from: b */
    public final int[] f12687b;

    /* renamed from: c */
    public final TextureImageListener f12688c;

    /* renamed from: d */
    public EGLDisplay f12689d;

    /* renamed from: e */
    public EGLContext f12690e;

    /* renamed from: f */
    public EGLSurface f12691f;

    /* renamed from: g */
    public SurfaceTexture f12692g;

    /* loaded from: classes.dex */
    public static final class GlException extends RuntimeException {
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface SecureMode {
    }

    /* loaded from: classes.dex */
    public interface TextureImageListener {
        void onFrameAvailable();
    }

    public EGLSurfaceTexture(Handler handler) {
        this(handler, null);
    }

    public SurfaceTexture getSurfaceTexture() {
        return (SurfaceTexture) Assertions.checkNotNull(this.f12692g);
    }

    public void init(int i) {
        EGLConfig eGLConfig;
        int[] iArr;
        int[] iArr2;
        EGLSurface eglCreatePbufferSurface;
        EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
        if (eglGetDisplay != null) {
            int[] iArr3 = new int[2];
            if (EGL14.eglInitialize(eglGetDisplay, iArr3, 0, iArr3, 1)) {
                this.f12689d = eglGetDisplay;
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                int[] iArr4 = new int[1];
                boolean eglChooseConfig = EGL14.eglChooseConfig(eglGetDisplay, f12685h, 0, eGLConfigArr, 0, 1, iArr4, 0);
                if (eglChooseConfig && iArr4[0] > 0 && (eGLConfig = eGLConfigArr[0]) != null) {
                    EGLDisplay eGLDisplay = this.f12689d;
                    if (i == 0) {
                        iArr = new int[]{12440, 2, 12344};
                    } else {
                        iArr = new int[]{12440, 2, 12992, 1, 12344};
                    }
                    EGLContext eglCreateContext = EGL14.eglCreateContext(eGLDisplay, eGLConfig, EGL14.EGL_NO_CONTEXT, iArr, 0);
                    if (eglCreateContext != null) {
                        this.f12690e = eglCreateContext;
                        EGLDisplay eGLDisplay2 = this.f12689d;
                        if (i == 1) {
                            eglCreatePbufferSurface = EGL14.EGL_NO_SURFACE;
                        } else {
                            if (i == 2) {
                                iArr2 = new int[]{12375, 1, 12374, 1, 12992, 1, 12344};
                            } else {
                                iArr2 = new int[]{12375, 1, 12374, 1, 12344};
                            }
                            eglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(eGLDisplay2, eGLConfig, iArr2, 0);
                            if (eglCreatePbufferSurface == null) {
                                throw new RuntimeException("eglCreatePbufferSurface failed");
                            }
                        }
                        if (EGL14.eglMakeCurrent(eGLDisplay2, eglCreatePbufferSurface, eglCreatePbufferSurface, eglCreateContext)) {
                            this.f12691f = eglCreatePbufferSurface;
                            int[] iArr5 = this.f12687b;
                            GLES20.glGenTextures(1, iArr5, 0);
                            GlUtil.checkGlError();
                            SurfaceTexture surfaceTexture = new SurfaceTexture(iArr5[0]);
                            this.f12692g = surfaceTexture;
                            surfaceTexture.setOnFrameAvailableListener(this);
                            return;
                        }
                        throw new RuntimeException("eglMakeCurrent failed");
                    }
                    throw new RuntimeException("eglCreateContext failed");
                }
                throw new RuntimeException(Util.formatInvariant("eglChooseConfig failed: success=%b, numConfigs[0]=%d, configs[0]=%s", Boolean.valueOf(eglChooseConfig), Integer.valueOf(iArr4[0]), eGLConfigArr[0]));
            }
            throw new RuntimeException("eglInitialize failed");
        }
        throw new RuntimeException("eglGetDisplay failed");
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.f12686a.post(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void release() {
        this.f12686a.removeCallbacks(this);
        try {
            SurfaceTexture surfaceTexture = this.f12692g;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                GLES20.glDeleteTextures(1, this.f12687b, 0);
            }
        } finally {
            EGLDisplay eGLDisplay = this.f12689d;
            if (eGLDisplay != null && !eGLDisplay.equals(EGL14.EGL_NO_DISPLAY)) {
                EGLDisplay eGLDisplay2 = this.f12689d;
                EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
                EGL14.eglMakeCurrent(eGLDisplay2, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            }
            EGLSurface eGLSurface2 = this.f12691f;
            if (eGLSurface2 != null && !eGLSurface2.equals(EGL14.EGL_NO_SURFACE)) {
                EGL14.eglDestroySurface(this.f12689d, this.f12691f);
            }
            EGLContext eGLContext = this.f12690e;
            if (eGLContext != null) {
                EGL14.eglDestroyContext(this.f12689d, eGLContext);
            }
            if (Util.SDK_INT >= 19) {
                EGL14.eglReleaseThread();
            }
            EGLDisplay eGLDisplay3 = this.f12689d;
            if (eGLDisplay3 != null && !eGLDisplay3.equals(EGL14.EGL_NO_DISPLAY)) {
                EGL14.eglTerminate(this.f12689d);
            }
            this.f12689d = null;
            this.f12690e = null;
            this.f12691f = null;
            this.f12692g = null;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        TextureImageListener textureImageListener = this.f12688c;
        if (textureImageListener != null) {
            textureImageListener.onFrameAvailable();
        }
        SurfaceTexture surfaceTexture = this.f12692g;
        if (surfaceTexture != null) {
            try {
                surfaceTexture.updateTexImage();
            } catch (RuntimeException unused) {
            }
        }
    }

    public EGLSurfaceTexture(Handler handler, @Nullable TextureImageListener textureImageListener) {
        this.f12686a = handler;
        this.f12688c = textureImageListener;
        this.f12687b = new int[1];
    }
}
