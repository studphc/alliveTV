package p000;

import java.util.Iterator;
import kotlin.collections.ArrayDeque;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.sequences.SequenceScope;
import okio.FileSystem;
import okio.Path;
import okio.internal._FileSystemKt;

/* loaded from: classes2.dex */
public final class q63 extends ContinuationImpl {

    /* renamed from: d */
    public SequenceScope f25464d;

    /* renamed from: e */
    public FileSystem f25465e;

    /* renamed from: f */
    public ArrayDeque f25466f;

    /* renamed from: g */
    public Path f25467g;

    /* renamed from: h */
    public Iterator f25468h;

    /* renamed from: i */
    public boolean f25469i;

    /* renamed from: j */
    public boolean f25470j;

    /* renamed from: k */
    public /* synthetic */ Object f25471k;

    /* renamed from: l */
    public int f25472l;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f25471k = obj;
        this.f25472l |= Integer.MIN_VALUE;
        return _FileSystemKt.collectRecursively(null, null, null, null, false, false, this);
    }
}
