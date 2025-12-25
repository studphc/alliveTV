package androidx.leanback.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.util.Property;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.leanback.R;
import androidx.leanback.widget.PagingIndicator;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import p000.ViewOnClickListenerC1109d4;
import p000.a12;
import p000.b12;
import p000.d12;
import p000.e12;
import p000.q20;

/* loaded from: classes.dex */
public abstract class OnboardingSupportFragment extends Fragment {

    /* renamed from: G0 */
    public static int f5070G0;

    /* renamed from: H0 */
    public static final DecelerateInterpolator f5071H0 = new DecelerateInterpolator();

    /* renamed from: I0 */
    public static final AccelerateInterpolator f5072I0 = new AccelerateInterpolator();

    /* renamed from: A0 */
    public boolean f5073A0;

    /* renamed from: B0 */
    public CharSequence f5074B0;

    /* renamed from: C0 */
    public boolean f5075C0;

    /* renamed from: D0 */
    public AnimatorSet f5076D0;

    /* renamed from: e0 */
    public ContextThemeWrapper f5079e0;

    /* renamed from: f0 */
    public PagingIndicator f5080f0;

    /* renamed from: g0 */
    public View f5081g0;

    /* renamed from: h0 */
    public ImageView f5082h0;

    /* renamed from: i0 */
    public ImageView f5083i0;

    /* renamed from: j0 */
    public int f5084j0;

    /* renamed from: k0 */
    public TextView f5085k0;

    /* renamed from: l0 */
    public TextView f5086l0;

    /* renamed from: m0 */
    public boolean f5087m0;

    /* renamed from: n0 */
    public int f5088n0;

    /* renamed from: o0 */
    public boolean f5089o0;

    /* renamed from: p0 */
    public boolean f5090p0;

    /* renamed from: q0 */
    public int f5091q0;

    /* renamed from: s0 */
    public boolean f5093s0;

    /* renamed from: u0 */
    public boolean f5095u0;

    /* renamed from: w0 */
    public boolean f5097w0;

    /* renamed from: y0 */
    public boolean f5099y0;

    /* renamed from: r0 */
    public int f5092r0 = 0;

    /* renamed from: t0 */
    public int f5094t0 = 0;

    /* renamed from: v0 */
    public int f5096v0 = 0;

    /* renamed from: x0 */
    public int f5098x0 = 0;

    /* renamed from: z0 */
    public int f5100z0 = 0;

    /* renamed from: E0 */
    public final ViewOnClickListenerC1109d4 f5077E0 = new ViewOnClickListenerC1109d4(5, this);

    /* renamed from: F0 */
    public final q20 f5078F0 = new q20(3, this);

    @ColorInt
    public final int getArrowBackgroundColor() {
        return this.f5100z0;
    }

    @ColorInt
    public final int getArrowColor() {
        return this.f5098x0;
    }

    public final int getCurrentPageIndex() {
        return this.f5091q0;
    }

    @ColorInt
    public final int getDescriptionViewTextColor() {
        return this.f5094t0;
    }

    @ColorInt
    public final int getDotBackgroundColor() {
        return this.f5096v0;
    }

    public final int getIconResourceId() {
        return this.f5084j0;
    }

    public final int getLogoResourceId() {
        return this.f5088n0;
    }

    public abstract int getPageCount();

    @Nullable
    public abstract CharSequence getPageDescription(int i);

    @Nullable
    public abstract CharSequence getPageTitle(int i);

    @Nullable
    public final CharSequence getStartButtonText() {
        return this.f5074B0;
    }

    @ColorInt
    public final int getTitleViewTextColor() {
        return this.f5092r0;
    }

    public final boolean isLogoAnimationFinished() {
        return this.f5089o0;
    }

