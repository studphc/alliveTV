package androidx.core.transition;

import android.transition.Transition;
import com.hisona.allive.CardPresenter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\n"}, m5569d2 = {"androidx/core/transition/TransitionKt$addListener$listener$1", "Landroid/transition/Transition$TransitionListener;", "onTransitionCancel", "", "transition", "Landroid/transition/Transition;", "onTransitionEnd", "onTransitionPause", "onTransitionResume", "onTransitionStart", "core-ktx_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = CardPresenter.CARD_HEIGHT)
@SourceDebugExtension({"SMAP\nTransition.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Transition.kt\nandroidx/core/transition/TransitionKt$addListener$listener$1\n*L\n1#1,76:1\n*E\n"})
/* loaded from: classes.dex */
public final class TransitionKt$addListener$listener$1 implements Transition.TransitionListener {

    /* renamed from: a */
    public final /* synthetic */ Function1 f3810a;

    /* renamed from: b */
    public final /* synthetic */ Function1 f3811b;

    /* renamed from: c */
    public final /* synthetic */ Function1 f3812c;

    /* renamed from: d */
    public final /* synthetic */ Function1 f3813d;

    /* renamed from: e */
    public final /* synthetic */ Function1 f3814e;

    public TransitionKt$addListener$listener$1(Function1<? super Transition, Unit> function1, Function1<? super Transition, Unit> function12, Function1<? super Transition, Unit> function13, Function1<? super Transition, Unit> function14, Function1<? super Transition, Unit> function15) {
        this.f3810a = function1;
        this.f3811b = function12;
        this.f3812c = function13;
        this.f3813d = function14;
        this.f3814e = function15;
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionCancel(@NotNull Transition transition) {
        this.f3813d.invoke(transition);
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionEnd(@NotNull Transition transition) {
        this.f3810a.invoke(transition);
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionPause(@NotNull Transition transition) {
        this.f3812c.invoke(transition);
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionResume(@NotNull Transition transition) {
        this.f3811b.invoke(transition);
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionStart(@NotNull Transition transition) {
        this.f3814e.invoke(transition);
    }
}
