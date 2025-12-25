package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.activity.BackEventCompat;
import androidx.annotation.CallSuper;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.fragment.R;
import androidx.fragment.app.C0266u;
import androidx.fragment.app.SpecialEffectsController;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.AbstractC1327iq;
import p000.AbstractC1726qj;
import p000.am2;
import p000.jt0;
import p000.wd0;
import p000.ye0;

@Metadata(m5568d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\b \u0018\u0000 52\u00020\u0001:\u00045678B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0012\u0010\u0011J\u0015\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0013\u0010\u0011J\u0015\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0018\u001a\u00020\r¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001a\u001a\u00020\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001c\u001a\u00020\r¢\u0006\u0004\b\u001c\u0010\u0019J\r\u0010\u001d\u001a\u00020\r¢\u0006\u0004\b\u001d\u0010\u0019J\u0017\u0010\"\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u001eH\u0000¢\u0006\u0004\b \u0010!J\r\u0010#\u001a\u00020\r¢\u0006\u0004\b#\u0010\u0019J*\u0010'\u001a\u00020\r2\u0011\u0010&\u001a\r\u0012\t\u0012\u00070\u001e¢\u0006\u0002\b%0$2\u0006\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b'\u0010(J\"\u0010+\u001a\u00020\r2\u0011\u0010&\u001a\r\u0012\t\u0012\u00070\u001e¢\u0006\u0002\b%0$H\u0010¢\u0006\u0004\b)\u0010*J\u0015\u0010.\u001a\u00020\r2\u0006\u0010-\u001a\u00020,¢\u0006\u0004\b.\u0010/J\r\u00100\u001a\u00020\r¢\u0006\u0004\b0\u0010\u0019R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104¨\u00069"}, m5569d2 = {"Landroidx/fragment/app/SpecialEffectsController;", "", "Landroid/view/ViewGroup;", "container", "<init>", "(Landroid/view/ViewGroup;)V", "Landroidx/fragment/app/s;", "fragmentStateManager", "Landroidx/fragment/app/SpecialEffectsController$Operation$LifecycleImpact;", "getAwaitingCompletionLifecycleImpact", "(Landroidx/fragment/app/s;)Landroidx/fragment/app/SpecialEffectsController$Operation$LifecycleImpact;", "Landroidx/fragment/app/SpecialEffectsController$Operation$State;", "finalState", "", "enqueueAdd", "(Landroidx/fragment/app/SpecialEffectsController$Operation$State;Landroidx/fragment/app/s;)V", "enqueueShow", "(Landroidx/fragment/app/s;)V", "enqueueHide", "enqueueRemove", "", "isPop", "updateOperationDirection", "(Z)V", "markPostponedState", "()V", "isPendingExecute", "()Z", "forcePostponedExecutePendingOperations", "executePendingOperations", "Landroidx/fragment/app/SpecialEffectsController$Operation;", "operation", "applyContainerChangesToOperation$fragment_release", "(Landroidx/fragment/app/SpecialEffectsController$Operation;)V", "applyContainerChangesToOperation", "forceCompleteAllOperations", "", "Lkotlin/jvm/JvmSuppressWildcards;", "operations", "collectEffects", "(Ljava/util/List;Z)V", "commitEffects$fragment_release", "(Ljava/util/List;)V", "commitEffects", "Landroidx/activity/BackEventCompat;", "backEvent", "processProgress", "(Landroidx/activity/BackEventCompat;)V", "completeBack", "a", "Landroid/view/ViewGroup;", "getContainer", "()Landroid/view/ViewGroup;", "Companion", "Effect", "androidx/fragment/app/u", "Operation", "fragment_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nSpecialEffectsController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpecialEffectsController.kt\nandroidx/fragment/app/SpecialEffectsController\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,900:1\n288#2,2:901\n288#2,2:903\n533#2,6:905\n1855#2,2:911\n1855#2:913\n1726#2,3:914\n1856#2:917\n1360#2:918\n1446#2,5:919\n1360#2:924\n1446#2,5:925\n1360#2:930\n1446#2,5:931\n1360#2:936\n1446#2,5:937\n*S KotlinDebug\n*F\n+ 1 SpecialEffectsController.kt\nandroidx/fragment/app/SpecialEffectsController\n*L\n67#1:901,2\n73#1:903,2\n170#1:905,6\n306#1:911,2\n316#1:913\n319#1:914,3\n316#1:917\n321#1:918\n321#1:919,5\n423#1:924\n423#1:925,5\n451#1:930\n451#1:931,5\n467#1:936\n467#1:937,5\n*E\n"})
/* loaded from: classes.dex */
public abstract class SpecialEffectsController {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: from kotlin metadata */
    public final ViewGroup container;

    /* renamed from: b */
    public final ArrayList f4625b;

    /* renamed from: c */
    public final ArrayList f4626c;

    /* renamed from: d */
    public boolean f4627d;

    /* renamed from: e */
    public boolean f4628e;

    /* renamed from: f */
    public boolean f4629f;

