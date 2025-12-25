package p000;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CopyableThreadContextElement;

/* renamed from: sw */
/* loaded from: classes2.dex */
public final class C1813sw extends Lambda implements Function2 {

    /* renamed from: b */
    public final /* synthetic */ Ref.ObjectRef f26591b;

    /* renamed from: c */
    public final /* synthetic */ boolean f26592c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1813sw(Ref.ObjectRef objectRef, boolean z) {
        super(2);
        this.f26591b = objectRef;
        this.f26592c = z;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [T, kotlin.coroutines.CoroutineContext] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        CoroutineContext coroutineContext = (CoroutineContext) obj;
        CoroutineContext.Element element = (CoroutineContext.Element) obj2;
        if (!(element instanceof CopyableThreadContextElement)) {
            return coroutineContext.plus(element);
        }
        Ref.ObjectRef objectRef = this.f26591b;
        CoroutineContext.Element element2 = ((CoroutineContext) objectRef.element).get(element.getKey());
        if (element2 == null) {
            CopyableThreadContextElement copyableThreadContextElement = (CopyableThreadContextElement) element;
            if (this.f26592c) {
                copyableThreadContextElement = copyableThreadContextElement.copyForChild();
            }
            return coroutineContext.plus(copyableThreadContextElement);
        }
        objectRef.element = ((CoroutineContext) objectRef.element).minusKey(element.getKey());
        return coroutineContext.plus(((CopyableThreadContextElement) element).mergeForChild(element2));
    }
}