    /* renamed from: l */
    public final AnimatorSet m1315l(View view, boolean z, int i, long j) {
        boolean z2;
        boolean z3;
        ObjectAnimator ofFloat;
        int i2;
        ObjectAnimator ofFloat2;
        int i3;
        if (getView().getLayoutDirection() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if ((z2 && i == 8388613) || ((!z2 && i == 8388611) || i == 5)) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z) {
            ofFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.ALPHA, RecyclerView.f7068F0, 1.0f);
            Property property = View.TRANSLATION_X;
            if (z3) {
                i3 = f5070G0;
            } else {
                i3 = -f5070G0;
            }
            ofFloat2 = ObjectAnimator.ofFloat(view, (Property<View, Float>) property, i3, RecyclerView.f7068F0);
            DecelerateInterpolator decelerateInterpolator = f5071H0;
            ofFloat.setInterpolator(decelerateInterpolator);
            ofFloat2.setInterpolator(decelerateInterpolator);
        } else {
            ofFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.ALPHA, 1.0f, RecyclerView.f7068F0);
            Property property2 = View.TRANSLATION_X;
            if (z3) {
                i2 = f5070G0;
            } else {
                i2 = -f5070G0;
            }
            ofFloat2 = ObjectAnimator.ofFloat(view, (Property<View, Float>) property2, RecyclerView.f7068F0, i2);
            AccelerateInterpolator accelerateInterpolator = f5072I0;
            ofFloat.setInterpolator(accelerateInterpolator);
            ofFloat2.setInterpolator(accelerateInterpolator);
        }
        ofFloat.setDuration(417L);
        ofFloat.setTarget(view);
        ofFloat2.setDuration(417L);
        ofFloat2.setTarget(view);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2);
        if (j > 0) {
            animatorSet.setStartDelay(j);
        }
        return animatorSet;
    }

    /* renamed from: m */
    public final void m1316m(int i) {
        AnimatorSet m1315l;
        AnimatorSet animatorSet = this.f5076D0;
        if (animatorSet != null) {
            animatorSet.end();
        }
        this.f5080f0.onPageSelected(this.f5091q0, true);
        ArrayList arrayList = new ArrayList();
        if (i < getCurrentPageIndex()) {
            arrayList.add(m1315l(this.f5085k0, false, GravityCompat.START, 0L));
            m1315l = m1315l(this.f5086l0, false, GravityCompat.START, 33L);
            arrayList.add(m1315l);
            arrayList.add(m1315l(this.f5085k0, true, GravityCompat.END, 500L));
            arrayList.add(m1315l(this.f5086l0, true, GravityCompat.END, 533L));
        } else {
            arrayList.add(m1315l(this.f5085k0, false, GravityCompat.END, 0L));
            m1315l = m1315l(this.f5086l0, false, GravityCompat.END, 33L);
            arrayList.add(m1315l);
            arrayList.add(m1315l(this.f5085k0, true, GravityCompat.START, 500L));
            arrayList.add(m1315l(this.f5086l0, true, GravityCompat.START, 533L));
        }
        m1315l.addListener(new d12(getCurrentPageIndex(), 1, this));
        Context context = getContext();
        if (getCurrentPageIndex() == getPageCount() - 1) {
            this.f5081g0.setVisibility(0);
            Animator loadAnimator = AnimatorInflater.loadAnimator(context, R.animator.lb_onboarding_page_indicator_fade_out);
            loadAnimator.setTarget(this.f5080f0);
            loadAnimator.addListener(new e12(this, 1));
            arrayList.add(loadAnimator);
            Animator loadAnimator2 = AnimatorInflater.loadAnimator(context, R.animator.lb_onboarding_start_button_fade_in);
            loadAnimator2.setTarget(this.f5081g0);
            arrayList.add(loadAnimator2);
        } else if (i == getPageCount() - 1) {
            this.f5080f0.setVisibility(0);
            Animator loadAnimator3 = AnimatorInflater.loadAnimator(context, R.animator.lb_onboarding_page_indicator_fade_in);
            loadAnimator3.setTarget(this.f5080f0);
            arrayList.add(loadAnimator3);
            Animator loadAnimator4 = AnimatorInflater.loadAnimator(context, R.animator.lb_onboarding_start_button_fade_out);
            loadAnimator4.setTarget(this.f5081g0);
            loadAnimator4.addListener(new e12(this, 2));
            arrayList.add(loadAnimator4);
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.f5076D0 = animatorSet2;
        animatorSet2.playTogether(arrayList);
        this.f5076D0.start();
        onPageChanged(this.f5091q0, i);
    }

    public void moveToNextPage() {
        if (this.f5089o0 && this.f5091q0 < getPageCount() - 1) {
            int i = this.f5091q0;
            this.f5091q0 = i + 1;
            m1316m(i);
        }
    }

    public void moveToPreviousPage() {
        int i;
        if (this.f5089o0 && (i = this.f5091q0) > 0) {
            this.f5091q0 = i - 1;
            m1316m(i);
        }
    }

    /* renamed from: n */
    public final boolean m1317n() {
        Animator animator;
        Context context = getContext();
        if (context == null) {
            return false;
        }
        if (this.f5088n0 != 0) {
            this.f5082h0.setVisibility(0);
            this.f5082h0.setImageResource(this.f5088n0);
            Animator loadAnimator = AnimatorInflater.loadAnimator(context, R.animator.lb_onboarding_logo_enter);
            Animator loadAnimator2 = AnimatorInflater.loadAnimator(context, R.animator.lb_onboarding_logo_exit);
            loadAnimator2.setStartDelay(1333L);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playSequentially(loadAnimator, loadAnimator2);
            animatorSet.setTarget(this.f5082h0);
            animator = animatorSet;
        } else {
            animator = onCreateLogoAnimation();
        }
        if (animator == null) {
            return false;
        }
        animator.addListener(new b12(this, context, 1));
        animator.start();
        return true;
    }

    @Nullable
    public abstract View onCreateBackgroundView(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup);

    @Nullable
    public abstract View onCreateContentView(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup);

    @NonNull
    public Animator onCreateDescriptionAnimator() {
        return AnimatorInflater.loadAnimator(getContext(), R.animator.lb_onboarding_description_enter);
    }

    @Nullable
    public Animator onCreateEnterAnimation() {
        return null;
    }

    @Nullable
    public abstract View onCreateForegroundView(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup);

    @Nullable
    public Animator onCreateLogoAnimation() {
        return null;
    }

    @NonNull
    public Animator onCreateTitleAnimator() {
        return AnimatorInflater.loadAnimator(getContext(), R.animator.lb_onboarding_title_enter);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Context context = getContext();
        int onProvideTheme = onProvideTheme();
        boolean z = true;
        if (onProvideTheme == -1) {
            int i = R.attr.onboardingTheme;
            TypedValue typedValue = new TypedValue();
            if (context.getTheme().resolveAttribute(i, typedValue, true)) {
                this.f5079e0 = new ContextThemeWrapper(context, typedValue.resourceId);
            }
        } else {
            this.f5079e0 = new ContextThemeWrapper(context, onProvideTheme);
        }
        ContextThemeWrapper contextThemeWrapper = this.f5079e0;
        if (contextThemeWrapper != null) {
            layoutInflater = layoutInflater.cloneInContext(contextThemeWrapper);
        }
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.lb_onboarding_fragment, viewGroup, false);
        if (getResources().getConfiguration().getLayoutDirection() != 0) {
            z = false;
        }
        this.f5087m0 = z;
        PagingIndicator pagingIndicator = (PagingIndicator) viewGroup2.findViewById(R.id.page_indicator);
        this.f5080f0 = pagingIndicator;
        ViewOnClickListenerC1109d4 viewOnClickListenerC1109d4 = this.f5077E0;
        pagingIndicator.setOnClickListener(viewOnClickListenerC1109d4);
        PagingIndicator pagingIndicator2 = this.f5080f0;
        q20 q20Var = this.f5078F0;
        pagingIndicator2.setOnKeyListener(q20Var);
        View findViewById = viewGroup2.findViewById(R.id.button_start);
        this.f5081g0 = findViewById;
        findViewById.setOnClickListener(viewOnClickListenerC1109d4);
        this.f5081g0.setOnKeyListener(q20Var);
        this.f5083i0 = (ImageView) viewGroup2.findViewById(R.id.main_icon);
        this.f5082h0 = (ImageView) viewGroup2.findViewById(R.id.logo);
        this.f5085k0 = (TextView) viewGroup2.findViewById(R.id.title);
        this.f5086l0 = (TextView) viewGroup2.findViewById(R.id.description);
        if (this.f5093s0) {
            this.f5085k0.setTextColor(this.f5092r0);
        }
        if (this.f5095u0) {
            this.f5086l0.setTextColor(this.f5094t0);
        }
        if (this.f5097w0) {
            this.f5080f0.setDotBackgroundColor(this.f5096v0);
        }
        if (this.f5099y0) {
            this.f5080f0.setArrowColor(this.f5098x0);
        }
        if (this.f5073A0) {
            this.f5080f0.setDotBackgroundColor(this.f5100z0);
        }
        if (this.f5075C0) {
            ((Button) this.f5081g0).setText(this.f5074B0);
        }
        Context context2 = getContext();
        if (f5070G0 == 0) {
            f5070G0 = (int) (context2.getResources().getDisplayMetrics().scaledDensity * 60.0f);
        }
        viewGroup2.requestFocus();
        return viewGroup2;
    }

    public void onFinishFragment() {
    }

    public void onLogoAnimationFinished() {
        startEnterAnimation(false);
    }

    public void onPageChanged(int i, int i2) {
    }

    public int onProvideTheme() {
        return -1;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("leanback.onboarding.current_page_index", this.f5091q0);
        bundle.putBoolean("leanback.onboarding.logo_animation_finished", this.f5089o0);
        bundle.putBoolean("leanback.onboarding.enter_animation_finished", this.f5090p0);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (bundle == null) {
            this.f5091q0 = 0;
            this.f5089o0 = false;
            this.f5090p0 = false;
            this.f5080f0.onPageSelected(0, false);
            view.getViewTreeObserver().addOnPreDrawListener(new a12(1, this));
            return;
        }
        this.f5091q0 = bundle.getInt("leanback.onboarding.current_page_index");
        this.f5089o0 = bundle.getBoolean("leanback.onboarding.logo_animation_finished");
        this.f5090p0 = bundle.getBoolean("leanback.onboarding.enter_animation_finished");
        if (!this.f5089o0) {
            if (!m1317n()) {
                this.f5089o0 = true;
                onLogoAnimationFinished();
                return;
            }
            return;
        }
        onLogoAnimationFinished();
    }

    public void setArrowBackgroundColor(@ColorInt int i) {
        this.f5100z0 = i;
        this.f5073A0 = true;
        PagingIndicator pagingIndicator = this.f5080f0;
        if (pagingIndicator != null) {
            pagingIndicator.setArrowBackgroundColor(i);
        }
    }

    public void setArrowColor(@ColorInt int i) {
        this.f5098x0 = i;
        this.f5099y0 = true;
        PagingIndicator pagingIndicator = this.f5080f0;
        if (pagingIndicator != null) {
            pagingIndicator.setArrowColor(i);
        }
    }

    public void setDescriptionViewTextColor(@ColorInt int i) {
        this.f5094t0 = i;
        this.f5095u0 = true;
        TextView textView = this.f5086l0;
        if (textView != null) {
            textView.setTextColor(i);
        }
    }

    public void setDotBackgroundColor(@ColorInt int i) {
        this.f5096v0 = i;
        this.f5097w0 = true;
        PagingIndicator pagingIndicator = this.f5080f0;
        if (pagingIndicator != null) {
            pagingIndicator.setDotBackgroundColor(i);
        }
    }

    public final void setIconResouceId(int i) {
        this.f5084j0 = i;
        ImageView imageView = this.f5083i0;
        if (imageView != null) {
            imageView.setImageResource(i);
            this.f5083i0.setVisibility(0);
        }
    }

    public final void setLogoResourceId(int i) {
        this.f5088n0 = i;
    }

    public void setStartButtonText(@Nullable CharSequence charSequence) {
        this.f5074B0 = charSequence;
        this.f5075C0 = true;
        View view = this.f5081g0;
        if (view != null) {
            ((Button) view).setText(charSequence);
        }
    }

    public void setTitleViewTextColor(@ColorInt int i) {
        this.f5092r0 = i;
        this.f5093s0 = true;
        TextView textView = this.f5085k0;
        if (textView != null) {
            textView.setTextColor(i);
        }
    }

    public final void startEnterAnimation(boolean z) {
        Object obj;
        Context context = getContext();
        if (context == null) {
            return;
        }
        this.f5082h0.setVisibility(8);
        int i = this.f5084j0;
        if (i != 0) {
            this.f5083i0.setImageResource(i);
            this.f5083i0.setVisibility(0);
        }
        View view = getView();
        LayoutInflater from = LayoutInflater.from(getContext());
        ContextThemeWrapper contextThemeWrapper = this.f5079e0;
        if (contextThemeWrapper != null) {
            from = from.cloneInContext(contextThemeWrapper);
        }
        ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.background_container);
        View onCreateBackgroundView = onCreateBackgroundView(from, viewGroup);
        if (onCreateBackgroundView != null) {
            viewGroup.setVisibility(0);
            viewGroup.addView(onCreateBackgroundView);
        }
        int i2 = R.id.content_container;
        ViewGroup viewGroup2 = (ViewGroup) view.findViewById(i2);
        View onCreateContentView = onCreateContentView(from, viewGroup2);
        if (onCreateContentView != null) {
            viewGroup2.setVisibility(0);
            viewGroup2.addView(onCreateContentView);
        }
        ViewGroup viewGroup3 = (ViewGroup) view.findViewById(R.id.foreground_container);
        View onCreateForegroundView = onCreateForegroundView(from, viewGroup3);
        if (onCreateForegroundView != null) {
            viewGroup3.setVisibility(0);
            viewGroup3.addView(onCreateForegroundView);
        }
        view.findViewById(R.id.page_container).setVisibility(0);
        view.findViewById(i2).setVisibility(0);
        if (getPageCount() > 1) {
            this.f5080f0.setPageCount(getPageCount());
            this.f5080f0.onPageSelected(this.f5091q0, false);
        }
        if (this.f5091q0 == getPageCount() - 1) {
            this.f5081g0.setVisibility(0);
        } else {
            this.f5080f0.setVisibility(0);
        }
        this.f5085k0.setText(getPageTitle(this.f5091q0));
        this.f5086l0.setText(getPageDescription(this.f5091q0));
        if (this.f5090p0 && !z) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Animator loadAnimator = AnimatorInflater.loadAnimator(context, R.animator.lb_onboarding_page_indicator_enter);
        if (getPageCount() <= 1) {
            obj = this.f5081g0;
        } else {
            obj = this.f5080f0;
        }
        loadAnimator.setTarget(obj);
        arrayList.add(loadAnimator);
        Animator onCreateTitleAnimator = onCreateTitleAnimator();
        if (onCreateTitleAnimator != null) {
            onCreateTitleAnimator.setTarget(this.f5085k0);
            arrayList.add(onCreateTitleAnimator);
        }
        Animator onCreateDescriptionAnimator = onCreateDescriptionAnimator();
        if (onCreateDescriptionAnimator != null) {
            onCreateDescriptionAnimator.setTarget(this.f5086l0);
            arrayList.add(onCreateDescriptionAnimator);
        }
        Animator onCreateEnterAnimation = onCreateEnterAnimation();
        if (onCreateEnterAnimation != null) {
            arrayList.add(onCreateEnterAnimation);
        }
        if (arrayList.isEmpty()) {
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        this.f5076D0 = animatorSet;
        animatorSet.playTogether(arrayList);
        this.f5076D0.start();
        this.f5076D0.addListener(new e12(this, 0));
        getView().requestFocus();
    }
}
