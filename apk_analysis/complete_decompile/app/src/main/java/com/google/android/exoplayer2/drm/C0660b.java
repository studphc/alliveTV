package com.google.android.exoplayer2.drm;

import android.media.NotProvisionedException;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Pair;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.decoder.CryptoConfig;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.ExoMediaDrm;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.CopyOnWriteMultiset;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import p000.m00;
import p000.n00;

/* renamed from: com.google.android.exoplayer2.drm.b */
/* loaded from: classes.dex */
public final class C0660b implements DrmSession {

    /* renamed from: a */
    public final List f10003a;

    /* renamed from: b */
    public final ExoMediaDrm f10004b;

    /* renamed from: c */
    public final DefaultDrmSession$ProvisioningManager f10005c;

    /* renamed from: d */
    public final DefaultDrmSession$ReferenceCountListener f10006d;

    /* renamed from: e */
    public final int f10007e;

    /* renamed from: f */
    public final boolean f10008f;

    /* renamed from: g */
    public final boolean f10009g;

    /* renamed from: h */
    public final HashMap f10010h;

    /* renamed from: i */
    public final CopyOnWriteMultiset f10011i;

    /* renamed from: j */
    public final LoadErrorHandlingPolicy f10012j;

    /* renamed from: k */
    public final PlayerId f10013k;

    /* renamed from: l */
    public final MediaDrmCallback f10014l;

    /* renamed from: m */
    public final UUID f10015m;

    /* renamed from: n */
    public final n00 f10016n;

    /* renamed from: o */
    public int f10017o;

    /* renamed from: p */
    public int f10018p;

    /* renamed from: q */
    public HandlerThread f10019q;

    /* renamed from: r */
    public HandlerC0659a f10020r;

    /* renamed from: s */
    public CryptoConfig f10021s;

    /* renamed from: t */
    public DrmSession.DrmSessionException f10022t;

    /* renamed from: u */
    public byte[] f10023u;

    /* renamed from: v */
    public byte[] f10024v;

    /* renamed from: w */
    public ExoMediaDrm.KeyRequest f10025w;

    /* renamed from: x */
    public ExoMediaDrm.ProvisionRequest f10026x;

    public C0660b(UUID uuid, ExoMediaDrm exoMediaDrm, DefaultDrmSession$ProvisioningManager defaultDrmSession$ProvisioningManager, DefaultDrmSession$ReferenceCountListener defaultDrmSession$ReferenceCountListener, List list, int i, boolean z, boolean z2, byte[] bArr, HashMap hashMap, MediaDrmCallback mediaDrmCallback, Looper looper, LoadErrorHandlingPolicy loadErrorHandlingPolicy, PlayerId playerId) {
        if (i == 1 || i == 3) {
            Assertions.checkNotNull(bArr);
        }
        this.f10015m = uuid;
        this.f10005c = defaultDrmSession$ProvisioningManager;
        this.f10006d = defaultDrmSession$ReferenceCountListener;
        this.f10004b = exoMediaDrm;
        this.f10007e = i;
        this.f10008f = z;
        this.f10009g = z2;
        if (bArr != null) {
            this.f10024v = bArr;
            this.f10003a = null;
        } else {
            this.f10003a = Collections.unmodifiableList((List) Assertions.checkNotNull(list));
        }
        this.f10010h = hashMap;
        this.f10014l = mediaDrmCallback;
        this.f10011i = new CopyOnWriteMultiset();
        this.f10012j = loadErrorHandlingPolicy;
        this.f10013k = playerId;
        this.f10017o = 2;
        this.f10016n = new n00(this, looper);
    }

