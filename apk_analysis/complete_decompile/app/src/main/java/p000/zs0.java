package p000;

import androidx.collection.SimpleArrayMap;
import androidx.core.provider.AbstractC0193h;
import androidx.core.provider.C0192g;
import androidx.core.util.Consumer;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class zs0 implements Consumer {

    /* renamed from: a */
    public final /* synthetic */ String f29508a;

    public zs0(String str) {
        this.f29508a = str;
    }

    @Override // androidx.core.util.Consumer
    public final void accept(Object obj) {
        C0192g c0192g = (C0192g) obj;
        synchronized (AbstractC0193h.f3756c) {
            try {
                SimpleArrayMap simpleArrayMap = AbstractC0193h.f3757d;
                ArrayList arrayList = (ArrayList) simpleArrayMap.get(this.f29508a);
                if (arrayList != null) {
                    simpleArrayMap.remove(this.f29508a);
                    for (int i = 0; i < arrayList.size(); i++) {
                        ((Consumer) arrayList.get(i)).accept(c0192g);
                    }
                }
            } finally {
            }
        }
    }
}
