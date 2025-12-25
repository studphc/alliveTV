package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import p000.C1540m9;
import p000.pm2;

/* loaded from: classes.dex */
public class StableIdStorage$IsolatedStableIdStorage implements pm2 {

    /* renamed from: a */
    public long f7266a = 0;

    @Override // p000.pm2
    @NonNull
    public StableIdStorage$StableIdLookup createStableIdLookup() {
        return new C1540m9(this);
    }
}
