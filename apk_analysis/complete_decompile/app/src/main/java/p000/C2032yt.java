package p000;

import android.content.Context;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import com.google.firebase.tracing.FirebaseTrace;

/* renamed from: yt */
/* loaded from: classes2.dex */
public final /* synthetic */ class C2032yt implements ComponentFactory {

    /* renamed from: a */
    public final /* synthetic */ int f29127a;

    /* renamed from: b */
    public final /* synthetic */ String f29128b;

    /* renamed from: c */
    public final /* synthetic */ Object f29129c;

    public /* synthetic */ C2032yt(Object obj, int i, String str) {
        this.f29127a = i;
        this.f29128b = str;
        this.f29129c = obj;
    }

    @Override // com.google.firebase.components.ComponentFactory
    public final Object create(ComponentContainer componentContainer) {
        switch (this.f29127a) {
            case 0:
                String str = this.f29128b;
                Component component = (Component) this.f29129c;
                try {
                    FirebaseTrace.pushTrace(str);
                    return component.getFactory().create(componentContainer);
                } finally {
                    FirebaseTrace.popTrace();
                }
            default:
                return new C1868ud(this.f29128b, ((LibraryVersionComponent.VersionExtractor) this.f29129c).extract((Context) componentContainer.get(Context.class)));
        }
    }
}
