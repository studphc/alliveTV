package com.google.android.exoplayer2.drm;

import android.media.ResourceBusyException;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.ExoMediaDrm;
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import p000.C1540m9;
import p000.RunnableC0583c7;
import p000.o00;

@RequiresApi(18)
/* loaded from: classes.dex */
public class DefaultDrmSessionManager implements DrmSessionManager {
    public static final long DEFAULT_SESSION_KEEPALIVE_MS = 300000;
    public static final int INITIAL_DRM_REQUEST_RETRY_COUNT = 3;
    public static final int MODE_DOWNLOAD = 2;
    public static final int MODE_PLAYBACK = 0;
    public static final int MODE_QUERY = 1;
    public static final int MODE_RELEASE = 3;
    public static final String PLAYREADY_CUSTOM_DATA_KEY = "PRCustomData";

    /* renamed from: a */
    public final UUID f9938a;

    /* renamed from: b */
    public final ExoMediaDrm.Provider f9939b;

    /* renamed from: c */
    public final MediaDrmCallback f9940c;

    /* renamed from: d */
    public final HashMap f9941d;

    /* renamed from: e */
    public final boolean f9942e;

    /* renamed from: f */
    public final int[] f9943f;

    /* renamed from: g */
    public final boolean f9944g;

    /* renamed from: h */
    public final C1540m9 f9945h;

    /* renamed from: i */
    public final LoadErrorHandlingPolicy f9946i;

    /* renamed from: j */
    public final C0663e f9947j;

    /* renamed from: k */
    public final long f9948k;

    /* renamed from: l */
    public final ArrayList f9949l;

    /* renamed from: m */
    public final Set f9950m;

    /* renamed from: n */
    public final Set f9951n;

    /* renamed from: o */
    public int f9952o;

    /* renamed from: p */
    public ExoMediaDrm f9953p;

    /* renamed from: q */
    public C0660b f9954q;

    /* renamed from: r */
    public C0660b f9955r;

    /* renamed from: s */
    public Looper f9956s;

    /* renamed from: t */
    public Handler f9957t;

    /* renamed from: u */
    public int f9958u;

    /* renamed from: v */
    public byte[] f9959v;

    /* renamed from: w */
    public PlayerId f9960w;

    /* renamed from: x */
    public volatile o00 f9961x;

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: d */
        public boolean f9965d;

        /* renamed from: f */
        public boolean f9967f;

        /* renamed from: a */
        public final HashMap f9962a = new HashMap();

        /* renamed from: b */
        public UUID f9963b = C0643C.WIDEVINE_UUID;

        /* renamed from: c */
        public ExoMediaDrm.Provider f9964c = FrameworkMediaDrm.DEFAULT_PROVIDER;

        /* renamed from: g */
        public LoadErrorHandlingPolicy f9968g = new DefaultLoadErrorHandlingPolicy();

        /* renamed from: e */
        public int[] f9966e = new int[0];

        /* renamed from: h */
        public long f9969h = 300000;

        public DefaultDrmSessionManager build(MediaDrmCallback mediaDrmCallback) {
            return new DefaultDrmSessionManager(this.f9963b, this.f9964c, mediaDrmCallback, this.f9962a, this.f9965d, this.f9966e, this.f9967f, this.f9968g, this.f9969h);
        }

        public Builder setKeyRequestParameters(@Nullable Map<String, String> map) {
            HashMap hashMap = this.f9962a;
            hashMap.clear();
            if (map != null) {
                hashMap.putAll(map);
            }
            return this;
        }

        public Builder setLoadErrorHandlingPolicy(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            this.f9968g = (LoadErrorHandlingPolicy) Assertions.checkNotNull(loadErrorHandlingPolicy);
            return this;
        }

        public Builder setMultiSession(boolean z) {
            this.f9965d = z;
            return this;
        }

        public Builder setPlayClearSamplesWithoutKeys(boolean z) {
            this.f9967f = z;
            return this;
        }

        public Builder setSessionKeepaliveMs(long j) {
            boolean z;
            if (j <= 0 && j != C0643C.TIME_UNSET) {
                z = false;
            } else {
                z = true;
            }
            Assertions.checkArgument(z);
            this.f9969h = j;
            return this;
        }

        public Builder setUseDrmSessionsForClearContent(int... iArr) {
            for (int i : iArr) {
                boolean z = true;
                if (i != 2 && i != 1) {
                    z = false;
                }
                Assertions.checkArgument(z);
            }
            this.f9966e = (int[]) iArr.clone();
            return this;
        }