    @Metadata(m5568d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0010\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\bJ\u001f\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\bJ\u0015\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\bJ\u0017\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\bR\u001a\u0010\u0012\u001a\u00020\u00118\u0016X\u0096D¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014¨\u0006\u0015"}, m5569d2 = {"Landroidx/fragment/app/SpecialEffectsController$Effect;", "", "<init>", "()V", "Landroid/view/ViewGroup;", "container", "", "performStart", "(Landroid/view/ViewGroup;)V", "onStart", "Landroidx/activity/BackEventCompat;", "backEvent", "onProgress", "(Landroidx/activity/BackEventCompat;Landroid/view/ViewGroup;)V", "onCommit", "cancel", "onCancel", "", "isSeekingSupported", "Z", "()Z", "fragment_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
    /* loaded from: classes.dex */
    public static class Effect {

        /* renamed from: a */
        public boolean f4630a;

        /* renamed from: b */
        public boolean f4631b;

        public final void cancel(@NotNull ViewGroup container) {
            Intrinsics.checkNotNullParameter(container, "container");
            if (!this.f4631b) {
                onCancel(container);
            }
            this.f4631b = true;
        }

        public boolean isSeekingSupported() {
            return false;
        }

        public void onCancel(@NotNull ViewGroup container) {
            Intrinsics.checkNotNullParameter(container, "container");
        }

        public void onCommit(@NotNull ViewGroup container) {
            Intrinsics.checkNotNullParameter(container, "container");
        }

        public void onProgress(@NotNull BackEventCompat backEvent, @NotNull ViewGroup container) {
            Intrinsics.checkNotNullParameter(backEvent, "backEvent");
            Intrinsics.checkNotNullParameter(container, "container");
        }

        public void onStart(@NotNull ViewGroup container) {
            Intrinsics.checkNotNullParameter(container, "container");
        }

        public final void performStart(@NotNull ViewGroup container) {
            Intrinsics.checkNotNullParameter(container, "container");
            if (!this.f4630a) {
                onStart(container);
            }
            this.f4630a = true;
        }
    }

    @Metadata(m5568d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010 \n\u0002\b\b\b\u0010\u0018\u00002\u00020\u0001:\u0002HIB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001c\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\u000fH\u0017¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010 \u001a\u00020\u000fH\u0011¢\u0006\u0004\b\u001f\u0010\u001eR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R$\u00105\u001a\u0002012\u0006\u00102\u001a\u0002018\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R$\u00108\u001a\u0002012\u0006\u00102\u001a\u0002018\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b7\u00104\u001a\u0004\b8\u00106R*\u0010:\u001a\u0002012\u0006\u00102\u001a\u0002018\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u00104\u001a\u0004\b:\u00106\"\u0004\b;\u0010<R$\u0010>\u001a\u0002012\u0006\u00102\u001a\u0002018\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b=\u00104\u001a\u0004\b>\u00106R\"\u0010@\u001a\u0002018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b?\u00104\u001a\u0004\b@\u00106\"\u0004\bA\u0010<R \u0010G\u001a\b\u0012\u0004\u0012\u00020\u00180B8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F¨\u0006J"}, m5569d2 = {"Landroidx/fragment/app/SpecialEffectsController$Operation;", "", "Landroidx/fragment/app/SpecialEffectsController$Operation$State;", "finalState", "Landroidx/fragment/app/SpecialEffectsController$Operation$LifecycleImpact;", "lifecycleImpact", "Landroidx/fragment/app/Fragment;", "fragment", "<init>", "(Landroidx/fragment/app/SpecialEffectsController$Operation$State;Landroidx/fragment/app/SpecialEffectsController$Operation$LifecycleImpact;Landroidx/fragment/app/Fragment;)V", "", "toString", "()Ljava/lang/String;", "Landroid/view/ViewGroup;", "container", "", "cancel", "(Landroid/view/ViewGroup;)V", "mergeWith", "(Landroidx/fragment/app/SpecialEffectsController$Operation$State;Landroidx/fragment/app/SpecialEffectsController$Operation$LifecycleImpact;)V", "Ljava/lang/Runnable;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "addCompletionListener", "(Ljava/lang/Runnable;)V", "Landroidx/fragment/app/SpecialEffectsController$Effect;", "effect", "addEffect", "(Landroidx/fragment/app/SpecialEffectsController$Effect;)V", "completeEffect", "onStart", "()V", "complete$fragment_release", "complete", "a", "Landroidx/fragment/app/SpecialEffectsController$Operation$State;", "getFinalState", "()Landroidx/fragment/app/SpecialEffectsController$Operation$State;", "setFinalState", "(Landroidx/fragment/app/SpecialEffectsController$Operation$State;)V", "b", "Landroidx/fragment/app/SpecialEffectsController$Operation$LifecycleImpact;", "getLifecycleImpact", "()Landroidx/fragment/app/SpecialEffectsController$Operation$LifecycleImpact;", "setLifecycleImpact", "(Landroidx/fragment/app/SpecialEffectsController$Operation$LifecycleImpact;)V", "c", "Landroidx/fragment/app/Fragment;", "getFragment", "()Landroidx/fragment/app/Fragment;", "", "<set-?>", "e", "Z", "isCanceled", "()Z", "f", "isComplete", "g", "isSeeking", "setSeeking$fragment_release", "(Z)V", "h", "isStarted", "i", "isAwaitingContainerChanges", "setAwaitingContainerChanges", "", "k", "Ljava/util/List;", "getEffects$fragment_release", "()Ljava/util/List;", "effects", "LifecycleImpact", "State", "fragment_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
    @SourceDebugExtension({"SMAP\nSpecialEffectsController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpecialEffectsController.kt\nandroidx/fragment/app/SpecialEffectsController$Operation\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,900:1\n1855#2,2:901\n1855#2,2:903\n*S KotlinDebug\n*F\n+ 1 SpecialEffectsController.kt\nandroidx/fragment/app/SpecialEffectsController$Operation\n*L\n671#1:901,2\n761#1:903,2\n*E\n"})
    /* loaded from: classes.dex */
    public static class Operation {

        /* renamed from: a, reason: from kotlin metadata */
        public State finalState;

        /* renamed from: b, reason: from kotlin metadata */
        public LifecycleImpact lifecycleImpact;

        /* renamed from: c, reason: from kotlin metadata */
        public final Fragment fragment;

        /* renamed from: d */
        public final ArrayList f4635d;

        /* renamed from: e, reason: from kotlin metadata */
        public boolean isCanceled;

        /* renamed from: f, reason: from kotlin metadata */
        public boolean isComplete;

        /* renamed from: g, reason: from kotlin metadata */
        public boolean isSeeking;

        /* renamed from: h, reason: from kotlin metadata */
        public boolean isStarted;

        /* renamed from: i, reason: from kotlin metadata */
        public boolean isAwaitingContainerChanges;

        /* renamed from: j */
        public final ArrayList f4641j;

        /* renamed from: k */
        public final ArrayList f4642k;

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        @Metadata(m5568d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, m5569d2 = {"Landroidx/fragment/app/SpecialEffectsController$Operation$LifecycleImpact;", "", "NONE", "ADDING", "REMOVING", "fragment_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
        /* loaded from: classes.dex */
        public static final class LifecycleImpact {
            public static final LifecycleImpact ADDING;
            public static final LifecycleImpact NONE;
            public static final LifecycleImpact REMOVING;

            /* renamed from: a */
            public static final /* synthetic */ LifecycleImpact[] f4643a;

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Enum, androidx.fragment.app.SpecialEffectsController$Operation$LifecycleImpact] */
            /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Enum, androidx.fragment.app.SpecialEffectsController$Operation$LifecycleImpact] */
            /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Enum, androidx.fragment.app.SpecialEffectsController$Operation$LifecycleImpact] */
            static {
                ?? r3 = new Enum("NONE", 0);
                NONE = r3;
                ?? r4 = new Enum("ADDING", 1);
                ADDING = r4;
                ?? r5 = new Enum("REMOVING", 2);
                REMOVING = r5;
                f4643a = new LifecycleImpact[]{r3, r4, r5};
            }

            public static LifecycleImpact valueOf(String str) {
                return (LifecycleImpact) Enum.valueOf(LifecycleImpact.class, str);
            }

            public static LifecycleImpact[] values() {
                return (LifecycleImpact[]) f4643a.clone();
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        @Metadata(m5568d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0080\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, m5569d2 = {"Landroidx/fragment/app/SpecialEffectsController$Operation$State;", "", "Landroid/view/View;", "view", "Landroid/view/ViewGroup;", "container", "", "applyState", "(Landroid/view/View;Landroid/view/ViewGroup;)V", "Companion", "REMOVED", "VISIBLE", "GONE", "INVISIBLE", "fragment_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
        /* loaded from: classes.dex */
        public static final class State {

            /* renamed from: Companion, reason: from kotlin metadata */
            @NotNull
            public static final Companion INSTANCE;
            public static final State GONE;
            public static final State INVISIBLE;
            public static final State REMOVED;
            public static final State VISIBLE;

            /* renamed from: a */
            public static final /* synthetic */ State[] f4644a;

            @Metadata(m5568d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0011\u0010\u0004\u001a\u00020\u0003*\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, m5569d2 = {"Landroidx/fragment/app/SpecialEffectsController$Operation$State$Companion;", "", "Landroid/view/View;", "Landroidx/fragment/app/SpecialEffectsController$Operation$State;", "asOperationState", "(Landroid/view/View;)Landroidx/fragment/app/SpecialEffectsController$Operation$State;", "", "visibility", TypedValues.TransitionType.S_FROM, "(I)Landroidx/fragment/app/SpecialEffectsController$Operation$State;", "fragment_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
            /* loaded from: classes.dex */
            public static final class Companion {
                public Companion(DefaultConstructorMarker defaultConstructorMarker) {
                }

                @NotNull
                public final State asOperationState(@NotNull View view) {
                    Intrinsics.checkNotNullParameter(view, "<this>");
                    if (view.getAlpha() == RecyclerView.f7068F0 && view.getVisibility() == 0) {
                        return State.INVISIBLE;
                    }
                    return from(view.getVisibility());
                }

                @JvmStatic
                @NotNull
                public final State from(int visibility) {
                    if (visibility != 0) {
                        if (visibility != 4) {
                            if (visibility == 8) {
                                return State.GONE;
                            }
                            throw new IllegalArgumentException(ye0.m8291k(visibility, "Unknown visibility "));
                        }
                        return State.INVISIBLE;
                    }
                    return State.VISIBLE;
                }
            }

            @Metadata(m5570k = 3, m5571mv = {1, 8, 0}, m5573xi = 48)
            /* loaded from: classes.dex */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[State.values().length];
                    try {
                        iArr[State.REMOVED.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[State.VISIBLE.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[State.GONE.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[State.INVISIBLE.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.Enum, androidx.fragment.app.SpecialEffectsController$Operation$State] */
            /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Enum, androidx.fragment.app.SpecialEffectsController$Operation$State] */
            /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.Enum, androidx.fragment.app.SpecialEffectsController$Operation$State] */
            /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Enum, androidx.fragment.app.SpecialEffectsController$Operation$State] */
            static {
                ?? r4 = new Enum("REMOVED", 0);
                REMOVED = r4;
                ?? r5 = new Enum("VISIBLE", 1);
                VISIBLE = r5;
                ?? r6 = new Enum("GONE", 2);
                GONE = r6;
                ?? r7 = new Enum("INVISIBLE", 3);
                INVISIBLE = r7;
                f4644a = new State[]{r4, r5, r6, r7};
                INSTANCE = new Companion(null);
            }

            @JvmStatic
            @NotNull
            public static final State from(int i) {
                return INSTANCE.from(i);
            }

            public static State valueOf(String str) {
                return (State) Enum.valueOf(State.class, str);
            }

            public static State[] values() {
                return (State[]) f4644a.clone();
            }

            public final void applyState(@NotNull View view, @NotNull ViewGroup container) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(container, "container");
                int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
                ViewGroup viewGroup = null;
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i == 4) {
                                if (FragmentManager.isLoggingEnabled(2)) {
                                    Log.v(FragmentManager.TAG, "SpecialEffectsController: Setting view " + view + " to INVISIBLE");
                                }
                                view.setVisibility(4);
                                return;
                            }
                            return;
                        }
                        if (FragmentManager.isLoggingEnabled(2)) {
                            Log.v(FragmentManager.TAG, "SpecialEffectsController: Setting view " + view + " to GONE");
                        }
                        view.setVisibility(8);
                        return;
                    }
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v(FragmentManager.TAG, "SpecialEffectsController: Setting view " + view + " to VISIBLE");
                    }
                    ViewParent parent = view.getParent();
                    if (parent instanceof ViewGroup) {
                        viewGroup = (ViewGroup) parent;
                    }
                    if (viewGroup == null) {
                        if (FragmentManager.isLoggingEnabled(2)) {
                            Log.v(FragmentManager.TAG, "SpecialEffectsController: Adding view " + view + " to Container " + container);
                        }
                        container.addView(view);
                    }
                    view.setVisibility(0);
                    return;
                }
                ViewParent parent2 = view.getParent();
                if (parent2 instanceof ViewGroup) {
                    viewGroup = (ViewGroup) parent2;
                }
                if (viewGroup != null) {
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v(FragmentManager.TAG, "SpecialEffectsController: Removing view " + view + " from container " + viewGroup);
                    }
                    viewGroup.removeView(view);
                }
            }
        }

        @Metadata(m5570k = 3, m5571mv = {1, 8, 0}, m5573xi = 48)
        /* loaded from: classes.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[LifecycleImpact.values().length];
                try {
                    iArr[LifecycleImpact.ADDING.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[LifecycleImpact.REMOVING.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[LifecycleImpact.NONE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public Operation(@NotNull State finalState, @NotNull LifecycleImpact lifecycleImpact, @NotNull Fragment fragment) {
            Intrinsics.checkNotNullParameter(finalState, "finalState");
            Intrinsics.checkNotNullParameter(lifecycleImpact, "lifecycleImpact");
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            this.finalState = finalState;
            this.lifecycleImpact = lifecycleImpact;
            this.fragment = fragment;
            this.f4635d = new ArrayList();
            this.isAwaitingContainerChanges = true;
            ArrayList arrayList = new ArrayList();
            this.f4641j = arrayList;
            this.f4642k = arrayList;
        }

        public final void addCompletionListener(@NotNull Runnable listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.f4635d.add(listener);
        }

        public final void addEffect(@NotNull Effect effect) {
            Intrinsics.checkNotNullParameter(effect, "effect");
            this.f4641j.add(effect);
        }

        public final void cancel(@NotNull ViewGroup container) {
            Intrinsics.checkNotNullParameter(container, "container");
            this.isStarted = false;
            if (this.isCanceled) {
                return;
            }
            this.isCanceled = true;
            if (this.f4641j.isEmpty()) {
                complete$fragment_release();
                return;
            }
            Iterator it = CollectionsKt___CollectionsKt.toList(this.f4642k).iterator();
            while (it.hasNext()) {
                ((Effect) it.next()).cancel(container);
            }
        }

        @CallSuper
        public void complete$fragment_release() {
            this.isStarted = false;
            if (this.isComplete) {
                return;
            }
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v(FragmentManager.TAG, "SpecialEffectsController: " + this + " has called complete.");
            }
            this.isComplete = true;
            Iterator it = this.f4635d.iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
        }

        public final void completeEffect(@NotNull Effect effect) {
            Intrinsics.checkNotNullParameter(effect, "effect");
            ArrayList arrayList = this.f4641j;
            if (arrayList.remove(effect) && arrayList.isEmpty()) {
                complete$fragment_release();
            }
        }

        @NotNull
        public final List<Effect> getEffects$fragment_release() {
            return this.f4642k;
        }

        @NotNull
        public final State getFinalState() {
            return this.finalState;
        }

        @NotNull
        public final Fragment getFragment() {
            return this.fragment;
        }

        @NotNull
        public final LifecycleImpact getLifecycleImpact() {
            return this.lifecycleImpact;
        }

        /* renamed from: isAwaitingContainerChanges, reason: from getter */
        public final boolean getIsAwaitingContainerChanges() {
            return this.isAwaitingContainerChanges;
        }

        /* renamed from: isCanceled, reason: from getter */
        public final boolean getIsCanceled() {
            return this.isCanceled;
        }

        /* renamed from: isComplete, reason: from getter */
        public final boolean getIsComplete() {
            return this.isComplete;
        }

        /* renamed from: isSeeking, reason: from getter */
        public final boolean getIsSeeking() {
            return this.isSeeking;
        }

        /* renamed from: isStarted, reason: from getter */
        public final boolean getIsStarted() {
            return this.isStarted;
        }

        public final void mergeWith(@NotNull State finalState, @NotNull LifecycleImpact lifecycleImpact) {
            Intrinsics.checkNotNullParameter(finalState, "finalState");
            Intrinsics.checkNotNullParameter(lifecycleImpact, "lifecycleImpact");
            int i = WhenMappings.$EnumSwitchMapping$0[lifecycleImpact.ordinal()];
            Fragment fragment = this.fragment;
            if (i != 1) {
                if (i != 2) {
                    if (i == 3 && this.finalState != State.REMOVED) {
                        if (FragmentManager.isLoggingEnabled(2)) {
                            Log.v(FragmentManager.TAG, "SpecialEffectsController: For fragment " + fragment + " mFinalState = " + this.finalState + " -> " + finalState + '.');
                        }
                        this.finalState = finalState;
                        return;
                    }
                    return;
                }
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v(FragmentManager.TAG, "SpecialEffectsController: For fragment " + fragment + " mFinalState = " + this.finalState + " -> REMOVED. mLifecycleImpact  = " + this.lifecycleImpact + " to REMOVING.");
                }
                this.finalState = State.REMOVED;
                this.lifecycleImpact = LifecycleImpact.REMOVING;
                this.isAwaitingContainerChanges = true;
                return;
            }
            if (this.finalState == State.REMOVED) {
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v(FragmentManager.TAG, "SpecialEffectsController: For fragment " + fragment + " mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = " + this.lifecycleImpact + " to ADDING.");
                }
                this.finalState = State.VISIBLE;
                this.lifecycleImpact = LifecycleImpact.ADDING;
                this.isAwaitingContainerChanges = true;
            }
        }

