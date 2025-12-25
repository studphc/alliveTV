package androidx.leanback.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Fragment;
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
import androidx.leanback.R;
import androidx.leanback.widget.PagingIndicator;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import p000.ViewOnClickListenerC1109d4;
import p000.a12;
import p000.b12;
import p000.c12;
import p000.d12;
import p000.ou0;
import p000.q20;

@Deprecated
/* loaded from: classes.dex */
public abstract class OnboardingFragment extends Fragment {

    /* renamed from: C */
    public static int f5039C;

    /* renamed from: D */
    public static final DecelerateInterpolator f5040D = new DecelerateInterpolator();

    /* renamed from: E */
    public static final AccelerateInterpolator f5041E = new AccelerateInterpolator();

    /* renamed from: a */
    public ContextThemeWrapper f5044a;

    /* renamed from: b */
    public PagingIndicator f5045b;

    /* renamed from: c */
    public View f5046c;

    /* renamed from: d */
    public ImageView f5047d;

    /* renamed from: e */
    public ImageView f5048e;

    /* renamed from: f */
    public int f5049f;

    /* renamed from: g */
    public TextView f5050g;

    /* renamed from: h */
    public TextView f5051h;

    /* renamed from: i */
    public boolean f5052i;

    /* renamed from: j */
    public int f5053j;

    /* renamed from: k */
    public boolean f5054k;

    /* renamed from: l */
    public boolean f5055l;

    /* renamed from: m */
    public int f5056m;

    /* renamed from: o */
    public boolean f5058o;

    /* renamed from: q */
    public boolean f5060q;

    /* renamed from: s */
    public boolean f5062s;

    /* renamed from: u */
    public boolean f5064u;

    /* renamed from: w */
    public boolean f5066w;

    /* renamed from: x */
    public CharSequence f5067x;

    /* renamed from: y */
    public boolean f5068y;

    /* renamed from: z */
    public AnimatorSet f5069z;

    /* renamed from: n */
    public int f5057n = 0;

    /* renamed from: p */
    public int f5059p = 0;

    /* renamed from: r */
    public int f5061r = 0;

    /* renamed from: t */
    public int f5063t = 0;

    /* renamed from: v */
    public int f5065v = 0;

    /* renamed from: A */
    public final ViewOnClickListenerC1109d4 f5042A = new ViewOnClickListenerC1109d4(4, this);

    /* renamed from: B */
    public final q20 f5043B = new q20(2, this);

