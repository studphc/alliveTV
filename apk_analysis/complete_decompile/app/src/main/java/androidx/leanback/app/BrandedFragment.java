package androidx.leanback.app;

import android.app.Fragment;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.leanback.R;
import androidx.leanback.widget.SearchOrbView;
import androidx.leanback.widget.TitleHelper;
import androidx.leanback.widget.TitleViewAdapter;

@Deprecated
/* loaded from: classes.dex */
public class BrandedFragment extends Fragment {

    /* renamed from: a */
    public boolean f4773a = true;

    /* renamed from: b */
    public CharSequence f4774b;

    /* renamed from: c */
    public Drawable f4775c;

    /* renamed from: d */
    public View f4776d;

    /* renamed from: e */
    public TitleViewAdapter f4777e;

    /* renamed from: f */
    public SearchOrbView.Colors f4778f;

    /* renamed from: g */
    public boolean f4779g;

    /* renamed from: h */
    public View.OnClickListener f4780h;

    /* renamed from: i */
    public TitleHelper f4781i;

    @Nullable
    public Drawable getBadgeDrawable() {
        return this.f4775c;
    }

    public int getSearchAffordanceColor() {
        return getSearchAffordanceColors().color;
    }

    @Nullable
    public SearchOrbView.Colors getSearchAffordanceColors() {
        if (this.f4779g) {
            return this.f4778f;
        }
        TitleViewAdapter titleViewAdapter = this.f4777e;
        if (titleViewAdapter != null) {
            return titleViewAdapter.getSearchAffordanceColors();
        }
        throw new IllegalStateException("Fragment views not yet created");
    }

    @Nullable
    public CharSequence getTitle() {
        return this.f4774b;
    }

    @Nullable
    public View getTitleView() {
        return this.f4776d;
    }

    @Nullable
    public TitleViewAdapter getTitleViewAdapter() {
        return this.f4777e;
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
        return this.f4773a;
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f4781i = null;
        this.f4776d = null;
        this.f4777e = null;
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

    @Override // android.app.Fragment
    public void onPause() {
        TitleViewAdapter titleViewAdapter = this.f4777e;
        if (titleViewAdapter != null) {
            titleViewAdapter.setAnimationEnabled(false);
        }
        super.onPause();
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        TitleViewAdapter titleViewAdapter = this.f4777e;
        if (titleViewAdapter != null) {
            titleViewAdapter.setAnimationEnabled(true);
        }
    }

    @Override // android.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("titleShow", this.f4773a);
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.f4777e != null) {
            showTitle(this.f4773a);
            this.f4777e.setAnimationEnabled(true);
        }
    }

    @Override // android.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (bundle != null) {
            this.f4773a = bundle.getBoolean("titleShow");
        }
        View view2 = this.f4776d;
        if (view2 != null && (view instanceof ViewGroup)) {
            TitleHelper titleHelper = new TitleHelper((ViewGroup) view, view2);
            this.f4781i = titleHelper;
            titleHelper.showTitle(this.f4773a);
        }
    }

    public void setBadgeDrawable(@Nullable Drawable drawable) {
        if (this.f4775c != drawable) {
            this.f4775c = drawable;
            TitleViewAdapter titleViewAdapter = this.f4777e;
            if (titleViewAdapter != null) {
                titleViewAdapter.setBadgeDrawable(drawable);
            }
        }
    }

    public void setOnSearchClickedListener(@Nullable View.OnClickListener onClickListener) {
        this.f4780h = onClickListener;
        TitleViewAdapter titleViewAdapter = this.f4777e;
        if (titleViewAdapter != null) {
            titleViewAdapter.setOnSearchClickedListener(onClickListener);
        }
    }

    public void setSearchAffordanceColor(int i) {
        setSearchAffordanceColors(new SearchOrbView.Colors(i));
    }

    public void setSearchAffordanceColors(@NonNull SearchOrbView.Colors colors) {
        this.f4778f = colors;
        this.f4779g = true;
        TitleViewAdapter titleViewAdapter = this.f4777e;
        if (titleViewAdapter != null) {
            titleViewAdapter.setSearchAffordanceColors(colors);
        }
    }

    public void setTitle(@Nullable CharSequence charSequence) {
        this.f4774b = charSequence;
        TitleViewAdapter titleViewAdapter = this.f4777e;
        if (titleViewAdapter != null) {
            titleViewAdapter.setTitle(charSequence);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setTitleView(@Nullable View view) {
        this.f4776d = view;
        if (view == 0) {
            this.f4777e = null;
            this.f4781i = null;
            return;
        }
        TitleViewAdapter titleViewAdapter = ((TitleViewAdapter.Provider) view).getTitleViewAdapter();
        this.f4777e = titleViewAdapter;
        titleViewAdapter.setTitle(this.f4774b);
        this.f4777e.setBadgeDrawable(this.f4775c);
        if (this.f4779g) {
            this.f4777e.setSearchAffordanceColors(this.f4778f);
        }
        View.OnClickListener onClickListener = this.f4780h;
        if (onClickListener != null) {
            setOnSearchClickedListener(onClickListener);
        }
        if (getView() instanceof ViewGroup) {
            this.f4781i = new TitleHelper((ViewGroup) getView(), this.f4776d);
        }
    }

    public void showTitle(boolean z) {
        if (z == this.f4773a) {
            return;
        }
        this.f4773a = z;
        TitleHelper titleHelper = this.f4781i;
        if (titleHelper != null) {
            titleHelper.showTitle(z);
        }
    }

    public void showTitle(int i) {
        TitleViewAdapter titleViewAdapter = this.f4777e;
        if (titleViewAdapter != null) {
            titleViewAdapter.updateComponentsVisibility(i);
        }
        showTitle(true);
    }
}