        @CallSuper
        public void onStart() {
            this.isStarted = true;
        }

        public final void setAwaitingContainerChanges(boolean z) {
            this.isAwaitingContainerChanges = z;
        }

        public final void setFinalState(@NotNull State state) {
            Intrinsics.checkNotNullParameter(state, "<set-?>");
            this.finalState = state;
        }

        public final void setLifecycleImpact(@NotNull LifecycleImpact lifecycleImpact) {
            Intrinsics.checkNotNullParameter(lifecycleImpact, "<set-?>");
            this.lifecycleImpact = lifecycleImpact;
        }

        public final void setSeeking$fragment_release(boolean z) {
            this.isSeeking = z;
        }

        @NotNull
        public String toString() {
            StringBuilder m7065u = AbstractC1726qj.m7065u("Operation {", Integer.toHexString(System.identityHashCode(this)), "} {finalState = ");
            m7065u.append(this.finalState);
            m7065u.append(" lifecycleImpact = ");
            m7065u.append(this.lifecycleImpact);
            m7065u.append(" fragment = ");
            m7065u.append(this.fragment);
            m7065u.append('}');
            return m7065u.toString();
        }
    }

    @Metadata(m5570k = 3, m5571mv = {1, 8, 0}, m5573xi = 48)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Operation.LifecycleImpact.values().length];
            try {
                iArr[Operation.LifecycleImpact.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public SpecialEffectsController(@NotNull ViewGroup container) {
        Intrinsics.checkNotNullParameter(container, "container");
        this.container = container;
        this.f4625b = new ArrayList();
        this.f4626c = new ArrayList();
    }

    /* renamed from: d */
    public static boolean m1212d(List list) {
        boolean z;
        Iterator it = list.iterator();
        loop0: while (true) {
            z = true;
            while (it.hasNext()) {
                Operation operation = (Operation) it.next();
                if (!operation.getEffects$fragment_release().isEmpty()) {
                    List<Effect> effects$fragment_release = operation.getEffects$fragment_release();
                    if (!(effects$fragment_release instanceof Collection) || !effects$fragment_release.isEmpty()) {
                        Iterator<T> it2 = effects$fragment_release.iterator();
                        while (it2.hasNext()) {
                            if (!((Effect) it2.next()).isSeekingSupported()) {
                                break;
                            }
                        }
                    }
                }
                z = false;
            }
            break loop0;
        }
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator it3 = list.iterator();
            while (it3.hasNext()) {
                AbstractC1327iq.addAll(arrayList, ((Operation) it3.next()).getEffects$fragment_release());
            }
            if (!arrayList.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    @JvmStatic
    @NotNull
    public static final SpecialEffectsController getOrCreateController(@NotNull ViewGroup viewGroup, @NotNull am2 am2Var) {
        return INSTANCE.getOrCreateController(viewGroup, am2Var);
    }

    /* renamed from: a */
    public final void m1213a(Operation.State state, Operation.LifecycleImpact lifecycleImpact, C0264s c0264s) {
        synchronized (this.f4625b) {
            try {
                Fragment fragment = c0264s.f4692c;
                Intrinsics.checkNotNullExpressionValue(fragment, "fragmentStateManager.fragment");
                Operation m1214b = m1214b(fragment);
                if (m1214b == null) {
                    Fragment fragment2 = c0264s.f4692c;
                    if (fragment2.f4460n) {
                        Intrinsics.checkNotNullExpressionValue(fragment2, "fragmentStateManager.fragment");
                        m1214b = m1215c(fragment2);
                    } else {
                        m1214b = null;
                    }
                }
                if (m1214b != null) {
                    m1214b.mergeWith(state, lifecycleImpact);
                    return;
                }
                final C0266u c0266u = new C0266u(state, lifecycleImpact, c0264s);
                this.f4625b.add(c0266u);
                final int i = 0;
                c0266u.addCompletionListener(new Runnable(this) { // from class: zl2

                    /* renamed from: b */
                    public final /* synthetic */ SpecialEffectsController f29429b;

                    {
                        this.f29429b = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        C0266u operation = c0266u;
                        SpecialEffectsController this$0 = this.f29429b;
                        switch (i) {
                            case 0:
                                SpecialEffectsController.Companion companion = SpecialEffectsController.INSTANCE;
                                Intrinsics.checkNotNullParameter(this$0, "this$0");
                                Intrinsics.checkNotNullParameter(operation, "$operation");
                                if (this$0.f4625b.contains(operation)) {
                                    SpecialEffectsController.Operation.State finalState = operation.getFinalState();
                                    View view = operation.getFragment().f4428K;
                                    Intrinsics.checkNotNullExpressionValue(view, "operation.fragment.mView");
                                    finalState.applyState(view, this$0.container);
                                    return;
                                }
                                return;
                            default:
                                SpecialEffectsController.Companion companion2 = SpecialEffectsController.INSTANCE;
                                Intrinsics.checkNotNullParameter(this$0, "this$0");
                                Intrinsics.checkNotNullParameter(operation, "$operation");
                                this$0.f4625b.remove(operation);
                                this$0.f4626c.remove(operation);
                                return;
                        }
                    }
                });
                final int i2 = 1;
                c0266u.addCompletionListener(new Runnable(this) { // from class: zl2

                    /* renamed from: b */
                    public final /* synthetic */ SpecialEffectsController f29429b;

                    {
                        this.f29429b = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        C0266u operation = c0266u;
                        SpecialEffectsController this$0 = this.f29429b;
                        switch (i2) {
                            case 0:
                                SpecialEffectsController.Companion companion = SpecialEffectsController.INSTANCE;
                                Intrinsics.checkNotNullParameter(this$0, "this$0");
                                Intrinsics.checkNotNullParameter(operation, "$operation");
                                if (this$0.f4625b.contains(operation)) {
                                    SpecialEffectsController.Operation.State finalState = operation.getFinalState();
                                    View view = operation.getFragment().f4428K;
                                    Intrinsics.checkNotNullExpressionValue(view, "operation.fragment.mView");
                                    finalState.applyState(view, this$0.container);
                                    return;
                                }
                                return;
                            default:
                                SpecialEffectsController.Companion companion2 = SpecialEffectsController.INSTANCE;
                                Intrinsics.checkNotNullParameter(this$0, "this$0");
                                Intrinsics.checkNotNullParameter(operation, "$operation");
                                this$0.f4625b.remove(operation);
                                this$0.f4626c.remove(operation);
                                return;
                        }
                    }
                });
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void applyContainerChangesToOperation$fragment_release(@NotNull Operation operation) {
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (operation.getIsAwaitingContainerChanges()) {
            Operation.State finalState = operation.getFinalState();
            View requireView = operation.getFragment().requireView();
            Intrinsics.checkNotNullExpressionValue(requireView, "operation.fragment.requireView()");
            finalState.applyState(requireView, this.container);
            operation.setAwaitingContainerChanges(false);
        }
    }

    /* renamed from: b */
    public final Operation m1214b(Fragment fragment) {
        Object obj;
        Iterator it = this.f4625b.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                Operation operation = (Operation) obj;
                if (Intrinsics.areEqual(operation.getFragment(), fragment) && !operation.getIsCanceled()) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        return (Operation) obj;
    }

    /* renamed from: c */
    public final Operation m1215c(Fragment fragment) {
        Object obj;
        Iterator it = this.f4626c.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                Operation operation = (Operation) obj;
                if (Intrinsics.areEqual(operation.getFragment(), fragment) && !operation.getIsCanceled()) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        return (Operation) obj;
    }

    public abstract void collectEffects(@NotNull List<Operation> operations, boolean isPop);

    public void commitEffects$fragment_release(@NotNull List<Operation> operations) {
        Intrinsics.checkNotNullParameter(operations, "operations");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = operations.iterator();
        while (it.hasNext()) {
            AbstractC1327iq.addAll(arrayList, ((Operation) it.next()).getEffects$fragment_release());
        }
        List list = CollectionsKt___CollectionsKt.toList(CollectionsKt___CollectionsKt.toSet(arrayList));
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ((Effect) list.get(i)).onCommit(this.container);
        }
        int size2 = operations.size();
        for (int i2 = 0; i2 < size2; i2++) {
            applyContainerChangesToOperation$fragment_release(operations.get(i2));
        }
        List list2 = CollectionsKt___CollectionsKt.toList(operations);
        int size3 = list2.size();
        for (int i3 = 0; i3 < size3; i3++) {
            Operation operation = (Operation) list2.get(i3);
            if (operation.getEffects$fragment_release().isEmpty()) {
                operation.complete$fragment_release();
            }
        }
    }

    public final void completeBack() {
        if (FragmentManager.isLoggingEnabled(3)) {
            Log.d(FragmentManager.TAG, "SpecialEffectsController: Completing Back ");
        }
        ArrayList arrayList = this.f4626c;
        m1216e(arrayList);
        commitEffects$fragment_release(arrayList);
    }

    /* renamed from: e */
    public final void m1216e(List list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ((Operation) list.get(i)).onStart();
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            AbstractC1327iq.addAll(arrayList, ((Operation) it.next()).getEffects$fragment_release());
        }
        List list2 = CollectionsKt___CollectionsKt.toList(CollectionsKt___CollectionsKt.toSet(arrayList));
        int size2 = list2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            ((Effect) list2.get(i2)).performStart(this.container);
        }
    }

    public final void enqueueAdd(@NotNull Operation.State finalState, @NotNull C0264s fragmentStateManager) {
        Intrinsics.checkNotNullParameter(finalState, "finalState");
        Intrinsics.checkNotNullParameter(fragmentStateManager, "fragmentStateManager");
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "SpecialEffectsController: Enqueuing add operation for fragment " + fragmentStateManager.f4692c);
        }
        m1213a(finalState, Operation.LifecycleImpact.ADDING, fragmentStateManager);
    }

    public final void enqueueHide(@NotNull C0264s fragmentStateManager) {
        Intrinsics.checkNotNullParameter(fragmentStateManager, "fragmentStateManager");
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "SpecialEffectsController: Enqueuing hide operation for fragment " + fragmentStateManager.f4692c);
        }
        m1213a(Operation.State.GONE, Operation.LifecycleImpact.NONE, fragmentStateManager);
    }

    public final void enqueueRemove(@NotNull C0264s fragmentStateManager) {
        Intrinsics.checkNotNullParameter(fragmentStateManager, "fragmentStateManager");
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "SpecialEffectsController: Enqueuing remove operation for fragment " + fragmentStateManager.f4692c);
        }
        m1213a(Operation.State.REMOVED, Operation.LifecycleImpact.REMOVING, fragmentStateManager);
    }

    public final void enqueueShow(@NotNull C0264s fragmentStateManager) {
        Intrinsics.checkNotNullParameter(fragmentStateManager, "fragmentStateManager");
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "SpecialEffectsController: Enqueuing show operation for fragment " + fragmentStateManager.f4692c);
        }
        m1213a(Operation.State.VISIBLE, Operation.LifecycleImpact.NONE, fragmentStateManager);
    }

    public final void executePendingOperations() {
        boolean z;
        if (this.f4629f) {
            return;
        }
        if (!this.container.isAttachedToWindow()) {
            forceCompleteAllOperations();
            this.f4628e = false;
            return;
        }
        synchronized (this.f4625b) {
            try {
                List<Operation> mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) this.f4626c);
                this.f4626c.clear();
                Iterator it = mutableList.iterator();
                while (true) {
                    z = true;
                    if (!it.hasNext()) {
                        break;
                    }
                    Operation operation = (Operation) it.next();
                    if (this.f4625b.isEmpty() || !operation.getFragment().f4460n) {
                        z = false;
                    }
                    operation.setSeeking$fragment_release(z);
                }
                for (Operation operation2 : mutableList) {
                    if (this.f4627d) {
                        if (FragmentManager.isLoggingEnabled(2)) {
                            Log.v(FragmentManager.TAG, "SpecialEffectsController: Completing non-seekable operation " + operation2);
                        }
                        operation2.complete$fragment_release();
                    } else {
                        if (FragmentManager.isLoggingEnabled(2)) {
                            Log.v(FragmentManager.TAG, "SpecialEffectsController: Cancelling operation " + operation2);
                        }
                        operation2.cancel(this.container);
                    }
                    this.f4627d = false;
                    if (!operation2.getIsComplete()) {
                        this.f4626c.add(operation2);
                    }
                }
                if (!this.f4625b.isEmpty()) {
                    m1217f();
                    List<Operation> mutableList2 = CollectionsKt___CollectionsKt.toMutableList((Collection) this.f4625b);
                    if (mutableList2.isEmpty()) {
                        return;
                    }
                    this.f4625b.clear();
                    this.f4626c.addAll(mutableList2);
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v(FragmentManager.TAG, "SpecialEffectsController: Executing pending operations");
                    }
                    collectEffects(mutableList2, this.f4628e);
                    boolean m1212d = m1212d(mutableList2);
                    Iterator<T> it2 = mutableList2.iterator();
                    boolean z2 = true;
                    while (it2.hasNext()) {
                        if (!((Operation) it2.next()).getFragment().f4460n) {
                            z2 = false;
                        }
                    }
                    if (!z2 || m1212d) {
                        z = false;
                    }
                    this.f4627d = z;
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v(FragmentManager.TAG, "SpecialEffectsController: Operation seekable = " + m1212d + " \ntransition = " + z2);
                    }
                    if (!z2) {
                        m1216e(mutableList2);
                        commitEffects$fragment_release(mutableList2);
                    } else if (m1212d) {
                        m1216e(mutableList2);
                        int size = mutableList2.size();
                        for (int i = 0; i < size; i++) {
                            applyContainerChangesToOperation$fragment_release(mutableList2.get(i));
                        }
                    }
                    this.f4628e = false;
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v(FragmentManager.TAG, "SpecialEffectsController: Finished executing pending operations");
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: f */
    public final void m1217f() {
        Iterator it = this.f4625b.iterator();
        while (it.hasNext()) {
            Operation operation = (Operation) it.next();
            if (operation.getLifecycleImpact() == Operation.LifecycleImpact.ADDING) {
                View requireView = operation.getFragment().requireView();
                Intrinsics.checkNotNullExpressionValue(requireView, "fragment.requireView()");
                operation.mergeWith(Operation.State.INSTANCE.from(requireView.getVisibility()), Operation.LifecycleImpact.NONE);
            }
        }
    }

    public final void forceCompleteAllOperations() {
        String str;
        String str2;
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "SpecialEffectsController: Forcing all operations to complete");
        }
        boolean isAttachedToWindow = this.container.isAttachedToWindow();
        synchronized (this.f4625b) {
            try {
                m1217f();
                m1216e(this.f4625b);
                List<Operation> mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) this.f4626c);
                Iterator it = mutableList.iterator();
                while (it.hasNext()) {
                    ((Operation) it.next()).setSeeking$fragment_release(false);
                }
                for (Operation operation : mutableList) {
                    if (FragmentManager.isLoggingEnabled(2)) {
                        if (isAttachedToWindow) {
                            str2 = "";
                        } else {
                            str2 = "Container " + this.container + " is not attached to window. ";
                        }
                        Log.v(FragmentManager.TAG, "SpecialEffectsController: " + str2 + "Cancelling running operation " + operation);
                    }
                    operation.cancel(this.container);
                }
                List<Operation> mutableList2 = CollectionsKt___CollectionsKt.toMutableList((Collection) this.f4625b);
                Iterator it2 = mutableList2.iterator();
                while (it2.hasNext()) {
                    ((Operation) it2.next()).setSeeking$fragment_release(false);
                }
                for (Operation operation2 : mutableList2) {
                    if (FragmentManager.isLoggingEnabled(2)) {
                        if (isAttachedToWindow) {
                            str = "";
                        } else {
                            str = "Container " + this.container + " is not attached to window. ";
                        }
                        Log.v(FragmentManager.TAG, "SpecialEffectsController: " + str + "Cancelling pending operation " + operation2);
                    }
                    operation2.cancel(this.container);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void forcePostponedExecutePendingOperations() {
        if (this.f4629f) {
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v(FragmentManager.TAG, "SpecialEffectsController: Forcing postponed operations");
            }
            this.f4629f = false;
            executePendingOperations();
        }
    }

    @Nullable
    public final Operation.LifecycleImpact getAwaitingCompletionLifecycleImpact(@NotNull C0264s fragmentStateManager) {
        Operation.LifecycleImpact lifecycleImpact;
        int i;
        Intrinsics.checkNotNullParameter(fragmentStateManager, "fragmentStateManager");
        Fragment fragment = fragmentStateManager.f4692c;
        Intrinsics.checkNotNullExpressionValue(fragment, "fragmentStateManager.fragment");
        Operation m1214b = m1214b(fragment);
        Operation.LifecycleImpact lifecycleImpact2 = null;
        if (m1214b != null) {
            lifecycleImpact = m1214b.getLifecycleImpact();
        } else {
            lifecycleImpact = null;
        }
        Operation m1215c = m1215c(fragment);
        if (m1215c != null) {
            lifecycleImpact2 = m1215c.getLifecycleImpact();
        }
        if (lifecycleImpact == null) {
            i = -1;
        } else {
            i = WhenMappings.$EnumSwitchMapping$0[lifecycleImpact.ordinal()];
        }
        if (i == -1 || i == 1) {
            return lifecycleImpact2;
        }
        return lifecycleImpact;
    }

    @NotNull
    public final ViewGroup getContainer() {
        return this.container;
    }

    public final boolean isPendingExecute() {
        return !this.f4625b.isEmpty();
    }

    public final void markPostponedState() {
        Fragment fragment;
        Object obj;
        jt0 jt0Var;
        synchronized (this.f4625b) {
            try {
                m1217f();
                ArrayList arrayList = this.f4625b;
                ListIterator listIterator = arrayList.listIterator(arrayList.size());
                while (true) {
                    fragment = null;
                    if (listIterator.hasPrevious()) {
                        obj = listIterator.previous();
                        Operation operation = (Operation) obj;
                        Operation.State.Companion companion = Operation.State.INSTANCE;
                        View view = operation.getFragment().f4428K;
                        Intrinsics.checkNotNullExpressionValue(view, "operation.fragment.mView");
                        Operation.State asOperationState = companion.asOperationState(view);
                        Operation.State finalState = operation.getFinalState();
                        Operation.State state = Operation.State.VISIBLE;
                        if (finalState == state && asOperationState != state) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                Operation operation2 = (Operation) obj;
                if (operation2 != null) {
                    fragment = operation2.getFragment();
                }
                boolean z = false;
                if (fragment != null && (jt0Var = fragment.f4431N) != null) {
                    z = jt0Var.f20623u;
                }
                this.f4629f = z;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void processProgress(@NotNull BackEventCompat backEvent) {
        Intrinsics.checkNotNullParameter(backEvent, "backEvent");
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "SpecialEffectsController: Processing Progress " + backEvent.getProgress());
        }
        ArrayList arrayList = this.f4626c;
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            AbstractC1327iq.addAll(arrayList2, ((Operation) it.next()).getEffects$fragment_release());
        }
        List list = CollectionsKt___CollectionsKt.toList(CollectionsKt___CollectionsKt.toSet(arrayList2));
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ((Effect) list.get(i)).onProgress(backEvent, this.container);
        }
    }

    public final void updateOperationDirection(boolean isPop) {
        this.f4628e = isPop;
    }

    @Metadata(m5568d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\u0007\u0010\u000b¨\u0006\f"}, m5569d2 = {"Landroidx/fragment/app/SpecialEffectsController$Companion;", "", "Landroid/view/ViewGroup;", "container", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Landroidx/fragment/app/SpecialEffectsController;", "getOrCreateController", "(Landroid/view/ViewGroup;Landroidx/fragment/app/FragmentManager;)Landroidx/fragment/app/SpecialEffectsController;", "Lam2;", "factory", "(Landroid/view/ViewGroup;Lam2;)Landroidx/fragment/app/SpecialEffectsController;", "fragment_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        @JvmStatic
        @NotNull
        public final SpecialEffectsController getOrCreateController(@NotNull ViewGroup container, @NotNull FragmentManager fragmentManager) {
            Intrinsics.checkNotNullParameter(container, "container");
            Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
            am2 m1157F = fragmentManager.m1157F();
            Intrinsics.checkNotNullExpressionValue(m1157F, "fragmentManager.specialEffectsControllerFactory");
            return getOrCreateController(container, m1157F);
        }

        @JvmStatic
        @NotNull
        public final SpecialEffectsController getOrCreateController(@NotNull ViewGroup container, @NotNull am2 factory) {
            Intrinsics.checkNotNullParameter(container, "container");
            Intrinsics.checkNotNullParameter(factory, "factory");
            int i = R.id.special_effects_controller_view_tag;
            Object tag = container.getTag(i);
            if (tag instanceof SpecialEffectsController) {
                return (SpecialEffectsController) tag;
            }
            ((wd0) factory).getClass();
            DefaultSpecialEffectsController defaultSpecialEffectsController = new DefaultSpecialEffectsController(container);
            Intrinsics.checkNotNullExpressionValue(defaultSpecialEffectsController, "factory.createController(container)");
            container.setTag(i, defaultSpecialEffectsController);
            return defaultSpecialEffectsController;
        }
    }

    @JvmStatic
    @NotNull
    public static final SpecialEffectsController getOrCreateController(@NotNull ViewGroup viewGroup, @NotNull FragmentManager fragmentManager) {
        return INSTANCE.getOrCreateController(viewGroup, fragmentManager);
    }
}
