package androidx.media;

import android.media.AudioAttributes;
import android.os.Build;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.media.AudioAttributesImpl;
import androidx.versionedparcelable.VersionedParcelable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import p000.ye0;

/* loaded from: classes.dex */
public class AudioAttributesCompat implements VersionedParcelable {
    public static final int CONTENT_TYPE_MOVIE = 3;
    public static final int CONTENT_TYPE_MUSIC = 2;
    public static final int CONTENT_TYPE_SONIFICATION = 4;
    public static final int CONTENT_TYPE_SPEECH = 1;
    public static final int CONTENT_TYPE_UNKNOWN = 0;
    public static final int FLAG_AUDIBILITY_ENFORCED = 1;
    public static final int FLAG_HW_AV_SYNC = 16;
    public static final int USAGE_ALARM = 4;
    public static final int USAGE_ASSISTANCE_ACCESSIBILITY = 11;
    public static final int USAGE_ASSISTANCE_NAVIGATION_GUIDANCE = 12;
    public static final int USAGE_ASSISTANCE_SONIFICATION = 13;
    public static final int USAGE_ASSISTANT = 16;
    public static final int USAGE_GAME = 14;
    public static final int USAGE_MEDIA = 1;
    public static final int USAGE_NOTIFICATION = 5;
    public static final int USAGE_NOTIFICATION_COMMUNICATION_DELAYED = 9;
    public static final int USAGE_NOTIFICATION_COMMUNICATION_INSTANT = 8;
    public static final int USAGE_NOTIFICATION_COMMUNICATION_REQUEST = 7;
    public static final int USAGE_NOTIFICATION_EVENT = 10;
    public static final int USAGE_NOTIFICATION_RINGTONE = 6;
    public static final int USAGE_UNKNOWN = 0;
    public static final int USAGE_VOICE_COMMUNICATION = 2;
    public static final int USAGE_VOICE_COMMUNICATION_SIGNALLING = 3;

    /* renamed from: a */
    public static boolean f6644a;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public AudioAttributesImpl mImpl;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public @interface AttributeContentType {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public @interface AttributeUsage {
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sparseIntArray.put(5, 1);
        sparseIntArray.put(6, 2);
        sparseIntArray.put(7, 2);
        sparseIntArray.put(8, 1);
        sparseIntArray.put(9, 1);
        sparseIntArray.put(10, 1);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public AudioAttributesCompat() {
    }

    /* renamed from: a */
    public static int m1548a(int i, int i2, boolean z) {
        if ((i & 1) == 1) {
            if (z) {
                return 1;
            }
            return 7;
        }
        if ((i & 4) == 4) {
            if (z) {
                return 0;
            }
            return 6;
        }
        switch (i2) {
            case 0:
            case 1:
            case 12:
            case 14:
            case 16:
                return 3;
            case 2:
                return 0;
            case 3:
                if (z) {
                    return 0;
                }
                return 8;
            case 4:
                return 4;
            case 5:
            case 7:
            case 8:
            case 9:
            case 10:
                return 5;
            case 6:
                return 2;
            case 11:
                return 10;
            case 13:
                return 1;
            case 15:
            default:
                if (!z) {
                    return 3;
                }
                throw new IllegalArgumentException(ye0.m8292l(i2, "Unknown usage value ", " in audio attributes"));
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static void setForceLegacyBehavior(boolean z) {
        f6644a = z;
    }

    @Nullable
    public static AudioAttributesCompat wrap(@NonNull Object obj) {
        if (f6644a) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            return new AudioAttributesCompat(new AudioAttributesImplApi21((AudioAttributes) obj));
        }
        return new AudioAttributesCompat(new AudioAttributesImplApi21((AudioAttributes) obj));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesCompat)) {
            return false;
        }
        AudioAttributesCompat audioAttributesCompat = (AudioAttributesCompat) obj;
        AudioAttributesImpl audioAttributesImpl = this.mImpl;
        if (audioAttributesImpl == null) {
            if (audioAttributesCompat.mImpl != null) {
                return false;
            }
            return true;
        }
        return audioAttributesImpl.equals(audioAttributesCompat.mImpl);
    }

    public int getContentType() {
        return this.mImpl.getContentType();
    }

    public int getFlags() {
        return this.mImpl.getFlags();
    }

    public int getLegacyStreamType() {
        return this.mImpl.getLegacyStreamType();
    }

    public int getUsage() {
        return this.mImpl.getUsage();
    }

    public int getVolumeControlStream() {
        return this.mImpl.getVolumeControlStream();
    }

    public int hashCode() {
        return this.mImpl.hashCode();
    }

    public String toString() {
        return this.mImpl.toString();
    }

    @Nullable
    public Object unwrap() {
        return this.mImpl.getAudioAttributes();
    }

    public AudioAttributesCompat(AudioAttributesImpl audioAttributesImpl) {
        this.mImpl = audioAttributesImpl;
    }

    /* loaded from: classes.dex */
    public static class Builder {

        /* renamed from: a */
        public final AudioAttributesImpl.Builder f6645a;

        /* JADX WARN: Type inference failed for: r0v4, types: [androidx.media.AudioAttributesImpl$Builder, java.lang.Object, androidx.media.c] */
        public Builder() {
            if (AudioAttributesCompat.f6644a) {
                ?? obj = new Object();
                obj.f6687a = 0;
                obj.f6688b = 0;
                obj.f6689c = 0;
                obj.f6690d = -1;
                this.f6645a = obj;
                return;
            }
            if (Build.VERSION.SDK_INT >= 26) {
                this.f6645a = new C0424a();
            } else {
                this.f6645a = new C0424a();
            }
        }

        public AudioAttributesCompat build() {
            return new AudioAttributesCompat(this.f6645a.build());
        }

        public Builder setContentType(int i) {
            this.f6645a.setContentType(i);
            return this;
        }

        public Builder setFlags(int i) {
            this.f6645a.setFlags(i);
            return this;
        }

        public Builder setLegacyStreamType(int i) {
            this.f6645a.setLegacyStreamType(i);
            return this;
        }

        public Builder setUsage(int i) {
            this.f6645a.setUsage(i);
            return this;
        }

        /* JADX WARN: Type inference failed for: r0v4, types: [androidx.media.AudioAttributesImpl$Builder, java.lang.Object, androidx.media.c] */
        public Builder(AudioAttributesCompat audioAttributesCompat) {
            if (AudioAttributesCompat.f6644a) {
                ?? obj = new Object();
                obj.f6687a = 0;
                obj.f6688b = 0;
                obj.f6689c = 0;
                obj.f6690d = -1;
                obj.f6687a = audioAttributesCompat.getUsage();
                obj.f6688b = audioAttributesCompat.getContentType();
                obj.f6689c = audioAttributesCompat.getFlags();
                obj.f6690d = audioAttributesCompat.mImpl.getRawLegacyStreamType();
                this.f6645a = obj;
                return;
            }
            if (Build.VERSION.SDK_INT >= 26) {
                this.f6645a = new C0424a(audioAttributesCompat.unwrap());
            } else {
                this.f6645a = new C0424a(audioAttributesCompat.unwrap());
            }
        }
    }
}
