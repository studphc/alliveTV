package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.JvmField;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.InternalCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.oa2;

@InternalCoroutinesApi
@Metadata(m5568d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u0001:\u00012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\n\u001a\u00020\t2\n\u0010\u0005\u001a\u00060\u0000j\u0002`\u00042\u000e\b\u0004\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0081\b¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\f\u001a\u00020\u00072\n\u0010\u0005\u001a\u00060\u0000j\u0002`\u0004¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000f\u001a\u00020\u000e2\n\u0010\u0005\u001a\u00060\u0000j\u0002`\u0004¢\u0006\u0004\b\u000f\u0010\u0010J,\u0010\u0011\u001a\u00020\u00072\n\u0010\u0005\u001a\u00060\u0000j\u0002`\u00042\u000e\b\u0004\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0086\b¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0014\u001a\u00020\u00072\n\u0010\u0005\u001a\u00060\u0000j\u0002`\u00042\n\u0010\u0013\u001a\u00060\u0000j\u0002`\u0004H\u0001¢\u0006\u0004\b\u0014\u0010\u0015J/\u0010\u0018\u001a\u00020\u00172\n\u0010\u0005\u001a\u00060\u0000j\u0002`\u00042\n\u0010\u0013\u001a\u00060\u0000j\u0002`\u00042\u0006\u0010\u0016\u001a\u00020\tH\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0004H\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0004H\u0014¢\u0006\u0004\b\u001e\u0010\u001dJ'\u0010\"\u001a\u00020\u000e2\n\u0010\u001f\u001a\u00060\u0000j\u0002`\u00042\n\u0010\u0013\u001a\u00060\u0000j\u0002`\u0004H\u0000¢\u0006\u0004\b \u0010!J\u000f\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u001bR\u0011\u0010\u0013\u001a\u00020\u00018F¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0015\u0010*\u001a\u00060\u0000j\u0002`\u00048F¢\u0006\u0006\u001a\u0004\b)\u0010\u001dR\u0015\u0010,\u001a\u00060\u0000j\u0002`\u00048F¢\u0006\u0006\u001a\u0004\b+\u0010\u001dR\u0011\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00010-8\u0002X\u0082\u0004R\u0011\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00000-8\u0002X\u0082\u0004R\u0013\u00101\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001000-8\u0002X\u0082\u0004¨\u00063"}, m5569d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "", "<init>", "()V", "Lkotlinx/coroutines/internal/Node;", "node", "Lkotlin/Function0;", "", "condition", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "makeCondAddOp", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlin/jvm/functions/Function0;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "addOneIfEmpty", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Z", "", "addLast", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "addLastIf", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlin/jvm/functions/Function0;)Z", "next", "addNext", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Z", "condAdd", "", "tryCondAddNext", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;)I", "remove", "()Z", "removeOrNext", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "nextIfRemoved", "prev", "validateNode$kotlinx_coroutines_core", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "validateNode", "", "toString", "()Ljava/lang/String;", "isRemoved", "getNext", "()Ljava/lang/Object;", "getNextNode", "nextNode", "getPrevNode", "prevNode", "Lkotlinx/atomicfu/AtomicRef;", "_next", "_prev", "Loa2;", "_removedRef", "CondAddOp", "kotlinx-coroutines-core"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nLockFreeLinkedList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LockFreeLinkedList.kt\nkotlinx/coroutines/internal/LockFreeLinkedListNode\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,367:1\n73#1,3:369\n1#2:368\n*S KotlinDebug\n*F\n+ 1 LockFreeLinkedList.kt\nkotlinx/coroutines/internal/LockFreeLinkedListNode\n*L\n134#1:369,3\n*E\n"})
/* loaded from: classes2.dex */
public class LockFreeLinkedListNode {

    /* renamed from: a */
    public static final AtomicReferenceFieldUpdater f22023a = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_next");

    /* renamed from: b */
    public static final AtomicReferenceFieldUpdater f22024b = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_prev");

    /* renamed from: c */
    public static final AtomicReferenceFieldUpdater f22025c = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_removedRef");

    @Volatile
    @Nullable
    private volatile Object _next = this;

    @Volatile
    @Nullable
    private volatile Object _prev = this;

    @Volatile
    @Nullable
    private volatile Object _removedRef;

    @Metadata(m5568d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\b!\u0018\u00002\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001B\u0011\u0012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0002\u0010\u0005J\u001e\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u00060\u0002j\u0002`\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016R\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, m5569d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "Lkotlinx/coroutines/internal/AtomicOp;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "newNode", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "oldNext", "complete", "", "affected", "failure", "", "kotlinx-coroutines-core"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
    @PublishedApi
    /* loaded from: classes2.dex */
    public static abstract class CondAddOp extends AtomicOp<LockFreeLinkedListNode> {

        @JvmField
        @NotNull
        public final LockFreeLinkedListNode newNode;

        @JvmField
        @Nullable
        public LockFreeLinkedListNode oldNext;

        public CondAddOp(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode) {
            this.newNode = lockFreeLinkedListNode;
        }

        @Override // kotlinx.coroutines.internal.AtomicOp
        public void complete(@NotNull LockFreeLinkedListNode affected, @Nullable Object failure) {
            boolean z = failure == null;
            LockFreeLinkedListNode lockFreeLinkedListNode = z ? this.newNode : this.oldNext;
            if (lockFreeLinkedListNode != null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = LockFreeLinkedListNode.f22023a;
                while (!atomicReferenceFieldUpdater.compareAndSet(affected, this, lockFreeLinkedListNode)) {
                    if (atomicReferenceFieldUpdater.get(affected) != this) {
                        return;
                    }
                }
                if (z) {
                    LockFreeLinkedListNode lockFreeLinkedListNode2 = this.newNode;
                    LockFreeLinkedListNode lockFreeLinkedListNode3 = this.oldNext;
                    Intrinsics.checkNotNull(lockFreeLinkedListNode3);
                    lockFreeLinkedListNode2.m5732b(lockFreeLinkedListNode3);
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x003e, code lost:
    
        r6 = ((p000.oa2) r6).f23684a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0046, code lost:
    
        if (r5.compareAndSet(r4, r3, r6) == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004e, code lost:
    
        if (r5.get(r4) == r3) goto L51;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final LockFreeLinkedListNode m5731a() {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f22024b;
            LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) atomicReferenceFieldUpdater.get(this);
            LockFreeLinkedListNode lockFreeLinkedListNode2 = lockFreeLinkedListNode;
            while (true) {
                LockFreeLinkedListNode lockFreeLinkedListNode3 = null;
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f22023a;
                    Object obj = atomicReferenceFieldUpdater2.get(lockFreeLinkedListNode2);
                    if (obj == this) {
                        if (lockFreeLinkedListNode == lockFreeLinkedListNode2) {
                            return lockFreeLinkedListNode2;
                        }
                        while (!atomicReferenceFieldUpdater.compareAndSet(this, lockFreeLinkedListNode, lockFreeLinkedListNode2)) {
                            if (atomicReferenceFieldUpdater.get(this) != lockFreeLinkedListNode) {
                                break;
                            }
                        }
                        return lockFreeLinkedListNode2;
                    }
                    if (isRemoved()) {
                        return null;
                    }
                    if (obj == null) {
                        return lockFreeLinkedListNode2;
                    }
                    if (obj instanceof OpDescriptor) {
                        ((OpDescriptor) obj).perform(lockFreeLinkedListNode2);
                        break;
                    }
                    if (obj instanceof oa2) {
                        if (lockFreeLinkedListNode3 != null) {
                            break;
                        }
                        lockFreeLinkedListNode2 = (LockFreeLinkedListNode) atomicReferenceFieldUpdater.get(lockFreeLinkedListNode2);
                    } else {
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
                        lockFreeLinkedListNode3 = lockFreeLinkedListNode2;
                        lockFreeLinkedListNode2 = (LockFreeLinkedListNode) obj;
                    }
                }
                lockFreeLinkedListNode2 = lockFreeLinkedListNode3;
            }
        }
    }

    public final void addLast(@NotNull LockFreeLinkedListNode node) {
        do {
        } while (!getPrevNode().addNext(node, this));
    }

    public final boolean addLastIf(@NotNull LockFreeLinkedListNode node, @NotNull Function0<Boolean> condition) {
        int tryCondAddNext;
        LockFreeLinkedListNode$makeCondAddOp$1 lockFreeLinkedListNode$makeCondAddOp$1 = new LockFreeLinkedListNode$makeCondAddOp$1(node, condition);
        do {
            tryCondAddNext = getPrevNode().tryCondAddNext(node, this, lockFreeLinkedListNode$makeCondAddOp$1);
            if (tryCondAddNext == 1) {
                return true;
            }
        } while (tryCondAddNext != 2);
        return false;
    }

    @PublishedApi
    public final boolean addNext(@NotNull LockFreeLinkedListNode node, @NotNull LockFreeLinkedListNode next) {
        f22024b.lazySet(node, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f22023a;
        atomicReferenceFieldUpdater.lazySet(node, next);
        while (!atomicReferenceFieldUpdater.compareAndSet(this, next, node)) {
            if (atomicReferenceFieldUpdater.get(this) != next) {
                return false;
            }
        }
        node.m5732b(next);
        return true;
    }

    public final boolean addOneIfEmpty(@NotNull LockFreeLinkedListNode node) {
        f22024b.lazySet(node, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f22023a;
        atomicReferenceFieldUpdater.lazySet(node, this);
        while (getNext() == this) {
            while (!atomicReferenceFieldUpdater.compareAndSet(this, this, node)) {
                if (atomicReferenceFieldUpdater.get(this) != this) {
                    break;
                }
            }
            node.m5732b(this);
            return true;
        }
        return false;
    }

    /* renamed from: b */
    public final void m5732b(LockFreeLinkedListNode lockFreeLinkedListNode) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f22024b;
            LockFreeLinkedListNode lockFreeLinkedListNode2 = (LockFreeLinkedListNode) atomicReferenceFieldUpdater.get(lockFreeLinkedListNode);
            if (getNext() != lockFreeLinkedListNode) {
                return;
            }
            while (!atomicReferenceFieldUpdater.compareAndSet(lockFreeLinkedListNode, lockFreeLinkedListNode2, this)) {
                if (atomicReferenceFieldUpdater.get(lockFreeLinkedListNode) != lockFreeLinkedListNode2) {
                    break;
                }
            }
            if (isRemoved()) {
                lockFreeLinkedListNode.m5731a();
                return;
            }
            return;
        }
    }

    @NotNull
    public final Object getNext() {
        while (true) {
            Object obj = f22023a.get(this);
            if (!(obj instanceof OpDescriptor)) {
                return obj;
            }
            ((OpDescriptor) obj).perform(this);
        }
    }

    @NotNull
    public final LockFreeLinkedListNode getNextNode() {
        return LockFreeLinkedListKt.unwrap(getNext());
    }

    @NotNull
    public final LockFreeLinkedListNode getPrevNode() {
        LockFreeLinkedListNode m5731a = m5731a();
        if (m5731a == null) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f22024b;
            Object obj = atomicReferenceFieldUpdater.get(this);
            while (true) {
                m5731a = (LockFreeLinkedListNode) obj;
                if (!m5731a.isRemoved()) {
                    break;
                }
                obj = atomicReferenceFieldUpdater.get(m5731a);
            }
        }
        return m5731a;
    }

    public boolean isRemoved() {
        return getNext() instanceof oa2;
    }

    @PublishedApi
    @NotNull
    public final CondAddOp makeCondAddOp(@NotNull LockFreeLinkedListNode node, @NotNull Function0<Boolean> condition) {
        return new LockFreeLinkedListNode$makeCondAddOp$1(node, condition);
    }

    @Nullable
    public LockFreeLinkedListNode nextIfRemoved() {
        oa2 oa2Var;
        Object next = getNext();
        if (next instanceof oa2) {
            oa2Var = (oa2) next;
        } else {
            oa2Var = null;
        }
        if (oa2Var == null) {
            return null;
        }
        return oa2Var.f23684a;
    }

    /* renamed from: remove */
    public boolean mo8899remove() {
        if (removeOrNext() == null) {
            return true;
        }
        return false;
    }

    @PublishedApi
    @Nullable
    public final LockFreeLinkedListNode removeOrNext() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        while (true) {
            Object next = getNext();
            if (next instanceof oa2) {
                return ((oa2) next).f23684a;
            }
            if (next == this) {
                return (LockFreeLinkedListNode) next;
            }
            Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
            LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) next;
            lockFreeLinkedListNode.getClass();
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f22025c;
            oa2 oa2Var = (oa2) atomicReferenceFieldUpdater2.get(lockFreeLinkedListNode);
            if (oa2Var == null) {
                oa2Var = new oa2(lockFreeLinkedListNode);
                atomicReferenceFieldUpdater2.lazySet(lockFreeLinkedListNode, oa2Var);
            }
            do {
                atomicReferenceFieldUpdater = f22023a;
                if (atomicReferenceFieldUpdater.compareAndSet(this, next, oa2Var)) {
                    lockFreeLinkedListNode.m5731a();
                    return null;
                }
            } while (atomicReferenceFieldUpdater.get(this) == next);
        }
    }

    @NotNull
    public String toString() {
        return new PropertyReference0Impl(this, DebugStringsKt.class, "classSimpleName", "getClassSimpleName(Ljava/lang/Object;)Ljava/lang/String;", 1) + '@' + DebugStringsKt.getHexAddress(this);
    }

    @PublishedApi
    public final int tryCondAddNext(@NotNull LockFreeLinkedListNode node, @NotNull LockFreeLinkedListNode next, @NotNull CondAddOp condAdd) {
        f22024b.lazySet(node, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f22023a;
        atomicReferenceFieldUpdater.lazySet(node, next);
        condAdd.oldNext = next;
        while (!atomicReferenceFieldUpdater.compareAndSet(this, next, condAdd)) {
            if (atomicReferenceFieldUpdater.get(this) != next) {
                return 0;
            }
        }
        if (condAdd.perform(this) == null) {
            return 1;
        }
        return 2;
    }

    public final void validateNode$kotlinx_coroutines_core(@NotNull LockFreeLinkedListNode prev, @NotNull LockFreeLinkedListNode next) {
    }
}
