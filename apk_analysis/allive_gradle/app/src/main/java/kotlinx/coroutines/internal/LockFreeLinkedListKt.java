package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p000.oa2;

@Metadata(m5568d1 = {"\u0000\u0018\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\u001a\u0017\u0010\u0003\u001a\u00060\u0001j\u0002`\u0002*\u00020\u0000H\u0001¢\u0006\u0004\b\u0003\u0010\u0004\"\u001a\u0010\u0006\u001a\u00020\u00058\u0000X\u0081T¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u0012\u0004\b\b\u0010\t\"\u001a\u0010\n\u001a\u00020\u00058\u0000X\u0081T¢\u0006\f\n\u0004\b\n\u0010\u0007\u0012\u0004\b\u000b\u0010\t\"\u001a\u0010\f\u001a\u00020\u00058\u0000X\u0081T¢\u0006\f\n\u0004\b\f\u0010\u0007\u0012\u0004\b\r\u0010\t\" \u0010\u0013\u001a\u00020\u00008\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u0012\u0004\b\u0012\u0010\t\u001a\u0004\b\u0010\u0010\u0011*\f\b\u0002\u0010\u0014\"\u00020\u00012\u00020\u0001¨\u0006\u0015"}, m5569d2 = {"", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "unwrap", "(Ljava/lang/Object;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "", "UNDECIDED", "I", "getUNDECIDED$annotations", "()V", "SUCCESS", "getSUCCESS$annotations", "FAILURE", "getFAILURE$annotations", "a", "Ljava/lang/Object;", "getCONDITION_FALSE", "()Ljava/lang/Object;", "getCONDITION_FALSE$annotations", "CONDITION_FALSE", "Node", "kotlinx-coroutines-core"}, m5570k = 2, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class LockFreeLinkedListKt {
    public static final int FAILURE = 2;
    public static final int SUCCESS = 1;
    public static final int UNDECIDED = 0;

    /* renamed from: a */
    public static final Symbol f22022a = new Symbol("CONDITION_FALSE");

    @NotNull
    public static final Object getCONDITION_FALSE() {
        return f22022a;
    }

    @PublishedApi
    public static /* synthetic */ void getCONDITION_FALSE$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void getFAILURE$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void getSUCCESS$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void getUNDECIDED$annotations() {
    }

    @PublishedApi
    @NotNull
    public static final LockFreeLinkedListNode unwrap(@NotNull Object obj) {
        oa2 oa2Var;
        LockFreeLinkedListNode lockFreeLinkedListNode;
        if (obj instanceof oa2) {
            oa2Var = (oa2) obj;
        } else {
            oa2Var = null;
        }
        if (oa2Var == null || (lockFreeLinkedListNode = oa2Var.f23684a) == null) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
            return (LockFreeLinkedListNode) obj;
        }
        return lockFreeLinkedListNode;
    }
}
