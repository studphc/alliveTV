package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.util.PriorityTaskManager;

@Deprecated
/* loaded from: classes.dex */
public final class PriorityDataSourceFactory implements DataSource.Factory {

    /* renamed from: a */
    public final DataSource.Factory f12525a;

    /* renamed from: b */
    public final PriorityTaskManager f12526b;

    /* renamed from: c */
    public final int f12527c;

    public PriorityDataSourceFactory(DataSource.Factory factory, PriorityTaskManager priorityTaskManager, int i) {
        this.f12525a = factory;
        this.f12526b = priorityTaskManager;
        this.f12527c = i;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource.Factory
    public PriorityDataSource createDataSource() {
        return new PriorityDataSource(this.f12525a.createDataSource(), this.f12526b, this.f12527c);
    }
}
