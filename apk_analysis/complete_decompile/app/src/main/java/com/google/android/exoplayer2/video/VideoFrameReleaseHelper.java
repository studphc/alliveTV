package com.google.android.exoplayer2.video;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.view.Surface;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import p000.C1294i5;
import p000.ai2;
import p000.g23;
import p000.h23;
import p000.i23;
import p000.j23;
import p000.me0;
import p000.ne0;

/* loaded from: classes.dex */
public final class VideoFrameReleaseHelper {

    /* renamed from: a */
    public final ne0 f12872a;

    /* renamed from: b */
    public final h23 f12873b;

    /* renamed from: c */
    public final j23 f12874c;

    /* renamed from: d */
    public boolean f12875d;

    /* renamed from: e */
    public Surface f12876e;

    /* renamed from: f */
    public float f12877f;

    /* renamed from: g */
    public float f12878g;

    /* renamed from: h */
    public float f12879h;

    /* renamed from: i */
    public float f12880i;

    /* renamed from: j */
    public int f12881j;

    /* renamed from: k */
    public long f12882k;

    /* renamed from: l */
    public long f12883l;

    /* renamed from: m */
    public long f12884m;

    /* renamed from: n */
    public long f12885n;

    /* renamed from: o */
    public long f12886o;

    /* renamed from: p */
    public long f12887p;

    /* renamed from: q */
    public long f12888q;

    /* JADX WARN: Removed duplicated region for block: B:14:0x0057  */
    /* JADX WARN: Type inference failed for: r0v0, types: [ne0, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public VideoFrameReleaseHelper(@Nullable Context context) {
        h23 h23Var;
        DisplayManager displayManager;
        ?? obj = new Object();
        obj.f23341d = new me0();
        obj.f23342e = new me0();
        obj.f23339b = C0643C.TIME_UNSET;
        this.f12872a = obj;
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            if (Util.SDK_INT >= 17 && (displayManager = (DisplayManager) applicationContext.getSystemService("display")) != null) {
                h23Var = new i23(displayManager);
            } else {
                h23Var = null;
            }
            if (h23Var == null) {
                WindowManager windowManager = (WindowManager) applicationContext.getSystemService("window");
                if (windowManager != null) {
                    h23Var = new ai2(11, windowManager);
                }
            }
            this.f12873b = h23Var;
            this.f12874c = h23Var != null ? j23.f20354e : null;
            this.f12882k = C0643C.TIME_UNSET;
            this.f12883l = C0643C.TIME_UNSET;
            this.f12877f = -1.0f;
            this.f12880i = 1.0f;
            this.f12881j = 0;
        }
        h23Var = null;
        this.f12873b = h23Var;
        this.f12874c = h23Var != null ? j23.f20354e : null;
        this.f12882k = C0643C.TIME_UNSET;
        this.f12883l = C0643C.TIME_UNSET;
        this.f12877f = -1.0f;
        this.f12880i = 1.0f;
        this.f12881j = 0;
    }

    /* renamed from: a */
    public final void m3062a() {
        Surface surface;
        if (Util.SDK_INT >= 30 && (surface = this.f12876e) != null && this.f12881j != Integer.MIN_VALUE && this.f12879h != RecyclerView.f7068F0) {
            this.f12879h = RecyclerView.f7068F0;
            g23.m4901a(surface, RecyclerView.f7068F0);
        }
    }

