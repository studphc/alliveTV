package com.google.android.exoplayer2.audio;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.provider.Settings;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import p000.C1150e9;
import p000.C1978xc;

/* loaded from: classes.dex */
public final class AudioCapabilitiesReceiver {

    /* renamed from: a */
    public final Context f9647a;

    /* renamed from: b */
    public final Listener f9648b;

    /* renamed from: c */
    public final Handler f9649c;

    /* renamed from: d */
    public final C1150e9 f9650d;

    /* renamed from: e */
    public final C1978xc f9651e;

    /* renamed from: f */
    public AudioCapabilities f9652f;

    /* renamed from: g */
    public boolean f9653g;

    /* loaded from: classes.dex */
    public interface Listener {
        void onAudioCapabilitiesChanged(AudioCapabilities audioCapabilities);
    }

    public AudioCapabilitiesReceiver(Context context, Listener listener) {
        C1150e9 c1150e9;
        Uri uri;
        Context applicationContext = context.getApplicationContext();
        this.f9647a = applicationContext;
        this.f9648b = (Listener) Assertions.checkNotNull(listener);
        Handler createHandlerForCurrentOrMainLooper = Util.createHandlerForCurrentOrMainLooper();
        this.f9649c = createHandlerForCurrentOrMainLooper;
        if (Util.SDK_INT >= 21) {
            c1150e9 = new C1150e9(1, this);
        } else {
            c1150e9 = null;
        }
        this.f9650d = c1150e9;
        if (AudioCapabilities.m2445a()) {
            uri = Settings.Global.getUriFor("external_surround_sound_enabled");
        } else {
            uri = null;
        }
        this.f9651e = uri != null ? new C1978xc(this, createHandlerForCurrentOrMainLooper, applicationContext.getContentResolver(), uri) : null;
    }

    public AudioCapabilities register() {
        if (this.f9653g) {
            return (AudioCapabilities) Assertions.checkNotNull(this.f9652f);
        }
        this.f9653g = true;
        C1978xc c1978xc = this.f9651e;
        if (c1978xc != null) {
            c1978xc.f28503a.registerContentObserver(c1978xc.f28504b, false, c1978xc);
        }
        C1150e9 c1150e9 = this.f9650d;
        Context context = this.f9647a;
        Intent intent = null;
        if (c1150e9 != null) {
            intent = context.registerReceiver(c1150e9, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG"), null, this.f9649c);
        }
        AudioCapabilities m2446b = AudioCapabilities.m2446b(context, intent);
        this.f9652f = m2446b;
        return m2446b;
    }

    public void unregister() {
        if (!this.f9653g) {
            return;
        }
        this.f9652f = null;
        C1150e9 c1150e9 = this.f9650d;
        if (c1150e9 != null) {
            this.f9647a.unregisterReceiver(c1150e9);
        }
        C1978xc c1978xc = this.f9651e;
        if (c1978xc != null) {
            c1978xc.f28503a.unregisterContentObserver(c1978xc);
        }
        this.f9653g = false;
    }
}
