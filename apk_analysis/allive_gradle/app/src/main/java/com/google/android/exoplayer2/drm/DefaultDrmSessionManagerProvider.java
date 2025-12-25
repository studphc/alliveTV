package com.google.android.exoplayer2.drm;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.primitives.Ints;
import java.util.Map;

/* loaded from: classes.dex */
public final class DefaultDrmSessionManagerProvider implements DrmSessionManagerProvider {

    /* renamed from: a */
    public final Object f9970a = new Object();

    /* renamed from: b */
    public MediaItem.DrmConfiguration f9971b;

    /* renamed from: c */
    public DefaultDrmSessionManager f9972c;

    /* renamed from: d */
    public DataSource.Factory f9973d;

    /* renamed from: e */
    public String f9974e;

    /* renamed from: a */
    public final DefaultDrmSessionManager m2516a(MediaItem.DrmConfiguration drmConfiguration) {
        String uri;
        DataSource.Factory factory = this.f9973d;
        if (factory == null) {
            factory = new DefaultHttpDataSource.Factory().setUserAgent(this.f9974e);
        }
        Uri uri2 = drmConfiguration.licenseUri;
        if (uri2 == null) {
            uri = null;
        } else {
            uri = uri2.toString();
        }
        HttpMediaDrmCallback httpMediaDrmCallback = new HttpMediaDrmCallback(uri, drmConfiguration.forceDefaultLicenseUri, factory);
        UnmodifiableIterator<Map.Entry<String, String>> it = drmConfiguration.licenseRequestHeaders.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> next = it.next();
            httpMediaDrmCallback.setKeyRequestProperty(next.getKey(), next.getValue());
        }
        DefaultDrmSessionManager build = new DefaultDrmSessionManager.Builder().setUuidAndExoMediaDrmProvider(drmConfiguration.scheme, FrameworkMediaDrm.DEFAULT_PROVIDER).setMultiSession(drmConfiguration.multiSession).setPlayClearSamplesWithoutKeys(drmConfiguration.playClearContentWithoutKey).setUseDrmSessionsForClearContent(Ints.toArray(drmConfiguration.forcedSessionTrackTypes)).build(httpMediaDrmCallback);
        build.setMode(0, drmConfiguration.getKeySetId());
        return build;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionManagerProvider
    public DrmSessionManager get(MediaItem mediaItem) {
        DrmSessionManager drmSessionManager;
        Assertions.checkNotNull(mediaItem.localConfiguration);
        MediaItem.DrmConfiguration drmConfiguration = mediaItem.localConfiguration.drmConfiguration;
        if (drmConfiguration != null && Util.SDK_INT >= 18) {
            synchronized (this.f9970a) {
                try {
                    if (!Util.areEqual(drmConfiguration, this.f9971b)) {
                        this.f9971b = drmConfiguration;
                        this.f9972c = m2516a(drmConfiguration);
                    }
                    drmSessionManager = (DrmSessionManager) Assertions.checkNotNull(this.f9972c);
                } catch (Throwable th) {
                    throw th;
                }
            }
            return drmSessionManager;
        }
        return DrmSessionManager.DRM_UNSUPPORTED;
    }

    public void setDrmHttpDataSourceFactory(@Nullable DataSource.Factory factory) {
        this.f9973d = factory;
    }

    @Deprecated
    public void setDrmUserAgent(@Nullable String str) {
        this.f9974e = str;
    }
}
