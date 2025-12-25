package p000;

import android.content.Context;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Handler;
import com.google.android.exoplayer2.SurfaceHolderCallbackC0644a;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;

/* renamed from: ad */
/* loaded from: classes.dex */
public final class C0014ad {

    /* renamed from: a */
    public final AudioManager f126a;

    /* renamed from: b */
    public final C2052zc f127b;

    /* renamed from: c */
    public SurfaceHolderCallbackC0644a f128c;

    /* renamed from: d */
    public AudioAttributes f129d;

    /* renamed from: f */
    public int f131f;

    /* renamed from: h */
    public AudioFocusRequest f133h;

    /* renamed from: g */
    public float f132g = 1.0f;

    /* renamed from: e */
    public int f130e = 0;

    public C0014ad(Context context, Handler handler, SurfaceHolderCallbackC0644a surfaceHolderCallbackC0644a) {
        this.f126a = (AudioManager) Assertions.checkNotNull((AudioManager) context.getApplicationContext().getSystemService(MimeTypes.BASE_TYPE_AUDIO));
        this.f128c = surfaceHolderCallbackC0644a;
        this.f127b = new C2052zc(this, handler);
    }

    /* renamed from: a */
    public final void m63a() {
        if (this.f130e == 0) {
            return;
        }
        int i = Util.SDK_INT;
        AudioManager audioManager = this.f126a;
        if (i >= 26) {
            AudioFocusRequest audioFocusRequest = this.f133h;
            if (audioFocusRequest != null) {
                audioManager.abandonAudioFocusRequest(audioFocusRequest);
            }
        } else {
            audioManager.abandonAudioFocus(this.f127b);
        }
        m65c(0);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0039, code lost:
    
        if (r7.contentType == 1) goto L13;
     */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m64b(AudioAttributes audioAttributes) {
        int i;
        if (!Util.areEqual(this.f129d, audioAttributes)) {
            this.f129d = audioAttributes;
            boolean z = false;
            if (audioAttributes != null) {
                i = 3;
                switch (audioAttributes.usage) {
                    case 0:
                        Log.m3027w("AudioFocusManager", "Specify a proper usage in the audio attributes for audio focus handling. Using AUDIOFOCUS_GAIN by default.");
                        i = 1;
                        break;
                    case 1:
                    case 14:
                        i = 1;
                        break;
                    case 2:
                    case 4:
                        i = 2;
                        break;
                    case 3:
                        break;
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 13:
                        break;
                    case 11:
                        break;
                    case 15:
                    default:
                        Log.m3027w("AudioFocusManager", "Unidentified audio usage: " + audioAttributes.usage);
                        break;
                    case 16:
                        if (Util.SDK_INT >= 19) {
                            i = 4;
                            break;
                        }
                        i = 2;
                        break;
                }
                this.f131f = i;
                if (i != 1 || i == 0) {
                    z = true;
                }
                Assertions.checkArgument(z, "Automatic handling of audio focus is only available for USAGE_MEDIA and USAGE_GAME.");
            }
            i = 0;
            this.f131f = i;
            if (i != 1) {
            }
            z = true;
            Assertions.checkArgument(z, "Automatic handling of audio focus is only available for USAGE_MEDIA and USAGE_GAME.");
        }
    }

    /* renamed from: c */
    public final void m65c(int i) {
        float f;
        if (this.f130e == i) {
            return;
        }
        this.f130e = i;
        if (i == 3) {
            f = 0.2f;
        } else {
            f = 1.0f;
        }
        if (this.f132g == f) {
            return;
        }
        this.f132g = f;
        SurfaceHolderCallbackC0644a surfaceHolderCallbackC0644a = this.f128c;
        if (surfaceHolderCallbackC0644a != null) {
            surfaceHolderCallbackC0644a.setVolumeMultiplier(f);
        }
    }

    /* renamed from: d */
    public final int m66d(int i, boolean z) {
        int requestAudioFocus;
        AudioFocusRequest.Builder m6291o;
        boolean z2;
        AudioFocusRequest.Builder audioAttributes;
        AudioFocusRequest.Builder willPauseWhenDucked;
        AudioFocusRequest.Builder onAudioFocusChangeListener;
        AudioFocusRequest build;
        int i2 = 1;
        if (i != 1 && this.f131f == 1) {
            if (!z) {
                return -1;
            }
            if (this.f130e != 1) {
                int i3 = Util.SDK_INT;
                AudioManager audioManager = this.f126a;
                C2052zc c2052zc = this.f127b;
                if (i3 >= 26) {
                    AudioFocusRequest audioFocusRequest = this.f133h;
                    if (audioFocusRequest == null) {
                        if (audioFocusRequest == null) {
                            AbstractC1571n3.m6299w();
                            m6291o = AbstractC1571n3.m6287k(this.f131f);
                        } else {
                            AbstractC1571n3.m6299w();
                            m6291o = AbstractC1571n3.m6291o(this.f133h);
                        }
                        AudioAttributes audioAttributes2 = this.f129d;
                        if (audioAttributes2 != null && audioAttributes2.contentType == 1) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        audioAttributes = m6291o.setAudioAttributes(((AudioAttributes) Assertions.checkNotNull(audioAttributes2)).getAudioAttributesV21().audioAttributes);
                        willPauseWhenDucked = audioAttributes.setWillPauseWhenDucked(z2);
                        onAudioFocusChangeListener = willPauseWhenDucked.setOnAudioFocusChangeListener(c2052zc);
                        build = onAudioFocusChangeListener.build();
                        this.f133h = build;
                    }
                    requestAudioFocus = audioManager.requestAudioFocus(this.f133h);
                } else {
                    requestAudioFocus = audioManager.requestAudioFocus(c2052zc, Util.getStreamTypeForAudioUsage(((AudioAttributes) Assertions.checkNotNull(this.f129d)).usage), this.f131f);
                }
                if (requestAudioFocus == 1) {
                    m65c(1);
                } else {
                    m65c(0);
                    i2 = -1;
                }
            }
            return i2;
        }
        m63a();
        if (z) {
            return 1;
        }
        return -1;
    }
}
