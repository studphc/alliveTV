package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.drm.DrmSessionManagerProvider;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.C0697f;
import com.google.android.exoplayer2.source.DefaultMediaSourceFactory;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.util.Assertions;
import com.google.common.base.Supplier;
import java.util.HashMap;
import java.util.HashSet;
import p000.a10;

/* renamed from: com.google.android.exoplayer2.source.f */
/* loaded from: classes.dex */
public final class C0697f {

    /* renamed from: a */
    public final ExtractorsFactory f11361a;

    /* renamed from: b */
    public final HashMap f11362b = new HashMap();

    /* renamed from: c */
    public final HashSet f11363c = new HashSet();

    /* renamed from: d */
    public final HashMap f11364d = new HashMap();

    /* renamed from: e */
    public DataSource.Factory f11365e;

    /* renamed from: f */
    public DrmSessionManagerProvider f11366f;

    /* renamed from: g */
    public LoadErrorHandlingPolicy f11367g;

    public C0697f(ExtractorsFactory extractorsFactory) {
        this.f11361a = extractorsFactory;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0078  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Supplier m2789a(int i) {
        Supplier supplier;
        Supplier supplier2;
        final int i2 = 0;
        final int i3 = 3;
        final int i4 = 2;
        final int i5 = 1;
        HashMap hashMap = this.f11362b;
        if (hashMap.containsKey(Integer.valueOf(i))) {
            return (Supplier) hashMap.get(Integer.valueOf(i));
        }
        final DataSource.Factory factory = (DataSource.Factory) Assertions.checkNotNull(this.f11365e);
        Supplier supplier3 = null;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            supplier3 = new Supplier() { // from class: z00
                                @Override // com.google.common.base.Supplier
                                public final Object get() {
                                    switch (i3) {
                                        case 0:
                                            return DefaultMediaSourceFactory.m2739a((Class) this, factory);
                                        case 1:
                                            return DefaultMediaSourceFactory.m2739a((Class) this, factory);
                                        case 2:
                                            return DefaultMediaSourceFactory.m2739a((Class) this, factory);
                                        default:
                                            return new ProgressiveMediaSource.Factory(factory, ((C0697f) this).f11361a);
                                    }
                                }
                            };
                        }
                        hashMap.put(Integer.valueOf(i), supplier3);
                        if (supplier3 != null) {
                            this.f11363c.add(Integer.valueOf(i));
                        }
                        return supplier3;
                    }
                    supplier = new a10(i2, Class.forName("com.google.android.exoplayer2.source.rtsp.RtspMediaSource$Factory").asSubclass(MediaSource.Factory.class));
                } else {
                    final Class asSubclass = HlsMediaSource.Factory.class.asSubclass(MediaSource.Factory.class);
                    supplier2 = new Supplier() { // from class: z00
                        @Override // com.google.common.base.Supplier
                        public final Object get() {
                            switch (i4) {
                                case 0:
                                    return DefaultMediaSourceFactory.m2739a((Class) asSubclass, factory);
                                case 1:
                                    return DefaultMediaSourceFactory.m2739a((Class) asSubclass, factory);
                                case 2:
                                    return DefaultMediaSourceFactory.m2739a((Class) asSubclass, factory);
                                default:
                                    return new ProgressiveMediaSource.Factory(factory, ((C0697f) asSubclass).f11361a);
                            }
                        }
                    };
                }
            } else {
                final Class asSubclass2 = SsMediaSource.Factory.class.asSubclass(MediaSource.Factory.class);
                supplier2 = new Supplier() { // from class: z00
                    @Override // com.google.common.base.Supplier
                    public final Object get() {
                        switch (i5) {
                            case 0:
                                return DefaultMediaSourceFactory.m2739a((Class) asSubclass2, factory);
                            case 1:
                                return DefaultMediaSourceFactory.m2739a((Class) asSubclass2, factory);
                            case 2:
                                return DefaultMediaSourceFactory.m2739a((Class) asSubclass2, factory);
                            default:
                                return new ProgressiveMediaSource.Factory(factory, ((C0697f) asSubclass2).f11361a);
                        }
                    }
                };
            }
            supplier3 = supplier2;
            hashMap.put(Integer.valueOf(i), supplier3);
            if (supplier3 != null) {
            }
            return supplier3;
        }
        final Class asSubclass3 = DashMediaSource.Factory.class.asSubclass(MediaSource.Factory.class);
        supplier = new Supplier() { // from class: z00
            @Override // com.google.common.base.Supplier
            public final Object get() {
                switch (i2) {
                    case 0:
                        return DefaultMediaSourceFactory.m2739a((Class) asSubclass3, factory);
                    case 1:
                        return DefaultMediaSourceFactory.m2739a((Class) asSubclass3, factory);
                    case 2:
                        return DefaultMediaSourceFactory.m2739a((Class) asSubclass3, factory);
                    default:
                        return new ProgressiveMediaSource.Factory(factory, ((C0697f) asSubclass3).f11361a);
                }
            }
        };
        supplier3 = supplier;
        hashMap.put(Integer.valueOf(i), supplier3);
        if (supplier3 != null) {
        }
        return supplier3;
    }
}
