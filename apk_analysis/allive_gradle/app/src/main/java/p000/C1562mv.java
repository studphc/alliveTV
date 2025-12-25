package p000;

import com.google.gson.JsonIOException;
import com.google.gson.internal.ObjectConstructor;

/* renamed from: mv */
/* loaded from: classes2.dex */
public final class C1562mv implements ObjectConstructor {

    /* renamed from: a */
    public final /* synthetic */ String f23134a;

    public C1562mv(String str) {
        this.f23134a = str;
    }

    @Override // com.google.gson.internal.ObjectConstructor
    public final Object construct() {
        throw new JsonIOException(this.f23134a);
    }
}
