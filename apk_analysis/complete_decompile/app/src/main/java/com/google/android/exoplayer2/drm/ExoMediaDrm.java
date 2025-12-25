package com.google.android.exoplayer2.drm;

import android.os.PersistableBundle;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.decoder.CryptoConfig;
import com.google.android.exoplayer2.drm.DrmInitData;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes.dex */
public interface ExoMediaDrm {
    public static final int EVENT_KEY_EXPIRED = 3;
    public static final int EVENT_KEY_REQUIRED = 2;
    public static final int EVENT_PROVISION_REQUIRED = 1;
    public static final int KEY_TYPE_OFFLINE = 2;
    public static final int KEY_TYPE_RELEASE = 3;
    public static final int KEY_TYPE_STREAMING = 1;

    /* loaded from: classes.dex */
    public static final class AppManagedProvider implements Provider {

        /* renamed from: a */
        public final ExoMediaDrm f9980a;

        public AppManagedProvider(ExoMediaDrm exoMediaDrm) {
            this.f9980a = exoMediaDrm;
        }

        @Override // com.google.android.exoplayer2.drm.ExoMediaDrm.Provider
        public ExoMediaDrm acquireExoMediaDrm(UUID uuid) {
            ExoMediaDrm exoMediaDrm = this.f9980a;
            exoMediaDrm.acquire();
            return exoMediaDrm;
        }
    }

    /* loaded from: classes.dex */
    public static final class KeyRequest {
        public static final int REQUEST_TYPE_INITIAL = 0;
        public static final int REQUEST_TYPE_NONE = 3;
        public static final int REQUEST_TYPE_RELEASE = 2;
        public static final int REQUEST_TYPE_RENEWAL = 1;
        public static final int REQUEST_TYPE_UNKNOWN = Integer.MIN_VALUE;
        public static final int REQUEST_TYPE_UPDATE = 4;

        /* renamed from: a */
        public final byte[] f9981a;

        /* renamed from: b */
        public final String f9982b;

        /* renamed from: c */
        public final int f9983c;

        @Target({ElementType.TYPE_USE})
        @Documented
        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes.dex */
        public @interface RequestType {
        }

        public KeyRequest(byte[] bArr, String str) {
            this(bArr, str, Integer.MIN_VALUE);
        }

        public byte[] getData() {
            return this.f9981a;
        }

        public String getLicenseServerUrl() {
            return this.f9982b;
        }

        public int getRequestType() {
            return this.f9983c;
        }

        public KeyRequest(byte[] bArr, String str, int i) {
            this.f9981a = bArr;
            this.f9982b = str;
            this.f9983c = i;
        }
    }

    /* loaded from: classes.dex */
    public static final class KeyStatus {

        /* renamed from: a */
        public final int f9984a;

        /* renamed from: b */
        public final byte[] f9985b;

        public KeyStatus(int i, byte[] bArr) {
            this.f9984a = i;
            this.f9985b = bArr;
        }

        public byte[] getKeyId() {
            return this.f9985b;
        }

        public int getStatusCode() {
            return this.f9984a;
        }
    }

    /* loaded from: classes.dex */
    public interface OnEventListener {
        void onEvent(ExoMediaDrm exoMediaDrm, @Nullable byte[] bArr, int i, int i2, @Nullable byte[] bArr2);
    }

    /* loaded from: classes.dex */
    public interface OnExpirationUpdateListener {
        void onExpirationUpdate(ExoMediaDrm exoMediaDrm, byte[] bArr, long j);
    }

    /* loaded from: classes.dex */
    public interface OnKeyStatusChangeListener {
        void onKeyStatusChange(ExoMediaDrm exoMediaDrm, byte[] bArr, List<KeyStatus> list, boolean z);
    }

    /* loaded from: classes.dex */
    public interface Provider {
        ExoMediaDrm acquireExoMediaDrm(UUID uuid);
    }

    /* loaded from: classes.dex */
    public static final class ProvisionRequest {

        /* renamed from: a */
        public final byte[] f9986a;

        /* renamed from: b */
        public final String f9987b;

        public ProvisionRequest(byte[] bArr, String str) {
            this.f9986a = bArr;
            this.f9987b = str;
        }

        public byte[] getData() {
            return this.f9986a;
        }

        public String getDefaultUrl() {
            return this.f9987b;
        }
    }

    void acquire();

    void closeSession(byte[] bArr);

    CryptoConfig createCryptoConfig(byte[] bArr);

    int getCryptoType();

    KeyRequest getKeyRequest(byte[] bArr, @Nullable List<DrmInitData.SchemeData> list, int i, @Nullable HashMap<String, String> hashMap);

    @Nullable
    PersistableBundle getMetrics();

    byte[] getPropertyByteArray(String str);

    String getPropertyString(String str);

    ProvisionRequest getProvisionRequest();

    byte[] openSession();

    @Nullable
    byte[] provideKeyResponse(byte[] bArr, byte[] bArr2);

    void provideProvisionResponse(byte[] bArr);

    Map<String, String> queryKeyStatus(byte[] bArr);

    void release();

    boolean requiresSecureDecoder(byte[] bArr, String str);

    void restoreKeys(byte[] bArr, byte[] bArr2);

    void setOnEventListener(@Nullable OnEventListener onEventListener);

    void setOnExpirationUpdateListener(@Nullable OnExpirationUpdateListener onExpirationUpdateListener);

    void setOnKeyStatusChangeListener(@Nullable OnKeyStatusChangeListener onKeyStatusChangeListener);

    void setPlayerIdForSession(byte[] bArr, PlayerId playerId);

    void setPropertyByteArray(String str, byte[] bArr);

    void setPropertyString(String str, String str2);
}
