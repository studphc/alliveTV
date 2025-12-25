package p000;

import com.google.gson.InstanceCreator;
import com.google.gson.internal.ObjectConstructor;
import java.lang.reflect.Type;

/* renamed from: iv */
/* loaded from: classes2.dex */
public final class C1331iv implements ObjectConstructor {

    /* renamed from: a */
    public final /* synthetic */ int f20272a;

    /* renamed from: b */
    public final /* synthetic */ InstanceCreator f20273b;

    /* renamed from: c */
    public final /* synthetic */ Type f20274c;

    public /* synthetic */ C1331iv(InstanceCreator instanceCreator, Type type, int i) {
        this.f20272a = i;
        this.f20273b = instanceCreator;
        this.f20274c = type;
    }

    @Override // com.google.gson.internal.ObjectConstructor
    public final Object construct() {
        switch (this.f20272a) {
            case 0:
                return this.f20273b.createInstance(this.f20274c);
            default:
                return this.f20273b.createInstance(this.f20274c);
        }
    }
}
