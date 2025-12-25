package com.google.android.exoplayer2.upstream;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource;

@Deprecated
/* loaded from: classes.dex */
public final class DefaultDataSourceFactory implements DataSource.Factory {

    /* renamed from: a */
    public final Context f12474a;

    /* renamed from: b */
    public final TransferListener f12475b;

    /* renamed from: c */
    public final DataSource.Factory f12476c;

    public DefaultDataSourceFactory(Context context) {
        this(context, (String) null, (TransferListener) null);
    }

    public DefaultDataSourceFactory(Context context, @Nullable String str) {
        this(context, str, (TransferListener) null);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource.Factory
    public DefaultDataSource createDataSource() {
        DefaultDataSource defaultDataSource = new DefaultDataSource(this.f12474a, this.f12476c.createDataSource());
        TransferListener transferListener = this.f12475b;
        if (transferListener != null) {
            defaultDataSource.addTransferListener(transferListener);
        }
        return defaultDataSource;
    }

    public DefaultDataSourceFactory(Context context, @Nullable String str, @Nullable TransferListener transferListener) {
        this(context, transferListener, new DefaultHttpDataSource.Factory().setUserAgent(str));
    }

    public DefaultDataSourceFactory(Context context, DataSource.Factory factory) {
        this(context, (TransferListener) null, factory);
    }

    public DefaultDataSourceFactory(Context context, @Nullable TransferListener transferListener, DataSource.Factory factory) {
        this.f12474a = context.getApplicationContext();
        this.f12475b = transferListener;
        this.f12476c = factory;
    }
}