        public Builder setUuidAndExoMediaDrmProvider(UUID uuid, ExoMediaDrm.Provider provider) {
            this.f9963b = (UUID) Assertions.checkNotNull(uuid);
            this.f9964c = (ExoMediaDrm.Provider) Assertions.checkNotNull(provider);
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static final class MissingSchemeDataException extends Exception {
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface Mode {
    }

    @Deprecated
    public DefaultDrmSessionManager(UUID uuid, ExoMediaDrm exoMediaDrm, MediaDrmCallback mediaDrmCallback, @Nullable HashMap<String, String> hashMap) {
        this(uuid, exoMediaDrm, mediaDrmCallback, hashMap == null ? new HashMap<>() : hashMap, false, 3);
    }

    /* renamed from: b */
    public static boolean m2510b(C0660b c0660b) {
        if (c0660b.f10017o == 1 && (Util.SDK_INT < 19 || (((DrmSession.DrmSessionException) Assertions.checkNotNull(c0660b.getError())).getCause() instanceof ResourceBusyException))) {
            return true;
        }
        return false;
    }

    /* renamed from: e */
    public static ArrayList m2511e(DrmInitData drmInitData, UUID uuid, boolean z) {
        ArrayList arrayList = new ArrayList(drmInitData.schemeDataCount);
        for (int i = 0; i < drmInitData.schemeDataCount; i++) {
            DrmInitData.SchemeData schemeData = drmInitData.get(i);
            if ((schemeData.matches(uuid) || (C0643C.CLEARKEY_UUID.equals(uuid) && schemeData.matches(C0643C.COMMON_PSSH_UUID))) && (schemeData.data != null || z)) {
                arrayList.add(schemeData);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public final DrmSession m2512a(Looper looper, DrmSessionEventListener.EventDispatcher eventDispatcher, Format format, boolean z) {
        ArrayList arrayList;
        if (this.f9961x == null) {
            this.f9961x = new o00(this, looper);
        }
        DrmInitData drmInitData = format.drmInitData;
        C0660b c0660b = null;
        if (drmInitData == null) {
            int trackType = MimeTypes.getTrackType(format.sampleMimeType);
            ExoMediaDrm exoMediaDrm = (ExoMediaDrm) Assertions.checkNotNull(this.f9953p);
            if ((exoMediaDrm.getCryptoType() == 2 && FrameworkCryptoConfig.WORKAROUND_DEVICE_NEEDS_KEYS_TO_CONFIGURE_CODEC) || Util.linearSearch(this.f9943f, trackType) == -1 || exoMediaDrm.getCryptoType() == 1) {
                return null;
            }
            C0660b c0660b2 = this.f9954q;
            if (c0660b2 == null) {
                C0660b m2514d = m2514d(ImmutableList.m3902of(), true, null, z);
                this.f9949l.add(m2514d);
                this.f9954q = m2514d;
            } else {
                c0660b2.acquire(null);
            }
            return this.f9954q;
        }
        if (this.f9959v == null) {
            arrayList = m2511e((DrmInitData) Assertions.checkNotNull(drmInitData), this.f9938a, false);
            if (arrayList.isEmpty()) {
                Exception exc = new Exception("Media does not support uuid: " + this.f9938a);
                Log.m3024e("DefaultDrmSessionMgr", "DRM error", exc);
                if (eventDispatcher != null) {
                    eventDispatcher.drmSessionManagerError(exc);
                }
                return new ErrorStateDrmSession(new DrmSession.DrmSessionException(exc, PlaybackException.ERROR_CODE_DRM_CONTENT_ERROR));
            }
        } else {
            arrayList = null;
        }
        if (!this.f9942e) {
            c0660b = this.f9955r;
        } else {
            Iterator it = this.f9949l.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                C0660b c0660b3 = (C0660b) it.next();
                if (Util.areEqual(c0660b3.f10003a, arrayList)) {
                    c0660b = c0660b3;
                    break;
                }
            }
        }
        if (c0660b == null) {
            c0660b = m2514d(arrayList, false, eventDispatcher, z);
            if (!this.f9942e) {
                this.f9955r = c0660b;
            }
            this.f9949l.add(c0660b);
        } else {
            c0660b.acquire(eventDispatcher);
        }
        return c0660b;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionManager
    @Nullable
    public DrmSession acquireSession(@Nullable DrmSessionEventListener.EventDispatcher eventDispatcher, Format format) {
        boolean z;
        if (this.f9952o > 0) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkState(z);
        Assertions.checkStateNotNull(this.f9956s);
        return m2512a(this.f9956s, eventDispatcher, format, true);
    }

    /* renamed from: c */
    public final C0660b m2513c(List list, boolean z, DrmSessionEventListener.EventDispatcher eventDispatcher) {
        Assertions.checkNotNull(this.f9953p);
        boolean z2 = this.f9944g | z;
        ExoMediaDrm exoMediaDrm = this.f9953p;
        int i = this.f9958u;
        byte[] bArr = this.f9959v;
        Looper looper = (Looper) Assertions.checkNotNull(this.f9956s);
        PlayerId playerId = (PlayerId) Assertions.checkNotNull(this.f9960w);
        C0660b c0660b = new C0660b(this.f9938a, exoMediaDrm, this.f9945h, this.f9947j, list, i, z2, z, bArr, this.f9941d, this.f9940c, looper, this.f9946i, playerId);
        c0660b.acquire(eventDispatcher);
        if (this.f9948k != C0643C.TIME_UNSET) {
            c0660b.acquire(null);
        }
        return c0660b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: d */
    public final C0660b m2514d(List list, boolean z, DrmSessionEventListener.EventDispatcher eventDispatcher, boolean z2) {
        C0660b m2513c = m2513c(list, z, eventDispatcher);
        boolean m2510b = m2510b(m2513c);
        long j = this.f9948k;
        Set set = this.f9951n;
        if (m2510b && !set.isEmpty()) {
            UnmodifiableIterator it = ImmutableSet.copyOf((Collection) set).iterator();
            while (it.hasNext()) {
                ((DrmSession) it.next()).release(null);
            }
            m2513c.release(eventDispatcher);
            if (j != C0643C.TIME_UNSET) {
                m2513c.release(null);
            }
            m2513c = m2513c(list, z, eventDispatcher);
        }
        if (m2510b(m2513c) && z2) {
            Set set2 = this.f9950m;
            if (!set2.isEmpty()) {
                UnmodifiableIterator it2 = ImmutableSet.copyOf((Collection) set2).iterator();
                while (it2.hasNext()) {
                    ((C0662d) it2.next()).release();
                }
                if (!set.isEmpty()) {
                    UnmodifiableIterator it3 = ImmutableSet.copyOf((Collection) set).iterator();
                    while (it3.hasNext()) {
                        ((DrmSession) it3.next()).release(null);
                    }
                }
                m2513c.release(eventDispatcher);
                if (j != C0643C.TIME_UNSET) {
                    m2513c.release(null);
                }
                return m2513c(list, z, eventDispatcher);
            }
            return m2513c;
        }
        return m2513c;
    }

    /* renamed from: f */
    public final void m2515f() {
        if (this.f9953p != null && this.f9952o == 0 && this.f9949l.isEmpty() && this.f9950m.isEmpty()) {
            ((ExoMediaDrm) Assertions.checkNotNull(this.f9953p)).release();
            this.f9953p = null;
        }
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionManager
    public int getCryptoType(Format format) {
        int cryptoType = ((ExoMediaDrm) Assertions.checkNotNull(this.f9953p)).getCryptoType();
        DrmInitData drmInitData = format.drmInitData;
        if (drmInitData == null) {
            if (Util.linearSearch(this.f9943f, MimeTypes.getTrackType(format.sampleMimeType)) == -1) {
                return 0;
            }
            return cryptoType;
        }
        if (this.f9959v == null) {
            UUID uuid = this.f9938a;
            if (m2511e(drmInitData, uuid, true).isEmpty()) {
                if (drmInitData.schemeDataCount == 1 && drmInitData.get(0).matches(C0643C.COMMON_PSSH_UUID)) {
                    Log.m3027w("DefaultDrmSessionMgr", "DrmInitData only contains common PSSH SchemeData. Assuming support for: " + uuid);
                }
                return 1;
            }
            String str = drmInitData.schemeType;
            if (str != null && !C0643C.CENC_TYPE_cenc.equals(str)) {
                if (C0643C.CENC_TYPE_cbcs.equals(str)) {
                    if (Util.SDK_INT >= 25) {
                        return cryptoType;
                    }
                } else if (!C0643C.CENC_TYPE_cbc1.equals(str) && !C0643C.CENC_TYPE_cens.equals(str)) {
                    return cryptoType;
                }
                return 1;
            }
            return cryptoType;
        }
        return cryptoType;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionManager
    public DrmSessionManager.DrmSessionReference preacquireSession(@Nullable DrmSessionEventListener.EventDispatcher eventDispatcher, Format format) {
        boolean z;
        if (this.f9952o > 0) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkState(z);
        Assertions.checkStateNotNull(this.f9956s);
        C0662d c0662d = new C0662d(this, eventDispatcher);
        ((Handler) Assertions.checkNotNull(this.f9957t)).post(new RunnableC0583c7(9, c0662d, format));
        return c0662d;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionManager
    public final void prepare() {
        int i = this.f9952o;
        this.f9952o = i + 1;
        if (i != 0) {
            return;
        }
        if (this.f9953p == null) {
            ExoMediaDrm acquireExoMediaDrm = this.f9939b.acquireExoMediaDrm(this.f9938a);
            this.f9953p = acquireExoMediaDrm;
            acquireExoMediaDrm.setOnEventListener(new C0661c(this));
        } else if (this.f9948k != C0643C.TIME_UNSET) {
            int i2 = 0;
            while (true) {
                ArrayList arrayList = this.f9949l;
                if (i2 < arrayList.size()) {
                    ((C0660b) arrayList.get(i2)).acquire(null);
                    i2++;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.exoplayer2.drm.DrmSessionManager
    public final void release() {
        int i = this.f9952o - 1;
        this.f9952o = i;
        if (i != 0) {
            return;
        }
        if (this.f9948k != C0643C.TIME_UNSET) {
            ArrayList arrayList = new ArrayList(this.f9949l);
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                ((C0660b) arrayList.get(i2)).release(null);
            }
        }
        UnmodifiableIterator it = ImmutableSet.copyOf((Collection) this.f9950m).iterator();
        while (it.hasNext()) {
            ((C0662d) it.next()).release();
        }
        m2515f();
    }

    public void setMode(int i, @Nullable byte[] bArr) {
        Assertions.checkState(this.f9949l.isEmpty());
        if (i == 1 || i == 3) {
            Assertions.checkNotNull(bArr);
        }
        this.f9958u = i;
        this.f9959v = bArr;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionManager
    public void setPlayer(Looper looper, PlayerId playerId) {
        boolean z;
        synchronized (this) {
            try {
                Looper looper2 = this.f9956s;
                if (looper2 == null) {
                    this.f9956s = looper;
                    this.f9957t = new Handler(looper);
                } else {
                    if (looper2 == looper) {
                        z = true;
                    } else {
                        z = false;
                    }
                    Assertions.checkState(z);
                    Assertions.checkNotNull(this.f9957t);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f9960w = playerId;
    }

    @Deprecated
    public DefaultDrmSessionManager(UUID uuid, ExoMediaDrm exoMediaDrm, MediaDrmCallback mediaDrmCallback, @Nullable HashMap<String, String> hashMap, boolean z) {
        this(uuid, exoMediaDrm, mediaDrmCallback, hashMap == null ? new HashMap<>() : hashMap, z, 3);
    }

    @Deprecated
    public DefaultDrmSessionManager(UUID uuid, ExoMediaDrm exoMediaDrm, MediaDrmCallback mediaDrmCallback, @Nullable HashMap<String, String> hashMap, boolean z, int i) {
        this(uuid, new ExoMediaDrm.AppManagedProvider(exoMediaDrm), mediaDrmCallback, hashMap == null ? new HashMap<>() : hashMap, z, new int[0], false, new DefaultLoadErrorHandlingPolicy(i), 300000L);
    }

    public DefaultDrmSessionManager(UUID uuid, ExoMediaDrm.Provider provider, MediaDrmCallback mediaDrmCallback, HashMap hashMap, boolean z, int[] iArr, boolean z2, LoadErrorHandlingPolicy loadErrorHandlingPolicy, long j) {
        Assertions.checkNotNull(uuid);
        Assertions.checkArgument(!C0643C.COMMON_PSSH_UUID.equals(uuid), "Use C.CLEARKEY_UUID instead");
        this.f9938a = uuid;
        this.f9939b = provider;
        this.f9940c = mediaDrmCallback;
        this.f9941d = hashMap;
        this.f9942e = z;
        this.f9943f = iArr;
        this.f9944g = z2;
        this.f9946i = loadErrorHandlingPolicy;
        this.f9945h = new C1540m9(6);
        this.f9947j = new C0663e(this);
        this.f9958u = 0;
        this.f9949l = new ArrayList();
        this.f9950m = Sets.newIdentityHashSet();
        this.f9951n = Sets.newIdentityHashSet();
        this.f9948k = j;
    }
}
