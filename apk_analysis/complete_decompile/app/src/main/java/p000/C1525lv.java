package p000;

import com.google.gson.JsonIOException;
import com.google.gson.internal.ObjectConstructor;

/* renamed from: lv */
/* loaded from: classes2.dex */
public final class C1525lv implements ObjectConstructor {

    /* renamed from: a */
    public final /* synthetic */ String f22675a;

    public C1525lv(String str) {
        this.f22675a = str;
    }

    @Override // com.google.gson.internal.ObjectConstructor
    public final Object construct() {
        throw new JsonIOException(this.f22675a);
    }
}