    public long adjustReleaseTime(long j) {
        long j2;
        j23 j23Var;
        long j3;
        long j4;
        if (this.f12887p != -1 && ((me0) this.f12872a.f23341d).m6142a()) {
            ne0 ne0Var = this.f12872a;
            if (((me0) ne0Var.f23341d).m6142a()) {
                me0 me0Var = (me0) ne0Var.f23341d;
                long j5 = me0Var.f22911e;
                if (j5 == 0) {
                    j4 = 0;
                } else {
                    j4 = me0Var.f22912f / j5;
                }
            } else {
                j4 = -9223372036854775807L;
            }
            j2 = this.f12888q + (((float) ((this.f12884m - this.f12887p) * j4)) / this.f12880i);
            if (Math.abs(j - j2) > 20000000) {
                this.f12884m = 0L;
                this.f12887p = -1L;
                this.f12885n = -1L;
            }
            this.f12885n = this.f12884m;
            this.f12886o = j2;
            j23Var = this.f12874c;
            if (j23Var == null && this.f12882k != C0643C.TIME_UNSET) {
                long j6 = j23Var.f20355a;
                if (j6 == C0643C.TIME_UNSET) {
                    return j2;
                }
                long j7 = this.f12882k;
                long j8 = (((j2 - j6) / j7) * j7) + j6;
                if (j2 <= j8) {
                    j3 = j8 - j7;
                } else {
                    j3 = j8;
                    j8 = j7 + j8;
                }
                if (j8 - j2 >= j2 - j3) {
                    j8 = j3;
                }
                return j8 - this.f12883l;
            }
            return j2;
        }
        j2 = j;
        this.f12885n = this.f12884m;
        this.f12886o = j2;
        j23Var = this.f12874c;
        if (j23Var == null) {
        }
        return j2;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m3063b() {
        float f;
        float f2;
        long j;
        if (Util.SDK_INT >= 30 && this.f12876e != null) {
            ne0 ne0Var = this.f12872a;
            if (((me0) ne0Var.f23341d).m6142a()) {
                if (((me0) ne0Var.f23341d).m6142a()) {
                    me0 me0Var = (me0) ne0Var.f23341d;
                    long j2 = me0Var.f22911e;
                    long j3 = 0;
                    if (j2 != 0) {
                        j3 = me0Var.f22912f / j2;
                    }
                    f = (float) (1.0E9d / j3);
                } else {
                    f = -1.0f;
                }
            } else {
                f = this.f12877f;
            }
            float f3 = this.f12878g;
            if (f == f3) {
                return;
            }
            if (f != -1.0f && f3 != -1.0f) {
                if (((me0) ne0Var.f23341d).m6142a()) {
                    if (((me0) ne0Var.f23341d).m6142a()) {
                        j = ((me0) ne0Var.f23341d).f22912f;
                    } else {
                        j = C0643C.TIME_UNSET;
                    }
                    if (j >= 5000000000L) {
                        f2 = 0.02f;
                        if (Math.abs(f - this.f12878g) < f2) {
                            return;
                        }
                    }
                }
                f2 = 1.0f;
                if (Math.abs(f - this.f12878g) < f2) {
                }
            } else if (f == -1.0f && ne0Var.f23338a < 30) {
                return;
            }
            this.f12878g = f;
            m3064c(false);
        }
    }

    /* renamed from: c */
    public final void m3064c(boolean z) {
        Surface surface;
        float f;
        if (Util.SDK_INT >= 30 && (surface = this.f12876e) != null && this.f12881j != Integer.MIN_VALUE) {
            if (this.f12875d) {
                float f2 = this.f12878g;
                if (f2 != -1.0f) {
                    f = f2 * this.f12880i;
                    if (z && this.f12879h == f) {
                        return;
                    }
                    this.f12879h = f;
                    g23.m4901a(surface, f);
                }
            }
            f = RecyclerView.f7068F0;
            if (z) {
            }
            this.f12879h = f;
            g23.m4901a(surface, f);
        }
    }

    public void onFormatChanged(float f) {
        this.f12877f = f;
        ne0 ne0Var = this.f12872a;
        ((me0) ne0Var.f23341d).m6144c();
        ((me0) ne0Var.f23342e).m6144c();
        ne0Var.f23340c = false;
        ne0Var.f23339b = C0643C.TIME_UNSET;
        ne0Var.f23338a = 0;
        m3063b();
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0056, code lost:
    
        if (r1 != false) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onNextFrame(long j) {
        boolean z;
        long j2 = this.f12885n;
        if (j2 != -1) {
            this.f12887p = j2;
            this.f12888q = this.f12886o;
        }
        this.f12884m++;
        long j3 = j * 1000;
        ne0 ne0Var = this.f12872a;
        ((me0) ne0Var.f23341d).m6143b(j3);
        int i = 0;
        if (((me0) ne0Var.f23341d).m6142a()) {
            ne0Var.f23340c = false;
        } else if (ne0Var.f23339b != C0643C.TIME_UNSET) {
            if (ne0Var.f23340c) {
                me0 me0Var = (me0) ne0Var.f23342e;
                long j4 = me0Var.f22910d;
                if (j4 == 0) {
                    z = false;
                } else {
                    z = me0Var.f22913g[(int) ((j4 - 1) % 15)];
                }
            }
            ((me0) ne0Var.f23342e).m6144c();
            ((me0) ne0Var.f23342e).m6143b(ne0Var.f23339b);
            ne0Var.f23340c = true;
            ((me0) ne0Var.f23342e).m6143b(j3);
        }
        if (ne0Var.f23340c && ((me0) ne0Var.f23342e).m6142a()) {
            me0 me0Var2 = (me0) ne0Var.f23341d;
            ne0Var.f23341d = (me0) ne0Var.f23342e;
            ne0Var.f23342e = me0Var2;
            ne0Var.f23340c = false;
        }
        ne0Var.f23339b = j3;
        if (!((me0) ne0Var.f23341d).m6142a()) {
            i = ne0Var.f23338a + 1;
        }
        ne0Var.f23338a = i;
        m3063b();
    }

    public void onPlaybackSpeed(float f) {
        this.f12880i = f;
        this.f12884m = 0L;
        this.f12887p = -1L;
        this.f12885n = -1L;
        m3064c(false);
    }

    public void onPositionReset() {
        this.f12884m = 0L;
        this.f12887p = -1L;
        this.f12885n = -1L;
    }

    public void onStarted() {
        this.f12875d = true;
        this.f12884m = 0L;
        this.f12887p = -1L;
        this.f12885n = -1L;
        h23 h23Var = this.f12873b;
        if (h23Var != null) {
            ((j23) Assertions.checkNotNull(this.f12874c)).f20356b.sendEmptyMessage(1);
            h23Var.mo93b(new C1294i5(23, this));
        }
        m3064c(false);
    }

    public void onStopped() {
        this.f12875d = false;
        h23 h23Var = this.f12873b;
        if (h23Var != null) {
            h23Var.unregister();
            ((j23) Assertions.checkNotNull(this.f12874c)).f20356b.sendEmptyMessage(2);
        }
        m3062a();
    }

    public void onSurfaceChanged(@Nullable Surface surface) {
        if (surface instanceof PlaceholderSurface) {
            surface = null;
        }
        if (this.f12876e == surface) {
            return;
        }
        m3062a();
        this.f12876e = surface;
        m3064c(true);
    }

    public void setChangeFrameRateStrategy(int i) {
        if (this.f12881j == i) {
            return;
        }
        this.f12881j = i;
        m3064c(true);
    }
}
