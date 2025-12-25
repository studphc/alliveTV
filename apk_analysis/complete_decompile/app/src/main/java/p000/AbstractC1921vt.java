package p000;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.Qualified;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import java.util.Set;

/* renamed from: vt */
/* loaded from: classes2.dex */
public abstract /* synthetic */ class AbstractC1921vt {
    /* renamed from: a */
    public static Object m7933a(ComponentContainer componentContainer, Qualified qualified) {
        Provider provider = componentContainer.getProvider(qualified);
        if (provider == null) {
            return null;
        }
        return provider.get();
    }

    /* renamed from: b */
    public static Object m7934b(ComponentContainer componentContainer, Class cls) {
        return componentContainer.get(Qualified.unqualified(cls));
    }

    /* renamed from: c */
    public static Deferred m7935c(ComponentContainer componentContainer, Class cls) {
        return componentContainer.getDeferred(Qualified.unqualified(cls));
    }

    /* renamed from: d */
    public static Provider m7936d(ComponentContainer componentContainer, Class cls) {
        return componentContainer.getProvider(Qualified.unqualified(cls));
    }

    /* renamed from: e */
    public static Set m7937e(ComponentContainer componentContainer, Qualified qualified) {
        return (Set) componentContainer.setOfProvider(qualified).get();
    }

    /* renamed from: f */
    public static Set m7938f(ComponentContainer componentContainer, Class cls) {
        return componentContainer.setOf(Qualified.unqualified(cls));
    }

    /* renamed from: g */
    public static Provider m7939g(ComponentContainer componentContainer, Class cls) {
        return componentContainer.setOfProvider(Qualified.unqualified(cls));
    }
}