    /* renamed from: a */
    public final void m2522a(boolean z) {
        long min;
        if (this.f10009g) {
            return;
        }
        byte[] bArr = (byte[]) Util.castNonNull(this.f10023u);
        ExoMediaDrm exoMediaDrm = this.f10004b;
        int i = this.f10007e;
        if (i != 0 && i != 1) {
            if (i != 2) {
                if (i == 3) {
                    Assertions.checkNotNull(this.f10024v);
                    Assertions.checkNotNull(this.f10023u);
                    m2527f(this.f10024v, 3, z);
                    return;
                }
                return;
            }
            byte[] bArr2 = this.f10024v;
            if (bArr2 != null) {
                try {
                    exoMediaDrm.restoreKeys(this.f10023u, bArr2);
                } catch (Exception e) {
                    m2524c(1, e);
                    return;
                }
            }
            m2527f(bArr, 2, z);
            return;
        }
        byte[] bArr3 = this.f10024v;
        if (bArr3 == null) {
            m2527f(bArr, 1, z);
            return;
        }
        if (this.f10017o != 4) {
            try {
                exoMediaDrm.restoreKeys(this.f10023u, bArr3);
            } catch (Exception e2) {
                m2524c(1, e2);
                return;
            }
        }
        if (!C0643C.WIDEVINE_UUID.equals(this.f10015m)) {
            min = Long.MAX_VALUE;
        } else {
            Pair pair = (Pair) Assertions.checkNotNull(WidevineUtil.getLicenseDurationRemainingSec(this));
            min = Math.min(((Long) pair.first).longValue(), ((Long) pair.second).longValue());
        }
        if (i == 0 && min <= 60) {
            Log.m3021d("DefaultDrmSession", "Offline license has expired or will expire soon. Remaining seconds: " + min);
            m2527f(bArr, 2, z);
            return;
        }
        if (min <= 0) {
            m2524c(2, new KeysExpiredException());
            return;
        }
        this.f10017o = 4;
        Iterator it = this.f10011i.elementSet().iterator();
        while (it.hasNext()) {
            ((DrmSessionEventListener.EventDispatcher) it.next()).drmKeysRestored();
        }
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public final void acquire(DrmSessionEventListener.EventDispatcher eventDispatcher) {
        boolean z = false;
        if (this.f10018p < 0) {
            Log.m3023e("DefaultDrmSession", "Session reference count less than zero: " + this.f10018p);
            this.f10018p = 0;
        }
        CopyOnWriteMultiset copyOnWriteMultiset = this.f10011i;
        if (eventDispatcher != null) {
            copyOnWriteMultiset.add(eventDispatcher);
        }
        int i = this.f10018p + 1;
        this.f10018p = i;
        if (i == 1) {
            if (this.f10017o == 2) {
                z = true;
            }
            Assertions.checkState(z);
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:DrmRequestHandler");
            this.f10019q = handlerThread;
            handlerThread.start();
            this.f10020r = new HandlerC0659a(this, this.f10019q.getLooper());
            if (m2526e()) {
                m2522a(true);
            }
        } else if (eventDispatcher != null && m2523b() && copyOnWriteMultiset.count(eventDispatcher) == 1) {
            eventDispatcher.drmSessionAcquired(this.f10017o);
        }
        this.f10006d.onReferenceCountIncremented(this, this.f10018p);
    }

    /* renamed from: b */
    public final boolean m2523b() {
        int i = this.f10017o;
        if (i != 3 && i != 4) {
            return false;
        }
        return true;
    }

    /* renamed from: c */
    public final void m2524c(int i, Exception exc) {
        this.f10022t = new DrmSession.DrmSessionException(exc, DrmUtil.getErrorCodeForMediaDrmException(exc, i));
        Log.m3024e("DefaultDrmSession", "DRM session error", exc);
        Iterator it = this.f10011i.elementSet().iterator();
        while (it.hasNext()) {
            ((DrmSessionEventListener.EventDispatcher) it.next()).drmSessionManagerError(exc);
        }
        if (this.f10017o != 4) {
            this.f10017o = 1;
        }
    }

    /* renamed from: d */
    public final void m2525d(Exception exc, boolean z) {
        int i;
        if (exc instanceof NotProvisionedException) {
            this.f10005c.provisionRequired(this);
            return;
        }
        if (z) {
            i = 1;
        } else {
            i = 2;
        }
        m2524c(i, exc);
    }

    /* renamed from: e */
    public final boolean m2526e() {
        ExoMediaDrm exoMediaDrm = this.f10004b;
        if (m2523b()) {
            return true;
        }
        try {
            byte[] openSession = exoMediaDrm.openSession();
            this.f10023u = openSession;
            exoMediaDrm.setPlayerIdForSession(openSession, this.f10013k);
            this.f10021s = exoMediaDrm.createCryptoConfig(this.f10023u);
            this.f10017o = 3;
            Iterator it = this.f10011i.elementSet().iterator();
            while (it.hasNext()) {
                ((DrmSessionEventListener.EventDispatcher) it.next()).drmSessionAcquired(3);
            }
            Assertions.checkNotNull(this.f10023u);
            return true;
        } catch (NotProvisionedException unused) {
            this.f10005c.provisionRequired(this);
            return false;
        } catch (Exception e) {
            m2524c(1, e);
            return false;
        }
    }

    /* renamed from: f */
    public final void m2527f(byte[] bArr, int i, boolean z) {
        try {
            this.f10025w = this.f10004b.getKeyRequest(bArr, this.f10003a, i, this.f10010h);
            HandlerC0659a handlerC0659a = (HandlerC0659a) Util.castNonNull(this.f10020r);
            Object checkNotNull = Assertions.checkNotNull(this.f10025w);
            handlerC0659a.getClass();
            handlerC0659a.obtainMessage(1, new m00(LoadEventInfo.getNewId(), z, SystemClock.elapsedRealtime(), checkNotNull)).sendToTarget();
        } catch (Exception e) {
            m2525d(e, true);
        }
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public final CryptoConfig getCryptoConfig() {
        return this.f10021s;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public final DrmSession.DrmSessionException getError() {
        if (this.f10017o == 1) {
            return this.f10022t;
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public final byte[] getOfflineLicenseKeySetId() {
        return this.f10024v;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public final UUID getSchemeUuid() {
        return this.f10015m;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public final int getState() {
        return this.f10017o;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public final boolean playClearSamplesWithoutKeys() {
        return this.f10008f;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public final Map queryKeyStatus() {
        byte[] bArr = this.f10023u;
        if (bArr == null) {
            return null;
        }
        return this.f10004b.queryKeyStatus(bArr);
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public final void release(DrmSessionEventListener.EventDispatcher eventDispatcher) {
        int i = this.f10018p;
        if (i <= 0) {
            Log.m3023e("DefaultDrmSession", "release() called on a session that's already fully released.");
            return;
        }
        int i2 = i - 1;
        this.f10018p = i2;
        if (i2 == 0) {
            this.f10017o = 0;
            ((n00) Util.castNonNull(this.f10016n)).removeCallbacksAndMessages(null);
            HandlerC0659a handlerC0659a = (HandlerC0659a) Util.castNonNull(this.f10020r);
            synchronized (handlerC0659a) {
                handlerC0659a.removeCallbacksAndMessages(null);
                handlerC0659a.f10001a = true;
            }
            this.f10020r = null;
            ((HandlerThread) Util.castNonNull(this.f10019q)).quit();
            this.f10019q = null;
            this.f10021s = null;
            this.f10022t = null;
            this.f10025w = null;
            this.f10026x = null;
            byte[] bArr = this.f10023u;
            if (bArr != null) {
                this.f10004b.closeSession(bArr);
                this.f10023u = null;
            }
        }
        if (eventDispatcher != null) {
            this.f10011i.remove(eventDispatcher);
            if (this.f10011i.count(eventDispatcher) == 0) {
                eventDispatcher.drmSessionReleased();
            }
        }
        this.f10006d.onReferenceCountDecremented(this, this.f10018p);
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public final boolean requiresSecureDecoder(String str) {
        return this.f10004b.requiresSecureDecoder((byte[]) Assertions.checkStateNotNull(this.f10023u), str);
    }
}
