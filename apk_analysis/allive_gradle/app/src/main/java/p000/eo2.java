package p000;

import android.content.Context;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Handler;
import com.google.android.exoplayer2.SurfaceHolderCallbackC0644a;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;

/* loaded from: classes.dex */
public final class eo2 {

    /* renamed from: a */
    public final Context f16930a;

    /* renamed from: b */
    public final Handler f16931b;

    /* renamed from: c */
    public final SurfaceHolderCallbackC0644a f16932c;

    /* renamed from: d */
    public final AudioManager f16933d;

    /* renamed from: e */
    public C1150e9 f16934e;

    /* renamed from: f */
    public int f16935f;

    /* renamed from: g */
    public int f16936g;

    /* renamed from: h */
    public boolean f16937h;

    public eo2(Context context, Handler handler, SurfaceHolderCallbackC0644a surfaceHolderCallbackC0644a) {
        boolean z;
        Context applicationContext = context.getApplicationContext();
        this.f16930a = applicationContext;
        this.f16931b = handler;
        this.f16932c = surfaceHolderCallbackC0644a;
        AudioManager audioManager = (AudioManager) Assertions.checkStateNotNull((AudioManager) applicationContext.getSystemService(MimeTypes.BASE_TYPE_AUDIO));
        this.f16933d = audioManager;
        this.f16935f = 3;
        this.f16936g = m4737b(audioManager, 3);
        int i = this.f16935f;
        if (Util.SDK_INT >= 23) {
            z = audioManager.isStreamMute(i);
        } else if (m4737b(audioManager, i) == 0) {
            z = true;
        } else {
            z = false;
        }
        this.f16937h = z;
        C1150e9 c1150e9 = new C1150e9(6, this);
        try {
            applicationContext.registerReceiver(c1150e9, new IntentFilter("android.media.VOLUME_CHANGED_ACTION"));
            this.f16934e = c1150e9;
        } catch (RuntimeException e) {
            Log.m3028w("StreamVolumeManager", "Error registering stream volume receiver", e);
        }
    }

    /* renamed from: b */
    public static int m4737b(AudioManager audioManager, int i) {
        try {
            return audioManager.getStreamVolume(i);
        } catch (RuntimeException e) {
            Log.m3028w("StreamVolumeManager", "Could not retrieve stream volume for stream type " + i, e);
            return audioManager.getStreamMaxVolume(i);
        }
    }

    /* renamed from: a */
    public final int m4738a() {
        int streamMinVolume;
        if (Util.SDK_INT >= 28) {
            streamMinVolume = this.f16933d.getStreamMinVolume(this.f16935f);
            return streamMinVolume;
        }
        return 0;
    }

    /* renamed from: c */
    public final void m4739c() {
        boolean z;
        int i = this.f16935f;
        AudioManager audioManager = this.f16933d;
        int m4737b = m4737b(audioManager, i);
        int i2 = this.f16935f;
        if (Util.SDK_INT >= 23) {
            z = audioManager.isStreamMute(i2);
        } else if (m4737b(audioManager, i2) == 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.f16936g != m4737b || this.f16937h != z) {
            this.f16936g = m4737b;
            this.f16937h = z;
            this.f16932c.onStreamVolumeChanged(m4737b, z);
        }
    }
}
