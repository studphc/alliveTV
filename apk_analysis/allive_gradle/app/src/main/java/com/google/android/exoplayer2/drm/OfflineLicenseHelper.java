package com.google.android.exoplayer2.drm;

import android.os.ConditionVariable;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.ExoMediaDrm;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Map;
import java.util.UUID;

@RequiresApi(18)
/* loaded from: classes.dex */
public final class OfflineLicenseHelper {

    /* renamed from: e */
    public static final Format f9996e = new Format.Builder().setDrmInitData(new DrmInitData(new DrmInitData.SchemeData[0])).build();

    /* renamed from: a */
    public final ConditionVariable f9997a;

    /* renamed from: b */
    public final DefaultDrmSessionManager f9998b;

    /* renamed from: c */
    public final HandlerThread f9999c;

    /* renamed from: d */
    public final DrmSessionEventListener.EventDispatcher f10000d;

    @Deprecated
    public OfflineLicenseHelper(UUID uuid, ExoMediaDrm.Provider provider, MediaDrmCallback mediaDrmCallback, @Nullable Map<String, String> map, DrmSessionEventListener.EventDispatcher eventDispatcher) {
        this(new DefaultDrmSessionManager.Builder().setUuidAndExoMediaDrmProvider(uuid, provider).setKeyRequestParameters(map).build(mediaDrmCallback), eventDispatcher);
    }

    public static OfflineLicenseHelper newWidevineInstance(String str, DataSource.Factory factory, DrmSessionEventListener.EventDispatcher eventDispatcher) {
        return newWidevineInstance(str, false, factory, eventDispatcher);
    }

    /* renamed from: a */
    public final byte[] m2519a(int i, byte[] bArr, Format format) {
        Looper looper = this.f9999c.getLooper();
        PlayerId playerId = PlayerId.UNSET;
        DefaultDrmSessionManager defaultDrmSessionManager = this.f9998b;
        defaultDrmSessionManager.setPlayer(looper, playerId);
        defaultDrmSessionManager.prepare();
        DrmSession m2520b = m2520b(i, bArr, format);
        DrmSession.DrmSessionException error = m2520b.getError();
        byte[] offlineLicenseKeySetId = m2520b.getOfflineLicenseKeySetId();
        m2520b.release(this.f10000d);
        defaultDrmSessionManager.release();
        if (error == null) {
            return (byte[]) Assertions.checkNotNull(offlineLicenseKeySetId);
        }
        throw error;
    }

    /* renamed from: b */
    public final DrmSession m2520b(int i, byte[] bArr, Format format) {
        Assertions.checkNotNull(format.drmInitData);
        DefaultDrmSessionManager defaultDrmSessionManager = this.f9998b;
        defaultDrmSessionManager.setMode(i, bArr);
        ConditionVariable conditionVariable = this.f9997a;
        conditionVariable.close();
        DrmSession acquireSession = defaultDrmSessionManager.acquireSession(this.f10000d, format);
        conditionVariable.block();
        return (DrmSession) Assertions.checkNotNull(acquireSession);
    }

    public synchronized byte[] downloadLicense(Format format) {
        boolean z;
        if (format.drmInitData != null) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkArgument(z);
        return m2519a(2, null, format);
    }

    public synchronized Pair<Long, Long> getLicenseDurationRemainingSec(byte[] bArr) {
        Assertions.checkNotNull(bArr);
        this.f9998b.setPlayer(this.f9999c.getLooper(), PlayerId.UNSET);
        this.f9998b.prepare();
        DrmSession m2520b = m2520b(1, bArr, f9996e);
        DrmSession.DrmSessionException error = m2520b.getError();
        Pair<Long, Long> licenseDurationRemainingSec = WidevineUtil.getLicenseDurationRemainingSec(m2520b);
        m2520b.release(this.f10000d);
        this.f9998b.release();
        if (error != null) {
            if (error.getCause() instanceof KeysExpiredException) {
                return Pair.create(0L, 0L);
            }
            throw error;
        }
        return (Pair) Assertions.checkNotNull(licenseDurationRemainingSec);
    }

    public void release() {
        this.f9999c.quit();
    }

    public synchronized void releaseLicense(byte[] bArr) {
        Assertions.checkNotNull(bArr);
        m2519a(3, bArr, f9996e);
    }

    public synchronized byte[] renewLicense(byte[] bArr) {
        Assertions.checkNotNull(bArr);
        return m2519a(2, bArr, f9996e);
    }

    public static OfflineLicenseHelper newWidevineInstance(String str, boolean z, DataSource.Factory factory, DrmSessionEventListener.EventDispatcher eventDispatcher) {
        return newWidevineInstance(str, z, factory, null, eventDispatcher);
    }

    public static OfflineLicenseHelper newWidevineInstance(String str, boolean z, DataSource.Factory factory, @Nullable Map<String, String> map, DrmSessionEventListener.EventDispatcher eventDispatcher) {
        return new OfflineLicenseHelper(new DefaultDrmSessionManager.Builder().setKeyRequestParameters(map).build(new HttpMediaDrmCallback(str, z, factory)), eventDispatcher);
    }

    public OfflineLicenseHelper(DefaultDrmSessionManager defaultDrmSessionManager, DrmSessionEventListener.EventDispatcher eventDispatcher) {
        this.f9998b = defaultDrmSessionManager;
        this.f10000d = eventDispatcher;
        HandlerThread handlerThread = new HandlerThread("ExoPlayer:OfflineLicenseHelper");
        this.f9999c = handlerThread;
        handlerThread.start();
        this.f9997a = new ConditionVariable();
        eventDispatcher.addEventListener(new Handler(handlerThread.getLooper()), new C0667i(this));
    }
}
