package androidx.leanback.app;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.leanback.R;
import androidx.leanback.widget.SearchOrbView;
import androidx.leanback.widget.TitleHelper;
import androidx.leanback.widget.TitleViewAdapter;

/* loaded from: classes.dex */
public class BrandedSupportFragment extends Fragment {

    /* renamed from: e0 */
    public boolean f4782e0 = true;

    /* renamed from: f0 */
    public CharSequence f4783f0;

    /* renamed from: g0 */
    public Drawable f4784g0;

    /* renamed from: h0 */
    public View f4785h0;

    /* renamed from: i0 */
    public TitleViewAdapter f4786i0;

    /* renamed from: j0 */
    public SearchOrbView.Colors f4787j0;

    /* renamed from: k0 */
    public boolean f4788k0;

    /* renamed from: l0 */
    public View.OnClickListener f4789l0;

    /* renamed from: m0 */
    public TitleHelper f4790m0;

    @Nullable
    public Drawable getBadgeDrawable() {
        return this.f4784g0;
    }

    public int getSearchAffordanceColor() {
        return getSearchAffordanceColors().color;
    }

    @Nullable
    public SearchOrbView.Colors getSearchAffordanceColors() {
        if (this.f4788k0) {
            return this.f4787j0;
        }
        TitleViewAdapter titleViewAdapter = this.f4786i0;
        if (titleViewAdapter != null) {
            return titleViewAdapter.getSearchAffordanceColors();
        }
        throw new IllegalStateException("Fragment views not yet created");
    }

    @Nullable
    public CharSequence getTitle() {
        return this.f4783f0;
    }

    @Nullable
    public View getTitleView() {
        return this.f4785h0;
    }

    @Nullable
    public TitleViewAdapter getTitleViewAdapter() {
        return this.f4786i0;
    }

    public void installTitleView(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup, @Nullable Bundle bundle) {
        View onInflateTitleView = onInflateTitleView(layoutInflater, viewGroup, bundle);
        if (onInflateTitleView != null) {
            viewGroup.addView(onInflateTitleView);
            setTitleView(onInflateTitleView.findViewById(R.id.browse_title_group));
        } else {
            setTitleView(null);
        }
    }

    public final boolean isShowingTitle() {
        return this.f4782e0;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f4790m0 = null;
        this.f4785h0 = null;
        this.f4786i0 = null;
    }

    @NonNull
    public View onInflateTitleView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int i;
        TypedValue typedValue = new TypedValue();
        if (viewGroup != null && viewGroup.getContext().getTheme().resolveAttribute(R.attr.browseTitleViewLayout, typedValue, true)) {
            i = typedValue.resourceId;
        } else {
            i = R.layout.lb_browse_title;
        }
        return layoutInflater.inflate(i, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        TitleViewAdapter titleViewAdapter = this.f4786i0;
        if (titleViewAdapter != null) {
            titleViewAdapter.setAnimationEnabled(false);
        }
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        TitleViewAdapter titleViewAdapter = this.f4786i0;
        if (titleViewAdapter != null) {
            titleViewAdapter.setAnimationEnabled(true);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("titleShow", this.f4782e0);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.f4786i0 != null) {
            showTitle(this.f4782e0);
            this.f4786i0.setAnimationEnabled(true);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (bundle != null) {
            this.f4782e0 = bundle.getBoolean("titleShow");
        }
        View view2 = this.f4785h0;
        if (view2 != null && (view instanceof ViewGroup)) {
            TitleHelper titleHelper = new TitleHelper((ViewGroup) view, view2);
            this.f4790m0 = titleHelper;
            titleHelper.showTitle(this.f4782e0);
        }
    }

    public void setBadgeDrawable(@Nullable Drawable drawable) {
        if (this.f4784g0 != drawable) {
            this.f4784g0 = drawable;
            TitleViewAdapter titleViewAdapter = this.f4786i0;
            if (titleViewAdapter != null) {
                titleViewAdapter.setBadgeDrawable(drawable);
            }
        }
    }

    public void setOnSearchClickedListener(@Nullable View.OnClickListener onClickListener) {
        this.f4789l0 = onClickListener;
        TitleViewAdapter titleViewAdapter = this.f4786i0;
        if (titleViewAdapter != null) {
            titleViewAdapter.setOnSearchClickedListener(onClickListener);
        }
    }

    public void setSearchAffordanceColor(int i) {
        setSearchAffordanceColors(new SearchOrbView.Colors(i));
    }

    public void setSearchAffordanceColors(@NonNull SearchOrbView.Colors colors) {
        this.f4787j0 = colors;
        this.f4788k0 = true;
        TitleViewAdapter titleViewAdapter = this.f4786i0;
        if (titleViewAdapter != null) {
            titleViewAdapter.setSearchAffordanceColors(colors);
        }
    }

    public void setTitle(@Nullable CharSequence charSequence) {
        this.f4783f0 = charSequence;
        TitleViewAdapter titleViewAdapter = this.f4786i0;
        if (titleViewAdapter != null) {
            titleViewAdapter.setTitle(charSequence);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setTitleView(@Nullable View view) {
        this.f4785h0 = view;
        if (view == 0) {
            this.f4786i0 = null;
            this.f4790m0 = null;
            return;
        }
        TitleViewAdapter titleViewAdapter = ((TitleViewAdapter.Provider) view).getTitleViewAdapter();
        this.f4786i0 = titleViewAdapter;
        titleViewAdapter.setTitle(this.f4783f0);
        this.f4786i0.setBadgeDrawable(this.f4784g0);
        if (this.f4788k0) {
            this.f4786i0.setSearchAffordanceColors(this.f4787j0);
        }
        View.OnClickListener onClickListener = this.f4789l0;
        if (onClickListener != null) {
            setOnSearchClickedListener(onClickListener);
        }
        if (getView() instanceof ViewGroup) {
            this.f4790m0 = new TitleHelper((ViewGroup) getView(), this.f4785h0);
        }
    }

    public void showTitle(boolean z) {
        if (z == this.f4782e0) {
            return;
        }
        this.f4782e0 = z;
        TitleHelper titleHelper = this.f4790m0;
        if (titleHelper != null) {
            titleHelper.showTitle(z);
        }
    }

    public void showTitle(int i) {
        TitleViewAdapter titleViewAdapter = this.f4786i0;
        if (titleViewAdapter != null) {
            titleViewAdapter.updateComponentsVisibility(i);
        }
        showTitle(true);
    }
}
