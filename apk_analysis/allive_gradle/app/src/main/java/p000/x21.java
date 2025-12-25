package p000;

import com.google.common.collect.ImmutableSet;
import java.util.Map;

/* loaded from: classes.dex */
public final class x21 extends AbstractC2041z1 {

    /* renamed from: a */
    public final /* synthetic */ int f28427a;

    /* renamed from: b */
    public final /* synthetic */ Map.Entry f28428b;

    public /* synthetic */ x21(Map.Entry entry, int i) {
        this.f28427a = i;
        this.f28428b = entry;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        switch (this.f28427a) {
            case 0:
                return this.f28428b.getKey();
            default:
                return this.f28428b.getKey();
        }
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        switch (this.f28427a) {
            case 0:
                return ImmutableSet.m3972of(this.f28428b.getValue());
            default:
                return this.f28428b.getValue();
        }
    }
}
