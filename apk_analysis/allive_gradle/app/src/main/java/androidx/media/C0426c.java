package androidx.media;

import android.util.Log;
import androidx.media.AudioAttributesImpl;
import com.google.android.exoplayer2.analytics.AnalyticsListener;

/* renamed from: androidx.media.c */
/* loaded from: classes.dex */
public final class C0426c implements AudioAttributesImpl.Builder {

    /* renamed from: a */
    public int f6687a;

    /* renamed from: b */
    public int f6688b;

    /* renamed from: c */
    public int f6689c;

    /* renamed from: d */
    public int f6690d;

    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.media.AudioAttributesImplBase, androidx.media.AudioAttributesImpl, java.lang.Object] */
    @Override // androidx.media.AudioAttributesImpl.Builder
    public final AudioAttributesImpl build() {
        int i = this.f6688b;
        int i2 = this.f6689c;
        int i3 = this.f6687a;
        int i4 = this.f6690d;
        ?? obj = new Object();
        obj.mContentType = i;
        obj.mFlags = i2;
        obj.mUsage = i3;
        obj.mLegacyStream = i4;
        return obj;
    }

    @Override // androidx.media.AudioAttributesImpl.Builder
    public final AudioAttributesImpl.Builder setContentType(int i) {
        if (i != 0 && i != 1 && i != 2 && i != 3 && i != 4) {
            this.f6688b = 0;
        } else {
            this.f6688b = i;
        }
        return this;
    }

    @Override // androidx.media.AudioAttributesImpl.Builder
    public final AudioAttributesImpl.Builder setFlags(int i) {
        this.f6689c = (i & AnalyticsListener.EVENT_DRM_KEYS_LOADED) | this.f6689c;
        return this;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // androidx.media.AudioAttributesImpl.Builder
    public final AudioAttributesImpl.Builder setLegacyStreamType(int i) {
        if (i != 10) {
            this.f6690d = i;
            int i2 = 2;
            switch (i) {
                case 0:
                    this.f6688b = 1;
                    break;
                case 1:
                    this.f6688b = 4;
                    break;
                case 2:
                    this.f6688b = 4;
                    break;
                case 3:
                    this.f6688b = 2;
                    break;
                case 4:
                    this.f6688b = 4;
                    break;
                case 5:
                    this.f6688b = 4;
                    break;
                case 6:
                    this.f6688b = 1;
                    this.f6689c |= 4;
                    break;
                case 7:
                    this.f6689c |= 1;
                    this.f6688b = 4;
                    break;
                case 8:
                    this.f6688b = 4;
                    break;
                case 9:
                    this.f6688b = 4;
                    break;
                case 10:
                    this.f6688b = 1;
                    break;
                default:
                    Log.e("AudioAttributesCompat", "Invalid stream type " + i + " for AudioAttributesCompat");
                    break;
            }
            switch (i) {
                case 0:
                case 6:
                    break;
                case 1:
                case 7:
                    i2 = 13;
                    break;
                case 2:
                    i2 = 6;
                    break;
                case 3:
                    i2 = 1;
                    break;
                case 4:
                    i2 = 4;
                    break;
                case 5:
                    i2 = 5;
                    break;
                case 8:
                    i2 = 3;
                    break;
                case 9:
                default:
                    i2 = 0;
                    break;
                case 10:
                    i2 = 11;
                    break;
            }
            this.f6687a = i2;
            return this;
        }
        throw new IllegalArgumentException("STREAM_ACCESSIBILITY is not a legacy stream type that was used for audio playback");
    }

    @Override // androidx.media.AudioAttributesImpl.Builder
    public final AudioAttributesImpl.Builder setUsage(int i) {
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                this.f6687a = i;
                return this;
            case 16:
                this.f6687a = 12;
                return this;
            default:
                this.f6687a = 0;
                return this;
        }
    }
}
