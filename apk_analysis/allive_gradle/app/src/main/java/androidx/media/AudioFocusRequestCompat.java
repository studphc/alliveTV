package androidx.media;

import android.media.AudioAttributes;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.core.util.ObjectsCompat;
import androidx.media.AudioAttributesCompat;
import p000.AbstractC0553bd;
import p000.C0589cd;
import p000.ye0;

/* loaded from: classes.dex */
public class AudioFocusRequestCompat {

    /* renamed from: g */
    public static final AudioAttributesCompat f6646g = new AudioAttributesCompat.Builder().setUsage(1).build();

    /* renamed from: a */
    public final int f6647a;

    /* renamed from: b */
    public final AudioManager.OnAudioFocusChangeListener f6648b;

    /* renamed from: c */
    public final Handler f6649c;

    /* renamed from: d */
    public final AudioAttributesCompat f6650d;

    /* renamed from: e */
    public final boolean f6651e;

    /* renamed from: f */
    public final Object f6652f;

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a */
        public int f6653a;

        /* renamed from: b */
        public AudioManager.OnAudioFocusChangeListener f6654b;

        /* renamed from: c */
        public Handler f6655c;

        /* renamed from: d */
        public AudioAttributesCompat f6656d;

        /* renamed from: e */
        public boolean f6657e;

        public Builder(int i) {
            this.f6656d = AudioFocusRequestCompat.f6646g;
            setFocusGain(i);
        }

        public AudioFocusRequestCompat build() {
            if (this.f6654b != null) {
                return new AudioFocusRequestCompat(this.f6653a, this.f6654b, this.f6655c, this.f6656d, this.f6657e);
            }
            throw new IllegalStateException("Can't build an AudioFocusRequestCompat instance without a listener");
        }

        @NonNull
        public Builder setAudioAttributes(@NonNull AudioAttributesCompat audioAttributesCompat) {
            if (audioAttributesCompat != null) {
                this.f6656d = audioAttributesCompat;
                return this;
            }
            throw new NullPointerException("Illegal null AudioAttributes");
        }

        @NonNull
        public Builder setFocusGain(int i) {
            if (i != 1 && i != 2 && i != 3 && i != 4) {
                throw new IllegalArgumentException(ye0.m8291k(i, "Illegal audio focus gain type "));
            }
            this.f6653a = i;
            return this;
        }

        @NonNull
        public Builder setOnAudioFocusChangeListener(@NonNull AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener) {
            return setOnAudioFocusChangeListener(onAudioFocusChangeListener, new Handler(Looper.getMainLooper()));
        }

        @NonNull
        public Builder setWillPauseWhenDucked(boolean z) {
            this.f6657e = z;
            return this;
        }

        @NonNull
        public Builder setOnAudioFocusChangeListener(@NonNull AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener, @NonNull Handler handler) {
            if (onAudioFocusChangeListener == null) {
                throw new IllegalArgumentException("OnAudioFocusChangeListener must not be null");
            }
            if (handler != null) {
                this.f6654b = onAudioFocusChangeListener;
                this.f6655c = handler;
                return this;
            }
            throw new IllegalArgumentException("Handler must not be null");
        }

        public Builder(@NonNull AudioFocusRequestCompat audioFocusRequestCompat) {
            this.f6656d = AudioFocusRequestCompat.f6646g;
            if (audioFocusRequestCompat != null) {
                this.f6653a = audioFocusRequestCompat.getFocusGain();
                this.f6654b = audioFocusRequestCompat.getOnAudioFocusChangeListener();
                this.f6655c = audioFocusRequestCompat.getFocusChangeHandler();
                this.f6656d = audioFocusRequestCompat.getAudioAttributesCompat();
                this.f6657e = audioFocusRequestCompat.willPauseWhenDucked();
                return;
            }
            throw new IllegalArgumentException("AudioFocusRequestCompat to copy must not be null");
        }
    }

    public AudioFocusRequestCompat(int i, AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener, Handler handler, AudioAttributesCompat audioAttributesCompat, boolean z) {
        this.f6647a = i;
        this.f6649c = handler;
        this.f6650d = audioAttributesCompat;
        this.f6651e = z;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 26 && handler.getLooper() != Looper.getMainLooper()) {
            this.f6648b = new C0589cd(onAudioFocusChangeListener, handler);
        } else {
            this.f6648b = onAudioFocusChangeListener;
        }
        if (i2 >= 26) {
            this.f6652f = AbstractC0553bd.m2084a(i, audioAttributesCompat != null ? (AudioAttributes) audioAttributesCompat.unwrap() : null, z, this.f6648b, handler);
        } else {
            this.f6652f = null;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AudioFocusRequestCompat)) {
            return false;
        }
        AudioFocusRequestCompat audioFocusRequestCompat = (AudioFocusRequestCompat) obj;
        if (this.f6647a == audioFocusRequestCompat.f6647a && this.f6651e == audioFocusRequestCompat.f6651e && ObjectsCompat.equals(this.f6648b, audioFocusRequestCompat.f6648b) && ObjectsCompat.equals(this.f6649c, audioFocusRequestCompat.f6649c) && ObjectsCompat.equals(this.f6650d, audioFocusRequestCompat.f6650d)) {
            return true;
        }
        return false;
    }

    @NonNull
    public AudioAttributesCompat getAudioAttributesCompat() {
        return this.f6650d;
    }

    @NonNull
    public Handler getFocusChangeHandler() {
        return this.f6649c;
    }

    public int getFocusGain() {
        return this.f6647a;
    }

    @NonNull
    public AudioManager.OnAudioFocusChangeListener getOnAudioFocusChangeListener() {
        return this.f6648b;
    }

    public int hashCode() {
        return ObjectsCompat.hash(Integer.valueOf(this.f6647a), this.f6648b, this.f6649c, this.f6650d, Boolean.valueOf(this.f6651e));
    }

    public boolean willPauseWhenDucked() {
        return this.f6651e;
    }
}
