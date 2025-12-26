package androidx.fragment.app.strictmode;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.ViewGroup;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.RunnableC0583c7;
import p000.lh1;
import p000.sh2;

@Metadata(m5568d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003,-.J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0014\u0010\u0013J\u001f\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015H\u0007¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u001c\u0010\u0011J\u0017\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u001d\u0010\u0013J\u0017\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u001e\u0010\u0013J\u001f\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\u001f\u0010\fJ\u0017\u0010\"\u001a\u00020\u00062\u0006\u0010!\u001a\u00020 H\u0007¢\u0006\u0004\b\"\u0010#R\"\u0010+\u001a\u00020$8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u0006/"}, m5569d2 = {"Landroidx/fragment/app/strictmode/FragmentStrictMode;", "", "Landroidx/fragment/app/Fragment;", "fragment", "", "previousFragmentId", "", "onFragmentReuse", "(Landroidx/fragment/app/Fragment;Ljava/lang/String;)V", "Landroid/view/ViewGroup;", "container", "onFragmentTagUsage", "(Landroidx/fragment/app/Fragment;Landroid/view/ViewGroup;)V", "expectedParentFragment", "", "containerId", "onWrongNestedHierarchy", "(Landroidx/fragment/app/Fragment;Landroidx/fragment/app/Fragment;I)V", "onSetRetainInstanceUsage", "(Landroidx/fragment/app/Fragment;)V", "onGetRetainInstanceUsage", "", "isVisibleToUser", "onSetUserVisibleHint", "(Landroidx/fragment/app/Fragment;Z)V", "violatingFragment", "targetFragment", "requestCode", "onSetTargetFragmentUsage", "onGetTargetFragmentUsage", "onGetTargetFragmentRequestCodeUsage", "onWrongFragmentContainer", "Landroidx/fragment/app/strictmode/Violation;", "violation", "onPolicyViolation", "(Landroidx/fragment/app/strictmode/Violation;)V", "Landroidx/fragment/app/strictmode/FragmentStrictMode$Policy;", "a", "Landroidx/fragment/app/strictmode/FragmentStrictMode$Policy;", "getDefaultPolicy", "()Landroidx/fragment/app/strictmode/FragmentStrictMode$Policy;", "setDefaultPolicy", "(Landroidx/fragment/app/strictmode/FragmentStrictMode$Policy;)V", "defaultPolicy", "Flag", "OnViolationListener", "Policy", "fragment_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes.dex */
public final class FragmentStrictMode {

    @NotNull
    public static final FragmentStrictMode INSTANCE = new Object();

    /* renamed from: a, reason: from kotlin metadata */
    public static Policy defaultPolicy = Policy.LAX;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(m5568d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, m5569d2 = {"Landroidx/fragment/app/strictmode/FragmentStrictMode$Flag;", "", "PENALTY_LOG", "PENALTY_DEATH", "DETECT_FRAGMENT_REUSE", "DETECT_FRAGMENT_TAG_USAGE", "DETECT_WRONG_NESTED_HIERARCHY", "DETECT_RETAIN_INSTANCE_USAGE", "DETECT_SET_USER_VISIBLE_HINT", "DETECT_TARGET_FRAGMENT_USAGE", "DETECT_WRONG_FRAGMENT_CONTAINER", "fragment_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
    /* loaded from: classes.dex */
    public static final class Flag {
        public static final Flag DETECT_FRAGMENT_REUSE;
        public static final Flag DETECT_FRAGMENT_TAG_USAGE;
        public static final Flag DETECT_RETAIN_INSTANCE_USAGE;
        public static final Flag DETECT_SET_USER_VISIBLE_HINT;
        public static final Flag DETECT_TARGET_FRAGMENT_USAGE;
        public static final Flag DETECT_WRONG_FRAGMENT_CONTAINER;
        public static final Flag DETECT_WRONG_NESTED_HIERARCHY;
        public static final Flag PENALTY_DEATH;
        public static final Flag PENALTY_LOG;

        /* renamed from: a */
        public static final /* synthetic */ Flag[] f4697a;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r10v1, types: [java.lang.Enum, androidx.fragment.app.strictmode.FragmentStrictMode$Flag] */
        /* JADX WARN: Type inference failed for: r11v1, types: [java.lang.Enum, androidx.fragment.app.strictmode.FragmentStrictMode$Flag] */
        /* JADX WARN: Type inference failed for: r12v1, types: [java.lang.Enum, androidx.fragment.app.strictmode.FragmentStrictMode$Flag] */
        /* JADX WARN: Type inference failed for: r13v1, types: [java.lang.Enum, androidx.fragment.app.strictmode.FragmentStrictMode$Flag] */
        /* JADX WARN: Type inference failed for: r14v1, types: [java.lang.Enum, androidx.fragment.app.strictmode.FragmentStrictMode$Flag] */
        /* JADX WARN: Type inference failed for: r15v1, types: [java.lang.Enum, androidx.fragment.app.strictmode.FragmentStrictMode$Flag] */
        /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Enum, androidx.fragment.app.strictmode.FragmentStrictMode$Flag] */
        /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Enum, androidx.fragment.app.strictmode.FragmentStrictMode$Flag] */
        /* JADX WARN: Type inference failed for: r9v0, types: [java.lang.Enum, androidx.fragment.app.strictmode.FragmentStrictMode$Flag] */
        static {
            ?? r9 = new Enum("PENALTY_LOG", 0);
            PENALTY_LOG = r9;
            ?? r10 = new Enum("PENALTY_DEATH", 1);
            PENALTY_DEATH = r10;
            ?? r11 = new Enum("DETECT_FRAGMENT_REUSE", 2);
            DETECT_FRAGMENT_REUSE = r11;
            ?? r12 = new Enum("DETECT_FRAGMENT_TAG_USAGE", 3);
            DETECT_FRAGMENT_TAG_USAGE = r12;
            ?? r13 = new Enum("DETECT_WRONG_NESTED_HIERARCHY", 4);
            DETECT_WRONG_NESTED_HIERARCHY = r13;
            ?? r14 = new Enum("DETECT_RETAIN_INSTANCE_USAGE", 5);
            DETECT_RETAIN_INSTANCE_USAGE = r14;
            ?? r15 = new Enum("DETECT_SET_USER_VISIBLE_HINT", 6);
            DETECT_SET_USER_VISIBLE_HINT = r15;
            ?? r3 = new Enum("DETECT_TARGET_FRAGMENT_USAGE", 7);
            DETECT_TARGET_FRAGMENT_USAGE = r3;
            ?? r2 = new Enum("DETECT_WRONG_FRAGMENT_CONTAINER", 8);
            DETECT_WRONG_FRAGMENT_CONTAINER = r2;
            f4697a = new Flag[]{r9, r10, r11, r12, r13, r14, r15, r3, r2};
        }

        public static Flag valueOf(String str) {
            return (Flag) Enum.valueOf(Flag.class, str);
        }

        public static Flag[] values() {
            return (Flag[]) f4697a.clone();
        }
    }

    @Metadata(m5568d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, m5569d2 = {"Landroidx/fragment/app/strictmode/FragmentStrictMode$OnViolationListener;", "", "onViolation", "", "violation", "Landroidx/fragment/app/strictmode/Violation;", "fragment_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
    /* loaded from: classes.dex */
    public interface OnViolationListener {
        void onViolation(@NotNull Violation violation);
    }

    @Metadata(m5568d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001d\u001cBC\b\u0000\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012 \u0010\f\u001a\u001c\u0012\u0004\u0012\u00020\b\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\n0\t0\u0007¢\u0006\u0004\b\r\u0010\u000eR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R4\u0010\u001b\u001a\u001c\u0012\u0004\u0012\u00020\b\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\n0\u00020\u00078\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, m5569d2 = {"Landroidx/fragment/app/strictmode/FragmentStrictMode$Policy;", "", "", "Landroidx/fragment/app/strictmode/FragmentStrictMode$Flag;", "flags", "Landroidx/fragment/app/strictmode/FragmentStrictMode$OnViolationListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "", "", "Ljava/lang/Class;", "Landroidx/fragment/app/strictmode/Violation;", "allowedViolations", "<init>", "(Ljava/util/Set;Landroidx/fragment/app/strictmode/FragmentStrictMode$OnViolationListener;Ljava/util/Map;)V", "a", "Ljava/util/Set;", "getFlags$fragment_release", "()Ljava/util/Set;", "b", "Landroidx/fragment/app/strictmode/FragmentStrictMode$OnViolationListener;", "getListener$fragment_release", "()Landroidx/fragment/app/strictmode/FragmentStrictMode$OnViolationListener;", "c", "Ljava/util/Map;", "getMAllowedViolations$fragment_release", "()Ljava/util/Map;", "mAllowedViolations", "Companion", "Builder", "fragment_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
    /* loaded from: classes.dex */
    public static final class Policy {

        @JvmField
        @NotNull
        public static final Policy LAX = new Policy(sh2.emptySet(), null, lh1.emptyMap());

        /* renamed from: a, reason: from kotlin metadata */
        public final Set flags;

        /* renamed from: b, reason: from kotlin metadata */
        public final OnViolationListener listener;

        /* renamed from: c */
        public final LinkedHashMap f4700c;

        public Policy(@NotNull Set<? extends Flag> flags, @Nullable OnViolationListener onViolationListener, @NotNull Map<String, ? extends Set<Class<? extends Violation>>> allowedViolations) {
            Intrinsics.checkNotNullParameter(flags, "flags");
            Intrinsics.checkNotNullParameter(allowedViolations, "allowedViolations");
            this.flags = flags;
            this.listener = onViolationListener;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<String, ? extends Set<Class<? extends Violation>>> entry : allowedViolations.entrySet()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
            this.f4700c = linkedHashMap;
        }

        @NotNull
        public final Set<Flag> getFlags$fragment_release() {
            return this.flags;
        }

        @Nullable
        /* renamed from: getListener$fragment_release, reason: from getter */
        public final OnViolationListener getListener() {
            return this.listener;
        }

        @NotNull
        public final Map<String, Set<Class<? extends Violation>>> getMAllowedViolations$fragment_release() {
            return this.f4700c;
        }

        @Metadata(m5568d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0004\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0006\u0010\u0005J\u0017\u0010\t\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u000b\u0010\u0005J\u000f\u0010\f\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\r\u0010\u0005J\u000f\u0010\u000e\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u000e\u0010\u0005J\u000f\u0010\u000f\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u000f\u0010\u0005J\u000f\u0010\u0010\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0010\u0010\u0005J\u000f\u0010\u0011\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0011\u0010\u0005J/\u0010\u0017\u001a\u00020\u00002\u000e\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u00122\u000e\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u0012H\u0007¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00192\u000e\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u0012H\u0007¢\u0006\u0004\b\u0017\u0010\u001aJ\r\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, m5569d2 = {"Landroidx/fragment/app/strictmode/FragmentStrictMode$Policy$Builder;", "", "<init>", "()V", "penaltyLog", "()Landroidx/fragment/app/strictmode/FragmentStrictMode$Policy$Builder;", "penaltyDeath", "Landroidx/fragment/app/strictmode/FragmentStrictMode$OnViolationListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "penaltyListener", "(Landroidx/fragment/app/strictmode/FragmentStrictMode$OnViolationListener;)Landroidx/fragment/app/strictmode/FragmentStrictMode$Policy$Builder;", "detectFragmentReuse", "detectFragmentTagUsage", "detectWrongNestedHierarchy", "detectRetainInstanceUsage", "detectSetUserVisibleHint", "detectTargetFragmentUsage", "detectWrongFragmentContainer", "Ljava/lang/Class;", "Landroidx/fragment/app/Fragment;", "fragmentClass", "Landroidx/fragment/app/strictmode/Violation;", "violationClass", "allowViolation", "(Ljava/lang/Class;Ljava/lang/Class;)Landroidx/fragment/app/strictmode/FragmentStrictMode$Policy$Builder;", "", "(Ljava/lang/String;Ljava/lang/Class;)Landroidx/fragment/app/strictmode/FragmentStrictMode$Policy$Builder;", "Landroidx/fragment/app/strictmode/FragmentStrictMode$Policy;", "build", "()Landroidx/fragment/app/strictmode/FragmentStrictMode$Policy;", "fragment_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
        /* loaded from: classes.dex */
        public static final class Builder {

            /* renamed from: b */
            public OnViolationListener f4702b;

            /* renamed from: a */
            public final LinkedHashSet f4701a = new LinkedHashSet();

            /* renamed from: c */
            public final LinkedHashMap f4703c = new LinkedHashMap();

            @SuppressLint({"BuilderSetStyle"})
            @NotNull
            public final Builder allowViolation(@NotNull Class<? extends Fragment> fragmentClass, @NotNull Class<? extends Violation> violationClass) {
                Intrinsics.checkNotNullParameter(fragmentClass, "fragmentClass");
                Intrinsics.checkNotNullParameter(violationClass, "violationClass");
                String fragmentClassString = fragmentClass.getName();
                Intrinsics.checkNotNullExpressionValue(fragmentClassString, "fragmentClassString");
                return allowViolation(fragmentClassString, violationClass);
            }

            @NotNull
            public final Policy build() {
                OnViolationListener onViolationListener = this.f4702b;
                LinkedHashSet linkedHashSet = this.f4701a;
                if (onViolationListener == null && !linkedHashSet.contains(Flag.PENALTY_DEATH)) {
                    penaltyLog();
                }
                return new Policy(linkedHashSet, this.f4702b, this.f4703c);
            }

            @SuppressLint({"BuilderSetStyle"})
            @NotNull
            public final Builder detectFragmentReuse() {
                this.f4701a.add(Flag.DETECT_FRAGMENT_REUSE);
                return this;
            }

            @SuppressLint({"BuilderSetStyle"})
            @NotNull
            public final Builder detectFragmentTagUsage() {
                this.f4701a.add(Flag.DETECT_FRAGMENT_TAG_USAGE);
                return this;
            }

            @SuppressLint({"BuilderSetStyle"})
            @NotNull
            public final Builder detectRetainInstanceUsage() {
                this.f4701a.add(Flag.DETECT_RETAIN_INSTANCE_USAGE);
                return this;
            }

            @SuppressLint({"BuilderSetStyle"})
            @NotNull
            public final Builder detectSetUserVisibleHint() {
                this.f4701a.add(Flag.DETECT_SET_USER_VISIBLE_HINT);
                return this;
            }

            @SuppressLint({"BuilderSetStyle"})
            @NotNull
            public final Builder detectTargetFragmentUsage() {
                this.f4701a.add(Flag.DETECT_TARGET_FRAGMENT_USAGE);
                return this;
            }

            @SuppressLint({"BuilderSetStyle"})
            @NotNull
            public final Builder detectWrongFragmentContainer() {
                this.f4701a.add(Flag.DETECT_WRONG_FRAGMENT_CONTAINER);
                return this;
            }

            @SuppressLint({"BuilderSetStyle"})
            @NotNull
            public final Builder detectWrongNestedHierarchy() {
                this.f4701a.add(Flag.DETECT_WRONG_NESTED_HIERARCHY);
                return this;
            }

            @SuppressLint({"BuilderSetStyle"})
            @NotNull
            public final Builder penaltyDeath() {
                this.f4701a.add(Flag.PENALTY_DEATH);
                return this;
            }

            @SuppressLint({"BuilderSetStyle"})
            @NotNull
            public final Builder penaltyListener(@NotNull OnViolationListener listener) {
                Intrinsics.checkNotNullParameter(listener, "listener");
                this.f4702b = listener;
                return this;
            }

            @SuppressLint({"BuilderSetStyle"})
            @NotNull
            public final Builder penaltyLog() {
                this.f4701a.add(Flag.PENALTY_LOG);
                return this;
            }

            @SuppressLint({"BuilderSetStyle"})
            @NotNull
            public final Builder allowViolation(@NotNull String fragmentClass, @NotNull Class<? extends Violation> violationClass) {
                Intrinsics.checkNotNullParameter(fragmentClass, "fragmentClass");
                Intrinsics.checkNotNullParameter(violationClass, "violationClass");
                LinkedHashMap linkedHashMap = this.f4703c;
                Set set = (Set) linkedHashMap.get(fragmentClass);
                if (set == null) {
                    set = new LinkedHashSet();
                }
                set.add(violationClass);
                linkedHashMap.put(fragmentClass, set);
                return this;
            }
        }
    }

    /* renamed from: a */
    public static Policy m1248a(Fragment fragment) {
        while (fragment != null) {
            if (fragment.isAdded()) {
                FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
                Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "declaringFragment.parentFragmentManager");
                if (parentFragmentManager.getStrictModePolicy() != null) {
                    Policy strictModePolicy = parentFragmentManager.getStrictModePolicy();
                    Intrinsics.checkNotNull(strictModePolicy);
                    return strictModePolicy;
                }
            }
            fragment = fragment.getParentFragment();
        }
        return defaultPolicy;
    }

    /* renamed from: b */
    public static void m1249b(Policy policy, Violation violation) {
        Fragment fragment = violation.getFragment();
        String name = fragment.getClass().getName();
        if (policy.getFlags$fragment_release().contains(Flag.PENALTY_LOG)) {
            Log.d("FragmentStrictMode", "Policy violation in ".concat(name), violation);
        }
        if (policy.getListener() != null) {
            m1251d(fragment, new RunnableC0583c7(21, policy, violation));
        }
        if (policy.getFlags$fragment_release().contains(Flag.PENALTY_DEATH)) {
            m1251d(fragment, new RunnableC0583c7(22, name, violation));
        }
    }

    /* renamed from: c */
    public static void m1250c(Violation violation) {
        if (FragmentManager.isLoggingEnabled(3)) {
            Log.d(FragmentManager.TAG, "StrictMode violation in ".concat(violation.getFragment().getClass().getName()), violation);
        }
    }

    /* renamed from: d */
    public static void m1251d(Fragment fragment, Runnable runnable) {
        if (fragment.isAdded()) {
            Handler handler = fragment.getParentFragmentManager().getHost().getHandler();
            if (Intrinsics.areEqual(handler.getLooper(), Looper.myLooper())) {
                runnable.run();
                return;
            } else {
                handler.post(runnable);
                return;
            }
        }
        runnable.run();
    }

    /* renamed from: e */
    public static boolean m1252e(Policy policy, Class cls, Class cls2) {
        Set<Class<? extends Violation>> set = policy.getMAllowedViolations$fragment_release().get(cls.getName());
        if (set == null) {
            return true;
        }
        if (!Intrinsics.areEqual(cls2.getSuperclass(), Violation.class) && CollectionsKt___CollectionsKt.contains(set, cls2.getSuperclass())) {
            return false;
        }
        return !set.contains(cls2);
    }

    @JvmStatic
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final void onFragmentReuse(@NotNull Fragment fragment, @NotNull String previousFragmentId) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(previousFragmentId, "previousFragmentId");
        FragmentReuseViolation fragmentReuseViolation = new FragmentReuseViolation(fragment, previousFragmentId);
        INSTANCE.getClass();
        m1250c(fragmentReuseViolation);
        Policy m1248a = m1248a(fragment);
        if (m1248a.getFlags$fragment_release().contains(Flag.DETECT_FRAGMENT_REUSE) && m1252e(m1248a, fragment.getClass(), FragmentReuseViolation.class)) {
            m1249b(m1248a, fragmentReuseViolation);
        }
    }

    @JvmStatic
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final void onFragmentTagUsage(@NotNull Fragment fragment, @Nullable ViewGroup container) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        FragmentTagUsageViolation fragmentTagUsageViolation = new FragmentTagUsageViolation(fragment, container);
        INSTANCE.getClass();
        m1250c(fragmentTagUsageViolation);
        Policy m1248a = m1248a(fragment);
        if (m1248a.getFlags$fragment_release().contains(Flag.DETECT_FRAGMENT_TAG_USAGE) && m1252e(m1248a, fragment.getClass(), FragmentTagUsageViolation.class)) {
            m1249b(m1248a, fragmentTagUsageViolation);
        }
    }

    @JvmStatic
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final void onGetRetainInstanceUsage(@NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        GetRetainInstanceUsageViolation getRetainInstanceUsageViolation = new GetRetainInstanceUsageViolation(fragment);
        INSTANCE.getClass();
        m1250c(getRetainInstanceUsageViolation);
        Policy m1248a = m1248a(fragment);
        if (m1248a.getFlags$fragment_release().contains(Flag.DETECT_RETAIN_INSTANCE_USAGE) && m1252e(m1248a, fragment.getClass(), GetRetainInstanceUsageViolation.class)) {
            m1249b(m1248a, getRetainInstanceUsageViolation);
        }
    }

    @JvmStatic
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final void onGetTargetFragmentRequestCodeUsage(@NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        GetTargetFragmentRequestCodeUsageViolation getTargetFragmentRequestCodeUsageViolation = new GetTargetFragmentRequestCodeUsageViolation(fragment);
        INSTANCE.getClass();
        m1250c(getTargetFragmentRequestCodeUsageViolation);
        Policy m1248a = m1248a(fragment);
        if (m1248a.getFlags$fragment_release().contains(Flag.DETECT_TARGET_FRAGMENT_USAGE) && m1252e(m1248a, fragment.getClass(), GetTargetFragmentRequestCodeUsageViolation.class)) {
            m1249b(m1248a, getTargetFragmentRequestCodeUsageViolation);
        }
    }

    @JvmStatic
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final void onGetTargetFragmentUsage(@NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        GetTargetFragmentUsageViolation getTargetFragmentUsageViolation = new GetTargetFragmentUsageViolation(fragment);
        INSTANCE.getClass();
        m1250c(getTargetFragmentUsageViolation);
        Policy m1248a = m1248a(fragment);
        if (m1248a.getFlags$fragment_release().contains(Flag.DETECT_TARGET_FRAGMENT_USAGE) && m1252e(m1248a, fragment.getClass(), GetTargetFragmentUsageViolation.class)) {
            m1249b(m1248a, getTargetFragmentUsageViolation);
        }
    }

    @JvmStatic
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final void onSetRetainInstanceUsage(@NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        SetRetainInstanceUsageViolation setRetainInstanceUsageViolation = new SetRetainInstanceUsageViolation(fragment);
        INSTANCE.getClass();
        m1250c(setRetainInstanceUsageViolation);
        Policy m1248a = m1248a(fragment);
        if (m1248a.getFlags$fragment_release().contains(Flag.DETECT_RETAIN_INSTANCE_USAGE) && m1252e(m1248a, fragment.getClass(), SetRetainInstanceUsageViolation.class)) {
            m1249b(m1248a, setRetainInstanceUsageViolation);
        }
    }

    @JvmStatic
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final void onSetTargetFragmentUsage(@NotNull Fragment violatingFragment, @NotNull Fragment targetFragment, int requestCode) {
        Intrinsics.checkNotNullParameter(violatingFragment, "violatingFragment");
        Intrinsics.checkNotNullParameter(targetFragment, "targetFragment");
        SetTargetFragmentUsageViolation setTargetFragmentUsageViolation = new SetTargetFragmentUsageViolation(violatingFragment, targetFragment, requestCode);
        INSTANCE.getClass();
        m1250c(setTargetFragmentUsageViolation);
        Policy m1248a = m1248a(violatingFragment);
        if (m1248a.getFlags$fragment_release().contains(Flag.DETECT_TARGET_FRAGMENT_USAGE) && m1252e(m1248a, violatingFragment.getClass(), SetTargetFragmentUsageViolation.class)) {
            m1249b(m1248a, setTargetFragmentUsageViolation);
        }
    }

    @JvmStatic
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final void onSetUserVisibleHint(@NotNull Fragment fragment, boolean isVisibleToUser) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        SetUserVisibleHintViolation setUserVisibleHintViolation = new SetUserVisibleHintViolation(fragment, isVisibleToUser);
        INSTANCE.getClass();
        m1250c(setUserVisibleHintViolation);
        Policy m1248a = m1248a(fragment);
        if (m1248a.getFlags$fragment_release().contains(Flag.DETECT_SET_USER_VISIBLE_HINT) && m1252e(m1248a, fragment.getClass(), SetUserVisibleHintViolation.class)) {
            m1249b(m1248a, setUserVisibleHintViolation);
        }
    }

    @JvmStatic
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final void onWrongFragmentContainer(@NotNull Fragment fragment, @NotNull ViewGroup container) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(container, "container");
        WrongFragmentContainerViolation wrongFragmentContainerViolation = new WrongFragmentContainerViolation(fragment, container);
        INSTANCE.getClass();
        m1250c(wrongFragmentContainerViolation);
        Policy m1248a = m1248a(fragment);
        if (m1248a.getFlags$fragment_release().contains(Flag.DETECT_WRONG_FRAGMENT_CONTAINER) && m1252e(m1248a, fragment.getClass(), WrongFragmentContainerViolation.class)) {
            m1249b(m1248a, wrongFragmentContainerViolation);
        }
    }

    @JvmStatic
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final void onWrongNestedHierarchy(@NotNull Fragment fragment, @NotNull Fragment expectedParentFragment, int containerId) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(expectedParentFragment, "expectedParentFragment");
        WrongNestedHierarchyViolation wrongNestedHierarchyViolation = new WrongNestedHierarchyViolation(fragment, expectedParentFragment, containerId);
        INSTANCE.getClass();
        m1250c(wrongNestedHierarchyViolation);
        Policy m1248a = m1248a(fragment);
        if (m1248a.getFlags$fragment_release().contains(Flag.DETECT_WRONG_NESTED_HIERARCHY) && m1252e(m1248a, fragment.getClass(), WrongNestedHierarchyViolation.class)) {
            m1249b(m1248a, wrongNestedHierarchyViolation);
        }
    }

    @NotNull
    public final Policy getDefaultPolicy() {
        return defaultPolicy;
    }

    @VisibleForTesting
    public final void onPolicyViolation(@NotNull Violation violation) {
        Intrinsics.checkNotNullParameter(violation, "violation");
        m1250c(violation);
        Fragment fragment = violation.getFragment();
        Policy m1248a = m1248a(fragment);
        if (m1252e(m1248a, fragment.getClass(), violation.getClass())) {
            m1249b(m1248a, violation);
        }
    }

    public final void setDefaultPolicy(@NotNull Policy policy) {
        Intrinsics.checkNotNullParameter(policy, "<set-?>");
        defaultPolicy = policy;
    }
}
