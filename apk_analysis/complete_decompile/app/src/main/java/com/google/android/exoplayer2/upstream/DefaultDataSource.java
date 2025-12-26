package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class DefaultDataSource implements DataSource {

    /* renamed from: a */
    public final Context f12460a;

    /* renamed from: b */
    public final ArrayList f12461b;

    /* renamed from: c */
    public final DataSource f12462c;

    /* renamed from: d */
    public FileDataSource f12463d;

    /* renamed from: e */
    public AssetDataSource f12464e;

    /* renamed from: f */
    public ContentDataSource f12465f;

    /* renamed from: g */
    public DataSource f12466g;

    /* renamed from: h */
    public UdpDataSource f12467h;

    /* renamed from: i */
    public DataSchemeDataSource f12468i;

    /* renamed from: j */
    public RawResourceDataSource f12469j;

    /* renamed from: k */
    public DataSource f12470k;

    /* loaded from: classes.dex */
    public static final class Factory implements DataSource.Factory {

        /* renamed from: a */
        public final Context f12471a;

        /* renamed from: b */
        public final DataSource.Factory f12472b;

        /* renamed from: c */
        public TransferListener f12473c;

        public Factory(Context context) {
            this(context, new DefaultHttpDataSource.Factory());
        }

        public Factory setTransferListener(@Nullable TransferListener transferListener) {
            this.f12473c = transferListener;
            return this;
        }

        public Factory(Context context, DataSource.Factory factory) {
            this.f12471a = context.getApplicationContext();
            this.f12472b = factory;
        }

        @Override // com.google.android.exoplayer2.upstream.DataSource.Factory
        public DefaultDataSource createDataSource() {
            DefaultDataSource defaultDataSource = new DefaultDataSource(this.f12471a, this.f12472b.createDataSource());
            TransferListener transferListener = this.f12473c;
            if (transferListener != null) {
                defaultDataSource.addTransferListener(transferListener);
            }
            return defaultDataSource;
        }
    }

    public DefaultDataSource(Context context, boolean z) {
        this(context, null, 8000, 8000, z);
    }

    /* renamed from: b */
    public static void m2980b(DataSource dataSource, TransferListener transferListener) {
        if (dataSource != null) {
            dataSource.addTransferListener(transferListener);
        }
    }

    /* renamed from: a */
    public final void m2981a(DataSource dataSource) {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f12461b;
            if (i < arrayList.size()) {
                dataSource.addTransferListener((TransferListener) arrayList.get(i));
                i++;
            } else {
                return;
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void addTransferListener(TransferListener transferListener) {
        Assertions.checkNotNull(transferListener);
        this.f12462c.addTransferListener(transferListener);
        this.f12461b.add(transferListener);
        m2980b(this.f12463d, transferListener);
        m2980b(this.f12464e, transferListener);
        m2980b(this.f12465f, transferListener);
        m2980b(this.f12466g, transferListener);
        m2980b(this.f12467h, transferListener);
        m2980b(this.f12468i, transferListener);
        m2980b(this.f12469j, transferListener);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() {
        DataSource dataSource = this.f12470k;
        if (dataSource != null) {
            try {
                dataSource.close();
            } finally {
                this.f12470k = null;
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public Map<String, List<String>> getResponseHeaders() {
        DataSource dataSource = this.f12470k;
        if (dataSource == null) {
            return Collections.emptyMap();
        }
        return dataSource.getResponseHeaders();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    @Nullable
    public Uri getUri() {
        DataSource dataSource = this.f12470k;
        if (dataSource == null) {
            return null;
        }
        return dataSource.getUri();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public long open(DataSpec dataSpec) {
        boolean z;
        if (this.f12470k == null) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkState(z);
        String scheme = dataSpec.uri.getScheme();
        boolean isLocalFileUri = Util.isLocalFileUri(dataSpec.uri);
        Context context = this.f12460a;
        if (isLocalFileUri) {
            String path = dataSpec.uri.getPath();
            if (path != null && path.startsWith("/android_asset/")) {
                if (this.f12464e == null) {
                    AssetDataSource assetDataSource = new AssetDataSource(context);
                    this.f12464e = assetDataSource;
                    m2981a(assetDataSource);
                }
                this.f12470k = this.f12464e;
            } else {
                if (this.f12463d == null) {
                    FileDataSource fileDataSource = new FileDataSource();
                    this.f12463d = fileDataSource;
                    m2981a(fileDataSource);
                }
                this.f12470k = this.f12463d;
            }
        } else if ("asset".equals(scheme)) {
            if (this.f12464e == null) {
                AssetDataSource assetDataSource2 = new AssetDataSource(context);
                this.f12464e = assetDataSource2;
                m2981a(assetDataSource2);
            }
            this.f12470k = this.f12464e;
        } else if (FirebaseAnalytics.Param.CONTENT.equals(scheme)) {
            if (this.f12465f == null) {
                ContentDataSource contentDataSource = new ContentDataSource(context);
                this.f12465f = contentDataSource;
                m2981a(contentDataSource);
            }
            this.f12470k = this.f12465f;
        } else {
            boolean equals = "rtmp".equals(scheme);
            DataSource dataSource = this.f12462c;
            if (equals) {
                if (this.f12466g == null) {
                    try {
                        DataSource dataSource2 = (DataSource) Class.forName("com.google.android.exoplayer2.ext.rtmp.RtmpDataSource").getConstructor(null).newInstance(null);
                        this.f12466g = dataSource2;
                        m2981a(dataSource2);
                    } catch (ClassNotFoundException unused) {
                        Log.m3027w("DefaultDataSource", "Attempting to play RTMP stream without depending on the RTMP extension");
                    } catch (Exception e) {
                        throw new RuntimeException("Error instantiating RTMP extension", e);
                    }
                    if (this.f12466g == null) {
                        this.f12466g = dataSource;
                    }
                }
                this.f12470k = this.f12466g;
            } else if ("udp".equals(scheme)) {
                if (this.f12467h == null) {
                    UdpDataSource udpDataSource = new UdpDataSource();
                    this.f12467h = udpDataSource;
                    m2981a(udpDataSource);
                }
                this.f12470k = this.f12467h;
            } else if (DataSchemeDataSource.SCHEME_DATA.equals(scheme)) {
                if (this.f12468i == null) {
                    DataSchemeDataSource dataSchemeDataSource = new DataSchemeDataSource();
                    this.f12468i = dataSchemeDataSource;
                    m2981a(dataSchemeDataSource);
                }
                this.f12470k = this.f12468i;
            } else if (!RawResourceDataSource.RAW_RESOURCE_SCHEME.equals(scheme) && !"android.resource".equals(scheme)) {
                this.f12470k = dataSource;
            } else {
                if (this.f12469j == null) {
                    RawResourceDataSource rawResourceDataSource = new RawResourceDataSource(context);
                    this.f12469j = rawResourceDataSource;
                    m2981a(rawResourceDataSource);
                }
                this.f12470k = this.f12469j;
            }
        }
        return this.f12470k.open(dataSpec);
    }

    @Override // com.google.android.exoplayer2.upstream.DataReader
    public int read(byte[] bArr, int i, int i2) {
        return ((DataSource) Assertions.checkNotNull(this.f12470k)).read(bArr, i, i2);
    }

    public DefaultDataSource(Context context, @Nullable String str, boolean z) {
        this(context, str, 8000, 8000, z);
    }

    public DefaultDataSource(Context context, @Nullable String str, int i, int i2, boolean z) {
        this(context, new DefaultHttpDataSource.Factory().setUserAgent(str).setConnectTimeoutMs(i).setReadTimeoutMs(i2).setAllowCrossProtocolRedirects(z).createDataSource());
    }

    public DefaultDataSource(Context context, DataSource dataSource) {
        this.f12460a = context.getApplicationContext();
        this.f12462c = (DataSource) Assertions.checkNotNull(dataSource);
        this.f12461b = new ArrayList();
    }
}