    /* renamed from: a */
    public final AnimatorSet m1312a(View view, boolean z, int i, long j) {
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
                i3 = f5039C;
            } else {
                i3 = -f5039C;
            }
            ofFloat2 = ObjectAnimator.ofFloat(view, (Property<View, Float>) property, i3, RecyclerView.f7068F0);
            DecelerateInterpolator decelerateInterpolator = f5040D;
            ofFloat.setInterpolator(decelerateInterpolator);
            ofFloat2.setInterpolator(decelerateInterpolator);
        } else {
            ofFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.ALPHA, 1.0f, RecyclerView.f7068F0);
            Property property2 = View.TRANSLATION_X;
            if (z3) {
                i2 = f5039C;
            } else {
                i2 = -f5039C;
            }
            ofFloat2 = ObjectAnimator.ofFloat(view, (Property<View, Float>) property2, RecyclerView.f7068F0, i2);
            AccelerateInterpolator accelerateInterpolator = f5041E;
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

    /* renamed from: b */
    public final void m1313b(int i) {
        AnimatorSet m1312a;
        AnimatorSet animatorSet = this.f5069z;
        if (animatorSet != null) {
            animatorSet.end();
        }
        this.f5045b.onPageSelected(this.f5056m, true);
        ArrayList arrayList = new ArrayList();
        if (i < getCurrentPageIndex()) {
            arrayList.add(m1312a(this.f5050g, false, GravityCompat.START, 0L));
            m1312a = m1312a(this.f5051h, false, GravityCompat.START, 33L);
            arrayList.add(m1312a);
            arrayList.add(m1312a(this.f5050g, true, GravityCompat.END, 500L));
            arrayList.add(m1312a(this.f5051h, true, GravityCompat.END, 533L));
        } else {
            arrayList.add(m1312a(this.f5050g, false, GravityCompat.END, 0L));
            m1312a = m1312a(this.f5051h, false, GravityCompat.END, 33L);
            arrayList.add(m1312a);
            arrayList.add(m1312a(this.f5050g, true, GravityCompat.START, 500L));
            arrayList.add(m1312a(this.f5051h, true, GravityCompat.START, 533L));
        }
        m1312a.addListener(new d12(getCurrentPageIndex(), 0, this));
        Context m6729a = ou0.m6729a(this);
        if (getCurrentPageIndex() == getPageCount() - 1) {
            this.f5046c.setVisibility(0);
            Animator loadAnimator = AnimatorInflater.loadAnimator(m6729a, R.animator.lb_onboarding_page_indicator_fade_out);
            loadAnimator.setTarget(this.f5045b);
            loadAnimator.addListener(new c12(1, this));
            arrayList.add(loadAnimator);
            Animator loadAnimator2 = AnimatorInflater.loadAnimator(m6729a, R.animator.lb_onboarding_start_button_fade_in);
            loadAnimator2.setTarget(this.f5046c);
            arrayList.add(loadAnimator2);
        } else if (i == getPageCount() - 1) {
            this.f5045b.setVisibility(0);
            Animator loadAnimator3 = AnimatorInflater.loadAnimator(m6729a, R.animator.lb_onboarding_page_indicator_fade_in);
            loadAnimator3.setTarget(this.f5045b);
            arrayList.add(loadAnimator3);
            Animator loadAnimator4 = AnimatorInflater.loadAnimator(m6729a, R.animator.lb_onboarding_start_button_fade_out);
            loadAnimator4.setTarget(this.f5046c);
            loadAnimator4.addListener(new c12(2, this));
            arrayList.add(loadAnimator4);
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.f5069z = animatorSet2;
        animatorSet2.playTogether(arrayList);
        this.f5069z.start();
        onPageChanged(this.f5056m, i);
    }

    /* renamed from: c */
    public final boolean m1314c() {
        Animator animator;
        Context m6729a = ou0.m6729a(this);
        if (m6729a == null) {
            return false;
        }
        if (this.f5053j != 0) {
            this.f5047d.setVisibility(0);
            this.f5047d.setImageResource(this.f5053j);
            Animator loadAnimator = AnimatorInflater.loadAnimator(m6729a, R.animator.lb_onboarding_logo_enter);
            Animator loadAnimator2 = AnimatorInflater.loadAnimator(m6729a, R.animator.lb_onboarding_logo_exit);
            loadAnimator2.setStartDelay(1333L);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playSequentially(loadAnimator, loadAnimator2);
            animatorSet.setTarget(this.f5047d);
            animator = animatorSet;
        } else {
            animator = onCreateLogoAnimation();
        }
        if (animator == null) {
            return false;
        }
        animator.addListener(new b12(this, m6729a, 0));
        animator.start();
        return true;
    }

    @ColorInt
    public final int getArrowBackgroundColor() {
        return this.f5065v;
    }

    @ColorInt
    public final int getArrowColor() {
        return this.f5063t;
    }

    public final int getCurrentPageIndex() {
        return this.f5056m;
    }

    @ColorInt
    public final int getDescriptionViewTextColor() {
        return this.f5059p;
    }

    @ColorInt
    public final int getDotBackgroundColor() {
        return this.f5061r;
    }

    public final int getIconResourceId() {
        return this.f5049f;
    }

    public final int getLogoResourceId() {
        return this.f5053j;
    }

    public abstract int getPageCount();

    @Nullable
    public abstract CharSequence getPageDescription(int i);

    @Nullable
    public abstract CharSequence getPageTitle(int i);

    @Nullable
    public final CharSequence getStartButtonText() {
        return this.f5067x;
    }

    @ColorInt
    public final int getTitleViewTextColor() {
        return this.f5057n;
    }

    public final boolean isLogoAnimationFinished() {
        return this.f5054k;
    }

    public void moveToNextPage() {
        if (this.f5054k && this.f5056m < getPageCount() - 1) {
            int i = this.f5056m;
            this.f5056m = i + 1;
            m1313b(i);
        }
    }

    public void moveToPreviousPage() {
        int i;
        if (this.f5054k && (i = this.f5056m) > 0) {
            this.f5056m = i - 1;
            m1313b(i);
        }
    }

    @Nullable
    public abstract View onCreateBackgroundView(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup);

    @Nullable
    public abstract View onCreateContentView(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup);

    @NonNull
    public Animator onCreateDescriptionAnimator() {
        return AnimatorInflater.loadAnimator(ou0.m6729a(this), R.animator.lb_onboarding_description_enter);
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
        return AnimatorInflater.loadAnimator(ou0.m6729a(this), R.animator.lb_onboarding_title_enter);
    }

    @Override // android.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        Context m6729a = ou0.m6729a(this);
        int onProvideTheme = onProvideTheme();
        boolean z = true;
        if (onProvideTheme == -1) {
            int i = R.attr.onboardingTheme;
            TypedValue typedValue = new TypedValue();
            if (m6729a.getTheme().resolveAttribute(i, typedValue, true)) {
                this.f5044a = new ContextThemeWrapper(m6729a, typedValue.resourceId);
            }
        } else {
            this.f5044a = new ContextThemeWrapper(m6729a, onProvideTheme);
        }
        ContextThemeWrapper contextThemeWrapper = this.f5044a;
        if (contextThemeWrapper != null) {
            layoutInflater = layoutInflater.cloneInContext(contextThemeWrapper);
        }
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.lb_onboarding_fragment, viewGroup, false);
        if (getResources().getConfiguration().getLayoutDirection() != 0) {
            z = false;
        }
        this.f5052i = z;
        PagingIndicator pagingIndicator = (PagingIndicator) viewGroup2.findViewById(R.id.page_indicator);
        this.f5045b = pagingIndicator;
        ViewOnClickListenerC1109d4 viewOnClickListenerC1109d4 = this.f5042A;
        pagingIndicator.setOnClickListener(viewOnClickListenerC1109d4);
        PagingIndicator pagingIndicator2 = this.f5045b;
        q20 q20Var = this.f5043B;
        pagingIndicator2.setOnKeyListener(q20Var);
        View findViewById = viewGroup2.findViewById(R.id.button_start);
        this.f5046c = findViewById;
        findViewById.setOnClickListener(viewOnClickListenerC1109d4);
        this.f5046c.setOnKeyListener(q20Var);
        this.f5048e = (ImageView) viewGroup2.findViewById(R.id.main_icon);
        this.f5047d = (ImageView) viewGroup2.findViewById(R.id.logo);
        this.f5050g = (TextView) viewGroup2.findViewById(R.id.title);
        this.f5051h = (TextView) viewGroup2.findViewById(R.id.description);
        if (this.f5058o) {
            this.f5050g.setTextColor(this.f5057n);
        }
        if (this.f5060q) {
            this.f5051h.setTextColor(this.f5059p);
        }
        if (this.f5062s) {
            this.f5045b.setDotBackgroundColor(this.f5061r);
        }
        if (this.f5064u) {
            this.f5045b.setArrowColor(this.f5063t);
        }
        if (this.f5066w) {
            this.f5045b.setDotBackgroundColor(this.f5065v);
        }
        if (this.f5068y) {
            ((Button) this.f5046c).setText(this.f5067x);
        }
        Context m6729a2 = ou0.m6729a(this);
        if (f5039C == 0) {
            f5039C = (int) (m6729a2.getResources().getDisplayMetrics().scaledDensity * 60.0f);
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

    @Override // android.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("leanback.onboarding.current_page_index", this.f5056m);
        bundle.putBoolean("leanback.onboarding.logo_animation_finished", this.f5054k);
        bundle.putBoolean("leanback.onboarding.enter_animation_finished", this.f5055l);
    }

    @Override // android.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (bundle == null) {
            this.f5056m = 0;
            this.f5054k = false;
            this.f5055l = false;
            this.f5045b.onPageSelected(0, false);
            view.getViewTreeObserver().addOnPreDrawListener(new a12(0, this));
            return;
        }
        this.f5056m = bundle.getInt("leanback.onboarding.current_page_index");
        this.f5054k = bundle.getBoolean("leanback.onboarding.logo_animation_finished");
        this.f5055l = bundle.getBoolean("leanback.onboarding.enter_animation_finished");
        if (!this.f5054k) {
            if (!m1314c()) {
                this.f5054k = true;
                onLogoAnimationFinished();
                return;
            }
            return;
        }
        onLogoAnimationFinished();
    }

    public void setArrowBackgroundColor(@ColorInt int i) {
        this.f5065v = i;
        this.f5066w = true;
        PagingIndicator pagingIndicator = this.f5045b;
        if (pagingIndicator != null) {
            pagingIndicator.setArrowBackgroundColor(i);
        }
    }

    public void setArrowColor(@ColorInt int i) {
        this.f5063t = i;
        this.f5064u = true;
        PagingIndicator pagingIndicator = this.f5045b;
        if (pagingIndicator != null) {
            pagingIndicator.setArrowColor(i);
        }
    }

    public void setDescriptionViewTextColor(@ColorInt int i) {
        this.f5059p = i;
        this.f5060q = true;
        TextView textView = this.f5051h;
        if (textView != null) {
            textView.setTextColor(i);
        }
    }

    public void setDotBackgroundColor(@ColorInt int i) {
        this.f5061r = i;
        this.f5062s = true;
        PagingIndicator pagingIndicator = this.f5045b;
        if (pagingIndicator != null) {
            pagingIndicator.setDotBackgroundColor(i);
        }
    }

    public final void setIconResouceId(int i) {
        this.f5049f = i;
        ImageView imageView = this.f5048e;
        if (imageView != null) {
            imageView.setImageResource(i);
            this.f5048e.setVisibility(0);
        }
    }

    public final void setLogoResourceId(int i) {
        this.f5053j = i;
    }

    public void setStartButtonText(@Nullable CharSequence charSequence) {
        this.f5067x = charSequence;
        this.f5068y = true;
        View view = this.f5046c;
        if (view != null) {
            ((Button) view).setText(charSequence);
        }
    }

    public void setTitleViewTextColor(@ColorInt int i) {
        this.f5057n = i;
        this.f5058o = true;
        TextView textView = this.f5050g;
        if (textView != null) {
            textView.setTextColor(i);
        }
    }

    public final void startEnterAnimation(boolean z) {
        Object obj;
        Context m6729a = ou0.m6729a(this);
        if (m6729a == null) {
            return;
        }
        this.f5047d.setVisibility(8);
        int i = this.f5049f;
        if (i != 0) {
            this.f5048e.setImageResource(i);
            this.f5048e.setVisibility(0);
        }
        View view = getView();
        LayoutInflater from = LayoutInflater.from(ou0.m6729a(this));
        ContextThemeWrapper contextThemeWrapper = this.f5044a;
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
            this.f5045b.setPageCount(getPageCount());
            this.f5045b.onPageSelected(this.f5056m, false);
        }
        if (this.f5056m == getPageCount() - 1) {
            this.f5046c.setVisibility(0);
        } else {
            this.f5045b.setVisibility(0);
        }
        this.f5050g.setText(getPageTitle(this.f5056m));
        this.f5051h.setText(getPageDescription(this.f5056m));
        if (this.f5055l && !z) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Animator loadAnimator = AnimatorInflater.loadAnimator(m6729a, R.animator.lb_onboarding_page_indicator_enter);
        if (getPageCount() <= 1) {
            obj = this.f5046c;
        } else {
            obj = this.f5045b;
        }
        loadAnimator.setTarget(obj);
        arrayList.add(loadAnimator);
        Animator onCreateTitleAnimator = onCreateTitleAnimator();
        if (onCreateTitleAnimator != null) {
            onCreateTitleAnimator.setTarget(this.f5050g);
            arrayList.add(onCreateTitleAnimator);
        }
        Animator onCreateDescriptionAnimator = onCreateDescriptionAnimator();
        if (onCreateDescriptionAnimator != null) {
            onCreateDescriptionAnimator.setTarget(this.f5051h);
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
        this.f5069z = animatorSet;
        animatorSet.playTogether(arrayList);
        this.f5069z.start();
        this.f5069z.addListener(new c12(0, this));
        getView().requestFocus();
    }
}
